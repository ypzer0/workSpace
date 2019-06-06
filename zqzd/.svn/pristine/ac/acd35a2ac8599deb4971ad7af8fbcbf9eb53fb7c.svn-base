<template>
  <div class="goods-details-box">
    <div class="goods-details-price">
      <p class="goods-details-money">￥{{GoodsInfo.price}}</p>
      <p class="goods-details-freight">运费：包邮</p>
    </div>
    <p class="goods-details-name">{{GoodsInfo.goods_name}}</p>
    <p class="goods-details-selected">已选“123”</p>
  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  computed: {
    ...mapState('zd_goods_detail', ['GoodsInfo'])
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
.goods-details-box{
  width: 100%;
  margin: 0 auto;
  background: #ffffff;
  padding-bottom: 30px;
  .goods-details-price{
    width: 95%;
    margin: 0 auto;
    padding-top: 30px;
    display: flex;
    justify-content: space-between;
    .goods-details-money{
      font-size: 40px;
      color: #f58d25;
    }
    .goods-details-freight{
      font-size: 26px;
      color: #b0b0b6;
    }
  }
  .goods-details-name{
    width: 95%;
    margin: 0 auto;
    font-size: 30px;
    color: #2e2e2e;
    padding-top: 30px;
  }
  .goods-details-selected{
    width: 95%;
    margin: 0 auto;
    font-size: 26px;
    color: #b0b0b6;
    padding-top: 30px;
  }
}
</style>
