<template>
  <page ref="scroll">
    <user-top></user-top>
    <user-category></user-category>
  </page>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import userTop from './user-top'
import userCategory from './user-category'
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
    userTop,
    userCategory,
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

</style>
