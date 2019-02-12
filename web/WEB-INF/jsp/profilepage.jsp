

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="resources/logo.jpg">

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
        <script>
            $(document).ready(function () {
                $(".btn-pref .btn").click(function () {
                    $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
                    // $(".tab").addClass("active"); // instead of this do the below 
                    $(this).removeClass("btn-default").addClass("btn-primary");
                });
            });
        </script>
    </head>
    <body style=" background-image: url(resources/star.jpeg);background-size: cover">

        <div class="useravatar" style="  display: inline-block;">
            <img alt="${users.getUsername()}" src="http://localhost:8080/images/${users.getImage()}.jpg" class="profpic">


            <div style=" display: inline-block; color: white;"><b><span class="card-title">${users.getUsername()}</span></b></div>
            <a href="http://localhost:8080/seek_play/logout.htm"><button type="button" class="btn-pref btn" style="background-color: transparent; border-color: transparent; color: white; "><span class="glyphicon glyphicon-off"></span>
                </button></a>

        </div>  

        <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="well">
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/search.htm" data-toggle="tab"><button type="button" id="search" class="btn btn-default" ><span class="glyphicon glyphicon-arrow-left" aria-hidden="true"></span>
                        <div class="hidden-xs">Back to Search</div>
                    </button></a>
            </div>          
        </div>


        <div class="col-xs-12 col-md-12 text-center">
            <div class="tab-pane fade in active center" id="tab1">
                <div class="" style="background-color: transparent;  box-shadow: none;">

                    <div class="row">
                        <div class="col-xs-12 col-md-12 text-center">                            

                            <h1 class="rating-num">${user.getUsername()}</h1>
                            <div class="profile-header-img">
                                <img class="img-circle" src="http://localhost:8080/images/${user.getImage()}.jpg" />
                                <!-- badge -->
                                <h2 > ${othersReviewsEmpty}</h2>
                                <c:if test="${empty othersReviewsEmpty}">
                                    <h2 > ${othersReviewsEmpty}</h2>
                                    <div class="rank-label-container">
                                        <h1><span>${star} / 5</span></h1>
                                    </div>
                                </div>
                                <div class="star-rating">
                                    <div class="back-stars">
                                        <i class="fa fa-futbol-o" aria-hidden="true"></i>
                                        <i class="fa fa-futbol-o" aria-hidden="true"></i>
                                        <i class="fa fa-futbol-o" aria-hidden="true"></i>
                                        <i class="fa fa-futbol-o" aria-hidden="true"></i>
                                        <i class="fa fa-futbol-o" aria-hidden="true"></i>
                                        <div class="front-stars" style="width:${overall}%">
                                            <i class="fa fa-futbol-o" aria-hidden="true"></i>
                                            <i class="fa fa-futbol-o" aria-hidden="true"></i>
                                            <i class="fa fa-futbol-o" aria-hidden="true"></i>
                                            <i class="fa fa-futbol-o" aria-hidden="true"></i>
                                            <i class="fa fa-futbol-o" aria-hidden="true"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-xs-12 col-md-12 text-center">
                                <div class="row rating-desc">
                                    <div class="col-xs-2 col-md-2 text-right">
                                        <span class="fa fa-group"></span>  Teamwork
                                    </div>
                                    <div class="col-xs-8 col-md-9 ">
                                        <div class="progress progress-striped ">
                                            <div class="progress-bar progress-bar-success " role="progressbar " aria-valuenow="20 "
                                                 aria-valuemin="0 " aria-valuemax="100 " style="width:${team}%; background-color:  blue;">
                                                <span class="sr-only ">${team}%</span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end 5 -->
                                    <div class="col-xs-2 col-md-2 text-right ">
                                        <span class="fa fa-heartbeat "></span> Athletism
                                    </div>
                                    <div class="col-xs-8 col-md-9 ">
                                        <div class="progress  progress-striped">
                                            <div class="progress-bar progress-bar-success" role="progressbar " aria-valuenow="20 "
                                                 aria-valuemin="0 " aria-valuemax="100 " style="width: ${athlet}%; background-color:  crimson;" >
                                                <span class="sr-only ">${athlet}%</span>
                                            </div>
                                        </div>
                                    </div>
                                    <!-- end 4 -->
                                    <div class="col-xs-2 col-md-2 text-right ">
                                        <span class="fa fa-line-chart "></span>  Technique
                                    </div>
                                    <div class="col-xs-8 col-md-9 ">
                                        <div class="progress  progress-striped">
                                            <div class="progress-bar progress-bar-info " role="progressbar " aria-valuenow="20 "
                                                 aria-valuemin="0 " aria-valuemax="100 " style="width:${tech}%; background-color:  darkcyan; ">
                                                <span class="sr-only ">${tech}%</span>
                                            </div>
                                        </div>
                                    </div>                                   
                                </div>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
        </div>


        <script src="<c:url value="/resources/newjavascript.js?$$REVISION$$" />"></script>
         <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">

    </body>
</html>