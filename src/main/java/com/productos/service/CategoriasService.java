package com.productos.service;

import java.util.List;

import com.productos.entity.Categoria;

public interface CategoriasService {

	List<Categoria> findAll();
	
	Categoria findOne(Long idCategoria);
	
	Categoria saveOne(Categoria categoria);
	
	void delete(Categoria categoria);
	
}
