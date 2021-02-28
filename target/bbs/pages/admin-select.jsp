<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script>
        $(function () {
            $("#academy").change(function() {
                var order = {"departmentId" : $("#academy").val()};
                $.ajax({
                    url : "${pageContext.request.contextPath}/findSelectJob",
                    type : "POST",
                    dataType: "json",
                    data : JSON.stringify(order),
                    contentType: "application/json;charset=UTF-8",
                    success : function(data) {
                        // 清除之前select下拉框下的option
                        document.getElementById("major").options.length = 0;
                        for (var i = 0; i < data.length; i++) {
                            var option = document.createElement("option");
                            $(option).val(data[i].id);
                            $(option).text(data[i].name);
                            $('#major').append(option);
                        }
                    },
                    error : function(xhr, textStatus, errorThrown) {
                        /*错误信息处理*/
                        alert("进入error---");
                        alert("状态码："+xhr.status);
                        alert("状态:"+xhr.readyState);//当前状态,0-未初始化，1-正在载入，2-已经载入，3-数据进行交互，4-完成。
                        alert("错误信息:"+xhr.statusText );
                        alert("返回响应信息："+xhr.responseText );//这里是详细的信息
                        alert("请求状态："+textStatus);
                        alert(errorThrown);
                        alert("请求失败");
                    }
                })
                return false;
            })
        })
    </script>
</head>
<body>
    <select class="form-control" id="academy" name="">
        <option value="" style="display: none;">部门</option>
        <option value="1" id="1" >财务部</option>
        <option value="2" id="2" >采购部</option>
        <option value="3" id="3" >技术部</option>
        <option value="4" id="4" >生产部</option>
    </select>
    <select class="form-control" id="major" name="major">
        <option value="" style="display: none;">岗位</option>
    </select>
</body>
</html>
