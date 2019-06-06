<template>
  <page ref="scroll">
    <my-consult-content></my-consult-content>
  </page>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import myConsultContent from './my-consult-content'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  data (){
    return{
      listShow: 0,
    }
  },

  computed: {    
  },
  components: {
    myConsultContent,
  },
  methods: {
      ...mapActions('zd_my_consult',['myConsult'])
  },
  created() {
      this.myConsult()
  },
  activated(){

  },
  
}
</script>


<style lang="less" scoped>

</style>
