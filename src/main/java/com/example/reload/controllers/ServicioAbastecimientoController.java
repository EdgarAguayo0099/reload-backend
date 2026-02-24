package com.example.reload.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.reload.models.ServicioAbastecimiento;
import com.example.reload.repositories.ServicioAbastecimientoRepository;

@RestController
public class ServicioAbastecimientoController {
	private final ServicioAbastecimientoRepository servicioAbastecimientoRepository;
	
	public ServicioAbastecimientoController(ServicioAbastecimientoRepository repository) {
		this.servicioAbastecimientoRepository = repository;
	}
	
	 @PostMapping("/saveAbastecimiento")
	  public ServicioAbastecimiento save(@RequestBody ServicioAbastecimiento b) {
		 System.out.println(b.toString());
	    return this.servicioAbastecimientoRepository.save(b);
	  }
	
	 @GetMapping("/findAllAbastecimiento")
	  public Iterable<ServicioAbastecimiento> findAll() {
	    return this.servicioAbastecimientoRepository.findAll();
	  }

	 @DeleteMapping("/deleteAbastecimiento")
	 public void delete(@RequestParam Integer id) {
		  this.servicioAbastecimientoRepository.deleteById(id);
	 }

}
