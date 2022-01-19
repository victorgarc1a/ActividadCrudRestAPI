package com.productos.service;

import java.util.List;

import com.productos.entity.Producto;

public interface ProductosService {
	
	List<Producto> findAll();
	
	Producto findOne(Long idProducto);
	
	void saveOne(Producto producto);
	
	void delete(Producto producto);

}
