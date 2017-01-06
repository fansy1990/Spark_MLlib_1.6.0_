
// 全局函数


// 弹出progressBar
// 
function popupProgressbar(titleStr,msgStr,intervalStr){
	$.messager.progress({
        title:titleStr,
        msg:msgStr,
        interval:intervalStr    //设置时间间隔较长 
    });
}
// 关闭progressBar
function closeProgressbar(){
	$.messager.progress('close');
}


// 调用ajax异步提交
// 任务返回成功，则提示成功，否则提示失败的信息
function callByAJax(url,data_){
	$.ajax({
		url : url,
		data: data_,
		async:true,
		dataType:"json",
		context : document.body,
		success : function(data) {
			closeProgressbar();
			console.info("close the progressbar:"+data.flag);
			var retMsg;
			if("true"==data.flag){
				retMsg=data.msg;
				if(typeof data.return_show !="undefined"){// 读取文件
					var return_id = "#"+data.return_show+"";
					$(return_id).html(data.return_txt);
					console.info('defined:'+data.return_show);
				}
			}else{
			    retMst = '操作失败！具体原因：'+data.msg;
			}
			$.messager.show({
				title : '提示',
				msg : retMsg
			});
			
		}
	});
}

function exitsMRmonitor(){
	var t = $('#layout_center_tabs');
	if (t.tabs('exists', "MR算法监控")) {
		$.messager.alert("操作提示", "请先关闭MR监控页面！","info"); 
		return true;
	} else {
		return false;
	}
}

function layout_center_addTabFun(opts) {
		var t = $('#layout_center_tabs');
		if (t.tabs('exists', opts.title)) {
			t.tabs('select', opts.title);
		} else {
			t.tabs('add', opts);
		}
		console.info("打开页面："+opts.title);
}

$(function(){
	$('#navid').tree({
		onClick: function(node){
//			alert(node.text+","+node.url);  // alert node text property when clicked
			console.info("click:"+node.text);
			if(node.attributes.folder=='1'){
				return ;
			}
			console.info("open url:"+node.attributes.url)	
			var url;
			if (node.attributes.url) {
				url = node.attributes.url;
			} else {
				url = '404.jsp';
			}
			console.info("open "+url);
			layout_center_addTabFun({
				title : node.text,
				closable : true,
				iconCls : node.iconCls,
				href : url
			});
		}
	});	
	

});
