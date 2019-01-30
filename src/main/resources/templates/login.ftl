<html>
<head>
    <title></title>
    <link rel="stylesheet" href="../static/theme/css/panta.css"/>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
</head>
<body>
<div class="pantaDiv">
    <section>
        <div class="divHeader">
            <span class="loginHeader">用户登录</span>
        </div>
        <form class="pantaForm" id="loginForm" action="/login/check" method="post">
            <ul class="bgfull">
                <div class="inputbg bgfull">
	                <li><label>手机号</label><input type="text"  placeholder="请输入您的手机号" name="username"></li>
	                <li><label>密码</label><input type="password"  placeholder="请输入您的密码" name="password"></li>
                </div>
                <li class="normal"><a class="submit" onclick="loginSubmit()">登录</a></li>
            </ul>
        </form>
    </section>
</div>

<div class="logo"></div>
<script>
    function loginSubmit(){
    	$("#loginForm").submit();
    }
</script>
</body>
</html>