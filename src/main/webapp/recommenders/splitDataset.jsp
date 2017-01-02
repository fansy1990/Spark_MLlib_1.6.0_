<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">推荐算法--splitDataset</div>
	<br>
	<div style="padding-left: 30px;font-size: 15px;padding-top:10px;">
		<br> Split a recommendation dataset into a training and a test
		set：把推荐数据集分为训练和测试集<br>
	</div>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">
		<table>
			<tr>
				<td><label for="name">输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
					id="splitDataset_input" name="input" data-options="required:true"
					style="width:400px" value="/user/root/recommenders/splitDataset/input.txt" /></td>

			</tr>
			<tr>
				<td><label for="name">输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
					id="splitDataset_output" name="output" data-options="required:true"
					style="width:400px"
					value="/user/root/recommenders/splitDataset/train_test_output" /></td>

			</tr>
			<tr>
				<td><label for="name">训练数据占比:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
					id="splitDataset_trainPercent" value="0.9"
					data-options="required:true" /></td>
			</tr>
			<tr>
				<td><label for="name">测试数据占比:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
					id="splitDataset_testPercent" value="0.1"
					data-options="required:true" /></td>
			</tr>

			<tr>
				<td><a id="splitDataset_submit" href=""
					data-options="iconCls:'icon-door_in'" class="easyui-linkbutton">提交</a>
				</td>

			</tr>
		</table>
	</div>
	<script type="text/javascript" src="js/mr_recommenders.js"></script>
</body>

