<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">FactorizationEvaluator算法调用</div>  
	<br>
	<div style="padding-left: 30px;font-size: 15px;padding-top:10px;"><br>
	任务运行完成后，到文件查看页面，输入路径：<br>
	/user/root/recommenders/evaluateFactorization/output/rmse.txt
	<br>
	即可看到测试数据的误差！
	  </div>	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="/user/root/recommenders/splitDataset/train_test_output/probeSet"
					id="evaluateFactorization_input" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/recommenders/evaluateFactorization/output"
					id="evaluateFactorization_output" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">userFeatures路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/recommenders/parallelALS/output/U"
					id="evaluateFactorization_userFeatures" data-options="required:true" style="width:400px" />
				</td>
				<td>ParallelALS任务中的用户特征值输出路径</td>
			</tr>
			<tr>
				<td><label for="name">itemFeatures路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/recommenders/parallelALS/output/M"
					id="evaluateFactorization_itemFeatures" data-options="required:true" style="width:400px" />
				</td>
				<td>ParallelALS任务中的项目特征值输出路径</td>
			</tr>
			
			<tr>
				<td><a id="evaluateFactorization_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
		</table>
	</div> 
	<script type="text/javascript" src="js/mr_recommenders.js"></script>  
</body>

