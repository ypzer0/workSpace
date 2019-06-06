<template>
  <div>
    <div class="user-category-order" @click="$go('/z-order')">
      <div class="user-category-order-iner">
        <div class="user-category-order-iner-left">
          <div class="user-category-order-iner-img">
            <img src="../../static/images/order.png"/>
          </div>
          <p class="user-category-order-iner-name">我的订单</p>
        </div>
        <i class="iconfont user-order-icon">&#xe65f;</i>
      </div>
    </div>

    <div class="user-category-order1">
      <div class="user-category-order-iner add" @click="$go('/z-report')">
        <div class="user-category-order-iner-left">
          <div class="user-category-order-iner-img">
            <img src="../../static/images/report.png"/>
          </div>
          <p class="user-category-order-iner-name">检查报告</p>
        </div>
        <i class="iconfont user-order-icon">&#xe65f;</i>
      </div>

      <div class="user-category-order-iner" @click="$go('/z-my-consult')">
        <div class="user-category-order-iner-left">
          <div class="user-category-order-iner-img">
            <img src="../../static/images/doctor.png"/>
          </div>
          <p class="user-category-order-iner-name">我的问诊</p>
        </div>
        <i class="iconfont user-order-icon">&#xe65f;</i>
      </div>
    </div>

    <div class="user-category-order" @click="$go('/z-service')">
      <div class="user-category-order-iner">
        <div class="user-category-order-iner-left">
          <div class="user-category-order-iner-img">
            <img src="../../static/images/service.png"/>
          </div>
          <p class="user-category-order-iner-name">客服售后</p>
        </div>
        <i class="iconfont user-order-icon">&#xe65f;</i>
      </div>
    </div>

  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
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
.user-category-order1{
  width: 100%;
  //height: 100px;
  background: #ffffff;
  margin-top: 16px;
  .add{
    border-bottom: 1px solid #e5e5e5;
  }
  .user-category-order-iner{
    width: 95%;
    height: 100px;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
    .user-category-order-iner-left{
      display: flex;
      .user-category-order-iner-img{
        width: 40px;
        height: 40px;
        padding: 30px 0;
        img{
          width: 100%;
          height: 100%;
        }
      }
      .user-category-order-iner-name{
        margin-left: 24px;
        font-size: 30px;
        color: #2e2e2e;
        line-height: 100px;
      }
    }
    .user-order-icon{
      font-size: 30px;
      color: #2e2e2e;
      line-height: 100px;
    }
  }
}



.user-category-order{
  width: 100%;
  height: 100px;
  background: #ffffff;
  margin-top: 16px;
  .user-category-order-iner{
    width: 95%;
    height: 100px;
    margin: 0 auto;
    display: flex;
    justify-content: space-between;
    .user-category-order-iner-left{
      display: flex;
      .user-category-order-iner-img{
        width: 40px;
        height: 40px;
        padding: 30px 0;
        img{
          width: 100%;
          height: 100%;
        }
      }
      .user-category-order-iner-name{
        margin-left: 24px;
        font-size: 30px;
        color: #2e2e2e;
        line-height: 100px;
      }
    }
    .user-order-icon{
      font-size: 30px;
      color: #2e2e2e;
      line-height: 100px;
    }
  }
}
</style>
