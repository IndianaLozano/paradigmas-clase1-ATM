package com.redbee.atm;

public abstract class Cuenta {

    private Integer saldo;

    public Cuenta(Integer montoInicial) {
        if (montoInicial == null || montoInicial < 0) {
            montoInicial = 0;
        }

        this.saldo = montoInicial;
    }

    public Integer getSaldo() {
        return saldo;
    }

    public abstract void mostrarSaldo();

    public void depositar(Integer monto) {
        if (monto != null && monto > 0) {
            this.saldo += monto;
        } else {
            System.out.println("Monto inválido");
        }
    }

    public void retirar(Integer monto) {
        if (monto != null && monto <= saldo) {
            this.saldo -= monto;
            System.out.println("Monto retirado " + monto);
        } else {
            System.out.println("Monto inválido");
        }

        System.out.println("Saldo restante " + this.saldo);
    }
}
