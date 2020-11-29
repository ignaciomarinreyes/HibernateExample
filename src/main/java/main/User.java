package main;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id_user;

    @Column(name = "nombre")
    private String nombre;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Route> routes;

    public User() {

    }

    public User(Integer id_user) {
        this.id_user = id_user;
    }



    public User(String nombre) {
        this.nombre = nombre;
    }

    public User(Integer id_user, String nombre) {
        this.id_user = id_user;
        this.nombre = nombre;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    @Override
    public String toString() {
        return "User{" + "id_user=" + id_user + ", nombre='" + nombre + '\'' + ", routes=" + routes + '}';
    }
}
