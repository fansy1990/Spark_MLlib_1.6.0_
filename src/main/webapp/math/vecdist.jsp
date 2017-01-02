<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">VectorDistanceSimilarityJob任务运行</div>  
	<br>
	 
	<div style="padding-left: 30px;font-size: 15px;padding-top:10px;"><br>
		求两个文件中的向量之间两两距离<br>
	</div>
	 
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				value="/user/root/prepare/inputdriver/output/part-m-00000"
					id="vecdist_input" data-options="required:true" style="width:350px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">HDFS输入路径2:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				value="/user/root/prepare/inputdriver/output/part-m-00000"
					id="vecdist_seed" data-options="required:true" style="width:350px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/math/vecdist/output"
					id="vecdist_output" data-options="required:true" style="width:350px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">距离最大值:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="-1"
					id="vecdist_mx" data-options="required:true" style="width:300px" />
				</td>
				<td>使用-1表示最大值</td>
			</tr>
			
			<tr>
				<td><label for="name">输出格式:</label>
				</td>
				<td>
				<select id="vecdist_outtype" class="easyui-combobox" name="dept"
					style="width:500px;">
						<option value="pw">&lt;seed, other, distance&gt;</option>
						<option value="v">&lt;other, &lt;Vector of size the number of seeds&gt;&gt;</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td><label for="name">距离算法:</label>
				</td>
				<td>
				<select id="vecdist_distanceMeasure" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="org.apache.mahout.common.distance.SquaredEuclideanDistanceMeasure">SquaredEuclidean</option>
						<option value="org.apache.mahout.common.distance.EuclideanDistanceMeasure">Euclidean</option>
						<option value="org.apache.mahout.common.distance.ManhattanDistanceMeasure">Manhattan</option>
						<option value="org.apache.mahout.common.distance.CosineDistanceMeasure">Cosine</option>
						<option value="org.apache.mahout.common.distance.TanimotoDistanceMeasure">Tanimoto</option>
						<option value="">未完待续。。。</option>
				</select>
				</td>
				<td><a id="vecdist_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
	
	</div> 
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

