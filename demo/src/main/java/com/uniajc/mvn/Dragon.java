package com.uniajc.mvn;

class Dragon extends Criatura implements Volador {
    public Dragon(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    @Override
    public void atacar(Criatura objetivo) {
        int danoTotal = this.fuerza * 2; // Se duplica la fuerza del Dragón

        System.out.print("\nEl Dragón " + this.nombre + " lanza un Aliento de Fuego (fuerza x 2)");

        // Incluir daño del arma si está equipada
        if (armaEquipada != null) {
            armaEquipada.atacarConArma();
            danoTotal += armaEquipada.getDanoAdicional();
            System.out.print(" (+ " + armaEquipada.getDanoAdicional() + " de daño por arma)");
        }
        
        System.out.print(" inflige " + danoTotal + " de daño a " + objetivo.getNombre());
        objetivo.defender(danoTotal);
    }

    @Override
    public void defender(int dano) {
        int danoRecibido = dano;
        // La defensa del dragón podría ser más alta, por ejemplo, 10% de reducción
        danoRecibido = (int) (danoRecibido * 0.9);
        this.salud -= danoRecibido;
        System.out.print(" pero " + this.nombre + " resiste. Salud restante: " + this.salud);
    }

    // Métodos de la interfaz Volador
    @Override
    public void volar() {
        System.out.println("Acción: " + this.nombre + " se eleva majestuosamente.");
    }

    @Override
    public void aterrizar() {
        System.out.println("\nAcción: " + this.nombre + " aterriza pesadamente.");
    }

}

class Mago extends Criatura implements Magico {
    public Mago(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    @Override
    public void atacar(Criatura objetivo) {
        lanzarHechizo(objetivo);
    }

    @Override
    public void defender(int dano) {
        this.salud -= dano;
        System.out.print(". Salud restante: " + this.salud);
    }

    @Override
    public void lanzarHechizo(Criatura objetivo) {
        int danoTotal = calcularDanoTotal();
        
        System.out.print("\nMago " + this.nombre + " lanza un Hechizo Arcano (fuerza)");
        System.out.print(" inflige " + danoTotal + " de daño a " + objetivo.getNombre());
        objetivo.defender(danoTotal);
    }

        @Override
    public void aprenderHechizo(String nombreHechizo) {
        System.out.println("Acción: " + this.nombre + " ha aprendido el hechizo: " + nombreHechizo + ".");
    }


}


class Guerrero extends Criatura {
    public Guerrero(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    @Override
    public void atacar(Criatura objetivo) {
        int danoTotal = calcularDanoTotal();
        
        System.out.print("\nEl Guerrero " + this.nombre + " ataca con su espada (fuerza)");
        System.out.print(" inflige " + danoTotal + " de daño a " + objetivo.getNombre());
        objetivo.defender(danoTotal);
    }

    @Override
    public void defender(int dano) {
        // La defensa del guerrero es Normal
        this.salud -= dano;
        System.out.print(". Salud restante: " + this.salud);
    }


}