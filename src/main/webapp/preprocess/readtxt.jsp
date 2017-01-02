<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">HDFS txt文件查看</div>  
	<br>
	<!-- 
	<div style="padding-left: 30px;font-size: 15px;padding-top:10px;"><br>
		如果有MR监控页面，请先关闭，在提交MR任务<br>
	</div>
	 -->
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/recommenders/splitDataset.txt"
					id="readtxt_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">读取行数:</label>
				</td>
				<td>
				<select id="readtxt_select" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="5">5行</option>
						<option value="10">10行</option>
						<option value="50">50行</option>
						<option value="100">100行</option> 
						<option value="500">500行</option>
						<option value="1000">1000行</option>

				</select>
				</td>
				<td><a id="readtxt_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">读取</a></td>
			</tr>
			
		</table>
	
	</div> 
	<div id="readtxt_return" style="padding-left: 30px;font-size: 12px;padding-top:10px;"></div>
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

