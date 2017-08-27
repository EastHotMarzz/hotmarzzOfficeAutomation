<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>校区信息填写 - 东方黑玛oa系统</title>

<meta name="description" content="Static &amp; Dynamic Tables" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

<!-- bootstrap & fontawesome -->
<link rel="stylesheet" href="<%=path%>/assets/css/bootstrap.min.css" />
<link rel="stylesheet"
	href="<%=path%>/assets/font-awesome/4.5.0/css/font-awesome.min.css" />

<!-- page specific plugin styles -->
<link rel="stylesheet" href="<%=path%>/assets/css/colorbox.min.css" />
<link rel="stylesheet"
	href="<%=path%>/assets/css/bootstrap-datepicker3.min.css" />
<link rel="stylesheet"
	href="<%=path%>/assets/css/jquery.gritter.min.css" />

<!-- text fonts -->
<link rel="stylesheet"
	href="<%=path%>/assets/css/fonts.googleapis.com.css" />

<!-- ace styles -->
<link rel="stylesheet" href="<%=path%>/assets/css/ace.min.css"
	class="ace-main-stylesheet" id="main-ace-style" />

<!--[if lte IE 9]>
			<link rel="stylesheet" href="<%=path%>/assets/css/ace-part2.min.css" class="ace-main-stylesheet" />
		<![endif]-->
<link rel="stylesheet" href="<%=path%>/assets/css/ace-skins.min.css" />
<link rel="stylesheet" href="<%=path%>/assets/css/ace-rtl.min.css" />

<!--[if lte IE 9]>
		  <link rel="stylesheet" href="<%=path%>/assets/css/ace-ie.min.css" />
		<![endif]-->

<!-- inline styles related to this page -->

<!-- ace settings handler -->
<script src="<%=path%>/assets/js/ace-extra.min.js"></script>

<!-- HTML5shiv and Respond.js for IE8 to support HTML5 elements and media queries -->

<!--[if lte IE 8]>
		<script src="<%=path%>/assets/js/html5shiv.min.js"></script>
		<script src="<%=path%>/assets/js/respond.min.js"></script>
		<![endif]-->
</head>

<body class="skin-1">
	<div class="main-container ace-save-state" id="main-container">
		<div class="main-content">
			<div class="main-content-inner">
				<div class="breadcrumbs ace-save-state" id="breadcrumbs">
					<ul class="breadcrumb">
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="main.do">东方黑玛oa系统</a>
						</li>

						<li><c:if test="${schoolForm.schoolId == null || schoolForm.schoolId == ''}">
								<a id="fillingManageLink" href="schools.do">校区管理</a>
							</c:if> 
							<c:if test="${!(schoolForm.schoolId == null || schoolForm.schoolId == '')}">
								<a id="fillingManageLink" href="schools.do">校区管理</a>
							</c:if></li>
						<li class="active">
							<c:if
								test="${schoolForm.schoolId == null || schoolForm.schoolId == ''}">
												校区添加
							</c:if> 
							<c:if
								test="${!(schoolForm.schoolId == null || schoolForm.schoolId == '')}">
												校区修改
							</c:if>
					</ul>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							校区管理 <small> <i class="ace-icon fa fa-angle-double-right"></i>
								<c:if test="${schoolForm.schoolId == null || schoolForm.schoolId == ''}">
												校区添加
											</c:if> <c:if
									test="${!(schoolForm.schoolId == null || schoolForm.schoolId == '')}">
												校区修改
											</c:if>
							</small>
						</h1>
					</div>
					<!-- /.page-header -->
					<div id="alertDiv" class="alert hidden">
						<a class="close" href="#">
							<i class="ace-icon fa fa-times"></i>
						</a>
					</div>

					<div class="row">
						<div class="col-xs-12">
							<!-- PAGE CONTENT BEGINS -->

							<div class="hr hr-18 hr-double dotted"></div>

							<div class="widget-box">
								<div class="widget-header widget-header-blue widget-header-flat">
									<h4 class="widget-title lighter">

										<c:if test="${schoolForm.schoolId == null || schoolForm.schoolId == ''}">
												校区添加
											</c:if>
										<c:if
											test="${!(schoolForm.schoolId == null || schoolForm.schoolId == '')}">
												校区修改
											</c:if>
									</h4>

									<div class="widget-toolbar"></div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div id="fuelux-wizard-container">

											<div class="step-content pos-rel">
												<div class="step-pane active" data-step="1">
													<form:form cssClass="form-horizontal" id="fillForm"
														modelAttribute="schoolForm">

														<c:if
															test="${!(schoolForm.schoolId == null || schoolForm.schoolId == '')}">
															<form:hidden path="schoolId" cssClass="col-xs-12 col-sm-6" />
														</c:if>

														<div class="form-group">
															<form:label path="schoolName"
																cssClass="control-label col-xs-12 col-sm-3 no-padding-right">校区名称:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
																	<form:input path="schoolName"
																		cssClass="col-xs-12 col-sm-6" />
																	<form:errors path="schoolName" />
																</div>
															</div>
														</div>

														<div class="space-2"></div>

														<div class="form-group">
															<form:label path="province"
																cssClass="control-label col-xs-12 col-sm-3 no-padding-right">所在省份:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
																	<form:textarea path="province"
																		cssClass="col-xs-12 col-sm-6" />
																	<form:errors path="province" />
																</div>
															</div>
														</div>

													</form:form>
												</div>

												<hr />
												<div class="wizard-actions">
													<button class="btn btn-success btn-next" id="submitBtn"
														data-last="Finish">
														<c:if
															test="${schoolForm.schoolId == null || schoolForm.schoolId == ''}">
															添加
														</c:if>
														<c:if
															test="${!(schoolForm.schoolId == null || schoolForm.schoolId == '')}">
															修改
														</c:if>
														<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
													</button>
												</div>
											</div>
											<!-- /.widget-main -->
										</div>
										<!-- /.widget-body -->
									</div>
									
								</div>
								<!-- /.col -->
							</div>
							<!-- /.row -->

						</div>
						<!-- /.page-content -->
					</div>
				</div>
				<!-- /.main-content -->

				<a href="#" id="btn-scroll-up"
					class="btn-scroll-up btn btn-sm btn-inverse"> <i
					class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
				</a>
			</div>
			<!-- /.main-container -->

			<!-- basic scripts -->

			<!--[if !IE]> -->
			<script src="<%=path%>/assets/js/jquery-2.1.4.min.js"></script>

			<!-- <![endif]-->

			<!--[if IE]>
<script src="<%=path%>/assets/js/jquery-1.11.3.min.js"></script>
<![endif]-->
			<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='<%=path%>/assets/js/jquery.mobile.custom.min.js'>"
									+ "<"+"/script>");
			</script>

			<!-- page specific plugin scripts -->
			<script src="<%=path%>/assets/js/jquery.dataTables.min.js"></script>
			<script src="<%=path%>/assets/js/jquery.dataTables.bootstrap.min.js"></script>
			<script src="<%=path%>/assets/js/dataTables.buttons.min.js"></script>
			<script src="<%=path%>/assets/js/buttons.flash.min.js"></script>
			<script src="<%=path%>/assets/js/buttons.html5.min.js"></script>
			<script src="<%=path%>/assets/js/buttons.print.min.js"></script>
			<script src="<%=path%>/assets/js/buttons.colVis.min.js"></script>
			<script src="<%=path%>/assets/js/dataTables.select.min.js"></script>
			<script src="<%=path%>/assets/js/spinbox.min.js"></script>

			<script src="<%=path%>/assets/js/jquery.validate.min.js"></script>

			<script src="<%=path%>/assets/js/jquery.colorbox.min.js"></script>
			<script src="<%=path%>/assets/js/bootstrap-datepicker.min.js"></script>
			<script src="<%=path%>/assets/js/jquery.gritter.min.js"></script>
			<script src="<%=path%>/assets/js/bootbox.js"></script>


			<script src="<%=path%>/assets/js/wizard.min.js"></script>
			<script src="<%=path%>/assets/js/jquery.validate.min.js"></script>
			<script src="<%=path%>/assets/js/jquery-additional-methods.min.js"></script>
			<script src="<%=path%>/assets/js/bootbox.js"></script>
			<script src="<%=path%>/assets/js/jquery.maskedinput.min.js"></script>
			<script src="<%=path%>/assets/js/select2.min.js"></script>


			<!-- serializeJSON -->
			<script src="<%=path%>/assets/js/tools/jquery.serializejson.min.js"></script>
			<script src="<%=path%>/assets/js/custom/array-utils.js"></script>
			<!-- inline scripts related to this page -->
			<script type="text/javascript">
				jQuery(function($) {

					var listUrl = "schools.do";
					var addOrUpdateUrl = "school.do";

					$("#submitBtn")
							.on("click",
									function(e) {
										console.log($("#fillForm").serialize());
										console.log(JSON.stringify($("#fillForm").serializeJSON()));
										var update = $("#fillForm input[name='schoolId'][type='hidden']").length > 0;
										var method = "post";
										if (update) {
											method = "put";
										}
										var param = $("#fillForm").serializeJSON();
										$.ajax({
													"url" : addOrUpdateUrl,
													"method" : method,
													"data" : JSON.stringify(param),
													"dataType" : "json",
													"contentType" : "application/json;charset=UTF-8",
													"success" : function(result) {
														if (result.flag == true) {
															$("#main").load(listUrl,
																	function() {
																initMain();
																var alertDiv = $("#alertDiv");
																alertDiv
																		.removeClass("hidden");
																alertDiv
																		.removeClass("alert-warning");
																alertDiv
																		.removeClass("alert-danger");
																alertDiv
																		.addClass("alert-info");
																alertDiv
																		.find(
																				"a")
																		.next(
																				"span")
																		.remove();
																alertDiv
																		.find(
																				"a")
																		.after(
																				"<span>"
																						+ result.msg
																						+ "<i class='ace-icon glyphicon glyphicon-ok'></i></span>");
															});
														}
														if (result.flag == 'validation') {
															$.each(result.validationMsg,
																			function(
																					key,
																					value) {
																				var ele = "#"
																						+ key;
																				//修复了校验的重复提示问题。
																				if($("#ok_"+key).html()!=null){
																					$("#ok_"+key).html(value)
																				}else{
																					$(ele).after("<div id='ok_"+key+"' class='help-block col-xs-12 col-sm-reset inline'>"
																											+ value
																											+ "</div>");
																				}
																			})
														}
														if (result.flag == false) {
															var alertDiv = $("#alertDiv");
															alertDiv
																	.removeClass("hidden");
															if (result.errorCode == '503') {
																alertDiv
																		.removeClass("alert-warning");
																alertDiv
																		.removeClass("alert-info");
																alertDiv
																		.addClass("alert-danger");
															}
															alertDiv
																	.find(
																			"button")
																	.next(
																			"span")
																	.remove();
															alertDiv
																	.find(
																			"button")
																	.after(
																			"<span>"
																					+ result.msg
																					+ "</span>");
														}
													}
												})
									});

					$("#fillingManageLink").on("click", function(e) {
						e.preventDefault();
						var href = $(this).attr("href");
						$("#main").load(listUrl);
					})
				})
			</script>
</body>
</html>
