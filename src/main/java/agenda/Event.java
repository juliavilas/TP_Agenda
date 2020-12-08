package agenda;

import java.time.*;

public class Event {

    /**
     * The myTitle of this event
     */
    private String myTitle;
    
    /**
     * The starting time of the event
     */
    private LocalDateTime myStart;

    /**
     * The durarion of the event 
     */
    private Duration myDuration;


    /**
     * Constructs an event
     *
     * @param title the title of this event
     * @param start the start time of this event
     * @param duration the duration of this event
     */
    public Event(String title, LocalDateTime start, Duration duration) {
        this.myTitle = title;
        this.myStart = start;
        this.myDuration = duration;
    }

    /**
     * Calcule la date et l'heure de fin de l'événement
     * @return la date et l'heure de fin de l'événement
     */
    public LocalDateTime getFinishDateTime(){
        LocalDateTime finishDateTime = myStart;
        long myMinutes = myStart.toLocalTime().getMinute() + myDuration.toMinutes();
        long myHours = myStart.toLocalTime().getHour();
        long myDays = 0;
        System.out.println("minutes non régularisées = " + myMinutes);
        while (myMinutes >= 60){
            myMinutes -= 60;
            myHours ++;
        }
        
            System.out.println("minutes régularisées = " + myMinutes);
            System.out.println("heure non régularisées = " + myHours);
        while (myHours >= 24){
            myHours -= 24;
            myDays++;
        }
        System.out.println("heures régularisées = " + myHours);
        System.out.println("jours = " + myDays);
        
        finishDateTime.plusDays(myDays);
        finishDateTime.withHour((int)myHours);
        finishDateTime.withMinute((int)myMinutes);
       
        System.out.println(finishDateTime);

//        finishDateTime.plus(myDuration.);
        return finishDateTime;
        
        // !!! La date de fin n'est pas correctement incrémentée
    }
    
    /**
     * Tests if an event occurs on a given day
     *
     * @param aDay the day to test
     * @return true if the event occurs on that day, false otherwise
     */
    public boolean isInDay(LocalDate aDay) {
        boolean inDay = false;
        if(aDay.isEqual(myStart.toLocalDate()) || aDay.isEqual(this.getFinishDateTime().toLocalDate())){
            inDay = true;
        }
        else if(aDay.isAfter(myStart.toLocalDate()) && aDay.isBefore(this.getFinishDateTime().toLocalDate())){
            inDay = true;
        }
        return inDay;
    }
   
    /**
     * @return the myTitle
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * @return the myStart
     */
    public LocalDateTime getStart() {
        return myStart;
    }


    /**
     * @return the myDuration
     */
    public Duration getDuration() {
        return myDuration;
    }

    @Override
    public String toString(){
        return "Event title : " + this.getTitle();
    }
    
}
