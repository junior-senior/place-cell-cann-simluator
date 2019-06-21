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
//Class to create every landmark from.
public class Landmarks {
    
    private int size; //Only used for landmark identifcation purposes
    private int xCoor; //bottom right corner
    private int yCoor;
    
    public Landmarks(int a, int b, int c){
        this.size=a;
        this.xCoor=b;
        this.yCoor=c;
    }
    public int getxCoor() {
        return xCoor;
    }
    public int getyCoor() {
        return yCoor;
    }
    public int getSize(){
        return size;
    }
}
