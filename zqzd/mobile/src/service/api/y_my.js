import axios from '@/libs/api.request'
import * as api from '@/config/api.js'
export const y_my = {

  
  //绑定上级用户
  bindUser: (params) => {
    
    return axios.request({
      url: api.Y_BindUser,
      data: params,
      method: 'post'
    })
  },

  //加载支付页面数据
  myCenter: (params) => {
    
    return axios.request({
      url: api.Y_MyDetailed,
      data: params,
      method: 'post'
    })
  },
  
  wechatLogin: (params) => {
    return axios.request({
      url: api.Y_UserLogin,
      data: params,
      method: 'post'
    })
  },

  testLogin: (params) => {
    return axios.request({
      url: api.Y_TestLogin,
      data: params,
      method: 'post'
    })
  },

  loadConfig: (params) => {
    return axios.request({
      url: api.Y_LoadConfig,
      data: params,
      method: 'post'
    })
  },
  
}
