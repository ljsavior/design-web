<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form class="form-horizontal" role="form" id="dataForm">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 动作名称 </label>

                <div class="col-sm-9">
                    <input type="text" name="name" value="${(item.name)!}" id="name" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 数据文件 </label>

                <div class="col-sm-9">
                    <input type="text" name="dataFile" value="${(item.dataFile)!}" id="dataFile" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 备注 </label>

                <div class="col-sm-9">
                    <textarea name="mark" id="mark">${(item.mark)!}</textarea>
                </div>
            </div>


            <input type="hidden" name="id" value="${(item.id)!}">
        </form>
    </div>
</div>