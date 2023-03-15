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

$(document).ready(function(){
  connect();
});

function connect() {
	var socket = new SockJS('/gs-guide-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/message/greetings', function(details) {
			console.log("===========" + details.body);
			//displayThought(chatShow.body);
			
			showGreeting(JSON.parse(details.body));
           
		});
		});
   }
		
		function showGreeting(message) {	
	$("#greetings").append("<tr><td>" + message.content + "</td></tr>");
	
	
	}
	
	function sendContent() {
		
    stompClient.send("/app/textTo", {},
        JSON.stringify({'content': $("#content").val() 
        }));
}
	
	
$(document).ready(function(){
  connect();
  
    $("#send").click(function() 
    { 
	event.preventDefault();
	sendContent(); 
	});
});
