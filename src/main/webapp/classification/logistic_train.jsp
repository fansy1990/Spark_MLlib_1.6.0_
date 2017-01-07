<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">逻辑回归模型训练任务算法调用</div>
	<br>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label >数据输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="hdfs://quickstart:8020/user/algorithm/input/logistic.dat"
					id="logistic_train_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label >数据最小Partition个数:</label>
                </td>
                <td><input class="easyui-numberbox" value="1" data-options="min:1,precision:0"
                           id="logistic_train_minPartitions"  />
                </td>
            </tr>
			<tr>
				<td><label >模型输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="hdfs://quickstart:8020/user/algorithm/model/logistic/output00"
					id="logistic_train_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label >数据列分隔符:</label>
                </td>
                <td><input class="easyui-validatebox" type="text"
                           value=" "
                           id="logistic_train_splitter" data-options="required:true" style="width:300px" />
                </td>
            </tr>
			<tr>
				<td><label>目标所在列（从1开始）:</label>
				</td>
				<td><input class="easyui-numberbox" value="1" data-options="min:1,precision:0"
					id="logistic_train_targetIndex"  style="width:300px" />
				</td>
			</tr>

			<tr>
				<td><label >逻辑回归函数:</label>
				</td>
				<td>
				<select id="logistic_train_method" class="easyui-combobox"
					style="width:200px;">
						<option value="SGD">SGD</option>
						<option value="LBFGS">LBFGS</option>

				</select>
				</td>
			</tr>
            <tr>
                <td><label >是否有截距:</label>
                </td>
                <td>
                    <select id="logistic_train_hasIntercept" class="easyui-combobox"
                            style="width:200px;">
                        <option value="true">是</option>
                        <option value="false">否</option>

                    </select>
                </td>
            </tr>
            <tr>
                <td><label>目标列类别数:</label>
                </td>
                <td><input class="easyui-numberbox" value="2" data-options="min:1,precision:0"
                           id="logistic_train_numClasses"  style="width:300px" />
                </td>
            </tr>

			<tr>
				<td><a id="logistic_train_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
        <br>
        <div id="LogisticCallable_id" style="padding-left: 30px;font-size: 14px;padding-top:10px;"></div>
	</div> 
	<script type="text/javascript" src="js/mr_classification.js"></script>  

</body>

