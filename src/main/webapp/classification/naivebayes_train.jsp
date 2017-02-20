<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">Naive Bayes模型训练任务算法调用</div>
	<br>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label >数据输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="hdfs://quickstart:8020/user/algorithm/input/naivebayes.dat"
					id="naivebayes_train_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label >数据最小Partition个数:</label>
                </td>
                <td><input class="easyui-numberbox" value="1" data-options="min:1,precision:0"
                           id="naivebayes_train_minPartitions"  />
                </td>
            </tr>
			<tr>
				<td><label >模型输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="hdfs://quickstart:8020/user/algorithm/model/naivebayes/output00"
					id="naivebayes_train_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
            <tr>
                <td><label >数据列分隔符:</label>
                </td>
                <td><input class="easyui-validatebox" type="text"
                           value=" "
                           id="naivebayes_train_splitter" data-options="required:true" style="width:300px" />
                </td>
            </tr>
			<tr>
				<td><label>目标所在列（从1开始）:</label>
				</td>
				<td><input class="easyui-numberbox" value="1" data-options="min:1,precision:0"
					id="naivebayes_train_targetIndex"  style="width:300px" />
				</td>
			</tr>

			<tr>
				<td><label >函数类型:</label>
				</td>
				<td>
				<select id="naivebayes_train_modelType" class="easyui-combobox"
					style="width:200px;">
						<option value="multinomial">多项式</option>
						<option value="bernoulli">伯努利</option>

				</select>
				</td>
			</tr>

            <tr>
                <td><label>平滑度:</label>
                </td>
                <td><input class="easyui-numberbox" value="10" data-options="min:0,precision:0.1"
                           id="naivebayes_train_lambda"  style="width:300px" />
                </td>
            </tr>

			<tr>
				<td><a id="naivebayes_train_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
        <br>
        <div id="NaiveBayesCallable_id" style="padding-left: 30px;font-size: 14px;padding-top:10px;"></div>
	</div> 
	<script type="text/javascript" src="js/mr_classification.js"></script>  

</body>

