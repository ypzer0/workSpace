<template>
  <page :better-scroll="true" ref="scroll">
    <div class="view-report">
      <img class="view-report-img" src="../../static/images/banner.png"/>
    </div>
   <div>
      <h4>{{report.reportName}}</h4>
      <iframe :src='report.reportPath' width="100%" height="480px" scrolling="true" frameborder="0"/>
   </div>
  </page>
  
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'

import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  data (){
    return{
    }
  },

  computed: {
    ...mapState('zd_report', ['report']),
    
  },
  components: {

  },
  methods: {
    ...mapActions('zd_report', ['reportView']),
  },
  created() {
    this.reportView(this.$route.query.id)
  },
  activated(){

  },
  
}
</script>


<style lang="less" scoped>
.view-report{
  width: 100%;
  //height: 310px;
  margin: 0 auto;
  .view-report-img{
    width: 100%;
    //height: 100%;
  }
}
</style>
