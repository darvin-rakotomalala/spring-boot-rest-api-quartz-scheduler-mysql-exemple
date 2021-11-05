package com.poc.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

import java.text.MessageFormat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.poc.service.repository")
public class MongoConfig extends AbstractMongoClientConfiguration {

	@Value("${mongodb.poc.host}")
	private String mongoHost;

	@Value("${mongodb.poc.port}")
	private String mongoPort;

	@Value("${mongodb.poc.dbname}")
	private String mongoDbname;

	@Value("${mongodb.poc.admin}")
	private String dbAdmin;

	@Value("${mongodb.poc.username}")
	private String userName;

	@Value("${mongodb.poc.password}")
	private String password;

	@Bean
	public MongoClient mongoClient() {

		String mongoURI = MessageFormat.format("mongodb://{0}:{1}/{2}", mongoHost, mongoPort, dbAdmin);
		return MongoClients.create(mongoURI);
	}

	@Override
	protected String getDatabaseName() {
		return mongoDbname;
	}

	@Primary
	@Bean
	public MongoDatabaseFactory mongoDbFactory() {
		return super.mongoDbFactory();
	}

	@Primary
	@Bean
	public MappingMongoConverter mongoConverter(MongoDatabaseFactory mongoFactory,
			MongoMappingContext mongoMappingContext) throws Exception {
		DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoFactory);
		MappingMongoConverter mongoConverter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);
		mongoConverter.setMapKeyDotReplacement("-DOT-");

		return mongoConverter;
	}

	@Override
	protected boolean autoIndexCreation() {
		return true;
	}

}