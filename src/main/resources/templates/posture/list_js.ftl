<script src="${rc.contextPath}/dataTables/js/jquery.dataTables.min.js"></script>
<script src="${rc.contextPath}/dataTables/js/dataTables.bootstrap.min.js"></script>
<script src="${rc.contextPath}/colorbox/jquery.colorbox-min.js"></script>

<script>
    function addRecord() {
        showModal({
            title: "添加姿势",
            buttonText: "提交",
            url: "${rc.contextPath}/posture/addOrUpdate.htm",
            buttonFunction: function() {
                confirmAlert("添加姿势", "确认添加？", function () {
                    $.ajax({
                        type:'post',
                        url:'${rc.contextPath}/posture/addOrUpdate.json',
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
                            errorAlert("添加姿势", "请求失败", function () {
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
            title: "编辑姿势",
            buttonText: "提交",
            url: "${rc.contextPath}/posture/addOrUpdate.htm",
            data: {
              id: id
            },
            buttonFunction: function() {
                confirmAlert("编辑姿势", "确认提交？", function () {
                    $.ajax({
                        type:'post',
                        url:'${rc.contextPath}/posture/addOrUpdate.json',
                        data:$("#dataForm").serialize(),
                        cache:false,
                        dataType:'json',
                        success:function(data) {
                            successAlert("编辑姿势", data.msg, function () {
                                closeModal();
                                refreshTable();
                            });
                        },
                        error: function (XMLHttpRequest, textStatus, errorThrown) {
                            errorAlert("编辑姿势", "请求失败", function() {
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
        confirmAlert("删除姿势", "确认删除？", function () {
            $.ajax({
                type:'post',
                url:'${rc.contextPath}/posture/delete.json',
                data:{
                    id: id
                },
                cache:false,
                dataType:'json',
                success:function(data) {
                    successAlert("删除姿势", data.msg, function () {
                        closeModal();
                        refreshTable();
                    });
                },
                error: function (XMLHttpRequest, textStatus, errorThrown) {
                    errorAlert("删除姿势", "请求失败", function () {
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
                "url": "${rc.contextPath}/posture/query.json",
                "data": function(d) {
                    d.name = $('#name').val();
                }
            },
            "columnDefs": [{
                "render": function(data, type, row) {
                    var img = '<a class="green colorbox_img" href="${rc.contextPath}/image' + data + '">' +
                            '<i class="icon-search bigger-130"></i>' +
                            '</a>';
                    return img;
                },
                "targets": 2
            },
            {
                "render": function(data, type, row) {
                    if(data === '0') {
                        data = 'Both';
                    } else if(data === '1') {
                        data = 'LeftArm';
                    } else if(data === '2') {
                        data = 'RightArm';
                    }
                    return data;
                },
                "targets": 3
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
                "targets": 5
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