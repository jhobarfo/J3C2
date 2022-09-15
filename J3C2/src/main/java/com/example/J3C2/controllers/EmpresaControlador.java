package com.example.J3C2.controllers;


import com.example.J3C2.entities.Empleado;
import com.example.J3C2.entities.Empresa;
import com.example.J3C2.services.EmpresaServicio;
import com.example.J3C2.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpresaControlador {
    EmpresaServicio empresaServicio;
    //Constructor
    public EmpresaControlador(EmpresaServicio empresaServicio) {this.empresaServicio = empresaServicio;}

    @GetMapping("/enterprises")
    public List<Empresa> getEmpresaList(){

        return this.empresaServicio.getEmpresaList();

    }
    @PostMapping("/enterprises")
    public Empresa crearEmpresa(@RequestBody Empresa empresa){

        return this.empresaServicio.crearEmpresa(empresa);

    }
    @GetMapping("/enterprises/{id}")
    public Empresa getEmpresaId (@PathVariable Long id) throws Exception {
        return this.empresaServicio.getEmpresaId(id);
    }
    @DeleteMapping("/enterprises/{id}")
    public Response eliminarEmpresa(@PathVariable Long id){

        return this.empresaServicio.deleteEmpresaId(id);
    }

    @PatchMapping("/enterprises")
    public Response updateEmpresa (@RequestBody Empresa empresa){
        try {
            return this.empresaServicio.updateEmpresa(empresa);
        } catch (Exception e) {

            Response response = new Response();
            response.setCode(200);
            response.setMessage("Empresa No actualizada");
            return response;
        }
    }
}
