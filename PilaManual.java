
public class PilaManual {
    private Nodo tope; //  Referencia al nodo superior (último ingresado)

    /**
     * Constructor: La pila inicia vacía.
     */
    public PilaManual() {
        this.tope = null;
    }

    /**
     * push(): Agrega una pizza al tope de la pila.
     * Lógica: 1. Crear nodo → 2. Apuntar al tope actual → 3. Mover tope
     */
    public void push(Pizza pizza) {
        Nodo nuevoNodo = new Nodo(pizza);      //  Creamos el eslabón con la pizza
        nuevoNodo.setSiguiente(tope);          //  La "flecha" del nuevo apunta al tope actual
        this.tope = nuevoNodo;                 //  El tope ahora es el nuevo nodo
    }

    /**
     * pop(): Retira y devuelve la pizza del tope.
     * Retorna null si la pila está vacía (seguridad).
     */
    public Pizza pop() {
        if (isEmpty()) {
            return null; //  No hay nada que sacar
        }
        Pizza pizzaRetirada = tope.getPizza(); //  Guardamos la pizza actual
        this.tope = tope.getSiguiente();       //  Avanzamos el tope al siguiente nodo
        return pizzaRetirada;                  //  Devolvemos la pizza retirada
    }

    /**
     * peek(): Devuelve la pizza del tope sin retirarla.
     * Útil para ver "qué está listo para producir" sin perder el pedido.
     */
    public Pizza peek() {
        if (isEmpty()) {
            return null;
        }
        return tope.getPizza();
    }

    /**
     * isEmpty(): Verifica si la pila no tiene elementos.
     */
    public boolean isEmpty() {
        return tope == null; // Si tope es null, no hay nodos enlazados
    }
}