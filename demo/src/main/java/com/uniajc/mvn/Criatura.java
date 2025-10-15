package com.uniajc.mvn;
// ------------------------------------
// 1. Clase Abstracta Criatura
// ------------------------------------
/**
 * Clase abstracta que define las características y comportamientos base de
 * cualquier criatura en el juego.
 */
public abstract class Criatura {
    protected String nombre;
    protected int salud;
    protected int fuerza;
    // Composición: La criatura puede tener un arma equipada
    protected Arma armaEquipada; 

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
        this.armaEquipada = null; // Inicialmente sin arma
    }

    // Métodos abstractos requeridos
    public abstract void atacar(Criatura objetivo);
    public abstract void defender(int dano);

    // Método concreto
    public boolean estaViva() {
        return salud > 0;
    }

    // Métodos para composición (equipar/desequipar arma)
    public void equiparArma(Arma arma) {
        this.armaEquipada = arma;
        System.out.println(this.nombre + " ha equipado " + arma.getNombre() + ".");
    }

    public void desequiparArma() {
        if (this.armaEquipada != null) {
            System.out.println(this.nombre + " ha desequipado " + this.armaEquipada.getNombre() + ".");
        }
        this.armaEquipada = null;
    }

    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public int getFuerza() { return fuerza; }
    

    public void setSalud(int salud) { this.salud = salud; }
    
        // Método para calcular el daño total considerando el arma equipada
    protected int calcularDanoTotal() {
        int danoBase = this.fuerza;
        if (armaEquipada != null) {
            danoBase += armaEquipada.getDanoAdicional();
            System.out.print(" (+ " + armaEquipada.getDanoAdicional() + " de daño por " + armaEquipada.getNombre() + ")");
        }
        return danoBase;
    }
}

// 2. Interfaces


//Interfaz para criaturas que pueden volar.

interface Volador {
    void volar();
    void aterrizar();
}

// Interfaz para criaturas con habilidades mágicas.

interface Magico {
    void lanzarHechizo(Criatura objetivo);
    void aprenderHechizo(String nombreHechizo);
}



//Armas que las criaturas pueden usar

class Arma {
    private String nombre;
    private int danoBase;

    public Arma(String nombre, int danoBase) {
        this.nombre = nombre;
        this.danoBase = danoBase;
    }

    public String getNombre() {
        return nombre;
    }

    
     //Devuelve el daño adicional proporcionado por el arma.
     
    public int getDanoAdicional() {
        return danoBase;
    }
    
    public void atacarConArma() {
        System.out.print("¡Ataca con " + this.nombre + "!");
    }
}