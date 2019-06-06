import * as types from './mutation-types'
import { api } from '@/service/api'
import {toast} from '@/libs/cube-ui'

export const actions = {
  //用户注册
  async getRegister ({dispatch, commit, state}, o) {
    //debugger;
      let user;
      if(state.radioChecke.username == ''){
        toast('请填写姓名', 'warn')
        return;
      }else if(state.radioChecke.age == ''){
        toast('请填写年龄', 'warn')
        return;
      }else if(state.radioChecke.code == ''){
        toast('请填写验证码', 'warn')
        return;
      }
      user = {
        username: state.radioChecke.username,
        gender: state.radioChecke.checkedValue,
        age: state.radioChecke.age,
        mobile: state.radioChecke.mobile,
      };
    
      //debugger;
      let res = await api.z_register.register(user)
      
      if (res.success) {
        commit(types.INIT_REGISTER, res.data)
      } else {
        toast(res.msg, 'warn')
      }
      return res;
  },

  //获取手机号发送验证码
  async getSendCode ({dispatch, commit, state}, o) {
    //debugger;
      let user;
      let phone = state.radioChecke.mobile;
      if(phone == ''){
        toast('请填写手机号', 'warn')
        return;
      }else if(!(/^((13[0-9])|(17[0-1,6-8])|(15[^4,\\D])|(18[0-9])|(19[0-9]))\d{8}$/.test(phone))){
        toast('请输入正确的手机号', 'warn')
        return;
      }
      user = {
        mobile: state.radioChecke.mobile,
      };
    
      //debugger;
      let res = await api.z_register.SendCode(user)
      
      if (res.success) {
        commit(types.INIT_SEND_CODE, res.data)
      } else {
        toast(res.msg, 'warn')
      }
  },
  
}
