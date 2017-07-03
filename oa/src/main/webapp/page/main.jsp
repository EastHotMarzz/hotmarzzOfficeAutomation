<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
		<meta charset="utf-8" />
		<title>首页 - 东方黑玛OA系统</title>
		
		<meta name="description" content="Static &amp; Dynamic Tables" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />

		<!-- bootstrap & fontawesome -->
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/font-awesome/4.5.0/css/font-awesome.min.css" />

		<!-- page specific plugin styles -->

		<!-- text fonts -->
		<link rel="stylesheet" href="assets/css/fonts.googleapis.com.css" />

		<!-- ace styles -->
		<link rel="stylesheet" href="assets/css/ace.min.css" class="ace-main-stylesheet" id="main-ace-style" />

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
		<link rel="stylesheet" href="assets/css/bootstrap-datetimepicker.min.css" />

		<script src="assets/js/custom/date-utils.js"></script>
		<link rel="stylesheet" href="assets/css/custom/table-custom.css" />
</head>

<body class="skin-1">
	<div id="navbar" class="navbar navbar-default ace-save-state">
		<div class="navbar-container ace-save-state" id="navbar-container">
			<button type="button" class="navbar-toggle menu-toggler pull-left" id="menu-toggler" data-target="#sidebar">
				<span class="sr-only">Toggle sidebar</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>

			<div class="navbar-header pull-left">
				<a href="index.html" class="navbar-brand">
					<small>
						<i class="fa fa-cloud"></i>东方黑玛OA系统
					</small>
				</a>
			</div>

			<div class="navbar-buttons navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="grey dropdown-modal">
						<a data-toggle="dropdown" class="dropdown-toggle" href="#">
					 		<i class="ace-icon fa fa-tasks"></i> <span class="badge badge-grey">4</span>
						</a>

						<ul
							class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i class="ace-icon fa fa-check"></i>
								4 Tasks to complete</li>

							<li class="dropdown-content">
								<ul class="dropdown-menu dropdown-navbar">
									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left">Software Update</span> <span
													class="pull-right">65%</span>
											</div>

											<div class="progress progress-mini">
												<div style="width: 65%" class="progress-bar"></div>
											</div>
									</a></li>

									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left">Hardware Upgrade</span> <span
													class="pull-right">35%</span>
											</div>

											<div class="progress progress-mini">
												<div style="width: 35%"
													class="progress-bar progress-bar-danger"></div>
											</div>
									</a></li>

									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left">Unit Testing</span> <span
													class="pull-right">15%</span>
											</div>

											<div class="progress progress-mini">
												<div style="width: 15%"
													class="progress-bar progress-bar-warning"></div>
											</div>
									</a></li>

									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left">Bug Fixes</span> <span
													class="pull-right">90%</span>
											</div>

											<div class="progress progress-mini progress-striped active">
												<div style="width: 90%"
													class="progress-bar progress-bar-success"></div>
											</div>
									</a></li>
								</ul>
							</li>

							<li class="dropdown-footer"><a href="#"> See tasks with
									details <i class="ace-icon fa fa-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="purple dropdown-modal"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="ace-icon fa fa-bell icon-animated-bell"></i> <span
							class="badge badge-important">8</span>
					</a>

						<ul
							class="dropdown-menu-right dropdown-navbar navbar-pink dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i
								class="ace-icon fa fa-exclamation-triangle"></i> 8 Notifications
							</li>

							<li class="dropdown-content">
								<ul class="dropdown-menu dropdown-navbar navbar-pink">
									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left"> <i
													class="btn btn-xs no-hover btn-pink fa fa-comment"></i> New
													Comments
												</span> <span class="pull-right badge badge-info">+12</span>
											</div>
									</a></li>

									<li><a href="#"> <i
											class="btn btn-xs btn-primary fa fa-user"></i> Bob just
											signed up as an editor ...
									</a></li>

									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left"> <i
													class="btn btn-xs no-hover btn-success fa fa-shopping-cart"></i>
													New Orders
												</span> <span class="pull-right badge badge-success">+8</span>
											</div>
									</a></li>

									<li><a href="#">
											<div class="clearfix">
												<span class="pull-left"> <i
													class="btn btn-xs no-hover btn-info fa fa-twitter"></i>
													Followers
												</span> <span class="pull-right badge badge-info">+11</span>
											</div>
									</a></li>
								</ul>
							</li>

							<li class="dropdown-footer"><a href="#"> See all
									notifications <i class="ace-icon fa fa-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="green dropdown-modal"><a data-toggle="dropdown"
						class="dropdown-toggle" href="#"> <i
							class="ace-icon fa fa-envelope icon-animated-vertical"></i> <span
							class="badge badge-success">5</span>
					</a>

						<ul
							class="dropdown-menu-right dropdown-navbar dropdown-menu dropdown-caret dropdown-close">
							<li class="dropdown-header"><i
								class="ace-icon fa fa-envelope-o"></i> 5 Messages</li>

							<li class="dropdown-content">
								<ul class="dropdown-menu dropdown-navbar">
									<li><a href="#" class="clearfix"> <img
											src="assets/images/avatars/avatar.png" class="msg-photo"
											alt="Alex's Avatar" /> <span class="msg-body"> <span
												class="msg-title"> <span class="blue">Alex:</span>
													Ciao sociis natoque penatibus et auctor ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>a moment
														ago</span>
											</span>
										</span>
									</a></li>

									<li><a href="#" class="clearfix"> <img
											src="assets/images/avatars/avatar3.png" class="msg-photo"
											alt="Susan's Avatar" /> <span class="msg-body"> <span
												class="msg-title"> <span class="blue">Susan:</span>
													Vestibulum id ligula porta felis euismod ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>20 minutes
														ago</span>
											</span>
										</span>
									</a></li>

									<li><a href="#" class="clearfix"> <img
											src="assets/images/avatars/avatar4.png" class="msg-photo"
											alt="Bob's Avatar" /> <span class="msg-body"> <span
												class="msg-title"> <span class="blue">Bob:</span>
													Nullam quis risus eget urna mollis ornare ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>3:15 pm</span>
											</span>
										</span>
									</a></li>

									<li><a href="#" class="clearfix"> <img
											src="assets/images/avatars/avatar2.png" class="msg-photo"
											alt="Kate's Avatar" /> <span class="msg-body"> <span
												class="msg-title"> <span class="blue">Kate:</span>
													Ciao sociis natoque eget urna mollis ornare ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>1:33 pm</span>
											</span>
										</span>
									</a></li>

									<li><a href="#" class="clearfix"> <img
											src="assets/images/avatars/avatar5.png" class="msg-photo"
											alt="Fred's Avatar" /> <span class="msg-body"> <span
												class="msg-title"> <span class="blue">Fred:</span>
													Vestibulum id penatibus et auctor ...
											</span> <span class="msg-time"> <i
													class="ace-icon fa fa-clock-o"></i> <span>10:09 am</span>
											</span>
										</span>
									</a></li>
								</ul>
							</li>

							<li class="dropdown-footer"><a href="inbox.html"> See
									all messages <i class="ace-icon fa fa-arrow-right"></i>
							</a></li>
						</ul></li>

					<li class="light-blue dropdown-modal">
						<a data-toggle="dropdown" href="#" class="dropdown-toggle">
							<img class="nav-user-photo" src="assets/images/avatars/user.jpg"/>
							<span class="user-info">
								<small>欢迎,</small>${login_emp.empName}
							</span>
							<i class="ace-icon fa fa-caret-down"></i>
						</a>

						<ul class="user-menu dropdown-menu-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li>
								<a href="updatePwd.do">
									<i class="ace-icon fa fa-user"></i> 修改密码
								</a>
							</li>

							<li class="divider"></li>

							<li>
								<a href="退出.do">
									<i class="ace-icon fa fa-power-off"></i>
									退出
								</a>
							</li>
						</ul></li>
				</ul>
			</div>
		</div>
		<!-- /.navbar-container -->
	</div>

	<div class="main-container ace-save-state" id="main-container">
		<script type="text/javascript">
				try{ace.settings.loadState('main-container')}catch(e){}
		</script>

		<div id="sidebar" class="sidebar  responsive ace-save-state">
			<script type="text/javascript">
				try {
					ace.settings.loadState('sidebar')
				} catch (e) {
				}
			</script>


			<ul class="nav nav-list">
				<li class="active">
					<a href="main.do">
						<i class="menu-icon fa fa-tachometer"></i>
						<span class="menu-text">
							东方黑玛OA系统
						</span>
					</a>
					<b class="arrow"></b>
				</li>
				
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								人力资源管理
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
							<ul class="submenu">
									<li class="">
										<a href="emps.do">
											<i class="menu-icon fa fa-caret-right"></i>
											公司员工管理
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											部门岗位管理
										</a>
									</li>
							</ul>
					</li>
					
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								教务管理
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						
							<ul class="submenu">
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											校区管理
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											班级管理
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											教师管理
										</a>
									</li>
							</ul>
					</li>
					
					<!-- --------------------------学员管理------------------------------- -->
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								学员管理
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
							<ul class="submenu">
									<li class="">
										<a href="stus.do">
											<i class="menu-icon fa fa-caret-right"></i>
											基本信息管理
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											异动信息管理
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											贷款信息管理
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											现金缴费管理
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											保险信息
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											补贴申请
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											成绩管理
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											申请记录
										</a>
									</li>
							</ul>
					</li>
					
					
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								统计管理
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						
							<ul class="submenu">
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											教学质量统计
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											学员基本信息统计
										</a>
									</li>
									
							</ul>
					</li>
					
					
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								招生咨询
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						
							<ul class="submenu">
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											校区电话量统计
										</a>
									</li>
									
							</ul>
					</li>
					
					
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								就业管理
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						
							<ul class="submenu">
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											分配就业老师
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											班级就业统计
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											特殊学员管理
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											就业审核
										</a>
									</li>
							</ul>
					</li>
					
					
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								财务流水管理
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						
							<ul class="submenu">
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											校区流水
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											财务申请
										</a>
									</li>
									
							</ul>
					</li>
					
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								规章制度
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						
							<ul class="submenu">
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											维护规章制度
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											查看规章制度
										</a>
									</li>
									
							</ul>
					</li>
					
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								教师评估
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						
							<ul class="submenu">
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											领导评分
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											满意度问卷
										</a>
									</li>
									
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											教员阶段考核
										</a>
									</li>
							</ul>
					</li>
					<!-- 
					<li class="">
						<a href="#" class="dropdown-toggle">
							<i class="menu-icon fa fa-desktop"></i>
							<span class="menu-text">
								教务管理
							</span>
							<b class="arrow fa fa-angle-down"></b>
						</a>
						<b class="arrow"></b>
						
							<ul class="submenu">
									<li class="">
										<a href="#">
											<i class="menu-icon fa fa-caret-right"></i>
											公司员工管理
										</a>
										
										<b class="arrow"></b>
											<ul class="submenu">
												<li class="">
													<a href="#" >
														<i class="menu-icon fa fa-caret-right"></i>
														三级菜单名
													</a>
													<b class="arrow"></b>
												</li>
											</ul>
										 
									</li>
							</ul>
					</li>
					-->
					
			</ul>
			<!-- /.nav-list -->
			<div class="sidebar-toggle sidebar-collapse" id="sidebar-collapse">
				<i id="sidebar-toggle-icon" class="ace-icon fa fa-angle-double-left ace-save-state" data-icon1="ace-icon fa fa-angle-double-left" data-icon2="ace-icon fa fa-angle-double-right"></i>
			</div>
		</div>

		
		<div id="main" style="float:left;"></div>
		<!-- /.main-content -->

		<div class="footer">
			<div class="footer-inner">
				<div class="footer-content">
					<span class="bigger-120"> <span class="blue bolder">东方黑玛</span>
						Application &copy; 2017-
					</span>
				</div>
			</div>
		</div>

		<a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse"> 
			<i class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>
	</div>
	<!-- /.main-container -->

	<!-- basic scripts -->

		<!--[if !IE]> -->
			<script src="assets/js/jquery-2.1.4.min.js"></script>
		<!-- <![endif]-->

		<!--[if IE]>
			<script src="assets/js/jquery-1.11.3.min.js"></script>
		<![endif]-->
		<script type="text/javascript">
			if('ontouchstart' in document.documentElement) document.write("<script src='assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>
		
		<script src="assets/js/bootstrap.min.js"></script>

		<!-- page specific plugin scripts -->
		<script src="assets/js/jquery-ui.custom.min.js"></script>
		<script src="assets/js/jquery.ui.touch-punch.min.js"></script>
		<script src="assets/js/jquery.sparkline.index.min.js"></script>
		<script src="assets/js/jquery.dataTables.min.js"></script>
		<script src="assets/js/jquery.dataTables.bootstrap.min.js"></script>
		<script src="assets/js/dataTables.buttons.min.js"></script>
		<script src="assets/js/buttons.flash.min.js"></script>
		<script src="assets/js/buttons.html5.min.js"></script>
		<script src="assets/js/buttons.print.min.js"></script>
		<script src="assets/js/buttons.colVis.min.js"></script>
		<script src="assets/js/dataTables.select.min.js"></script>
		<script src="assets/js/custom/table-datatables.js"></script>
		<script src="assets/js/tools/base64.min.js"></script>
		<script src="assets/js/bootstrap-datepicker.min.js"></script>
	
		<!-- ace scripts -->
		<script src="assets/js/ace-elements.min.js"></script>
		<script src="assets/js/ace.min.js"></script>
		
	<!-- inline scripts related to this page -->
	<script type="text/javascript">
		jQuery(function($) {
			initMain = function(){
				var sider_zindex = $("#sidebar").css("z-index");
				if(sider_zindex == 'auto'){
					var body_width = $("body").width();
					var sidebar_width = $("#sidebar").width();
					var main_width = body_width-sidebar_width-30;
					$(".main-content").css("width",parseInt(main_width)+"px");
					return;
				}
				if(parseInt(sider_zindex)>=1027){
					var body_width = $("body").width();
					$(".main-content").css("width",parseInt(body_width)+"px");
					return;
				}
			}
			$(".nav-list a").not(".dropdown-toggle").on("click",function(e){
				e.preventDefault();
				var href = $(this).attr("href");
				$("#main").load(href,initMain);
			})
		})
						
	</script>

</body>
</html>
