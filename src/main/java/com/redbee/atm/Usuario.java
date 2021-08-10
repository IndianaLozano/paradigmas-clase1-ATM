package com.redbee.atm;

public class Usuario {
    private String contraseña = "123";

    public void cambiarContrasenia(String nuevaContrasenia) {
        if (nuevaContrasenia != null) {
            this.contraseña = nuevaContrasenia;
        }
    }
}
