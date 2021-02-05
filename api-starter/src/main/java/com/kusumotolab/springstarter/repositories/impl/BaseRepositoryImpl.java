package com.kusumotolab.springstarter.repositories.impl;

import com.kusumotolab.springstarter.repositories.BaseRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class BaseRepositoryImpl implements BaseRepository {
    @PersistenceContext
    private EntityManager em;
}
