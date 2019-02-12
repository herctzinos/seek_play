
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="resources/logo.jpg">

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            table {
                font-family: arial, sans-serif;
                border-collapse: collapse;
                width: 100%;
            }

            td, th {
                border: 1px solid #dddddd;
                text-align: left;
                padding: 8px;
            }


        </style>
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

            <h1 style="font-family: Verdana">Review your Co-Players</h1>

        </div>


        <div class="container" style=" background-color: transparent">


            <table border="1"  class="table table-hover" style= "width:1100px; background: black; color: white; cursor: pointer">

                <thead>
                    <tr>
                        <td>Player </td>
                        <td>Court name</td>
                        <td>Game date</td>
                        <td>Game time</td>

                    </tr>
                </thead>
                <tbody id="gamesTable">
                <c:forEach items="${pendingReviewList}" var="current">

                    <tr onclick="reply_click(this.id)" id="${current.id}">

                        <td>${current.requestReceiver.username}</td>
                        <td>${current.match.courtId.name}</td>
                        <td>${current.match.date}</td>
                        <td>${current.match.hours.hour}</td>

                    </tr>
                </c:forEach>
                    </tbody>
            </table>

            <h3>${gameRequestIDError}</h3>
            <div style="display: inline-block;">
                <h3 style="font-family: Verdana;"> ${review1}</h3>
                <c:if test="${not empty review}">
                    <spring:form modelAttribute="review" action="${pageContext.request.contextPath}/reviewFormHandling.htm" method="POST">  


                        <input type="hidden" id="game_request_id" name="gameRequestId" value="" />
                        <table>


                            <tr>
                                <td> <spring:label path="teamwork">Teamwork</spring:label></td> 
                                <td> <spring:radiobuttons path="teamwork" items="${Grades}" label="Teamwork"/>  <spring:errors path="teamwork" cssClass="error"/></td>

                            </tr>

                            <tr>
                                <td> <spring:label path="athletism">Athletism</spring:label></td> 
                                <td> <spring:radiobuttons path="athletism" items="${Grades}" label="Athletism"/>  <spring:errors path="athletism" cssClass="error"/></td>

                            </tr> 
                            <tr>
                                <td> <spring:label path="technique">Technique</spring:label></td> 
                                <td> <spring:radiobuttons path="technique" items="${Grades}" label="Technique"/>  <spring:errors path="technique" cssClass="error"/></td>

                            </tr>
                            <tr> 
                                <td> <spring:label path="comments">Comments</spring:label></td>  
                                <td> <spring:textarea  path="comments"  rows="3" cols="100"/></td>
                            </tr>
                        </table>
                        <input type="submit">
                    </spring:form>
                </c:if>

            </div>
        </div> 
        <script>

            function reply_click(clicked_id)
            {

                document.getElementById("game_request_id").value = clicked_id;

                $("#gamesTable").children().css("background-color", "black");


               // document.getElementById(clicked_id).style.color = "blue";
                document.getElementById(clicked_id).style.backgroundColor = "blue";
            }




        </script>

         <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">

        <script src="<c:url value="/resources/newjavascript.js?$$REVISION$$" />"></script> 


    </body>
</html>
