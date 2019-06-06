import axios from '@/libs/api.request'
import * as api from '@/config/api.js'
export const zd_service  = {
    
  //提交建议
  suggest: (params) => {
    return axios.request({
      url: api.zd_suggest,
      data: params,
      method: 'post'
    },{
      cp : 'application/json'
    })
  },
  getContact: () => {
      return axios.request({
        url: api.zd_service_info,
        method: 'post'  
      })
  }

}
