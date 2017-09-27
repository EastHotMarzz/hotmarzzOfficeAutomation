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
<title>流水信息填写 - 东方黑玛oa系统</title>

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
							<c:if
								test="${waterForm.waterId == null || waterForm.waterId == ''}">
												资金申请
							</c:if> 
							<c:if
								test="${!(waterForm.waterId == null || waterForm.waterId == '')}">
												流水修改
							</c:if>
					</ul>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							流水管理 <small> <i class="ace-icon fa fa-angle-double-right"></i>
								<c:if test="${waterForm.waterId == null || waterForm.waterId == ''}">
												资金申请
											</c:if> <c:if
									test="${!(waterForm.waterId == null || waterForm.waterId == '')}">
												流水修改
											</c:if>
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

										<c:if test="${waterForm.waterId == null || waterForm.waterId == ''}">
												资金申请
											</c:if>
										<c:if
											test="${!(waterForm.waterId == null || waterForm.waterId == '')}">
												流水修改
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
														modelAttribute="waterForm">

														<c:if
															test="${!(waterForm.waterId == null || waterForm.waterId == '')}">
															<form:hidden path="waterId" cssClass="col-xs-12 col-sm-6" />
														</c:if>

														<div class="form-group">
															<form:label path="waterType" 
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right">账目类别:</form:label> 
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
																	<form:radiobutton path="waterType" value="0" checked="checked" />
																	支出
																	<form:radiobutton path="waterType" value="1"/> 
																	收入
																</div>
															</div>
														</div>
														
														<div class="space-2"></div>
														<div class="form-group">
															<form:label path="subId"
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right"><span style="color:red">*</span>科目:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
 																	<form:select path="subIdDto" onchange="change_sub()" cssStyle="width:200px">
 																		<form:options items="${subs }" itemLabel="subjectName" itemValue="subjectId"/>
 																	</form:select>
																</div>
															</div>
														</div>
														
														<div class="space-2"></div>
														<div class="form-group">
															<form:label path="subDetailId"
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right"><span style="color:red">*</span>科目明细:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
 																	<form:select path="subDetailIdDto" cssStyle="width:200px">
 																		<form:options items="${subDetails }" itemLabel="subjectDetailName" itemValue="subjectDetailId"/>
 																	</form:select>
																</div>
															</div>
														</div>
														
														<div class="space-2"></div>
														<div class="form-group">
															<form:label path="waterSum"
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right"><span style="color:red">*</span>金额:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
 																	<form:input path="waterSum" 
 																		cssClass="col-xs-12 col-sm-6" onfocus="clearStr()" onkeyup="value=value.replace(/[^\d||.]/g,'')"
 																		/> 
 																	<span id="waterSumErr" style="color:red"></span>
																</div>
															</div>
														</div>
														
														<div class="space-2"></div>
														<div class="form-group">
															<form:label path="issupple" 
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right">是否补单:</form:label> 
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
																	<form:radiobutton path="issupple" value="0"/>
																	是
																	<form:radiobutton path="issupple" value="1" checked="checked"/> 
																	否
																</div>
															</div>
														</div>
														
														<div class="space-2"></div>
														<div class="form-group">
															<form:label path="waterDate" 
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right">时间:</form:label> 
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
																	<form:input path="waterDate" cssClass="datepicker col-xs-12 col-sm-6" onfocus="clearStr()"/>
																	<span id="waterDateErr" style="color:red"></span>
																</div>
															</div>
														</div>

														<div class="space-2"></div>
														<div class="form-group">
															<form:label path="remark"
 																cssClass="control-label col-xs-12 col-sm-3 no-padding-right">备注:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
 																	<form:textarea path="remark" 
 																		cssClass="col-xs-12 col-sm-6" />
 																	<form:errors path="remark" />
																</div>
															</div>
														</div>
														<input type="hidden" name="formToken" value="${formToken}" />
													</form:form>
												</div>

												<hr />
												<div class="wizard-actions">
													<button class="btn btn-success btn-next" id="submitBtn"
														data-last="Finish">
														<c:if
															test="${waterForm.waterId == null || waterForm.waterId == ''}">
															添加
														</c:if>
														<c:if
															test="${!(waterForm.waterId == null || waterForm.waterId == '')}">
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
			function clearStr(){
				$("#waterDateErr").html("");
				$("#waterSumErr").html("");
			}
			function ck_money(){
				var myMoney=$("#waterSum").val();
				if(myMoney=="" || myMoney==null){
					$("#waterSumErr").html("请添加金额")
					return false;
				}
				return true;
			}
			
			function ck_date(){
				var myDate=$("#waterDate").val();
				if(myDate=="" || myDate==null){
					$("#waterDateErr").html("请填写日期")
					return false
				}
				var nowDate=new Date();
				var curYear=nowDate.getYear()+1900;
				var curMonth=nowDate.getMonth()+1;
				if(curYear==myDate.substring(0,4) && myDate.substring(5,7)==curMonth){
					return true
				}
				$("#waterDateErr").html("日期只能选择当前月份")
				return false
			}
			
			function change_sub() {
				var subid=$("#subIdDto").val();
				$.ajax({
					"url" : "getSubDetailsList/"+subid+".do",
					"type" : "post",
					"contentType" : "application/json;charset=UTF-8",
					"cache" : false,
					"dataType":"json",
					"success":function(result){
						var subDe=document.getElementById("subDetailIdDto");
						subDe.innerHTML=""
						for(var i=0;i<result.length;i++){
							var newOP=document.createElement("option");
							newOP.innerHTML=result[i].subjectDetailName;
							newOP.value=result[i].subjectDetailId;
							subDe.appendChild(newOP);
						}
					},
					"error":function(){
						alert("服务器响应失败！")
					}
				})
			}
				jQuery(function($) {
					$("#alertDiv a").click(function(){
						var alertDiv = $("#alertDiv");
						alertDiv.addClass("hidden");
						alertDiv.find("a").next("span").remove();
					})

					var listUrl = "fins.do";
					var addOrUpdateUrl = "water.do";
					
					$("#submitBtn")
							.on("click",function(e) {
									var myResult=true;
									var myResult2=ck_money();
									var isCheckDate = $("#fillForm input[name='waterId'][type='hidden']").length > 0;
									if(!isCheckDate){
										myResult=ck_date();
									}
									var ok=myResult && myResult2;
										if(!ok){
											return;
										}
										console.log($("#fillForm").serialize());
										console.log(JSON.stringify($("#fillForm").serializeJSON()));
										var update = $("#fillForm input[name='waterId'][type='hidden']").length > 0;
										var method = "post";
										if (update) {
											method = "put";
										}
										var param = $("#fillForm").serializeJSON();
										addOrUpdateUrl = addOrUpdateUrl+"?formToken="+param.formToken;
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
																				alertDiv.removeClass("hidden");
																				alertDiv.removeClass("alert-warning");
																				alertDiv.removeClass("alert-danger");
																				alertDiv.addClass("alert-info");
																				alertDiv.find("a").next("span").remove();
																				alertDiv.find("a").after("<span>"+ result.msg+ "<i class='ace-icon glyphicon glyphicon-ok'></i></span>");
																			});
														}
														if (result.flag === 'validation') {
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
