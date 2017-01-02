<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">FuzzyKMeans聚类算法调用</div>  
	<br>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/clustering/fuzzykmeans/input.seq"
					id="fuzzykmeans_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/clustering/fuzzykmeans/output"
					id="fuzzykmeans_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">聚类中心路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/clustering/fuzzykmeans/clusters"
					id="fuzzykmeans_clusters" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">聚类个数:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="6"
					id="fuzzykmeans_k" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">收敛阈值:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="0.5"
					id="fuzzykmeans_convergenceDelta" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">最大循环次数:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="3"
					id="fuzzykmeans_maxIter" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">系数归一化因子:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="2"
					id="fuzzykmeans_m" data-options="required:true" style="width:300px" />
				</td>
				<td>必须大于1</td>
			</tr>
			
			<tr>
				<td><label for="name">对原始数据进行聚类:</label>
				</td>
				<td>
				<select id="fuzzykmeans_clustering" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="true">是</option>
						<option value="false">否</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td><label for="name">输出最相似向量或使用pdf阈值:</label>
				</td>
				<td>
				<select id="fuzzykmeans_emitMostLikely" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="true">输出最相似向量</option>
						<option value="false">使用pdf阈值</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td><label for="name">pdf阈值:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="0"
					id="fuzzykmeans_threshold" data-options="required:true" style="width:300px" />
				</td>
				<td>默认是0</td>
			</tr>
			
			<tr>
				<td><label for="name">距离算法:</label>
				</td>
				<td>
				<select id="fuzzykmeans_distanceMeasure" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="org.apache.mahout.common.distance.SquaredEuclideanDistanceMeasure">SquaredEuclidean</option>
						<option value="org.apache.mahout.common.distance.EuclideanDistanceMeasure">Euclidean</option>
						<option value="org.apache.mahout.common.distance.ManhattanDistanceMeasure">Manhattan</option>
						<option value="org.apache.mahout.common.distance.CosineDistanceMeasure">Cosine</option>
						<option value="org.apache.mahout.common.distance.TanimotoDistanceMeasure">Tanimoto</option>
						<option value="">未完待续。。。</option>
				</select>
				</td>
				<td><a id="fuzzykmeans_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
	
	</div> 
	<script type="text/javascript" src="js/mr_clustering.js"></script>  

</body>

