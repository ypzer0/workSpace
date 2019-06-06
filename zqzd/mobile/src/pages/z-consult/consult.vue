<template>
  <page :better-scroll="true" ref="scroll">
    <consult-issue></consult-issue>
    <consult-after></consult-after>
    <consult-issue-help></consult-issue-help>
    <p class="consult-prompt">待医生回复后，可在个人中心里面"我的问诊"中查看回复消息</p>
    <button class="consult-btn" @click="questionAction">提交问题</button>
  </page>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import consultIssue from './consult-issue'
import consultAfter from './consult-after'
import consultIssueHelp from './consult-issue-help'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  computed: {
    ...mapState('zd_consult',['zdQuestionVo'])
  },
  components: {
    consultIssue,
    consultAfter,
    consultIssueHelp
  },
  methods: {
    ...mapActions('zd_consult', ['questionAction']),
  },
  created() {

  },
  activated(){

  },
  
}
</script>


<style lang="less" scoped>
.consult-prompt{
  padding-top: 23px;
  width: 95%;
  margin: 0 auto;
  font-size: 26px;
  color: #f58d25;
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
