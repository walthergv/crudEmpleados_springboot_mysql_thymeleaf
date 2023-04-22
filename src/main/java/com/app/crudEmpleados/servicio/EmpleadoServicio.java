package com.app.crudEmpleados.servicio;

import com.app.crudEmpleados.entidad.Empleado;

import java.util.List;

public interface EmpleadoServicio {
    public List<Empleado> listarEmpleados();

    public Empleado guardarEmpleado(Empleado empleado);

    public Empleado obtenerEmpleado(int id);

    public Empleado actualizarEmpleado(Empleado empleado);

    public void eliminarEmpleado(int id);
}
