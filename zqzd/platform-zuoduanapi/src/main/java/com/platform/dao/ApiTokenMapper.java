package com.platform.dao;

import com.platform.entity.TokenVo;
import org.apache.ibatis.annotations.Param;

/**
 * 用户Token
 *
 * @author lipengjun
 * @email 939961241@qq.com
 * @date 2017-03-23 15:22:07
 */
public interface ApiTokenMapper extends BaseDao<TokenVo> {

    TokenVo queryByUserId(@Param("userId") Long userId);

    TokenVo queryByToken(@Param("token") String token);

}
