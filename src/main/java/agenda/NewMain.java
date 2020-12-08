/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agenda;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Denoëla
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Duration min_120 = Duration.ofMinutes(120);
       LocalDateTime nov_1__2020_22_30 = LocalDateTime.of(2020, 11, 1, 22, 30);
       Event overlapping = new Event("Overlapping event", nov_1__2020_22_30, min_120);
       System.out.println(overlapping.getFinishDateTime());
    }
    
}
