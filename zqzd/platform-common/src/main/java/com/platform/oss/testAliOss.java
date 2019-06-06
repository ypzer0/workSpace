package com.platform.oss;

import java.io.File;

import com.aliyun.oss.OSSClient;

public class testAliOss {
	
    public static void main(String[] args) {
    	
//    	File file = new File("E:/笔记/框架/YunJian/YJ.App/yunjian/images/dz_fw4.jpg");
//    	String rt = OSSUploadUtil.uploadFile(file, "jpg");
//    	rt = "";
    	
    	// Endpoint以杭州为例，其它Region请按实际情况填写。
    	String endpoint = "http://oss-cn-shenzhen.aliyuncs.com";
    	// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    	String accessKeyId = "LTAI2jbCwa9br3Bh";
    	String accessKeySecret = "uq1cf5RTOgGfcS7rb50p2HZqpTFWRF";

    	// 创建OSSClient实例。
    	OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);
    	ossClient.doesObjectExist("", "");
    	// 上传文件。<yourLocalFile>由本地文件路径加文件名包括后缀组成，例如/users/local/myfile.txt。
    	ossClient.putObject("qzhws", "h5/2019-2-23/abc.jpg", new File("E:/笔记/框架/YunJian/YJ.App/yunjian/images/dz_fw4.jpg"));
    	
    	// 关闭OSSClient。
    	ossClient.shutdown();
    }
	
}
