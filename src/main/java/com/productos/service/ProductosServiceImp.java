package com.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productos.entity.Producto;
import com.productos.repository.ProductosRepository;

@Service
public class ProductosServiceImp implements ProductosService {

	 @Autowired
	 private ProductosRepository repo;
	
	@Override
	@Transactional
	public List<Producto> findAll() {
		
		return repo.findAll();
	}

	@Override
	@Transactional
	public Producto findOne(Long idProducto) {

		
		return repo.findById(idProducto).orElse(null);
	}

	@Override
	@Transactional
	public void saveOne(Producto producto) {
		
		repo.save(producto);
		
	}

	@Override
	@Transactional
	public void delete(Producto producto) {

		repo.delete(producto);
	}
	
	
	
	
}
