export function formatDate (date, fmt) {
    if (/(y+)/.test(fmt)) {
        fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length));
    }
    let o = {
        'M+': date.getMonth() + 1,
        'd+': date.getDate(),
        'h+': date.getHours(),
        'm+': date.getMinutes(),
        's+': date.getSeconds()
    };
    for (let k in o) {
        if (new RegExp(`(${k})`).test(fmt)) {
            let str = o[k] + '';
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : padLeftZero(str));
        }
    }
    return fmt;
};

function padLeftZero (str) {
    return ('00' + str).substr(str.length);
};

/**
 * char 转ascii码并汇总
 *
 * @return {int} 所有字符的总和
 */
export function toAscii (str){
    var rt = 0;
    for(var si in str){
        rt += str[si].charCodeAt();
    }
    return rt;
}

/**
 * 克隆一个数组
 * @param {*} arr 
 */
export function clone(arr) {
    var clonedArray = [];
    var length = arr.length;

    for (var index = 0; index < length; index++) {
        clonedArray[index] = arr[index];
    }

    return clonedArray;
}
