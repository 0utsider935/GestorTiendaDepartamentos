package Proyecto.gestortiendadepartamentos;

public class Departamento {

    private int id;
    private String nombre;
    private Articulo[] cola;
    private int frente;
    private int fin;
    private int max;

    // Constructor para crear un departamento 
    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.max = 20;
        this.frente = 0;
        this.fin = 0;
        this.cola = new Articulo[this.max];
    }

    // Verifica si la cola está vacía
    public boolean isColaVacia() {
        return this.frente == this.fin;
    }

    // Verifica si la cola está llena
    public boolean isColaLlena() {
        return (this.fin + 1) % this.max == this.frente;
    }

    // Agrega un artículo al final de la cola
    public boolean agregarArticulo(Articulo a) {
        if (isColaLlena()) return false;
        this.cola[this.fin] = a;
        this.fin = (this.fin + 1) % this.max;
        return true;
    }

    // Elimina un artículo del frente de la cola 
    public Articulo eliminarArticulo() {
        if (isColaVacia()) return null;
        Articulo a = this.cola[this.frente];
        this.frente = (this.frente + 1) % this.max;
        return a;
    }

    // Devuelve los artículos en orden FIFO
    public Articulo[] obtenerArticulos() {
        int cantidad = (this.fin - this.frente + this.max) % this.max;
        Articulo[] lista = new Articulo[cantidad];
        for (int i = 0, j = this.frente; j != this.fin; j = (j + 1) % this.max, i++) {
            lista[i] = this.cola[j];
        }
        return lista;
    }

    // Getters
    public int getId() { return this.id; }
    public String getNombre() { return this.nombre; }
}