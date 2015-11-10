package com.montana.services;

import com.montana.models.nodes.Photo;
import com.montana.repositories.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class PhotoServiceImpl implements PhotoService {

    @Autowired
    private PhotoRepository photoRepository;

    public Photo save(Photo photo) {
        return photoRepository.save(photo);
    }
}