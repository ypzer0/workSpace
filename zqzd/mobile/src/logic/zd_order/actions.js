import * as types from './mutation-types'
import { api } from '@/service/api'
import {toast} from '@/libs/cube-ui'

export const actions = {
  //用户问病
  async list ({commit},payStatus) {
    //debugger;
      const form = {
        payStatus: payStatus
      };
      let res = await api.zd_order.list(form)
      
      if (res.success) {
        commit(types.ORDER_LIST, res.data)
      } else {
        toast(res.msg, 'warn')
      }
  },
  
}
