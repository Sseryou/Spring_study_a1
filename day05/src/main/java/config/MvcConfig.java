package config;

import commons.CommonLibrary;
import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.*;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import java.util.Locale;
import java.util.ResourceBundle;

@Import(DbConfig.class)//Dbconfig에서 설정을 받아옴.
@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer { /*WebMvcConfigurer 꼭 기억하기. MVC설정을 대신 해준다..*/

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
        templateResolver.setApplicationContext(applicationContext);
        templateResolver.setPrefix("/WEB-INF/view/");
        templateResolver.setSuffix(".html");
        templateResolver.setCacheable(false);
        return templateResolver;
    }

    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine templateEngine = new SpringTemplateEngine();
        templateEngine.setTemplateResolver(templateResolver());
        templateEngine.setEnableSpringELCompiler(true);
        /*확장 기능, temporals 추가, java.time 패키지.*/
        templateEngine.addDialect(new Java8TimeDialect());
        templateEngine.addDialect(new LayoutDialect());
        return templateEngine;
    }

    @Bean
    public ThymeleafViewResolver thymeleafViewResolver() {
        ThymeleafViewResolver resolver = new ThymeleafViewResolver();
        resolver.setContentType("text/html");
        resolver.setCharacterEncoding("utf-8");
        resolver.setTemplateEngine(templateEngine());
        return resolver;
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.viewResolver(thymeleafViewResolver());
    }

    /* 메세지 출력을 위한 소스 */
    @Bean
    public MessageSource messageSource(){
        ResourceBundleMessageSource ms = new ResourceBundleMessageSource();
        ms.setBasenames("messages.commons");
        ms.setDefaultEncoding("UTF-8");
        //메세지를 불러올때, 어떤 국가의 메세지 세팅이 기본 세팅인가를 결정
        //ms.setDefaultLocale(Locale.KOREAN);
        return ms;
    }

    @Bean
    public CommonLibrary cLib(){
        return new CommonLibrary();
    }

    /* 컨트롤러 없이 바로 url과 템플릿 연결  */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        /* 메인으로 연결 시, 바로 main/index로 보냄 */
        /* view만 가지고도 기능 활성화 */

        registry.addViewController("/mypage")
                .setViewName("mypage/index");


    }

    /* 정적인 경로 설정. */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /* 이 경로를 포함한 모든 파일 */
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/");
        /* 대분류(classpath)인 java, resource.. 중
        static을 찾아서 그 안에 있는 파일을 사용할것임을 명시 */
    }
}
