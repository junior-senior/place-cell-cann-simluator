/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

/**
 *
 * @author jake2314
 */
public class Run {

    UI2 ui;

    public Run() {
        
        ui = new UI2();

        ui.CANN.initCells();
        ui.CANN.initConnections();
        ui.CANN.environment.initvBot();
        ui.CANN.environment.initLandmarks();
        ui.CANN.environment.vBotandLandmarks();
         ui.jTextArea1.append("Please Press 'Learn Environment' to begin.");
        }
    public void update(){
      
            
            
    }
    }


