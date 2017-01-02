<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">分类序列文件生成</div>  
	<br>
	
	<div style="padding-left: 30px;font-size: 15px;padding-top:10px;"><br>
		根据输入的csv格式数据，生成序列文件，其key为类别，value是属性向量<br>
	</div>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">本地路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
					value="/user/root/classification/generate_classify/input.csv"
					id="generate_classify_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				value="/user/root/process/generate_classify/input.seq"
					id="generate_classify_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">Label所在列:</label>
				</td>
				<td>
				<select id="generate_classify_labelindex" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="end">最后一列</option>
						<option value="start">第一列</option>
				</select>
				</td>
				<td><a id="generate_classify_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">转换</a></td>
			</tr>
			
			
		</table>
	
	</div> 
	<div id="generate_classify_return" style="padding-left: 30px;font-size: 20px;padding-top:10px;"></div>
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

