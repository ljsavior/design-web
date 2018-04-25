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

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 角色 </label>

                <div class="col-sm-9">
                    <select id="type" name="role">
                        <option value="0" <#if item?? && item.role == 0>selected</#if>>管理员</option>
                        <option value="1" <#if item?? && item.role == 1>selected</#if>>康复教练</option>
                        <option value="2" <#if item?? && item.role == 2>selected</#if>>病患</option>
                    </select>
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 性别 </label>

                <div class="col-sm-9">
                    <select id="sex" name="sex">
                        <option value="0" <#if item?? && item.sex == 0>selected</#if>>男</option>
                        <option value="1" <#if item?? && item.sex == 1>selected</#if>>女</option>
                    </select>
                </div>
            </div>


            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 姓名 </label>

                <div class="col-sm-9">
                    <input type="text" name="name" value="${(item.name)!}" id="name" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 出生日期 </label>

                <div class="col-sm-9">
                    <input type="text" name="birthday" value="${(item.birthday)!}" id="birthday" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 手机 </label>

                <div class="col-sm-9">
                    <input type="text" name="mobile_phone" value="${(item.mobile_phone)!}" id="mobile_phone" class="col-xs-10 col-sm-5" />
                </div>
            </div>

            <div class="space-4"></div>

            <div class="form-group">
                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 备注 </label>

                <div class="col-sm-9">
                    <textarea name="mark" id="mark">${(item.mark)!}</textarea>
                </div>
            </div>

            <#if item?? && item.role == 2>
                <div class="space-4"></div>

                <div class="form-group">
                    <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 教练 </label>

                    <div class="col-sm-9">
                        <select id="coachId" name="coachId">
                            <#list coachList as c>
                                <option value="${c.id}" <#if coachId?? && c.id == coachId>selected</#if>>${c.name}</option>
                            </#list>
                        </select>
                    </div>
                </div>
            </#if>


            <input type="hidden" name="id" value="${(item.id)!}">
        </form>
    </div>
</div>