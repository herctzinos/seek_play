<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <link rel="icon" href="resources/logo.jpg">

        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        
        <link href="${pageContext.request.contextPath}/resources/newcss2.css" rel="stylesheet" >

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Seek & Play</title>
    </head> 
    <body>
    <section class="login-block">
        <div class="container">
            <div class="row">
                <form autocomplete="on" class="login-form" action="${pageContext.request.contextPath}/loginFormHandling.htm" method="POST">

                    <div class="col-md-4 login-sec">
                        <h2 class="text-center">Login Now</h2>
                        <div class="form-group">
                            <label for="exampleInputEmail1" class="text-uppercase">Username</label>
                            <input class="form-control" id="username" name="username" required="required" type="text" placeholder="myusername"/>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1" class="text-uppercase">Password</label>
                            <input class="form-control" id="password" name="password" required="required" type="password" placeholder="eg. X8df!90EO"/> 
                        </div>
                        <div class="error-message">${message}</div>
                        <div class="form-check">

                            <!--                                     <p class="login button"> 
                                                               <input type="submit" id="submit" value="Login" /> 
                                                            </p>-->
                            <button type="submit" id="submit" class="btn btn-login float-right" style="background-color: #0c00ff">Submit</button>
                        </div>
                        <p class="change_link">
                            Not a member yet ?
                            <a href="http://localhost:8080/seek_play/goToRegisterForm.htm">Go to register page</a>
                        </p>

                    </div>   



                    <div class="carousel fade-carousel slide col-md-8 banner-sec" data-ride="carousel" data-interval="4000" id="bs-carousel">
                        <!-- Overlay -->
                        <div class="overlay"></div>
                        <!-- Indicators -->
                        <ol class="carousel-indicators">
                            <li data-target="#bs-carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#bs-carousel" data-slide-to="1"></li>
                            <li data-target="#bs-carousel" data-slide-to="2"></li>
                            <li data-target="#bs-carousel" data-slide-to="3"></li>

                        </ol>

                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item slides active">
                                <div class="slide-1"></div>
                                <div class="hero">
                                    <hgroup>
                                        <h1 >Feeling like Giannis?</h1>        
                                        <h3></h3>
                                    </hgroup>
                                </div>
                            </div>
                            <div class="item slides">
                                <div class="slide-2"></div>
                                <div class="hero">        
                                    <hgroup>
                                        <h1 style="font-size: 2.5em">Looking for a Roger vs Rafa rivalry?</h1>        
                                        <h3></h3>
                                    </hgroup>       
                                </div>
                            </div>
                            <div class="item slides">
                                <div class="slide-3"></div>
                                <div class="hero">        
                                    <hgroup>
                                        <h1 style="font-size: 2.5em">Can't wait to play with your friends?</h1>        
                                        <h3></h3>
                                    </hgroup>
                                </div>
                            </div>
                            <div class="item slides">
                                <div class="slide-4"></div>
                                <div class="hero">        
                                    <hgroup>
                                        <h1 style="font-size: 3.5em">Welcome!</h1>        
                                        <h3></h3>
                                    </hgroup>
                                </div>
                            </div>
                        </div> 
                    </div>
                </form>
            </div>           
        </div>               
    </section>  

     <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">

    <script src="<c:url value="/resources/newjavascript.js?$$REVISION$$" />"></script> 
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>