package com.platform.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.platform.dao.ZdOrderDao;
import com.platform.entity.ZdOrderEntity;
import com.platform.service.ZdOrderService;
import com.platform.utils.DecimalUtil;

/**
 * Service实现类
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-05-30 10:04:31
 */
@Service("ZdorderService")
public class ZdOrderServiceImpl implements ZdOrderService {
    @Autowired
    private ZdOrderDao ZdorderDao;

    @Override
    public ZdOrderEntity queryObject(Integer id) {
        return ZdorderDao.queryObject(id);
    }

    @Override
    public List<ZdOrderEntity> queryList(Map<String, Object> map) {
        return ZdorderDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return ZdorderDao.queryTotal(map);
    }

    @Override
    public int save(ZdOrderEntity Zdorder) {
        return ZdorderDao.save(Zdorder);
    }

    @Override
    public int update(ZdOrderEntity Zdorder) {
        return ZdorderDao.update(Zdorder);
    }

    @Override
    public int delete(Integer id) {
        return ZdorderDao.delete(id);
    }

    @Override
    public int deleteBatch(Integer[] ids) {
        return ZdorderDao.deleteBatch(ids);
    }

	@Override
	public Float querySumOrderPrice() {
		return DecimalUtil.GetValueOrDefault(ZdorderDao.querySumOrderPrice()).floatValue();
	}

	@Override
	public Float querySumOrderPrice(Integer payStatus) {
		return DecimalUtil.GetValueOrDefault(ZdorderDao.querySumOrderPrice(payStatus)).floatValue();
	}
	
	/**
     * 超过24h没有支付的订单进行关闭
     * */

    @Override
    public int orderClose24h() {
        return ZdorderDao.orderClose24h();
    }
}
