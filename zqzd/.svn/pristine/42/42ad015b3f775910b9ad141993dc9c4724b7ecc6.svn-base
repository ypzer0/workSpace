$(function () {
    $("#jqGrid").Grid({
        url: '../sysoperlog/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true},
//			{label: '标志id', name: 'flag', index: 'flag', width: 80},
			{label: '操作人', name: 'username', index: 'username', width: 80},
			{label: '部门', name: 'deptName', index: 'deptName', width: 80, align: 'center', sortable: false },
			{label: '操作时间', name: 'createDate', index: 'createDate', width: 80, align: 'center', sortable: false,
				formatter: function (value) {
					return transDate(value);
				}
			},
			{label: '行为操作', name: 'name', index: 'name', width: 80, align: 'center', sortable: false },
			{label: '备注', name: 'title', index: 'title', width: 80, align: 'center', sortable: false },
//			{label: '操作名称', name: 'name', index: 'name', width: 80},
//			{label: '请求方法', name: 'title', index: 'title', width: 80},
//			{label: '请求参数', name: 'params', index: 'params', width: 80},
//			{label: '触发时间', name: 'createDate', index: 'create_date', width: 80,
//				formatter: function (value) {
//					return transDate(value);
//				}
//			}
			]
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		sysOperLog: {},
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
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.sysOperLog = {};
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
            let url = vm.sysOperLog.id == null ? "../sysoperlog/save" : "../sysoperlog/update";
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.sysOperLog),
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
				    url: "../sysoperlog/delete",
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
                url: "../sysoperlog/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.sysOperLog = r.sysOperLog;
                }
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
            
            var createDate = vm.q.createDate != '' ? vm.q.createDate.dateFormat("yyyy-MM-dd") : '';
            
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {
                	'username': vm.q.username,
                	'createDate':createDate,
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