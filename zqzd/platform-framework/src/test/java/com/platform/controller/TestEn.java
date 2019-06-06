//package com.platform.controller;
//
//import java.io.UnsupportedEncodingException;
//import java.math.BigDecimal;
//import java.net.URLEncoder;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.Map;
//import java.util.Set;
//import java.util.TreeMap;
//
//import org.apache.commons.codec.digest.DigestUtils;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.platform.BaseSpringTestCase;
//import com.platform.entity.OrderVo;
//import com.platform.entity.PayLogEntity;
//import com.platform.entity.WalletInfoVo;
//import com.platform.entity.WalletInfoLogVo;
//import com.platform.service.ApiOrderService;
//import com.platform.service.WalletInfoLogService;
//import com.platform.service.WalletInfoService;
//import com.platform.util.CommonUtil;
//import com.platform.util.wechat.MD5;
//import com.platform.util.wechat.WechatRefundApiResult;
//import com.platform.util.wechat.WechatUtil;
//import com.platform.utils.DateUtils;
//import com.platform.utils.ResourceUtil;
//
//public class TestEn extends BaseSpringTestCase {
//
//    @Autowired
//    private ApiOrderService orderService;
//    @Autowired
//    private WalletInfoService walletInfoService;
//    @Autowired
//    private WalletInfoLogService walletInfoLogService;
//
//    @Test
//    public void Testaaa() {
//    	String timeee = DateUtils.timeToStr(System.currentTimeMillis() / 1000, DateUtils.DATE_TIME_PATTERN);
//    	
//    	print("timeee:" + timeee);
//
//        Map<Object, Object> resultObj = new TreeMap();
//
//        resultObj.put("appId", "111");
//        resultObj.put("timeStamp", DateUtils.timeToStr(System.currentTimeMillis() / 1000, DateUtils.DATE_TIME_PATTERN));
//        resultObj.put("nonceStr", "111");
//        resultObj.put("package", "prepay_id=" + "111");
//        resultObj.put("signType", "MD5");
//        String paySign = arraySign(resultObj, "SDK");
//    }
//
//    public static String arraySign(Map<Object, Object> params, String paySignKey) {
//        boolean encode = false;
//        Set<Object> keysSet = params.keySet();
//        Object[] keys = keysSet.toArray();
//        Arrays.sort(keys);
//        StringBuffer temp = new StringBuffer();
//        boolean first = true;
//        for (Object key : keys) {
//            if (first) {
//                first = false;
//            } else {
//                temp.append("&");
//            }
//            temp.append(key).append("=");
//            Object value = params.get(key);
//            String valueString = "";
//            if (null != value) {
//                valueString = value.toString();
//            }
//            if (encode) {
//                try {
//                    temp.append(URLEncoder.encode(valueString, "UTF-8"));
//                } catch (UnsupportedEncodingException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                temp.append(valueString);
//            }
//        }
//        temp.append("&key=");
//        temp.append(paySignKey);
//        System.out.println(temp.toString());
//        String packageSign = MD5.getMessageDigest(temp.toString());
//        return packageSign;
//    }
//	@Test
//	public void TestOrderSn() {
//
//        float pay_money = 0f;
//        int pay_status = 2;
//        //申请支付日志
//        PayLogEntity payLog = new PayLogEntity();
//        payLog.setCtime(new Date());
//        payLog.setIp("");
//        payLog.setPayType(11);
//        payLog.setTraType(2);
//        payLog.setUId(0);
//        payLog.setUName("");
//		WechatRefundApiResult result = new WechatRefundApiResult();
//		result.setResult_code("SUCCESS");
//		result.setRefund_fee("1");
//		result.setOut_trade_no("20190312154008438202412");
//		
//        String result_code = result.getResult_code();
//
////        String result_code = result.getResult_code();
//        if (result_code.equalsIgnoreCase("FAIL")) {
//            //订单编号
//            String out_trade_no = result.getOut_trade_no();
//
//            OrderVo orderInfo = orderService.queryObjectByOrderNo(out_trade_no);
//            if(orderInfo != null) {
//                payLog.setOId(orderInfo.getId());
//                payLog.setUId(orderInfo.getUser_id().intValue());
//                payLog.setUName(orderInfo.getUserName());
//            }
//            payLog.setOrderNo(out_trade_no);
//            
//            logger.error("订单" + out_trade_no + "响应支付失败");
////            response.getWriter().write(setXml("SUCCESS", "OK"));
//            print("返回错误");
//        } else if (result_code.equalsIgnoreCase("SUCCESS")) {
//        	
//        	
//            //订单编号
//        	pay_status = 1;
//            String out_trade_no = result.getOut_trade_no();
//
//            payLog.setOrderNo(out_trade_no);
//            pay_money = Integer.parseInt(result.getRefund_fee());
//            
//            logger.error("订单" + out_trade_no + "支付成功");
//            // 业务处理
//            OrderVo orderInfo = orderService.queryObjectByOrderNo(out_trade_no);
//            
//            if(orderInfo != null) {
//                payLog.setOId(orderInfo.getId());
//                payLog.setUId(orderInfo.getUser_id().intValue());
//                payLog.setUName(orderInfo.getUserName());
//            }
//            else {
//            	logger.info("异常查找的订单失败.");
//            }
//            
//            orderInfo.setPay_status(2);
//            orderInfo.setOrder_status(201);
//            orderInfo.setShipping_status(0);
//            orderInfo.setPay_time(new Date());
//            orderService.update(orderInfo);
//            
//            //插入流水信息  zy 2019-03-05
//            WalletInfoVo walletInfo = new WalletInfoVo();
//            walletInfo.setUid(orderInfo.getUser_id());
//            walletInfo.setMoney(orderInfo.getActual_price());
//            walletInfo.setWtype1(1);
//            walletInfo.setWtype2(3);
//            walletInfo.setOrderSn(out_trade_no);
//            walletInfo.setCouponId(0);
//            walletInfo.setTransactionId(result.getOut_trade_no());
//            walletInfo.setOutTradeNo(result.getOut_trade_no());
//            walletInfo.setActivityId("");
//            walletInfo.setCtime(new Date());
//            
////            walletInfoService.save(walletInfo);
//            
//            WalletInfoLogVo walletInfoLog = new WalletInfoLogVo();
//            walletInfoLog.setContent("用户：" + orderInfo.getUserName() + " 下单：" + out_trade_no + " 支付：" + orderInfo.getActual_price() );
//            walletInfoLog.setCtime(new Date());
//            walletInfoLog.setMoney(orderInfo.getActual_price());
//            walletInfoLog.setWtype1(walletInfo.getWtype1());
//            walletInfoLog.setWtype2(walletInfo.getWtype2());
//            walletInfoLog.setTitle(walletInfoLog.getWtype2Str() + " " + walletInfoLog.getWtype1Str());
//            walletInfoLog.setUid(walletInfo.getUid().intValue());
//            walletInfoLog.setWid(walletInfo.getId());
//            
////            walletInfoLogService.save(walletInfoLog);
//
//            print("返回成功");
////            response.getWriter().write(setXml("SUCCESS", "OK"));
//        }
//	}
//	
//	@Test
//	public void TestSignE() {
//		String rawData = "{\"nickName\":\"상    사랑\",\"gender\":1,\"language\":\"zh_CN\",\"city\":\"\",\"province\":\"\",\"country\":\"China\",\"avatarUrl\":\"https://wx.qlogo.cn/mmopen/vi_32/bhecGe2qviad9EPC4ambkAHNdVc8s26fwJlMdyL8vOFyQ9a9fvrrTeicve3HCxvnSWYxGCy9roofOiaD0JnFMqjKw/132\"}";
//		String skey = "JoIc+oCowX1HRNcG+tYL/w==";
//		
//		String sha1 = DigestUtils.sha1Hex(rawData + skey);
//		print("6cb54b9804adf5c40c2363f869fe4ad21d1efb56");
//		print(sha1);
//	}
//	
//	@Test
//	public void TestSign() {
//		
////		String rawData
////        String sha1 = CommonUtil.getSha1(fullUserInfo.getRawData() + sessionData.getString("session_key"));
//		
//		BigDecimal bd = new BigDecimal(0.02);
//		BigDecimal rt = bd.multiply(new BigDecimal(100));
//		print(rt.intValue());
//		print(bd.multiply(new BigDecimal(100)).intValue());
//		
////		print(Integer.valueOf("20190312154008438202412"));
//		Testkkk();
//		
//		new AAA(123);
//		
//	}
//	
//	
//	private void Testkkk() {
//		
//		try {
//			print("try");
//			throw new Exception();
//		} catch(Exception ex) {
//			print("erorr");
//			return ;
//		}
//		finally {
//			print("finily");
//			// TODO: handle finally clause
//		}
//		
//	}
//	
//	
//	public class AAA{
//		
//		private int aaa;
//		public AAA() {
//			// TODO Auto-generated method stub
//			print("AAA");
//			print(aaa);
//		}
//
//		public AAA(int a) {
//			// TODO Auto-generated method stub
//			this();
//			aaa = a;
//			print("AAA:a");
//		}
//		
//	}
//	
//	
//	
//}
