import * as types from './mutation-types'
import { api } from '@/service/api'
import {toast} from '@/libs/cube-ui'

export const actions = {
   //获取服务商品信息
  async getGoodsInfo ({commit}, id) {
    var para= {
      id: id
    }
    let res = await api.zd_goods_detail.getInfo(para)

    if (res.success) {
      
      commit(types.INIT_GOODS_DETAIL, res.data)
    } else {
      toast(res.msg, 'warn')
    }
  return res;
  },
  //获取下拉框选项信息
  async getSelectInfo ({commit}) {
    let res = await api.zd_goods_detail.getSelectInfo()

    if (res.success) {
      commit(types.GET_SELECT_INFO, res.data)
    } else {
      toast(res.msg, 'warn')
    }
  return res;
  }
  
}
