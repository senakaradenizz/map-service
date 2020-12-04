/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.mapservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mapservice.model.BaseEntity;
import java.io.Serializable;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseRepository<T extends BaseEntity, E extends Serializable> extends JpaRepository<T, Long>,
        JpaSpecificationExecutor<BaseEntity> {
    Optional<T> findById(Long id);
}