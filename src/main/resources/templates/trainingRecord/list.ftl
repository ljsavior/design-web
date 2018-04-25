<div class="row">
    <div class="col-xs-12">
        <h3 class="header smaller lighter blue">训练记录 training_record</h3>

        <button type="button" class="btn btn-sm btn-primary" onclick="viewTrend()">查看趋势图</button>

        <div class="widget-box">
            <div class="widget-header">
                <h4>Query</h4>
            </div>

            <div class="widget-body">
                <div class="widget-main">
                    <form class="form-inline">
                        <select id="patientId">
                            <option value="">全部病患</option>
                            <#if patientList??>
                                <#list patientList as p>
                                    <option value="${p.id}">${p.username}</option>
                                </#list>
                            </#if>
                        </select>

                        <select id="trainingType">
                            <option value="">全部训练</option>
                            <option value="0">姿势训练</option>
                            <option value="1">动作训练</option>
                        </select>

                        <input type="text" id="trainingName" class="input-large" placeholder="训练名称" />

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
                    <th>ID</th>
                    <th>训练者</th>
                    <th>训练名称</th>
                    <th>训练类型</th>
                    <th>用时列表</th>
                    <th>完成状态列表</th>
                    <th>
                        <i class="icon-time bigger-110 hidden-480"></i>
                        训练时间
                    </th>
                    <th>操作</th>
                </tr>
                </thead>
            </table>
        </div>
    </div>
</div>
