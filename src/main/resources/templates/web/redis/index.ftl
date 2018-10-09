<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>Redis缓存</title>
    <meta name="keywords" content="">
    <meta name="description" content="">

    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="${ctx!}/assets/css/bootstrap.min.css?v=3.3.6" rel="stylesheet">
    <link href="${ctx!}/assets/css/font-awesome.css?v=4.4.0" rel="stylesheet">

    <link href="${ctx!}/assets/css/plugins/bootstrap-table/bootstrap-table.min.css" rel="stylesheet">

    <link href="${ctx!}/assets/css/animate.css" rel="stylesheet">
    <link href="${ctx!}/assets/css/style.css?v=4.1.0" rel="stylesheet">

</head>

<body class="gray-bg">
    <div class="wrapper wrapper-content  animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox ">
                    <div class="ibox-title">
                        <h5>缓存管理</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-inline form-horizontal pb30" id="priceSearchForm">
                        <p>
                        	<#--<@shiro.hasPermission name="system:resource:add">
                        		<button class="btn btn-success " type="button" onclick="add();"><i class="fa fa-plus"></i>&nbsp;添加</button>
                        	</@shiro.hasPermission>-->
                            <div class="form-group mr20 mb10">
                                <label for=" " class="mr5">商品编码</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="input-goodSn" name="goodSn" value="" placeholder="请输入商品编码">
                                </div>
								<label for=" " class="mr5">仓库编码</label>
								<div class="input-group">
									<input type="text" class="form-control" id="input-warehouseCode" name="warehouseCode" value="" placeholder="请输入仓库编码">
								</div>
								<label for=" " class="mr5">渠道编码</label>
								<div class="input-group">
									<input type="text" class="form-control" id="input-pipelineCode" name="pipelineCode" value="" placeholder="请输入渠道编码">
								</div>
								<div class="button-bar">
									<button type="button" id="priceSearchBtn" class="btn btn-info">筛选</button>
                                    <button type="button" id="priceDelBtn" class="btn btn-info">删除</button>
								</div>
                            </div>
                        </p>
						</form>
                        <hr>
                        <div class="row row-lg">
		                    <div class="col-sm-12">
		                        <!-- Example Card View -->
		                        <div class="example-wrap">
		                            <div class="example">
		                            	<table id="table_list" class="table table-bordered" id="" cellpadding="0" cellspacing="0">
                                            <thead>
                                            <tr>
                                                <th>价格</th>
                                                <th>利润率</th>
                                                <th>组ID</th>
                                                <th>价格ID</th>
                                                <th>组名称</th>
                                                <th>系统标签</th>
                                                <th>运营标签</th>
                                                <th>开始时间</th>
                                                <th>结束时间</th>
                                                <th>备注</th>
                                                <th>说明</th>
                                            </tr>
                                            </thead>
                                            <tbody id="table_list_tbody">
                                                <tr>
                                                    <td colspan="11" align="center">没有找到匹配的记录</td>
                                                </tr>
                                            </tbody>
										</table>
		                            </div>
		                        </div>
		                        <!-- End Example Card View -->
		                    </div>
	                    </div>
                        <hr>
                        <form class="form-inline form-horizontal pb30" id="priceBatchDelForm">
                            <p>
                            <div class="form-group mr20 mb10">
                                <label for=" " class="mr5">商品(批量)</label>
                                <div class="input-group">
                                    <textarea class="col-sm-push-12" id="skus" name="skus"></textarea>
                                </div>
                                <label for=" " class="mr5">仓库编码</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="input-warehouseCode"
                                           name="warehouseCode" value="" placeholder="请输入仓库编码">
                                </div>
                                <label for=" " class="mr5">渠道编码</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="input-pipelineCode" name="pipelineCode"
                                           value="" placeholder="请输入渠道编码">
                                </div>
                                <div class="button-bar">
                                    <button type="button" id="priceBatchDelBtn" class="btn btn-info">批量删除</button>
                                </div>
                            </div>
                            </p>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- 全局js -->
    <script src="${ctx!}/assets/js/jquery.min.js?v=2.1.4"></script>
    <script src="${ctx!}/assets/js/bootstrap.min.js?v=3.3.6"></script>


	<!-- Bootstrap table -->
    <script src="${ctx!}/assets/js/plugins/bootstrap-table/bootstrap-table.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/bootstrap-table/bootstrap-table-mobile.min.js"></script>
    <script src="${ctx!}/assets/js/plugins/bootstrap-table/locale/bootstrap-table-zh-CN.min.js"></script>

    <!-- Peity -->
    <script src="${ctx!}/assets/js/plugins/peity/jquery.peity.min.js"></script>

    <script src="${ctx!}/assets/js/plugins/layer/layer.min.js"></script>

    <!-- 自定义js -->
    <script src="${ctx!}/assets/js/content.js?v=1.0.0"></script>
    <script src="${ctx!}/assets/js/json.js?v=1.0.0"></script>

	<script>
		/*$("#priceSearchBtn").bind("click", function() {

		});*/
        $("#priceSearchBtn").click(function() {
            var queryJson = $('#priceSearchForm').serializeFormJSON();
            //console.log(data);
			//alert(JSON.stringify(queryJson));
            $.ajax({
                type:'POST',
                contentType: 'application/json',
                url: '${ctx!}/web/redis/getPrice',
				data: JSON.stringify(queryJson),
                dataType:'json',  //返回格式为json
                success: function(data){
                    //alert(JSON.stringify(data));
                    if(data.code == '0'){
                        /*layer.msg("success", {icon: 1, time: 1000});*/
						var html = '';
                        if(data.data.length > 0) {
                            $.each(data.data, function(n, value) {
                                html +=
                                        '<tr>' +
                                        '<td>' + value.price + '</td>' +
                                        '<td>' + value.rates + '</td>' +
                                        '<td>' + value.conditionId + '</td>' +
                                        '<td>' + value.priceId + '</td>' +
                                        '<td>' + value.priceName + '</td>' +
                                        '<td>' + value.syslabelId + '</td>' +
                                        '<td>' + value.userLabelId + '</td>' +
                                        '<td>' + value.startTime + '</td>' +
                                        '<td>' + value.endTime + '</td>' +
                                        '<td>' + value.remark + '</td>' +
                                        '<td>' + value.declare + '</td>' +
                                        '</tr>';
							});
                            $("#table_list_tbody").html(html);
						}
						else {
                            layer.msg("查询不到数据", { icon: 7, time: 1500 });
                            $("#table_list_tbody").html(html);
						}
                    }
                    else {
						layer.msg(data.message, { icon: 7, time: 1500 });
					}
                },
                error:function(){
                    layer.msg('接口调用异常', { icon: 2 });
                }
            });
        });
	</script>

	<script>
		$("#priceDelBtn").bind("click", function() {
            var queryJson = $('#priceSearchForm').serializeFormJSON();
            $.ajax({
                type:'POST',
                contentType: 'application/json',
                url: '${ctx!}/web/redis/delPrice',
                data: JSON.stringify(queryJson),
                dataType:'json',
                success: function(data) {
                    if(data.code == '0') {
                        layer.msg("缓存删除成功", {icon: 1, time: 1000});
                    }
                    else {
                        layer.msg(data.message, { icon: 7, time: 1500 });
                    }
                },
                error:function(){
                    layer.msg('接口调用异常', { icon: 2 });
                }
            });
		});

        $("#priceBatchDelBtn").bind("click", function () {
            var queryJson = $('#priceBatchDelForm').serializeFormJSON();
            $.ajax({
                type: 'POST',
                contentType: 'application/json',
                url: '${ctx!}/web/redis/batchDelPrice',
                data: JSON.stringify(queryJson),
                dataType: 'json',
                success: function (data) {
                    if (data.code == '0') {
                        layer.msg("缓存批量删除成功", {icon: 1, time: 1000});
                    }
                    else {
                        layer.msg(data.message, {icon: 7, time: 1500});
                    }
                },
                error: function () {
                    layer.msg('接口调用异常', {icon: 2});
                }
            });
        });
	</script>

	<#--<script>
        // 价格参数校验
        (function($) {
            $('#priceSearchForm').validator({
                theme : 'yellow_right_effect',
                stopOnError : false,
                timely : 1,
                focusCleanup : true,
                focusInvalid : true,
                valid : function() {
                    alert("validate success.........");
                }
            });
        })(jQuery);
	</script>-->

    <!-- Page-Level Scripts -->
    <#--<script>
        $(document).ready(function () {
			//初始化表格,动态从服务器加载数据  
			$("#table_list").bootstrapTable({
			    //使用get请求到服务器获取数据  
			    method: "POST",
			    //必须设置，不然request.getParameter获取不到请求参数
			    contentType: "application/x-www-form-urlencoded",
			    //获取数据的Servlet地址  
			    url: "${ctx!}/admin/resource/list",
			    //表格显示条纹  
			    striped: true,
			    //启动分页  
			    pagination: true,
			    //每页显示的记录数  
			    pageSize: 10,
			    //当前第几页  
			    pageNumber: 1,
			    //记录数可选列表  
			    pageList: [5, 10, 15, 20, 25],
			    //是否启用查询  
			    search: true,
			    //是否启用详细信息视图
			    detailView:true,
			    detailFormatter:detailFormatter,
			    //表示服务端请求  
			    sidePagination: "server",
			    //设置为undefined可以获取pageNumber，pageSize，searchText，sortName，sortOrder  
			    //设置为limit可以获取limit, offset, search, sort, order  
			    queryParamsType: "undefined",
			    //json数据解析
			    responseHandler: function(res) {
			        return {
			            "rows": res.content,
			            "total": res.totalElements
			        };
			    },
			    //数据列
			    columns: [{
			        title: "ID",
			        field: "id",
			        sortable: true
			    },{
			        title: "资源名称",
			        field: "name"
			    },{
			        title: "资源KEY",
			        field: "sourceKey"
			    },{
			        title: "资源类型",
			        field: "type",
			        formatter: function(value,row,index){
			        	if(value == 0)
                    		return '<span class="label label-info">目录</span>';
                    	else if(value == 1)
                    		return '<span class="label label-primary">菜单</span>';
                    	else if(value == 2)
                    		return '<span class="label label-warning">按钮</span>';
			        }
			    },{
			        title: "资源URL",
			        field: "sourceUrl"
			    },{
			        title: "层级",
			        field: "level",
			        sortable: true
			    },{
			        title: "排序",
			        field: "sort",
			        sortable: true
			    },{
			        title: "图标",
			        field: "icon"
			    },{
			        title: "状态",
			        sortable: true,
			        field: "isHide",
                    formatter: function (value, row, index) {
                    	if(value == 0)
                    		return '<span class="label label-info">显示</span>';
                    	else if(value == 1)
                    		return '<span class="label label-danger">隐藏</span>';
                    }
			    },{
			        title: "创建时间",
			        field: "createTime",
			        sortable: true
			    },{
			        title: "更新时间",
			        field: "updateTime",
			        sortable: true
			    },{
			        title: "操作",
			        field: "empty",
                    formatter: function (value, row, index) {
                    	var operateHtml = '<@shiro.hasPermission name="system:resource:add"><button class="btn btn-primary btn-xs" type="button" onclick="edit(\''+row.id+'\')"><i class="fa fa-edit"></i>&nbsp;修改</button> &nbsp;</@shiro.hasPermission>';
                    	operateHtml = operateHtml + '<@shiro.hasPermission name="system:resource:deleteBatch"><button class="btn btn-danger btn-xs" type="button" onclick="del(\''+row.id+'\')"><i class="fa fa-remove"></i>&nbsp;删除</button></@shiro.hasPermission>';
                        return operateHtml;
                    }
			    }]
			});
        });
        
        function edit(id){
        	layer.open({
        	      type: 2,
        	      title: '资源修改',
        	      shadeClose: true,
        	      shade: false,
        	      area: ['893px', '600px'],
        	      content: '${ctx!}/admin/resource/edit/' + id,
        	      end: function(index){
        	    	  $('#table_list').bootstrapTable("refresh");
       	    	  }
        	    });
        }
        function add(){
        	layer.open({
        	      type: 2,
        	      title: '资源添加',
        	      shadeClose: true,
        	      shade: false,
        	      area: ['893px', '600px'],
        	      content: '${ctx!}/admin/resource/add',
        	      end: function(index){
        	    	  $('#table_list').bootstrapTable("refresh");
       	    	  }
        	    });
        }
        function del(id){
        	layer.confirm('确定删除吗?', {icon: 3, title:'提示'}, function(index){
        		$.ajax({
    	    		   type: "POST",
    	    		   dataType: "json",
    	    		   url: "${ctx!}/admin/resource/delete/" + id,
    	    		   success: function(msg){
	 	   	    			layer.msg(msg.message, {time: 2000},function(){
	 	   	    				$('#table_list').bootstrapTable("refresh");
	 	   	    				layer.close(index);
	 	   					});
    	    		   }
    	    	});
       		});
        }
        
        function detailFormatter(index, row) {
	        var html = [];
	        html.push('<p><b>描述:</b> ' + row.description + '</p>');
	        return html.join('');
	    }
    </script>-->

    
    

</body>

</html>
