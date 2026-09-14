#  Pizza-Track: Sistema de Gestión de Pedidos con Pilas Manuales

##  Objetivo
Desarrollar una aplicación en consola que simule el registro, deshacer (Undo) y rehacer (Redo) de pedidos de pizza, utilizando **dos pilas manuales basadas en listas ligadas** (sin `java.util.Stack`). El sistema valida entradas, gestiona punteros manualmente y documenta la lógica de estructuras de datos lineales.

##  Arquitectura del Proyecto
| Archivo | Responsabilidad |
|:---|:---|
| `Pizza.java` | Modelo de datos. Contiene nombre y arreglo fijo de 3 ingredientes. |
| `Nodo.java` | Eslabón de la lista ligada. Guarda referencia a `Pizza` y al siguiente `Nodo`. |
| `PilaManual.java` | Implementación manual de Stack. Métodos: `push()`, `pop()`, `peek()`, `isEmpty()`. |
| `GestionPedidos.java` | Controlador principal. Menú interactivo + coordinación de 2 pilas para Undo/Redo. |

##  Requisitos
- Java JDK 11 o superior (Eclipse Temurin recomendado)
- VS Code con `Extension Pack for Java` instalado
- Terminal con `javac` y `java` disponibles en PATH

##  Instrucciones de Ejecución
1. Clona o descarga la carpeta del proyecto
2. Abre la carpeta en VS Code
3. Abre terminal integrada: `` Ctrl + ` ``
4. Compila: `javac *.java`
5. Ejecuta: `java GestionPedidos`
6. Sigue el menú interactivo en consola

##  Capturas de Consola
*(Reemplaza con imágenes reales de tu ejecución)*
| Acción | Captura |
|:---|:---|
| Registro de Pizza + Ingredientes | <img width="446" height="360" alt="image" src="https://github.com/user-attachments/assets/170852ec-c929-4bec-a401-76359408dacc" />

| Ciclo: Deshacer → Rehacer → Peek | 
| Validación de entrada y salida |


##  Información Académica
- **Autor(es):** `[Stiven_Chaverra_Garcia] `
- **Materia:** `[Estructura_de_datos]`
- **Docente:** `[Carlos_Arturo_Castro]`
- **Fecha de entrega:** `[17/09/2026]`

##  Notas Técnicas
- No se utiliza `java.util.Stack` ni colecciones predefinidas.
- Los punteros (`nodo.siguiente`) se gestionan manualmente con reasignación de referencias.
- La pila secundaria se vacía automáticamente al registrar un nuevo pedido (regla de negocio estándar para invalidez de historial Redo).
