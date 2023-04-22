package com.app.crudEmpleados.controlador;

import com.app.crudEmpleados.entidad.Empleado;
import com.app.crudEmpleados.servicio.EmpleadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmpleadoControlador {
    @Autowired
    private EmpleadoServicio empleadoServicio;
    @GetMapping({"/empleados", "/"})
    public String listarEmpleados(Model modelo){
        modelo.addAttribute("empleados",empleadoServicio.listarEmpleados());
        return "empleados";
    }

    @GetMapping("/empleados/nuevo")
    public String mostrarFormRegistrarEmpleado(Model model){
        Empleado empleado = new Empleado();
        model.addAttribute("empleado", empleado);
        return "crear_empleado";
    }

    @PostMapping("/empleados")
    public String guardarEmpleado(@ModelAttribute("empleado") Empleado empleado){
        empleadoServicio.guardarEmpleado(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/editar/{id}")
    public String mostrarFormEditarEmpleado(@PathVariable int id, Model model){
        model.addAttribute("empleado", empleadoServicio.obtenerEmpleado(id));
        return "editar_empleado";
    }

    @PostMapping("/empleados/{id}")
    public String actuaizarEmpleado(@PathVariable int id, @ModelAttribute("empleado") Empleado empleado, Model model){
        Empleado empleado1 = empleadoServicio.obtenerEmpleado(id);
        empleado1.setId(id);
        empleado1.setNombre(empleado.getNombre());
        empleado1.setApellido(empleado.getApellido());
        empleado1.setDireccion(empleado.getDireccion());
        empleado1.setEmail(empleado.getEmail());

        empleadoServicio.actualizarEmpleado(empleado1);
        return "redirect:/empleados";
    }

    @GetMapping("/empleados/{id}")
    public String eliminarEmpleado(@PathVariable int id){
        empleadoServicio.eliminarEmpleado(id);
        return "redirect:/empleados";
    }
}
