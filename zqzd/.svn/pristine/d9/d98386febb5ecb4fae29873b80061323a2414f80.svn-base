import * as types from './mutation-types'

export const mutations = {
  //用户注册
  [types.REPORT_LIST] (state, o) {
    state.reportList = o.reportList;
  },
  [types.REPORT_DOWNLOAD] (state, response) {
    const url = window.URL.createObjectURL(new Blob([response.data]));
    const link = document.createElement('a');
    // 返回的header Content-Disposition:attachment; filename=elmeast-report-2018-2.pdf
    let head = response.headers['content-disposition'];
    let fname = 'report.pdf';
    if (head) {
        try {
            fname = head.split(';')[1].split('=')[1]
        } catch (err){
            console.log('can not get pdf name');
        }
    }
    link.href = url;
    link.setAttribute('download', fname);
    document.body.appendChild(link);
    link.click();
  },
  [types.REPORT_VIEW] (state, o) {
    state.report=o;
  }

}
