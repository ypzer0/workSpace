<template>
  <div class="home-box">
    <ul class="home-list">
      <li class="home-list-li" v-for='(item,index) in zdOrderList' :key="index" @click="jumpToMsg(item)">
        <div class="home-list-li-iner">
          <div class="home-list-li-goods-msg">
            <div class="home-list-img">
              <img :src="item.smallImgPath"/>
            </div>
            <div class="home-list-goods-msg">
              <p class="home-list-name">{{item.goodsName}}</p>
              <p class="home-list-remark">数量：{{item.orderNumber}}</p>
              <p class="home-list-price">￥{{item.orderPrice}}</p>
            </div>
          </div>
          <div class="order-time-state">
            <span class="order-time">下单时间：{{item.confirmTime | formatDate}}</span>
            <span class="order-state">已支付</span>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script type="text/ecmascript-6">
import Vue from 'vue'
import {formatDate} from '../../utils/date';
import {mapState, mapGetters, mapMutations, mapActions} from 'vuex'

export default {
  data (){
    return{
      num: 0,
      listContent:[
        {
          img: "../../static/images/img.png",
          price: "888.88",
          name: "基因检测 发发硕大的密码...",
          remark: "适用于16-26岁",
        },
        {
          img: "../../static/images/img.png",
          price: "888.88",
          name: "基因检测 发发硕大的密码...",
          remark: "适用于16-26岁",
        },
      ],
    }
  },

  computed: {
    ...mapState('zd_order',['zdOrderList'])
  },
  components: {
    
  },
  methods: {
    jumpToMsg: function(item){
       this.$router.push({path:`/z-order-msg?id=${item.id}`})
    },
    ...mapActions('zd_order',['list']),
    clickTab:function(index,item){
      console.log("num:", this.num);
      console.log("item:", item);
      this.num = index;
      this.$emit('click-tab', { i : index, item : item });
    }
  },

  
filters: {
    formatDate(time) {
        var date = new Date(time);
        return formatDate(date, 'yyyy-MM-dd hh:mm:ss');
    },
},

  created() {
    this.list(1)
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

  .home-box{
    width: 100%;
    margin: 0 auto;
    //margin-top: 18px;
    //background: #ffffff;
    padding-bottom: 40px;
    .home-list{
      width: 100%;
      margin: 0 auto;
      // display: flex;
      // justify-content: space-between;
      .home-list-li{
        width: 95%;
        margin: 0 auto;
        margin-top: 30px;
        border-radius: 10px;
        background: #ffffff;
        //margin-top: 18px;
        .home-list-li-iner{
          width: 95%;
          margin: 0 auto;
          padding: 30px 0;
          .home-list-li-goods-msg{
            display: flex;
            .home-list-img{
              width: 140px;
              height: 140px;
              border-radius: 6px;
              img{
                width: 100%;
                height: 100%;
              }
            }
            .home-list-goods-msg{
              width: 500px;
              margin-left: 25px;
              .home-list-price{
                font-size: 30px;
                margin-top: 25px;
                color: #f58d25;
              }
              .home-list-name{
                font-size: 26px;
                //margin-top: 25px;
                color: #2e2e2e;
              }
              .home-list-remark{
                font-size: 22px;
                margin-top: 25px;
                color: #b0b0b6;
              }
            }
          }

          .order-time-state{
            margin-top: 26px;
            display: flex;
            justify-content: space-between;
            .order-time{
              font-size: 22px;
              color: #b0b0b6;
            }
            .order-state{
              font-size: 22px;
              color: #15a396;
            }
          }

        }
      }
    }
  }

  .active{
    color: #15a396;
    border-bottom: 4px solid #15a396;
  }
</style>
