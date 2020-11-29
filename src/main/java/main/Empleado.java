package main;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer id_empleado;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<Coche> coches;

    public Empleado(){

    }

    public Empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public Empleado(String nombre) {
        this.nombre = nombre;
    }

    public Empleado(Integer id_empleado, String nombre) {
        this.id_empleado = id_empleado;
        this.nombre = nombre;
    }

    public Integer getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(Integer id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Coche> getCoches() {
        return coches;
    }

    public void setCoches(List<Coche> coches) {
        this.coches = coches;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id_empleado + ", nombre='" + nombre + '\'' + '}';
    }
}
