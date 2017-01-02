$(function(){
	// splitDataset---
	$('#splitDataset_submit').bind('click', function(){
		
		// 检查是否有“MR监控页面”，如果有，则退出，并提示关闭
		if(exitsMRmonitor()){
			return ;
		}	
		var input=$('#splitDataset_input').val();
		var output=$('#splitDataset_output').val();//
		var trainPercent=$('#splitDataset_trainPercent').val();
		var testPercent=$('#splitDataset_testPercent').val();
		
		// 弹出进度框
		popupProgressbar('推荐MR','splitDataset任务提交中...',1000);
		// ajax 异步提交任务
		
		callByAJax('cloud/cloud_submitJob.action',{algorithm:"DatasetSplitterRunnable",jobnums:"3",
			arg1:input,arg2:output,arg3:trainPercent,arg4:testPercent});
		
	});
	
	// ------splitDataset
	
	// recommenditembased---
	$('#recommenditembased_submit').bind('click', function(){
		
		// 检查是否有“MR监控页面”，如果有，则退出，并提示关闭
		if(exitsMRmonitor()){
			return ;
		}	
		var input=$('#recommenditembased_input').val();
		var output=$('#recommenditembased_output').val();
		var opfsm=$('#recommenditembased_opfsm').val();
		var num=$('#recommenditembased_num').val();
		
		var b=$('#recommenditembased_b').combobox("getValue");
		
		var mxp=$('#recommenditembased_mxp').val();
		
		var mp=$('#recommenditembased_mp').val();
		var m=$('#recommenditembased_m').val();
		var mpiis=$('#recommenditembased_mpiis').val();
		
		var s=$('#recommenditembased_s').combobox("getValue");
		var seq=$('#recommenditembased_seq').combobox("getValue");
		
		// 弹出进度框
		popupProgressbar('推荐MR','splitDataset任务提交中...',1000);
		// ajax 异步提交任务
		
		callByAJax('cloud/cloud_submitJob.action',{algorithm:"RecommendItembasedRunnable",jobnums:"10",
			arg1:input,arg2:output,arg3:opfsm,arg4:num,arg5:b,
			arg6:mxp,arg7:mp,arg8:m,arg9:mpiis,arg10:s,arg11:seq});
		
	});
	
	// ------recommenditembased
	
	
	// parallelALS---
	$('#parallelALS_submit').bind('click', function(){
		
		// 检查是否有“MR监控页面”，如果有，则退出，并提示关闭
		if(exitsMRmonitor()){
			return ;
		}	
		var input=$('#parallelALS_input').val();
		var output=$('#parallelALS_output').val();
		var lambda=$('#parallelALS_lambda').val();
		var numFeatures=$('#parallelALS_numFeatures').val();
		var numIterations=$('#parallelALS_numIterations').val();
		var numThreadsPerSolver=$('#parallelALS_numThreadsPerSolver').val();
		// 弹出进度框
		popupProgressbar('推荐MR','parallelALS任务提交中...',1000);
		// ajax 异步提交任务
		
		var jobnums_=parseInt(numIterations);
		jobnums_=jobnums_+jobnums_+3;
		
		callByAJax('cloud/cloud_submitJob.action',{algorithm:"ParallelALSRunnable",jobnums:jobnums_,
			arg1:input,arg2:output,arg3:lambda,arg4:numFeatures,arg5:numIterations,
			arg6:numThreadsPerSolver});
		
	});
	
	// ------parallelALS
	
	//recommendfactorized---
	$('#recommendfactorized_submit').bind('click', function(){
		
		// 检查是否有“MR监控页面”，如果有，则退出，并提示关闭
		if(exitsMRmonitor()){
			return ;
		}	
		var input=$('#recommendfactorized_input').val();
		var output=$('#recommendfactorized_output').val();
		var userFeatures=$('#recommendfactorized_userFeatures').val();
		var itemFeatures=$('#recommendfactorized_itemFeatures').val();
		var num=$('#recommendfactorized_num').val();
		var maxRating=$('#recommendfactorized_maxRating').val();
		var numThreads=$('#recommendfactorized_numThreads').val();
		// 弹出进度框
		popupProgressbar('推荐MR','recommendfactorized任务提交中...',1000);
		// ajax 异步提交任务
		
		callByAJax('cloud/cloud_submitJob.action',{algorithm:"RecommendFactorizedRunnable",jobnums:'1',
			arg1:input,arg2:output,arg3:userFeatures,arg4:itemFeatures,arg5:num,
			arg6:maxRating,arg7:numThreads});
		
	});
	
	// ------recommendfactorized
	
	
	//evaluateFactorization---
	$('#evaluateFactorization_submit').bind('click', function(){
		
		// 检查是否有“MR监控页面”，如果有，则退出，并提示关闭
		if(exitsMRmonitor()){
			return ;
		}	
		var input=$('#evaluateFactorization_input').val();
		var output=$('#evaluateFactorization_output').val();
		var userFeatures=$('#evaluateFactorization_userFeatures').val();
		var itemFeatures=$('#evaluateFactorization_itemFeatures').val();
		// 弹出进度框
		popupProgressbar('推荐MR','evaluateFactorization任务提交中...',1000);
		// ajax 异步提交任务
		
		callByAJax('cloud/cloud_submitJob.action',{algorithm:"EvaluateFactorizationRunnable",jobnums:'1',
			arg1:input,arg2:output,arg3:userFeatures,arg4:itemFeatures});
		
	});
	
	// ------evaluateFactorization
	
	// itemsimilarity---
	$('#itemsimilarity_submit').bind('click', function(){
		
		// 检查是否有“MR监控页面”，如果有，则退出，并提示关闭
		if(exitsMRmonitor()){
			return ;
		}	
		var input=$('#itemsimilarity_input').val();
		var output=$('#itemsimilarity_output').val();
		var b=$('#itemsimilarity_b').combobox("getValue");
		
		var mp=$('#itemsimilarity_mp').val();
		var m=$('#itemsimilarity_m').val();
		var mppu=$('#itemsimilarity_mppu').val();
		
		var s=$('#itemsimilarity_s').combobox("getValue");
		
		// 弹出进度框
		popupProgressbar('推荐MR','itemsimilarity任务提交中...',1000);
		// ajax 异步提交任务
		
		callByAJax('cloud/cloud_submitJob.action',{algorithm:"ItemSimilarityJobRunnable",jobnums:"8",
			arg1:input,arg2:output,arg3:b,arg4:mp,arg5:m,
			arg6:mppu,arg7:s});
		
	});
	// ------itemsimilarity
});
