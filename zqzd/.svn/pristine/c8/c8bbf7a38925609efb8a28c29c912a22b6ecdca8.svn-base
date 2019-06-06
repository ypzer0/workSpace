<template>
  <div>
    <div class="goods-msg-title">
      <span class="goods-msg-title-sp1"></span>
      <span class="goods-msg-title-sp2">商品详情</span>
    </div>
    <ul class="goods-msg-details">
      <li class="goods-msg-details-li"><img  :src="zdOrder.bigImgPath" width="380"/></li>
    </ul>
  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  computed: {
    ...mapState('zd_order_msg',['zdOrder'])
  },
  components: {
    
  },
  methods: {
    
  },
  created() {

  },
  activated(){

  },
  
}
</script>

<style lang="less" scoped>
.goods-msg-title{
  width: 100%;
  height: 80px;
  margin: 0 auto;
  background: #ffffff;
  margin-top: 16px;
  display: flex;
  .goods-msg-title-sp1{
    width: 6px;
    height: 26px;
    border-radius: 20px;
    background: #15a396;
    display: block;
    margin: 28px 0 25px 28px;
  }
  .goods-msg-title-sp2{
    font-size: 30px;
    color: #2e2e2e;
    line-height: 80px;
    margin-left: 6px;
  }
}


.goods-msg-details{
  width: 100%;
  margin: 0 auto;
  background: #ffffff;
  //margin-top: 16px;
  //padding-bottom: 16px;
  .goods-msg-details-li{
    width: 95%;
    margin: 0 auto;
    padding-top: 30px;
    padding-bottom: 30px;
    border-bottom: 1px solid #e5e5e5;
    display: flex;
    justify-content: space-between;
    .goods-msg-details-li-sp1{
      font-size: 24px;
      color: #5c5c7a;
    }
    .goods-msg-details-li-sp2{
      font-size: 24px;
      color: #5d5d5d;
    }
  }
}
</style>
