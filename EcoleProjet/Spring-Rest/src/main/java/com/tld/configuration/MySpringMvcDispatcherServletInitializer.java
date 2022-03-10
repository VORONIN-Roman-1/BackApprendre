package com.tld.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
/** on reprend certaines informations web.xml **/
public class MySpringMvcDispatcherServletInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
// nous n'avons pas de RootConfigs class
        return null;
    }
    // nous avons les getServletConfigClasses
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { DemoAppConfig.class };
    }
    //notre servlet mapping
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}