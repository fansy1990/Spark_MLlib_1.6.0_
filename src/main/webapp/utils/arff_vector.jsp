<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">arff文件序列化</div>  
	<br>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">Arff本地文件路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
					value="D:/workspase/book/mahout1.0/src/main/resources/data/utils/arff_vector.arff"
					id="arff_input" data-options="required:true" style="width:450px" />
				</td>
				<td>需修改为实际路径</td>
			</tr>
			
			<tr>
				<td><label for="name">HDFS输出文件路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
					value="/user/root/utils/arff_vector/output"
					id="arff_output" data-options="required:true" style="width:450px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">本地生成字典文件路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
					value="D:/workspase/book/mahout1.0/src/main/resources/data/utils/arff_vector.dic"
					id="arff_dictionary" data-options="required:true" style="width:450px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">分隔符:</label>
				</td>
				<td>
				<select id="arff_delimiter" class="easyui-combobox" name="dept"
					style="width:200px;">
						
						<option value="|">竖线(|)</option>
						<option value=";">分号(;)</option>
						<option value="\t">Tab键</option>
						<option value=" ">空格(' ')</option> 
						<option value=",">逗号(,)</option>
						<option value="<">小于号(&lt;)</option>
						<option value=">">大于号(&gt;)</option>
						<option value=".">句号(.)</option>
						<option value="||">双竖线(||)</option>
						
				</select>
				</td>
			</tr>
			<tr>
				<td><a id="arff_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">读取</a></td>
			</tr>
			
		</table>
	
	</div> 
	<div id="arff_return" style="padding-left: 30px;font-size: 12px;padding-top:10px;"></div>
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

