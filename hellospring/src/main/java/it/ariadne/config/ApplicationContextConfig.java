package it.ariadne.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import it.ariadne.dao.MessageCollectionRepository;
import it.ariadne.dao.MessageRepository;
import it.ariadne.model.English;
import it.ariadne.model.Language;

@Configuration
@ComponentScan("it.ariadne.*") 
public class ApplicationContextConfig { 
  
	@Bean(name ="language")
    public Language getLanguage() { 
        return new English();
    }
 
    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/pages/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
  
    @Bean(name ="messageRepository")
    public MessageRepository getMessageRepository() { 
        return new MessageCollectionRepository();
    }
 
}
