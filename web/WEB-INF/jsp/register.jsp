<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>

<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="resources/logo.jpg">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
         <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">

        <title>Registration</title>
    </head>
    <body>
        <section class="login-block">
            <div class="container">
                <div class="row">


                    <spring:form modelAttribute="user" cssClass="login-form" action="${pageContext.request.contextPath}/registerFormHandling.htm" method="POST">  
                        <div class="col-md-4 login-sec">
                            <h2 class="text-center">Create your account</h2>
                            <div class="form-group">
                                <spring:label path="username" cssClass="text-uppercase">USERNAME</spring:label>
                                <spring:input  cssClass="form-control" path="username"/> 
                                <spring:errors path="username" cssClass="error error-message"/>

                            </div>  
                            <div class="form-group">
                                <spring:label path="firstname" cssClass="text-uppercase">FIRSNAME</spring:label>
                                <spring:input  cssClass="form-control" path="firstname"/> 
                                <spring:errors path="firstname" cssClass="error error-message"/>

                            </div>  
                            <div class="form-group">
                                <spring:label path="lastname" cssClass="text-uppercase">LASTNAME</spring:label>
                                <spring:input  cssClass="form-control" path="lastname"/> 
                                <spring:errors path="lastname" cssClass="error error-message"/>

                            </div>  
                            <div class="form-group">
                                <spring:label path="password" cssClass="text-uppercase">PASSWORD</spring:label>
                                <spring:password  cssClass="form-control" path="password"/> 
                                <spring:errors path="password" cssClass="error error-message"/>

                            </div>  
                            <div class="form-group">
                                <spring:label path="password_confirmation" cssClass="text-uppercase">CONFIRM PASSWORD</spring:label>
                                <spring:password   cssClass="form-control" path="password_confirmation"/> 
                                <spring:errors path="password_confirmation" cssClass="error error-message"/>

                            </div>  

                            <button type="submit" id="submit" class="btn btn-login float-right" style="background-color: #0c00ff">Submit</button>
                            <p class="change_link">
                                Already a member?
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
                    </spring:form> 


                </div>           
            </div>               
        </section>
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


        <script src="<c:url value="/resources/newjavascript.js?$$REVISION$$" />"></script> 
         <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">
    </body>
</html>
