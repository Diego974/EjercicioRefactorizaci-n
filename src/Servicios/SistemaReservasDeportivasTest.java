package Servicios;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

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
		LocalDateTime fecha = LocalDateTime.now();
		assertTrue(sistemaReservas.reservarPista(1, fecha,60));
		assertFalse(sistemaReservas.reservarPista(1, fecha, 60));
		assertTrue(sistemaReservas.reservarPista(2, fecha, 60));
		assertTrue(sistemaReservas.reservarPista(3, fecha.plusDays(1), 60));
		assertTrue(sistemaReservas.reservarPista(10, fecha.plusDays(1), 60));
			
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
