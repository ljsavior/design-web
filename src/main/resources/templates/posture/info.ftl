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
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 动作图片 </label>

                <div class="col-sm-9">
                    <input type="text" name="picPath" value="${(item.picPath)!}" id="picPath" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 动作数据 </label>

                <div class="col-sm-9">
                    <textarea name="data" id="data">${(item.data)!}</textarea>
                    <#--<input type="text" name="data" value="${(item.data)!}" id="data" class="col-xs-10 col-sm-5" />-->
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 动作类型 </label>

                <div class="col-sm-9">
                    <select id="type" name="type">
                        <option value="0">Both</option>
                        <option value="1">LeftArm</option>
                        <option value="2">RightArm</option>
                    </select>
                </div>
            </div>

            <input type="hidden" name="id" value="${(item.id)!}">
        </form>
    </div>
</div>