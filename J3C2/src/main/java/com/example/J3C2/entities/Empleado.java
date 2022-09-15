package com.example.J3C2.entities;
import com.example.J3C2.enums.EmpleadoEnum;
import lombok.*;

import javax.persistence.*;
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Empleado")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //@Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nombreEmpleado")
    private String nombreEmpleado;
    @Column(name="correoEmpleado")
    private String correoEmpleado;
    @Enumerated(EnumType.STRING)
    @Column(name = "rolEmpleado")
    private EmpleadoEnum rolEmpleado;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;
}
