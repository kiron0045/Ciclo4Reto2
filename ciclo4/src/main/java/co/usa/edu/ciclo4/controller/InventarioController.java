package co.usa.edu.ciclo4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.edu.ciclo4.model.Inventario;
import co.usa.edu.ciclo4.repository.InventarioRepository;


@CrossOrigin
@RestController
@RequestMapping("/api/cookware")

public class InventarioController {
	
	@Autowired
	private InventarioRepository inventariorepo;
	
	@GetMapping("/all")
	List<Inventario> productos() {
		return inventariorepo.findAll();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/new")
	Inventario crearProducto(@RequestBody Inventario inventario) {
		return inventariorepo.save(inventario);
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PutMapping("/update")
	Inventario actualizarProducto(@RequestBody Inventario inventario) {
		return inventariorepo.save(inventario);
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	void Delete(@PathVariable String id) {
		Inventario inventario = inventariorepo.findById(id).orElseThrow(RuntimeException::new);
		inventariorepo.delete(inventario);
	}
	
}

