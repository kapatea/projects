package com.orileo.edairy.authservice;
import java.security.Principal;

/**
 * @author H Kapil Kumar
 *
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@Controller
public class AuthserviceApplication
{
	@RequestMapping("/logged-info")
	@ResponseBody
	public Principal employee(Principal user) {
		return user;
	}
	
	@GetMapping(value="/open/public", produces = MediaType.APPLICATION_JSON_VALUE)
	private String message(){
		System.out.println("Employee Get Call");
		return "I'm open to all";
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AuthserviceApplication.class, args);
	}
	
	@Configuration
	public class CORS extends WebMvcConfigurerAdapter{
	    @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }
	    
	}
}

