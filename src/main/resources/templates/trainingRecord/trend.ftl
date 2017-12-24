<div class="row">
    <div class="col-xs-12">
        <h3 class="header smaller lighter blue">训练记录趋势图</h3>

        <div class="widget-box">
            <div class="widget-header">
                <h4>Query</h4>
            </div>

            <div class="widget-body">
                <div class="widget-main">
                    <form class="form-inline">
                        <select class="input-large" id="username">
                        </select>
                        <button type="button" class="btn btn-info btn-sm" onclick="loadTrend()">
                            查询
                        </button>
                    </form>
                </div>
            </div>
        </div>


        <div id="timeUsedTrend" style="width: 800px;height:400px;"></div>
        <div id="completeRateTrend" style="width: 800px;height:400px;"></div>
    </div>
</div>
