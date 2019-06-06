import axios from '@/libs/api.request'
import * as api from '@/config/api.js'
export const z_register = {
    
  //用户注册
  register: (params) => {
    
    return axios.request({
      url: api.z_UserRegister,
      data: params,
      method: 'post'
    })
  },

  //发送验证码
  SendCode: (params) => {
    
    return axios.request({
      url: api.z_MobileSend,
      data: params,
      method: 'post'
    })
  },

}
