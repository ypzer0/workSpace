<template>
  <page ref="scroll">
    <details-banner></details-banner>
    <details-message></details-message>
    <details-goods-message></details-goods-message>
    <details-buy-alert></details-buy-alert>
    <div class="register-button">
      <button class="register-btn">立即购买</button>
    </div>
  </page>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import detailsBanner from './details-banner'
import detailsMessage from './details-message'
import detailsGoodsMessage from './details-goods-message'
import detailsBuyAlert from './details-buy-alert'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  data (){
    return{
      isShowSelect: false,
      listShow: 0,
      isHideAll: false,
    }
  },

  computed: {
    
  },
  components: {
    detailsBanner,
    detailsMessage,
    detailsGoodsMessage,
    detailsBuyAlert,
  },
  methods: {
    ...mapActions('zd_goods_detail', ['getGoodsInfo','getSelectInfo'])
    
  },
  created() {
    this.getGoodsInfo(this.$route.query.id) 
    this.getSelectInfo() 
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
