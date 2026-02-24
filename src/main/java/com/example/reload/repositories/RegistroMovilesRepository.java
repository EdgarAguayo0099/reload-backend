package com.example.reload.repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.reload.models.RegistroMoviles;

public interface RegistroMovilesRepository 
        extends CrudRepository<RegistroMoviles, Integer> {

}