package com.montana.configurations;

import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.data.neo4j.config.Neo4jConfiguration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.server.Neo4jServer;
import org.springframework.data.neo4j.server.RemoteServer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by alexto on 10/10/15.
 */

@Configuration
@EnableNeo4jRepositories("com.montana.repositories")
@EnableTransactionManagement
@PropertySource("classpath:neo4j.properties")
public class Neo4j extends Neo4jConfiguration {

    @Autowired
    Environment env;

    @Override
    public Neo4jServer neo4jServer() {
        String host = env.getProperty("neo4j.server");
        return new RemoteServer(host, env.getProperty("neo4j.username"), env.getProperty("neo4j.password"));
    }

    @Override
    public SessionFactory getSessionFactory() {
        return new SessionFactory("com.montana.models");
    }

    @Override
    @Bean
    @Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
    public Session getSession() throws Exception {
        return super.getSession();
    }
}
