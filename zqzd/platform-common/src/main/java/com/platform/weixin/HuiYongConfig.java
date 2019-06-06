package com.platform.weixin;

import java.io.InputStream;

import com.platform.utils.WeiXinUtil;

public class HuiYongConfig extends WXPayConfig {

	private static final Integer plat = 2;
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
		return null;
	}

	@Override
	IWXPayDomain getWXPayDomain() {
		// TODO Auto-generated method stub
		return null;
	}

}
