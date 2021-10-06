package com.example.unimanagement.service;

import com.example.unimanagement.dao.Authority;
import com.example.unimanagement.repo.AuthorityRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorityService {
    private final AuthorityRepository authorityRepository;

    @PersistenceContext
    EntityManager entityManager;

    public AuthorityService(AuthorityRepository authorityRepository){
        this.authorityRepository = authorityRepository;
    }

    public Authority create(Authority authority){
        return authorityRepository.save(authority);
    }

    public Authority findByName(String name){
        return entityManager.find(Authority.class, name);
    }

    public List<Authority> getAllAuthorities(){
        return authorityRepository.findAll();
    }

}
