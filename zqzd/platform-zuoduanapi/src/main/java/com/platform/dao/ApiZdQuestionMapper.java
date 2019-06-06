package com.platform.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.platform.entity.ZdQuestionVo;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 10:34:02
 */
public interface ApiZdQuestionMapper extends BaseDao<ZdQuestionVo> {
	Map<String , Object> queryMyQuestion(@Param(value="uId")Integer uId);
	
	List<ZdQuestionVo> queryQuestionList(@Param(value="uId")Integer uId); 
}
