<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">KMeans聚类算法调用</div>  
	<br>
	
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/clustering/kmeans/input.seq"
					id="kmeans_input" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/clustering/kmeans/output"
					id="kmeans_output" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">聚类中心路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="/user/root/clustering/kmeans/clusters"
					id="kmeans_clusters" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">聚类个数:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="6"
					id="kmeans_k" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">收敛阈值:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="0.5"
					id="kmeans_convergenceDelta" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">最大循环次数:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="3"
					id="kmeans_maxIter" data-options="required:true" style="width:300px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">对原始数据进行聚类:</label>
				</td>
				<td>
				<select id="kmeans_clustering" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="true">是</option>
						<option value="false">否</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><label for="name">距离算法:</label>
				</td>
				<td>
				<select id="kmeans_distanceMeasure" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="org.apache.mahout.common.distance.SquaredEuclideanDistanceMeasure">SquaredEuclidean</option>
						<option value="org.apache.mahout.common.distance.EuclideanDistanceMeasure">Euclidean</option>
						<option value="org.apache.mahout.common.distance.ManhattanDistanceMeasure">Manhattan</option>
						<option value="org.apache.mahout.common.distance.CosineDistanceMeasure">Cosine</option>
						<option value="org.apache.mahout.common.distance.TanimotoDistanceMeasure">Tanimoto</option>
						<option value="">未完待续。。。</option>
				</select>
				</td>
				<td><a id="kmeans_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
			
		</table>
	
	</div> 
	<script type="text/javascript" src="js/mr_clustering.js"></script>  

</body>

