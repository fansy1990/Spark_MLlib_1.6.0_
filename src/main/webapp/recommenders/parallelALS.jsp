<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">parallelALS算法调用</div>  
	<br>
		<div style="padding-left: 30px;font-size: 15px;padding-top:10px;"><br>
		参考：http://blog.csdn.net/fansy1990/article/details/12259975
	  </div>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="/user/root/recommenders/splitDataset/train_test_output/trainingSet"
					id="parallelALS_input" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/recommenders/parallelALS/output"
					id="parallelALS_output" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">lambda:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="0.065"
					id="parallelALS_lambda" data-options="required:true" style="width:100px" />
				</td>
				<td>规范化参数</td>
			</tr>
			
			<tr>
				<td><label for="name">numFeatures:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="10"
					id="parallelALS_numFeatures" data-options="required:true" style="width:100px" />
				</td>
				<td>特征空间维度</td>
			</tr>
			
			<tr>
				<td><label for="name">numIterations:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="10"
					id="parallelALS_numIterations" data-options="required:true" style="width:100px" />
				</td>
				<td>循环次数</td>
			</tr>
			
			<tr>
				<td><label for="name">numThreadsPerSolver:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="1"
					id="parallelALS_numThreadsPerSolver" data-options="required:true" style="width:100px" />
				</td>
				<td>每个mapper的线程数</td>
			</tr>
			
			<tr>
				<td><a id="parallelALS_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
	
	</div> 
	<script type="text/javascript" src="js/mr_recommenders.js"></script>  

</body>

