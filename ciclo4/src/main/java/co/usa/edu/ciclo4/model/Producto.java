package co.usa.edu.ciclo4.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "producto")
public class Producto {
	
	@Id
	private String id;
	private String nombre;
	private String categoria;
	private String materiales;
	private String disponibilidad;
	private String dimensiones;
	private String precio;
	private String stock;
		
}