package com.platform.weixin;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import com.platform.utils.WeiXinUtil;

public class DingXingConfig extends WXPayConfig {

    private byte[] certData;
	private static final Integer plat = 1;
	
	public DingXingConfig() throws Exception {
//		String certPath = "/data/config/chidori/apiclient_cert.p12";
//	    File file = new File(certPath);
//	    InputStream certStream = new FileInputStream(file);
//	    this.certData = new byte[(int) file.length()];
//	    certStream.read(this.certData);
//	    certStream.close();
	}
    
	
	@Override
	String getAppID() {
		// TODO Auto-generated method stub
		return WeiXinUtil.getAppId(plat);
	}

	@Override
	String getMchID() {
		// TODO Auto-generated method stub
		return WeiXinUtil.getMchId(plat);
	}

	@Override
	String getKey() {
		// TODO Auto-generated method stub
		return WeiXinUtil.getPaySignKey(plat);
	}

	@Override
	InputStream getCertStream() {
		// TODO Auto-generated method stub
//		return new ByteArrayInputStream(this.certData);
		return null;
	}

	@Override
	IWXPayDomain getWXPayDomain() {
		// TODO Auto-generated method stub
		IWXPayDomain iwxPayDomain = new IWXPayDomain() {
            @Override
            public void report(String domain, long elapsedTimeMillis, Exception ex) {

            }
            @Override
            public DomainInfo getDomain(WXPayConfig config) {
                return new IWXPayDomain.DomainInfo(WXPayConstants.DOMAIN_API, true);
            }
        };
        return iwxPayDomain;
	}

}

