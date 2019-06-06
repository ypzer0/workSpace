import * as types from './mutation-types'
import { api } from '@/service/api'

export const actions = {
  async getUserCartInfo ({commit}) {
    let res = await api.cart.getUserCartInfo()
    if (res.success) {
      commit(types.INIT_CART_INFO, res)
    }
  },
  async updateUserCartGoods ({commit}, o) {
    const updateInfo = {
      goodsId: o.goods.goodsId,
      number: o.type === 'sub' ? (parseInt(o.number) - 1) : (parseInt(o.number) + 1)
    }
    let res = await api.cart.updateUserCartGoods()
    if (res.success) {
      commit(types.UPDATE_CART_GOODS_BY_ID, updateInfo)
    }
  },
  async deleteUserCartGoods ({commit}, a) {
    const deleteGoodsIds = a.map(i => {
      return i.goodsId
    })
    let res = await api.cart.deleteUserCartGoods()
    if (res.success) {
      commit(types.DELETE_CART_GOODS_BY_IDS, deleteGoodsIds)
    }
  },

  async cartAdd ({commit}, a) {
    var params = {
      goodsId: a.goodsId,
      productId: a.productId,
      number: a.number
    };
    let res = await api.cart.cartAdd(params)
    return res;
  },
  
  async checkout ({commit}, a) {
    let res = await api.cart.checkout(a)
    if (res.success) {
      
      return res.data;
    }
  },
  async getCheckoutInfo ({commit}, n) {
    let res = await api.cart.getCheckoutInfo()
    if (res.success) {
      return res.data
    }
  },
  async pay ({dispatch, commit}, n) {
    // 具体的支付逻辑，包括微信，支付宝支付，业务服务器的逻辑
    // 清空购物车数据， 重新获取购物车信息
    commit(types.CLEAR_CART)

    return dispatch('SubmitOrder', n.addr)
    // dispatch('getUserCartInfo')
  },
  async getTransactionInfo ({commit}, n) {
    
    let res = await api.cart.getTransactionInfo(n)
    return res
  },
  async getAddressList({commit}, n){

    let res = await api.addr.getAddressList()
    if (res.success) {
      
      //添加isCheck 属性
      if(res.data.length != 0){
        for (let i = 0; i < res.data.length; i++) {
          const ele = res.data[i];
          ele.isCheck = false;
        }
      }
      return res.data
    }

  },
  async getAddressDetail({commit}, n){
    var para = {
      id: n.id
    }
    let res = await api.addr.getAddressDetail(para)
    if (res.success) {
      return res.data
    }
  },
  async SaveAddress({commit}, n){
    let res = await api.addr.SaveAddress(n)
    return res;
  },
  async SubmitOrder({commit}, n){
    let res = await api.order.submitOrder(n)
    return res;
  },
  
  async paySubmit({commit}, n){
    var para ={
      orderId : n.oid
    }
    let res1 = await api.order.pay(para)
    return res1;
  },

  async LoadCar({dispatch, commit}, n){
    
    let res = await api.cart.LoadCar(n)
    if (res.success) {
      commit(types.LoadCarList, res.data)
      commit(types.LOAD_LIST_GROUP, res.data)
    }
  },

  async GoodsChecked({commit}, n){

    let res = await api.cart.GoodsChecked(n)
    if (res.success) {
      // commit(types.CART_GOODS_CHECKED, res.data)
      commit(types.LoadCarList, res.data)
      commit(types.LOAD_LIST_GROUP, res.data)
    }
  },

  async UpdateGoodsNumber({commit}, n){
    var cnum = n.number;
    if(n.type == 'add'){
      cnum = cnum + 1;
    }
    else{
      cnum = cnum - 1;
    }

    var paras = {
      "productId": n.goods.proId,
      "goodsId": n.goods.goodsId,
      "number": cnum,
      "id": n.goods.id
    }
    let res = await api.cart.UpdateGoodsNumber(paras)
    if (res.success) {
      // commit(types.CART_GOODS_CHECKED, res.data)
      commit(types.LoadCarList, res.data)
      commit(types.LOAD_LIST_GROUP, res.data)
    }
  },
  
  async CartDelete({commit}, n){

    var proids = [];

    n.forEach(ele => {
      if(ele.select){
        proids.push(ele.proId);
      }
    });
    if(proids.length == 0){
      return { code: 0};
    }

    var paras = {
      productIds: proids.join(',')
    }
    let res = await api.cart.CartDelete(paras)
    if (res.success) {
      // commit(types.CART_GOODS_CHECKED, res.data)
      commit(types.LoadCarList, res.data)
      commit(types.LOAD_LIST_GROUP, res.data)
    }
    return { code : 1 };
  },
  
  
  
}
