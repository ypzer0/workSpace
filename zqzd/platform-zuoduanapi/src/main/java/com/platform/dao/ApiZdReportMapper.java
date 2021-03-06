package com.platform.dao;

import java.util.List;

import com.platform.entity.ZdReportVo;

/**
 * Dao
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 12:58:56
 */
public interface ApiZdReportMapper extends BaseDao<ZdReportVo> {
	List<ZdReportVo> queryReportList(Integer uId);
	
	ZdReportVo queryById(Integer id);
	
}
