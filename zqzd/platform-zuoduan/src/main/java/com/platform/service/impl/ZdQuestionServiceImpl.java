package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import com.platform.dao.ZdQuestionDao;
import com.platform.entity.ZdQuestionEntity;
import com.platform.service.ZdQuestionService;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 10:38:46
 */
@Service("ZdquestionService")
public class ZdQuestionServiceImpl implements ZdQuestionService {
    @Autowired
    private ZdQuestionDao ZdquestionDao;

    @Override
    public ZdQuestionEntity queryObject(Integer id) {
        return ZdquestionDao.queryObject(id);
    }

    @Override
    public List<ZdQuestionEntity> queryList(Map<String, Object> map) {
        return ZdquestionDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return ZdquestionDao.queryTotal(map);
    }

    @Override
    public int save(ZdQuestionEntity Zdquestion) {
        return ZdquestionDao.save(Zdquestion);
    }

    @Override
    public int update(ZdQuestionEntity Zdquestion) {
    	Zdquestion.setAnswerStatus(1);
        return ZdquestionDao.update(Zdquestion);
    }

    @Override
    public int delete(Integer id) {
        return ZdquestionDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return ZdquestionDao.deleteBatch(ids);
    }
}
