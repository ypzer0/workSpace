import axios from '@/libs/api.request'
import * as api from '@/config/api.js'
export const zd_report  = {
    
  //获取用户报告列表
  list: () => {
    return axios.request({
      url: api.zd_report_list,
      method: 'post'
    })
  },
  //下载报告
  download: (params) => {
    return axios.request({
      url: params,
      responseType: 'blob',
      method: 'get'
    })
  },
  //查看报告
  view: (params) => {
    return axios.request({
      url: api.zd_report_view,
      data: params,
      method: 'post'
    },{
      cp : 'application/json'
    })
  }

}
