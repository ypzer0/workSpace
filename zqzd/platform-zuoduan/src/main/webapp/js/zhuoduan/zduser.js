$(function () {
    $("#jqGrid").Grid({
        url: '../Zduser/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true },
			{label: '用户昵称', name: 'nickname', index: 'nickname', width: 80, align: 'center', sortable: false },
			{label: '用户名', name: 'username', index: 'username', width: 80, align: 'center', sortable: false },
			{label: '性别', name: 'gender', index: 'gender', width: 80, sortable: false,
				align: 'center',
				formatter: function (value) {
                	var rt = "";
                	cls = 'info';
                	if (value == '0') {
                    	rt =  '女';
                    } 
                	if (value == '1') {
                    	rt =  '男';
                    } 
                	
                	return '<span>' + rt + '</span>';
                }	
			},
			{label: '手机', name: 'mobile', index: 'mobile', width: 80, align: 'center', sortable: false },
			{label: '年龄', name: 'age', index: 'age', width: 80, align: 'center', sortable: false },
			{label: '状态', name: 'status', index: 'status', width: 80, sortable: false,
				align: 'center',
				formatter: function (value) {
                	var rt = "";
                	var cls = "";
                	cls = 'info';
                	if (value == '0') {
                    	cls = 'warning';
                    	rt =  '黑名单';
                    } 
                	if (value == '1') {
                    	rt =  '正常';
                    }
                	return '<span class="label label-'+ cls +'">' + rt + '</span>';
                }	
			},
			{label: '备注', name: 'remarks', index: 'remarks', width: 80, align: 'center', sortable: false }]
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		Zduser: {},
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
		query: function () {
			vm.reload();
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
            let url = vm.Zduser.id == null ? "../Zduser/save" : "../Zduser/update";
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.Zduser),
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
				    url: "../Zduser/delete",
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
                url: "../Zduser/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.Zduser = r.Zduser;
                    /*if(r.Zduser.lastLoginTime){
                    	vm.Zduser.lastLoginTime=
                    }*/
                }
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {
                	"nickname": vm.q.nickname,
                	"status":vm.q.status,
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