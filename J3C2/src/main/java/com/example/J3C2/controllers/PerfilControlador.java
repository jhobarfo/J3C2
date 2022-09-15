package com.example.J3C2.controllers;

import com.example.J3C2.entities.Empleado;
import com.example.J3C2.entities.Perfil;
import com.example.J3C2.services.PerfilServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PerfilControlador {
    @Autowired
    PerfilServicio perfilServicio;

    @GetMapping("/perfil")
    public List<Perfil> getperfilList(){

        return this.perfilServicio.getPerfilList();

    }
}
