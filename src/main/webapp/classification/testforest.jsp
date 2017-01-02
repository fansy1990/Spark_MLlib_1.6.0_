<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">testforest 测试分类结果查看</div>  
	<br>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				value="/user/root/classification/buildforest/input.csv"
					id="testforest_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">描述文件路径:</label>
				</td>
				<td>
				<input class="easyui-validatebox" type="text" 
				value="/user/root/utils/describe/input.info"
					id="testforest_describe" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">模型文件路径:</label>
				</td>
				<td>
				<input class="easyui-validatebox" type="text" 
				value="/user/root/classification/buildforest/output"
					id="testforest_model" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">输出文件路径:</label>
				</td>
				<td>
				<input class="easyui-validatebox" type="text" 
				value="/user/root/classification/testforest/output"
					id="testforest_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			<tr>
				<td><a id="testforest_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
	
	</div> 
	<div id="testforest_return" style="padding-left: 30px;font-size: 15px;padding-top:10px;"></div>
	<script type="text/javascript" src="js/mr_classification.js"></script>  

</body>

