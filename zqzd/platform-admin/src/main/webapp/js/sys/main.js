
var vm = new Vue({
    el: '#rrapp',
    data: {
    	model1 : "",
    	seDay: 5,
    	orderList: [
    		{ label : "近5天" , value : 5 },
    		{ label : "近10天" , value : 10 },
    		{ label : "近20天" , value : 20 },
    		{ label : "近30天" , value : 30 },
    	],
    },
    created: function(){
		
    },
    methods: {
		seChange(n, o){
			window.loadApp(n);
		}
    }
});

$().ready(function(){
	loadApp(5);
})

window.loadApp = function(d){
	if(window.nowPagePower.OrderPower){
		Ajax.request({
		    url: "../Zdeptordereday/list",
	        params: JSON.stringify([ d ]),
	        type: "POST",
		    contentType: "application/json",
	        successCallback: function (d) {
	        	loadChart(d);
	    	    loadTotalOrder(d);
			}
		});
	}
	
	if(window.nowPagePower.CustomerPower) {

		Ajax.request({
		    url: "../Zdeptusereday/list",
	        params: JSON.stringify([ d ]),
	        type: "POST",
		    contentType: "application/json",
	        successCallback: function (d) {
	        	loadCustomerMsg(d);
			}
		});
	}
	
}



var loadCustomerMsg = function(dt){

	var myChart = echarts.init(document.getElementById('userRpt'));
	var option = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['注册人数', '上线人数']
		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : dt.data.src.pro
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'注册人数',
		            type:'line',
		            stack: '总量',
		            data:dt.data.src.reg
		        },
		        {
		            name:'上线人数',
		            type:'line',
		            stack: '总量',
		            data:dt.data.src.online
		        },
		    ]
		};

    myChart.setOption(option);
}

var loadTotalOrder = function(dt){

	var myChart = echarts.init(document.getElementById('orderEveryDay'));
	var option = {
		    tooltip : {
		        trigger: 'axis'
		    },
		    legend: {
		        data:['订单量']
		    },
// 		    toolbox: {
// 		        show : true,
// 		        feature : {
// 		            mark : {show: true},
// 		            dataView : {show: true, readOnly: false},
// 		            magicType : {show: true, type: ['line', 'bar', 'stack', 'tiled']},
// 		            restore : {show: true},
// 		            saveAsImage : {show: true}
// 		        }
// 		    },
		    calculable : true,
		    xAxis : [
		        {
		            type : 'category',
		            boundaryGap : false,
		            data : dt.data.src.pro
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'订单量',
		            type:'line',
		            stack: '总量',
		            data:dt.data.src.all
		        },
		    ]
		};

    myChart.setOption(option);
}



var loadChart = function(dt){

	var myChart = echarts.init(document.getElementById('main'));

	var app = {};

	setTimeout(function () {

	    var option = {

	        legend: {},
	        tooltip: {
	            trigger: 'axis',
	            showContent: false
	        },
	        dataset: {
	            source: [
	                ['product', '2012-1-1', '2012-1-2', '2012-1-3', '2012-1-4', '2012-1-5', '2012-1-6'],
	                ['订单完成数', 22, 92.1, 85.7, 83.1, 73.4, 55.1],
	                ['未完成订单数', 33, 67.2, 79.5, 86.4, 65.2, 82.5],
	                ['失败订单数', 44, 67.1, 69.2, 72.4, 53.9, 39.1]
	            ]
	        },
	        xAxis: {type: 'category'},
	        yAxis: {gridIndex: 0},
	        grid: {top: '55%'},
	        series: [
	            {type: 'line', smooth: true, seriesLayoutBy: 'row'},
	            {type: 'line', smooth: true, seriesLayoutBy: 'row'},
	            {type: 'line', smooth: true, seriesLayoutBy: 'row'},
	            {
	                type: 'pie',
	                id: 'pie',
	                radius: '30%',
	                center: ['50%', '25%'],
	                label: {
	                    formatter: '{b}: {@' + dt.data.fit + '} ({d}%)'
	                },
	                encode: {
	                    itemName: 'product',
	                    value: dt.data.fit,
	                    tooltip: dt.data.fit
	                }
	            }
	        ]
	    };
	    option.dataset.source = [];
	    var dd = [];
	    dd.push("product");
	    dd.addRange(dt.data.src.pro);
	    option.dataset.source.push(dd);
	    
	    dd = [];
	    dd.push("订单完成数");
	    dd.addRange(dt.data.src.comp);
	    option.dataset.source.push(dd);

	    dd = [];
	    dd.push("未完成订单数");
	    dd.addRange(dt.data.src.unfinish);
	    option.dataset.source.push(dd);

	    dd = [];
	    dd.push("失败订单数");
	    dd.addRange(dt.data.src.failed);
	    option.dataset.source.push(dd);
	    
	    myChart.on('updateAxisPointer', function (event) {
	        var xAxisInfo = event.axesInfo[0];
	        if (xAxisInfo) {
	            var dimension = xAxisInfo.value + 1;
	            myChart.setOption({
	                series: {
	                    id: 'pie',
	                    label: {
	                        formatter: '{b}: {@[' + dimension + ']} ({d}%)'
	                    },
	                    encode: {
	                        value: dimension,
	                        tooltip: dimension
	                    }
	                }
	            });
	        }
	    });

	    myChart.setOption(option);
		
	});
	
}