<template>
  <div>
    <cube-slide :data="imgArray">
      <cube-slide-item v-for='(item,index) in imgArray' :key="index">
        <div class="home-banner">
          <img class="home-banner-img" :src="item.img"/>
        </div>

      </cube-slide-item>
    </cube-slide>
    <!-- <div class="home-banner" v-for='(item,index) in imgArray' :key="index" v-show="index===mark">
      <img class="home-banner-img" :src="item.img"/>
    </div> -->
  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import img from '../../static/images/banner.png'
import img1 from '../../static/images/banner1.png'
import img2 from '../../static/images/banner2.png'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  data (){
    return{
      mark: 0,
      imgArray:[
        {
          id: 0,
          img: img,
        },
        {
          id: 1,
          img: img1,
        },
        {
          id: 2,
          img: img2,
        }
        // '../../static/images/banner.png',
        // "../../static/images/banner1.png",
        // "../../static/images/banner2.png",
      ],
    }
  },

  computed: {
    
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
  .home-banner{
    width: 100%;
    height: 310px;
    margin: 0 auto;
    .home-banner-img{
      width: 100%;
      height: 100%;
    }
  }
</style>
