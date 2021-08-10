package com.redbee.atm;

import java.util.Map;
import java.util.Scanner;

public class ATM {

    public static void main(String[] args) {
         new ATM().menuPrincipal();
    }

    // variables de instancia
    private Scanner sc = new Scanner(System.in);

    private Map<String, Cuenta> cuentas = Map.of(
            "CAJA CORRIENTE", new CajaCorriente(0),
            "CAJA EN PESOS", new CajaDeAhorroPesos(0),
            "CAJA EN DOLARES", new CajaDeAhorroDolares(0)
    );

    private Cuenta cuentaActual;
    private Usuario usuario = new Usuario();

    // métodos
    public void menuPrincipal() {
        while (true) {
            System.out.println("1. Elegir tipo de cuenta");
            System.out.println("2. Cambiar contraseña");

            switch (obtenerNumero(sc.nextLine())) {
                case 1:
                    if (menuEleccionCuenta()) {
                        menuCuenta();
                    }
                    break;
                case 2:
                    this.cambiarContrasenia();
                    break;
                default:
                    System.out.println("Opción inválida");
            }

        }
    }

    public boolean menuEleccionCuenta() {
        System.out.println("1. Caja corriente");
        System.out.println("2. Caja de ahorro en pesos");
        System.out.println("3. Caja de ahorro en dólares");

        boolean cuentaValida = true;
        switch (obtenerNumero(sc.nextLine())) {
            case 1:
                this.cuentaActual = cuentas.get("CAJA CORRIENTE");
                break;
            case 2:
                this.cuentaActual = cuentas.get("CAJA EN PESOS");
                break;
            case 3:
                this.cuentaActual = cuentas.get("CAJA EN DOLARES");
                break;
            default:
                System.out.println("Opción inválida");
                cuentaValida = false;
        }

        return cuentaValida;
    }

    public void menuCuenta() {
        while (true) {
            System.out.println("1. Mostrar saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Volver atrás");

            switch (obtenerNumero(sc.nextLine())) {
                case 1:
                    this.cuentaActual.mostrarSaldo();
                    break;
                case 2:
                    this.depositar();
                    break;
                case 3:
                    this.menuRetiro();
                    break;
                default: return;
            }
        }
    }

    public void menuRetiro() {
        System.out.println("1. Retirar $5000");
        System.out.println("2. Retirar $10.000");
        System.out.println("3. Retirar $20.000");
        System.out.println("4. Retirar $50.000");
        System.out.println("5. Retirar $100.000");
        System.out.println("6. Retirar otro monto.");

        switch (obtenerNumero(sc.nextLine())) {
            case 1:
                this.cuentaActual.retirar(5000);
                break;
            case 2:
                this.cuentaActual.retirar(10000);
                break;
            case 3:
                this.cuentaActual.retirar(20000);
                break;
            case 4:
                this.cuentaActual.retirar(50000);
                break;
            case 5:
                this.cuentaActual.retirar(100000);
                break;
            case 6:
                this.retirarPersonalizado();
                break;
            default:
                System.out.println("Opción inválida");
        }
    }

    public void retirarPersonalizado() {
        System.out.println("Monto a retirar: ");
        this.cuentaActual.retirar(obtenerNumero(sc.nextLine()));
    }

    /**
     * Retorna el número que representa el string o 0 en caso de no ser un número.
     *
     * */
    public Integer obtenerNumero(String str) {
        Integer valor = 0;

        if (str.matches("\\d+")) {
            valor = Integer.parseInt(str);
        }

        return valor;
    }

    public void depositar() {
        System.out.println("Monto a depositar: ");
        this.cuentaActual.depositar(obtenerNumero(sc.nextLine()));
    }

    public void cambiarContrasenia() {
        System.out.println("Ingrese la nueva contraseña: ");
        this.usuario.cambiarContrasenia(sc.nextLine());
    }
}
