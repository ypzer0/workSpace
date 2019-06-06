<template>
  <div>
    <!-- 我的问诊咨询 -->
    <div class="goods-msg-title">
      <span class="goods-msg-title-sp1"></span>
      <span class="goods-msg-title-sp2">我的问诊咨询</span>
    </div>
    <div class="my-consult-content">
      <p class="my-consult-content-text">{{ZdUserVo.consultation}}</p>
    </div>

    <!-- 医生回复 -->
    <div class="goods-msg-title1">
      <span class="goods-msg-title-sp1"></span>
      <span class="goods-msg-title-sp2">医生回复区</span>
    </div>
    <div class="my-consult-content">
      <p class="my-consult-content-text">{{ZdUserVo.answer_info}}</p>
    </div>


  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  computed: {
    ...mapState('zd_my_consult',['ZdUserVo'])
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
  //margin-top: 16px;
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


.goods-msg-title1{
  width: 100%;
  height: 80px;
  margin: 0 auto;
  background: #ffffff;
  margin-top: 20px;
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



.my-consult-content{
  width: 100%;
  background: #ffffff;
  padding-bottom: 30px;
  padding-top: 10px;
  .my-consult-content-text{
    width: 95%;
    margin: 0 auto;
    padding-left: 30px;
    font-size: 24px;
    color: #5d5d5d;
    line-height: 30px;
  }
}

</style>
