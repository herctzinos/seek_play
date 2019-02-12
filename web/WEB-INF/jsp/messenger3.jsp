<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="forms"%>
<!DOCTYPE html>
<html>
    <head>
                <link rel="icon" href="resources/logo.jpg">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Game Requests</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

    </head>


    <body style=" background-image: url(resources/messenger.jpg);background-size: cover">

        <div class="centreButtons">
            <button onclick="myFunction1()" class="btn btn-primary" style="display:inline-block; text-align: center;">Incoming</button>
            <button onclick="myFunction2()" class="btn btn-primary" style="display:inline-block;">Outgoing</button>
            <button onclick="myFunction3()" class="btn btn-primary" style="display:inline-block;">Answered</button>
            <button onclick="window.location = 'http://localhost:8080/seek_play/user.htm';" class="btn btn-success" style="display:inline-block;">Go to Main Menu</button>
                 
        </div>
        <div class="container" id="incoming" style="background-color: transparent; ">

            <h3 class=" text-center" style="color: white"> Requests</h3>
            <div class="messaging" >
                <div class="inbox_msg">
                    <div class="inbox_people" style=" background: linear-gradient(to bottom, #2a7a5f, #05563b); opacity: 0.85;border-radius: 4%">
                        <div class="headind_srch">
                            <div class="recent_heading">
                                <h4 style="color: black">Incoming</h4>
                            </div>
                        </div>
                        <div class="inbox_chat" id="style-5">
                            <div class="chat_list">     
                                <c:forEach items="${incoming_requests}" var="incoming_requests">
                                    <div class="chat_people">
                                        <div class="chat_img"> <img src="http://localhost:8080/images/${incoming_requests.match.booker.image}.jpg" alt="https://ptetutorials.com/images/user-profile.png"> </div>
                                        <div class="chat_ib"><a id="incoming_id" style="display: none">${incoming_requests.id}</a>
                                            <h5 style="color: black">${incoming_requests.match.booker.username}<span class="chat_date">${incoming_requests.match.date}</span><br>
                                                <a style="float: right" id="text">${incoming_requests.match.hours.hour}</a>
                                            </h5>
                                            <p class="plain_message" style="display: none;">${incoming_requests.match.courtId.name}</p>
<!--                                            <h6>${incoming_requests.text}</h6>-->
                                            <h2 style="display: none">${incoming_requests.status}</h2>

                                        </div>
                                    </div>
                                </c:forEach> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mesgs">
                    <div class="msg_history">
                        <div class="incoming_msg" style="opacity: 0.8">
                            <div class="received_msg" style="color: white; white-space: pre-wrap;  background: linear-gradient(to bottom, #2a7a5f, #05563b); border-radius: 4%" id="m1">
                                <div class="received_withd_msg">
                                    <span class="time_date"></span>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div >
                            <div class="input_msg_write text-center" style="color: black">
                                <form id="accept" action="" method="POST"  >
                                    <button type="submit" class="btn btn-primary btn-rounded waves-effect btn-lg" id="acceptBtn" style="float:left;" disabled="">Accept</button>
                                </form>
                                <div>
                                    <form id="deny" action="" method="POST" style="display:inline">
                                        <button type="submit" class="btn btn-danger btn-rounded waves-effect btn-lg" id="denyBtn" style="float:right;" disabled="">Deny</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container" id="outgoing" style="display: none; background-color: transparent;">
            <h3 class=" text-center" style="color: white">Requests</h3>
            <div class="messaging">
                <div class="inbox_msg">
                    <div class="inbox_people" style=" background: linear-gradient(to bottom, #2a7a5f, #05563b); opacity: 0.85;border-radius: 4%">
                        <div class="headind_srch">
                            <div class="recent_heading">
                                <h4 style="color: black">Outgoing</h4>
                            </div>
                        </div>
                        <div class="inbox_chat" id="style-5">
                            <div class="chat_list">     
                                <c:forEach items="${outgoing_requests}" var="outgoing_requests">
                                    <div class="chat_people">
                                        <div class="chat_img"> <img src="http://localhost:8080/images/${outgoing_requests.requestReceiver.image}.jpg" alt="sunil"> </div>
                                        <div class="chat_ib">
                                            <h5 style="color: black">${outgoing_requests.requestReceiver.username}<span class="chat_date">${outgoing_requests.match.date}</span><br> <a style="float: right" id="text">${outgoing_requests.match.hours.hour}</a></h5>
                                            <p class="plain_message" style="display: none">${outgoing_requests.match.courtId.name}</p>
<!--                                            <h6 >${outgoing_requests.text}</h6>-->
                                            <h2 style="display: none">${outgoing_requests.status}</h2>
                                            <br>
                                        </div>
                                    </div>
                                </c:forEach> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mesgs">
                    <div class="msg_history">
                        <div class="incoming_msg" style="opacity: 0.8">
                            <div class="received_msg" style="color: white; white-space: pre-wrap;  background: linear-gradient(to bottom, #2a7a5f, #05563b); border-radius: 4%" id="m2">
                                <div class="received_withd_msg">
                                    <p></p>
                                    <span class="time_date"></span>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div >
                            <div class="input_msg_write text-center" style="color: black">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="container" id="answered" style="display: none;background-color: transparent;">
            <h3 class=" text-center" style="color: white">Requests</h3>
            <div class="messaging">
                <div class="inbox_msg">
                    <div class="inbox_people" style=" background: linear-gradient(to bottom, #2a7a5f, #05563b); opacity: 0.85;border-radius: 4%">
                        <div class="headind_srch">
                            <div class="recent_heading">
                                <h4 style="color: black">Answered</h4>
                            </div>
                        </div>
                        <div class="inbox_chat" id="style-5">
                            <div class="chat_list">     
                                <c:forEach items="${answered_requests}" var="answered_requests">
                                    <div class="chat_people">
                                        <div class="chat_img"> <img src="http://localhost:8080/images/${answered_requests.match.booker.image}.jpg" alt=""> </div>
                                        <div class="chat_ib">
                                            <h5 style="color: black">${answered_requests.match.booker.username}<span class="chat_date">${answered_requests.match.date}</span><br> <a style="float: right" id="text">${answered_requests.match.hours.hour}</a></h5>
                                            <p class="plain_message" style="display: none">${answered_requests.match.courtId.name}</p>
<!--                                            <h6 >${answered_requests.text}</h6>-->
                                            <h2 style="display: none">${answered_requests.status}</h2>

                                            <br>
                                        </div>
                                    </div>
                                </c:forEach> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="mesgs">
                    <div class="msg_history">
                        <div class="incoming_msg" style="opacity: 0.8">
                            <div class="received_msg" style="color: white; white-space: pre-wrap;  background: linear-gradient(to bottom, #2a7a5f, #05563b); border-radius: 4%" id="m3">
                                <div class="received_withd_msg">
                                    <p></p>
                                    <span class="time_date"></span>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div >
                            <div class="input_msg_write text-center" style="color: black">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="<c:url value="/resources/newjavascript.js?$$REVISION$$" />"></script> 
         <link href="<c:url value="/resources/newcss2.css" />" rel="stylesheet">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css" type="text/css" rel="stylesheet"/>
    </body>
</html>