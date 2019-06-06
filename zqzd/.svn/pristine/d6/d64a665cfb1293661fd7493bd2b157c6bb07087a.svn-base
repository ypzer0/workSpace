import * as types from './mutation-types'
import { api } from '@/service/api'
import {toast} from '@/libs/cube-ui'

export const actions = {
  //客服信息
  async serviceInfo ({commit}) {
      let res = await api.zd_service.getContact();
      
      if (res.success) {
        commit(types.SERVICE_INFO, res.data)
      } else {
        toast(res.msg, 'warn')
      }
  },
  async suggest ({state}) {
    var para= {
      opinion: state.suggestVo.opinion
    };

    let res = await api.zd_service.suggest(para);
    
    if (res.success) {
      toast('意见提交成功','correct')
    } else {
      toast(res.msg, 'warn')
    }
  }
  
}
