<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>登入 - layuiAdmin</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link href="/css/layui.css" rel="stylesheet" type="text/css" />
    <link href="/css/admin.css" rel="stylesheet" type="text/css" />
    <link href="/css/login.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="layadmin-user-login layadmin-user-display-show" id="LAY-user-login" style="display: none;">

    <div class="layadmin-user-login-main">
        <div class="layadmin-user-login-box layadmin-user-login-header">
            <h2>统一权限管理中心</h2>
        </div>
        <form role="form" action="/login2" method="post">
            <div class="layadmin-user-login-box layadmin-user-login-body layui-form">
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-username"></label>
                    <input type="text" name="username" id="username" value="15259155608" lay-verify="required" placeholder="用户名"
                           class="layui-input">
                </div>
                <div class="layui-form-item">
                    <label class="layadmin-user-login-icon layui-icon layui-icon-password"></label>
                    <input type="password" name="password" id="password" value="123456" lay-verify="required" placeholder="密码"
                           class="layui-input">
                </div>

                <div class="layui-form-item">
                    <button class="layui-btn layui-btn-fluid" type="submit">登 入</button>
                </div>
            </div>
          <#--  <input type="hidden" id="csrf_token" name="${_csrf.parameterName}" value="${_csrf.token}"/>-->
        </form>
    </div>

    <div class="layui-trans layadmin-user-login-footer">

        <p>© 2019 <a href="http://www.fjhrt.com/" target="_blank">恒瑞通（福建）</a></p>
    </div>

</div>
</body>
</html>