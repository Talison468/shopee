package com.mercadoria.shopee.repository;

import com.mercadoria.shopee.entity.Mercadoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface MercadoriaRepository extends JpaRepository<Mercadoria, UUID>{
    //save, delete, update, findAll, findById;
}
