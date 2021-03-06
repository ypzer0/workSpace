import * as types from './mutation-types'
import { api } from '@/service/api'
import {toast} from '@/libs/cube-ui'

export const actions = {
  //用户问病
  async detail ({commit},orderId) {
    //debugger;
      const para = {
        id: orderId
      };
      let res = await api.zd_order_msg.detail(para);
      
      if (res.success) {
        commit(types.ORDER_DETAIL, res.data)
      } else {
        toast(res.msg, 'warn')
      }
  },
  
}
