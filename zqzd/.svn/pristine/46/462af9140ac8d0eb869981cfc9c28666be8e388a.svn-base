import axios from '@/libs/api.request'
import * as api from '@/config/api.js'
export const zd_goods_detail = {

  //检测服务商品
  getInfo: (params) => {
    
    return axios.request({
      url: api.zd_goods_detail,
      data: params,
      method: 'post'
    },{
        cp : 'application/json'
    })
  },
  //查询医生集合
  getSelectInfo: ()=>{
    return axios.request({
      url: api.zd_select_info,
      method: 'post'
    })
  }

}
