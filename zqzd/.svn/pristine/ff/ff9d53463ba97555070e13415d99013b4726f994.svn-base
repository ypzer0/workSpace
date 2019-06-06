<template>
  <div>
    <section class="showChose">
      <section class="address">
        <section class="title">
          <h4>收货地址</h4>
          <span @click="closeAdd()">×</span>
        </section>
        <section class="title">
          <div class="area" @click="provinceSelected()">{{areaD.checkedP.name === undefined ? '请选择' : areaD.checkedP.name}}</div>
          <div class="area" @click="citySelected()" :class="areaD.checkedC.name === undefined?'':'active'">{{areaD.checkedC.name === undefined ?'请选择': areaD.checkedC.name}}</div>
          <div
            class="area"
            @click="districtSelected()"
            :class="areaD.checkedD.name === undefined?'':'active'"
          >{{areaD.checkedD.name === undefined?'请选择':areaD.checkedD.name}}</div> 
        </section>
        <ul>
          <li
            class="addList"
            :key="k"
            v-for="(v,k) in areaD.provinceList"
            @click="provinceItemSelected(v.id, v.name, k, v)"
            v-show="areaD.showProvince"
            :class="v.selected ? 'active' : ''"
          >{{v.name}}</li>
          <li
            class="addList"
            :key="'c' + k1"
            v-for="(v,k1) in areaD.cityList"
            @click="cityItemSelected(v.id, v.name, k1, v)"
            v-show="areaD.showCity"
            :class="v.selected ? 'active' : ''"
          >{{v.name}}</li>
          <li
            class="addList"
            :key="'d' + k2"
            v-for="(v,k2) in areaD.districtList"
            @click="distriItemSelected(v.id, v.name, k2, v)"
            v-show="areaD.showDistrict"
            :class="v.selected ? 'active' : ''"
          >{{v.name}}</li> 
        </ul>
      </section>
    </section>
  </div>
</template>

<script type="text/ecmascript-6">
import {mapState, mapActions} from 'vuex'
import {api} from '@/service/api'
export default {
  props: ["pName", "cName", "dName"],
  data() {
    return {
      
        areaD:{
            
            provinceList:[],
            cityList: [],
            districtList: [],

            checkedP: {},
            checkedC: {},
            checkedD: {},

            showProvince: true,
            showCity: false,
            showDistrict: false,
        }

    };

  },
  created(){
    if(this.pName != undefined && this.pName != null){
        this.loadIndex();
    }
    else{
        this.getProvince();
    }

  },
  methods: {
    loadIndex(){
        this.getProvince().then(res => {
            
            if(res.success){
                var nowProvince = null;
                res.data.forEach(ele => {
                    if(ele.name == this.pName){
                        nowProvince = ele;
                        return false;
                    }
                });
                
                if(nowProvince != null){
                    this.provinceItemSelected(null, nowProvince.name, null, nowProvince).then(ct => {

                        var nowCity = null;
                        ct.data.forEach(ele => {
                            if(ele.name == this.cName){
                                nowCity = ele;
                                return false;
                            }
                        });
                        if(nowCity != null){
                            this.cityItemSelected(null, nowCity.name, null, nowCity).then(dt => {
                                
                                var nowDt = null;
                                dt.data.forEach(ele => {
                                    if(ele.name == this.dName){
                                        nowDt = ele;
                                        return false;
                                    }
                                });
                                if(nowDt != null){
                                    this.distriItemSelected(null , nowDt.name, null, nowDt);
                                }
                            });

                        }


                    });
                }

            }

        });

    },
    showChange(p, c, d){
        this.areaD.showProvince = p;
        this.areaD.showCity = c;
        this.areaD.showDistrict = d;
    },
    async getProvince ( o) {
        let rt = api.region.getProvince()
        rt.then(res=>{

            if(res.success){
                res.data.forEach(ele => {
                    ele.selected = false;
                });
                this.loadProvince(res.data);
            }
        });
        return rt;
    },
    loadProvince(o){
        this.areaD.provinceList = o;
        if(this.areaD.checkedP.id == undefined && o.length > 0)
        this.areaD.checkedP = o[0];
        this.showChange(true, false, false);
    },
    async getCity ( o) {
        let rt = api.region.getCity(o);
        rt.then(res=>{

            if(res.success){
                res.data.forEach(ele => {
                    ele.selected = false;
                });
                this.loadCity(res.data);
            }
        });
        return rt;
    },
    loadCity(o){

        this.areaD.cityList = o;
        if(this.areaD.checkedC.id == undefined && o.length > 0)
        this.areaD.checkedC = o[0];
        
        this.showChange(false, true, false);

    },
    
    async getDistinct (o) {
        let rt = api.region.getDistinct(o);
        rt.then(res=>{
            if(res.success){
                res.data.forEach(ele => {
                    ele.selected = false;
                });
                this.loadDistinct(res.data);
            }
        });
        return rt;
    },
    loadDistinct(o){
        
        this.areaD.districtList = o;
        if(this.areaD.checkedD.id == undefined && o.length > 0)
        this.areaD.checkedD = o[0];
        
        this.showChange(false, false, true);
    },

    provinceSelected: function() {
        this.areaD.cityList = [];
        this.areaD.districtList = [];

        this.areaD.checkedC = {};
        this.areaD.checkedD = {};

        this.showChange(true, false, false);
        this.change();
    },
    provinceItemSelected: function(id, n, k ,d){
        
        this.areaD.provinceList.forEach(ele => {
            ele.selected = false;
        });

        d.selected = true;
        this.areaD.checkedP = d;
        
        this.change();
        return this.getCity({
            proviceName: n
        });

    },

    citySelected: function() {

        this.areaD.districtList = [];
        this.areaD.checkedD = {};

        this.showChange(false, true, false);
        this.change();

    },
    cityItemSelected: function(id, n, k ,d){
        
        this.areaD.cityList.forEach(ele => {
            ele.selected = false;
        });
        d.selected = true;
        this.areaD.checkedC = d;
        this.change();
        return this.getDistinct({
            proviceName: this.areaD.checkedP.name,
            cityName: n
        });
    },
    districtSelected: function() {
        this.showChange(false, false, true);
        this.change();
    },
    distriItemSelected: function(id, n, k ,d){
        
        this.areaD.districtList.forEach(ele => {
            ele.selected = false;
        });
        this.areaD.checkedD = d;
        d.selected = true;
        
        this.change();
    },

    closeAdd: function() {
        this.change();
    },
    change: function() {
        var d = {
            p : this.areaD.checkedP,
            c : this.areaD.checkedC,
            d : this.areaD.checkedD,
        }
        this.$emit("change", d);
    }
  }
};
</script>

<style lang="less" scoped>
.myAddress {
  width: 100%;
  background-color: white;
  border-top: 4px solid rgba(245, 245, 245, 1);
  color: #333;
  .cont {
    border-bottom: 1px solid rgba(245, 245, 245, 0.8);
    span {
      display: inline-block;
      font-size: 0.28rem;
      color: #333;
      line-height: 0.88rem;
      margin-left: 0.32rem;
    }
    section {
      float: left;
    }
    p {
      display: inline-block;
      font-size: 0.28rem;
      color: #333333;
      line-height: 0.88rem;
      margin-left: 1rem;
    }
    .pic2 {
      float: right;
      width: 0.14rem;
      height: 0.24rem;
      margin: 0.32rem 0.32rem 0.32rem 0;
    }
    p {
      .text {
        margin-left: 0.72rem;
      }
    }
  }
}
.showChose {
  width: 100%;
  background: rgba(77, 82, 113, 0.8);
}
.address {
  background: #fff;

  ul {
    width: 95%;
    height: 300px;
    overflow-y: scroll;
    overflow-x: hidden;
    // li {
    //    margin-left: 5%;
    // }
    .active {
      color: #0071b8;
    }
  }

  .title {
    .active {
      color: #0071b8;
      border-bottom: 0.02rem solid #0071b8;
    }
  }
}
.title {
  h4 {
    display: inline-block;
    margin-left: 3.2rem;
    font-size: 0.32rem;
    line-height: 0.88rem;
    font-weight: normal;
    color: #999;
  }
  span {
    margin: 0.42rem 0 0 2.2rem;
    font-size: 0.45rem;
    line-height: 0.34rem;
    color: #d8d8d8;
  }
}
.area {
  display: inline-block;
  font-size: 0.24rem;
  line-height: 0.88rem;
  margin-left: 0.42rem;
  color: #333;
}

.addList {
  width: 100%;
  padding-left: 0.32rem;
  font-size: 0.34rem;
  line-height: 0.88rem;
  color: #333;
}
</style>