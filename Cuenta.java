// Cuenta.java
public class Cuenta {
    private String numeroCuenta;
    private double saldo;

    public Cuenta(String numeroCuenta, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldoInicial;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) throws IllegalArgumentException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a depositar debe ser mayor que cero.");
        }
        saldo += cantidad;
    }

    public void retirar(double cantidad) throws IllegalArgumentException, InsuficienciaDeFondosException {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad a retirar debe ser mayor que cero.");
        }
        if (cantidad > saldo) {
            throw new InsuficienciaDeFondosException("Fondos insuficientes.");
        }
        saldo -= cantidad;
    }

    @Override
    public String toString() {
        return "Número de cuenta: " + numeroCuenta + ", Saldo: " + saldo;
    }
}
