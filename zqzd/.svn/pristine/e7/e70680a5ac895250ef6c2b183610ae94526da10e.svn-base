import axios from '@/libs/api.request'
import * as api from '@/config/api.js'
export const zd_consult  = {
    
  //提交用户问题
  save: (zdQuestionVo) => {
    
    return axios.request({
      url: api.zd_consult,
      data: zdQuestionVo,
      method: 'post'
    }, {
      cp : 'application/json'
    })
  },

}
