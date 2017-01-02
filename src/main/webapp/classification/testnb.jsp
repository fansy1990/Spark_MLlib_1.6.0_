<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">朴素贝叶斯测试任务算法调用</div>  
	<br>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="/user/root/process/generate_classify/input.seq"
					id="testnb_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>

			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/classification/testnb/output"
					id="testnb_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">模型所在HDFS路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
					value="/user/root/classification/trainnb/output/"
					id="testnb_model" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">HDFS类别存储路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				value="/user/root/classification/trainnb/labelIndex"
					id="testnb_labelIndex" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><a id="testnb_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
	
	</div> 
	<script type="text/javascript" src="js/mr_classification.js"></script>  

</body>

