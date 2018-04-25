<script src="${rc.contextPath}/dataTables/js/jquery.dataTables.min.js"></script>
<script src="${rc.contextPath}/dataTables/js/dataTables.bootstrap.min.js"></script>
<script src="${rc.contextPath}/colorbox/jquery.colorbox-min.js"></script>

<script>
    function addRecord() {
        showModal({
            title: "添加动作",
            buttonText: "提交",
            url: "${rc.contextPath}/action/addOrUpdate.htm",
            buttonFunction: function() {
                confirmAlert("添加动作", "确认添加？", function () {
                    $.ajax({
                        type:'post',
                        url:'${rc.contextPath}/action/addOrUpdate.json',
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
                            errorAlert("添加动作", "请求失败", function () {
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
            title: "编辑动作",
            buttonText: "提交",
            url: "${rc.contextPath}/action/addOrUpdate.htm",
            data: {
              id: id
            },
            buttonFunction: function() {
                confirmAlert("编辑动作", "确认提交？", function () {
                    $.ajax({
                        type:'post',
                        url:'${rc.contextPath}/action/addOrUpdate.json',
                        data:$("#dataForm").serialize(),
                        cache:false,
                        dataType:'json',
                        success:function(data) {
                            successAlert("编辑动作", data.msg, function () {
                                closeModal();
                                refreshTable();
                            });
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            errorAlert("编辑动作", "请求失败", function() {
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
        confirmAlert("删除动作", "确认删除？", function () {
            $.ajax({
                type:'post',
                url:'${rc.contextPath}/action/delete.json',
                data:{
                    id: id
                },
                cache:false,
                dataType:'json',
                success:function(data) {
                    successAlert("删除动作", data.msg, function () {
                        closeModal();
                        refreshTable();
                    });
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    errorAlert("删除动作", "请求失败", function () {
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
                "url": "${rc.contextPath}/action/query.json",
                "data": function(d) {
                    d.name = $('#name').val();
                }
            },
            "columnDefs": [{
                "render": function(data, type, row) {
                    var editButton = '<a class="green" href="javascript:void(0);" onclick="editRecord(' + row[0] + ')">' +
                            '<i class="icon-pencil bigger-130"></i>' +
                            '</a>';
                    var deleteButton = '<a class="red" href="javascript:void(0);" onclick="deleteRecord(' + row[0] + ')">' +
                            '<i class="icon-trash bigger-130"></i>' +
                            '</a>';
                    return editButton + '&nbsp;&nbsp;&nbsp;&nbsp;' + deleteButton;
                },
                "targets": 3
            }]
        });

        $('.dataTable').css({
            "width":"100%"
        });
        $('.dataTable').parent("div").css({
            "padding":"0px"
        });

        myDataTable.on( 'draw', function () {
            $(".colorbox_img").colorbox({rel:'colorbox_img', maxWidth: '100%', maxHeight: '100%'});
        } );
    });
</script>