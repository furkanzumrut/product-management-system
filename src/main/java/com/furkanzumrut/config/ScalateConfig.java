
package com.furkanzumrut.config;

import org.fusesource.scalate.layout.DefaultLayoutStrategy;
import org.fusesource.scalate.layout.LayoutStrategy;
import org.fusesource.scalate.servlet.Config;
import org.fusesource.scalate.servlet.ServletTemplateEngine;
import org.fusesource.scalate.spring.view.ScalateViewResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.context.ServletContextAware;
import scala.collection.JavaConversions;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * The scalate configuration. Initializes the template path, default extension and
 * layouts.
 * 
 * @author cnagel
 */
@Configuration
public class ScalateConfig {

	/**
	 * The template path
	 */
	public static final String DEFAULT_PREFIX = "/WEB-INF/templates/";

	/**
	 * The template extension
	 */
	public static final String DEFAULT_SUFFIX = ".ssp";

	/**
	 * The default layout to use
	 */
	public static final String DEFAULT_LAYOUT = "/WEB-INF/templates/layouts/default.ssp";

	/**
	 * The scalate dummy config configuration. Needs the servlet context.
	 * 
	 * @author cnagel
	 */
	@Configuration
	protected static class ScalateConfigConfiguration implements ServletContextAware {

		private ServletContext servletContext;

		@Override
		public void setServletContext(ServletContext servletContext) {
			this.servletContext = servletContext;
		}

		@Bean
		public Config config() {
			return new Config() {

				@Override
				public ServletContext getServletContext() {
					return servletContext;
				}

				@Override
				public String getName() {
					return "unknown";
				}

				@Override
				public Enumeration<?> getInitParameterNames() {
					return null;
				}

				@Override
				public String getInitParameter(String name) {
					return null;
				}
			};
		}

	}

	/**
	 * The scalate servlet template engine configuration, initializing the default layout.
	 * 
	 * @author cnagel
	 */
	@Configuration
	protected static class ScalateServletTemplateEngineConfiguration {

		@Autowired
		private Config config;

		@Bean
		public ServletTemplateEngine servletTemplateEngine() {
			ServletTemplateEngine engine = new ServletTemplateEngine(config);
			engine.layoutStrategy_$eq(getLayoutStrategy(engine));
			return engine;
		}

		private LayoutStrategy getLayoutStrategy(ServletTemplateEngine engine) {
			List<String> layouts = new ArrayList<String>(1);
			layouts.add(DEFAULT_LAYOUT);
			return new DefaultLayoutStrategy(engine,
					JavaConversions.asScalaBuffer(layouts));
		}

	}

	/**
	 * The scalate view resolver configuration, initializing the template path and
	 * extension.
	 * 
	 * @author cnagel
	 */
	@Configuration
	protected static class ScalateViewResolverConfiguration {

		@Autowired
		private ServletTemplateEngine servletTemplateEngine;

		@Bean
		public ScalateViewResolver scalateViewResolver() {
			ScalateViewResolver resolver = new ScalateViewResolver();
			resolver.templateEngine_$eq(servletTemplateEngine);
			resolver.setOrder(Ordered.LOWEST_PRECEDENCE - 20);
			resolver.setPrefix(DEFAULT_PREFIX);
			resolver.setSuffix(DEFAULT_SUFFIX);
			return resolver;
		}

	}

}
