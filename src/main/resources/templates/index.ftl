<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8" />
    <title>主页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- basic styles -->

    <link href="${rc.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="${rc.contextPath}/assets/css/font-awesome.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="${rc.contextPath}/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <!-- ace styles -->

    <link rel="stylesheet" href="${rc.contextPath}/assets/css/ace.min.css" />
    <link rel="stylesheet" href="${rc.contextPath}/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="${rc.contextPath}/assets/css/ace-skins.min.css" />

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="${rc.contextPath}/assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->
    <@includeX template="${target_view_name!}_css.ftl" default_template="empty.ftl" />

    <!-- ace settings handler -->

    <script src="${rc.contextPath}/assets/js/ace-extra.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="${rc.contextPath}/assets/js/html5shiv.js"></script>
    <script src="${rc.contextPath}/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    Admin
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="${rc.contextPath}/assets/avatars/user.jpg" alt="Jason's Photo" />
                        <span class="user-info">
                            <small>Welcome,</small>
                            Admin
                        </span>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="icon-cog"></i>
                                Settings
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="icon-user"></i>
                                Profile
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="#">
                                <i class="icon-off"></i>
                                Logout
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
            </script>

            <ul class="nav nav-list" id="menu_bar">
                <li>
                    <a href="${rc.contextPath}/user/list.htm">
                        <i class="icon-dashboard"></i>
                        <span class="menu-text">用户管理</span>
                    </a>
                </li>

                <li>
                    <a href="${rc.contextPath}/posture/list.htm">
                        <i class="icon-dashboard"></i>
                        <span class="menu-text">动作管理</span>
                    </a>
                </li>

                <li>
                    <a href="${rc.contextPath}/training/list.htm">
                        <i class="icon-dashboard"></i>
                        <span class="menu-text">训练管理</span>
                    </a>
                </li>

                <li>
                    <a href="${rc.contextPath}/trainingRecord/list.htm">
                        <i class="icon-dashboard"></i>
                        <span class="menu-text">训练记录管理</span>
                    </a>
                </li>

            </ul><!-- /.nav-list -->

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>

            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
            </script>
        </div>

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">Home</a>
                    </li>

                    <li id="idx_1">
                        <a href="#"></a>
                    </li>
                    <li id="idx_2">
                        <a href="#"></a>
                    </li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <@includeX template="${target_view_name!}.ftl" default_template="empty.ftl" />
                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div><!-- /.main-content -->
    </div><!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>

    <!-- Modal -->
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="modalTitle"></h4>
                </div>
                <div class="modal-body" id="modalBody">



                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" id="modalButton">Submit</button>
                </div>
            </div>
        </div>
    </div>
</div><!-- /.main-container -->

<!-- basic scripts -->


<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='${rc.contextPath}/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='${rc.contextPath}/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='${rc.contextPath}/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="${rc.contextPath}/assets/js/bootstrap.min.js"></script>
<script src="${rc.contextPath}/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->

<!-- ace scripts -->

<script src="${rc.contextPath}/assets/js/ace-elements.min.js"></script>
<script src="${rc.contextPath}/assets/js/ace.min.js"></script>

<script src="${rc.contextPath}/sweetAlert2/sweetalert2.all.js"></script>

<!-- inline scripts related to this page -->
<@includeX template="${target_view_name!}_js.ftl" default_template="empty.ftl" />

<script type="text/javascript">
    $(function () {
        var current_url = window.location.href;
        var target_url = current_url.substring(current_url.indexOf('${rc.contextPath}'), current_url.indexOf('.htm') + 4);
        $('#menu_bar').find('a').each(function() {
            if($(this).attr('href') === target_url) {
                var obj = $(this).parent('li');
                if(obj !== undefined) {
                    obj.addClass('active');
                    var objParent = obj.parents('li');
                    if(objParent !== undefined && objParent.length > 0) {
                        objParent.addClass('active open');
                    }

                    var text1 = '';
                    var text2 = '';
                    if(objParent === undefined || objParent.length === 0) {
                        text1 = $.trim(obj.children('a').children('span.menu-text').text());
                    } else {
                        text2 = $.trim(obj.text());
                        text1 = $.trim(objParent.children('a.dropdown-toggle').children('span.menu-text').text());
                    }

                    $('#idx_1').children('a').text(text1);
                    if(text2 === '') {
                        $('#idx_2').hide();
                    } else {
                        $('#idx_2').children('a').text(text2);
                    }
                }
                return false;
            }
        });
    });

    function showModal(params) {
        var load = false;
        if(params !== undefined) {
            if(params.title !== undefined)
                $('#modalTitle').text(params.title);
            if(params.buttonText !== undefined)
                $('#modalButton').text(params.buttonText);
            if(params.buttonFunction !== undefined)
                $('#modalButton').click(params.buttonFunction);
            if(params.url !== undefined) {
                $('#modalBody').load(params.url, params.data, function(response, status, xhr) {
                    $('#myModal').modal('show');
                });
                load = true;
            }

        }
        if(load === false)
            $('#myModal').modal('show');
    }

    function closeModal() {
        $('#myModal').modal('hide');
    }

    function refreshTable() {
        if(myDataTable !== undefined) {
            myDataTable.draw(true);
        }
    }

    function successAlert(title, msg, callBack) {
        var sw = swal(
            title,
            msg,
            'success'
        );
        if(callBack !== undefined) {
            sw.then(function (result) {
                callBack()
            });
        }
    }

    function errorAlert(title, msg, callBack) {
        swal(
            title,
            msg,
            'error'
        );
        if(callBack !== undefined) {
            sw.then(function (result) {
                callBack()
            });
        }
    }

    function confirmAlert(title, msg, callBack) {
        swal({
            title: title,
            text: msg,
            type: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            confirmButtonText: 'Yes'
        }).then(function (result) {
            if(result.value === true) {
                callBack();
            }
        });
    }
</script>
</body>
</html>