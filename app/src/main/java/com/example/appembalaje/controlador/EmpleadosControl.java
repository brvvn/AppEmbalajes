package com.example.appembalaje.controlador;

import android.widget.Toast;

import com.example.appembalaje.modelos.Empleados;

import java.util.List;

public class EmpleadosControl {

    private boolean VerificarExistencia(String rut){
        return false;
    }

    public String CrearEmpleado(Empleados empleado){
        return null;
    }

    public boolean ActualizarEmpleado(Empleados empleado){
        return false;
    };

    public boolean DesactivarEmpleado(String rut){
        if (rut==null){
            return false;
        }else{
            return true;
        }
    }

    public boolean ActualizarPermisos(String rut, List<Object> permisos){
        if(rut == null || permisos == null){
            Toast.makeText(null, "Faltan datos", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            //acá va el codigo que se conecta  al ADO y actualiza el resgistro
            return true;
        }
    }
}
