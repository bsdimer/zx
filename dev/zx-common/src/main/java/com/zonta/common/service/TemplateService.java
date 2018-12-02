package com.zonta.common.service;

import com.zonta.common.exception.TemplateEngineException;

import java.util.Map;

/**
 * Created by dimomass on 10.10.18.
 */

public interface TemplateService {
    String merge(String templateName, String lang, Map<String,Object> model) throws TemplateEngineException;
}
