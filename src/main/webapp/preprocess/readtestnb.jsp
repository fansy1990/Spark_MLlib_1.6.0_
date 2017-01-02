<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">testnb 测试分类结果查看</div>  
	<br>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">testnb输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				value="/user/root/classification/testnb/output/"
					id="readtestnb_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">Label 路径:</label>
				</td>
				<td>
				<input class="easyui-validatebox" type="text" 
				value="/user/root/classification/trainnb/labelIndex"
					id="readtestnb_label" data-options="required:true" style="width:300px" />
				</td>
				<td><a id="readtestnb_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">读取</a></td>
			</tr>
			
		</table>
	
	</div> 
	<div id="readtestnb_return" style="padding-left: 30px;font-size: 15px;padding-top:10px;"></div>
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

