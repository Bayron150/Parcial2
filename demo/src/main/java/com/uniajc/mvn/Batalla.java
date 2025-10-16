package com.uniajc.mvn;

public class Batalla {

    
     //Simula una batalla por turnos entre dos criaturas.
     
    public static void simularBatalla(Criatura c1, Criatura c2) {
        System.out.println("\n========================================");
        System.out.println("¡COMIENZA LA BATALLA!");
        System.out.println(c1.getNombre() + " (" + c1.getClass().getSimpleName() + " - Salud: " + c1.getSalud() + ") vs " + 
                           c2.getNombre() + " (" + c2.getClass().getSimpleName() + " - Salud: " + c2.getSalud() + ")");
        System.out.println("========================================");

        int turno = 1;
        Criatura atacante = c1;
        Criatura defensor = c2;

        while (c1.estaViva() && c2.estaViva()) {
            System.out.println("\n--- Turno " + turno + " ---");

            // interfaces y composición en la batalla
            if (atacante instanceof Volador) {
                ((Volador) atacante).volar();
            }

            atacante.atacar(defensor);


            if (atacante instanceof Volador) {
                ((Volador) atacante).aterrizar(); // <--- Aterrizaje añadido aquí
            }

            
            if (atacante instanceof Magico) {
                // El Mago tiene su propia lógica de ataque que llama a lanzarHechizo
            }
            
            // Cada criatura atacará según su implementación
            

            // Revertir roles para el siguiente turno
            Criatura temp = atacante;
            atacante = defensor;
            defensor = temp;
            
            turno++;
        }

        System.out.println("\n========================================");
        System.out.println("¡BATALLA TERMINADA!");
        if (c1.estaViva()) {
            System.out.println(" El ganador es: " + c1.getNombre() + " con " + c1.getSalud() + " de salud restante.");
        } else {
            System.out.println(" El ganador es: " + c2.getNombre() + " con " + c2.getSalud() + " de salud restante.");
        }
        System.out.println("========================================");
    }
}