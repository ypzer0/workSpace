<template>
  <div>
    <div class="issue-tetle-box">
      <p class="issue-tetle">您曾经是否检查或治疗过</p>
      <input type="radio" value="0" v-model="zdQuestionVo.checkStatus" name="checkStatus" />否
      <input type="radio" value="1" v-model="zdQuestionVo.checkStatus" name="checkStatus" />是
      <!--<ul class="issue-tetle-btn">
        <li class="issue-tetle-btn1" :class="{active:index == btnIndex}" v-for="(item,index) in btn" :key="index" @click="clickTab(index,item)">{{item.name}}</li>
      </ul>-->
    </div>
    
    <div class="issue-content">
        <textarea class="issue-textarea" v-model="zdQuestionVo.checkInfo" placeholder="描述您检查或治疗的情况，方便医生分析问题" rows="3"></textarea>
        <!--<div class="issue-counter">
            <span class="issue-textareaLength">{{textNumber}}</span>/{{totaltextNumber}}
        </div>-->
    </div>
  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  computed: {
    ...mapState('zd_consult',['zdQuestionVo'])
  },
  components: {
    
  },
  methods: {
    
  },
  created() {
    //this.issueText();
  },

  activated(){

  },
  
}
</script>


<style lang="less" scoped>
.issue-tetle-box{
  display: flex;
  justify-content: space-between;
  width: 95%;
  margin: 0 auto;
  .issue-tetle{
    width: 95%;
    margin: 30px auto;
    font-size: 30px;
    color: 2e2e2e;
  }
  .issue-tetle-btn{
    display: flex;
    .issue-tetle-btn1{
      width: 110px;
      height: 50px;
      border-radius: 6px;
      //background: #ededed;
      border: 1px solid #b0b0b6;
      margin-top: 20px;
      font-size: 30px;
      text-align: center;
      line-height: 50px;
      margin-left: 20px;
    }
    .issue-tetle-btn2{
      width: 110px;
      height: 50px;
      border-radius: 6px;
      background: #ededed;
      border: 1px solid #b0b0b6;
      margin-top: 20px;
      margin-left: 20px;
    }
  }
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

.active{
  color: #ffffff;
  background-color: #15a396;
}
</style>
