<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">序列文件分割</div>  
	<br>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS序列文件路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
					value="/user/root/clustering/kmeans/input.seq"
					id="resplitseq_input" data-options="required:true" style="width:350px" />
				</td>
				<td> 需修改为实际路径</td>
			</tr>
			
			<tr>
				<td><label for="name">HDFS输出文件路径前缀:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
					value="/user/root/utils/resplitseq/split"
					id="resplitseq_output" data-options="required:true" style="width:350px" />
				</td>
			</tr>			
			<tr>
				<td><label for="name">文件个数:</label>
				</td>
				<td>
				<select id="resplitseq_files" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="2">2个</option>
						<option value="3">3个</option>
						<option value="4">4个</option>
						<option value="5">5个</option>
						<option value="7">7个</option>
						<option value="8">8个</option>
						<option value="9">9个</option> 
						<option value="10">10个</option>
						<option value="20">20个</option>
						
				</select>
				</td>
			</tr>
			<tr>
				<td><a id="resplitseq_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">分割</a></td>
			</tr>
			
		</table>
	
	</div> 
	<div id="resplitseq_return" style="padding-left: 30px;font-size: 12px;padding-top:10px;"></div>
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

