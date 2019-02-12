

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

        <title>Others reviews</title>
        <script>$(document).ready(function () {
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
            <a href="http://localhost:8080/seek_play/logout.htm"><button title="Log out" type="button" class="btn-pref btn" style="background-color: transparent; border-color: transparent; color: white; "><span class="glyphicon glyphicon-off"></span>
                </button></a>

        </div>
        <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="well">
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/star.htm" data-toggle="tab"><button type="button" id="rank" class="btn btn-primary" ><h4><span class="glyphicon glyphicon-star" aria-hidden="true"></span></h4>
                    </button></a>
            </div>
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/messenger3.htm" data-toggle="tab"><button type="button" id="messages" class="btn btn-default" href="#tab2" data-toggle="tab" ><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                        <div class="hidden-xs">Requests</div>
                    </button></a>
            </div>
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/person.htm" data-toggle="tab"><button type="button" id="personalinfos" class="btn btn-default" href="#tab1" data-toggle="tab" ><span class="glyphicon glyphicon-user" aria-hidden="true"></span>
                        <div class="hidden-xs">Personal Infos</div>
                    </button></a>
            </div>
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/booking_manage.htm" data-toggle="tab"><button type="button" id="event" class="btn btn-default" href="#tab1" data-toggle="tab"><span class="glyphicon glyphicon-calendar" aria-hidden="true"></span>
                        <div class="hidden-xs">Events</div>
                    </button></a>
            </div>
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/search.htm" data-toggle="tab"><button type="button" id="search" class="btn btn-default" href="#tab1" data-toggle="tab"><span class="glyphicon glyphicon-search" aria-hidden="true"></span>
                        <div class="hidden-xs">Search</div>
                    </button></a>
            </div>

        </div>
        <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="well">
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/myreviews.htm" data-toggle="tab"><button type="button" id="my" class="btn btn-default" style="color: #1988F2"><span class="glyphicon glyphicon-save" aria-hidden="true"></span>
                        <div class="hidden-xs">My Reviews</div>
                    </button></a>
            </div>
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/others.htm" data-toggle="tab"><button type="button" id="others" class="btn btn-default" data-toggle="tab" style="color: #1988F2"><span class="glyphicon glyphicon-open" aria-hidden="true"></span>
                        <div class="hidden-xs">Others Reviews</div>
                    </button></a>
            </div>
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/goToReviewForm.htm" data-toggle="tab"><button type="button" id="unfinished" class="btn btn-default" data-toggle="tab" style="color: #1988F2"><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
                        <div class="hidden-xs">Unfinished Reviews</div>
                    </button></a>
            </div>
        </div>
        <div class="col-xs-12 col-md-12 text-center">

            <h1 style="font-family: Verdana">Reviews by me</h1>

        </div>
        <div class="col-xs-12 col-md-12 text-center" >


            <div class="container " style=" background-color: transparent">
                <div id="11" >

                    <h2 > ${othersReviewsEmpty}</h2>
                    <c:if test="${not empty othersReviews}">
                        <table border="1" class="table table-hover" style= "width:1100px; background: linear-gradient(to bottom, #606060, #282828); color: white; cursor: crosshair">
                            <thead >
                                <tr style="color:green; font-weight: bold">
                                    <td>Court Name</td>
                                    <td>Game Date</td>
                                    <td>Game Time</td>
                                    <td>Reviewed</td>
                                    <td>Teamwork</td>
                                    <td>Athletism</td>
                                    <td>Technique</td>
                                    <td>Comments</td>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${othersReviews}" var="current">

                                    <tr>
                                        <td><c:out value="${current.match.courtId.name}" /></td>
                                        <td><c:out value="${current.match.date}" /></td>
                                        <td><c:out value="${current.match.hours.hour}" /></td>
                                        <td><c:out value="${current.reviewed.username}" /></td>
                                        <td><c:out value="${current.teamwork}" /></td>
                                        <td><c:out value="${current.athletism}" /></td>
                                        <td><c:out value="${current.technique}" /></td>
                                        <td><c:out value="${current.comments}" /></td>


                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>

        </div>
    </div>

    <script src="<c:url value="/resources/newjavascript.js?$$REVISION$$" />"></script> 
     <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">
</body>
</html>
