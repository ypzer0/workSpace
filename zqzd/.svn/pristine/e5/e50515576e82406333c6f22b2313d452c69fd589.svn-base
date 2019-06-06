import * as types from './mutation-types'
import { api } from '@/service/api'
import {toast} from '@/libs/cube-ui'

export const actions = {
  //我的问诊
  async myConsult ({commit}) {
      let res = await api.zd_my_consult.myConsult();
      
      if (res.success) {
        commit(types.MY_CONSULT, res.data)
      } else {
        toast(res.msg, 'warn')
      }
  },
  
}
