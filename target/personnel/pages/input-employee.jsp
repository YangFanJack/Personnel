<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>人才库录入</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <!-- Bootstrap 3.3.6 -->
    <!-- Font Awesome -->
    <!-- Ionicons -->
    <!-- Theme style -->
    <!-- iCheck -->
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/plugins/iCheck/square/blue.css">
</head>

<body class="hold-transition register-page">
<div class="register-box" style="width: 50%;">
    <div class="register-logo">
        <a href="input-employee.jsp">人才数据录入</a>
    </div>
    <div class="register-box-body">
        <p class="login-box-msg">信息填写</p>

        <form action="${pageContext.request.contextPath}/insertStaff" method="get">
            <div class="form-group has-feedback">
                <input type="text" name="name" class="form-control" placeholder="全名">

            </div>
            <div class="form-group has-feedback">
                &nbsp;&nbsp;<label>  性别：</label>
                男 ：<input type="radio" value="1" name="gender" checked="checked" class="form-control">
                女 : <input type="radio" value="2" name="gender" class="form-control">
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="identityId" class="form-control" placeholder="身份证号">
            </div>
            <div class="form-group has-feedback">
                <select name="from" required="required" class="form-control">
                    <option value="" style="display: none">招聘来源</option>
                    <option value ="1">校园招聘</option>
                    <option value ="2">社会招聘</option>
                    <option value ="3">其他</option>
                </select>
            </div>
            <div class="form-group has-feedback">
                <select name="org" required="required" class="form-control">
                    <option value="" style="display: none">政治面貌</option>
                    <option value ="1">党员</option>
                    <option value ="2">预备党员</option>
                    <option value ="3">团员</option>
                    <option value ="4">其他</option>
                </select>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="home" class="form-control" placeholder="籍贯">
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="phone" class="form-control" placeholder="联系电话">
            </div>
            <div class="form-group has-feedback">
                <select name="qualif1" required="required" class="form-control">
                    <option value="" style="display: none">最高学历</option>
                    <option value ="1">小学</option>
                    <option value ="2">初中</option>
                    <option value ="3">中专</option>
                    <option value ="4">高中</option>
                    <option value ="5">大专</option>
                    <option value ="6">本科</option>
                    <option value ="7">硕士研究生</option>
                    <option value ="8">博士研究生</option>
                </select>
            </div>
            <div class="form-group has-feedback">
                <select name="qualif2" required="required" class="form-control">
                    <option value="" style="display: none">最高学位</option>
                    <option value ="1">学士</option>
                    <option value ="2">硕士</option>
                    <option value ="3">博士</option>
                </select>
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="university" class="form-control" placeholder="毕业院校">
            </div>
            <div class="form-group has-feedback">
                <input type="text" name="major" class="form-control" placeholder="所学专业">
            </div>

            <div class="row">
                <!-- /.col -->
                <div class="col-xs-12">
                    <button type="submit" class="btn btn-primary btn-block btn-flat">确认录入</button>
                </div>
                <!-- /.col -->
            </div>
            <span>${msg}</span>
        </form>
    </div>
    <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.2.3 -->
<!-- Bootstrap 3.3.6 -->
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/plugins/jQuery/jquery-2.2.3.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/plugins/iCheck/icheck.min.js"></script>
<script>
    $(function() {
        $('input').iCheck({
            checkboxClass: 'icheckbox_square-blue',
            radioClass: 'iradio_square-blue',
            increaseArea: '20%' // optional
        });
    });
</script>
</body>

</html>