$(function(){
	// logistic regression ---
	$('#logistic_train_submit').bind('click', function(){
		// get parameters :input minPartitions output targetIndex splitter method hasIntercept numClasses
		var input=$('#logistic_train_input').val();//
        var minPartitions = $('#logistic_train_minPartitions').numberbox('getValue');//
		var output=$('#logistic_train_output').val();//
		var targetIndex=$('#logistic_train_targetIndex').numberbox('getValue');//
		var numClasses=$('#logistic_train_numClasses').numberbox('getValue');//
		var splitter=$('#logistic_train_splitter').val();
		var method=$('#logistic_train_method').combobox("getValue");
		var hasIntercept=$('#logistic_train_hasIntercept').combobox("getValue");


		//思路1： 弹出进度框 ,不同用户提交没有影响，这里不是interval，而是实实在在的进度
		//思路2：弹出进度框，只显示提交的状态，提交成功，返回提交的任务id，提交失败，返回提示信息；
        // 提交成功后，在后台，存储数据库相应信息；
        popupProgressbar('回归','逻辑回归任务初始化中...',1000);
		// ajax 异步提交任务
		console.info("input:"+input+",output:"+output+",targetIndex:"+targetIndex+
		",numClasses:"+numClasses+",splitter:"+splitter+",method:"+method+",hasIntercept:"+hasIntercept);

		// 状态有：任务初始化，任务提交完成；任务运行进度（初始化，accept，running，finished）
		callByAJax('cloud/cloud_submitSparkJob.action',{algorithm:"classification.LogisticCallable",
			arg1:input,arg2:minPartitions,arg3:output,arg4:targetIndex,arg5:splitter
			,arg6:method,arg7:hasIntercept,arg8:numClasses
			});
		
	});
	
	// svm train---
	$('#svm_train_submit').bind('click', function(){
		// testOrNot input minPartitions output targetIndex "
        //    "splitter numIteration stepSize regParam miniBatchFraction regMethod"
		var input=$('#svm_train_input').val();//
        var minPartitions = $('#svm_train_minPartitions').numberbox('getValue');//
        var output=$('#svm_train_output').val();//
        var targetIndex=$('#svm_train_targetIndex').numberbox('getValue');//
        var numIteration=$('#svm_train_numIteration').numberbox('getValue');//
        var stepSize=$('#svm_train_stepSize').numberbox('getValue');//
        var regParam=$('#svm_train_regParam').numberbox('getValue');//
        var minBatchFraction=$('#svm_train_minBatchFraction').numberbox('getValue');//
        var splitter=$('#svm_train_splitter').val();
        var regMethod=$('#svm_train_regMethod').combobox("getValue");

        //思路2：弹出进度框，只显示提交的状态，提交成功，返回提交的任务id，提交失败，返回提示信息；
        // 提交成功后，在后台，存储数据库相应信息；
        popupProgressbar('分类','SVM建模任务初始化中...',1000);
        // ajax 异步提交任务
        console.info("input:"+input+",output:"+output+",targetIndex:"+targetIndex+
        ",numIteration:"+numIteration+",splitter:"+splitter+",regMethod:"+regMethod+",stepSize:"+stepSize+
        ",regParam:"+regParam+",minBatchFraction:"+minBatchFraction);

        // 状态有：任务初始化，任务提交完成；任务运行进度（初始化，accept，running，finished）
        callByAJax('cloud/cloud_submitSparkJob.action',{algorithm:"classification.SVMCallable",
            arg1:input,arg2:minPartitions,arg3:output,arg4:targetIndex,arg5:splitter
            ,arg6:numIteration,arg7:stepSize,arg8:regParam,arg9:minBatchFraction,arg10:regMethod
            });

	});
//	==================svm train
	
	// decisiontree train---
    	$('#decisiontree_train_submit').bind('click', function(){
    		//    testOrNot input minPartitions output targetIndex " +
             //   "splitter impurity maxDepth algo maxBins numClasses<numClass is only for classifictation>

    		var input=$('#decisiontree_train_input').val();//
            var minPartitions = $('#decisiontree_train_minPartitions').numberbox('getValue');//
            var output=$('#decisiontree_train_output').val();//
            var targetIndex=$('#decisiontree_train_targetIndex').numberbox('getValue');//
            var impurity=$('#decisiontree_train_impurity').combobox('getValue');//
            var maxDepth=$('#decisiontree_train_maxDepth').numberbox('getValue');//
            var algo=$('#decisiontree_train_algo').combobox('getValue');//
            var maxBins=$('#decisiontree_train_maxBins').numberbox('getValue');//
            var splitter=$('#decisiontree_train_splitter').val();
            var numClasses=$('#decisiontree_train_numClasses').numberbox("getValue");
    
            //思路2：弹出进度框，只显示提交的状态，提交成功，返回提交的任务id，提交失败，返回提示信息；
            // 提交成功后，在后台，存储数据库相应信息；
            popupProgressbar('分类','decisiontree建模任务初始化中...',1000);
            // ajax 异步提交任务

            // 状态有：任务初始化，任务提交完成；任务运行进度（初始化，accept，running，finished）
            callByAJax('cloud/cloud_submitSparkJob.action',{algorithm:"classification.DecisionTreeCallable",
                arg1:input,arg2:minPartitions,arg3:output,arg4:targetIndex,arg5:splitter
                ,arg6:impurity,arg7:maxDepth,arg8:algo,arg9:maxBins,arg10:numClasses
                });
    
    	});
    //	==================decisiontree train


    // gradientboosttree train---
    $('#gradientboosttree_train_submit').bind('click', function(){

//    testOrNot input minPartitions output targetIndex " +
//    "splitter algo lossType numIteration  maxDepth [numClasses]
        var input=$('#gradientboosttree_train_input').val();//
        var minPartitions = $('#gradientboosttree_train_minPartitions').numberbox('getValue');//
        var output=$('#gradientboosttree_train_output').val();//
        var targetIndex=$('#gradientboosttree_train_targetIndex').numberbox('getValue');//
        var lossType=$('#gradientboosttree_train_lossType').combobox('getValue');//
        var maxDepth=$('#gradientboosttree_train_maxDepth').numberbox('getValue');//
        var algo=$('#gradientboosttree_train_algo').combobox('getValue');//
        var numIteration=$('#gradientboosttree_train_numIteration').numberbox('getValue');//
        var splitter=$('#gradientboosttree_train_splitter').val();
        var numClasses=$('#gradientboosttree_train_numClasses').numberbox("getValue");

        //思路2：弹出进度框，只显示提交的状态，提交成功，返回提交的任务id，提交失败，返回提示信息；
        // 提交成功后，在后台，存储数据库相应信息；
        popupProgressbar('分类','gradientboosttree建模任务初始化中...',1000);
        // ajax 异步提交任务

        // 状态有：任务初始化，任务提交完成；任务运行进度（初始化，accept，running，finished）
        callByAJax('cloud/cloud_submitSparkJob.action',{algorithm:"classification.GradientBoostTreeCallable",
            arg1:input,arg2:minPartitions,arg3:output,arg4:targetIndex,arg5:splitter
            ,arg6:algo,arg7:lossType,arg8:numIteration,arg9:maxDepth,arg10:numClasses
        });

    });
    //	==================gradientboosttree train

    // isotonic train---
    $('#isotonic_train_submit').bind('click', function(){

//    testOrNot input minPartitions output targetIndex " +
//    "splitter weights isotonic
        var input=$('#isotonic_train_input').val();//
        var minPartitions = $('#isotonic_train_minPartitions').numberbox('getValue');//
        var output=$('#isotonic_train_output').val();//
        var targetIndex=$('#isotonic_train_targetIndex').numberbox('getValue');//
        var isotonic=$('#isotonic_train_isotonic').combobox('getValue');//
        var weights=$('#isotonic_train_weights').numberbox('getValue');//
        var splitter=$('#isotonic_train_splitter').val();

        //思路2：弹出进度框，只显示提交的状态，提交成功，返回提交的任务id，提交失败，返回提示信息；
        // 提交成功后，在后台，存储数据库相应信息；
        popupProgressbar('分类','isotonic建模任务初始化中...',1000);
        // ajax 异步提交任务

        // 状态有：任务初始化，任务提交完成；任务运行进度（初始化，accept，running，finished）
        callByAJax('cloud/cloud_submitSparkJob.action',{algorithm:"classification.IsotonicCallable",
            arg1:input,arg2:minPartitions,arg3:output,arg4:targetIndex,arg5:splitter
            ,arg6:weights,arg7:isotonic
        });

    });
    //	==================isotonic train

// naivebayes train---
    $('#naivebayes_train_submit').bind('click', function(){

//    testOrNot input minPartitions output targetIndex " +
//    "splitter weights naivebayes
        var input=$('#naivebayes_train_input').val();//
        var minPartitions = $('#naivebayes_train_minPartitions').numberbox('getValue');//
        var output=$('#naivebayes_train_output').val();//
        var targetIndex=$('#naivebayes_train_targetIndex').numberbox('getValue');//
        var modelType=$('#naivebayes_train_modelType').combobox('getValue');//
        var lambda=$('#naivebayes_train_lambda').numberbox('getValue');//
        var splitter=$('#naivebayes_train_splitter').val();

        //思路2：弹出进度框，只显示提交的状态，提交成功，返回提交的任务id，提交失败，返回提示信息；
        // 提交成功后，在后台，存储数据库相应信息；
        popupProgressbar('分类','naivebayes建模任务初始化中...',1000);
        // ajax 异步提交任务

        // 状态有：任务初始化，任务提交完成；任务运行进度（初始化，accept，running，finished）
        callByAJax('cloud/cloud_submitSparkJob.action',{algorithm:"classification.NaiveBayesCallable",
            arg1:input,arg2:minPartitions,arg3:output,arg4:targetIndex,arg5:splitter
            ,arg6:modelType,arg7:lambda
        });

    });
    //	==================naivebayes train



});
