package com.app.crudEmpleados.servicio;

import com.app.crudEmpleados.entidad.Empleado;
import com.app.crudEmpleados.repositorio.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpleadoServicioImp implements EmpleadoServicio{
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }
    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }
    @Override
    public Empleado obtenerEmpleado(int id) {
        return empleadoRepositorio.findById(id).get();
    }
    @Override
    public Empleado actualizarEmpleado(Empleado empleado) {
        return empleadoRepositorio.save(empleado);
    }
    @Override
    public void eliminarEmpleado(int id) {
        empleadoRepositorio.deleteById(id);
    }
}
