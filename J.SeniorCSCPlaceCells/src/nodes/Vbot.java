/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nodes;

public class Vbot {

    private int xCoor;
    private int yCoor;
    private int length;

    public Vbot(int a, int b) {
        this.xCoor = a;
        this.yCoor = b;
        this.length = 10;
    }

    public int getxCoor() {
        return xCoor;
    }

    public void setxCoor(int xCoor) {
        this.xCoor = xCoor;
    }

    public int getyCoor() {
        return yCoor;
    }

    public void setyCoor(int yCoor) {
        this.yCoor = yCoor;
    }

    public int getLength() {
        return length;
    }

    public void move(int x) {
        if (x == 1) {
            xCoor += 12;
        }
        if (x == 2) {
            yCoor -= 12;
        }
        if (x == 3) {
            xCoor -= 12;
        }
        if (x == 4) {
            yCoor += 12;
        }
    }
}
