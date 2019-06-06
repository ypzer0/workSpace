$(function () {
    $("#jqGrid").Grid({
        url: '../Zdorder/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true },
			{label: '商品名称', name: 'goodsName', index: 'goods_name', width: 80, align: 'center', sortable: false },
			{label: '订单状态', name: 'orderStatus', index: 'order_status', width: 80, sortable: false,
				align: 'center',
				formatter: function (value) {
                	var rt = "";
                	var cls = "";
                	cls = 'info';
                	if (value == '0') {
                		cls = 'warning';
                    	rt =  '未支付';
                    }
                	if (value == '1') {
                    	rt =  '支付成功';
                    }
                	if (value == '2') {
                		cls = 'danger';
                    	rt =  '支付失败';
                    } 
                	return '<span class="label label-'+ cls +'">' + rt + '</span>';
                }	
			},
			{label: '用户昵称', name: 'nickname', index: 'nickname', width: 80, align: 'center', sortable: false },
			{label: '订单金额', name: 'orderPrice', index: 'order_price', width: 80, align: 'center', sortable: false },
			{label: '下单数量', name: 'orderNumber', index: 'order_number', width: 80, align: 'center', sortable: false },
			{label: '订单编号', name: 'orderSn', index: 'order_sn', width: 80, align: 'center', sortable: false },
			{label: '下单时间', name: 'confirmTime', index: 'confirm_time', width: 80, sortable: false, align: 'center',
				formatter: function (value) {
					return transDate(value);
				}	
			}
		],
		footerrow: true,
		gridComplete: function() {
        },
        loadComplete: function(xhr){
    		
        	var total = {
        		totalPrice: 0,
        		successfulPrice:0
        	};
        	if(xhr.total != null){
        		total.totalPrice = xhr.total.totalPrice;
        		total.successfulPrice=xhr.total.successfulPrice;
        	}
			var rows = $("#jqGrid").jqGrid("getRowData");
        	$("#jqGrid").jqGrid("footerData", "set", { 
        		nickname : "总金额：",
        		orderPrice:"￥"+total.totalPrice,
        		orderNumber : "成功金额：" ,
        		orderSn:"￥"+total.successfulPrice
        	});
        }
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		Zdorder: {},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: ''
		}
	},
	methods: {
		handleTime: function(value){
			value="1111";
		}
		,
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.Zdorder = {};
		},
		update: function (event) {
            let id = getSelectedRow("#jqGrid");
			if (id == null) {
				return;
			}
			vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
            let url = vm.Zdorder.id == null ? "../Zdorder/save" : "../Zdorder/update";
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.Zdorder),
                type: "POST",
			    contentType: "application/json",
                successCallback: function (r) {
                    alert('操作成功', function (index) {
                        vm.reload();
                    });
                }
			});
		},
		del: function (event) {
            let ids = getSelectedRows("#jqGrid");
			if (ids == null){
				return;
			}

			confirm('确定要删除选中的记录？', function () {
                Ajax.request({
				    url: "../Zdorder/delete",
                    params: JSON.stringify(ids),
                    type: "POST",
				    contentType: "application/json",
                    successCallback: function () {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
					}
				});
			});
		},
		getInfo: function(id){
            Ajax.request({
                url: "../Zdorder/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.Zdorder = r.Zdorder;
                }
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {
                	"goodsName": vm.q.goodsName,
                	"orderSn": vm.q.orderSn,
                	"orderStatus": vm.q.orderStatus,
                },
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
		},
        reloadSearch: function() {
            vm.q = {
                name: ''
            }
            vm.reload();
        },
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        }
	}
});