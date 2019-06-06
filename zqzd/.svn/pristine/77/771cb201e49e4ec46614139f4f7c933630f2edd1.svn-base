<template>
  <page :better-scroll="true" ref="scroll">
    <order-nav @click-tab="tabList"></order-nav>
    <order-have-pay v-show="this.listShow == 0"></order-have-pay>
    <order-no-pay v-show="this.listShow == 1"></order-no-pay>
  </page>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import orderNav from './order-nav'
import orderHavePay from './order-have-pay'
import orderNoPay from './order-no-pay'
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
    orderNav,
    orderHavePay,
    orderNoPay,
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

</style>
