package com.uniajc.mvn;

public class Guerrero {
    private String nombre;
    private int salud;
    private int fuerza;

    public Guerrero(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    public void atacar() {
        System.out.println(nombre + " ataca con fuerza " + fuerza);
    }

    public void recibirDanio(int danio) {
        salud -= danio;
        System.out.println(nombre + " recibe " + danio + " puntos de daño.");
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}
