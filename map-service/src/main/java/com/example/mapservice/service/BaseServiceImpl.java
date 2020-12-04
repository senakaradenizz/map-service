/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import com.example.mapservice.repository.BaseRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;
import com.example.mapservice.model.BaseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Component
@SuppressWarnings("unchecked")
@Transactional(rollbackFor = Exception.class)
public abstract class BaseServiceImpl implements BaseService<BaseEntity, Long> {
    protected final BaseRepository baseRepository;
    BaseServiceImpl(BaseRepository repository) {
        this.baseRepository = repository;
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Page<BaseEntity> getAll(PageRequest request) {
        return this.baseRepository.findAll(request);
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public List<BaseEntity> getAll() {
        return this.baseRepository.findAll();
    }
    @Override
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Optional<BaseEntity> get(Long id) {
        return this.baseRepository.findById(id);
    }
    @Override
    public Object add(BaseEntity entity) {
        return this.baseRepository.save(entity);
    }
    public Object addAll(List<BaseEntity> entity) {
        return this.baseRepository.saveAll(entity);
    }
    @Override
    public Object update(BaseEntity entity) {
        return this.baseRepository.save(entity);
    }
    @Override
    public void remove(BaseEntity entity) {
        this.baseRepository.delete(entity);
    }
    public void deleteById(Long entityId) {
        this.baseRepository.deleteById(entityId);
    }
    @Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
    public Integer getCount() {
        return Math.toIntExact(this.baseRepository.count());
    }
}