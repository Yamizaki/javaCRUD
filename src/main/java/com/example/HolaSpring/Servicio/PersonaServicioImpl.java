package com.example.HolaSpring.Servicio;

import com.example.HolaSpring.dao.IPersonaDao;
import com.example.HolaSpring.dominio.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonaServicioImpl implements PersonaServicio {

    @Autowired    
    private  IPersonaDao ipersonadao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Persona> listarPersonas() {
        return (List<Persona>) ipersonadao.findAll();
        
    }

    @Override
    @Transactional
    public void guardar(Persona persona) {
        ipersonadao.save(persona); 
    }

    @Override
    @Transactional
    public void eliminar(Persona persona) {
        ipersonadao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return ipersonadao.findById(persona.getId()).orElse(null);
    }
    
}
