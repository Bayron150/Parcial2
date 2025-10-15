package com.uniajc.mvn;

public class Magico {
    // Atributos
    private String nombre;
    private int salud;
    private int fuerza;

    // Constructor
    public Magico(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    // Métodos
    public void atacar(Criatura objetivo) {
        // Lógica de ataque
    }

    public void defender(int dano) {
        // Lógica de defensa
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }
}
