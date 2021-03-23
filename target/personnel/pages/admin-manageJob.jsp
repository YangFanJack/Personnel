<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>部门管理</title>
    <meta name="description" content="AdminLTE2定制版">
    <meta name="keywords" content="AdminLTE2定制版">
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/morris/morris.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.theme.default.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/select2/select2.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-markdown/css/bootstrap-markdown.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.skinNice.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-slider/slider.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.css">
</head>

<body class="hold-transition skin-purple sidebar-mini">

    <div class="wrapper">

        <!-- 页面头部 -->
        <header class="main-header">


            <!-- Logo -->
            <a href="all-admin-index.html" class="logo">
                <!-- mini logo for sidebar mini 50x50 pixels -->
                <span class="logo-mini"><b>数据</b></span>
                <!-- logo for regular state and mobile devices -->
                <span class="logo-lg"><b>数据</b>后台管理</span>
            </a>


            <!-- Header Navbar: style can be found in header.less -->
            <nav class="navbar navbar-static-top">
                <!-- Sidebar toggle button-->
                <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                     

                        <li class="dropdown user user-menu">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="user-image" alt="User Image">
                        <span class="hidden-xs">张猿猿</span>
                    </a>
                            <ul class="dropdown-menu">
                                <!-- User image -->
                                <li class="user-header">
                                    <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">

                                    <p>
                                        张猿猿 - 数据管理员
                                        <small>最后登录 11:20AM</small>
                                    </p>
                                </li>
                                <!-- Menu Footer-->
                                <li class="user-footer">  
                                    <div class="pull-right">
                                        <a href="quit" class="btn btn-default btn-flat">注销</a>
                                    </div>
                                </li>
                            </ul>
                        </li>

                    </ul>
                </div>
            </nav>
        </header>
        <!-- 页面头部 /-->

        <!-- 导航侧栏 -->
        <aside class="main-sidebar">
            <!-- sidebar: style can be found in sidebar.less -->
            <section class="sidebar">
                <!-- Sidebar user panel -->
                <!-- sidebar menu: : style can be found in sidebar.less -->
                <ul class="sidebar-menu">
                    <li class="header">菜单</li>
                    <!-- 菜单 -->
                    <li class="treeview">
                        <a href="selectAllDepartmentByPage">
                            <i class="fa fa-folder"></i> <span>部门管理</span>
                            <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                        </a>
                    </li>
                    <li class="treeview">
                        <a href="selectAllJobByPage">
                            <i class="fa fa-folder"></i> <span>岗位管理</span>
                            <span class="pull-right-container">
					        <i class="fa fa-angle-left pull-right"></i>
					    </span>
                        </a>
                    </li>
                    <li class="treeview">
                        <a href="showEnterStaffByPage">
                            <i class="fa fa-folder"></i> <span>入职管理</span>
                            <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                        </a>
                    </li>
                    <li class="treeview">
                        <a href="showProbStaffByPage">
                            <i class="fa fa-folder"></i> <span>试用期管理</span>
                            <span class="pull-right-container">
					    <i class="fa fa-angle-left pull-right"></i>
					</span>
                        </a>
                    </li>

                    <li class="treeview">
                        <a href="showSeletedStaffByPage">
                            <i class="fa fa-folder"></i> <span>员工离职</span>
                            <span class="pull-right-container">
					        <i class="fa fa-angle-left pull-right"></i>
					    </span>
                        </a>
                    </li>
                    <!-- 菜单 /-->
                </ul>
            </section>
            <!-- /.sidebar -->
        </aside>
        <!-- 导航侧栏 /-->

        <!-- 内容区域 -->
        <!-- @@master = admin-layout.html-->
        <!-- @@block = content -->

        <div class="content-wrapper">

            <!-- 内容头部 -->
            <section class="content-header">
                <h1>
                    岗位管理
                </h1>
                <ol class="breadcrumb">
         
                    <li><a href="#">岗位管理</a></li>
                </ol>
            </section>
            <!-- 内容头部 /-->

            <!-- 正文区域 -->
            <section class="content">

                <!-- .box-body -->
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <h3 class="box-title">列表</h3>
                    </div>

                    <div class="box-body">

                        <!-- 数据表格 -->
                        <div class="table-box">

                            <!--工具栏-->
                            <div class="pull-left">
                                <div class="form-group form-inline">
                                    <div class="btn-group">
                                        <button type="button" class="btn btn-default" title="新建" data-toggle="modal" data-target="#myModal"><i class="fa fa-file-o"></i> 新建</button>
                                    </div>
                                </div>
                            </div>
                            <div class="box-tools pull-right">
                                <div class="has-feedback">
                                    <form action="${pageContext.request.contextPath}/selectAllJobByPage" method="get">
                                        <input type="text" class="form-control input-sm" placeholder="搜索" name="searchString">
                                    </form>
                                </div>
                            </div>
                            <!--工具栏/-->

                            <!--数据列表-->
                            <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                                <thead>
                                    <tr>
                                        <th>ID</th>
                                        <th>岗位名称</th>
										<th>所属部门</th>
										<th class="text-center">操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${jobPageBean.list}" var="keyword" varStatus="id">
                                    <tr>
                                        <td >${keyword.id}</td>
                                        <td >${keyword.name}</td>
                                        <td hidden="hidden">${keyword.departmentId.id}</td>
                                        <td >${keyword.departmentId.name}</td>
                                        <td class="text-center">
                                            <a href="${pageContext.request.contextPath}/showSeletedStaffByJobByPage?jobId=${keyword.id}"><button type="button" class="btn bg-olive btn-xs">员工详情</button></a>
                                            <button type="button" class="btn btn-warning btn-xs edit" data-toggle="modal" data-target="#myModal1"> 编辑</button>
                                            <a href="${pageContext.request.contextPath}/deleteJob?jobId=${keyword.id}"><button type="button" class="btn btn-danger btn-xs">删除</button></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <!--
                            <tfoot>
                            <tr>
                            <th>Rendering engine</th>
                            <th>Browser</th>
                            <th>Platform(s)</th>
                            <th>Engine version</th>
                            <th>CSS grade</th>
                            </tr>
                            </tfoot>-->
                            </table>
                            <!--数据列表/-->
                        </div>
                        <!-- 数据表格 /-->


                    </div>
                    <!-- /.box-body -->

                    <!-- .box-footer-->
                    <div class="box-footer">
                        <div class="pull-left">
                            <div class="form-group form-inline">
                                总共${jobPageBean.totalPage} 页，共${jobPageBean.totalCount} 条数据。
                            </div>
                        </div>

                        <div class="box-tools pull-right">
                            <ul class="pagination">
                                <li>
                                    <a href="${pageContext.request.contextPath}/selectAllJobByPage?currentPage=1&searchString=${searchString}" aria-label="Previous">首页</a>
                                </li>

                                <li>
                                    <a href="${pageContext.request.contextPath}/selectAllJobByPage?currentPage=${jobPageBean.currentPage-1}&searchString=${searchString}" aria-label="Previous">
                                        上一页
                                    </a>
                                </li>
                                <c:forEach  var="i" begin="1" end="${jobPageBean.totalPage}">
                                    <li><a href="${pageContext.request.contextPath}/selectAllJobByPage?currentPage=${i}&searchString=${searchString}">${i}</a></li>
                                </c:forEach>
                                <li>
                                    <a href="${pageContext.request.contextPath}/selectAllJobByPage?currentPage=${jobPageBean.currentPage+1}&totalPage=${jobPageBean.totalPage}&searchString=${searchString}" aria-label="Next">
                                        下一页
                                    </a>
                                </li>
                                <li>
                                    <a href="${pageContext.request.contextPath}/selectAllJobByPage?currentPage=${jobPageBean.totalPage}&searchString=${searchString}" aria-label="Next">尾页</a>
                                </li>
                            </ul>
                        </div>

                    </div>
                    <!-- /.box-footer-->
                </div>
				<!-- 模态框新建部门（Modal） -->
				<div class="update_modal">
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
									&times;
								</button>
								<h4 class="modal-title" id="myModalLabel">
									新建岗位
								</h4>
							</div>
							<form action="insertJob" role="from">
							<div class="modal-body">
					
								<div class="form-group">
								    <label for="postName">岗位名称</label>
								    <input type="text" name="name" class="form-control" id="postName" placeholder="岗位名称" required="required">
								</div>
								<div class="form-group">
								    <label for="Department">所属部门</label>
									<select name="departmentId" class="form-control" id="Department">
                                        <option value="" style="display: none;">所属部门</option>
                                        <c:forEach items="${departments}" var="keyword" varStatus="id">
                                            <option value="${keyword.id}">${keyword.name}</option>
                                        </c:forEach>
									</select>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default" data-dismiss="modal">关闭
								</button>
								<input type="submit" class="btn btn-primary">								
								</button>
							</div>
							</form>
						</div><!-- /.modal-content -->
					</div><!-- /.modal -->
					</div>
					<div class="update_modal">
					<!-- 模态框编辑部门（Modal） -->
					<div class="modal fade" id="myModal1" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<button type="button" class="close" data-dismiss="modal" aria-hidden="true">
										&times;
									</button>
									<h4 class="modal-title" id="myModalLabel1">
										编辑岗位
									</h4>
								</div>
								<form action="updateJob" role="from" id="editForm">
								<div class="modal-body">
									<div class="form-group">
									    <label for="postId1">岗位编号</label>
									    <input name="id" type="text" class="form-control" id="postId1" placeholder="岗位编号" required="required" readonly="readonly">
									</div>
									<div class="form-group">
									    <label for="postName1">岗位名称</label>
									    <input name="name" type="text" class="form-control" id="postName1" placeholder="岗位名称" required="required">
									</div>
									<div class="form-group">
									    <label for="Department"></label>
									   	<select name="departmentId" class="form-control" id="Department1">
                                            <option value="" style="display: none;">所属部门</option>
                                            <c:forEach items="${departments}" var="keyword" varStatus="id">
                                                <option value="${keyword.id}">${keyword.name}</option>
                                            </c:forEach>
									   	</select>
									 </div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-default" data-dismiss="modal">关闭
									</button>
									<input type="submit" class="btn btn-primary">								
									</button>
								</div>
								</form>
							</div><!-- /.modal-content -->
						</div><!-- /.modal -->
						</div>
				</div>
                </div>

            </section>
            <!-- 正文区域 /-->

        </div>
        <!-- @@close -->
        <!-- 内容区域 /-->

      <!-- 底部导航 -->
      <footer class="main-footer">
          <div class="pull-right hidden-xs">
              <b>Version</b> 1.0
          </div>
          <strong>2021-12-22 <a href="http://www.itcast.cn">大连海事大学</a>.</strong> 
      </footer>
      <!-- 底部导航 /-->

    </div>


    <script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/jQueryUI/jquery-ui.min.js"></script>
    <script>
        $.widget.bridge('uibutton', $.ui.button);
    </script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/raphael/raphael-min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/morris/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/sparkline/jquery.sparkline.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/knob/jquery.knob.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/daterangepicker/moment.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/daterangepicker/daterangepicker.zh-CN.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/datepicker/bootstrap-datepicker.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/datepicker/locales/bootstrap-datepicker.zh-CN.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/fastclick/fastclick.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/adminLTE/js/app.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/treeTable/jquery.treetable.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/select2/select2.full.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/colorpicker/bootstrap-colorpicker.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-wysihtml5/bootstrap-wysihtml5.zh-CN.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/bootstrap-markdown.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/locale/bootstrap-markdown.zh.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/markdown.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-markdown/js/to-markdown.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/ckeditor/ckeditor.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/input-mask/jquery.inputmask.extensions.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/datatables/jquery.dataTables.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/datatables/dataTables.bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/chartjs/Chart.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.resize.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.pie.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/flot/jquery.flot.categories.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/ionslider/ion.rangeSlider.min.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-slider/bootstrap-slider.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
    <script src="${pageContext.request.contextPath}/plugins/bootstrap-datetimepicker/locales/bootstrap-datetimepicker.zh-CN.js"></script>
    <script>
        $(document).ready(function() {
            // 选择框
            $(".select2").select2();

            // WYSIHTML5编辑器
            $(".textarea").wysihtml5({
                locale: 'zh-CN'
            });
        });
		
		
        // 设置激活菜单
        function setSidebarActive(tagUri) {
            var liObj = $("#" + tagUri);
            if (liObj.length > 0) {
                liObj.parent().parent().addClass("active");
                liObj.addClass("active");
            }
        }
        $(document).ready(function() {

            // 激活导航位置
            setSidebarActive("admin-datalist");

            // 列表按钮 
            $("#dataList td input[type='checkbox']").iCheck({
                checkboxClass: 'icheckbox_square-blue',
                increaseArea: '20%'
            });
            // 全选操作 
            $("#selall").click(function() {
                var clicks = $(this).is(':checked');
                if (!clicks) {
                    $("#dataList td input[type='checkbox']").iCheck("uncheck");
                } else {
                    $("#dataList td input[type='checkbox']").iCheck("check");
                }
                $(this).data("clicks", !clicks);
            });
        });
	
	$(document).ready(function(){
	  $(".edit").click(function(){
		var a=$(this).parent().siblings();
		$("#postId1").val(a[0].innerHTML);
		$("#postName1").val(a[1].innerHTML);
		$("#Department1").val(a[2].innerHTML);
	});
	})
    </script>
</body>

</html>