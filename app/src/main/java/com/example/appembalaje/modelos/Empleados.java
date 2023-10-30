package com.example.appembalaje.modelos;

import java.util.Date;

public class Empleados {

    private String id;
    private String nombre;
    private String cargo;
    private Date fechaNacimiento;
    private String idNegocio;

    public Empleados(String id, String nombre, String cargo, Date fechaNacimiento, String idNegocio) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.fechaNacimiento = fechaNacimiento;
        this.idNegocio = idNegocio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getIdNegocio() {
        return idNegocio;
    }

    public void setIdNegocio(String idNegocio) {
        this.idNegocio = idNegocio;
    }



}
