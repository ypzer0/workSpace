import * as types from './mutation-types'
import { debug } from 'util';

export const mutations = {
  [types.INIT_CART_INFO] (state, a) {
    // @TODO
  },
  [types.TOGGLE_MODEL] (state) {
    state.cart.model = !state.cart.model
  },
  [types.SELECT_GOODS] (state, o) {

    o.select = !o.select;
    if(o.select){
      state.cart.select.push(o)
    }
    else{
      for (let i = 0; i < state.cart.select.length; i++) {
        if (state.cart.select[i].goodsId === o.goodsId) {
          state.cart.select.splice(i, 1)
          break;
        }
      }
    }

  },
  [types.SELECT_GROUP] (state, o) {
    //changeSelect
    o.select = !o.select;
    
    let gid = state.cart.list.filter(i => {
      return i.shopId === o.shopId
    }).map(j => {
      return j.goodsId
    })
    let sid = state.cart.select.map(k => {
      return k.goodsId
    })
    let isAll = true
    for (let l = 0; l < gid.length; l++) {
      if (!sid.includes(gid[l])) {
        isAll = false
        break;
      }
    }
    state.cart.select = state.cart.select.filter(m => {
      return m.shopId !== o.shopId
    })
    if (!isAll) {
      for (let n = 0; n < state.cart.list.length; n++) {
        if (state.cart.list[n].shopId === o.shopId) {
          state.cart.select.push(state.cart.list[n])
        }
      }
    }
    
    o.list.forEach(ele => {
      ele.select = o.select;
    });

  },
  [types.SELECT_ALL] (state) {
    if (state.cart.list.length > state.cart.select.length) {
      state.cart.select = state.cart.list.filter(i => {
        return true
      })
    } else {
      state.cart.select = []
    }

    state.cart.listGroup.forEach(ele => {
      ele.select = true;
      ele.list.forEach(item => {
        item.select = true;
      });
    });

  },
  [types.UPDATE_CART_GOODS_BY_ID] (state, o) {
    for (let i = 0; i < state.cart.list.length; i++) {
      if (state.cart.list[i].goodsId === o.goodsId) {
        state.cart.list[i].number = o.number
        break
      }
    }
    for (let i = 0; i < state.cart.select.length; i++) {
      if (state.cart.select[i].goodsId === o.goodsId) {
        state.cart.select[i].number = o.number
        return
      }
    }
  },
  [types.DELETE_CART_GOODS_BY_IDS] (state, a) {
    state.cart.list = state.cart.list.filter(i => {
      return !a.includes(i.goodsId)
    })
    state.cart.select = state.cart.select.filter(i => {
      return !a.includes(i.goodsId)
    })
  },
  [types.CLEAR_CART] (state, a) {
    state.cart.list = []
    state.cart.select = []
  },
  
  [types.CART_GOODS_CHECKED](state, e){
    
    // state.cart.list = [];
    // e.cartList.forEach(ele => {
    //   state.cart.list.push({
    //     shopId: ele.goods_id,
    //     shopName: ele.goods_name,
    //     goodsId: ele.id,
    //     pic: ele.list_pic_url,
    //     price: ele.retail_price,
    //     number: ele.number,
    //     proId: ele.product_id,
    //     select: ele.checked == 1
    //   });
    // });

  },

  [types.CART_INDEX](state, e){


  },
  [types.LoadCarList](state, e){
    state.cart.select = [];
    state.cart.list = [];
    e.cartList.forEach(ele => {
      state.cart.list.push({
        id: ele.id,
        shopId: ele.goods_id,
        shopName: ele.goods_name,
        goodsId: ele.id,
        pic: ele.list_pic_url,
        price: ele.retail_price,
        number: ele.number,
        proId: ele.product_id,
        select: ele.checked == 1
      });
    });
    //loadSelect
    state.cart.list.forEach(ele => {
      if(ele.select){
        state.cart.select.push(ele);
      }
    });


  },

  [types.LOAD_LIST_GROUP](state, e){
    let map = {}
    let dest = []
    let arr = state.cart.list
    let sid = state.cart.select.map(k => {
      return k.goodsId
    })
    for (let i = 0; i < arr.length; i++) {
      let ai = arr[i]
      if (sid.includes(ai.goodsId)) {
        ai.select = true
      } else {
        ai.select = false
      }
      if (!map[ai.shopId]) {
        dest.push({
          shopId: ai.shopId,
          shopName: ai.shopName,
          list: [ai]
        })
        map[ai.shopId] = ai
      } else {
        for (let j = 0; j < dest.length; j++) {
          let dj = dest[j]
          if (dj.shopId === ai.shopId) {
            dj.list.push(ai)
            break
          }
        }
      }
    }
    for (let k = 0; k < dest.length; k++) {
      let isAll = true
      for (let l = 0; l < dest[k].list.length; l++) {
        if (!sid.includes(dest[k].list[l].goodsId)) {
          isAll = false
        }
      }
      if (isAll) {
        dest[k].select = true
      } else {
        dest[k].select = false
      }
    }
    state.cart.listGroup = dest;
  },
  [types.LOAD_PAY_SUCCESS](state, n){
    state.checkOut.payurl = rt.data.url + "&redirect_url=http://h5.qzhkj.cn";
  }




}
