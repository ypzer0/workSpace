<template>
    <page ref="scroll">  
    <home-banner></home-banner>
    <home-nav @click-tab="tabList"></home-nav>
    <home-list-one v-show="this.listShow == 0"></home-list-one>
    <home-list-two v-show="this.listShow == 1"></home-list-two>
    <ul class="aa1">
      <li class="aa1-li" @click="$go('/z-consult')">一病多问</li>
      <li class="aa1-li" @click="$go('/z-home')">检测服务</li>
      <li class="aa1-li" @click="$go('/z-user')">个人中心</li>
    </ul>
  </page>
</template>
  </page>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import homeBanner from './home-banner'
import homeNav from './home-nav'
import homeListOne from './home-list-one'
import homeListTwo from './home-list-two'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  data (){
    return{
      listShow: 0,
    }
  },

  computed: {
    ...mapState('z_home', ['home'])
    
  },
  components: {
    homeBanner,
    homeNav,
    homeListOne,
    homeListTwo,
  },
  methods: {
    ...mapActions('z_home', ['getHome']),
    tabList(dt){
      
      console.log("dt:",dt);
      if(dt.item.id == 0){
        this.listShow = 0;
      }else if(dt.item.id == 1){
        this.listShow = 1;
      }
    }
  },
  created() {
    //this.getHome();
  },
  activated(){

  },
  
}
</script>


<style lang="less" scoped>
  .aa1{
  width: 100%;
  height: 98px;
  margin: 0 auto;
  background: #ffffff;
  position: fixed;
  bottom: 0;
  display: flex;
  justify-content: center;
}
.aa1-li{
  line-height: 98px;
  width: 33.3%;
  text-align: center;
}
</style>
