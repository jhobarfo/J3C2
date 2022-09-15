package com.example.J3C2.controllers;

import com.example.J3C2.entities.Empleado;
import com.example.J3C2.entities.Empresa;
import com.example.J3C2.services.EmpleadoServicio;
import com.example.J3C2.services.Response;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmpleadoControlador {
    EmpleadoServicio empleadoServicio;
    //Constructor
    public EmpleadoControlador(EmpleadoServicio empleadoServicio) {
        this.empleadoServicio = empleadoServicio;
    }

    @GetMapping("/empleado")
    public List<Empleado> getEmpleadoList(){

        return this.empleadoServicio.getEmpleadoList();

    }
    @PostMapping("/empleado")
    public Empleado crearEmpleado(@RequestBody Empleado empleado){

        return this.empleadoServicio.crearEmpleado(empleado);

    }
    @GetMapping("/empleado/{id}")
    public Empleado getEmpleadoId(@PathVariable Long id){

        return this.empleadoServicio.getEmpleadoId(id);

    }
    @DeleteMapping("/empleado/{id}")
    public Response eliminarEmpleado(@PathVariable Long id){
        return this.empleadoServicio.deleteEmpleadoId(id);
    }

    @PutMapping("/empleado")
    public Response updateEmpleado(@RequestBody Empleado empleado){
        return this.empleadoServicio.updateEmpleado(empleado);
    }
    @PatchMapping("/empleado")
    public Response updateEmpresa (@RequestBody Empleado empleado){
        try {
            return this.empleadoServicio.updateEmpleadoPatch(empleado);
        } catch (Exception e) {

            Response response = new Response();
            response.setCode(200);
            response.setMessage("Empleado No actualizada");
            return response;
        }
    }

}
