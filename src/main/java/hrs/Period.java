/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hrs;

import java.time.LocalDate;

/**
 * @author kiper
 */
public interface Period {
    LocalDate getStartDate();

    LocalDate getEndDate();
}