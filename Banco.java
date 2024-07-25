// Banco.java
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Banco {
    private Map<String, Cuenta> cuentas;

    public Banco() {
        cuentas = new HashMap<>();
    }

    public void crearCuenta(String numeroCuenta, double saldoInicial) {
        if (cuentas.containsKey(numeroCuenta)) {
            System.out.println("La cuenta ya existe.");
        } else {
            cuentas.put(numeroCuenta, new Cuenta(numeroCuenta, saldoInicial));
            System.out.println("Cuenta creada exitosamente.");
        }
    }

    public void crearCuentaAhorro(String numeroCuenta, double saldoInicial, double tasaDeInteres) {
        if (cuentas.containsKey(numeroCuenta)) {
            System.out.println("La cuenta ya existe.");
        } else {
            cuentas.put(numeroCuenta, new CuentaAhorro(numeroCuenta, saldoInicial, tasaDeInteres));
            System.out.println("Cuenta de ahorro creada exitosamente.");
        }
    }

    public void depositar(String numeroCuenta, double cantidad) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null) {
            try {
                cuenta.depositar(cantidad);
                System.out.println("Depósito realizado exitosamente.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error al depositar: " + e.getMessage());
            }
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public void retirar(String numeroCuenta, double cantidad) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null) {
            try {
                cuenta.retirar(cantidad);
                System.out.println("Retiro realizado exitosamente.");
            } catch (IllegalArgumentException | InsuficienciaDeFondosException e) {
                System.out.println("Error al retirar: " + e.getMessage());
            }
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public void consultarSaldo(String numeroCuenta) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null) {
            System.out.println(cuenta);
        } else {
            System.out.println("Cuenta no encontrada.");
        }
    }

    public static void main(String[] args) {
        Banco banco = new Banco();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Crear cuenta");
            System.out.println("2. Crear cuenta de ahorro");
            System.out.println("3. Depositar");
            System.out.println("4. Retirar");
            System.out.println("5. Consultar saldo");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    System.out.print("Número de cuenta: ");
                    String numCuenta = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldoInicial = scanner.nextDouble();
                    banco.crearCuenta(numCuenta, saldoInicial);
                    break;

                case 2:
                    System.out.print("Número de cuenta: ");
                    numCuenta = scanner.nextLine();
                    System.out.print("Saldo inicial: ");
                    saldoInicial = scanner.nextDouble();
                    System.out.print("Tasa de interés: ");
                    double tasaInteres = scanner.nextDouble();
                    banco.crearCuentaAhorro(numCuenta, saldoInicial, tasaInteres);
                    break;

                case 3:
                    System.out.print("Número de cuenta: ");
                    numCuenta = scanner.nextLine();
                    System.out.print("Cantidad a depositar: ");
                    double cantidadDeposito = scanner.nextDouble();
                    banco.depositar(numCuenta, cantidadDeposito);
                    break;

                case 4:
                    System.out.print("Número de cuenta: ");
                    numCuenta = scanner.nextLine();
                    System.out.print("Cantidad a retirar: ");
                    double cantidadRetiro = scanner.nextDouble();
                    banco.retirar(numCuenta, cantidadRetiro);
                    break;

                case 5:
                    System.out.print("Número de cuenta: ");
                    numCuenta = scanner.nextLine();
                    banco.consultarSaldo(numCuenta);
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        }
    }
}
