<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">Decision Tree模型训练任务算法调用</div>
	<br>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label >数据输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="hdfs://quickstart:8020/user/algorithm/input/decisiontree.dat"
					id="decisiontree_train_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label >数据最小Partition个数:</label>
                </td>
                <td><input class="easyui-numberbox" value="1" data-options="min:1,precision:0"
                           id="decisiontree_train_minPartitions"  />
                </td>
            </tr>
			<tr>
				<td><label >模型输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="hdfs://quickstart:8020/user/algorithm/model/decisiontree/output00"
					id="decisiontree_train_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label >数据列分隔符:</label>
                </td>
                <td><input class="easyui-validatebox" type="text"
                           value=" "
                           id="decisiontree_train_splitter" data-options="required:true" style="width:300px" />
                </td>
            </tr>
			<tr>
				<td><label>目标所在列（从1开始）:</label>
				</td>
				<td><input class="easyui-numberbox" value="1" data-options="min:1,precision:0"
					id="decisiontree_train_targetIndex"  style="width:300px" />
				</td>
			</tr>

			<tr>
				<td><label >不纯度函数:(分类有用，否则固定variance)</label>
				</td>
				<td>
				<select id="decisiontree_train_impurity" class="easyui-combobox"
					style="width:200px;">
						<option value="entropy">entropy</option>
						<option value="gini">gini</option>

				</select>
				</td>
			</tr>

            <tr>
                <td><label>树最大深度:</label>
                </td>
                <td><input class="easyui-numberbox" value="10" data-options="min:10,precision:0"
                           id="decisiontree_train_maxDepth"  style="width:300px" />
                </td>
            </tr>
            <tr>
                <td><label>分类Or回归:</label>
                </td>
                <td>
                    <select id="decisiontree_train_algo" class="easyui-combobox"
                            style="width:200px;">
                        <option value="classification">分类</option>
                        <option value="regression">回归</option>

                    </select>
                </td>
            </tr>
            <tr>
                <td><label>分裂数据集个数:</label>
                </td>
                <td><input class="easyui-numberbox" value="32" data-options="min:1,precision:1"
                           id="decisiontree_train_maxBins"  style="width:300px" />
                </td>
            </tr>
            <tr>
                <td><label>目标类个数:</label>
                </td>
                <td><input class="easyui-numberbox" value="2" data-options="min:2,precision:1"
                           id="decisiontree_train_numClasses"  style="width:300px" />
                </td>
            </tr>
			<tr>
				<td><a id="decisiontree_train_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
        <br>
        <div id="DecisionTreeCallable_id" style="padding-left: 30px;font-size: 14px;padding-top:10px;"></div>
	</div> 
	<script type="text/javascript" src="js/mr_classification.js"></script>  

</body>

