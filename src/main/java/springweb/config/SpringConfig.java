package springweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "springweb.controller")
public class SpringConfig implements WebMvcConfigurer {

	// @Bean
	// public ViewResolver viewResolver() {
	// InternalResourceViewResolver viewResolver = new
	// InternalResourceViewResolver();
	// viewResolver.setViewClass(JstlView.class);
	// viewResolver.setPrefix("/WEB-INF/JSP/");
	// viewResolver.setSuffix(".jsp");
	//
	// return viewResolver;
	// }

	@Bean
	public TilesConfigurer tilesConfigurer() {
		TilesConfigurer configure = new TilesConfigurer();
		configure.setDefinitions("/WEB-INF/tiles.xml");
		return configure;
	}

	@Bean
	public ViewResolver viewResolver() {
		TilesViewResolver viewResolver = new TilesViewResolver();
		return viewResolver;
	}

}
