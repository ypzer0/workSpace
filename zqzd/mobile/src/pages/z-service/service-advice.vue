<template>
  <div>
    <!-- 建议 -->
    <div class="goods-msg-title">
      <span class="goods-msg-title-sp1"></span>
      <span class="goods-msg-title-sp2">改善建议</span>
    </div>
    <div class="my-consult-content">
      <textarea class="user-advice" placeholder="请输入您的建议" v-model="suggestVo.opinion"></textarea>
    </div>
    <button class="consult-btn" @click="suggest">提交建议</button>

  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  computed: {
    ...mapState('zd_service',['suggestVo'])
  },
  components: {
    
  },
  methods: {
    ...mapActions('zd_service',['suggest'])
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
  .user-advice{
    width: 90%;
    height: 200px;
    margin: 0 auto;
    margin-left: 30px;
    margin-right: 30px;
    font-size: 24px;
    color: #5d5d5d;
    line-height: 30px;
    background: #ededed;
    border-radius: 10px;
    border: none;
    padding-left: 10px;
    padding-top: 10px;
    font-size: 26px;
  }
}


.consult-btn{
  width: 300px;
  height: 80px;
  border-radius: 100px;
  margin: 0 auto;
  display: block;
  border: none;
  margin-top: 50px;
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
