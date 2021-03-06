$(function () {
    $("#jqGrid").Grid({
        url: '../Zdeptordereday/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true },
			{label: '总下单数', name: 'total', index: 'total', width: 80, align: 'center', sortable: false },
			{label: '完成订单数', name: 'completed', index: 'completed', width: 80, align: 'center', sortable: false },
			{label: '未完成订单数', name: 'unfinished', index: 'unfinished', width: 80, align: 'center', sortable: false },
			{label: '失败订单数', name: 'failed', index: 'failed', width: 80, align: 'center', sortable: false },
			{label: '统计时间', name: 'ctime', index: 'ctime', width: 80, align: 'center', sortable: false }]
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		ZdeptOrderEday: {},
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
			vm.ZdeptOrderEday = {};
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
            let url = vm.ZdeptOrderEday.id == null ? "../Zdeptordereday/save" : "../Zdeptordereday/update";
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.ZdeptOrderEday),
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
				    url: "../Zdeptordereday/delete",
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
                url: "../Zdeptordereday/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.ZdeptOrderEday = r.ZdeptOrderEday;
                }
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.q.name},
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