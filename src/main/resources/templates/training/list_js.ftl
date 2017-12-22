<script src="${rc.contextPath}/dataTables/js/jquery.dataTables.min.js"></script>
<script src="${rc.contextPath}/dataTables/js/dataTables.bootstrap.min.js"></script>

<script>
    function addRecord() {
        showModal({
            title: "添加训练",
            buttonText: "提交",
            url: "${rc.contextPath}/training/addOrUpdate.htm",
            buttonFunction: function() {
                confirmAlert("添加训练", "确认添加？", function () {
                    $.ajax({
                        type:'post',
                        url:'${rc.contextPath}/training/addOrUpdate.json',
                        data:$("#dataForm").serialize(),
                        cache:false,
                        dataType:'json',
                        success:function(data) {
                            successAlert("添加", data.msg, function () {
                                closeModal();
                                refreshTable();
                            });

                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            errorAlert("添加训练", "请求失败", function () {
                                closeModal();
                                refreshTable();
                            });
                        }
                    });
                });
            }
        });
    }

    function editRecord(id) {
        showModal({
            title: "编辑训练",
            buttonText: "提交",
            url: "${rc.contextPath}/training/addOrUpdate.htm",
            data: {
              id: id
            },
            buttonFunction: function() {
                confirmAlert("编辑训练", "确认提交？", function () {
                    $.ajax({
                        type:'post',
                        url:'${rc.contextPath}/training/addOrUpdate.json',
                        data:$("#dataForm").serialize(),
                        cache:false,
                        dataType:'json',
                        success:function(data) {
                            successAlert("编辑训练", data.msg, function () {
                                closeModal();
                                refreshTable();
                            });
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            errorAlert("编辑训练", "请求失败", function() {
                                closeModal();
                                refreshTable();
                            });
                        }
                    });
                });
            }
        });
    }

    function deleteRecord(id) {
        confirmAlert("删除训练", "确认删除？", function () {
            $.ajax({
                type:'post',
                url:'${rc.contextPath}/training/delete.json',
                data:{
                    id: id
                },
                cache:false,
                dataType:'json',
                success:function(data) {
                    successAlert("删除训练", data.msg, function () {
                        closeModal();
                        refreshTable();
                    });
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    errorAlert("删除训练", "请求失败", function () {
                        closeModal();
                        refreshTable();
                    });
                }
            });
        })

    }

    $(document).ready(function() {
        myDataTable = $('#sample-table-2').DataTable({
            "ordering": false,
            "searching": false,
            "lengthChange": false,
            "pageLength": 10,
            "processing": true,
            "serverSide": true,
            "ajax": {
                "url": "${rc.contextPath}/training/query.json",
                "data": function(d) {
                    d.name = $('#name').val();
                }
            },
            "columnDefs": [
            {
                "visible": false,
                "targets": [0]
            },
            {
                "render": function(data, type, row) {
                    var editButton = '<a class="green" href="javascript:void(0);" onclick="editRecord(' + row[0] + ')">' +
                            '<i class="icon-pencil bigger-130"></i>' +
                            '</a>';
                    var deleteButton = '<a class="red" href="javascript:void(0);" onclick="deleteRecord(' + row[0] + ')">' +
                            '<i class="icon-trash bigger-130"></i>' +
                            '</a>';
                    return editButton + '&nbsp;&nbsp;&nbsp;&nbsp;' + deleteButton;
                },
                "targets": 4
            }]
        });

        $('.dataTable').css({
            "width":"100%"
        });
        $('.dataTable').parent("div").css({
            "padding":"0px"
        });
    });
</script>