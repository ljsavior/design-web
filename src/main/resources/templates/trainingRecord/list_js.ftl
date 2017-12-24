<script src="${rc.contextPath}/dataTables/js/jquery.dataTables.min.js"></script>
<script src="${rc.contextPath}/dataTables/js/dataTables.bootstrap.min.js"></script>

<script>

    $(document).ready(function() {
        myDataTable = $('#sample-table-2').DataTable({
            "ordering": false,
            "searching": false,
            "lengthChange": false,
            "pageLength": 10,
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": "${rc.contextPath}/trainingRecord/query.json",
                "data": function(d) {
                    d.username = $('#username').val();
                    d.trainingName = $('#trainingName').val();
                }
            },
            "columnDefs": [
            {
                "visible": false,
                "targets": [0]
            },
            {
                "render": function(data, type, row) {
                    var showChartButton = '<a class="green" href="${rc.contextPath}/trainingRecord/detailBar.htm?id=' + row[0] + '">' +
                            '<i class="icon-search bigger-130"></i>' +
                            '</a>';
                    return showChartButton;
                },
                "targets": 6
            }]
        });

        $('.dataTable').css({
            "width":"100%"
        });
        $('.dataTable').parent("div").css({
            "padding":"0px"
        });
    });

    function viewTrend() {
        window.location.href = '${rc.contextPath}/trainingRecord/trend.htm';
    }
</script>