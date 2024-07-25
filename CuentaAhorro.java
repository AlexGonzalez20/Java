// CuentaAhorro.java
public class CuentaAhorro extends Cuenta {
    private double tasaDeInteres;

    public CuentaAhorro(String numeroCuenta, double saldoInicial, double tasaDeInteres) {
        super(numeroCuenta, saldoInicial);
        this.tasaDeInteres = tasaDeInteres;
    }

    public void aplicarInteres() {
        double interes = getSaldo() * tasaDeInteres / 100;
        try {
            depositar(interes);
        } catch (IllegalArgumentException e) {
            System.out.println("Error al aplicar interés: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Tasa de interés: " + tasaDeInteres + "%";
    }
}
