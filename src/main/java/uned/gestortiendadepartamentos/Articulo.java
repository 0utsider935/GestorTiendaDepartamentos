
package uned.gestortiendadepartamentos;

public class Articulo {
    private int id;
    private String nombre;
    private String categoria;

    // Constructor para inicializar un artículo con un id, nombre y categoría
    public Articulo(int id, String nombre, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
    }

    // Getters 
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
}