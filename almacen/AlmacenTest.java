import static org.junit.jupiter.api.Assertions.*;

class AlmacenTest {
// @author Maria Montero

    @org.junit.jupiter.api.Test
    void recibirMercancia() {
        // Caso normal
        Almacen almacen = new Almacen(500);
        boolean resultado = almacen.recibirMercancia(100);
        assertEquals(true, resultado);
        assertEquals(600, almacen.getStockActual());

        //caso negativo
        Almacen almacen2 = new Almacen(800);
        boolean resultado2 = almacen2.recibirMercancia(300);
        assertEquals(false, resultado2);
        assertEquals(800, almacen2.getStockActual());

        // cantidad negativa o cero
        Almacen almacen3 = new Almacen(500);
        boolean resultado3 = almacen3.recibirMercancia(0);
        assertEquals(false, resultado3);
        assertEquals(500, almacen3.getStockActual());

        // caso limite
        Almacen almacen4 = new Almacen(900);
        boolean resultado4 = almacen4.recibirMercancia(100);
        assertEquals(true, resultado4);
        assertEquals(1000, almacen4.getStockActual());
    }

    @org.junit.jupiter.api.Test
    void enviarMercancia() {
        // Caso normal
        Almacen almacen = new Almacen(300);
        boolean resultado = almacen.enviarMercancia(200);
        assertEquals(true, resultado);
        assertEquals(100, almacen.getStockActual());

        //Caso negativo
        Almacen almacen2 = new Almacen(100);
        boolean resultado2 = almacen2.enviarMercancia(101);
        assertEquals(false, resultado2);
        assertEquals(100, almacen2.getStockActual());

        // Caso negativo o cero
        Almacen almacen3 = new Almacen(0);
        boolean resultado3 = almacen3.enviarMercancia(100);
        assertEquals(false, resultado3);
        assertEquals(0, almacen3.getStockActual());

        // Caso límite
        Almacen almacen4 = new Almacen(1000);
        boolean resultado4 = almacen4.enviarMercancia(1000);
        assertEquals(true, resultado4);
        assertEquals(0, almacen4.getStockActual());
    }

    @org.junit.jupiter.api.Test
    void transferirProductos() {
        // Caso normal
        Almacen origen = new Almacen(500);
        Almacen destino = new Almacen(0);
        boolean resultado = origen.transferirProductos(200, destino);
        assertEquals(true, resultado);
        assertEquals(300, origen.getStockActual());
        assertEquals(200, destino.getStockActual());

        // caso negativo o cero
        Almacen origen2 = new Almacen(0);
        Almacen destino2 = new Almacen(0);
        boolean resultado2 = origen2.transferirProductos(200, destino2);
        assertEquals(false, resultado2);
        assertEquals(0, origen2.getStockActual());
        assertEquals(0, destino2.getStockActual());

        // caso null
        Almacen origen3 = new Almacen(500);
        boolean resultado3 = origen3.transferirProductos(200, null);
        assertEquals(false, resultado3);
        assertEquals(500, origen3.getStockActual());

        // caso limite
        Almacen origen4 = new Almacen(1000);
        Almacen destino4 = new Almacen(1);
        boolean resultado4 = origen4.transferirProductos(999, destino4);
        assertEquals(true, resultado4);
        assertEquals(1, origen4.getStockActual());
        assertEquals(1000, destino4.getStockActual());


    }

    @org.junit.jupiter.api.Test
    void calcularPorcentajeOcupacion() {
        //caso 0
        Almacen almacen = new Almacen(0);
        assertEquals(0.0, almacen.calcularPorcentajeOcupacion(), 0.01);
        // caso limite
        Almacen almacen2 = new Almacen(1000);
        assertEquals(100,  almacen2.calcularPorcentajeOcupacion(), 0.01);

        //caso negativo
        Almacen almacen3 = new Almacen(-500);
        assertEquals(0, almacen3.calcularPorcentajeOcupacion(), 0.01);

        //caso normal
        Almacen almacen4 = new Almacen(800);
        assertEquals(80, almacen4.calcularPorcentajeOcupacion(), 0.01);
    }
}