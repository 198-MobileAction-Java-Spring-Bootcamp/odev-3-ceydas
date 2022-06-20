package com.ceydog.hw3ceydas.gen.service;

import com.ceydog.hw3ceydas.gen.entity.BaseEntity;
import com.ceydog.hw3ceydas.gen.enums.GenErrorMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public abstract class BaseEntityService<E extends BaseEntity, D extends JpaRepository<E,Long>> {

    private static final Integer DEFAULT_PAGE = 0;
    private static final Integer DEFAULT_SIZE = 10;

    private final D dao;

    public List<E> findAll(){
        return dao.findAll();
    }


    public Optional<E> findById(Long id){
        return dao.findById(id);
    }

    public E findByIdWithControl(Long id){

        Optional<E> optionalEntity = dao.findById(id);

        E entity;
        if (optionalEntity.isPresent()){
            entity = optionalEntity.get();
        } else {
            throw new RuntimeException(GenErrorMessage.ITEM_NOT_FOUND.getMessage());
        }

        return entity;
    }

    public E save(E entity){

        return dao.save(entity);
    }


    public void delete(E e){
        dao.delete(e);
    }

    public boolean existsById(Long id){
        return dao.existsById(id);
    }


    public D getDao() {
        return dao;
    }
}
