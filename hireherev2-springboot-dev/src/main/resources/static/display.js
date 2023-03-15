var stompClient = null;
window.onload = function() {
  connect();
};
function connect() {
    var socket = new SockJS('http://localhost:9090/gs-guide-websocket');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function(frame) {
        console.log('Connected: ' + frame);
        stompClient.send('/app/extractAllRequirements');
        stompClient.subscribe('/message/requirements', function(greeting) {
            console.log("before show greeting call");
            console.log("===========" + greeting.body);
            showGreeting(greeting.body);
        });
        
    function showGreeting(requirements){
    console.log("-----------"+requirements);
   const obj =JSON.parse(requirements);
   for (let i = 0; i < obj.AllRequirements.length; i++)
   $("#greetings").append("JOBID : "+obj.AllRequirements[i].jdId+ "<br>"+"QUALIFICATION : "+obj.AllRequirements[i].qualifications + "<br> " +"DOMAIN : "+ obj.AllRequirements[i].domain + "<br> " +"SKILLSETS : "+obj.AllRequirements[0].skillSets+ "<br> " +
    "EXPERIENECEINYEARS : "+obj.AllRequirements[i].experienceInYears + " <br>" +"POSITIONFOR : "+ obj.AllRequirements[i].positionFor
        + " <br>" +"RESPOSIBILITIES : "+ obj.AllRequirements[i].responsibilites + "<br>" +"ISAPPROVED : "+obj.AllRequirements[i].approved  + "<br>" +"REMARRK : "+obj.AllRequirements[i].remarks )
        
}
    });
}