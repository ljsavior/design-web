<div class="row">
    <div class="col-xs-12">
        <!-- PAGE CONTENT BEGINS -->
        <form class="form-horizontal" role="form" id="dataForm">
            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 训练名称 </label>

                <div class="col-sm-9">
                    <input type="text" name="trainingname" value="${(item.name)!}" id="name" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 训练类型 </label>

                <div class="col-sm-9">
                    <select id="type" name="type" onchange="typeSelectChanged()">
                        <option value="0" <#if item?? && item.type == 0>selected</#if>>姿势训练</option>
                        <option value="1" <#if item?? && item.type == 1>selected</#if>>动作训练</option>
                    </select>
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 训练姿势/动作 </label>

                <div class="col-sm-9">
                    <select multiple="" class="width-100 chosen-select tag-input-style" id="postures" data-placeholder="选择姿势/动作">
                    </select>
                </div>
            </div>

            <input type="hidden" id="id" name="id" value="${(item.id)!}">
            <input type="hidden" id="originPostures" value="${(item.postures)!}">
        </form>
    </div>
</div>