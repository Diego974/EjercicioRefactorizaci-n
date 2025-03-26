package Servicios;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SistemaReservasDeportivasTest {
	static SistemaReservasDeportivas sistemaReservas;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sistemaReservas = new SistemaReservasDeportivas();
	}

	@Test
	void testReservarPista() {
		
		assertTrue(sistemaReservas.reservarPista(1, "21-03-2025 20:00", 60));
		assertFalse(sistemaReservas.reservarPista(1, "21-03-2025 20:00", 60));
		assertTrue(sistemaReservas.reservarPista(2, "21-03-2025 20:00", 60));
		assertTrue(sistemaReservas.reservarPista(3, "22-03-2025 20:00", 60));
		assertTrue(sistemaReservas.reservarPista(10, "22-03-2025 20:00", 60));
			
		}

	@Test
	void testCancelarReserva() {
		
		assertTrue(sistemaReservas.cancelarReserva(1));
		assertFalse(sistemaReservas.cancelarReserva(2));
		assertTrue(sistemaReservas.cancelarReserva(3));
		assertTrue(sistemaReservas.cancelarReserva(4));
		assertTrue(sistemaReservas.cancelarReserva(5));
			
		}

}
