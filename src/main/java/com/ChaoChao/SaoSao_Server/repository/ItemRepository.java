package com.ChaoChao.SaoSao_Server.repository;

import com.ChaoChao.SaoSao_Server.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item,Integer> {
    Optional<Item> findByItemName(String itemName);
    void deleteByItemName(String itemName);
}
