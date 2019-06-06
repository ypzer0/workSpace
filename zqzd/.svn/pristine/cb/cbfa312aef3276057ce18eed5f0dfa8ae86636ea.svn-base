import * as types from './mutation-types'
import { api } from '@/service/api'
import {toast} from '@/libs/cube-ui'

export const actions = {
  //首页检测服务导航
  async getGoodsCategory ({dispatch, commit, state}, o) {
    
      let res = await api.z_home.goodsCategory(o)
      //debugger;
      if (res.success) {
        commit(types.INIT_GOODS_CATEGORY, res.data)
      } else {
        toast(res.msg, 'warn')
      }
    return res;
  },

  //首页检测服务商品
  async getHome ({dispatch, commit, state}, o) {
    
    let res = await api.z_home.home(o)
    //debugger;
    if (res.success) {
      commit(types.INIT_HOME, res.data)
    } else {
      toast(res.msg, 'warn')
    }
  return res;
},
  
}
