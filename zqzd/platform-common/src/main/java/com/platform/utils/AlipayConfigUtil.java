package com.platform.utils;

public class AlipayConfigUtil {

	/**
	 * 获取appid
	 * @param plat
	 * @return
	 */
	public static String getAppId(Integer plat) {
		if(plat == 1) {
			return ResourceUtil.getConfigByName("aldx.appid");
		}
		return ResourceUtil.getConfigByName("alhy.appid");
	}
	
	/**
	 * 获取key
	 * @param plat
	 * @return
	 */
	public static String getKey(Integer plat) {
		if(plat == 1) {
			return ResourceUtil.getConfigByName("aldx.key");
		}
		return ResourceUtil.getConfigByName("alhy.key");
	}
	
	/**
	 * 获取notifyurl
	 * @param plat
	 * @return
	 */
	public static String getNotifyurl(Integer plat) {
		if(plat == 1) {
			return ResourceUtil.getConfigByName("aldx.notifyurl");
		}
		return ResourceUtil.getConfigByName("alhy.notifyurl");
	}
	
	/**
	 * 获取returnurl
	 * @param plat
	 * @return
	 */
	public static String getReturnurl(Integer plat) {
		if(plat == 1) {
			return ResourceUtil.getConfigByName("aldx.returnurl");
		}
		return ResourceUtil.getConfigByName("alhy.returnurl");
	}
	
	/**
	 * 获取url
	 * @param plat
	 * @return
	 */
	public static String getUrl(Integer plat) {
		if(plat == 1) {
			return ResourceUtil.getConfigByName("aldx.url");
		}
		return ResourceUtil.getConfigByName("alhy.url");
	}
	
	/**
	 * 获取charset
	 * @param plat
	 * @return
	 */
	public static String getCharset(Integer plat) {
		if(plat == 1) {
			return ResourceUtil.getConfigByName("aldx.charset");
		}
		return ResourceUtil.getConfigByName("alhy.charset");
	}
	
	/**
	 * 获取format
	 * @param plat
	 * @return
	 */
	public static String getFormat(Integer plat) {
		if(plat == 1) {
			return ResourceUtil.getConfigByName("aldx.format");
		}
		return ResourceUtil.getConfigByName("alhy.format");
	}
	
	
	/**
	 * 获取pubkey
	 * @param plat
	 * @return
	 */
	public static String getPubkey(Integer plat) {
		if(plat == 1) {
			return ResourceUtil.getConfigByName("aldx.pubkey");
		}
		return ResourceUtil.getConfigByName("alhy.pubkey");
	}
	
	/**
	 * 获取signtype
	 * @param plat
	 * @return
	 */
	public static String getSigntype(Integer plat) {
		if(plat == 1) {
			return ResourceUtil.getConfigByName("aldx.signtype");
		}
		return ResourceUtil.getConfigByName("alhy.signtype");
	}
	
	/**
	 * 获取procode
	 * @param plat
	 * @return
	 */
	public static String getProcode(Integer plat) {
		if(plat == 1) {
			return ResourceUtil.getConfigByName("aldx.procode");
		}
		return ResourceUtil.getConfigByName("alhy.procode");
	}
	
	
}
