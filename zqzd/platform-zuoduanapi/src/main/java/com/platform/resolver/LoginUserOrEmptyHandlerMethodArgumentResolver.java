package com.platform.resolver;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.platform.annotation.LoginUserOrEmpty;
import com.platform.entity.TokenVo;
import com.platform.entity.ZdUserVo;
import com.platform.interceptor.AuthorizationInterceptor;
import com.platform.service.ApiZdUserService;
import com.platform.service.TokenService;

/**
 * 有@LoginUser注解的方法参数，注入当前登录用户
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 22:02
 */
public class LoginUserOrEmptyHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    protected Logger logger = Logger.getLogger(getClass());
    private ApiZdUserService userService;
    @Autowired
    private TokenService tokenService;

    public void setUserService(ApiZdUserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(ZdUserVo.class) && parameter.hasParameterAnnotation(LoginUserOrEmpty.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
    	

    	logger.info("获取用户");
        //从header中获取token
        String token = request.getHeader(AuthorizationInterceptor.LOGIN_TOKEN_KEY);
        //如果header中不存在token，则从参数中获取token
        if (StringUtils.isBlank(token)) {
            token = request.getParameter(AuthorizationInterceptor.LOGIN_TOKEN_KEY);
        }

    	logger.info("获取token:" + token);

        //token为空
        if (StringUtils.isBlank(token)) {
        	return null;
        }

    	logger.info("查询token:" + token);
        //查询token信息
        TokenVo tokenEntity = tokenService.queryByToken(token);
        if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
            return null;
        }
    	logger.info("用户id:" + tokenEntity.getUserId());
    	//发布时取消
        //获取用户信息
    	return userService.queryObject(tokenEntity.getUserId());

    	//测试环境
    	
//    	UserVo user = userService.queryObject(4L);
//    	return user;
    }
}
