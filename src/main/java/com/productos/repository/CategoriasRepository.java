package com.productos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.productos.entity.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {

}
