
var root = '/api/'
if(process.env.NODE_ENV === 'development'){
    // root = '/platform/api/'
    // root = '/api/'
    root = ''
}
else{
    root = '/coupon/cpapi/'
}
// export const IS_MOCK = true
export const IS_MOCK = false
export const API_BASE_URL = IS_MOCK ? '/mock/' : (process.env.NODE_ENV === 'development' 
? 
'http://192.168.1.137:8080/platform/zdapi'
: 
'http://yhjwbuy.qzhkj.cn' + root
)

console.log(process.env.NODE_ENV)
export const TOKEN_KEY = 'X-COUPON-BYZY-Token' 
export const HISTORY_KEY = 'History-Key'
//global Data
export const GLOBALDATA_KEY = 'GLOBALDATA_KEY'

