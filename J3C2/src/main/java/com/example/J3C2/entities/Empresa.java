package com.example.J3C2.entities;
import javax.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombreEmpresa")
    private String nombreEmpresa;
    @Column(name = "nitEmpresa")
    private String nitEmpresa;
    @Column(name = "telefonoEmpresa")
    private String telefonoEmpresa;
    @Column(name = "direccionEmpresa")
    private String direccionEmpresa;

    @OneToMany(mappedBy = "empresa")
    private List<Empleado> empleados;

}
