<div class="row">
    <div class="col-xs-12">
        <h3 class="header smaller lighter blue">命令 Command</h3>

        <button type="button" class="btn btn-sm btn-primary" onclick="addRecord()">添加</button>

        <div class="widget-box">
            <div class="widget-header">
                <h4>Query</h4>
            </div>

            <div class="widget-body">
                <div class="widget-main">
                    <form class="form-inline">
                        <input type="text" id="commandFunction" class="input-large" placeholder="命令类型" />
                        <input type="text" id="description" class="input-large" placeholder="命令描述" />
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
                    <th>命令类型</th>
                    <th>命令描述</th>
                    <th>返回值描述</th>
                    <th>
                        <i class="icon-time bigger-110 hidden-480"></i>
                        创建时间
                    </th>
                    <th>
                        <i class="icon-time bigger-110 hidden-480"></i>
                        上次修改时间
                    </th>
                    <th>修改人编号</th>
                    <th>备注</th>
                    <th>操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
