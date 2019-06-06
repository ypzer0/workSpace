<template>
  <page :better-scroll="true" ref="scroll">
    <report-check></report-check>
  </page>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import reportCheck from './report-check'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  data (){
    return{
    }
  },

  computed: {
    //...mapState('user', ['isLogin']),
    
  },
  components: {
    reportCheck
  },
  methods: {
    ...mapActions('zd_report', ['reportList'])

  },
  created() {
    this.reportList();
  },
  activated(){

  },
  
}
</script>


<style lang="less" scoped>

</style>
