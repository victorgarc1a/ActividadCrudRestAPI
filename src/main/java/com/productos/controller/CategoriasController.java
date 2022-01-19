package com.productos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productos.entity.Categoria;
import com.productos.service.CategoriasService;

import io.swagger.annotations.ApiOperation;

@RestController
public class CategoriasController {

	@Autowired
	private CategoriasService categoriaService;
	
	
	@ApiOperation(value = "Prueba de listado de categorías", notes="Esta es la lista de las categorías almacenados en la tabla de categorías")
	@GetMapping(value = "/categorias")
	private List<Categoria> getCategorias(){

		try {
			return categoriaService.findAll();
		}
		catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	@PostMapping(value="/categorias")
	@ApiOperation(value = "Agregar nueva categoría", notes="Este acces point es para agregar una nueva categoría")
	private void postCategoria() {
		
		try {
		
			Categoria categoria = new Categoria();
			
			categoria.setIdCategoria(5L);
			categoria.setNombreCategoria("Cremoso");
			
			categoriaService.saveOne(categoria);
			
			System.out.println(categoria.getIdCategoria());
			System.out.println(categoria.getNombreCategoria());

		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@PutMapping(value="/categorias/{idCategoria}")
	@ApiOperation(value = "Actualizar nueva categoría", notes="Este acces point es para actualizar una nueva categoría")
	private void putCategoria(@RequestParam(value="idCategoria")Long idCategoria) {
		
		try {
			Categoria categoria = categoriaService.findOne(idCategoria);
			
			categoria.setNombreCategoria("Cremoso");
			
			categoriaService.saveOne(categoria);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	@PatchMapping(value="/categorias/{idCategoria}")
	@ApiOperation(value = "Actualizar parcialmente nueva categoría", notes="Este acces point es para actualizar parcialmente una nueva categoría")
	private void patchCategoria(@RequestParam(value="idCategoria")Long idCategoria) {
		
		try {
			Categoria categoria = categoriaService.findOne(idCategoria);
			
			categoria.setNombreCategoria("Frío");
			
			categoriaService.saveOne(categoria);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	@DeleteMapping(value="/categorias/{idCategoria}")
	@ApiOperation(value = "Agregar nueva categoría", notes="Este acces point es para agregar una nueva categoría")
	private void deleteCategoria(@RequestParam(value="idCategoria")Long idCategoria) {
		
		try {
			categoriaService.delete(categoriaService.findOne(idCategoria));
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
}
