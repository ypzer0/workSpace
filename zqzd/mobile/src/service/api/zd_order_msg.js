import axios from '@/libs/api.request'
import * as api from '@/config/api.js'
export const zd_order_msg  = {
    
  //提交用户问题
  detail: (params) => {
    
    return axios.request({
      url: api.zd_order_msg,
      data: params,
      method: 'post'
    })
  },

}
