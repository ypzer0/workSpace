import Cookies from 'js-cookie'
import Vue from 'vue'
import {GLOBALDATA_KEY} from '@/config/app'

//must set object 
Vue.prototype.$setGlobal = Vue.$setGlobal = function (dt) {
    Cookies.set(GLOBALDATA_KEY, dt)
}

Vue.prototype.$cleanGlobal = Vue.$cleanGlobal = function () {
    Cookies.remove(GLOBALDATA_KEY)
}

Vue.prototype.$getGlobal = Vue.$getGlobal = function () {
    var dt = Cookies.get(GLOBALDATA_KEY);
    if(dt == undefined) dt = {};
    else{
        dt = 'dt = ' + dt;
        eval(dt);
    }
    return eval(dt);
}
