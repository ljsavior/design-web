<script src="${rc.contextPath}/dataTables/js/jquery.dataTables.min.js"></script>
<script src="${rc.contextPath}/dataTables/js/dataTables.bootstrap.min.js"></script>
<script src="${rc.contextPath}/assets/js/chosen.jquery.min.js"></script>

<script>
    var select_id = 'postures';

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
                        data: {
                            name: $('#name').val(),
                            type: $('#type').val(),
                            postures: '[' + getVal(select_id) + ']'
                        },
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
            },
            loadFinishCallback: loadFinishCallbackFunc
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
                        data: {
                            id: $('#id').val(),
                            name: $('#name').val(),
                            type: $('#type').val(),
                            postures: '[' + getVal(select_id) + ']'
                        },
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
            },
            loadFinishCallback: loadFinishCallbackFunc
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

    function setVal(id, vals) {
        var selectItem =  $('#' + id);
        selectItem.val(vals).trigger('chosen:updated');
        var options = selectItem.find('option');
        var ul = $('#' + id + '_chosen').find('ul.chosen-choices');
        var input = ul.children('li.search-field');
        var chosens = ul.children('li.search-choice');
        var map = {};
        chosens.each(function(index,element){
            var idx = $(element).find('a.search-choice-close').attr('data-option-array-index');
            map[$(options[idx]).val()]=element;
        });

        $.each(vals, function(index,value){
            input.before(map[value]);
        });
    }

    function getVal(id) {
        var options = $('#' + id).find('option');
        var ul = $('#' + id + '_chosen').find('ul.chosen-choices');
        var chosens = ul.children('li.search-choice');
        var val = '';
        chosens.each(function(index,element){
            var idx = $(element).find('a.search-choice-close').attr('data-option-array-index');
            val = val + $(options[idx]).val() + ',';
        });
        if(val.length > 0) {
            val = val.substring(0, val.length - 1);
        }
        return val;
    }

    function loadPostureOrActionByType(type, callback) {
        var selectItem =  $('#' + select_id);
        selectItem.val(null).empty().trigger('chosen:updated');
        $.ajax({
            type:'post',
            url:'${rc.contextPath}/training/queryPostureOrActionList.json',
            data:{
                type: type
            },
            cache:false,
            dataType:'json',
            success:function(data) {
                $.each(data, function(index,value){
                    selectItem.append(new Option(value.text, value.val, false, false));
                });
                selectItem.trigger('chosen:updated');
                if(callback !== undefined) {
                    callback();
                }
            }
        });
    }

    function typeSelectChanged() {
        loadPostureOrActionByType($('#type').val());
    }

    function loadFinishCallbackFunc() {
        $('#' + select_id).chosen({
            no_results_text: "没有找到 ",
            search_contains:true,
            allow_single_deselect:true
        });
        $('.chosen-container-multi').css('width', '165px');

        loadPostureOrActionByType($('#type').val(), function() {
            var originPosturesVal = $('#originPostures').val();
            if(originPosturesVal.length > 0) {
                var vals = originPosturesVal.substring(1, originPosturesVal.length - 1).split(',');
                setVal(select_id, vals);
            }
        });
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
                    d.name = $('#trainingName').val();
                    d.type = $('#trainingType').val();
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
                "targets": 5
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