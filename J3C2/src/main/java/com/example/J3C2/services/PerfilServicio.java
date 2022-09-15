package com.example.J3C2.services;

import com.example.J3C2.entities.Empresa;
import com.example.J3C2.entities.Perfil;
import com.example.J3C2.repositories.PerfilRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilServicio {
    @Autowired
    PerfilRepositorio perfilRepositorio;

    public List<Perfil> getPerfilList(){return this.perfilRepositorio.findAll();}
}
