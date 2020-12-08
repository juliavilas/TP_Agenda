package agenda;

import java.util.*;
import java.time.*;
import java.time.temporal.ChronoUnit;

/**
 * Description : A repetitive Event
 */
public class RepetitiveEvent extends Event {
    
    protected ChronoUnit frequency;
    /**
     * Constructs a repetitive event
     *
     * @param title the title of this event
     * @param start the start of this event
     * @param duration myDuration in seconds
     * @param frequency one of :
     * <UL>
     * <LI>ChronoUnit.DAYS for daily repetitions</LI>
     * <LI>ChronoUnit.WEEKS for weekly repetitions</LI>
     * <LI>ChronoUnit.MONTHS for monthly repetitions</LI>
     * </UL>
     */
    
    public RepetitiveEvent(String title, LocalDateTime start, Duration duration, ChronoUnit frequency) {
        super(title, start, duration);
        this.frequency=frequency;
        LocalDateTime nextStart = start.plus(1, frequency);
        int i = 0;
        while(i < 366){
            RepetitiveEvent nextEvent = new RepetitiveEvent(title,nextStart,duration,frequency);
            i++;
        }
    }
    
    

   
           
    /**
     * Adds an exception to the occurrence of this repetitive event
     *
     * @param date the event will not occur at this date
     */
    public void addException(LocalDate date){
        if(this.isInDay(date)){
            throw new UnsupportedOperationException("Pas encore implémenté");
        }
    }

    /**
     *
     * @return the type of repetition
     */
    public ChronoUnit getFrequency() {
        return frequency;  
    }

}
