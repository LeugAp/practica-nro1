/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import controller.util.Util;
import java.time.LocalDateTime;

/**
 *
 * @author miguel
 */
public class Action {
    private String description;
    private LocalDateTime time;
    
    public Action () {
        this.time = LocalDateTime.now();
    }
    
    public Action (String description) {
        this.description = description;
        this.time = LocalDateTime.now();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "[" + description + " , "+ Util.getTime(time) + " ]";
    }
    
    
}
