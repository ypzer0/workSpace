import * as types from './mutation-types'
import { api } from '@/service/api'
import {toast} from '@/libs/cube-ui'

export const actions = {
  //检查报告列表
  async reportList ({commit}) {

      let res = await api.zd_report.list();
      
      if (res.success) {
        commit(types.REPORT_LIST, res.data) 
      } else {
        toast(res.msg, 'warn')
      }
  },
  //检查报告下载
  async reportDownLoad ({commit},item) {

    let response = await api.zd_report.download(item.reportPath);
    commit(types.REPORT_DOWNLOAD, response) 
  },
  //检查报告查看
  async reportView ({commit},reportId) {
      var para= {
        id : reportId
      }
      let res = await api.zd_report.view(para);
      
      if (res.success) {
        commit(types.REPORT_VIEW, res.data) 
      } else {
        toast(res.msg, 'warn')
      }
  }
  
}
