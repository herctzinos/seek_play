<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link rel="icon" href="resources/logo.jpg">

        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script>setTimeout(function () {
                window.location.href = 'index.htm'
            }, 5000);</script>

        <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">

        <!------ Include the above in your HEAD tag ---------->     
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Successful Registration</title>
    </head> 
    <body>
    <section class="login-block">
        <div class="container">
            <div class="row">

                <div class="col-md-4 login-sec">
                    <h2 class="text-center">You have successfully registered!</h2>
                    <h4 class="text-center">Please wait 5 seconds to be redirected to the login page or press the button below</h4>

                    <p>
                        <a href="http://localhost:8080/seek_play/index.htm">Go to login page</a>
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
            </div>           
        </div>               
    </section>  


     <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">

    <script src="<c:url value="/resources/newjavascript.js?$$REVISION$$" />"></script> 
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>