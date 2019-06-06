package com.platform.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 实体
 * 表名 nideshop_order_ask_msg
 *
 * @author zy
 * @email zgyxszyd@163.com
 * @date 2019-03-06 14:03:27
 */
public class OrderAskMsgEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    //
    private Integer id;
    //申请id
    private Integer askid;
    //消息管理
    private String msg;
    //用户Id
    private Integer uid;
    //用户昵称
    private String uName;
    //回复人Id
    private Integer handerId;
    //操作人
    private String handerName;
    //0: 删除 1：显示，2：隐藏
    private Integer status;
    //创建时间
    private Date ctime;

    //消息类型 1.消息, 2.备注
    private Integer msgType;
    
    //读取状态 0 未读  1 已读
    private Integer readStatus;
    
    //消息方式 1 用户到操作员 2 操作员到用户
    private Integer msgWay;
    

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */

    
    

	/**
     * 消息方式 1 用户到操作员 2 操作员到用户
	 * @return the msgWay
	 */
	public Integer getMsgWay() {
		return msgWay;
	}

	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\r\n {id:'" + id + "', askid:'" + askid + "', msg:'" + msg + "', uid:'" + uid
				+ "', uName:'" + uName + "', handerId:'" + handerId + "', handerName:'" + handerName + "', status:'"
				+ status + "', ctime:'" + ctime + "', msgType:'" + msgType + "', readStatus:'" + readStatus
				+ "', msgWay:'" + msgWay + "'}";
	}


	/**
	 * 消息方式 1 用户到操作员 2 操作员到用户
	 * @param msgWay the msgWay to set
	 */
	public void setMsgWay(Integer msgWay) {
		this.msgWay = msgWay;
	}

	/**
	 * 读取状态 0 未读  1 已读
	 * @return the readStatus
	 */
	public Integer getReadStatus() {
		return readStatus;
	}

	/**
	 * 读取状态 0 未读  1 已读
	 * @param readStatus the readStatus to set
	 */
	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}

	/**
	 * 消息类型 1.消息, 2.备注
	 * @return the msgType
	 */
	public Integer getMsgType() {
		return msgType;
	}

	/**
	 * 消息类型 1.消息, 2.备注
	 * @param msgType the msgType to set
	 */
	public void setMsgType(Integer msgType) {
		this.msgType = msgType;
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
     * 设置：申请id
     */
    public void setAskid(Integer askid) {
        this.askid = askid;
    }

    /**
     * 获取：申请id
     */
    public Integer getAskid() {
        return askid;
    }
    /**
     * 设置：消息管理
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取：消息管理
     */
    public String getMsg() {
        return msg;
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
     * 设置：回复人Id
     */
    public void setHanderId(Integer handerId) {
        this.handerId = handerId;
    }

    /**
     * 获取：回复人Id
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
     * 设置：0: 删除 1：显示，2：隐藏，
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取：0: 删除 1：显示，2：隐藏，
     */
    public Integer getStatus() {
        return status;
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
    
    
    
    public String getStatusStr() {
    	return OrderAskMsgEntity.getStatusById(status);
    }
    
    public String getMsgTypeStr() {
    	return OrderAskMsgEntity.getMsgTypeById(msgType);
    }
    
    public String getReadStatusStr() {
    	return OrderAskMsgEntity.getReadStatusById(readStatus);
    }

	//获取状态
    public static String getStatusById(Integer typeid) {
    	String rt = "";
    	if(typeid == null) return rt;
    	switch (typeid) {
		case 0:
			rt = "删除";
			break;
		case 1:
			rt = "显示";
			break;
		case 2:
			rt = "隐藏";
			break;
		default:
			break;
		}
    	return rt;
    }
    
	//获取消息类型
    public static String getMsgTypeById(Integer typeid) {
    	String rt = "";
    	if(typeid == null) return rt;
    	switch (typeid) {
		case 1:
			rt = "消息";
			break;
		case 2:
			rt = "备注";
			break;
		default:
			break;
		}
    	return rt;
    }

	//获取读取类型
    public static String getReadStatusById(Integer typeid) {
    	String rt = "";
    	if(typeid == null) return rt;
    	switch (typeid) {
		case 0:
			rt = "未读";
			break;
		case 1:
			rt = "已读";
			break;
		default:
			break;
		}
    	return rt;
    }
    
    
    
}
