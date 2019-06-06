$(function () {
    $("#jqGrid").Grid({
        url: '../couponuser/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true, align: 'center', sortable: false},
			{label: '用户id', name: 'uCode', index: 'u_code', align: 'center', sortable: false,
				formatter: function (value, dt, rowObject) {
					var plat = rowObject.platType == 1 ? "DX" : "HY";
                    return plat + value;
                }
			},
			{label: '昵称', name: 'nickname', index: 'nickname', width: 80, align: 'center', sortable: false},
			{label: '性别', name: 'gender', index: 'gender', width: 80, align: 'center', sortable: false,
				formatter: function (value) {
                	var rt = "";
                	var cls = "";
					if(value == 0){
						cls = "success";
						rt = "女";
					}
					else if(value == 1){
						cls = "error";
						rt = "男";
					}
					else{
						rt = "未知";
					}
                	return '<span class="label label-'+ cls +'">' + rt + '</span>';
				}
			},
			{label: '年龄', name: 'age', index: 'age', width: 80, align: 'center', sortable: false},
			{label: '注册时间', name: 'registerTime', index: 'u.register_time', width: 80, align: 'center',
				formatter: function (value) {
					return transDate(value);
				}
			},
			{label: '手机', name: 'mobile', index: 'mobile', width: 80, align: 'center', sortable: false},
			{label: '微信号', name: 'weixinCode', index: 'weixin_code', width: 80, align: 'center', sortable: false},
			{label: '支付宝', name: 'zhifubao', index: 'zhifubao', width: 80, align: 'center', sortable: false},
			{label: '状态', name: 'status', index: 'status', width: 80, align: 'center', sortable: false,
				align: 'center',
				formatter: function (value) {
                	var rt = "";
                	var cls = "";
                	cls = 'success';
                	if (value == '0') {
                    	rt =  '正常';
                    } else if (value == '1') {
                    	rt =  '禁用';
                    	cls = 'warning';
                    } else if (value == '2') {
                    	rt =  '已删除';
                    } 
                    else{
                        rt =  '-';
                    }
                	return '<span class="label label-'+ cls +'">' + rt + '</span>';
                }	
			},
			{label: '成功售出（件）', name: 'sucOut', index: '', width: 80, align: 'center', sortable: false},
			{label: '未售出（件）', name: 'notOut', index: '', width: 80, align: 'center', sortable: false},
			{label: '一共售出（元）', name: 'sucOutMoney', index: '', width: 80, align: 'center', sortable: false},

			/*{label: '用户名', name: 'username', index: 'username', width: 80},
			{label: '密码', name: 'password', index: 'password', width: 80},
			{label: '最后登录时间', name: 'lastLoginTime', index: 'last_login_time', width: 80},
			{label: '最后登录 ip', name: 'lastLoginIp', index: 'last_login_ip', width: 80},
			{label: '用户级别', name: 'userLevelId', index: 'user_level_id', width: 80},
			{label: '注册ip', name: 'registerIp', index: 'register_ip', width: 80},
			{label: '头像', name: 'avatar', index: 'avatar', width: 80},
			{label: '微信openid', name: 'weixinOpenid', index: 'weixin_openid', width: 80},
			{label: '平台标识编码：1: 鼎鑫权益用户DX开头  2:惠友圈用户 HY开头', name: 'platType', index: 'plat_type', width: 80},
			{label: '用户编号id', name: 'codeId', index: 'code_id', width: 80},
			{label: '用户信用积分', name: 'multiple', index: 'multiple', width: 80},
			{label: '积分', name: 'credit', index: 'credit', width: 80},
			{label: '推广倍数 分倍数', name: 'integral', index: 'integral', width: 80}*/]
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        showMsg: false,
        title: null,
		Couponuser: {},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: '',
		    uCode: ''
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.Couponuser = {};
		},
		update: function (event) {
            let id = getSelectedRow("#jqGrid");
			if (id == null) {
				return;
			}
			vm.showList = false;
        	vm.showMsg = false;
            vm.title = "修改";

            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
            let url = vm.Couponuser.id == null ? "../couponuser/save" : "../couponuser/update";
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.Couponuser),
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
				    url: "../couponuser/delete",
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
                url: "../couponuser/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.Couponuser = r.Couponuser;
                }
            });
		},
		reload: function (event) {
			vm.showList = true;
			var code = "";
			if(vm.q.uCode !== undefined && vm.q.uCode != null){
				code = vm.q.uCode.replace(/[a-zA-Z]+/gi, "");
			}
			
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.q.name, 'uCode': code},
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
        },
        moreMsg: function(){

            let id = getSelectedRow("#jqGrid");
			if (id == null) {
				return;
			}
        	vm.showList = false;
        	vm.showMsg = true;
            vm.title = "更多信息";

            Ajax.request({
                url: "../couponuser/moremsg/"+id,
                async: true,
                successCallback: function (r) {
                    vm.Couponuser = r.user;
                }
            });
        	
        }
	}
});