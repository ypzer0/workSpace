import * as types from './mutation-types'
import { debug } from 'util';

export const mutations = {
//首页检测服务导航
[types.INIT_GOODS_CATEGORY] (state, o) {
  state.goodsCategory = o.categoryList;
  //debugger;
},

//首页检测服务商品
[types.INIT_HOME] (state, o) {
  state.home = o.goodsList;
},

}
