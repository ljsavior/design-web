<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form class="form-horizontal" role="form" id="dataForm">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 命令类型 </label>

                <div class="col-sm-9">
                    <input type="text" name="commandFunction" value="${(command.commandFunction)!}" id="commandFunction" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 命令描述 </label>

                <div class="col-sm-9">
                    <input type="text" name="commandDescription" value="${(command.commandDescription)!}" id="commandDescription" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 返回值描述 </label>

                <div class="col-sm-9">
                    <input type="text" name="returnDataDescription" value="${(command.returnDataDescription)!}" id="returnDataDescription" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 修改人编号 </label>

                <div class="col-sm-9">
                    <input type="text" name="modUserId" value="${(command.modUserId)!}" id="modUserId" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 备注 </label>

                <div class="col-sm-9">
                    <input type="text" name="remarks" value="${(command.remarks)!}" id="remarks" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <input type="hidden" name="id" value="${(command.id)!}">
        </form>
    </div>
</div>