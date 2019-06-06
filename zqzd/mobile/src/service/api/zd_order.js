import axios from '@/libs/api.request'
import * as api from '@/config/api.js'
export const zd_order  = {
    
  //提交用户问题
  list: (params) => {
    
    return axios.request({
      url: api.zd_order_list,
      data: params,
      method: 'post'
    })
  },

}
