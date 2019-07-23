package com.app.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.processor.Processor;
import com.app.reader.Reader;
import com.app.writer.Writer;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	//1. reader processor writer beans
	
	@Bean
	public Reader reader() {
		return new Reader();
	}
	@Bean
	public Processor processor() {
		return new Processor();
	}
	@Bean
	public Writer writer() {
		return new Writer();
	}
	
	//2. StebBuilder Factory
	@Autowired
	private StepBuilderFactory sf;
	
	//3.
	@Bean
	public Step step1() {
		return sf.get("step1").<String,String>chunk(5).reader(reader())
				.processor(processor()).writer(writer()).build();
	}
	
	//4. 
	@Autowired
	private JobBuilderFactory jf;
	
	@Bean
	public Job job() {
		return jf.get("job1").incrementer(new RunIdIncrementer())
				.start(step1())
				.build();
	}
	
}
