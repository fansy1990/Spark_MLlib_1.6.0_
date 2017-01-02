<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">聚类数据转换</div>  
	<br>
	
	<div style="padding-left: 30px;font-size: 15px;padding-top:10px;"><br>
		converts text files containing space-delimited floating point numbers into
  Mahout sequence files of VectorWritable suitable for input to the clustering jobs:<br>
   把空格分隔的float类型数据转换为Mahout聚类使用的向量数据，即序列化向量数据
	</div>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/prepare/inputdriver/input.txt"
					id="inputdriver_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/prepare/inputdriver/output"
					id="inputdriver_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">向量名称:</label>
				</td>
				<td>
				<select id="inputdriver_select" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="org.apache.mahout.math.RandomAccessSparseVector">RandomAccessSparseVector</option>
						<option value="org.apache.mahout.math.DenseVector">DenseVector</option>

				</select>
				</td>
				<td><a id="inputdriver_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">转换</a></td>
			</tr>
			
		</table>
	
	</div> 
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

