$(function () {
    $("#jqGrid").Grid({
        url: '../Zddepartment/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true },
			{label: '科室名称', name: 'departmentName', index: 'department_name', width: 80, align: 'center', sortable: false },
			{label: '医院名称', name: 'hospitalName', index: 'hospital_name', width: 80, align: 'center', sortable: false },
			{label: '添加时间', name: 'addTime', index: 'add_time', width: 80, sortable: false, align: 'center',
				formatter: function (value) {
					return transDate(value);
				}	
			}
		]
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		Zddepartment: {},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		hospitalCategory: [],
		q: {
		    name: ''
		}
	},
	methods: {
		loadHospital: function(){
			Ajax.request({
			    url: "../Zddepartment/selectHospital",
                params: '',
                type: "POST",
			    contentType: "application/json",
                successCallback: function (r) {
                	this.hospitalCategory = [
                		{ key: '', val: '请选择-医院'}
                	];
                	vm.hospitalCategory.addRange(r.list);
				}
			});
		},
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.Zddepartment = {};
			vm.loadHospital();
		},
		update: function (event) {
            let id = getSelectedRow("#jqGrid");
			if (id == null) {
				return;
			}
			vm.showList = false;
            vm.title = "修改";
            vm.loadHospital();
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
            let url = vm.Zddepartment.id == null ? "../Zddepartment/save" : "../Zddepartment/update";
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.Zddepartment),
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
				    url: "../Zddepartment/delete",
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
                url: "../Zddepartment/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.Zddepartment = r.Zddepartment;
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