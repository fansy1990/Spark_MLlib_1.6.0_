<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">Describe 任务运行</div>  
	<br>
	 
	<div style="padding-left: 30px;font-size: 15px;padding-top:10px;"><br>
		把原始文件的描述写入一个文件，具体参考：http://blog.csdn.net/fansy1990/article/details/11846979<br>
	</div>
	 
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/utils/describe/input.txt"
					id="describe_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">HDFS描述文件路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/utils/describe/input.info"
					id="describe_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">输入描述字符串:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="I 9 N L"
					id="describe_description" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">是否是回归问题:</label>
				</td>
				<td>
				<select id="describe_select" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="false">否</option>
						<option value="true">是</option>
				</select>
				</td>
				<td><a id="describe_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
	
	</div> 
	<div id="describe_return" style="padding-left: 30px;font-size: 20px;padding-top:10px;"></div>
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

