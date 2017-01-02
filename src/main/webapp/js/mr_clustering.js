$(function(){
	// kmeans---
	$('#kmeans_submit').bind('click', function(){
		
		// 检查是否有“MR监控页面”，如果有，则退出，并提示关闭
		if(exitsMRmonitor()){
			return ;
		}	
		var input=$('#kmeans_input').val();//
		var output=$('#kmeans_output').val();//
		var clusters=$('#kmeans_clusters').val();//
		var k=$('#kmeans_k').val();
		var convergenceDelta=$('#kmeans_convergenceDelta').val();
		var maxIter=$('#kmeans_maxIter').val();
		var clustering=$('#kmeans_clustering').combobox("getValue");
		var distanceMeasure=$('#kmeans_distanceMeasure').combobox("getValue");
		
		var jobnums_=parseInt(k); // 一共的MR个数
		if("true"==clustering){
			jobnums_=jobnums_+1;
		}
		jobnums_=jobnums_+"";
		// 弹出进度框
		popupProgressbar('聚类MR','kmeans任务提交中...',1000);
		// ajax 异步提交任务
		
		callByAJax('cloud/cloud_submitIterMR.action',{algorithm:"KMeansDriverRunnable",jobnums:jobnums_,
			arg1:input,arg2:output,arg3:clusters,arg4:k,
			arg5:convergenceDelta,arg6:maxIter,arg7:clustering,arg8:distanceMeasure});
		
	});
	
	// ------kmeans
	
	
	// fuzzykmeans---
	$('#fuzzykmeans_submit').bind('click', function(){
		
		// 检查是否有“MR监控页面”，如果有，则退出，并提示关闭
		if(exitsMRmonitor()){
			return ;
		}	
		var input=$('#fuzzykmeans_input').val();//
		var output=$('#fuzzykmeans_output').val();//
		var clusters=$('#fuzzykmeans_clusters').val();//
		var k=$('#fuzzykmeans_k').val();
		var convergenceDelta=$('#fuzzykmeans_convergenceDelta').val();
		var maxIter=$('#fuzzykmeans_maxIter').val();
		var clustering=$('#fuzzykmeans_clustering').combobox("getValue");
		var distanceMeasure=$('#fuzzykmeans_distanceMeasure').combobox("getValue");
		
		var m =$('#fuzzykmeans_m').val();
		var emitMostLikely=$('#fuzzykmeans_emitMostLikely').combobox("getValue");;
		var threshold =$('#fuzzykmeans_threshold').val();
		
		var jobnums_=parseInt(k); // 一共的MR个数
		if("true"==clustering){
			jobnums_=jobnums_+1;
		}
		jobnums_=jobnums_+"";
		// 弹出进度框
		popupProgressbar('聚类MR','fuzzykmeans任务提交中...',1000);
		// ajax 异步提交任务
		
		callByAJax('cloud/cloud_submitIterMR.action',{algorithm:"FuzzyKMeansDriverRunnable",jobnums:jobnums_,
			arg1:input,arg2:output,arg3:clusters,arg4:k,
			arg5:convergenceDelta,arg6:maxIter,arg7:clustering,arg8:distanceMeasure,
			arg9:m,arg10:emitMostLikely,arg11:threshold});
		
	});
	
	// ------fuzzykmeans
	
	
});
