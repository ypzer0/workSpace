package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_order_ask
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-06 14:03:27
 */
public class OrderAskEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //订单Id
    private Integer orderid;
    //订单号
    private String orderSn;
    //原始订单状态
    private Integer orderStatus;
    //类型，1：退款申请 2：退货申请 3：换货申请
    private Integer typeid;
    //1：未提交，2：已提交，3：已通过， 4：已拒绝，5 ：已关闭
    private Integer status;
    //用户Id
    private Integer uid;
    //用户昵称
    private String uName;
    //操作人Id
    private Integer handerId;
    //操作人
    private String handerName;
    //修改时间
    private Date utime;
    //创建时间
    private Date ctime;

    
    

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\r\n {id:'" + id + "', orderid:'" + orderid + "', orderSn:'" + orderSn + "', orderStatus:'"
				+ orderStatus + "', typeid:'" + typeid + "', status:'" + status + "', uid:'" + uid + "', uName:'"
				+ uName + "', handerId:'" + handerId + "', handerName:'" + handerName + "', utime:'" + utime
				+ "', ctime:'" + ctime + "', newMsg:'" + newMsg + "}";
	}

	/**
     * 设置：
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取：
     */
    public Integer getId() {
        return id;
    }
    /**
     * 设置：订单Id
     */
    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }

    /**
     * 获取：订单Id
     */
    public Integer getOrderid() {
        return orderid;
    }
    /**
     * 设置：订单号
     */
    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    /**
     * 获取：订单号
     */
    public String getOrderSn() {
        return orderSn;
    }
    /**
     * 设置：原始订单状态
     */
    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * 获取：原始订单状态
     */
    public Integer getOrderStatus() {
        return orderStatus;
    }
    /**
     * 设置：类型，1：退款申请 2：退货申请 3：换货申请
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }
    
    /**
     * 获取：类型，1：退款申请 2：退货申请 3：换货申请
     */
    public Integer getTypeid() {
        return typeid;
    }
    /**
     * 设置：1：未提交，2：已提交，3：已通过， 4：已拒绝，5 ：已关闭
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：1：未提交，2：已提交，3：已通过， 4：已拒绝，5 ：已关闭
     */
    public Integer getStatus() {
        return status;
    }
    /**
     * 设置：用户Id
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * 获取：用户Id
     */
    public Integer getUid() {
        return uid;
    }
    /**
     * 设置：用户昵称
     */
    public void setUName(String uName) {
        this.uName = uName;
    }

    /**
     * 获取：用户昵称
     */
    public String getUName() {
        return uName;
    }
    /**
     * 设置：操作人Id
     */
    public void setHanderId(Integer handerId) {
        this.handerId = handerId;
    }

    /**
     * 获取：操作人Id
     */
    public Integer getHanderId() {
        return handerId;
    }
    /**
     * 设置：操作人
     */
    public void setHanderName(String handerName) {
        this.handerName = handerName;
    }

    /**
     * 获取：操作人
     */
    public String getHanderName() {
        return handerName;
    }
    /**
     * 设置：修改时间
     */
    public void setUtime(Date utime) {
        this.utime = utime;
    }

    /**
     * 获取：修改时间
     */
    public Date getUtime() {
        return utime;
    }
    /**
     * 设置：创建时间
     */
    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    /**
     * 获取：创建时间
     */
    public Date getCtime() {
        return ctime;
    }

    
    ///新消息数
    private Integer newMsg;
    
    /**
	 * @return the newMsg
	 */
	public Integer getNewMsg() {
		return newMsg;
	}

	/**
	 * @param newMsg the newMsg to set
	 */
	public void setNewMsg(Integer newMsg) {
		this.newMsg = newMsg;
	}

	/**
	 * @return the typeNameStr
	 */
	public String getTypeNameStr() {
		return OrderAskEntity.getTypeNameById(typeid);
	}

	/**
	 * @return the statusNameStr
	 */
	public String getStatusNameStr() {
		return OrderAskEntity.getStatusNameById(status);
	}

	//获取申请类型
    public static String getTypeNameById(Integer typeid) {
    	String rt = "";
    	if(typeid == null) return rt;
    	switch (typeid) {
		case 1:
			rt = "退款申请";
			break;
		case 2:
			rt = "退货申请";
			break;
		case 3:
			rt = "换货申请";
			break;

		default:
			break;
		}
    	return rt;
    }
    
    //1：未提交，2：已提交，3：已通过， 4：已拒绝，5 ：已关闭

    public static String getStatusNameById(Integer status) {
    	String rt = "";
    	if(status == null) return rt;
    	switch (status) {
		case 1:
			rt = "未提交";
			break;
		case 2:
			rt = "已提交";
			break;
		case 3:
			rt = "已通过";
			break;
		case 4:
			rt = "已拒绝";
			break;
		case 5:
			rt = "已关闭";
			break;
		default:
			break;
		}
    	return rt;
    	
    }
    

}
