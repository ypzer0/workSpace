import {Validate} from './validate.js'

export class UserValidate extends Validate {
  _rule = {
    mobile: 'require|phone',
    password: 'require'
  }
  _message = {
    'mobile.require': '手机号必填',
    'mobile.phone': '手机号码格式不正确',
    'password.require': '密码必填'
  }
  _scene = {
    login: ['mobile', 'password']
  }
}
