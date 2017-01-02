<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">序列文件查看</div>  
	<br>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS序列文件路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
					value="/user/root/clustering/kmeans/output/clusteredPoints/part-m-00000"
					id="readseq_input" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">键值对个数:</label>
				</td>
				<td>
				<select id="readseq_numItems" class="easyui-combobox" name="dept"
					style="width:200px;">
						
						<option value="1">1个</option>
						<option value="2">2个</option>
						<option value="3">3个</option>
						<option value="5">5个</option> 
						<option value="10">10个</option>
						<option value="50">50个</option>
						<option value="100">100个</option>
						<option value="500">500个</option>
						<option value="1000">1000个</option>
						
				</select>
				</td>
			</tr>
			<tr>
				<td><a id="readseq_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">读取</a></td>
			</tr>
			
		</table>
	
	</div> 
	<div id="readseq_return" style="padding-left: 30px;font-size: 12px;padding-top:10px;"></div>
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

