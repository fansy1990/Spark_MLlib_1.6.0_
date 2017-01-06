/**
 * preprocess 
 * 和
 * utils
 * 和
 * math
 * 
 */
$(function(){
	// =====upload 数据上传，如果是初始化会把arg3赋值为 “initial” ,表明是要进行初始化操作，否则是上传
	$('#upload_submit').bind('click', function(){
		var input=$('#upload_input').val();
		var output=$('#upload_output').val();
		// 弹出进度框
		popupProgressbar('数据上传','数据上传中...',1000);
		// ajax 异步提交任务
		callByAJax('cloud/cloud_submitJobNotMR.action',{algorithm:'Upload',
			arg1:input,arg2:output});
	});

	
	$('#upload_prepare_submit').bind('click', function(){
		var select_value=$('#prepare_select').combobox("getValue");;
		var algorithm_type='prepare';
		// 弹出进度框
		popupProgressbar('数据上传','数据上传中...',1000);
		// ajax 异步提交任务
		callByAJax('cloud/cloud_submitJobNotMR.action',{algorithm:'Upload',
			arg1:select_value,arg2:algorithm_type,arg3:"initial"});
	});
	
	//=======upload ===================
	

	
	
	// ============ readtxt
	$('#readtxt_submit').bind('click', function(){
		var select_value=$('#readtxt_select').combobox("getValue");
		var input=$('#readtxt_input').val();
		// 弹出进度框
		popupProgressbar('提示','数据读取中...',1000);
		// ajax 异步提交任务
		callByAJax('cloud/cloud_submitJobNotMR.action',{algorithm:'ReadTxt',arg1:input,arg2:select_value});
	});
	// ============ readtxt =================

	
	// ============ readcluster
	$('#readcluster_submit').bind('click', function(){
//		var select_value=$('#readtxt_select').combobox("getValue");;
		var input=$('#readcluster_input').val();
		var distanceMeasure=$('#readcluster_distanceMeasure').combobox("getValue");
		var include_per_cluster=$('#readcluster_include_per_cluster').combobox("getValue");
		var points=$('#readcluster_points').val();
		// 弹出进度框
		popupProgressbar('提示','数据读取中...',1000);
		// ajax 异步提交任务
		callByAJax('cloud/cloud_submitJobNotMR.action',{algorithm:'ReadCluster',arg1:input,arg2:points,
			arg3:distanceMeasure,arg4:include_per_cluster});
	});
	// ============ readcluster =================
	
	// ============ readseq
	$('#readseq_submit').bind('click', function(){
		var input=$('#readseq_input').val();
		var numItems=$('#readseq_numItems').combobox("getValue");
		// 弹出进度框
		popupProgressbar('提示','数据读取中...',1000);
		// ajax 异步提交任务
		callByAJax('cloud/cloud_submitJobNotMR.action',{algorithm:'ReadSeq',arg1:input,arg2:numItems});
	});
	// ============ readseq =================
	
	
	// ============ inputdriver
	$('#inputdriver_submit').bind('click', function(){
		var select_value=$('#inputdriver_select').combobox("getValue");;
		var input=$('#inputdriver_input').val();
		var output=$('#inputdriver_output').val();
		// 弹出进度框
		popupProgressbar('提示','数据转换中...',1000);
		// ajax 异步提交任务
		callByAJax('cloud/cloud_submitJob.action',{algorithm:'InputDriverRunnable',
			jobnums:1,arg1:input,
			arg2:output,arg3:select_value});
	});
	// ============ inputdriver =================
	
	// ============ describe
	$('#describe_submit').bind('click', function(){
		var select_value=$('#describe_select').combobox("getValue");;
		var input=$('#describe_input').val();
		var output=$('#describe_output').val();
		var description=$('#describe_description').val();
		// 弹出进度框
		popupProgressbar('提示','数据读取中...',1000);
		// ajax 异步提交任务
		callByAJax('cloud/cloud_submitJobNotMR.action',{algorithm:'DescribeTest'
			,arg1:input,arg2:output,arg3:description,arg4:select_value});
	});
	// ============ describe ================
	
	
	// ============ generate_classify
	$('#generate_classify_submit').bind('click', function(){
		var labelindex=$('#generate_classify_labelindex').combobox("getValue");;
		var input=$('#generate_classify_input').val();
		var output=$('#generate_classify_output').val();
		// 弹出进度框
		popupProgressbar('提示','数据转换中...',1000);
		// ajax 异步提交任务
		callByAJax('cloud/cloud_submitJobNotMR.action',{algorithm:'GenerateClassify'
			,arg1:input,arg2:output,arg3:labelindex});
	});
	// ============ generate_classify ================
	
	
	// ============ vecdist
	$('#vecdist_submit').bind('click', function(){
		var dm=$('#vecdist_distanceMeasure').combobox("getValue");
		var ot=$('#vecdist_outtype').combobox("getValue");
		var input=$('#vecdist_input').val();
		var output=$('#vecdist_output').val();
		var seed=$('#vecdist_seed').val();
		var mx=$('#vecdist_mx').val();
		// 弹出进度框
		popupProgressbar('提示','任务提交中...',1000);
		// ajax 异步提交任务
		callByAJax('cloud/cloud_submitJob.action',{algorithm:'VecDistRunnable',jobnums:"1",
			arg1:input,arg2:output,arg3:seed,arg4:dm,arg5:ot,arg6:mx});
	});
	// ============ vecdist ================
	
	// ============ readtestnb
	$('#readtestnb_submit').bind('click', function(){
		var output=$('#readtestnb_output').val();
		var label=$('#readtestnb_label').val();
		// 弹出进度框
		popupProgressbar('提示','读取testnb分类结果中...',1000);
		// ajax 异步提交任务
		callByAJax('cloud/cloud_submitJobNotMR.action',{algorithm:'ReadTestNb',
			arg1:output,arg2:label});
	});
	// ============ readtestnb ================
	
});
