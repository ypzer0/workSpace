<template>
  <page ref="scroll">
    <order-msg-msg></order-msg-msg>
    <order-msg-explain></order-msg-explain>
  </page>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import orderMsgMsg from './order-msg-msg'
import orderMsgExplain from './order-msg-explain'
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
    orderMsgMsg,
    orderMsgExplain,
  },
  methods: {
    ...mapActions('zd_order_msg',['detail'])    
  },
  created() {
    //此处待完善,需要页面列表传来oId
     this.detail(this.$route.query.id);
  },
  activated(){

  },
  
}
</script>


<style lang="less" scoped>

</style>
