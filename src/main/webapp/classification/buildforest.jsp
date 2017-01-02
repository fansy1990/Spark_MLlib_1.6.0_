<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">随机森林训练算法调用</div>  
	<br>
	<div style="padding-left: 30px;font-size: 15px;padding-top:10px;"><br>
	拷贝mahout的lib下面的<br>：
	  xstream-1.4.4.jar，xmlpull-1.1.3.1.jar，xpp3_min-1.1.4c.jar，commons-lang3-3.1.jar<br>
	  到hadoop lib目录
	  </div>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="/user/root/classification/buildforest/input.csv"
					id="buildforest_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">描述文件路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="/user/root/utils/describe/input.info"
					id="buildforest_describe" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/classification/buildforest/output"
					id="buildforest_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">随机选择属性个数:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="-1"
					id="buildforest_selection" data-options="required:true" style="width:100px" />
				</td>
				<td>设置为-1则是默认，默认分类问题取所有变量个数的开方，回归问题取所有变量的1/3</td>
			</tr>
			<tr>
				<td><label for="name">生成树节点分离阈值:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="2"
					id="buildforest_minsplit" data-options="required:true" style="width:100px" />
				</td>
				<td>分类问题使用此阈值</td>
			</tr>
			
			<tr>
				<td><label for="name">生成树节点分离阈值:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="0.001"
					id="buildforest_minprop" data-options="required:true" style="width:100px" />
				</td>
				<td>回归问题使用此阈值</td>
			</tr>
			<tr>
				<td><label for="name">生成树个数:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="10"
					id="buildforest_nbtrees" data-options="required:true" style="width:100px" />
				</td>
				<td>回归问题使用此阈值</td>
			</tr>
			
			<tr>
				<td><label for="name">生成树是否完整:</label>
				</td>
				<td>
				<select id="buildforest_complete" class="easyui-combobox" 
					style="width:200px;">
						<option value="false">否</option>
						<option value="true">是</option>

				</select>
				</td>
			</tr>
			
			<tr>
				<td><a id="buildforest_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
	
	</div> 
	<script type="text/javascript" src="js/mr_classification.js"></script>  

</body>

