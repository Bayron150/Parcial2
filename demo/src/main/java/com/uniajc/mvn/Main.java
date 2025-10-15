package com.uniajc.mvn;

public class Main {
    public static void main(String[] args) {
        // 1. Creación de armas
        Arma espada = new Arma("Espada Larga", 15);
        Arma baculo = new Arma("Báculo de Roble", 10);
        
        // 2. Creación de criaturas
        Dragon Shyvana = new Dragon("Shyvana", 200, 20);
        Mago Boldemord = new Mago("Boldemord", 120, 30); 
        Guerrero Dave = new Guerrero("Dave", 150, 25);

        // 3. Demostrar habilidades y composición
        Shyvana.equiparArma(espada);
        Boldemord.equiparArma(baculo);
        ((Magico) Boldemord).aprenderHechizo("Bola de Fuego");
        
        // El Dragón usa sus habilidades de Volador
        ((Volador) Shyvana).volar();
        ((Volador) Shyvana).aterrizar();

        System.out.println("\n--- Batalla 1: Dave vs Boldemord ---");
        Batalla.simularBatalla(Dave, Boldemord);

        Shyvana = new Dragon("Shyvana", 200, 20);
        Boldemord = new Mago("Boldemord", 120, 30);
        Shyvana.equiparArma(espada);
        Boldemord.equiparArma(baculo);

        System.out.println("\n--- Batalla 2: Shyvana vs Boldemord ---");
        Batalla.simularBatalla(Shyvana, Boldemord);
    }
}