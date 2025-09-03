package com.mercadoria.shopee.repository;

import com.mercadoria.shopee.entity.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, UUID> {
}
