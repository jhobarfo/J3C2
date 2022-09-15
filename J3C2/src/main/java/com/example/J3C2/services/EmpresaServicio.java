package com.example.J3C2.services;

import com.example.J3C2.entities.Empleado;
import com.example.J3C2.entities.Empresa;
import com.example.J3C2.repositories.EmpleadoRepositorio;
import com.example.J3C2.repositories.EmpresaRepositorio;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpresaServicio {
    private EmpresaRepositorio empresaRepositorio;
    //Contructor
    public EmpresaServicio(EmpresaRepositorio empresaRepositorio) {this.empresaRepositorio = empresaRepositorio;
    }
    public Empresa crearEmpresa(Empresa empresa){return this.empresaRepositorio.save(empresa);}

    public List<Empresa> getEmpresaList(){return this.empresaRepositorio.findAll();}

    public Empresa getEmpresaId(Long id) throws Exception {
        Optional<Empresa> empresa=this.empresaRepositorio.findById(id);
        if (empresa.isPresent())
        {
            return empresa.get();
        }
        else
        {
            throw new Exception("Usuario No Existe");
        }
    }
    public Response deleteEmpresaId(Long id){
        this.empresaRepositorio.deleteById(id);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("Empresa eliminada satisfactoriamente");
        return response;
    }

    public Response updateEmpresa(Empresa empresa) throws Exception {
        try
        {
            Empresa empresa1=getEmpresaId(empresa.getId());

            if (empresa.getDireccionEmpresa()!=null){
                empresa1.setDireccionEmpresa(empresa.getDireccionEmpresa());
            }
            if (empresa.getNitEmpresa()!=null){
                empresa1.setNitEmpresa(empresa.getNitEmpresa());
            }
            if (empresa.getNombreEmpresa()!=null){
                empresa1.setNombreEmpresa(empresa.getNombreEmpresa());
            }
            if (empresa.getTelefonoEmpresa()!=null){
                empresa1.setTelefonoEmpresa(empresa.getDireccionEmpresa());
            }
            this.empresaRepositorio.save(empresa1);
            Response response = new Response();
            response.setCode(200);
            response.setMessage("Empresa actualizada satisfactoriamente");
            return response;


        } catch (Exception e)
        {
            throw new Exception("Empresa no se actualizó porque no existe");
        }
    }


}
