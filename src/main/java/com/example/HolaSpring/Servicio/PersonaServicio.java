package com.example.HolaSpring.Servicio;

import com.example.HolaSpring.dominio.Persona;
import java.util.List;


public interface PersonaServicio {
    
    public List<Persona> listarPersonas();
    
    public void guardar(Persona persona);
    
    public void eliminar(Persona persona);
    
    public Persona encontrarPersona(Persona persona);
}
