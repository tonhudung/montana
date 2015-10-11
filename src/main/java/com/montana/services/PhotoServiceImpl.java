package com.montana.services;

import com.montana.models.Photo;
import com.montana.repositories.PhotoRepository;
import com.montana.services.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.template.Neo4jOperations;
import org.springframework.data.neo4j.template.Neo4jTemplate;
import org.springframework.stereotype.Service;

@Service
public class PhotoServiceImpl implements PhotoService{

    @Autowired
    PhotoRepository photoRepository;

    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }
}