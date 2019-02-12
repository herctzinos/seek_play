

var active = 'active_chat';
var $thumbs = $('.chat_people').click(function (e) {
    e.preventDefault();
    $thumbs.removeClass(active);
    $(this).addClass(active);
});

var name = document.getElementsByClassName(".chat_people");
$(".chat_people").click(function () {



    var div = this.textContent;
    var court = $(this).find('p').text();
    var user = $(this).find('h5').justtext().trim();
    var date = $(this).find('span').text();
//    var message = $(this).find('h6').text();
    var time = $(this).find('a#text').text();
    var id = $(this).find('a#incoming_id').text();
    var status = $(this).find('h2').text();


    /*    $("div.received_msg#m1").text(user + " send you a game request!\nDate: " + date + " at " + time + " \nCourt: " + court + "\n" + "Message: " + message + "\n" + "Status: " + status);
     $("div.received_msg#m2").text(" You send " + user + " a game request!\nDate: " + date + " at " + time + " \nCourt: " + court + "\n" + "Your message: " + message + "\n" + "Status: " + status);
     $("div.received_msg#m3").text(user + " sssssend you a game request!\nDate: " + date + " at " + time + " \nCourt: " + court + "\n" + "Message: " + message + "\n" + "Status: " + status);
     */
    $("div.received_msg#m1").text(user + " send you a game request!\nDate: " + date + " at " + time + " \nCourt: " + court + "\n" + "Status: " + status);
    $("div.received_msg#m2").text(" You send " + user + " a game request!\nDate: " + date + " at " + time + " \nCourt: " + court + "\n" + "Status: " + status);
    $("div.received_msg#m3").text(user + " send you a game request!\nDate: " + date + " at " + time + " \nCourt: " + court + "\n" + "Status: " + status);


    document.getElementById("acceptBtn").disabled = false;
    document.getElementById("denyBtn").disabled = false;


    document.getElementById("accept").action = "/seek_play/accept.htm?id=" + id;
    document.getElementById("deny").action = "/seek_play/deny.htm?id=" + id;

//alert(user+"test");
});

jQuery.fn.justtext = function () {

    return $(this).clone()
            .children()
            .remove()
            .end()
            .text();

};

function myFunction1() {
    var mainFrameOne = document.getElementById("incoming");
    var mainFrameTwo = document.getElementById("outgoing");
    var mainFrameThree = document.getElementById("answered");






    mainFrameOne.style.display = "block";
    mainFrameTwo.style.display = "none";
    mainFrameThree.style.display = "none";


}
;
function myFunction2() {
    var mainFrameOne = document.getElementById("incoming");
    var mainFrameTwo = document.getElementById("outgoing");
    var mainFrameThree = document.getElementById("answered");



    mainFrameOne.style.display = "none";
    mainFrameTwo.style.display = "block";
    mainFrameThree.style.display = "none";

}
;

function myFunction3() {
    var mainFrameOne = document.getElementById("incoming");
    var mainFrameTwo = document.getElementById("outgoing");
    var mainFrameThree = document.getElementById("answered");



    mainFrameOne.style.display = "none";
    mainFrameTwo.style.display = "none";
    mainFrameThree.style.display = "block";

}
;

$(document).ready(function () {
    $(".btn").click(function () {
        $("div.received_msg").empty();
    });
}
);

