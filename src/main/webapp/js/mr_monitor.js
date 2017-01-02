

/**
 * 刷新
 */
function monitor_one_refresh(){
	$.ajax({ // ajax提交
		url : 'cloud/cloud_monitorone.action',
		dataType : "json",
		success : function(data) {
			if (data.finished == 'error') {// 获取信息错误 ，返回数据设置为0，否则正常返回
				clearInterval(monitor_cf_interval);
				
				console.info("monitor,finished:"+data.finished);
				$.messager.show({
					title : '提示',
					msg : '任务运行失败！'
				});
				setJobInfoValues(data);
			} else if(data.finished == 'true'){
				// 所有任务运行成功则停止timer
				console.info('monitor,data.finished='+data.finished);
				setJobInfoValues(data);
				clearInterval(monitor_cf_interval);
				$.messager.show({
					title : '提示',
					msg : '所有任务成功运行完成！'
				});
				
			}else{
				// 设置提示，并更改页面数据,多行显示job任务信息
				setJobInfoValues(data);
			}
		}
	});
	
}


function setJobInfoValues(data){
	if(typeof data.jobnums == 'undefined'){
		$('#jobnums').val("0");
	}else{
		$('#jobnums').val(data.jobnums);
	}
	if(typeof data.currjob == 'undefined'){
		$('#currjob').val('0');
	}else{
		$('#currjob').val(data.currjob);
	}
	if(typeof data.rows.jobId == 'undefined'){
		$('#jobid').val("#");
	}else{
		$('#jobid').val(data.rows.jobId);
	}
	if(typeof data.rows.jobName == 'undefined'){
		$('#jobname').val("#");
	}else{
		$('#jobname').val(data.rows.jobName);
	}
//	(n*100).toFixed(2)+"%" // 保留两位小数，同时转为百分数
	if(typeof data.rows.mapProgress == 'undefined'){
		$('#mapprogress').val('0.0'+'%');
	}else{
		$('#mapprogress').val((data.rows.mapProgress*100).toFixed(2)+'%');
	}
	if(typeof data.rows.redProgress == 'undefined'){
		$('#redprogress').val('0.0'+'%');
	}else{
		$('#redprogress').val((data.rows.redProgress*100).toFixed(2)+'%');
	}
	if(typeof data.rows.runState == 'undefined'){
		$('#state').val("#");
	}else{
		$('#state').val(data.rows.runState);
	}
}


function callByAJaxLocal_findbestdc(url,data_){
	$.ajax({
		url : url,
		data: data_,
		async:true,
		dataType:"json",
		context : document.body,
		success : function(data) {
//			$.messager.progress('close');
			closeProgressbar();
			console.info("data.dbOrFile:"+data.flag);
			var retMsg;
			if("true"==data.flag){
				retMsg='操作成功！DC阈值为：'+data.dc;
				$('#dc_return_id').html("推荐DC阈值为："+data.dc);
			}else{
				retMsg='操作失败！失败原因：'+data.msg;
			}
			$.messager.show({
				title : '提示',
				msg : retMsg
			});
			
		}
	});
}