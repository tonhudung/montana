package com.montana.services;

import com.montana.models.User;
import com.montana.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by alext on 10/10/2015.
 */

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    Neo4jOperations neo4jOperations;

    public UserDetailsServiceImpl() {
    }

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }


}
