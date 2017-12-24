<script src="${rc.contextPath}/echarts/echarts.common.min.js"></script>

<script>
    var timeUsedTrend = echarts.init(document.getElementById('timeUsedTrend'));
    timeUsedTrend.setOption({
        title: [{
            left: 'center',
            text: '训练总用时趋势(秒)'
        }],
        tooltip: {
            trigger: 'axis',
            formatter: '{a0}:{c0}秒'
        },
        xAxis: [{
            data: []
        }],
        yAxis: [{
            splitLine: {show: true}
        }],
        series: [{
            name: '总用时',
            type: 'line',
            showSymbol: false,
            data: []
        }]
    });

    var completeRateTrend = echarts.init(document.getElementById('completeRateTrend'));
    completeRateTrend.setOption({
        title: [{
            left: 'center',
            text: '训练动作完成度(%)'
        }],
        tooltip: {
            trigger: 'axis',
            formatter: '{a0}:{c0}%'
        },
        xAxis: [{
            data: []
        }],
        yAxis: [{
            splitLine: {show: true}
        }],
        series: [{
            name: '动作完成度',
            type: 'line',
            showSymbol: false,
            data: []
        }]
    });


    $(document).ready(function() {
        $.get('${rc.contextPath}/user/usernameList.json').done(function (data) {
            $('#username').empty();
            $.each(data, function(index, element) {
                $("#username").append('<option value="' + element + '">' + element + '</option>');
            });
        });
    });


    function loadTrend() {
        var username = $('#username').val();
        $.ajax({
            type:'post',
            url:'${rc.contextPath}/trainingRecord/trend.json',
            data:{
                username: username
            },
            cache:false,
            dataType:'json',
            success:function(result) {
                if(result.success === true) {
                    showTrend(timeUsedTrend, username + "-训练总用时趋势(秒)", result.data.createTimeList, result.data.timeUsedList);
                    showTrend(completeRateTrend, username + "-训练动作完成度(%)", result.data.createTimeList, result.data.completeRateList);
                }
            }
        });
    }

    function showTrend(chart, title, xAxis, series) {
        chart.setOption({
            title: {
                text: title
            },
            xAxis: {
                data: xAxis
            },
            series: [{
                data: series
            }]
        });
    }

</script>