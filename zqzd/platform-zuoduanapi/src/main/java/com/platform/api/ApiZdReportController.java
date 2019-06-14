package com.platform.api;

import com.platform.annotation.IgnoreAuth;
import com.platform.oss.AliyunCloudStorageService;
import com.platform.oss.CloudStorageConfig;
import com.platform.service.SysConfigService;
import com.platform.utils.Constant;
import com.platform.utils.SpringContextUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.annotation.LoginUser;
import com.platform.entity.ZdReportVo;
import com.platform.entity.ZdUserVo;
import com.platform.service.ApiZdReportService;
import com.platform.util.ApiBaseAction;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author 张桐
 *
 */
@Api("卓断检查报告")
@RestController
@RequestMapping("/zdapi")
public class ApiZdReportController extends ApiBaseAction {

	@Autowired
	private ApiZdReportService apiZdReportService;

	@ApiOperation("检查报告列表接口")
	@PostMapping("/report/list")
	public Object reportList(@LoginUser ZdUserVo nowUser) {
		return apiZdReportService.reportList(nowUser);
	}

	
	@ApiOperation("检查报告查看接口")
	@PostMapping("/report/view")
	public Object reportView(@LoginUser ZdUserVo nowUser, @RequestBody ZdReportVo report) {
		return apiZdReportService.reportView(nowUser, report.getId());
	}

	@GetMapping("/report/download")
    @IgnoreAuth
	public Object reportDownLoad(HttpServletResponse response){
        InputStream inputStream=null;
        try {
            SysConfigService sysConfigService=(SysConfigService) SpringContextUtils.getBean("sysConfigService");
            //获取云存储配置信息
            CloudStorageConfig config = sysConfigService.getConfigObject(Constant.CLOUD_STORAGE_CONFIG_KEY, CloudStorageConfig.class);
            AliyunCloudStorageService storageService = new AliyunCloudStorageService(config);
            inputStream = storageService.downloadPDF("https://wsimg.qzhkj.cn/h5/goods/20190609/175200813d5df1.pdf");
            ServletOutputStream outputStream = response.getOutputStream();
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition:attachment;", " filename=test.pdf");
            response.setCharacterEncoding("utf-8");
            byte[] arr=new byte[1024];
            int len;
            response.reset();
            while ((len=inputStream.read(arr))!=-1){
               outputStream.write(arr,0,len);
            }
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        } finally {
            if(inputStream!=null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
	}

	

}
