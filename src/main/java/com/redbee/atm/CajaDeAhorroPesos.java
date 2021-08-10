package com.redbee.atm;

public class CajaDeAhorroPesos extends Cuenta {

    public CajaDeAhorroPesos(Integer montoInicial) {
        super(montoInicial);
    }

    public void mostrarSaldo() {
        System.out.println("Sueldo de caja de ahorro en pesos: $" + this.getSaldo());
    }
}
