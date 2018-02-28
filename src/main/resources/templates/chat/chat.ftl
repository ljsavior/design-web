<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8" />
    <title>主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="stylesheet" href="${rc.contextPath}/chat/style.css" />

    <script src="${rc.contextPath}/chat/sockjs.min.js"></script>
    <script src="${rc.contextPath}/chat/stomp.js"></script>
    <script src="${rc.contextPath}/assets/js/jquery-2.0.3.min.js"></script>

</head>

<body>
    <div id="convo">
        <ul class="chat-thread">
        </ul>

        <form id="messageForm" class="chat-window">
            <input id="msg" class="chat-window-message" name="chat-window-message" type="text" autocomplete="off" autofocus="autofocus"/>
        </form>
    </div>

    <input id="from" type="hidden" value="${from}" />
    <input id="to" type="hidden" value="${to}" />

    <script th:inline="javascript">
        var stompClient = null;
        var from = $('#from').val();
        var to = $('#to').val();

        function connect() {
            var socket = new SockJS('/web-chat');
            stompClient = Stomp.over(socket);
            stompClient.connect({user: from}, function (frame) {
                console.log('Connected: ' + frame);
                stompClient.subscribe('/user/topic/chat', function (msg) {
                    showMsg(msg.body);
                });
            });
        }

        function disconnect() {
            if (stompClient != null) {
                stompClient.disconnect();
            }
            console.log("Disconnected");
        }

        function sendMsg() {
            var msg = $('#msg').val();
            $(".chat-thread").append('<li class="self">' + msg + '</li>');
            stompClient.send("/app/chat/msg", {}, JSON.stringify({
                'from': from,
                'to': to,
                'msg': msg
            }));
            $('#msg').val('');
        }

        function showMsg(message) {
            $(".chat-thread").append('<li class="other">' + JSON.parse(message).msg + '</li>');
        }


        $(function () {
            $("#messageForm").on('submit', function (e) {
                e.preventDefault();
                sendMsg();
            });
            connect();
        });
    </script>
</body>
</html>