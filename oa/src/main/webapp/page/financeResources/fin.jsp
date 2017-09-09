<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<meta charset="utf-8" />
<title>财务申请 - 东方黑玛oa系统</title>

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
						<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">东方黑玛oa系统</a>
						</li>
						<li class="active">
						财务申请
					</ul>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							财务申请 <small> <i class="ace-icon fa fa-angle-double-right"></i>
								财务申请
							</small>
						</h1>
					</div>
					<!-- 提示：流水重复信息的div -->
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
										财务申请
									</h4>

									<div class="widget-toolbar"></div>
								</div>
								<div class="widget-body">
									<div class="widget-main">
										<div id="fuelux-wizard-container">

											<div class="step-content pos-rel">
												<div class="step-pane active" data-step="1">
													<form:form cssClass="form-horizontal" id="fillForm"
														modelAttribute="finForm">
														
														<c:if
															test="${!(finForm.finappId == null || finForm.finappId == '')}">
															<form:hidden path="finappId" cssClass="col-xs-12 col-sm-6" />
														</c:if>
														
														<div class="form-group">
															<form:label path="finappSum"
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right"><span style="color:red">*</span>申请资金:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
 																	<form:input path="finappSum" cssStyle="width:200px" onkeyup="value=value.replace(/[^\d||.]/g,'')"/>
																</div>
															</div>
														</div>
														
														<div class="space-2"></div>
														<div class="form-group">
															<form:label path="finSubjectIdDto"
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right"><span style="color:red">*</span>科目:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
 																	<form:select path="finSubjectIdDto" onchange="change_sub()" cssStyle="width:200px">
 																		<form:options items="${subs }" itemLabel="finSubjectName" itemValue="finSubjectId"/>
 																	</form:select>
																</div>
															</div>
														</div>
														
														<div class="space-2"></div>
														<div class="form-group">
															<form:label path="finSubDetIdDto"
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right"><span style="color:red">*</span>科目明细:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
 																	<form:select path="finSubDetIdDto" cssStyle="width:200px">
 																		<form:options items="${subDetails }" itemLabel="finSubDetailName" itemValue="finSubDetailId"/>
 																	</form:select>
																</div>
															</div>
														</div>
														
														<div class="space-2"></div>
														<div class="form-group">
															<form:label path="approveUser"
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right">审批人:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
																	<form:checkboxes path="" items="${finemps }" cssClass="ckbox" itemLabel="empname" itemValue="empname"/>
																</div>
															</div>
															<form:input cssStyle="display:none" path="approveUser" id="in_app"/>
														</div>

														<div class="space-2"></div>
														<div class="form-group">
															<form:label path="finappDes"
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right">申请描述:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
 																	<form:textarea path="finappDes" 
 																		cssClass="col-xs-12 col-sm-6" />
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
															test="${!(finForm.finappId == null || finForm.finappId == '')}">
															修改
														</c:if>
														<c:if
															test="${(finForm.finappId == null || finForm.finappId == '')}">
															申请
														</c:if>
														<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
													</button>
												</div>
											</div>
											<!-- /.widget-main -->
										</div>
										<!-- /.widget-body -->
									</div>
									<!-- PAGE CONTENT ENDS -->
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
			function ckAll(){
				$(".ckbox").attr("checked","checked");
				$(".ckbox").attr("disabled","disabled");
			}
			
			function fuzhiCKB(){
				var cks=$(".ckbox");
				var str=$("#in_app").val();
				var ss=str.split(",");
				for(var i=0;i<ss.length;i++){
					for(var j=0;j<cks.length;j++){
						if(cks[j].value==ss[i]){
							cks[j].checked =true;
						}
					}
					
				}
			}
			
			function addstr(){
				var cks=$(".ckbox");
				var arr=[];
				for(var i=0;i<cks.length;i++){
					if(cks[i].checked){
						arr.push(cks[i].value)
					}
				}
				$("#in_app").val(arr);
			}
			
			
			function change_sub() {
				var subid=$("#finSubjectIdDto").val();
				$.ajax({
					"url" : "getFinSubDetailsList/"+subid+".do",
					"type" : "post",
					"contentType" : "application/json;charset=UTF-8",
					"cache" : false,
					"dataType":"json",
					"success":function(result){
						var subDe=document.getElementById("finSubDetIdDto");
						subDe.innerHTML=""
						for(var i=0;i<result.length;i++){
							var newOP=document.createElement("option");
							newOP.innerHTML=result[i].finSubDetailName;
							newOP.value=result[i].finSubDetailId;
							subDe.appendChild(newOP);
						}
					},
					"error":function(){
						alert("服务器响应失败！")
					}
				})
			}
				jQuery(function($) {
					fuzhiCKB();
					ckAll();
					
					$("#alertDiv a").click(function(){
						var alertDiv = $("#alertDiv");
						alertDiv.addClass("hidden");
						alertDiv.find("a").next("span").remove();
					})

					var addOrUpdateUrl = "financial.do";
					
					$("#submitBtn")
							.on("click",function(e) {
								addstr();
										if($("#finappSum").val().trim()==""){
											alert("请输入金额")
											return false;
										}
										console.log($("#fillForm").serialize());
										console.log(JSON.stringify($("#fillForm").serializeJSON()));
										var update = $("#fillForm input[name='finappId'][type='hidden']").length > 0;
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
															$("#main").load("financial.do",
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
																								+ "申请成功"
																								+ "<i class='ace-icon glyphicon glyphicon-ok'></i></span>");
																	});
														}
														if (result.flag === 'exception') {
															var alertDiv = $("#alertDiv");
															alertDiv
																	.removeClass("hidden");
															if (((result.exCode+"").indexOf("4"))==0) {
																alertDiv
																		.removeClass("alert-danger");
																alertDiv
																		.removeClass("alert-info");
																alertDiv
																		.addClass("alert-warning");
															}
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
																					+ result.exMsg
																					+ "</span>");
														}
													}
												})
									});
					$('.datepicker').datepicker({
						autoclose : true,
						todayHighlight : true,
						todayBtn : true,
						format : "yyyy-mm-dd"
					})
					.next().on(ace.click_event, function() {
						$(this).prev().focus();
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
