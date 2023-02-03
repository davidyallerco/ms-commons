package controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import services.CommonService;


public class CommonController<E,S extends CommonService<E>> {
	
	@Autowired
	protected S service;
	
	@GetMapping
	public ResponseEntity<?> listar() {
		return ResponseEntity.ok().body(service.buscarTodos());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> ver(@PathVariable Long id){
		Optional<E> optional = service.buscarPorId(id);
		if (!optional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(optional.get());
	}
	
	@PostMapping
	public ResponseEntity<?> crear(@RequestBody E entity){
		E entityDb = service.guardar(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entityDb);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id){
		service.eliminarPorId(id);
		return ResponseEntity.noContent().build();
	}

}
