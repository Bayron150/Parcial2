package Prueba_Batalla;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PruebaCriatura {
    
    private Dragon dragon;
    private Mago mago;
    private Arma espada;

    @BeforeEach
    void setUp() {
        // Inicializar objetos
        dragon = new Dragon("Falkor", 100, 10); 
        mago = new Mago("Merlin", 50, 5);
        espada = new Arma("Espada Corta", 5);
    }

    @Test
    void testEstaVivaInicialmente() {
        // Requisito 1: estaViva()
        assertTrue(dragon.estaViva(), "El dragón debe estar vivo al inicio.");
    }

    @Test
    void testCriaturaMuere() {
        // Simular un daño muy grande para matar a la criatura
        dragon.setSalud(-10); // Establecer salud a un valor no positivo
        assertFalse(dragon.estaViva(), "El dragón no debe estar vivo con salud <= 0.");
    }

    @Test
    void testAtaqueYDefensa_MagoAtaque() {
        // Mago (Fuerza 5) ataca a Dragón (Salud 100).
        // El ataque base del Mago es su Fuerza (5).
        // El Dragón tiene reducción del 10% en defensa (daño 5 * 0.9 = 4.5 -> 4).
        
        mago.atacar(dragon); 
        // 100 - 4 = 96
        assertEquals(96, dragon.getSalud(), "El dragón debe perder 4 de salud (5 * 0.9).");
    }

    @Test
    void testAtaqueYDefensa_DragonAtaque() {
        // Dragón (Fuerza 10 -> Ataque 20) ataca a Mago (Salud 50).
        // El Mago tiene defensa estándar (daño 20).
        
        dragon.atacar(mago);
        // 50 - 20 = 30
        assertEquals(30, mago.getSalud(), "El mago debe perder 20 de salud.");
    }

    @Test
    void testComposicion_EquiparArma() {
        // Requisito 3 y 4: Composición
        dragon.equiparArma(espada);
        // Dragón (Fuerza 10 -> Ataque 20) + Arma (Daño 5) = Daño 25
        // El Mago tiene defensa estándar (daño 25).
        
        dragon.atacar(mago);
        // 50 - 25 = 25
        assertEquals(25, mago.getSalud(), "El mago debe perder 25 de salud debido al arma equipada.");
    }

    @Test
    void testInterfazVolador() {
        // Requisito 2: Interfaz Volador
        assertTrue(dragon instanceof Volador, "El Dragón debe implementar Volador.");
        // Aunque los métodos 'volar' y 'aterrizar' solo imprimen, se prueba que la interfaz esté implementada.
        // Las pruebas unitarias de métodos con efectos colaterales (como imprimir) se centran en verificar
        // que la lógica principal (en este caso, la herencia) sea correcta.
        // Se puede usar System.out.capture() para verificar la salida si fuera crítico.
    }
}