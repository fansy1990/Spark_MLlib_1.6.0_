<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<body>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">itemsimilarity算法调用</div>  
	<br>
	<div style="padding-left: 30px;font-size: 20px;padding-top:10px;">  
	 
		<table>
			<tr>
				<td><label for="name">HDFS输入路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text"
				 value="/user/root/recommenders/itemsimilarity/input.csv"
					id="itemsimilarity_input" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">HDFS输出路径:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" 
				 value="/user/root/recommenders/itemsimilarity/output"
					id="itemsimilarity_output" data-options="required:true" style="width:400px" />
				</td>
			</tr>
			<tr>
				<td><label for="name">输入数据是否包含评分值:</label>
				</td>
				<td>
				<select id="itemsimilarity_b" class="easyui-combobox" 
					style="width:200px;">
						<option value="true">包含</option>
						<option value="false">不包含</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><label for="name">minPrefsPerUser:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="1"
					id="itemsimilarity_mp" data-options="required:true" style="width:100px" />
				</td>
				<td>在计算相似度时，用户最小的参考数，如果用户的参考数低于此数值，用户将会被忽略</td>
			</tr>
			<tr>
				<td><label for="name">maxSimilaritiesPerItem:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="100"
					id="itemsimilarity_m" data-options="required:true" style="width:100px" />
				</td>
				<td>每个项目最大的相似度个数</td>
			</tr>
			<tr>
				<td><label for="name">maxPrefsInItemSimilarity:</label>
				</td>
				<td><input class="easyui-validatebox" type="text" value="500"
					id="itemsimilarity_mppu" data-options="required:true" style="width:100px" />
				</td>
				<td>在计算项目相似度时，每个用户或项目最大的参考个数，大于此值将会被采样处理</td>
			</tr>
			<tr>
				<td><label for="name">相似度算法:</label>
				</td>
				<td>
				<select id="itemsimilarity_s" class="easyui-combobox" 
					style="width:300px;">
						<option value="SIMILARITY_COOCCURRENCE">SIMILARITY_COOCCURRENCE</option>
						<option value="SIMILARITY_LOGLIKELIHOOD">SIMILARITY_LOGLIKELIHOOD</option>
						<option value="SIMILARITY_TANIMOTO_COEFFICIENT">SIMILARITY_TANIMOTO_COEFFICIENT</option>
						<option value="SIMILARITY_CITY_BLOCK">SIMILARITY_CITY_BLOCK</option>
						<option value="SIMILARITY_COSINE">SIMILARITY_COSINE</option>
						<option value="SIMILARITY_PEARSON_CORRELATION">SIMILARITY_PEARSON_CORRELATION</option>
						<option value="SIMILARITY_EUCLIDEAN_DISTANCE">SIMILARITY_EUCLIDEAN_DISTANCE</option>
				</select>
				</td>
			</tr>
			<tr>
				<td><a id="itemsimilarity_submit" class="easyui-linkbutton"
					data-options="iconCls:'icon-door_in'">提交</a></td>
			</tr>
		</table>
	</div> 
	<script type="text/javascript" src="js/mr_recommenders.js"></script>  

</body>

