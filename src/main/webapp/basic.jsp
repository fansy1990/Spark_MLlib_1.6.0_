<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
	<meta charset="UTF-8">
	<title>Spark Algorithm</title>
	<link rel="stylesheet" type="text/css" href="themes/ui-sunny/easyui.css">
	<link rel="stylesheet" type="text/css" href="themes/icon.css">
	<link rel="stylesheet" type="text/css" href="css/demo.css">
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="js/basic.js"></script>
	
</head>
	
<body  class="easyui-layout">
	
	<div data-options="region:'north',border:false" style="height:60px;background:#feeebd;padding:10px;">
	    <h1 style="font-size:20px">Spark Algorithm Platform</h1>
    </div>
	<div data-options="region:'west',split:true,title:'导航'" style="width:220px;padding:10px;">
		<ul id="navid" class="easyui-tree" data-options="url:'tree_data.json',method:'get',animate:true,dnd:true"></ul>
	</div>
	<!-- 
	<div data-options="region:'east',split:true,collapsed:true,title:'East'" style="width:100px;padding:10px;">east region</div>
	 -->
	<div data-options="region:'south',border:false" style="height:30px;background:#817865;padding:3px;">
		<h2 style="text-align:center"> © Copyright 版权所有</h2>
	</div>
	
	<div  data-options="region:'center',title:'内容'">
		<div id="layout_center_tabs" class="easyui-tabs" data-options="fit:true" >
			<div title="Welcome" data-options="href:'about.html',iconCls:'icon-tip'"></div>
		</div>
	</div>
	
</body>
</html>