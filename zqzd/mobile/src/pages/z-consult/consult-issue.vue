<template>
  <div>
    <p class="issue-tetle">请填写您的健康疑问，描述越详细，医生越容易解答</p>
    <div class="issue-content">
        <textarea class="issue-textarea" v-model="zdQuestionVo.consultation" placeholder="描述您的主要病症，发病时间和病情变化情况等" rows="3"></textarea>
        <div class="issue-counter">
            <span class="issue-textareaLength">{{textNumber}}</span>/{{totaltextNumber}}
        </div>
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  data (){
    return{
      listShow: 0,
      textContent: '',
      textNumber: 0,
      totaltextNumber: 50,
    }
  },

  computed: {
    ...mapState('zd_consult', ['zdQuestionVo'])
    
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
.issue-tetle{
  width: 95%;
  margin: 30px auto;
  font-size: 30px;
  color: 2e2e2e;
}
.issue-content{
  width: 95%;
  //height: 200px;
  padding-bottom: 20px;
  margin: 0 auto;
  background: #ffffff;
  .issue-textarea{
    width: 99%;
    border: none;
    height: 160px;
    margin-bottom: 20px;
    font-size: 26px;
    padding: 10px 0 0 10px;
  }
  .issue-counter{
    //margin-bottom: 20px;
    text-align: right;
    margin-right: 20px;
    font-size: 22px;
      color: #d1d1d6;
    .issue-textareaLength{
      font-size: 22px;
      color: #d1d1d6;
    }
  }
}
</style>
