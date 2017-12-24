<script src="${rc.contextPath}/echarts/echarts.common.min.js"></script>

<script>

    $(document).ready(function() {
        var id = ${id};

        var timesUsedBar = echarts.init(document.getElementById('timesUsedBar'));
        timesUsedBar.setOption({
            title: {
                text: '各动作用时(秒)'
            },
            tooltip: {
                formatter: '{a0}:{c0}秒'
            },
            legend: {
                data:['用时']
            },
            xAxis: {
                data: []
            },
            yAxis: {},
            series: [{
                name: '用时',
                type: 'bar',
                data: []
            }]
        });

        var resultBar = echarts.init(document.getElementById('resultBar'));
        resultBar.setOption({
            title: {
                text: '各动作完成情况'
            },
            tooltip: {},
            legend: {
                data:['完成情况(1-完成，0-未完成)']
            },
            xAxis: {
                data: []
            },
            yAxis: {
                data: [1]
            },
            series: [{
                name: '完成情况(1-完成，0-未完成)',
                type: 'bar',
                data: []
            }]
        });


        $.ajax({
            type:'post',
            url:'${rc.contextPath}/trainingRecord/timesUsedBar.json',
            data:{
                id: id
            },
            cache:false,
            dataType:'json',
            success:function(result) {
                if(result.success === true) {
                    var title = '各动作用时(S)-' + result.data.username + '-' + result.data.trainingName;
                    showTimeUsedBar(timesUsedBar, title, result.data.xAxis, result.data.series);
                }

            }
        });

        $.ajax({
            type:'post',
            url:'${rc.contextPath}/trainingRecord/resultBar.json',
            data:{
                id: id
            },
            cache:false,
            dataType:'json',
            success:function(result) {
                if(result.success === true) {
                    var title = '各动作完成情况-' + result.data.username + '-' + result.data.trainingName;
                    showTimeUsedBar(resultBar, title, result.data.xAxis, result.data.series);
                }

            }
        });

    });

    function showTimeUsedBar(chart, title, xAxis, series)
    {
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