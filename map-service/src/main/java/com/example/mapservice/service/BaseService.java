/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import com.example.mapservice.model.BaseEntity;


public interface BaseService<E extends BaseEntity, K> {
    Page<BaseEntity> getAll(PageRequest request);
    List<BaseEntity> getAll();
    Optional<E> get(K id);
    Object add(E entity);
    Object update(E entity);
    void remove(E entity);
}