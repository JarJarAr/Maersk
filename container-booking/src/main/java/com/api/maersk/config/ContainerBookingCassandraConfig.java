package com.api.maersk.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableReactiveCassandraRepositories;

@Configuration
@EnableReactiveCassandraRepositories
public class ContainerBookingCassandraConfig extends AbstractCassandraConfiguration{
	
	@Value("${spring.cassandra.keyspace-name}")
	private String keySpace;
	@Override
	protected String getKeyspaceName() {
		return keySpace;
	}

}
