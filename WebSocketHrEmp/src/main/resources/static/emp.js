var stompClient = null;
var today = new Date();
var time = today.getHours() + ":" + today.getMinutes();
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

function connect(id) {
	
	var socket = new SockJS('/Config-websocket');
	stompClient = Stomp.over(socket);
	stompClient.connect({}, function(frame) {
		setConnected(true);
		console.log('Connected: ' + frame);
		stompClient.subscribe('/topic/details/'+id, function(details) {
			showGreeting(JSON.parse(details.body));
		});
		/*stompClient.subscribe('/topic/details/', function(greeting) {
			showGreeting(greeting.body);
		});*/
				
	});
}

function disconnect() {
	if (stompClient !== null) {
		stompClient.disconnect();
	}
	setConnected(false);
	console.log("Disconnected");
}

function sendName() {
	console.log("bvhg=cfhgjh=====================")
	
	stompClient.send("/app/sendMessage", {}, 
	JSON.stringify({ 'senderId': $("#senderId").val(), 'receiverId': $("#receiverId").val(),'content': $("#content").val() }));
	$("#greetings").append('<div style="text-align: right;margin-left:10rem">'+ $("#content").val() + ":"+$("#receiverId").val()+'&nbsp' + time + "</div>");
	console.log("=====================")
}

function showGreeting(message) {
	var today = new Date();
  var time = today.getHours() + ":" + today.getMinutes();

$("#greetings").append("<tr><td style='color:red'>" + message.content + ":"+  message.senderId +'&nbsp' + time+ "</td></tr>");
/*$("#greetings").append("<tr><td>" + message.senderId + "</td></tr>" );*/

}

$(function() {
	$("form").on('submit', function(e) {
		document.getElementById("content").value='';
		document.getElementById("receiverId").value='';
		e.preventDefault();
	});
	
	$("#senderId").change(function() { connect($("#senderId").val()); });
	
	$("#disconnect").click(function() { disconnect(); });
	$("#send").click(function() { sendName(); });
	
});
