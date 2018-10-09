<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>通用工具</title>
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
                        <h5>通用工具</h5>
                    </div>
                    <div class="ibox-content">
                        <form class="form-inline form-horizontal pb30" id="routerSearchForm">
                        <p>
                        	<#--<@shiro.hasPermission name="system:resource:add">
                        		<button class="btn btn-success " type="button" onclick="add();"><i class="fa fa-plus"></i>&nbsp;添加</button>
                        	</@shiro.hasPermission>-->
                            <div class="form-group mr20 mb10">
                                <label for=" " class="mr5">分表字段</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="input-router" name="router" value="" placeholder="请输入相应的分表值">
                                </div>
                                <label for=" " class="mr5">分表结果</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="input-routerResult" name="routerResult">
                                </div>
								<div class="button-bar">
									<button type="button" id="routerSearchBtn" class="btn btn-info">确定</button>
								</div>
                            </div>
                        </p>
						</form>
                        <hr>
                        <form class="form-inline form-horizontal pb30" id="sqlForm">
                            <p>
                            <div class="form-group mr20 mb10">
                                <label for=" " class="mr5">SKU(批量)</label>
                                <div class="input-group">
                                    <textarea class="col-sm-push-12" id="skus" name="skus" placeholder="请输入SKU"></textarea>
                                </div>
                                <label for=" " class="mr5">价格类型</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="input-sysLabelId" name="sysLabelId" value="" placeholder="请输入系统标签">
                                </div>
                                <label for=" " class="mr5">渠道编码</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="input-pipelineCode" name="pipelineCode" value="" placeholder="请输入渠道编码">
                                </div>
                                <label for=" " class="mr5">模板ID</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="input-templateId" name="templateId" value="" placeholder="请输入模板ID">
                                </div>
                                <label for=" " class="mr5">仓库编码</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="input-warehouseCode" name="warehouseCode" value="" placeholder="请输入仓库编码">
                                </div>
                                <label for=" " class="mr5">组名称</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="input-priceName" name="priceName" value="" placeholder="请输入组名称">
                                </div>
                                <div class="button-bar">
                                    <button type="button" id="deleteSqlBtn" class="btn btn-info">生成删除sql</button>
                                    <button type="button" id="selectSqlBtn" class="btn btn-info">生成查询sql</button>
                                </div>
                            </div>
                            </p>
                        </form>
                        <hr>
                        <div class="form-group mr20 mb10" style="display: none" id="sqlResultDiv">
                            <label for=" " class="mr5">SQL语句</label>
                            <div class="input-group">
                                <textarea class="col-sm-push-12" id="sql" name="sql"></textarea>
                            </div>
                        </div>
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
		$("#routerSearchBtn").bind("click", function() {
            var router = $("#input-router").val();
            $.ajax({
                type:'GET',
                url: '${ctx!}/web/common/router',
                data: {router: $("#input-router").val()},
                //data: router,
                //dataType:'json',
                success: function(data) {
                    var result = JSON.parse(data);
                    if(result.code == '0' || result.code == 0) {
                        $("#input-routerResult").val(result.data);
                        layer.msg("获取分表结果：" + result.data, {icon: 1, time: 1000});
                    }
                    else {
                        layer.msg(result.message, { icon: 7, time: 1500 });
                    }
                },
                error:function() {
                    layer.msg('接口调用异常', { icon: 2 });
                }
            });
		});
	</script>

    <script>
        $("#deleteSqlBtn").bind("click", function(){
            $("#sqlResultDiv").attr("style","display:none;");
            var queryJson = $('#sqlForm').serializeFormJSON();
            $.ajax({
                type:'POST',
                contentType: 'application/json',
                url: '${ctx!}/web/common/generateDeleteSql',
                data: JSON.stringify(queryJson),
                dataType:'json',
                success: function(data) {
                    if(data.code == '0') {
                        layer.msg("sql语句已生成", {icon: 1, time: 1000});
                        $("#sqlResultDiv").attr("style","display:block;");
                        $("#sql").text(data.data);
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

        $("#selectSqlBtn").bind("click", function(){
            $("#sqlResultDiv").attr("style","display:none;");
            var queryJson = $('#sqlForm').serializeFormJSON();
            $.ajax({
                type:'POST',
                contentType: 'application/json',
                url: '${ctx!}/web/common/generateSelectSql',
                data: JSON.stringify(queryJson),
                dataType:'json',
                success: function(data) {
                    if(data.code == '0') {
                        layer.msg("sql语句已生成", {icon: 1, time: 1000});
                        $("#sqlResultDiv").attr("style","display:block;");
                        $("#sql").text(data.data);
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

</body>

</html>
