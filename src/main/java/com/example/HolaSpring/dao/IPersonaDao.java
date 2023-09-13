package com.example.HolaSpring.dao;

import com.example.HolaSpring.dominio.Persona;
import org.springframework.data.repository.CrudRepository;

public interface IPersonaDao extends CrudRepository<Persona, Long>{
    
}
