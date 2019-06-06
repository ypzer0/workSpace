import axios from '@/libs/api.request'
import * as api from '@/config/api.js'
export const z_home = {

  //检测服务导航
  goodsCategory: (params) => {
    
    return axios.request({
      url: api.z_GoodsCategory,
      data: params,
      method: 'post'
    })
  },

  //检测服务商品
  home: (params) => {
    
    return axios.request({
      url: api.z_GoodsList,
      data: params,
      method: 'post'
    })
  },

}
