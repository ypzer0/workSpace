<template>
  <div class="login-box">
    <!-- <m-nav-header slot="top"></m-nav-header> -->
    <!-- <div class="login-logo">
      <div class="logo-wrap">
        <img class="ignore" src="../../static/images/login/logo.png" alt="">
      </div>
    </div> -->
    <div class="login-btns">
      <m-button class="weixin-btn" v-if="isWeiXin()"  color="" styles="" @click.native="getOauthCode">  <!-- v-if="isWeiXin()"  -->
        <i class="iconfont" style="padding-right:5px">&#xe64e;</i>
        <span>微信授权登陆</span>
      </m-button>
    </div>
    <!-- <input type="text" v-model="testLoginDt.name" placeholder="请输入测试用户名"/> -->
    <button id='tese-btn' v-if="!isWeiXin()" @click="testLogin({ go : $go })">一键测试登录</button>
  </div>
</template>

<script type="text/ecmascript-6">
import mNavHeader from '../common/nav-header'
import {wechat} from '@/service/wechat'
import {mapState, mapActions} from 'vuex'
import session from '@/libs/session'
export default {
  computed:{
    ...mapState('y_my', ['testLoginDt'])
  },
  components: {
    mNavHeader
  },
  methods: {
    ...mapActions('y_my', ['wechatLogin','testLogin']),
    getOauthCode: wechat.oauth.getOauthCode,
    wechatLoginHandler () {
      
      var pcode = session.getPCode();
      pcode = pcode === undefined ? "" : pcode;
      let params = {
        code : this.$route.query.code,
        state : this.$route.query.state,
        plat: 1,
        pcode: pcode
      }
      this.wechatLogin(params).then(res => {
        session.clearPCode();
        this.$go('/z-home');

      })
    },
    isWeiXin(){
      var ua = window.navigator.userAgent.toLowerCase();
      //通过正则表达式匹配ua中是否含有MicroMessenger字符串
      if(ua.match(/MicroMessenger/i) == 'micromessenger'){
        return true;
      }else{
        return false;
      }
    }
  },
  created () {
    if (this.$route.query.code) {
      this.wechatLoginHandler()
    }
    // else{
    //   var pcode = this.$route.query.pcode;
    //   pcode = pcode === undefined ? "" : pcode;
    //   session.setPCode(pcode);
    //   console.log(pcode);
    // }


  }
}
</script>

<style lang="less" scoped>
  @import '../../static/less/index';

  .login-header {
    position: relative;
    display: flex;
    align-items: center;
    justify-content: center;
    height: 88px;
    background: white;
    .header-left {
      position: absolute;
      top: 50%;
      left: 27px;
      transform: translateY(-50%);
      i {
        font-size: 55px;
        color: #333;
      }
    }
    h3 {
      font-size: 34px;
      font-size: @title-color;
    }
    .header-right {
      position: absolute;
      top: 50%;
      right: 27px;
      transform: translateY(-50%);
      i {
        font-size: 55px;
        color: #333;
        &:not(:last-child) {
          padding-right: 27px;
        }
      }
    }
  }

  .login-box{
    background-image: url("../../static/images/doctor.png");
    width: 100%;
    height: 100%;
    background-size: 100%;
    background-repeat: no-repeat;
    .weixin-btn{
      position: absolute;
      top: 45%;
      left: 7%;
      width: 85%;
      height: 98px;
      border-radius: 100px;
      margin: 0 auto;
      font-size: 36px;
      text-align: center;
      line-height: 98px;
      color: #fff;
      background: #2eacef;
      display: block;
      border: none;
    }
    #tese-btn{
      position: absolute;
      top: 45%;
      left: 7%;
      width: 85%;
      height: 98px;
      border-radius: 100px;
      margin: 0 auto;
      font-size: 36px;
      text-align: center;
      line-height: 98px;
      color: #fff;
      background: #2eacef;
      display: block;
      border: none;
    }
  }

  .login-logo {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 410px;
    .logo-wrap {
      display: inline-block;
      width: 300px;
      height: 100px;
      .ignore {
        width: 100%;
        height: 100%;
      }
    }
  }

  .login-btns {
    padding: 0 40px;
  }
  
</style>
