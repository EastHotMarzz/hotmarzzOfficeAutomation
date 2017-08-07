<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<style type="text/css">
	
</style>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>菜单授权管理 - 东方黑玛oa系统</title>

<meta name="description" content="Static &amp; Dynamic Tables" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->

<!-- text fonts -->
<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
<link rel="stylesheet" href="assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="assets/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="assets/js/html5shiv.min.js"></script>
		<script src="assets/js/respond.min.js"></script>
		<![endif]-->
<link rel="stylesheet" href="assets/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet"
	href="assets/css/bootstrap-datetimepicker.min.css" />


<script src="assets/js/custom/date-utils.js"></script>
<link rel="stylesheet" href="assets/css/custom/table-custom.css" />
</head>

<body class="skin-1">
	
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">东方黑玛oa系统</a>
					</li>
					<li><a href="#">系统权限管理</a></li>
					<li class="active">菜单授权管理</li>
				</ul>
			</div>

			<div class="page-content">
				<div class="ace-settings-container" id="ace-settings-container">
				</div>
				<!-- /.ace-settings-container -->

				<div class="page-header">
					<h1>
						系统权限管理 <small> <i class="ace-icon fa fa-angle-double-right"></i>
							菜单授权管理
						</small>
					</h1>
				</div>
				
				<div id="alertDiv" class="alert alert-warning hidden">
									<a class="close" href="#">
										<i class="ace-icon fa fa-times"></i>
									</a>
				</div>
				
				<!-- /.page-header -->

				<div class="row">
					<div class="col-sm-12">
						<div class="widget-box">
							<div class="widget-header widget-header-flat widget-header-small">
								<h5 class="widget-title">
									<i class="ace-icon fa fa-search"></i> 菜单授权管理
								</h5>

								<div class="widget-toolbar no-border">
									<div class="btn-toolbar">
										<div class="btn-group">
											<button id="searchButton"
												class="btn btn-sm btn-success btn-white btn-round">
												<i class="ace-icon fa fa-search bigger-110 green"></i> 查询
											</button>
										</div>
										<div class="btn-group">
											<button id="clearButton"
												class="btn btn-sm btn-success btn-white btn-round">
												<i class="ace-icon fa fa-search bigger-110 green"></i> 清空
											</button>
										</div>
									</div>
								</div>
							</div>

							<div class="widget-body">
								<div class="widget-main">
									<form:form id="searchForm"
										modelAttribute="bq" method="post" cssClass="form-horizontal"
										role="form">
										<div class="form-group">
											<form:label path="queryParams[roleId]"
												cssClass="col-sm-2 control-label no-padding-right">角色名称:</form:label>
											<div class="col-sm-3">
												<form:select path="queryParams[roleId]">
													<form:option value="-1">--请选择角色--</form:option>
													<c:if test="${! empty roles }">
														<c:forEach items="${roles }" var="role">
															<form:option value="${role.roleId }">${role.roleName }</form:option>
														</c:forEach>
													</c:if>
												</form:select>
											</div>

											<form:hidden id="current_page" path="pag.current_page" />
											<form:hidden id="total_page" path="pag.total_page" />
										</div>
									</form:form>
								</div>
								<!-- /.widget-main -->
							</div>
							<!-- /.widget-body -->
						</div>
						<!-- /.widget-box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->

				<div class="row">
					<div class="col-sm-12">
						<div class="widget-box">
							<div class="widget-header widget-header-flat widget-header-small">
								<h5 class="widget-title">
									<i class="ace-icon fa fa-database"></i> 菜单授权管理

								</h5>
								<div class="widget-toolbar">
									<div class="btn-toolbar">
										<div class="btn-group">
											<button id="addButton"
												class="btn btn-sm btn-success btn-white btn-round"
												value="menuGrant.do">
												<i class="ace-icon fa fa-plus bigger-110 green"></i> 菜单授权
											</button>
											<div class="tableTools-container"></div>
										</div>
									</div>

								</div>
							</div>

							<div class="widget-body">
								<div class="widget-main">
									<table id="main-table"
										class="table table-striped table-bordered table-hover">
									</table>
								</div>
								<!-- /.widget-main -->
							</div>
							<!-- /.widget-body -->
						</div>
						<!-- /.widget-box -->
					</div>
					<!-- /.col -->
				</div>

			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->

	<!-- /.main-container -->

	<!-- basic scripts -->

	<!--[if !IE]> -->
	<script src="assets/js/jquery-2.1.4.min.js"></script>

	<!-- <![endif]-->

	<!--[if IE]>
<script src="assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
	<script type="text/javascript">
		if ('ontouchstart' in document.documentElement)
			document
					.write("<script src='assets/js/jquery.mobile.custom.min.js'>"
							+ "<"+"/script>");
	</script>

	<!-- page specific plugin scripts -->
	<script src="assets/js/jquery.dataTables.min.js"></script>
	<script src="assets/js/jquery.dataTables.bootstrap.min.js"></script>
	<script src="assets/js/dataTables.buttons.min.js"></script>
	<script src="assets/js/buttons.flash.min.js"></script>
	<script src="assets/js/buttons.html5.min.js"></script>
	<script src="assets/js/buttons.print.min.js"></script>
	<script src="assets/js/buttons.colVis.min.js"></script>
	<script src="assets/js/dataTables.select.min.js"></script>

	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {

			var bq = {
				'pag' : {
					'current_page' : '1',
					'page_size' : '10'
				},
				'queryParams' : {}
			};

			var lang = {
				"sProcessing" : "处理中...",
				"sLengthMenu" : "每页 _MENU_ 项",
				"sZeroRecords" : "没有匹配结果",
				"sInfo" : "当前显示第 _START_ 至 _END_ 项，共 _TOTAL_ 项。",
				"sInfoEmpty" : "当前显示第 0 至 0 项，共 0 项",
				"sInfoFiltered" : "(由 _MAX_ 项结果过滤)",
				"sInfoPostFix" : "",
				"sSearch" : "搜索:",
				"sUrl" : "",
				"sEmptyTable" : "表中数据为空",
				"sLoadingRecords" : "载入中...",
				"sInfoThousands" : ",",
				"oPaginate" : {
					"sFirst" : "首页",
					"sPrevious" : "上页",
					"sNext" : "下页",
					"sLast" : "末页",
					"sJump" : "跳转"
				}, 
				"oAria" : {
					"sSortAscending" : ": 以升序排列此列",
					"sSortDescending" : ": 以降序排列此列"
				}
			};

			var preParams = function() {
				var current_page = $(":input[name='pag.current_page']").val();
				if (current_page != undefined && current_page != null
						&& current_page < 1) {
					bq.pag.current_page = 1;
				} else {
					bq.pag.current_page = current_page;
				}
				bq.pag.page_size = $("select[name='main-table_length']").val();
				if($(":input[name='queryParams[roleId]']")!=null&&$(":input[name='queryParams[roleId]']")!=undefined){
					if( $(":input[name='queryParams[roleId]']").val()!="-1"){
						bq.queryParams.roleId = $(":input[name='queryParams[roleId]']").val();
					}else{
						delete bq.queryParams.roleId;
					}
				}
				return JSON.stringify(bq);
			}

			
			var writeParams = function(result) {
				$(":input[name='queryParams[roleId]']").val(
						result.queryParams.roleId);
				$(":input[name='pag.current_page']").val(
						result.pag.current_page);
				$(":input[name='pag.total_page']").val(result.pag.total_page);
			}

			var tableColumn = [
					{
						data : "role",
						title : "所属角色",
						render : function(data, type, full, meta) {
							if(data!=null){
								return data.roleName;
							}
							return "";
						}
					},
					{
						data : "resources",
						title : "授予菜单",
						render : function(data, type, full, meta) {
							var menuNames = '';
							if(data!=null){
								var i = 0;
								$.each(data,function(index,item){
									i++;
									if(i%3==0){
										menuNames += item.menuName + ",<br/>" 
									}else{
										menuNames += item.menuName + ","
									}
									
								})
								menuNames = menuNames.substring(0,menuNames.lastIndexOf(","));
							}
							return menuNames;
						},
					}
					
					/* ,
					{
						title : "操作",
						data : function( row, type, val, meta ) {
							var id = row['role'].roleId;
							var str = "<a class='update blue' href='menuGrant/"+id+".do' data-toggle='modal'>修改</a>"
									+ "&nbsp;&nbsp;";
							
							return str;
						}
					}  */];

			var mainTable = $("#main-table")
					.dataTable(
							{
								oLanguage : lang,
								paging: false,
								//bPaginate : true,
								pageLength : 10,
								//pagingType : "full_numbers",
								searching:false,
								columnDefs : [
								//targets定义哪一列，可以是数组，0代表左起第一列，_all代表所有
								{
									"targets" : "_all",
									"className" : "centerCell"
								} ],
								//必须加这句话，fnDraw()时才会重新加载数据
								"bServerSide" : true,
								ajax : {
									"url" : "getMenuGrantList.do",
									"type" : "post",
									"contentType" : "application/json;charset=UTF-8",
									"cache" : false,
									"async" : true,
									"data" : function(e) {
										if (typeof (preParams) != "undefined"
												&& typeof (preParams) == "function") {
											return preParams();
										} else {
											return JSON.stringify(bq);
										}
									},
									"dataType" : "json",
									//改成datatables期望的格式
									"dataFilter" : function(result, settings) {
										var json = jQuery.parseJSON(result);
										if (typeof (writeParams) != "undefined"
												&& writeParams
												&& typeof (writeParams) == "function") {
											writeParams(json);
										}
										json.recordsTotal = json.pag.total_count;
										json.recordsFiltered = json.pag.total_count;
										json.data = json.pag.pageList;
										return JSON.stringify(json);
									}
								},
								//监听datatables buttons事件
								"drawCallback" : function(settings, json) {
									//修改
									$(".update").on("click", function(e) {
										e.preventDefault();
										var updateUrl = $(this).prop("href");
										//在当前页面刷新新的页面
										$("#main").load(updateUrl,initMain);										
									});
									
									$(".pagination .paginate_button")
											.on(
													"mousedown",
													function(e) {
														var cp = $(":input[name='pag.current_page']");
														if(cp==null||cp==undefined){
															return;
														}
														var currentPage = cp.val();
														var firstPage = 1;
														var total_page = $(":input[name='pag.total_page']").val();
														var pageInfo = '';
														//点击了那一个按钮
														if ($(this).hasClass(
																"first")) {
															cp.val(firstPage);
															pageInfo = "first";
														} else if ($(this)
																.hasClass(
																		"last")) {
															cp.val(total_page);
															pageInfo = "last";
														} else if ($(this)
																.hasClass(
																		"previous")) {
															
															if(parseInt(currentPage) - 1<=1){
																cp.val(firstPage);
																pageInfo = "previous";
															}else{
																cp.val(parseInt(currentPage) - 1);
																pageInfo = "previous";
															}
															
														} else if ($(this)
																.hasClass(
																		"next")) {
															if(parseInt(currentPage) + 1>=total_page){
																cp.val(total_page);
																pageInfo = "next";
															}else{
																cp.val(parseInt(currentPage) + 1);
																pageInfo = "next";
															}
															
														} else {
															cp
																	.val($(this)
																			.children(
																					"a")
																			.html());
															pageInfo = $(this)
																	.children(
																			"a")
																	.html();
														}
													})
									//redraw();
								},
								columns : tableColumn
							});

			//重新画分页按钮的css
			function redraw() {
				var currentPage = $(":input[name='pag.current_page']").val();
				var totalPage = $(":input[name='pag.total_page']").val();
				$(".pagination .paginate_button").filter(".active")
						.removeClass("active");
				$(".pagination .paginate_button").filter(function() {
					return $(this).children("a").html() == currentPage;
				}).addClass("active");
				$(".pagination .paginate_button").filter(
						".first,.previous,.last,.next").removeClass("disabled");
				if (currentPage == 1) {
					$(".pagination .paginate_button")
							.filter(".first,.previous").addClass("disabled");
				}
				if (currentPage == totalPage) {
					$(".pagination .paginate_button").filter(".last,.next")
							.addClass("disabled");
				}
			}

			$("#searchButton").on("click", function() {
				mainTable.fnDraw();
			})
			
			$("#clearButton").on("click",function(){
				$("#searchForm select").val(-1);
			})

			$("#addButton").on("click", function() {
				var addUrl = $(this).val();
				$("#main").load(addUrl,initMain);
			});

		})
	</script>
	<script src="assets/js/custom/table-datatables.js"></script>

</body>
</html>
