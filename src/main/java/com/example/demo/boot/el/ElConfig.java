package com.example.demo.boot.el;

import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;

@Configuration
@ComponentScan
@EnableConfigurationProperties
@PropertySource("classpath:springel.properties")
public class ElConfig {
	@Value("I Love You!")
	private String normal;
	@Value("#{systemProperties['os.name']}")
	private String osName;
	@Value("#{T(java.lang.Math).random()*100.0}")
	private double randomNumber;
	@Value("#{demoService.another}")
	private String another;
	
	@Value("D:/Document/Documents/workspace-sts-3.9.2.RELEASE/springboot1.5demo/src/main/java/com/example/demo/DemoApplication.java")
	private FileSystemResource testFile;
	@Value("http://www.baidu.com")
	private UrlResource testUrl;
	
	@Value("${book.name}")
	private String bookName;
	
	@Autowired
	private Environment environment;
	
	public void outputResource() {
		try {
			System.out.println(normal);
			System.out.println(osName);
			System.out.println(randomNumber);
			System.out.println(another);
			
			System.out.println(IOUtils.toString(testFile.getInputStream(), Charset.defaultCharset()));
			System.out.println(IOUtils.toString(testUrl.getInputStream(), Charset.defaultCharset()));
			System.out.println(bookName);
			System.out.println(environment.getProperty("book.author"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Bean
	@Profile("V1")
	public InnerProfile getInnerProfileV1() {
		return new InnerProfile("V1");
	}
	
	@Bean
	@Profile("V2")
	public InnerProfile getInnerProfileV2() {
		return new InnerProfile("V2");
	}
	
	public class InnerProfile {
		private String version;

		private InnerProfile(String version) {
			super();
			this.version = version;
		}

		public String getVersion() {
			return version;
		}

		public void setVersion(String version) {
			this.version = version;
		}
		
	}
}
