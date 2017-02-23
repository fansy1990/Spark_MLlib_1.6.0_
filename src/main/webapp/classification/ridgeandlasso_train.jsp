<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">岭回归与套索回归模型训练任务算法调用</div>
	<br>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label >数据输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="hdfs://quickstart:8020/user/algorithm/input/ridgeandlasso.dat"
					id="ridgeandlasso_train_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label >数据最小Partition个数:</label>
                </td>
                <td><input class="easyui-numberbox" value="1" data-options="min:1,precision:0"
                           id="ridgeandlasso_train_minPartitions"  />
                </td>
            </tr>
			<tr>
				<td><label >模型输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="hdfs://quickstart:8020/user/algorithm/model/ridgeadnlasso/output00"
					id="ridgeandlasso_train_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label >数据列分隔符:</label>
                </td>
                <td><input class="easyui-validatebox" type="text"
                           value=" "
                           id="ridgeandlasso_train_splitter" data-options="required:true" style="width:300px" />
                </td>
            </tr>
			<tr>
				<td><label>目标所在列（从1开始）:</label>
				</td>
				<td><input class="easyui-numberbox" value="1" data-options="min:1,precision:0"
					id="ridgeandlasso_train_targetIndex"  style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label>循环次数:</label>
                </td>
                <td><input class="easyui-numberbox" value="100" data-options="min:1,precision:0"
                           id="ridgeandlasso_train_numIteration"  style="width:300px" />
                </td>
            </tr>
            <tr>
                <td><label>步进:</label>
                </td>
                <td><input class="easyui-numberbox" value="1.0" data-options="min:1,precision:0.1"
                           id="ridgeandlasso_train_stepSize"  style="width:300px" />
                </td>
            </tr>
            <tr>
                <td><label>正则参数:</label>
                </td>
                <td><input class="easyui-numberbox" value="0.01" data-options="min:0.01,precision:0.001"
                           id="ridgeandlasso_train_regParam"  style="width:300px" />
                </td>
            </tr>
            <tr>
                <td><label>批处理力度:</label>
                </td>
                <td><input class="easyui-numberbox" value="1.0" data-options="min:1,precision:0"
                           id="ridgeandlasso_train_miniBatchFraction"  style="width:300px" />
                </td>
            </tr>
			<tr>
				<td><label >逻辑回归函数:</label>
				</td>
				<td>
				<select id="ridgeandlasso_train_regressionType" class="easyui-combobox"
					style="width:200px;">
						<option value="RIDGE">岭回归</option>
						<option value="LASSO">套索回归</option>

				</select>
				</td>
			</tr>
            <tr>
                <td><label >是否有截距:</label>
                </td>
                <td>
                    <select id="ridgeandlasso_train_hasIntercept" class="easyui-combobox"
                            style="width:200px;">
                        <option value="true">是</option>
                        <option value="false">否</option>

                    </select>
                </td>
            </tr>
            

			<tr>
				<td><a id="ridgeandlasso_train_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
        <br>
        <div id="RidgeAndLassoCallable_id" style="padding-left: 30px;font-size: 14px;padding-top:10px;"></div>
	</div> 
	<script type="text/javascript" src="js/mr_classification.js"></script>  

</body>

