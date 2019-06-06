$(function () {
    $("#jqGrid").Grid({
        url: '../Zdopinion/list',
        colModel: [
        	{label: 'id', name: 'id', index: 'id', key: true, hidden: true },
			{label: '用户昵称', name: 'nickname', index: 'nickname', width: 80, align: 'center', sortable: false },
			{label: '用户姓名', name: 'username', index: 'username', width: 80, align: 'center', sortable: false },
			{label: '性别', name: 'gender', index: 'gender', width: 80, align: 'center', sortable: false,
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
			{label: '年龄', name: 'age', index: 'age', width: 80, align: 'center', sortable: false },
			{label: '电话', name: 'mobile', index: 'mobile', width: 80, align: 'center', sortable: false },
			{label: '投诉建议', name: 'opinion', index: 'opinion', width: 100, align: 'center', sortable: false },
			]
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		Zdopinion: {},
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
			vm.Zdopinion = {};
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
            let url = vm.Zdopinion.id == null ? "../Zdopinion/save" : "../Zdopinion/update";
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.Zdopinion),
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
				    url: "../Zdopinion/delete",
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
                url: "../Zdopinion/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.Zdopinion = r.Zdopinion;
                }
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {
                	"nickname": vm.q.nickname
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