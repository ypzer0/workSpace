<template>
  <page ref="scroll">
    <my-msg-data></my-msg-data>
  </page>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import myMsgData from './my-msg-data'
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
    myMsgData,
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
