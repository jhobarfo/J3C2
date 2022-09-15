package com.example.J3C2.services;

import com.example.J3C2.entities.Empleado;
import com.example.J3C2.entities.Empresa;
import com.example.J3C2.repositories.EmpleadoRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServicio {
    private EmpleadoRepositorio empleadoRepositorio;
    //Contructor
    public EmpleadoServicio(EmpleadoRepositorio empleadoRepositorio) {
        this.empleadoRepositorio = empleadoRepositorio;
    }
    public Empleado crearEmpleado(Empleado empleado){
        return this.empleadoRepositorio.save(empleado);
    }
    public List<Empleado> getEmpleadoList(){
        return this.empleadoRepositorio.findAll();
    }

    public Empleado getEmpleadoId(Long id){
        Optional<Empleado>empleado=this.empleadoRepositorio.findById(id);
        if (empleado.isPresent())
        {
            return empleado.get();
        }
        else
        {
            return null;
        }
    }
    public Response deleteEmpleadoId(Long id){
        this.empleadoRepositorio.deleteById(id);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("Empleado eliminado satisfactoriamente");
        return response;
    }
    public Response updateEmpleado(Empleado empleado){
        Response response = new Response();
        if (empleado.getId()==0){
            response.setCode(500);
            response.setMessage("Id empleado incorrecto");
            return response;
        }
        Empleado empleadoEncontrado=getEmpleadoId(empleado.getId());
        if (empleado.getId()==null){
            response.setCode(500);
            response.setMessage("Id empleado no existe");
            return response;
        }
        empleadoEncontrado.setNombreEmpleado(empleado.getNombreEmpleado());
        empleadoEncontrado.setCorreoEmpleado(empleado.getCorreoEmpleado());
        this.empleadoRepositorio.save(empleadoEncontrado);
        response.setCode(200);
        response.setMessage("Empleado actualizado correctamente");
        return response;
    }

    public Response updateEmpleadoPatch(Empleado empleado) throws Exception {
        try
        {
            Empleado empleado1=getEmpleadoId(empleado.getId());

            if (empleado.getRolEmpleado()!=null){
                empleado1.setRolEmpleado(empleado.getRolEmpleado());
            }
            if (empleado.getCorreoEmpleado()!=null){
                empleado1.setCorreoEmpleado(empleado.getCorreoEmpleado());
            }
            if (empleado.getNombreEmpleado()!=null){
                empleado1.setNombreEmpleado(empleado.getNombreEmpleado());
            }
            this.empleadoRepositorio.save(empleado1);
            Response response = new Response();
            response.setCode(200);
            response.setMessage("Empleado actualizada satisfactoriamente");
            return response;


        } catch (Exception e)
        {
            throw new Exception("Empleado no se actualizó porque no existe");
        }
    }


}
