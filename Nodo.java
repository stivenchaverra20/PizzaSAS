/**
 * Clase que representa un Nodo en la lista ligada.
 * Cada nodo guarda una Pizza y un enlace al siguiente nodo.
 */
public class Nodo {
    private Pizza pizza;      //  El dato real que guardamos
    private Nodo siguiente;   //  La "flecha" que apunta al siguiente nodo

    /**
     * Constructor: Recibe la pizza y deja el enlace en null por defecto.
     */
    public Nodo(Pizza pizza) {
        this.pizza = pizza;
        this.siguiente = null; // Inicialmente no apunta a nada
    }

    //  Getters y Setters (para leer/modificar punteros y datos)
    public Pizza getPizza() { return pizza; }
    public void setPizza(Pizza pizza) { this.pizza = pizza; }

    public Nodo getSiguiente() { return siguiente; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
}
