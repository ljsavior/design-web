<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form class="form-horizontal" role="form" id="dataForm">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 用户名 </label>

                <div class="col-sm-9">
                    <input type="text" name="username" value="${(item.username)!}" id="username" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 密码 </label>

                <div class="col-sm-9">
                    <input type="text" name="password" value="${(item.password)!}" id="password" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <input type="hidden" name="id" value="${(item.id)!}">
        </form>
    </div>
</div>