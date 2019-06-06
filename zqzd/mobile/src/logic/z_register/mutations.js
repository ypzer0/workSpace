import * as types from './mutation-types'
import { debug } from 'util';

export const mutations = {
//用户注册
[types.INIT_SEND_CODE] (state, o) {
  state.SendCode = o;
},

}
