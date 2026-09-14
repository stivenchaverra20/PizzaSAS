import java.util.Scanner;

/**
 * Clase principal que coordina el flujo de Pizza-Track.
 * Gestiona dos pilas manuales para implementar Undo/Redo sin colecciones predefinidas.
 */
public class GestionPedidos {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //  Dos pilas independientes. Cada una gestiona sus propios nodos y punteros.
        PilaManual pilaPrincipal = new PilaManual();  //  Pila UNDO: pedidos activos
        PilaManual pilaSecundaria = new PilaManual(); //  Pila REDO: pedidos deshechos
        int opcion;

        System.out.println(" BIENVENIDO A PIZZA-TRACK ");

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Registrar Pizza (Escribir)");
            System.out.println("2. Deshacer (Undo)");
            System.out.println("3. Rehacer (Redo)");
            System.out.println("4. Mostrar Pedido Actual (Peek)");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");

            //  Validación para evitar crash por entrada no numérica
            while (!scanner.hasNextInt()) {
                System.out.print(" Ingresa un número válido (0-4): ");
                scanner.next(); // limpia el buffer
            }
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    registrarPizza(scanner, pilaPrincipal, pilaSecundaria);
                    break;
                case 2:
                    deshacerPedido(pilaPrincipal, pilaSecundaria);
                    break;
                case 3:
                    rehacerPedido(pilaPrincipal, pilaSecundaria);
                    break;
                case 4:
                    mostrarPedidoActual(pilaPrincipal);
                    break;
                case 0:
                    System.out.println(" ¡Gracias por usar Pizza-Track! Saliendo...");
                    break;
                default:
                    System.out.println(" Opción no válida.");
                    break;
            }
        } while (opcion != 0);

        scanner.close();
    }

    /**
     * REGISTRAR: Crea pizza, la apila en principal y LIMPIA la pila secundaria.
     *  Regla de negocio: una nueva acción invalida el historial de "Rehacer".
     */
    private static void registrarPizza(Scanner sc, PilaManual principal, PilaManual secundario) {
        sc.nextLine(); // Limpia el salto de línea pendiente de nextInt()
        System.out.print(" Nombre de la pizza: ");
        String nombre = sc.nextLine();

        String[] ingredientes = new String[3];
        System.out.println(" Ingresa exactamente 3 ingredientes (uno por línea):");
        for (int i = 0; i < 3; i++) {
            System.out.print("Ingrediente " + (i+1) + ": ");
            ingredientes[i] = sc.nextLine();
        }

        Pizza nuevaPizza = new Pizza(nombre, ingredientes);
        principal.push(nuevaPizza); //  push() crea Nodo → enlaza con tope actual → actualiza tope
        System.out.println(" Pizza registrada exitosamente.");

        // 🧹 Limpia pila secundaria al registrar nuevo pedido
        while (!secundario.isEmpty()) {
            secundario.pop();
        }
    }

    /**
     * DESHACER (UNDO): Saca de principal → Mete en secundaria.
     * Equivale a: pop(principal) + push(secundario)
     */
    private static void deshacerPedido(PilaManual principal, PilaManual secundario) {
        if (principal.isEmpty()) {
            System.out.println(" No hay pedidos para deshacer.");
            return;
        }
        Pizza deshecha = principal.pop(); //  pop() guarda tope.pizza → tope = tope.siguiente
        secundario.push(deshecha);
        System.out.println(" Deshecho: " + deshecha);
    }

    /**
     * REHACER (REDO): Saca de secundaria → Mete en principal.
     * Equivale a: pop(secundario) + push(principal)
     */
    private static void rehacerPedido(PilaManual principal, PilaManual secundario) {
        if (secundario.isEmpty()) {
            System.out.println(" No hay pedidos para rehacer.");
            return;
        }
        Pizza rehecha = secundario.pop();
        principal.push(rehecha);
        System.out.println(" Rehecho: " + rehecha);
    }

    /**
     * MOSTRAR ACTUAL (PEEK): Solo lee el tope sin modificar punteros.
     */
    private static void mostrarPedidoActual(PilaManual principal) {
        if (principal.isEmpty()) {
            System.out.println(" No hay pedidos en la pila.");
            return;
        }
        Pizza actual = principal.peek();
        System.out.println(" Pedido actual (tope): " + actual);
    }
}
