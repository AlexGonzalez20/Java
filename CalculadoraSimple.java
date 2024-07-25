import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraSimple {

    public static void main(String[] args) {
        System.out.flush();
        Scanner scanner = new Scanner(System.in);
        double num1, num2;
        int opcion;
        boolean continuar = true;

        System.out.println("Calculadora Simple");

        while (continuar) {
            System.out.println("Selecciona una opción:");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            System.out.println("5. Salir");

            opcion = obtenerOpcionValida(scanner);

            if (opcion == 5) {
                continuar = false;
                System.out.println("Saliendo del programa...");
                break;
            }

            num1 = obtenerNumeroValido(scanner, "Introduce el primer número: ");
            num2 = obtenerNumeroValido(scanner, "Introduce el segundo número: ");

            // Realizar la operación según la opción seleccionada
            switch (opcion) {
                case 1: // Sumar
                    System.out.println("Resultado de la suma: " + (int)(num1 + num2));
                    break;
                case 2: // Restar
                    System.out.println("Resultado de la resta: " + (int)(num1 - num2));
                    break;
                case 3: // Multiplicar
                    System.out.println("Resultado de la multiplicación: " + (int)(num1 * num2));
                    break;
                case 4: // Dividir
                    if (num2 != 0) {
                        System.out.println("Resultado de la división: " + (int)(num1 / num2));
                    } else {
                        System.out.println("Error: División por cero no permitida.");
                    }
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    // Método para obtener una opción válida
    private static int obtenerOpcionValida(Scanner scanner) {
        int opcion = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print("Introduce el número de la opción: ");
                opcion = scanner.nextInt();
                if (opcion < 1 || opcion > 5) {
                    System.out.println("Opción no válida. Por favor, selecciona una opción entre 1 y 5.");
                } else {
                    entradaValida = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, introduce un número.");
                scanner.next(); // Limpiar la entrada inválida
            }
        }

        return opcion;
    }

    // Método para obtener un número válido
    private static double obtenerNumeroValido(Scanner scanner, String mensaje) {
        double num = 0;
        boolean entradaValida = false;

        while (!entradaValida) {
            try {
                System.out.print(mensaje);
                num = scanner.nextDouble();
                verificarNumeroNegativo(num);
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Error: Entrada no válida. Por favor, introduce un número.");
                scanner.next(); // Limpiar la entrada inválida
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return num;
    }

    // Método para verificar si un número es negativo
    private static void verificarNumeroNegativo(double num) {
        if (num < 0) {
            throw new IllegalArgumentException("Error: No se permiten números negativos.");
        }
    }
}
