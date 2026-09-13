/**
 * Clase que representa un pedido de pizza.
 * Modelo de datos para el sistema Pizza-Track.
 */
public class Pizza {
    // Atributos (datos que guarda cada objeto Pizza)
    private String nombre;
    private String[] ingredientes = new String[3]; //  Requisito: ARREGLO FIJO DE 3

    /**
     * Constructor: Se ejecuta automaticamente al crear: new Pizza(...)
     * Recibe el nombre y un arreglo con exactamente 3 ingredientes.
     */
    public Pizza(String nombre, String[] ingredientes) {
        this.nombre = nombre; // this.nombre = atributo de la clase | nombre = parametro recibido
        
        //Copia defensiva: duplica el arreglo para evitar referencias cruzadas
        if (ingredientes != null && ingredientes.length == 3) {
            System.arraycopy(ingredientes, 0, this.ingredientes, 0, 3);
        }
    }

    // Getters: permiten leer los atributos desde otras clases
    public String getNombre() { return nombre; }
    public String[] getIngredientes() { return ingredientes; }

    /**
     *  toString(): Define como se imprime el objeto en consola
     * Se usara automaticamente en peek() y pop() mas adelante
     */
    @Override
    public String toString() {
        return " Pizza: " + nombre + 
               " | Ingredientes: " + ingredientes[0] + ", " + 
               ingredientes[1] + ", " + ingredientes[2];
    }
}
