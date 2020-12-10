package agenda;

import java.time.LocalDate;
import java.util.*;

/**
 * Description : An agenda that stores events
 */
public class Agenda {

    private ArrayList<Event> myEvents = new ArrayList<>();

    /**
     * Adds an event to this agenda
     *
     * @param e the event to add
     */
    public void addEvent(Event e) {
        myEvents.add(e);
    }

    /**
     * Computes the events that occur on a given day
     *
     * @param day the day toi test
     * @return and iteraror to the events that occur on that day
     */
    public List<Event> eventsInDay(LocalDate day) {
        ArrayList<Event> myEventsInDay = new ArrayList<>();
        for (Event e : myEvents) {
            if (e.isInDay(day)) {
                myEventsInDay.add(e);
            }
        }
        return myEventsInDay;
    }

    /**
     * Trouver les événements de l'agenda en fonction de leur titre
     *
     * @param title le titre à rechercher
     * @return les événements qui ont le même titre
     */
    public List<Event> findByTitle(String title) {
        ArrayList<Event> myEventsByTitle = new ArrayList<>();
        for (Event e : myEvents) {
            if (e.getTitle().equals(title)) {
                myEventsByTitle.add(e);
            }
        }
        return myEventsByTitle;
    }

    /**
     * Déterminer s’il y a de la place dans l'agenda pour un événement
     *
     * @param e L'événement à tester (on se limitera aux événements simples)
     * @return vrai s’il y a de la place dans l'agenda pour cet événement
     */
    public boolean isFreeFor(Event e) {
        for (Event ev : myEvents) {
            if (myEvents.isEmpty()) {
                return true;
            }
            if (ev.getStart().plus(ev.getDuration()).isAfter(e.getStart()) && ev.getStart().isBefore(e.getStart().plus(e.getDuration()))) {
                return false;
            }
            if (ev.getStart().isBefore(e.getStart().plus(e.getDuration())) && ev.getStart().isAfter(e.getStart())) {
                return false;
            }
            if (ev.getStart().isEqual(e.getStart()) || ev.getStart().plus(ev.getDuration()).isEqual(e.getStart().plus(e.getDuration()))) {
                return false;
            }
           if (ev.getStart().isAfter(e.getStart()) && ev.getStart().plus(ev.getDuration()).isBefore(e.getStart().plus(e.getDuration()))) {
               return false;
            }
        }
        return true;
    }
}
