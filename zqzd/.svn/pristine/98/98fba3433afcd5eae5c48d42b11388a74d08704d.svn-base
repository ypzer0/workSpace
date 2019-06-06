package com.platform.util;

import com.alibaba.fastjson.JSONObject;
import com.platform.entity.TokenVo;
import com.platform.entity.UserVo;
import com.platform.interceptor.AuthorizationInterceptor;
import com.platform.service.ApiUserService;
import com.platform.service.TokenService;
import com.platform.utils.R;

import org.apache.commons.collections.MapUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @author harmon
 * @ClassName: ApiBaseAction
 * @Description: 基础控制类
 * @date 2016年9月2日
 */
public class ApiBaseAction {
    protected Logger logger = Logger.getLogger(getClass());
    /**
     * 得到request对象
     */
    @Autowired
    protected HttpServletRequest request;
    /**
     * 得到response对象
     */
    @Autowired
    protected HttpServletResponse response;

    @Autowired
    protected TokenService tokenService;
    
    @Autowired
    private ApiUserService userService;

    /**
     * 参数绑定异常
     */
    @ExceptionHandler({BindException.class, MissingServletRequestParameterException.class, UnauthorizedException.class, TypeMismatchException.class})
    @ResponseBody
    public Map<String, Object> bindException(Exception e) {
        if (e instanceof BindException) {
            return toResponsObject(1, "参数绑定异常", e.getMessage());
        } else if (e instanceof UnauthorizedException) {
            return toResponsObject(1, "无访问权限", e.getMessage());
        }
        return toResponsObject(1, "处理异常", e.getMessage());
    }

    /**
     * @param requestCode
     * @param msg
     * @param data
     * @return Map<String,Object>
     * @throws
     * @Description:构建统一格式返回对象
     * @date 2016年9月2日
     * @author zhuliyun
     */
    public Map<String, Object> toResponsObject(int requestCode, String msg, Object data) {
//    	String ish5 = request.getHeader("X-Qzh-Hfive");
//    	if(ish5 != null && ish5 != "" && "1".equals(ish5)) {
    		return H5Response(requestCode == 0 ? 200 : 400, requestCode == 0, msg, data);
//    	}
//    	
//        Map<String, Object> obj = new HashMap<String, Object>();
//        obj.put("errno", requestCode);
//        obj.put("errmsg", msg);
//        if (data != null)
//            obj.put("data", data);
//        return obj;
    }


    public Map<String, Object> toRespons(R r) {
        Map<String, Object> rp = toResponsObject(MapUtils.getInteger(r, "code"), 
        		MapUtils.getString(r, "msg"), MapUtils.getObject(r, "data"));
        return rp;
    }
    
    public Map<String, Object> toResponsSuccess(Object data) {
        Map<String, Object> rp = toResponsObject(0, "执行成功", data);
        logger.info("response:" + rp);
        return rp;
    }

    public Map<String, Object> toResponsMsgSuccess(String msg) {
        return toResponsObject(0, msg, "");
    }

    public Map<String, Object> toResponsSuccessForSelect(Object data) {
        Map<String, Object> result = new HashMap<>(2);
        result.put("list", data);
        return toResponsObject(0, "执行成功", result);
    }

    public Map<String, Object> toResponsFail(String msg) {
        return toResponsObject(1, msg, null);
    }

    /**
     * initBinder 初始化绑定 <br>
     * 这里处理了3种类型<br>
     * 1、字符串自动 trim 去掉前后空格 <br>
     * 2、java.util.Date 转换为 "yyyy-MM-dd HH:mm:ss" 格式<br>
     * 3、java.sql.Date 转换为 "yyyy-MM-dd" 格式<br>
     * 4、java.util.Timestamps 时间转换
     *
     * @param binder  WebDataBinder 要注册的binder
     * @param request 前端请求
     */
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        // 字符串自动Trim
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
    }

    /**
     * 获取请求方IP
     *
     * @return 客户端Ip
     */
    public String getClientIp() {
        String xff = request.getHeader("x-forwarded-for");
        if (xff == null) {
            return "8.8.8.8";
        }
        int i = xff.indexOf(',');
        if(i != -1) {
        	xff = xff.substring(0, i);
        }
        
        i = xff.indexOf(':');
        if(i != -1) {
        	xff = xff.substring(0, i);
        }
        return xff;
    }

    public JSONObject getJsonRequest() {
        JSONObject result = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = request.getReader();) {
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
            result = JSONObject.parseObject(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 获取请求的用户Id
     *
     * @return 客户端Ip
     */
    public Long getUserId() {
        String token = request.getHeader(AuthorizationInterceptor.LOGIN_TOKEN_KEY);
        //查询token信息
        TokenVo tokenEntity = tokenService.queryByToken(token);
        if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
            return null;
        }
        return tokenEntity.getUserId();
    }
    
    /**
     * 获取登录用户
     * zy 2018-12-28
     * 
     * */
    public UserVo getLoginUser() {
    	Long userId = getUserId();
    	if(userId == null) return null;
    	return userService.queryObject(userId);
    }
    
    

    /**
     * @param requestCode
     * @param success
     * @param msg
     * @param data
     * @return Map<String,Object>
     * @throws
     * @Description:h5构建统一格式返回对象
     * @date 2018年12月27日
     * @author zy
     */
    public Map<String, Object> H5Response(int requestCode, Boolean success, String msg, Object data) {
        Map<String, Object> obj = new HashMap<String, Object>();
        obj.put("code", requestCode);
        obj.put("msg", msg);
        obj.put("success", success);
        obj.put("data", data);
        return obj;
    }
    

    public Map<String, Object> H5ResponseSuccess(Object data) {
        Map<String, Object> rp = H5Response(200, true, "执行成功", data);
        logger.info("h5response:" + rp);
        return rp;
    }

    public Map<String, Object> H5ResponseSuccessMsg(String msg) {
        return H5Response(200, true, msg, "");
    }

    public Map<String, Object> H5ResponseFail(String msg) {
        return H5Response(400, false, msg, null);
    }
    
    
}
