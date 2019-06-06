
    let vm = new Vue({
        el: '#rrapp',
        data: {
            smsLog: {
                sendType: 'temp',
                temp: 0
            },
            ruleValidate: {
                content: [
                    {required: true, message: '发送内容不能为空', trigger: 'blur'}
                ],
                mobile: [
                    {required: true, message: '手机号码不能为空', trigger: 'blur'}
                ],
//                 template: [
//                     {required: true, message: '请选择一个模板'}
//                 ]
            },
            templist: []
        },
        methods: {
            handleSubmit: function (name) {
                handleSubmitValidate(this, name, function () {
                    vm.send();
                });
            },
            handleReset: function (name) {
                handleResetForm(this, name);
            },
            send: function () {
            	if(this.smsLog.temp == null || this.smsLog.temp == ''){
                    alert('请选择一个模板');return;
            	}
                let url = "../sys/smslog/sendSms";
                
                var temp = vm.getTempById(vm.smsLog.temp);
                
                for(var i in temp.vars){
                	if(temp.vars[i].val === ''){
                        alert('请配置变量${' + temp.vars[i].key + '}的值');return;
                	}
                }
                Ajax.request({
                    url: url,
                    params: JSON.stringify($.extend(vm.smsLog, { tempData : temp.vars })),
                    contentType: "application/json",
                    type: 'POST',
                    successCallback: function () {
                        alert('提交成功', function (index) {
                            vm.handleReset('formValidate');
                        });
                    }
                });
            },
            getTemplateVar: function(){
            	
	           	for(var k in this.templist){
	           		var vars = [];
			       	var reg=/\$\{\s*(\w+)\s*\}/g;
			        var str=this.templist[k].content;
			       	var arr=reg.exec(str);
		        	while(arr){
// 	        	        console.dir(arr);
// 	        	        console.dir(arr[1]);
// 	        	        console.log("lastIndex:"+reg.lastIndex);
		        	    vars.push({ key : arr[1], val : '' });
	        	        arr=reg.exec(str);
	        	    }
		        	this.templist[k].vars = vars;
	           	}
	           	
            },
            getTempById: function(id){
            	var rt = {};

	           	for(var k in this.templist){
					if(this.templist[k].id === id){
						return this.templist[k]; 
					}
	           	}
            	return rt;
            }
        },
        created(){
        	var nowvm = this;
        	let url = "../smstemp/queryAll";
            Ajax.request({
                url: url,
                params: { status: 2 },
                contentType: "application/json",
                type: 'POST',
                successCallback: function (d) {
                	if(d.code == 0){
						nowvm.templist = d.list;
						nowvm.getTemplateVar();
                	}
                }
            });
        	
        	
        	
        }
    });