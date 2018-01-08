package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.Context;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.bean.Person;
@Controller
@SpringBootApplication
public class Demo14Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo14Application.class, args);
	}
	@Component
	public static class myServletContainer implements EmbeddedServletContainerCustomizer{

		@Override
		public void customize(ConfigurableEmbeddedServletContainer container) {
			// TODO Auto-generated method stub
			container.setPort(8888);
		}
		
	}
	
//	public EmbeddedServletContainerFactory servletContainer(){
//		EmbeddedServletContainerFactory tomcat = new EmbeddedServletContainerFactory(){
//
//			@Override
//			public EmbeddedServletContainer getEmbeddedServletContainer(ServletContextInitializer... arg0) {
//				// TODO Auto-generated method stub
//				SecurityConstraint securityConstraint = new SecurityConstraint();
//				securityConstraint.setUserConstraint("CONFIDENTIAL");
//				SecurityCollection collection = new SecurityCollection();
//				collection.addPattern("/*");
//				securityConstraint.addCollection(collection);
//				
//				return null;
//			}
//			
//		}
//	}
	@RequestMapping("/index1")
	public String index(Model model){
		Person s1 = new Person("孙科",11);
		List<Person> listP = new ArrayList<Person>();
		listP.add(new Person("张三",22));
		listP.add(new Person("李四2",23));
		listP.add(new Person("王五1",24));
		model.addAttribute("singlePerson",s1);
		model.addAttribute("persons", listP);
		return "index";
	}
}
