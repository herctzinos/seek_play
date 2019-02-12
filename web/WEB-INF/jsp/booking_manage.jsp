
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="icon" href="resources/logo.jpg">


        <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking section</title>

        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <script>

            $(document).ready(function () {

                $("#tr").click(function () {

                });




                $("#datepicker").change(function () {
                    $("#output").empty()
                    var text = $(this).val();
                    var text2 = $("#court").val();
                    //alert(text2);
                    $.ajax({
                        url: 'findFreeTimeSlotsByRest.htm?userinput=' + text + '&userinput2=' + text2,
                        contentType: 'application/json',
                        success: function (result) {
                            //alert(result)
                            var jsonobj = $.parseJSON(result);

                            $.each(jsonobj, function (i, item) {

                                $tr = $("#output").append(
                                        // $('<td>').text(item.username),
                                        $('<option value=' + item.hoursId + '>').text(item.hour)
                                        );
                            });
                        }
                    });
                });

            }
            );

        </script>
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
    <body style=" background-image: url(resources/new-event.jpg);">

        <div class="useravatar" style="  display: inline-block;">
            <img alt="${users.getUsername()}" src="http://localhost:8080/images/${user.getImage()}.jpg" class="profpic">


            <div style=" display: inline-block; color: white;"><b><span class="card-title">${user.getUsername()}</span></b></div>
            <a href="http://localhost:8080/seek_play/logout.htm"><button title="Log out" type="button" class="btn-pref btn" style="background-color: transparent; border-color: transparent; color: white; "><span class="glyphicon glyphicon-off"></span>
                </button></a>

        </div>

        <div class="btn-pref btn-group btn-group-justified btn-group-lg" role="group" aria-label="well">
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/star.htm" data-toggle="tab"><button type="button" id="rank" class="btn btn-default" ><span class="glyphicon glyphicon-star" aria-hidden="true"></span>
                        <div class="hidden-xs">Ranks</div>
                    </button></a>
            </div>
            <div class="btn-group" role="group">
                <a href="http://localhost:8080/seek_play/messenger3.htm" data-toggle="tab"><button type="button" id="messages" class="btn btn-default" href="#tab2" data-toggle="tab" ><span class="glyphicon glyphicon-envelope" aria-hidden="true"></span>
                        <div hidden-xs">Requests</div>
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
        <br>


        <!--Creation section -->
        <div class="container" style= "width:700px; background: linear-gradient(to bottom, #606060, #282828); color: white; cursor: pointer">
            <h1 style="color: white; font-family: Verdana">Let's create a new event!</h1>

            <div style="overflow: auto; width:680px; height:525px;" id="style-5">

                <form:form id="form1" modelAttribute="courtReservation" method="POST" cssStyle="color: black" name="form1" action="${pageContext.request.contextPath}/handleEventCreationForm.htm">
                    <form:select id="court" name="court" path="courtId.id">
                        <c:forEach items="${courtList}" var="courtList">
                            <option value="${courtList.id}">${courtList.name}</option>
                        </c:forEach>

                    </form:select>
                    <form:input id="datepicker" type="date"  name="date" path="date"/>
                    <form:select id="output" path="hours.hoursId" ></form:select>
                        <button type="submit">Create Event</button>
                </form:form>


                <h2 style="font-family: Verdana">My Active Events</h2>

                <!--                <div style="overflow: auto; width:680px; height:270px;" id="style-5">-->

                <table border="1" class="table table-hover" style="color: white" id="booktable">
                    <c:forEach items="${myActiveReservationList}" var="current">
                        <tr onclick="reply_click(this.id)" id ="${current.courtReservationID}">

                            <td><c:out value="${current.courtId.name}" /><td>
                            <td><c:out value="${current.date}" /><td>
                            <td><c:out value="${current.hours.hour}" /><td>


                                <a href='${pageContext.request.contextPath}/booking_delete.htm?id=${current.courtReservationID}'><span class="fa fa-trash" aria-hidden="true" style="color: white"></span></a>

                        </tr>
                    </c:forEach>
                </table>


                <!--                    <div style="overflow: auto; width:680px; height:270px;" id="style-5">-->
                <table  border="1" class="table table-hover" id="output1" style="color: white;">SELECT AVAILABLE PLAYERS BASED ON THEIR RATING</table>
                <br>
                <table  border="1" class="table table-hover" id="output3" style="color: white;">SELECT AVAILABLE PLAYERS NOT YET REVIEWED</table>
                <br>
                <table  border="1" class="table table-hover" id="output2" style="color: white;">PLAYERS ALREADY INVITED</table>


                <!--                    </div>-->
            </div>
        </div>

        <script>


            function reply_click(clicked_id)
            {
                var courtReservationId = clicked_id;
                $("#output1").empty();
                $("#output2").empty();
                $("#output3").empty();

                $.ajax({url: 'findAvaliablePlayersForThisGameByRest.htm?courtReservationId=' + courtReservationId, contentType: 'application/json',
                    success: function (result1) {
                        var jsonobj1 = $.parseJSON(result1);

                        //  $('table').text("SELECT AVAILABLE PLAYERS FOR YOUR GAME").appendTo('#output1');


                        $('<tr>').append(
                                $('<td>').text("Username"),
                                $('<td>').text("Teamwork"),
                                $('<td>').text("Athletism"),
                                $('<td>').text("Technique")).appendTo('#output1').css("font-weight", "bold");

                        $(function () {
                            $.each(jsonobj1, function (i, item) {
                                $('<tr>').append(
                                        $('<td>').text(item.username),
                                        $('<td>').text(item.teamwork),
                                        $('<td>').text(item.athletism),
                                        $('<td>').text(item.technique),
                                        $('<td>').append('<a href="${pageContext.request.contextPath}/handleGameRequests.htm?user_to_be_invited=' + item.player + '&game=' + courtReservationId + '">' + "Send Request" + '</a>')).appendTo('#output1');
                            });

                        });
                    }
                });

                $.ajax({url: 'findPlayersnotyetReviewed.htm?courtReservationId=' + courtReservationId, contentType: 'application/json',
                    success: function (result3) {
                        var jsonobj3 = $.parseJSON(result3);

                        $('<tr>').append(
                                $('<td>').text("Username"),
                                $('<td>').text("Teamwork"),
                                $('<td>').text("Athletism"),
                                $('<td>').text("Technique")).appendTo('#output3').css("font-weight", "bold");

                        $(function () {
                            $.each(jsonobj3, function (i, item) {
                                $('<tr>').append(
                                        $('<td>').text(item.username),
                                        $('<td>').text("N/A"),
                                        $('<td>').text("N/A"),
                                        $('<td>').text("N/A"),
                                        $('<td>').append('<a href="${pageContext.request.contextPath}/handleGameRequests.htm?user_to_be_invited=' + item.userId + '&game=' + courtReservationId + '">' + "Send Request" + '</a>')).appendTo('#output3');
                            });
                        });
                    }
                });


                $.ajax({url: 'findplayersalreadyinvited.htm?courtReservationId=' + courtReservationId, contentType: 'application/json',
                    success: function (result2) {
                        var jsonobj2 = $.parseJSON(result2);


                        $('<tr>').append(
                                $('<td>').text("Username"),
                                $('<td>').text("Teamwork"),
                                $('<td>').text("Athletism"),
                                $('<td>').text("Technique")).appendTo('#output2').css("font-weight", "bold");

                        $(function () {
                            $.each(jsonobj2, function (i, item) {
                                $('<tr>').append(
                                        $('<td>').text(item.username),
                                        $('<td>').text(item.teamwork),
                                        $('<td>').text(item.athletism),
                                        $('<td>').text(item.technique)).appendTo('#output2');

                            });
                        });
                    }
                });
            }
            ;

        </script>

        <script src="<c:url value="/resources/newjavascript.js?$$REVISION$$" />"></script> 
         <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">
    </body>
</html>
