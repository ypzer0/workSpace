import * as types from './mutation-types'
import {api} from '@/service/api'
import {toast} from '@/libs/cube-ui'
import session from '@/libs/session'
import * as wechat from '@/config/wechat'

export const actions = {


  
  async bindUser ({dispatch, commit}, o) {
    let res = await api.y_my.bindUser(o)
    return res;
  },

  async getMyCenter ({dispatch, commit}, o) {
    let res = await api.y_my.myCenter()
    if (res.success) {
      commit(types.INIT_MY, res.data)
    } else {
      toast(res.msg, 'warn')
    }
    return res;
  },
  //微信登录
  async wechatLogin ({dispatch}, s) {
    const form = {
      code: s.code,
      state: s.state,
      plat: wechat.PLAT,
      pcode: s.pcode
    }
    console.log('login');
    console.log(form);
    let res = await api.y_my.wechatLogin(form)
    if (res.success) {
      session.setToken(res.data.token)
      let res1 = await dispatch('getMyCenter')
      return res1
    } else {
      toast(res.msg, 'warn')
    }
  },


  //开发环境一键登录
  async testLogin ({},s) {
    let nickname = "peterYoung";
    const form = {
      name: nickname
    }
    console.log('login');
    console.log(form);
    let res = await api.y_my.testLogin(form)
    if (res.success) {
      session.setToken(res.data.token) 
      s.go(`/z-home`)
    } else {
      toast(res.msg, 'warn')
    }
  },

  //加载wenxin配置
  async loadConfig ({dispatch, state}, s) {

    let form = {
      pid : wechat.PLAT,
      url : window.location.href
    };
    let res = await api.y_my.loadConfig(form)
    if (res.success) {
      let dt = res.data;
      wx.config({
        // debug: true, 
        appId: wechat.APPID, // 必填，公众号的唯一标识
        timestamp: parseInt(dt.timestamp), // 必填，生成签名的时间戳
        nonceStr: dt.noncestr, // 必填，生成签名的随机串
        signature: dt.signature,// 必填，签名
        jsApiList: s.funs // 必填，需要使用的JS接口列表
      })

    } else {
      toast(res.msg, 'warn')
    }
    return res;
  },

   //分享给朋友
   async shareToFrends({dispatch, state}, s){

    console.log(s);

    wx.ready(function () {   //需在用户可能点击分享按钮前就先调用

      // wx.updateAppMessageShareData({ 
      //   title: document.title, // 分享标题
      //   desc: s.desc, // 分享描述
      //   link: window.location.href, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
      //   imgUrl: s.imgUrl, // 分享图标
      //   success: function () {
      //     // 设置成功
      //     toast('分享成功！', 'correct')
      //   }
      // })

      // wx.onMenuShareAppMessage({
      //   title: document.title, // 分享标题
      //   desc: s.desc, // 分享描述
      //   link: window.location.href, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
      //   imgUrl: s.imgUrl, // 分享图标
      //   type: 'link', // 分享类型,music、video或link，不填默认为link
      //   dataUrl: '', // 如果type是music或video，则要提供数据链接，默认为空
      //   success: function () {
      //     // 用户点击了分享后执行的回调函数
      //     toast('分享成功！', 'correct')
      //   }
      //   });

  var shareUrl = window.location.href;
  var shareImg = s.imgUrl;
  var sayName = state.myCenter.myname;
  sayName = sayName === undefined ? "" : sayName;
  var obj = {//朋友圈
      title: sayName  +'给您的悄悄话', // 分享标题
      desc: '点击查看那些未曾对你说出口的话吧！', // 分享描述
      link: shareUrl, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
      // 该链接是重定向链接，因为需要获取用户code，但是该链接又无法直接写微信获取code的链接，
      // 所以需要点击后重新加载新的页面，来实现重定向，重新打开获取code的微信链接，实现获取用户信息的功能；
      imgUrl: shareImg, // 分享图标
      fail: function (res) {
          toast(JSON.stringify(res), 'correct');
      },
      success: function () {
      // 用户确认分享后执行的回调函数
        toast('成功', 'correct');
      },
      cancel: function () {
      // 用户取消分享后执行的回调函数
        toast('失败', 'correct');
      }
  };
  var obj1 = {//好友
      title: sayName + '有些话，早就想对您说', // 分享标题
      desc: '点击查看那些未曾对你说出口的话吧！', // 分享描述
      link: shareUrl, // 分享链接，该链接域名或路径必须与当前页面对应的公众号JS安全域名一致
      // 该链接是重定向链接，因为需要获取用户code，但是该链接又无法直接写微信获取code的链接，
      // 所以需要点击后重新加载新的页面，来实现重定向，重新打开获取code的微信链接，实现获取用户信息的功能；
      imgUrl: shareImg, // 分享图标
      fail: function (res) {
        toast(JSON.stringify(res), 'correct');
      },
      success: function () {
      // 用户确认分享后执行的回调函数
        toast('成功', 'correct');
      },
      cancel: function () {
      // 用户取消分享后执行的回调函数
        toast('失败', 'correct');
      }
  };
    // // 2.1 监听“分享给朋友”，按钮点击、自定义分享内容及分享结果接口
    // wx.onMenuShareAppMessage(obj1);

    // // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
    // wx.onMenuShareTimeline(obj);

    

    // wx.checkJsApi({
    //   jsApiList: ['updateAppMessageShareData'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
    //   success: function(res) {
    //     wx.updateAppMessageShareData(obj1);
    //       // 以键值对的形式返回，可用的api值true，不可用为false
    //       // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
    //     }
    // });
    
    // wx.checkJsApi({
    //   jsApiList: ['updateTimelineShareData'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
    //   success: function(res) {
    //     wx.updateTimelineShareData(obj);
    //       // 以键值对的形式返回，可用的api值true，不可用为false
    //       // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
    //     }
    // });

    
    // 2.1 监听“分享给朋友”，按钮点击、自定义分享内容及分享结果接口
    wx.onMenuShareAppMessage(obj1);

    // 2.2 监听“分享到朋友圈”按钮点击、自定义分享内容及分享结果接口
    wx.onMenuShareTimeline(obj);
    
    // 2.3 监听“分享到QQ”按钮点击、自定义分享内容及分享结果接口
    wx.onMenuShareQQ(obj);

    // 2.4 监听“分享到微博”按钮点击、自定义分享内容及分享结果接口
    wx.onMenuShareWeibo(obj);

    // 2.5 监听“分享到QZone”按钮点击、自定义分享内容及分享接口
    wx.onMenuShareQZone(obj);
    
    // wx.checkJsApi({
    //   jsApiList: ['onMenuShareAppMessage'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
    //   success: function(res) {
    //     wx.onMenuShareAppMessage(obj1);
    //       // 以键值对的形式返回，可用的api值true，不可用为false
    //       // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
    //     }
    // });

    // if (wx.updateAppMessageShareData) {
    // } else {
    //   wx.onMenuShareAppMessage(obj1);
    // }
    // //分享给朋友圈
    // if (wx.updateTimelineShareData) {
    //   wx.updateTimelineShareData(obj);
    // } else {
    //   wx.onMenuShareTimeline(obj);
    // }

    });
    
    // dispatch('loadConfig', { funs: [
    //   'onMenuShareAppMessage',
    //   'onMenuShareTimeline',
    //   'chooseWXPay',
    //   'showOptionMenu',
    //   "updateAppMessageShareData",
    //   "hideMenuItems",
    //   "showMenuItems",
    //   "onMenuShareTimeline",
    //   'onMenuShareAppMessage'
    // ] });
    
    dispatch('loadConfig', { funs: [
      'onMenuShareTimeline',
      'onMenuShareAppMessage',
      'onMenuShareQQ',
      'onMenuShareWeibo',
      'onMenuShareQZone'
    ] });

  },

  //分享商品
  async shareGoods({dispatch, state}, s){

    dispatch('shareToFrends', { 
      title: s.name,
      desc: s.name,
      link: wechat.SHARE_BACK + s.gid + "?cid=" + s.cid,
      imgUrl: wechat.WEB_BASE_URI + "../../static/images/goods.png"
    });

  },
 //微信支付
 async pay({dispatch, state}, ddd){

  let s = ddd.pd;
  wx.ready(function () {   //需在用户可能点击分享按钮前就先调用
      
    wx.chooseWXPay({
      timestamp: parseInt(s.timestamp), // 支付签名时间戳，注意微信jssdk中的所有使用timestamp字段均为小写。但最新版的支付后台生成签名使用的timeStamp字段名需大写其中的S字符
      nonceStr: s.nonceStr, // 支付签名随机串，不长于 32 位
      package: "prepay_id=" + s.package, // 统一支付接口返回的prepay_id参数值，提交格式如：prepay_id=\*\*\*）
      signType: s.signType, // 签名方式，默认为'SHA1'，使用新版支付需传入'MD5'
      paySign: s.paySign, // 支付签名
      success: function (res) {
      // 支付成功后的回调函数
          ddd.go('/y-pay-success?oid=' + ddd.oid)
        }
      });

  });
  
  dispatch('loadConfig', { funs: ['chooseWXPay'] });


},


  //信用分隐藏提示框
  async alertCommitHide({dispatch, state}, s){
    state.testLoginDt.alertCommit = false;
  },

  //信用分显示提示框
  async alertCommitshow({dispatch, state}, s){
    
    state.testLoginDt.alertCommit = true;
    //debugger;
  }




}
