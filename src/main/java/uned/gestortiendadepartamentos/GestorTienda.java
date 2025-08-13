package uned.gestortiendadepartamentos;

import java.util.Arrays;

public class GestorTienda {

    private Departamento[] pila;
    private int tope;
    private final int MAX = 20;
    private int idDep;
    private int idArt;

    public GestorTienda() {
        this.tope = -1;
        this.idDep = 1;
        this.idArt = 1;
        this.pila = new Departamento[MAX];
    }

    //Fragmentos de codigo de pilas adaptados de: Tutoría 2 - Estructura de Datos  https://youtu.be/4n8fVyfugVA

    // Verifica si la pila está llena
    public boolean isPilaLlena() {
        return this.tope == MAX - 1;
    }

    // Verifica si la pila está vacía. 
    public boolean isPilaVacia() {
        return this.tope == -1;
    }

    // Agrega un nuevo departamento al tope de la pila
    public boolean agregarDepartamento(String nombre) {
        if (!isPilaLlena()) {
            this.pila[++this.tope] = new Departamento(this.idDep++, nombre);
            return true;
        }
        return false;
    }

    //Fragmentos de codigo de colas adaptados de: Tutoría 2 - Estructura de Datos https://youtu.be/4n8fVyfugVA?t=1897

    // Elimina el departamento del tope si su cola está vacía
    public boolean eliminarDepartamento() {
        if (!isPilaVacia() && this.pila[this.tope].isColaVacia()) {
            this.pila[this.tope--] = null;
            return true;
        }
        return false;
    }

    // Devuelve los departamentos actuales
    public Departamento[] obtenerDepartamentos() {
        return Arrays.copyOfRange(this.pila, 0, this.tope + 1);
    }

    // Agrega un artículo a un departamento
    public boolean agregarArticulo(int index, String nombre, String categoria) {
        if (index >= 0 && index <= this.tope) {
            return this.pila[index].agregarArticulo(new Articulo(this.idArt++, nombre, categoria));
        }
        return false;
    }

    // Elimina el artículo más antiguo de un departamento
    public Articulo eliminarArticulo(int index) {
        if (index >= 0 && index <= this.tope) {
            return this.pila[index].eliminarArticulo();
        }
        return null;
    }

    // Traslada todos los artículos de un departamento a otro
    public boolean trasladarArticulos(int origen, int destino) {

        if (origen == destino || origen < 0 || destino < 0 || origen > this.tope || destino > this.tope) return false;

        Departamento dOrigen = this.pila[origen];
        Departamento dDestino = this.pila[destino];

        while (!dOrigen.isColaVacia()) {
            Articulo a = dOrigen.eliminarArticulo();  // Elimina el artículo del departamento de origen
            if (!dDestino.agregarArticulo(a)) return false; // Agrega el artículo al departamento de destino
        }
        return true;
    }
}