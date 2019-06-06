$(function () {
    $("#jqGrid").Grid({
        url: '../Zdquestion/list',
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true },
			{label: '用户昵称', name: 'nickname', index: 'nickname', width: 80, align: 'center', sortable: false },
			{label: '用户姓名', name: 'username', index: 'username', width: 80, align: 'center', sortable: false },
			{label: '性别', name: 'gender', index: 'gender', width: 80, align: 'center', sortable: false },
			{label: '年龄', name: 'age', index: 'age', width: 80, align: 'center', sortable: false },
			{label: '电话', name: 'mobile', index: 'mobile', width: 80, align: 'center', sortable: false },
			{label: '状态', name: 'answerStatus', index: 'answer_status', width: 80, sortable: false,
				align: 'center',
				formatter: function (value) {
                	var rt = "";
                	var cls = "";
                	//cls = 'info';
                	if (value == '0') {
                    	cls = 'warning';
                    	rt =  '未回复';
                    } else if (value == '1') {
                    	rt =  '已回复';
                    }
                    else{
                        rt =  '-';
                    }
                	return '<span class="label label-'+ cls +'">' + rt + '</span>';
                }	
			},
			{label: '基本问题', name: 'consultation', index: 'consultation', width: 80, align: 'center', sortable: false },
			{label: '检查状态', name: 'checkStatus', index: 'check_status', width: 80, sortable: false,
				align: 'center',
				formatter: function (value) {
                	var rt = "";
                	var cls = "";
                	//cls = 'info';
                	if (value == '0') {
                    	cls = 'warning';
                    	rt =  '未接受过检查';
                    } else if (value == '1') {
                    	rt =  '接受过检查';
                    }
                    else{
                        rt =  '-';
                    }
                	return '<span class="label label-'+ cls +'">' + rt + '</span>';
                }	
			},
			{label: '检查或治疗的基本情况', name: 'checkInfo', index: 'check_info', width: 80, align: 'center', sortable: false },
			{label: '想获得怎样的帮助', name: 'helpInfo', index: 'help_info', width: 80, align: 'center', sortable: false }
		]
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		Zdquestion: {},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: ''/*,
		    nickname:'',
		    answerStatus:''*/
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
            vm.title = "回复";

            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
            let url = vm.Zdquestion.id == null ? "../Zdquestion/save" : "../Zdquestion/update";
            
            Ajax.request({
			    url: url,
                params: JSON.stringify(vm.Zdquestion),
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
				    url: "../Zdquestion/delete",
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
                url: "../Zdquestion/info/"+id,
                async: true,
                successCallback: function (r) {
                    vm.Zdquestion = r.Zdquestion;
                    if(r.Zdquestion.checkStatus=="0"){
                    	vm.Zdquestion.checkMsg="未接受过检查"
                    }
                    if(r.Zdquestion.checkStatus=="1"){
                    	vm.Zdquestion.checkMsg="接受过检查"
                    }
                }
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {
                	"nickname": vm.q.nickname,
                	"answerStatus":vm.q.answerStatus,
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