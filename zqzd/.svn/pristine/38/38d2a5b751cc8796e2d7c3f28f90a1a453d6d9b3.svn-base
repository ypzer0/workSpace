<template>
  <div class="register-prompt-box">
    <div class="register-prompt-text">亲爱的用户首次购买需要注册会员，请注册</div>
  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
//import homeBanner from './home-banner'
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
    
  },
  methods: {
    //...mapActions('cart', ['updateUserCartGoods', 'deleteUserCartGoods', 'checkout', 'LoadCar', 'GoodsChecked', 'UpdateGoodsNumber', 'CartDelete']),
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
.register-prompt-box{
  width: 100%;
  margin: 0 auto;
  .register-prompt-text{
    width: 700px;
    height: 40px;
    margin: 40px auto;
    border: 1px solid #15a396;
    border-radius: 20px;
    text-align: center;
    color: #15a396;
    line-height: 40px;
  }
}
</style>
