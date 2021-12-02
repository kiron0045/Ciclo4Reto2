package co.usa.edu.ciclo4.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.usa.edu.ciclo4.model.Producto;



public interface ProductoRepository extends MongoRepository<Producto, String>{
	List<Producto> findByCategoria(String categoria);
	List<Producto> findByNombre(String nombre);
	
}
