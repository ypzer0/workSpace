import Axios from 'axios'
import Cookies from 'js-cookie'
import {API_BASE_URL, TOKEN_KEY} from '@/config/app'
import {toast} from '@/libs/cube-ui'
import Vue from 'vue'
import qs from 'qs'

class httpRequest {
  constructor () {
    this.options = {
      method: '',
      url: ''
    }
    // 存储请求队列
    this.queue = {}
  }

  // 销毁请求实例
  destroy (url) {
    delete this.queue[url]
    const queue = Object.keys(this.queue)
    return queue.length
  }

  // 请求拦截
  interceptors (instance, url) {
    // 添加请求拦截器
    instance.interceptors.request.use(config => {
      //
      // config.headers['X-Qzh-Hfive'] = "1"
      if (!config.url.includes('/users')) {
        config.headers['X-COUPON-BYZY-Token'] = Cookies.get(TOKEN_KEY)
      }
      // Spin.show()
      // 在发送请求之前做些什么
      
      return config
    }, error => {
      // 对请求错误做些什么
      return Promise.reject(error)
    })

    // 添加响应拦截器
    instance.interceptors.response.use((res) => {
      let {data} = res
      const is = this.destroy(url)
      if (!is) {
        setTimeout(() => {
          // Spin.hide()
        }, 500)
      }
      if (!(data instanceof Blob)) {
        if (data.code !== 200) {
          // 后端服务在个别情况下回报201，待确认
          if (data.code === 401) {
            Cookies.remove(TOKEN_KEY)
            toast('请重新登录', 'warn')
            Vue.$go('/y-login')
            // @TODO
          } else {
            if (data.msg) {
              // @TODO
              toast(data.msg, 'warn')
            }
          }
          return data
        }
      }
      return data
    }, (error) => {
      // 对响应错误做点什么
      return Promise.reject(error)
    })
  }

  // 创建实例
  create (oopt) {
    let conf = {
      baseURL: API_BASE_URL,
      timeout: 2000,
      headers: {
        'Content-Type': 'application/x-www-form-urlencoded; charset=utf-8',
        'X-URL-PATH': location.pathname
      }
    }
    if(oopt && oopt != null){
      if(oopt.cp && oopt.cp != null){
        conf.headers["Content-Type"] = oopt.cp;
      }
    }
    return Axios.create(conf)
  }

  // 合并请求实例
  mergeReqest (instances = []) {
    //
  }

  // 请求实例
  request (options, oopt) {
    var instance = this.create(oopt)
    this.interceptors(instance, options.url)
    options = Object.assign({}, options)
    this.queue[options.url] = instance
    if(options.method && options.method == 'post' && options.data != undefined && options.data != null){
      var tp = '';
      if(oopt && oopt != null){
        if(oopt.cp && oopt.cp != null){
          tp = oopt.cp;
        }
      }
      
      if(tp == 'application/json'){
        
      }
      else{
        var params = new URLSearchParams();
        for(var k in options.data){
          params.append(k, options.data[k]);
        }
        options.data = params;
      }
    }
    return instance(options)
  }
}

export default httpRequest
