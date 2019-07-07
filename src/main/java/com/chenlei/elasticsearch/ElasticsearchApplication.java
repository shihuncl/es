package com.chenlei.elasticsearch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.chenlei"})
@MapperScan(basePackages = {"com.chenlei.elasticsearch.mapper"})
@SpringBootConfiguration
@EnableScheduling
@EnableAsync
public class ElasticsearchApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ElasticsearchApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(ElasticsearchApplication.class, args);
	}

}
