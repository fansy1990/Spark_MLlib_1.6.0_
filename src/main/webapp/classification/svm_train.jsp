<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">SVM模型训练任务算法调用</div>
	<br>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label >数据输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="hdfs://quickstart:8020/user/algorithm/input/svm.dat"
					id="svm_train_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label >数据最小Partition个数:</label>
                </td>
                <td><input class="easyui-numberbox" value="1" data-options="min:1,precision:0"
                           id="svm_train_minPartitions"  />
                </td>
            </tr>
			<tr>
				<td><label >模型输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="hdfs://quickstart:8020/user/algorithm/model/svm/output00"
					id="svm_train_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label >数据列分隔符:</label>
                </td>
                <td><input class="easyui-validatebox" type="text"
                           value=" "
                           id="svm_train_splitter" data-options="required:true" style="width:300px" />
                </td>
            </tr>
			<tr>
				<td><label>目标所在列（从1开始）:</label>
				</td>
				<td><input class="easyui-numberbox" value="1" data-options="min:1,precision:0"
					id="svm_train_targetIndex"  style="width:300px" />
				</td>
			</tr>

			<tr>
				<td><label >正则化函数:</label>
				</td>
				<td>
				<select id="svm_train_regMethod" class="easyui-combobox"
					style="width:200px;">
						<option value="L1">L1</option>
						<option value="L2">L2</option>

				</select>
				</td>
			</tr>

            <tr>
                <td><label>循环次数:</label>
                </td>
                <td><input class="easyui-numberbox" value="100" data-options="min:10,precision:0"
                           id="svm_train_numIteration"  style="width:300px" />
                </td>
            </tr>
            <tr>
                <td><label>步进:</label>
                </td>
                <td><input class="easyui-numberbox" value="1.0" data-options="min:0.0,precision:1"
                           id="svm_train_stepSize"  style="width:300px" />
                </td>
            </tr>
            <tr>
                <td><label>正则参数:</label>
                </td>
                <td><input class="easyui-numberbox" value="0.01" data-options="min:0.00,precision:2"
                           id="svm_train_regParam"  style="width:300px" />
                </td>
            </tr>
            <tr>
                <td><label>批处理粒度:</label>
                </td>
                <td><input class="easyui-numberbox" value="1.0" data-options="min:0.1,precision:1,max:1.0"
                           id="svm_train_minBatchFraction"  style="width:300px" />
                </td>
            </tr>
			<tr>
				<td><a id="svm_train_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
        <br>
        <div id="SVMCallable_id" style="padding-left: 30px;font-size: 14px;padding-top:10px;"></div>
	</div> 
	<script type="text/javascript" src="js/mr_classification.js"></script>  

</body>

