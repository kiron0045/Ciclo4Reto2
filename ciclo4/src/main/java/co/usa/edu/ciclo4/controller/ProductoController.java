package co.usa.edu.ciclo4.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.edu.ciclo4.model.Producto;
import co.usa.edu.ciclo4.repository.ProductoRepository;


@CrossOrigin
@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	@Autowired
	private ProductoRepository productoRepo;
	
	@GetMapping("")
	List<Producto> productos() {
		return productoRepo.findAll();
	}
	
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	Producto crearProducto(@RequestBody Producto producto) {
		return productoRepo.save(producto);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("{id}")
	void Delete(@PathVariable String id) {
		Producto producto = productoRepo .findById(id).orElseThrow(RuntimeException::new);
		productoRepo.delete(producto);
	}
	
	@GetMapping("categoria/{categoria}")
	List<Producto> productos(@PathVariable String categoria) {
		List<Producto> producto = productoRepo.findByCategoria(categoria);
		return producto;
	}
	@GetMapping("nombre/{nombre}")
	List<Producto> producto2(@PathVariable String nombre) {
		List<Producto> producto = productoRepo.findByNombre(nombre);
		return producto;
	}
}
    
