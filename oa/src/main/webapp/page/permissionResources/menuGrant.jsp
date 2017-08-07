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
<title>菜单授权 - 东方黑玛oa系统</title>

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

						<li><c:if test="${roleId == null || roleId == ''}">
								<a id="fillingManageLink" href="menuGrants.do">菜单授权管理</a>
							</c:if> 
							<c:if test="${!(roleId == null || roleId == '')}">
								<a id="fillingManageLink" href="../menuGrants.do">学员管理</a>
							</c:if></li>
						<li class="active">
							<c:if
								test="${roleId == null || roleId == ''}">
												菜单授权
							</c:if> 
							<c:if
								test="${!(roleId == null || roleId == '')}">
												授权修改
							</c:if>
					</ul>
					<!-- /.breadcrumb -->
				</div>

				<div class="page-content">
					<div class="page-header">
						<h1>
							菜单授权管理 <small> <i class="ace-icon fa fa-angle-double-right"></i>
								<c:if test="${roleId == null || roleId == ''}">
												菜单授权
											</c:if> <c:if
									test="${!(roleId == null || roleId == '')}">
												授权修改
											</c:if>
							</small>
						</h1>
					</div>
					<!-- 提示：学员重复信息的div -->
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

										<c:if test="${roleId == null || roleId == ''}">
												菜单授权
											</c:if>
										<c:if
											test="${!(roleId == null || roleId == '')}">
												授权修改
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
														modelAttribute="menuGrantForm">
														
														<div class="form-group">
															<form:label path="roleId"
																cssClass="control-label col-xs-12 col-sm-3 padding-right">所属角色:</form:label>
															<c:if
																test="${roleId == null || roleId == ''}">
																<form:select path="roleId" cssClass="col-xs-12 col-sm-6">
																	<form:option value="-1">--请选择角色--</form:option>
																	<form:options items="${roles }" itemLabel="roleName" itemValue="roleId"/>
																</form:select>
															</c:if>
															
															<c:if
																test="${!(roleId == null || roleId == '')}">
																<input type="hidden" name="roleId" value="${roleId }"/>
																
																<form:select path="roleId" cssClass="col-xs-12 col-sm-6">
																	<form:option value="-1">--请选择角色--</form:option>
																	<c:forEach items="${roles }" var="role">
																		<c:if test="${role.roleId == roleId }">
																			<form:option value="${role.roleId }" selected="selected">${role.roleName }</form:option>
																		</c:if>
																		<c:if test="${role.roleId != roleId }">
																			<form:option value="${role.roleId }">${role.roleName }</form:option>
																		</c:if>
																	</c:forEach>
																</form:select>
															</c:if>
														</div>
														
														
														<div class="form-group">
															<form:label path="resourceIds"
																cssClass="control-label col-xs-12 col-sm-3 padding-right">菜单列表:</form:label>
															<div class="col-xs-12 col-sm-9">
																<div class="clearfix">
																	<br/>
																	<input type="checkbox" name="all">&nbsp;全选<br/>
																	<c:if test="${roleId == null || roleId == ''}">
																		<c:forEach items="${menus }" var="menuDto">
																			<form:checkbox title="${menuDto.menu.resourceId }" class="groupAll" path="resourceIds" label="${menuDto.menu.menuName }" value="${menuDto.menu.resourceId }"/><br/>
																			<c:forEach items="${menuDto.childrenMenus }" var="childMenu">
																				<form:checkbox title="${menuDto.menu.resourceId }" path="resourceIds" label="${childMenu.menuName }" value="${childMenu.resourceId }"/>&nbsp;&nbsp;
																			</c:forEach>
																			<hr/>
																		</c:forEach>
																	</c:if>
															</div>
														</div>
													</form:form>
												</div>

												<hr />
												<div class="wizard-actions">
													<button class="btn btn-success btn-next" id="submitBtn"
														data-last="Finish">
															授权
														<i class="ace-icon fa fa-arrow-right icon-on-right"></i>
													</button>
												</div>
											</div>
											<!-- /.widget-main -->
										</div>
										<!-- /.widget-body -->
									</div>
									<!-- 
									<div id="modal-wizard" class="modal">
										<div class="modal-dialog">
											<div class="modal-content">
												<div id="modal-wizard-container">
													<div class="modal-header">
														<ul class="steps">
															<li data-step="1" class="active"><span class="step">1</span>
																<span class="title">Validation states</span></li>

															<li data-step="2"><span class="step">2</span> <span
																class="title">Alerts</span></li>

															<li data-step="3"><span class="step">3</span> <span
																class="title">Payment Info</span></li>

															<li data-step="4"><span class="step">4</span> <span
																class="title">Other Info</span></li>
														</ul>
													</div>

													<div class="modal-body step-content">
														<div class="step-pane active" data-step="1">
															<div class="center">
																<h4 class="blue">Step 1</h4>
															</div>
														</div>

														<div class="step-pane" data-step="2">
															<div class="center">
																<h4 class="blue">Step 2</h4>
															</div>
														</div>

														<div class="step-pane" data-step="3">
															<div class="center">
																<h4 class="blue">Step 3</h4>
															</div>
														</div>

														<div class="step-pane" data-step="4">
															<div class="center">
																<h4 class="blue">Step 4</h4>
															</div>
														</div>
													</div>
												</div>

											</div>
										</div>
									</div>
									 -->
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
				jQuery(function($) {
					var update = $("input[type='hidden'][name='roleId']").length;
					if(update>0){
						$("select[name='roleId']").attr("disabled","disabled");
					}
					
					$("#alertDiv a").click(function(){
						var alertDiv = $("#alertDiv");
						alertDiv.addClass("hidden");
						alertDiv.find("a").next("span").remove();
					})

					var listUrl = "menuGrants.do";
					var addOrUpdateUrl = "menuGrant.do";
					
					$("#submitBtn")
							.on("click",
									function(e) {
										var roleId = $("#roleId").val();
										var resourceIdsEle = $("input[type='checkbox'][name='resourceIds']:checked");
										var resourceIds = [];
										$.each(resourceIdsEle,function(index,e){
											resourceIds.push($(e).val());
										})
										var param = {"roleId":roleId,"resourceIds":resourceIds};
										console.log(JSON.stringify(param));
										$.ajax({
													"url" : addOrUpdateUrl,
													"method" : "post",
													"data" : JSON.stringify(param),
													"dataType" : "json",
													"contentType" : "application/json;charset=UTF-8",
													"success" : function(result) {
														if (result.flag === true) {
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
					//show datepicker when clicking on the icon
					.next().on(ace.click_event, function() {
						$(this).prev().focus();
					});

					$("#fillingManageLink").on("click", function(e) {
						e.preventDefault();
						var href = $(this).attr("href");
						$("#main").load(listUrl);
					})
					
					$("input[type='checkbox'][name='all']").on("click",function(e){
						if($("input[type='checkbox'][name='all']").is(':checked')){
							$("input[type='checkbox'][name='resourceIds']").prop("checked","checked");
						}else{
							$("input[type='checkbox'][name='resourceIds']").prop("checked",false);
						}
					})
					
					$(".groupAll").on("click",function(e){
						var title = $(this).prop("title");
						var groupEle = $("input[type='checkbox'][name='resourceIds'][title='"+title+"']");
						if($(this).is(':checked')){
							groupEle.prop("checked","checked");
						}else{
							groupEle.prop("checked",false);
						}
					})
					
					$("#roleId").on("change",function(e){
						var roleId = $(this).val();
						var url = "getMenuByRoleList.do";
						$.ajax({
							url:url,
							type:"post",
							data: {"roleId":roleId},
							dataType:"json",
							success:function(res){
								var menus = eval(res);
								var ches = $("input[type='checkbox'][name='resourceIds']");
								if(ches!=null&&ches.length>0){
									$.each(ches,function(index,ele){
										$(ele).prop("checked",false);
									})
								}
								if(menus!=null&&menus.length>0){
									$.each(menus,function(index,ele){
										var menuId = ele.resourceId;
										$.each(ches,function(ind,e){
											var chVal = $(e).val();
											if(menuId==chVal){
												$(e).prop("checked","checked");
											}
										})
									})
								}
							}
						})
					})
				})
			</script>
</body>
</html>
