package com.redbee.atm;

public class CajaDeAhorroDolares extends Cuenta {

    public CajaDeAhorroDolares(Integer montoInicial) {
        super(montoInicial);
    }

    public void mostrarSaldo() {
        System.out.println("Sueldo de caja ahorro en dólares: $" + this.getSaldo());
    }
}
