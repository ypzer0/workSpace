<template>
  <div class="register-data-box">
    <ul class="register-data-list">
      <li class="register-data-list-name">
        <div class="register-data-list-name-icon">
          <img src="../../static/images/name.png"/>
        </div>
        <input class="register-data-list-name-text" type="text" v-model="radioChecke.username" placeholder="请填写你的姓名"/>
      </li>
      <li class="register-data-list-name">
        <div class="register-data-list-name-icon">
          <img src="../../static/images/gender.png"/>
        </div>
        <form class="register-radio-box">
          <label class="register-radio"><input v-model="radioChecke.checkedValue" class="border_w" type="radio" name="Q3" value="0"/><span class="border_text">女</span></label> 
          <label class="register-radio"><input v-model="radioChecke.checkedValue" class="border_w" type="radio" name="Q3" value="1"/><span class="border_text">男</span></label> 
        </form>
      </li>

      <li class="register-data-list-name">
        <div class="register-data-list-name-icon">
          <img src="../../static/images/age.png"/>
        </div>
        <input class="register-data-list-name-text" type="number" v-model="radioChecke.age" placeholder="请填写你的年龄"/>
      </li>

      <li class="register-data-list-name">
        <div class="register-data-list-name-icon">
          <img src="../../static/images/phone.png"/>
        </div>
        <input class="register-data-list-name-text" type="text" v-model="radioChecke.mobile" placeholder="请填写你的联系方式"/>
        <button class="register-data-list-name-btn" @click="getSendCode">发送短信</button>
      </li>

      <li class="register-data-list-name">
        <div class="register-data-list-name-icon">
          <img src="../../static/images/phone.png"/>
        </div>
        <input class="register-data-list-name-text" type="text" v-model="radioChecke.code" placeholder="请填写短信验证码"/>
      </li>
    </ul>
  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
//import homeBanner from './home-banner'
import {toast} from '@/libs/cube-ui'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  data (){
    return{
      listShow: 0,
      selected: '',
      //checkedValue:0,
      aa: 1,
    }
  },

  computed: {
    ...mapState('z_register', ['radioChecke']),
    
  },
  components: {
   
  },
  methods: {
    ...mapActions('z_register', ['getRegister', 'getSendCode']),
    tabList(dt){
      console.log("dt:",dt);
      if(dt.item.id == 0){
        this.listShow = 0;
      }else if(dt.item.id == 1){
        this.listShow = 1;
      }
    }
  },
  created() {

  },
  activated(){

  },
  
}
</script>


<style lang="less" scoped>
.register-data-box{
  width: 100%;
  margin: 0 auto;
  background: #ffffff;
  .register-data-list{
    width: 100%;
    margin: 0 auto;
    .register-data-list-name{
      width: 95%;
      margin: 0 auto;
      height: 100px;
      border-bottom: 1px solid #e5e5e5;
      display: flex;
      .register-data-list-name-icon{
        width: 36px;
        padding: 30px 0;
        margin-right: 25px;
        img{
          width: 100%;
        }
      }
      .register-data-list-name-text{
        width: 450px;
        font-size: 26px;
        color: #b0b0b6;
      }
      .register-data-list-name-btn{
        width: 200px;
        height: 70px;
        margin-top: 15px;
        background: none;
        border: 1px solid #15a396;
        border-radius: 6px;
        color: #15a396;
      }
      .register-radio-box{
        display: flex;
        margin-left: 80px;
      }
      .register-radio{
        font-size: 34px;
        display: flex;
        margin-right: 80px;
      }
      .border_w{
        font-size: 40px;
        margin-right: 20px;
        width: 40px;
        height: 40px;
        margin-top: 28px;
      }
      .border_text{
        line-height: 100px;
      }
    }
  }
}
</style>
