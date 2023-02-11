package pl.coderslab.jeespringmvcalj02;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan("pl.coderslab")
@EnableWebMvc
public class AppConfig implements WebMvcConfigurer {
}
