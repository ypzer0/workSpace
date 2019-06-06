package com.platform.annotation;

import java.lang.annotation.*;

/**
 * 系统操作日志
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019年3月18日 上午10:19:56
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysOperLog {
	
    int flg() default 0;
    String value() default "操作日志";
    //是否记录参数值
    boolean remParaVal() default false;
    
}
