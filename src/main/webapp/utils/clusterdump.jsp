<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">聚类中心文件查看</div>  
	<br>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">聚类中西路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
					value="/user/root/clustering/kmeans/output/clusters-3-final"
					id="readcluster_input" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			
			<tr>
				<td><label for="name">聚类数据路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
					value="/user/root/clustering/kmeans/output/clusteredPoints/part-m-00000"
					id="readcluster_points" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">每个聚类展示的数据点:</label>
				</td>
				<td>
				<select id="readcluster_include_per_cluster" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="-1">全部</option>
						<option value="1">1个</option>
						<option value="2">2个</option>
						<option value="3">3个</option>
						<option value="5">5个</option> 
						<option value="10">10个</option>
						<option value="50">50个</option>
				</select>
				</td>
			</tr>
			
			<tr>
				<td><label for="name">距离算法:</label>
				</td>
				<td>
				<select id="readcluster_distanceMeasure" class="easyui-combobox" name="dept"
					style="width:200px;">
						<option value="org.apache.mahout.common.distance.SquaredEuclideanDistanceMeasure">SquaredEuclidean</option>
						<option value="org.apache.mahout.common.distance.EuclideanDistanceMeasure">Euclidean</option>
						<option value="org.apache.mahout.common.distance.ManhattanDistanceMeasure">Manhattan</option>
						<option value="org.apache.mahout.common.distance.CosineDistanceMeasure">Cosine</option>
						<option value="org.apache.mahout.common.distance.TanimotoDistanceMeasure">Tanimoto</option>
						<option value="">未完待续。。。</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><a id="readcluster_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">读取</a></td>
			</tr>
			
		</table>
	
	</div> 
	<div id="readcluster_return" style="padding-left: 30px;font-size: 12px;padding-top:10px;"></div>
	<script type="text/javascript" src="js/preprocess.js"></script>  

</body>

