package com.productos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productos.entity.Categoria;
import com.productos.repository.CategoriasRepository;

@Service
public class CategoriasServiceImp implements CategoriasService {
	
	@Autowired
	private CategoriasRepository repo;
	
	@Override
	public List<Categoria> findAll() {
		
		return repo.findAll();
	}

	@Override
	@Transactional
	public Categoria saveOne(Categoria categoria) {
		
		return repo.save(categoria);
	}

	@Override
	public void delete(Categoria categoria) {
		repo.delete(categoria);
		
	}

	@Override
	public Categoria findOne(Long idCategoria) {
		
		return repo.findById(idCategoria).orElse(null);
	}

	
}
