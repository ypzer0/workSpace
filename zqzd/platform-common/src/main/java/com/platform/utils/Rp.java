package com.platform.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * api 返回数据
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019年5月5日 下午1:59:27
 */
public class Rp extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    
    Map<String, Object> dataMap = new HashMap<String, Object>();
    public Rp() {
        put("code", 200);
        put("msg", "");
        put("success", true);
        put("data", dataMap);
    }

    public static Rp error() {
        return error(500, "未知异常，请联系管理员");
    }

    public static Rp error(String msg) {
        return error(500, msg);
    }

    public static Rp error(int code, String msg) {
        Rp r = new Rp();
        r.put("code", code);
        r.put("msg", msg);
        r.put("success", false);
        return r;
    }

    public static Rp ok(String msg) {
        Rp r = new Rp();
        r.put("msg", msg);
        return r;
    }

    public static Rp ok(Map<String, Object> map) {
        Rp r = new Rp();
        r.putAll(map);
        return r;
    }

    public static Rp ok() {
        return new Rp();
    }
    
    /**
     * put所有数据到data
     * @param maps
     * @return
     */
    public Rp putAllDt(Map<String, Object> maps) {
    	dataMap.putAll(maps);
        return this;
    }
    
    /**
     * put key 和 value 到dataMap
     * @param key
     * @param value
     * @return
     */
    public Rp putDt(String key, Object value) {
    	dataMap.put(key, value);
        return this;
    }
}
