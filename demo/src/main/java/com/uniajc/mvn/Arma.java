package com.uniajc.mvn;

public class Arma {
    private String nombre;
    private int danoBase;

    public Arma(String nombre, int danoBase) {
        this.nombre = nombre;
        this.danoBase = danoBase;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Devuelve el daño adicional proporcionado por el arma.
     */
    public int getDanoAdicional() {
        // Podríamos tener lógica de daño más compleja aquí. Por ahora, es el daño base.
        return danoBase;
    }

    public void atacarConArma() {
        System.out.print("¡Ataca con " + this.nombre + "!");
    }
}
