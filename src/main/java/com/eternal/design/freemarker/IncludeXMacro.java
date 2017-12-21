package com.eternal.design.freemarker;

import freemarker.cache.TemplateLoader;
import freemarker.core.Environment;
import freemarker.core._MiscTemplateException;
import freemarker.template.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * Created by yeyang.lj on 2017/10/23.
 */
@Component
public class IncludeXMacro implements TemplateDirectiveModel {
    private static final String PATH_PARAM = "template";
    private static final String DEFALUT_PATH_PARAM = "default_template";

    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels,
                        TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        TemplateLoader templateLoader = environment.getConfiguration().getTemplateLoader();

        String fullTemplatePath = getTemplateParam(map, PATH_PARAM);
        if (templateLoader.findTemplateSource(fullTemplatePath) != null) {
            environment.include(environment.getTemplateForInclusion(fullTemplatePath, null, true));
        } else {
            String defaultFullTemplatePath =getTemplateParam(map, DEFALUT_PATH_PARAM);
            if (templateLoader.findTemplateSource(defaultFullTemplatePath) == null) {
                throw new _MiscTemplateException(environment, "Missing template file path:" + defaultFullTemplatePath);
            }
            environment.include(environment.getTemplateForInclusion(defaultFullTemplatePath, null, true));
        }
    }

    private String getTemplateParam(Map params, String key) throws MalformedTemplateNameException {
        if (!params.containsKey(key)) {
            throw new MalformedTemplateNameException("missing required parameter '" + key, "'");
        }
        return params.get(key).toString();
    }

}
