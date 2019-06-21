package nodes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.*;
import javax.swing.*;

public class CANN {

    Environment environment = new Environment(200, 200, 2);
    private int width, height, scale;
    //Constants for activation
    private double phi0 = 1.66122155;
    private double cP = 1110.00;
    public Node node;
    Node[][] nodeArray;
    int counter;
    boolean vision;
    public int mouseX, mouseY, mouseX2, mouseY2, mouseX3, mouseY3, vbotyCoor;
    private BufferedImage image;
    public BufferedImage scaledImage;
    private WritableRaster raster;
    private ColorModel colourModel;
    public double I, sWsum, I0;
    JFrame imageFrame = new JFrame("Continous Attractor Neural Network");
    ImagePanel imagePanel;
    Timer timer;

    public CANN(int width, int height, int scale) {
        this.width = width * scale;
        this.height = height * scale;
        this.scale = scale;
        nodeArray = new Node[width * scale][height * scale];
        image = new BufferedImage(width * scale, height * scale, BufferedImage.TYPE_INT_RGB);
        raster = image.getRaster();
        colourModel = image.getColorModel();
        scaledImage = new BufferedImage((scale * width), ((scale * height) + 22), BufferedImage.TYPE_INT_RGB);
        imagePanel = new ImagePanel(scaledImage);
        imageFrame.add(imagePanel);
        imageFrame.setSize(((width * scale)+40), ((scale * height) + 40));
        imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageFrame.setVisible(true);
        imagePanel.setVisible(true);
        vision = true;
        //  imageFrame.addMouseListener(new NodeMouseListener());
        timer = new Timer(100, new MyTimerActionListener());
        //  imageFrame.addMouseMotionListener(new NodeMouseMotionListener());

    }

    //Timer representing the Activation Equation (Equation 2.5)
    class MyTimerActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (vision == true) {
                I += 0.05;
                double sW = 0;
                double a = 0, ba = 0;
                double f;
                int pcmfx = 0, pcmfy = 0, counter = 0, px = 0, py = 0;
                mouseX2 = mouseX;
                mouseY2 = mouseY;
                mouseX3 = mouseX;
                mouseY3 = mouseY;

                //CODE FOR DIRECTION + DISTANCE TO LM GOES HERE, CONVERT TO X AND Y COOR
                for (int x = mouseX2 - (6 * scale); x <= mouseX2 + (6 * scale); x++) {
                    if (mouseX2 % (6 * scale) == 0) {
                        break;
                    }

                    if (x % (6 * scale) == 0) {
                        mouseX2 = x;
                        break;
                    }

                }
                for (int y = mouseY2 - (6 * scale); y <= mouseY2 + (6 * scale); y++) {
                    if (mouseY2 % (6 * scale) == 0) {
                        break;
                    }
                    if (y % (6 * scale) == 0) {
                        mouseY2 = y;
                        break;
                    }
                }

                try {

                    for (int i = 0; i < width; i++) {
                        for (int j = 0; j < height; j++) {
                            a = 0;
                            if (i % (6 * scale) == 0 && j % (6 * scale) == 0 && I <= 0.4) {
                                if (mouseX2 < 14 || mouseY2 < 9 || mouseX2 >= (width - 14) || mouseY2 >= (height - 9)) {
                                    break;
                                }

                                //    if(vision == true){
                                pcmfx = nodeArray[i][j].xCoormax;
                                pcmfy = nodeArray[i][j].yCoormax;
                                //    }
                                int vbx = environment.vbot.getxCoor();
                                int vby = environment.vbot.getyCoor();
                                int sia;
                                int sib;
                                int sit;
                                if (pcmfx > vbx) {          //Calculate the distance between the vbot and the 
                                    sia = (pcmfx - vbx);   //place the vbot needs to be for cell [i][j] to fire maximally
                                } else {
                                    sia = (vbx - pcmfx);
                                }
                                if (pcmfy > vby) {
                                    sib = (pcmfy - vby);
                                } else {
                                    sib = (vby - pcmfy);
                                }

                                sit = sia + sib;
                                if (sit < 400) {
                                    sWsum = 0;
                                    for (int k1 = 0; k1 < 400; k1++) {
                                        for (int l1 = 0; l1 < 400; l1++) {
                                            if (k1 % (6 * scale) == 0 && l1 % (6 * scale) == 0) {   //Place Cell Activation Equation, Equation 2.6 calculation)
                                                sW = nodeArray[i][j].getConnections(k1, l1);
                                                sW -= 0.25;
                                                nodeArray[k1][l1].setactivationFiringRate();
                                                f = nodeArray[k1][l1].getactivationFiringRate();
                                                sW *= f;
                                                sWsum += sW;
                                            }
                                        }
                                    }
                                }
                                a = (((phi0 / cP) * (sWsum) + I));
                                if (a > ba) {
                                    ba = a;
                                    counter = 0;
                                    px = i;
                                    py = j;
                                }
                                if (a == ba) {
                                    counter++;
                                }
                                nodeArray[i][j].setActivation(a);
                                if (sit > 400) {
                                    nodeArray[i][j].setActivation(0);
                                }

                            }
                        }
                    }

                } catch (NullPointerException exception) {

                }
            }
        }

    }

    //Update the Place Cells (From Theo's Game of Life)  
    public void updateGridImage() {
        if (vision == true) {
            if (I < 0.4) {
                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {
                        int i1 = i;
                        int j1 = j;
                        int ii = i;
                        int jj = j;
                        if ((i < 0) || (i >= width) || (j < 0) || (j >= height)) {
                            if (ii < 0) {
                                ii += width;
                                i1 = ii;
                            } else if (ii >= width) {
                                ii -= width;
                                i1 = ii;
                            }
                            if (jj < 0) {
                                jj += height;
                                j1 = jj;
                            } else if (jj >= height) {
                                jj -= height;
                                j1 = jj;
                            }
                        }
                        if (nodeArray[i1][j1] != null && nodeArray[i1][j1].getActivation() >= 1.0) {
                            for (int k = i1 - 11; k < i1 + 1; k++) {
                                for (int l = j1 - 11; l < j1 + 1; l++) {
                                    setCellColour(k, l, 1.0F, 0.0F, 0.0F);
                                }
                            }
                        } else if (nodeArray[i1][j1] != null && nodeArray[i1][j1].getActivation() >= 0.95 && nodeArray[i1][j1].getActivation() < 1.0) {
                            for (int k = i1 - 11; k < i1 + 1; k++) {
                                for (int l = j1 - 11; l < j1 + 1; l++) {
                                    setCellColour(k, l, 1.0F, 0.271F, 0.0F);
                                }
                            }

                        } else if (nodeArray[i1][j1] != null && nodeArray[i1][j1].getActivation() >= 0.9 && nodeArray[i1][j1].getActivation() < 0.95) {
                            for (int k = i1 - 11; k < i1 + 1; k++) {
                                for (int l = j1 - 11; l < j1 + 1; l++) {
                                    setCellColour(k, l, 1.0F, 0.647F, 0.0F);
                                }
                            }
                        } else if (nodeArray[i1][j1] != null && nodeArray[i1][j1].getActivation() >= 0.85 && nodeArray[i1][j1].getActivation() < 0.9) {
                            for (int k = i1 - 11; k < i1 + 1; k++) {
                                for (int l = j1 - 11; l < j1 + 1; l++) {
                                    setCellColour(k, l, 1.0F, 1.0F, 0.0F);
                                }
                            }
                        } else if (nodeArray[i1][j1] != null && nodeArray[i1][j1].getActivation() >= 0.8 && nodeArray[i1][j1].getActivation() < 0.85) {
                            for (int k = i1 - 11; k < i1 + 1; k++) {
                                for (int l = j1 - 11; l < j1 + 1; l++) {
                                    setCellColour(k, l, 0.5F, 1.0F, 0.0F);
                                }
                            }
                        } else if (nodeArray[i1][j1] != null && nodeArray[i1][j1].getActivation() >= 0.75 && nodeArray[i1][j1].getActivation() < 0.8) {
                            for (int k = i1 - 11; k < i1 + 1; k++) {
                                for (int l = j1 - 11; l < j1 + 1; l++) {
                                    setCellColour(k, l, 0.25F, 1.0F, 0.0F);
                                }
                            }
                        } else if (nodeArray[i1][j1] != null && nodeArray[i1][j1].getActivation() >= 0.45 && nodeArray[i1][j1].getActivation() < 0.75) {
                            for (int k = i1 - 11; k < i1 + 1; k++) {
                                for (int l = j1 - 11; l < j1 + 1; l++) {
                                    setCellColour(k, l, 0.0F, 0.0F, 1.0F);
                                }
                            }
                        } else if (nodeArray[i1][j1] != null && nodeArray[i1][j1].getActivation() >= 0.4 && nodeArray[i1][j1].getActivation() < 0.45) {
                            for (int k = i1 - 11; k < i1 + 1; k++) {
                                for (int l = j1 - 11; l < j1 + 1; l++) {
                                    setCellColour(k, l, 0.0F, 0.0F, 0.75F);
                                }
                            }
                        } else if (nodeArray[i1][j1] != null && nodeArray[i1][j1].getActivation() < 0.4) {
                            setCellColour(i, j, 0.0F, 0.0F, 0.5F);
                        } else {
                            setCellColour(i, j, 0.0F, 0.0F, 0.5F);
                        }
                    }
                    Graphics2D scaledImageGraphicsContext = scaledImage.createGraphics();
                    scaledImageGraphicsContext.drawImage(image, 0, 0, (width), (height), null);
                    scaledImageGraphicsContext.dispose();
                    imagePanel.validate();
                    imagePanel.repaint();

                }
            }
        }
    }

    //Method linking CANN and robot's 'vision'
    public void VbotAsInput() {
        mouseX = environment.vbot.getxCoor();
        mouseY = environment.vbot.getyCoor();
        mouseY += 21;

        for (int x = mouseX - (6 * scale); x <= mouseX + (6 * scale); x++) {
            if (mouseX % (6 * scale) == 0) {
                break;
            }
            if (x % (6 * scale) == 0) {
                mouseX = x;
                break;
            }
        }
        for (int y = mouseY - (6 * scale); y <= mouseY + (6 * scale); y++) {
            if (mouseY % (6 * scale) == 0) {
                break;
            }

            if (mouseY % (6 * scale) == 0 || y % (6 * scale) == 0) {
                mouseY = y;
                break;
            }
        }
        if (mouseX != mouseX2 || mouseY != mouseY2) {
            I = 0;
        }

        timer.start();
    }

    //Method used by updateGridImage to set the colour of each cell (From Theo's Game of Life)
    private void setCellColour(int x, int y, float red, float green, float blue) {
        Color colour = new Color(red, green, blue);
        int i1 = x;
        int j1 = y;
        int ii = x;
        int jj = y;
        if ((y < 0) || (y >= width) || (x < 0) || (y >= height)) {
            if (ii < 0) {
                ii += width;
                i1 = ii;
            } else if (ii >= width) {
                ii -= width;
                i1 = ii;
            }
            if (jj < 0) {
                jj += height;
                j1 = jj;
            } else if (jj >= height) {
                jj -= height;
                j1 = jj;
            }
        }
        raster.setDataElements(i1, j1, colourModel.getDataElements(colour.getRGB(), null));
    }

//Initalises Place Cells
    public void initCells() {

        for (int i = 0; i < width; i++) //Loop to create coordinates of cicles and store in array
        {
            for (int j = 0; j < height; j++) {
                if (i % (6 * scale) == 0 && j % (6 * scale) == 0) { //every 10 pixels
                    //Create nodes
                    node = new Node(i, j, 0);
                    nodeArray[i][j] = node;

                    nodeArray[i][j].setXYMax(i, j);
                }
            }
        }
        updateGridImage();
        imagePanel.validate();
        imagePanel.repaint();
    }

//Initalises Synaptic weights for Place Cells
    public void initConnections() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                if ((nodeArray[i][j] != null)) {
                    nodeArray[i][j].setConnection(width, height, scale);
                    nodeArray[i][j].setActivation(0.0);

                }

            }
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {

                if ((nodeArray[i][j] != null)) {
                    nodeArray[i][j].setactivationFiringRate();
                }

            }
        }
        updateGridImage();
        imagePanel.validate();
        imagePanel.repaint();
    }

    public void clearCells() {
        for (int i = 0; i < width; i++) //Loop to create coordinates of cicles and store in array
        {
            for (int j = 0; j < height; j++) {
                if (i % (6 * scale) == 0 && j % (6 * scale) == 0) { //every 10 pixels
                    //Create nodes

                    nodeArray[i][j] = null;

                }
            }
        }
        updateGridImage();
        imagePanel.validate();
        imagePanel.repaint();
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    //turns vision on and off
    public void setVision(boolean i) {
        vision = i;
    }

    //Equation 2.3
    public void setCellMaxXY() {
        environment.vbot.setxCoor(0);
        environment.vbot.setyCoor(0);
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 400; j++) {
                if (i % (6 * scale) == 0 && j % (6 * scale) == 0) {
                    environment.vBotandLandmarks();
                    double dbxCoor;
                    double dbyCoor;
                    int xCoor;
                    int yCoor;
                    int vbx = environment.vbot.getxCoor();
                    int vby = environment.vbot.getyCoor();
                    dbxCoor = environment.lm1dxy2;
                    dbxCoor += environment.lm2dxy2;
                    dbxCoor += environment.lm3dxy2;
                    dbxCoor += environment.lm4dxy2;

                    dbyCoor = environment.thetalm1dx;
                    dbyCoor += environment.thetalm2dy;
                    dbyCoor += environment.thetalm3dx;
                    dbyCoor += environment.thetalm4dy;

                    dbxCoor *= 400;
                    dbyCoor *= 400;
                    xCoor = (int) dbxCoor;
                    yCoor = (int) dbyCoor;

                    if (xCoor > 400) {
                        int xCoor2 = (xCoor / 400);
                        xCoor -= (400 * xCoor2);
                    }
                    if (yCoor > 400) {
                        int yCoor2 = (yCoor / 400);
                        yCoor -= (400 * yCoor2);
                    }

                    for (int xCoorc = xCoor - 6; xCoorc < xCoor + 6; xCoorc++) {
                        if (xCoor % (6 * scale) == 0) {
                            break;
                        }
                        if (xCoorc % (6 * scale) == 0) {
                            xCoor = xCoorc;
                            break;
                        }
                    }
                    for (int yCoorc = yCoor - 6; yCoorc < yCoor + 6; yCoorc++) {
                        if (yCoor % (6 * scale) == 0) {
                            break;
                        }
                        if (yCoorc % (6 * scale) == 0) {
                            yCoor = yCoorc;
                            break;
                        }
                    }

                    nodeArray[i][j].setXYMax(xCoor, yCoor); //sets Robot location where cell fire maximally
                    if (vby < 390) {
                        environment.vbot.move(4);
                        environment.vBotandLandmarks();
                        int Klmc = 0;
                        for (int s = vbx - 16; s <= vbx + 16; s++) {
                            if (Klmc == 1) {
                                break;
                            }
                            for (int d = vby - 11; d <= vby + 11; d++) {
                                if (d > 0 && s > 0 && d < 400 && s < 400) {
                                    if (environment.landmarkLocationArray[s][d] == 1) {
                                        Klmc = 1;
                                        break;
                                    }
                                }

                            }
                        }
                    } else if (vbx < 390 && vby >= 390) {

                        environment.vbot.move(1);
                        environment.vbot.setyCoor(0);
                        environment.vBotandLandmarks();
                        int Klmc = 0;

                        for (int s = vbx - 16; s <= vbx + 16; s++) {
                            if (Klmc == 1) {
                                break;
                            }
                            for (int d = vby - 11; d <= vby + 11; d++) {
                                if (d > 0 && s > 0 && d < 400 && s < 400) {
                                    if (environment.landmarkLocationArray[s][d] == 1) {
                                        Klmc = 1;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    //Learning phase, called when 'Learn Environment is pressed in UI'
    public void learn() {
        double sW, sWsum, a, sia, sib, sic, sigma, q, ri, dsW, k, phi0, cP, fr1, fr2;
        int vbx = 0, vby = 0, I, percent = 0;
        phi0 = 1250690.00;
        cP = 1336336.00;
        sWsum = 0;
        I = 0;
        sigma = 0.8;
        k = 0.001;
        sW = 0;
        setCellMaxXY();
        environment.vbot.setxCoor(0);
        environment.vbot.setyCoor(0);
        for (int c = 0; c < 19; c++) {
            updateFiringRates();
            updateSynapticWeights();
            if (vby < 390) {
                environment.vbot.move(4);
                int Klmc = 0;
                for (int s = vbx - 16; s <= vbx + 16; s++) {
                    if (Klmc == 1) {
                        break;
                    }
                    for (int d = vby - 11; d <= vby + 11; d++) {
                        if (d > 0 && s > 0 && d < 400 && s < 400) {
                            if (environment.landmarkLocationArray[s][d] == 1) {
                                Klmc = 1;
                                break;
                            }
                        }

                    }
                }
            } else if (vbx < 390 && vby >= 390) {
                environment.vbot.move(1);
                int Klmc = 0;

                for (int s = vbx - 16; s <= vbx + 16; s++) {
                    if (Klmc == 1) {
                        break;
                    }
                    for (int d = vby - 11; d <= vby + 11; d++) {
                        if (d > 0 && s > 0 && d < 400 && s < 400) {
                            if (environment.landmarkLocationArray[s][d] == 1) {
                                Klmc = 1;
                                break;
                            }
                        }
                    }
                }
            }
        }
    }

    //Equation 2.2
    public void updateFiringRates() {
        double sia, sib, sic, sigma, q, ri;
        int pcmfx, vbx = 0, pcmfy, vby = 0;
        sigma = 0.5;
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 400; j++) {
                if (i % (6 * scale) == 0 && j % (6 * scale) == 0) {
                    pcmfx = nodeArray[i][j].xCoormax;
                    pcmfy = nodeArray[i][j].yCoormax;
                    vbx = environment.vbot.getxCoor();
                    vby = environment.vbot.getyCoor();
                    environment.vBotandLandmarks();
                    sia = (pcmfx - vbx);
                    sia /= 600;
                    sib = (pcmfy - vby);
                    sib /= 600;
                    //Update Firing rate
                    sia = Math.pow(sia, 2);
                    sib = Math.pow(sib, 2);
                    sic = sia + sib;
                    // sic = Math.pow(sic,0.5);
                    sigma = Math.pow(sigma, 2);
                    sigma *= 2;
                    q = (sic / sigma);
                    ri = Math.exp(-q);
                    nodeArray[i][j].setlearningFiringRate(ri);

                }
            }
        }
    }

    //Equation 2.4
    public void updateSynapticWeights() {
        double dsW, k, fr1, fr2;
        k = 0.01;
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 400; j++) {
                if (i % (6 * scale) == 0 && j % (6 * scale) == 0) {
                    for (int i1 = 0; i1 < 400; i1++) {
                        for (int j1 = 0; j1 < 400; j1++) {
                            int a = 0;
                            if (i1 % (6 * scale) == 0 && j1 % (6 * scale) == 0) {
                                fr1 = nodeArray[i][j].getlearningFiringRate();    //update Synaptic weights
                                fr2 = nodeArray[i1][j1].getlearningFiringRate();
                                dsW = k * fr1 * fr2;
                                nodeArray[i][j].updateConnection(i1, j1, dsW);

                            }
                        }
                    }
                }
            }
        }

    }

    private class ImagePanel extends JPanel {

        private BufferedImage image;

        public ImagePanel(BufferedImage image) {
            this.image = image;
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (image == null) {
                return;
            }

            g.drawImage(image, 0, 0, null);
        }
    }
}
