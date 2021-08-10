package com.redbee.atm;

public class CajaCorriente extends Cuenta {

    public CajaCorriente(Integer montoInicial) {
        super(montoInicial);
    }

    public void mostrarSaldo() {
        System.out.println("Sueldo de caja corriente: $" + this.getSaldo());
    }

}
