/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.preexamenhilos;

import static java.lang.Thread.sleep;
import javax.swing.JLabel;

/**
 *
 * @author Nightm4re
 */
public class hilorefrigerador extends Thread {

    JLabel deseada;
    JLabel actual;
    
    boolean running;

    private volatile boolean exit = false;

    public hilorefrigerador(JLabel deseada, JLabel actual) {

        this.deseada = deseada;
        this.actual = actual;

    }

    public void run() {

        while (true) {
            if (!exit) {
                System.out.println("Hilo frio -1");

                int tempdes = Integer.parseInt(deseada.getText());
                int tempact = Integer.parseInt(actual.getText());
                System.out.println(Integer.toString(tempact - 1));
                actual.setText(Integer.toString(tempact - 1));
//            if(tempact > tempdes+5){
//                try {
//                    wait();
//                } catch (Exception e) {
//                }
//                
//            }

                try {
                    sleep(500);
                } catch (Exception e) {
                }

            }else{
                while(exit){
                    try{
                    wait();
                }
                
            }
            
        }

    }

    public void stopthread() {
        exit = true;
    }

    public void resumeThread() {
        exit = false;
    }

    public boolean isStopped() {
        return this.exit;
    }
}
