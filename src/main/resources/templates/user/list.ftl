<div class="row">
    <div class="col-xs-12">
        <h3 class="header smaller lighter blue">用户 user</h3>

        <button type="button" class="btn btn-sm btn-primary" onclick="addRecord()">添加</button>

        <div class="widget-box">
            <div class="widget-header">
                <h4>Query</h4>
            </div>

            <div class="widget-body">
                <div class="widget-main">
                    <form class="form-inline">
                        <input type="text" id="username" class="input-large" placeholder="用户名" />
                        <button type="button" class="btn btn-info btn-sm" onclick="refreshTable()">
                            查询
                        </button>
                    </form>
                </div>
            </div>
        </div>



        <div class="table-header">
            Result
        </div>

        <div class="table-responsive">
            <table id="sample-table-2" class="table table-striped table-bordered table-hover">
                <thead>
                <tr>
                    <th>id</th>
                    <th>用户名</th>
                    <th>
                        <i class="icon-time bigger-110 hidden-480"></i>
                        创建时间
                    </th>
                    <th>操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
