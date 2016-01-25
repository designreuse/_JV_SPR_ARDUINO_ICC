<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--bootstrap css--%>
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

    <%--jquery --%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>

    <%--bootstrap js--%>
    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</head>
<body>

<script type="text/javascript">

    // root
    ICC = {};

    //base URL
    ICC.url = "http://localhost:8080";//local
    //ICC.url = "http://172.20.10.2:8080";//Mobile
    //ICC.url = "http://192.168.2.233:8080";//local

    // request types
    ICC.request = new Object();

    // data types
    ICC.dataType = new Object();

    // content types
    ICC.contentType = new Object();

    ICC.request.get = 'GET';
    ICC.request.post = 'POST';
    ICC.request.put = 'PUT';
    ICC.request.del = 'DELETE';

    ICC.dataType.json = 'json';
    ICC.dataType.xml = 'xml';

    ICC.contentType.json = 'application/json; charset=utf-8';

    ICC.ajax = {
        get: function (url, data, done, fail) {
            $.ajax({
                url: url,
                type: ICC.request.get,
                data: data,
                dataType: ICC.dataType.json,
                success: done,
                error: fail
            });
        },
        post: function (url, data, success, error) {
            $.ajax({
                type: ICC.request.post,
                url: ICC.url + url,
                cache: false,
                dataType: ICC.dataType.json,
                data: JSON.stringify(data),
                contentType: ICC.contentType.json
            }).done(success).fail(error);
        },
        put: function (url, data, success, error) {
            var k = '_method', v = 'PUT';
            var headers = {};
            headers[k] = v;
            $.ajax({
                type: ICC.request.put,
                url: url,
                cache: false,
                headers: headers,
                dataType: ICC.dataType.json,
                data: JSON.stringify(data),
                contentType: ICC.contentType.json
            }).done(success).fail(error);

        },
        del: function (url, success, error) {
            var k = '_method', v = 'DELETE';
            var headers = {};
            headers[k] = v;
            $.ajax({
                type: ICC.request.del,
                url: url,
                cache: false,
                headers: headers,
                dataType: ICC.dataType.json,
                contentType: ICC.contentType.json
            }).done(success).fail(error);
        },
    };

</script>

<script>

    $(document).ready(function () {

        var climateStartBtn = $("#climateStartBtn");
        var climateStopBtn = $("#climateStopBtn");
        var systemDownBtn = $("#systemDownBtn");

        var successContainer = $(".alert-success");
        var errorContainer = $(".alert-error");
        var infoContainer = $(".alert-info");
        var warningContainer = $(".alert-warning");

        var successMsg = $(".alert-success .msg");
        var errorMsg = $(".alert-error .msg");
        var infoMsg = $(".alert-info .msg");
        var warningMsg = $(".alert-warning .msg");

        function hideAllMessages() {
            successContainer.addClass("hide");
            errorContainer.addClass("hide");
            infoContainer.addClass("hide");
            warningContainer.addClass("hide");
        }

        //Start Climate
        climateStartBtn.on("click", function () {

            var postData = {startDate: 123456, endDate: 87654};

            ICC.ajax.post("/climate/start", postData, function (res, status, xhr) {

                hideAllMessages();//hide all messages alerts

                if (res.status == "200" && xhr.status == "200") {

                    successContainer.removeClass("hide");
                    successMsg.html("Klima Çalıştırıldı.")

                } else {

                    errorContainer.removeClass("hide");
                    errorMsg.html("Bir hata oluştu ve klima çalıştırılamadı!")

                }

            }, function (err) {
                errorMsg.html("Klima calistirilamadi!");
                errorContainer.removeClass("hide");
            });//API Call finish

        });//click finish

    });

</script>
<div class="container">


    <ol class="breadcrumb">
        <li><a href="#">Inteligent Climate Control</a></li>
    </ol>

    <div class="container">
        <div class="alert alert-success hide">
            <strong>Basarili!</strong> <span class="msg">  </span>
        </div>

        <div class="alert alert-info hide">
            <strong>Bilgi!</strong> <span class="msg">  </span>
        </div>

        <div class="alert alert-warning hide">
            <strong>Uyari!</strong> <span class="msg">  </span>
        </div>

        <div class="alert alert-danger hide">
            <strong>Dikkat!</strong> <span class="msg">  </span>
        </div>
    </div>

    <h2>${message}</h2>

    <div class="panel-group" id="accordion">
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse1">Mod Ayarlari</a>
                </h4>
            </div>
            <div id="collapse1" class="panel-collapse collapse in">
                <div class="panel-body">

                    Mod ayarlari icerigi
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse2">Nem/Sıcaklık/Hareket</a>
                </h4>
            </div>
            <div id="collapse2" class="panel-collapse collapse">
                <div class="panel-body">
                    Sıcaklıkk nem ayarları
                </div>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading">
                <h4 class="panel-title">
                    <a data-toggle="collapse" data-parent="#accordion" href="#collapse3">Manuel islemler</a>
                </h4>
            </div>
            <div id="collapse3" class="panel-collapse collapse">
                <div class="panel-body">

                    <div class="container">
                        <button type="button" class="btn btn-primary" id="climateStartBtn">Klimayi Ac</button>
                        <button type="button" class="btn btn-warning" id="climateStopBtn">Klimayi Kapat</button>
                        <button type="button" class="btn btn-danger" id="systemDownBtn">Sistemi Kapat</button>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
