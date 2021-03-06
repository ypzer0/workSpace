import Vue from 'vue'
import Vuex from 'vuex'
import z_registerModule from './z_register/index'
import z_homeModule from './z_home/index'

import zd_consultModule from './zd_consult/index'
import zd_orderModule from './zd_order/index'
import zd_orderMsgModule from './z-order-msg/index'
import zd_my_consultModule from './zd-my-consult/index'
import zd_serviceModule from './zd-service/index'
import zd_goodsDetailModule from './zd_goods_detail/index'
import zd_reportModule from './zd_report'

//copy
import y_my_module from './y_my'



Vue.use(Vuex)

export default new Vuex.Store({
  modules: {
    z_register: z_registerModule,
    z_home: z_homeModule,
    zd_consult: zd_consultModule,
    zd_order: zd_orderModule,
    zd_order_msg: zd_orderMsgModule,
    zd_my_consult: zd_my_consultModule,
    zd_service: zd_serviceModule,
    zd_goods_detail: zd_goodsDetailModule,
    zd_report: zd_reportModule,
    y_my: y_my_module
  }
})
