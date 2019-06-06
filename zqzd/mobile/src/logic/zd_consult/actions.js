import * as types from './mutation-types'
import { api } from '@/service/api'
import {toast} from '@/libs/cube-ui'

export const actions = {
  //用户问病
  async questionAction ({state}) {
    //debugger;
      var para = {
        consultation: state.zdQuestionVo.consultation,
        checkStatus: state.zdQuestionVo.checkStatus,
        checkInfo: state.zdQuestionVo.checkInfo,
        helpInfo: state.zdQuestionVo.helpInfo
      };
    
      let res = await api.zd_consult.save(para)
      
      if (res.success) {
        toast('问题提交成功', 'correct')
      } else {
        toast(res.msg, 'warn')
      }
  },
  
}
