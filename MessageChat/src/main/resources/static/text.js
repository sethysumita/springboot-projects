
var stompClient = null;
function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
        $("#conversation").show();
    }
    else {
        $("#conversation").hide();
    }
    $("#greetings").html("");
}
function connect() {


   var socket = new SockJS('/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        setConnected(true);
        console.log('Connected: ' + frame);
        stompClient.subscribe('/message/greetings', function(greeting) {
            showGreeting(JSON.parse(greeting.body));
        });

   });
   }
function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
function sendContent() {
	
    stompClient.send("/app/textTo", {},
        JSON.stringify({'content': $("#content").val() 
        }));
}
function showGreeting(message) {
    /*$("#greetings").empty();*/
    $("#greetings").append("<tr><td>" + message.content + "</td></tr>");
}



$(document).ready(function(){
  connect();
  
    $("#send").click(function() 
    { 
	event.preventDefault();
	sendContent(); 
	});
});


