package com.mercadoria.shopee.entity;

import jakarta.persistence.OneToOne;

public class Address {
    @OneToOne(mappedBy = "address")
    private Warehouse warehouse;
}
