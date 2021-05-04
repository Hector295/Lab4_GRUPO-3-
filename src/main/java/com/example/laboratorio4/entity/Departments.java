package com.example.laboratorio4.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="departments")
public class Departments {

    @Id
    @Column(name = "department_id")
    private int id;
    @Column(name = "department_name")
    private String departmentname;
    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees managerid;
    @ManyToOne
    @JoinColumn(name = "location_id")
    private Locations locations;

    public List<Employees> getListaEmpleadosPorDepartamento() {
        return listaEmpleadosPorDepartamento;
    }

    public void setListaEmpleadosPorDepartamento(List<Employees> listaEmpleadosPorDepartamento) {
        this.listaEmpleadosPorDepartamento = listaEmpleadosPorDepartamento;
    }

    @OneToMany(mappedBy = "departments")
    private List<Employees> listaEmpleadosPorDepartamento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public Employees getManagerid() {
        return managerid;
    }

    public void setManagerid(Employees managerid) {
        this.managerid = managerid;
    }

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }
}
