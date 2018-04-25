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
            text: '训练完成度(%)'
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
            name: '完成度',
            type: 'line',
            showSymbol: false,
            data: []
        }]
    });


    $(document).ready(function() {
        $.get('${rc.contextPath}/user/patientInfoList.json').done(function (data) {
            $.each(data, function(index, element) {
                $("#userId").append('<option value="' + element.id + '">' + element.username + '</option>');
            });
        });
    });


    function loadTrend() {
        var userId = $('#userId').val();
        var trainingType = $('#trainingType').val();
        var trainingTypeName = trainingType === "0" ? "姿势训练" : "动作训练";
        $.ajax({
            type:'post',
            url:'${rc.contextPath}/trainingRecord/trend.json',
            data:{
                userId: userId,
                trainingType: trainingType
            },
            cache:false,
            dataType:'json',
            success:function(result) {
                if(result.success === true) {
                    showTrend(timeUsedTrend, result.data.username + "-" + trainingTypeName + "总用时趋势(秒)", result.data.createTimeList, result.data.timeUsedList);
                    showTrend(completeRateTrend, result.data.username + "-" + trainingTypeName + "完成度(%)", result.data.createTimeList, result.data.completeRateList);
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