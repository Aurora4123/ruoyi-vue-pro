package cn.iocoder.yudao.module.cms.framework.web.config;

import cn.iocoder.yudao.framework.swagger.config.YudaoSwaggerAutoConfiguration;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class CmsWebConfiguration {
    @Bean
    public GroupedOpenApi buildCmsApi(){
        return YudaoSwaggerAutoConfiguration.buildGroupedOpenApi("cms");
    }
}
