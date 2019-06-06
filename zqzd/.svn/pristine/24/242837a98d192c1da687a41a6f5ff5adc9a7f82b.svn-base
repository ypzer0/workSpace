<template>
  <page ref="scroll">
    <pay-goods-msg></pay-goods-msg>
    <pay-goods-explain></pay-goods-explain>
    <div class="register-button">
      <button class="register-btn" @click="$go('/z-pay-succeed')">微信支付</button>
    </div>
  </page>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import payGoodsMsg from './pay-goods-msg'
import payGoodsExplain from './pay-goods-explain'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  data (){
    return{
      listShow: 0,
    }
  },

  computed: {
    //...mapState('user', ['isLogin']),
    
  },
  components: {
    payGoodsMsg,
    payGoodsExplain,
  },
  methods: {
    //...mapActions('cart', ['updateUserCartGoods', 'deleteUserCartGoods', 'checkout', 'LoadCar', 'GoodsChecked', 'UpdateGoodsNumber', 'CartDelete']),
    
  },
  created() {

  },
  activated(){

  },
  
}
</script>


<style lang="less" scoped>
.register-button{
  width: 100%;
  background: #ffffff;
  position: fixed;
  bottom: 0,
}
.register-btn{
  width: 702px;
  height: 80px;
  border-radius: 100px;
  margin: 0 auto;
  display: block;
  border: none;
  margin-top: 20px;
  margin-bottom: 20px;
  font-size: 36px;
  color: #fff;
  // -webkit-box-shadow: 10px 10px 5px #b6b6b6;
  // -o-box-shadow: 10px 10px 5px #b6b6b6;
  // -moz-box-shadow: 10px 10px 5px #b6b6b6;
  // box-shadow: 10px 10px 5px #b6b6b6;
  background: -webkit-linear-gradient(100deg, #25c5a2, #17a797); /* Safari 5.1 - 6.0 */
  background: -o-linear-gradient(100deg, #25c5a2, #17a797); /* Opera 11.1 - 12.0 */
  background: -moz-linear-gradient(100deg, #25c5a2, #17a797); /* Firefox 3.6 - 15 */
  background: linear-gradient(100deg,#25c5a2, #17a797); /* 标准的语法（必须放在最后） */
}
</style>
