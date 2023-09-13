package com.example.HolaSpring;

import com.example.HolaSpring.Servicio.PersonaServicio;
import com.example.HolaSpring.dao.IPersonaDao;
import com.example.HolaSpring.dominio.Persona;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorInicio {

    /* @Value("${index.saludo}")
    private String saludo;*/

 /*  @GetMapping("/inicio")
    public String inicio(Model model) {

        var persona = new Persona();
        persona.setNombre("Yamizaki");
        persona.setApellido("Arakaki");
        persona.setEmail("Arakaki@outlook.com");
        persona.setTelefono("987654987");

        var persona2 = new Persona();
        persona2.setNombre("Carla");
        persona2.setApellido("Suya");
        persona2.setEmail("Carla@outlook.com");
        persona2.setTelefono("123456789");

        var persona3 = new Persona();
        persona3.setNombre("Jso");
        persona3.setApellido("Sre");
        persona3.setEmail("Jsre@outlook.com");
        persona3.setTelefono("0000000");

        var personas = new ArrayList();
        personas.add(persona);
        personas.add(persona2);
        personas.add(persona3);

        
        
        String saludar = "Hola tengo 25 años";
        String edad = "18";

        model.addAttribute("saludar", saludar);
        model.addAttribute("edad", edad);
        model.addAttribute("saludo", saludo);
        model.addAttribute("personas", personas);
        return "index";
    }*/
    @Autowired
    private PersonaServicio personaservicio;

    @GetMapping("/")
    public String persona(Model model) {

        var personas = personaservicio.listarPersonas();
        model.addAttribute("personas", personas);
        return "index";

    }

    @GetMapping("/agregar")
    public String agregar(Persona persona) {
        return "agregar";

    }

    @PostMapping("/guardar")
    public String guardar(Persona persona) {
        personaservicio.guardar(persona);
        return "redirect:/";

    }

    @GetMapping("/editar/{id}")
    public String editar(Persona persona, Model model) {
        persona = personaservicio.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "agregar";

    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(Persona persona, Model model) {
        personaservicio.eliminar(persona);
        return "redirect:/";
    }
}
