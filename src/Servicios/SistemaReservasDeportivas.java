package Servicios;

import java.util.ArrayList;
import java.util.List;

import Entidades.Reserva;

/**
 * Sistema de Reservas Deportivas que gestiona la reserva de pistas deportivas y la activación de la iluminación en ellas.
 */
public class SistemaReservasDeportivas {

    private List<Reserva> reservas;
    private boolean[] iluminacion;
    private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

    /**
     * Constructor que inicializa la lista de reservas y el estado de la iluminación.
     */
    public SistemaReservasDeportivas() {
        reservas = new ArrayList<>();
        iluminacion = new boolean[MAX_PISTAS];
    }

    /**
     * Reserva una pista deportiva en una fecha específica.
     * 
     * @param idPista  Identificador de la pista a reservar.
     * @param fecha    Fecha de la reserva.
     * @param duracion Duración de la reserva en horas.
     * @return true si la reserva fue exitosa, false si la pista ya está reservada o el ID es inválido.
     */
    public boolean reservarPista(int idPista, String fecha, int duracion) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista ya está reservada en esa fecha
            }
        }
        reservas.add(new Reserva(idPista, fecha, duracion));
        return true;
    }

    /**
     * Cancela una reserva existente.
     * 
     * @param idReserva Identificador de la reserva a cancelar.
     * @return true si la reserva fue encontrada y eliminada, false si no se encontró.
     */
    public boolean cancelarReserva(int idReserva) {
        for (int i = 0; i < reservas.size(); i++) {
            if (reservas.get(i).getIdPista() == idReserva) {
                reservas.remove(i);
                return true;
            }
        }
        return false; // No se encontró la reserva
    }

    /**
     * Activa la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación fue activada, false si el ID de pista es inválido.
     */
    public boolean activarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = true;
        return true;
    }

    /**
     * Desactiva la iluminación de una pista específica.
     * 
     * @param idPista Identificador de la pista.
     * @return true si la iluminación fue desactivada, false si el ID de pista es inválido.
     */
    public boolean desactivarIluminacion(int idPista) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        iluminacion[idPista] = false;
        return true;
    }

    /**
     * Verifica la disponibilidad de una pista en una fecha y hora determinadas.
     * 
     * @param idPista Identificador de la pista.
     * @param fecha   Fecha en la que se desea verificar la disponibilidad.
     * @param hora    Hora en la que se desea verificar la disponibilidad.
     * @return true si la pista está disponible, false si ya está reservada.
     */
    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {
        if (idPista < 0 || idPista >= MAX_PISTAS) {
            return false; // ID de pista inválido
        }
        for (Reserva r : reservas) {
            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
                return false; // La pista no está disponible en esa fecha
            }
        }
        return true; // La pista está disponible
    }
}