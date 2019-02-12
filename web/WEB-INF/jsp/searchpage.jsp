
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>   
        <link rel="icon" href="resources/logo.jpg">

        <link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search</title>
        <script>$(document).ready(function () {
                $(".btn-pref .btn").click(function () {
                    $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");
                    $(this).removeClass("btn-default").addClass("btn-primary");
                });
            });
        </script>
    </head>
    <body style=" background-image: url(resources/game-request.jpeg);background-size: cover">

        <div class="useravatar" style="  display: inline-block;">
            <img alt="${users.getUsername()}" src="http://localhost:8080/images/${users.getImage()}.jpg" class="profpic">


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
                <a href="http://localhost:8080/seek_play/search.htm" data-toggle="tab"><button type="button" id="search" class="btn btn-primary" href="#tab1" data-toggle="tab"><h4><span class="glyphicon glyphicon-search" aria-hidden="true"></span></h4>

                    </button></a>
            </div>

        </div>

        <div class="well main-center"  >
            <div class="tab-content center">
                <div class="tab-pane fade in active">
                    <h3 style="font-family: Verdana; font-size: 30px;"><B style="color: white">Search for Player</B></h3>
                    <input type="text" name="texts" id="mytext" style="color: black" placeholder="Enter Username"/><br>
                    <table class="display" style="width: 100%">

                        <tr style="font-size: 27px; font-family: Verdana; color: white">
                            <td>Picture</td>
                            <td >Username</td>
                            <td>First Name</td>
                            <td>Last Name</td>
                        </tr>

                        <tr style="font-size: 22px;">
                            <td id="text4"></td>
                            <td id="text"></td>
                            <td id="text2"></td>
                            <td id="text3"></td>
                        </tr>

                    </table>


                </div>
            </div>
        </div>

    </div> 

    <script>
        $(document).ready(function () {

            $(".btn-pref .btn").click(function () {
                $(".btn-pref .btn").removeClass("btn-primary").addClass("btn-default");

                $(this).removeClass("btn-default").addClass("btn-primary");
            });

            $("#mytext").keyup(function () {

                var text = $(this).val();
                $.ajax({
                    url: 'find.htm?texts=' + text,

                    contentType: 'application/json',
                    success: function (result) {
                        $("#text").empty();
                        $("#text2").empty();
                        $("#text3").empty();
                        $("#text4").empty();
                        var jsonobj = $.parseJSON(result);
                        $.each(jsonobj, function (i, item) {
                            $tp = $('<a href="http://localhost:8080/seek_play/profile.htm?name=' + item.username + '"><br>').append(
                                    $('<td>').append('<img class="profpic" src="http://localhost:8080/images/' + item.image + '.jpg">'));
                            $tr = $('<a href="http://localhost:8080/seek_play/profile.htm?name=' + item.username + '"><br>').append(
                                    $('<td>').text(item.username));
                            $ts = $('<a href="http://localhost:8080/seek_play/profile.htm?name=' + item.username + '"><br>').append(
                                    $('<td>').text(item.firstname));
                            $th = $('<a href="http://localhost:8080/seek_play/profile.htm?name=' + item.username + '"><br>').append(
                                    $('<td>').text(item.lastname));

                            $("#text").append($tr);
                            $("#text2").append($ts);
                            $("#text3").append($th);
                            $("#text4").append($tp);
                        });
                    }
                });

            });

        });
     



    </script>

    <script src="<c:url value="/resources/newjavascript.js?$$REVISION$$" />"></script> 
     <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">
</body>
</html>
