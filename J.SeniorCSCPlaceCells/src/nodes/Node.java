package nodes;

public class Node {

    private int xCoor;
    private int yCoor;
    private double activation;
    private double[][] synapticWeight;
    public double activationFiringRate, learningFiringRate;
    private double b = 0.1;
    private double alpha = -20.0;
    public int xCoormax;
    public int yCoormax;

    public Node(int x, int y, int a) {
        this.xCoor = x;
        this.yCoor = y;
        this.activation = a;

    }

    public void setXYMax(int x, int y) {
        xCoormax = x;  //This is found buy visual information from the landmarks somehow
        yCoormax = y;
    }

    public int getxCoormax() {
        return xCoormax;
    }

    public int getyCoormax() {
        return yCoormax;
    }

    public double getlearningFiringRate() {
        return learningFiringRate;
    }
    public double getactivationFiringRate() {
        return learningFiringRate;
    }

    public void setactivationFiringRate() {
        this.activationFiringRate = 1 / (1 + Math.exp((-2 * b) * (activation - alpha)));
    }
    public void setlearningFiringRate(double i){
        this.learningFiringRate = i;
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

    public double getActivation() {
        return activation;
    }

    public void setActivation(double activation) {
        this.activation = activation;
            //use set connection array to set activation of all other nodes

    }

    public double getConnections(int c, int d) {
        return synapticWeight[c][d];
    }

    public void updateConnection(int i, int j, double swu) {
        synapticWeight[i][j] += swu;
    }

    public void setConnection(int c, int d, int s) {
        int i;
        int j;
        double dx;
        double dy;
        i = this.getxCoor();
        j = this.getyCoor();
        double dxy = 0.0;
        synapticWeight = new double[c][d];
        for (int h = 0; h < c + 100; h++) {
            for (int g = 0; g < d + 100; g++) {
                if (h >= 0 && h < c && g >= 0 && g < d && h % (6 * s) == 0 && g % (6 * s) == 0) {
                    if (i > h) {
                        dx = ((i - h) / 6 * s);
                    } else {
                        dx = ((h - i) / 6 * s);
                    }
                    if (j >= g) {
                        dy = ((j - g) / 6 * s);
                    } else {
                        dy = ((g - j) / 6 * s);
                    }
                    if (dx == 0.0) {
                        //dxy = Math.pow(dy, 2); //x^2
                        dxy = dy;
                    } else if (dy == 0.0) {
                        // dxy = Math.pow(dx, 2); //x^2
                        dxy = dx;
                    } else if (dx != 0 && dy != 0) {
                        double xy = Math.pow(dx, 2) + Math.pow(dy, 2);
                        double xyroot = Math.pow(xy, 0.5);
                        dxy = xyroot; //x^2
                    }
                    double dxy2 = Math.pow(dxy, 2);
                    double piSTDV = (2 * Math.PI * 0.025);
                    double sW = (1 / (Math.pow(piSTDV, 0.5))) * Math.exp(-(dxy2 / 2 * 0.05));

                 //double efunc = Math.exp(-0.5 * dxy);
                    // double sW = ((1 - dxy) * efunc);
                    if (h > c) {
                        h = c - 400;
                    }
                    if (g > d) {
                        g = d - 400;
                    }
                    try {
                        synapticWeight[h][g] = sW;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        break;
                    }
                }
            }
        }

    }
}
