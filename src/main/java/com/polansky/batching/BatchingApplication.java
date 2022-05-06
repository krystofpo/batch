package com.polansky.batching;

import net.ttddyy.dsproxy.listener.ChainListener;
import net.ttddyy.dsproxy.listener.logging.InlineQueryLogEntryCreator;
import net.ttddyy.dsproxy.listener.logging.SLF4JQueryLoggingListener;
import net.ttddyy.dsproxy.support.ProxyDataSourceBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@EnableTransactionManagement
@SpringBootApplication
public class BatchingApplication {


	public static void main(String[] args) {
		SpringApplication.run(BatchingApplication.class, args);
	}


	@Bean
	public DataSource dataSource() {
		ChainListener listener = new ChainListener();
		SLF4JQueryLoggingListener loggingListener = new SLF4JQueryLoggingListener();
		loggingListener.setQueryLogEntryCreator(new InlineQueryLogEntryCreator());
		listener.addListener(loggingListener);


		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:oracle:thin:@localhost:1521/xe");
		dataSource.setUsername("xxx");
		dataSource.setPassword("xxx");


		return ProxyDataSourceBuilder
				.create(dataSource)
				.name(getClass().getName())
				.listener(listener)
				.build();

	}
}
