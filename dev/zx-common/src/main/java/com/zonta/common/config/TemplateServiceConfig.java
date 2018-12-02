package com.zonta.common.config;

import com.zonta.common.service.FreeMakerTemplateService;
import com.zonta.common.service.TemplateService;
import freemarker.template.Configuration;
import org.springframework.context.annotation.Bean;

public abstract class TemplateServiceConfig {

    @Bean
    TemplateService freeMakerTemplateService(Configuration configuration){
        return new FreeMakerTemplateService(configuration);
    }
}
