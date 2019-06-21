package nodes;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.Scanner;
import javax.swing.*;

public class Environment {

    public int width, height, scale, number;
    //Constants for activation
    Vbot vbot;
    Landmarks lm1;
    Landmarks lm2;
    Landmarks lm3;
    Landmarks lm4;
    double lm1dxy2, lm2dxy2, lm3dxy2, lm4dxy2;
    double thetalm1dx, thetalm2dy, thetalm3dx, thetalm4dy, totaltheta, closelm1theta, closelm2theta;
    int[][] vBotLocationArray;
    int[][] landmarkLocationArray;
    int counter;
    public BufferedImage image, scaledImage;
    private WritableRaster raster;
    private ColorModel colourModel;
    public int position = 1;
    JFrame imageFrame = new JFrame("Continous Attractor Neural Network");
    ImagePanel imagePanel;

    public Environment(int width, int height, int scale) {
        this.width = width * scale;
        this.height = height * scale;
        this.number = 1;

        image = new BufferedImage(width * scale, height * scale, BufferedImage.TYPE_INT_RGB);
        raster = image.getRaster();
        colourModel = image.getColorModel();
        vBotLocationArray = new int[width * scale][height * scale];
        landmarkLocationArray = new int[width * scale][height * scale];
        scaledImage = new BufferedImage((scale * width)+22, ((scale * height)+44), BufferedImage.TYPE_INT_RGB);
        imagePanel = new ImagePanel(scaledImage);
        imageFrame.add(imagePanel);
        imageFrame.setSize(((width * scale)+22), ((scale * height) + 40));
        imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        imageFrame.setVisible(true);
        imagePanel.setVisible(true);
    }
    //Update the Place Cells (From Theo's Game of Life)
    public void updateGridImage() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i == 0 || j == 0 || j == height - 1 || i == width - 1) {
                    setCellColour(i, j, 0.0F, 0.0F, 0.0F);
                } else {
                    setCellColour(i, j, 1.0F, 1.0F, 1.0F);
                }
                if (vBotLocationArray[i][j] == 1) {
                    setCellColour(i, j, 1.0F, 0.0F, 0.0F);
                } else if (vBotLocationArray[i][j] == 2) {
                    setCellColour(i, j, 0.0F, 0.0F, 0.0F);
                }
                if (landmarkLocationArray[i][j] == 1) {
                    setCellColour(i, j, 0.0F, 0.0F, 0.0F);
                }
            }
        }
        Graphics2D scaledImageGraphicsContext = scaledImage.createGraphics();
        scaledImageGraphicsContext.drawImage(image, 0, 0, (width), (height), null);
        scaledImageGraphicsContext.dispose();
        imagePanel.validate();
        imagePanel.repaint();
    }
     //Method used by updateGridImage to set the colour of each cell (From Theo's Game of Life)
    private void setCellColour(int x, int y, float red, float green, float blue) {
        Color colour = new Color(red, green, blue);

        raster.setDataElements(x, y, colourModel.getDataElements(colour.getRGB(), null));
    }

    public void initvBot() {
        int x = 0;
        int y = 0;
        if (position == 1) {
            x = 96;
            y = 100;
        }
        if (position == 2) {
            x = 288;
            y = 336;
        }
        if (position == 3) {
            x = 304;
            y = 100;
        }
        if (position == 4) {
            x = 200;
            y = 200;
        }
        vbot = new Vbot(x, y);
        for (int i = x - 14; i <= x + 14; i++) {
            for (int j = y - 9; j <= y + 9; j++) {
                if (i >= x - 9 && i <= x + 9) {
                    vBotLocationArray[i][j] = 1;
                } else {
                    vBotLocationArray[i][j] = 2;
                }
            }
        }
    }
   
    

    public void clearvBot() {
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 400; j++) {
                vBotLocationArray[i][j] = 0;
            }
        }
    }

    public void initLandmarks() {
        if (number == 4) {
            lm1 = new Landmarks(50, 25, 25);
            for (int i = 25 - 25; i <= 25 + 25; i++) {
                for (int j = 25 - 25; j <= 25 + 25; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm2 = new Landmarks(50, 25, 374);
            for (int i = 25 - 25; i <= 25 + 25; i++) {
                for (int j = 374 - 25; j <= 374 + 25; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm3 = new Landmarks(50, 374, 374);
            for (int i = 374 - 25; i <= 374 + 25; i++) {
                for (int j = 374 - 25; j <= 374 + 25; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm4 = new Landmarks(50, 374, 25);
            for (int i = 374 - 25; i <= 374 + 25; i++) {
                for (int j = 25 - 25; j <= 25 + 25; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }

            updateGridImage();
            imagePanel.validate();
            imagePanel.repaint();
        }
        if (number == 2) {
            lm1 = new Landmarks(20, 190, 25);
            for (int i = 190 - 10; i <= 190 + 10; i++) {
                for (int j = 25 - 10; j <= 25 + 10; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm2 = new Landmarks(30, 90, 350);
            for (int i = 90 - 15; i <= 90 + 15; i++) {
                for (int j = 350 - 15; j <= 350 + 15; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm3 = new Landmarks(40, 350, 290);
            for (int i = 350 - 20; i <= 350 + 20; i++) {
                for (int j = 290 - 20; j <= 290 + 20; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm4 = new Landmarks(50, 360, 25);
            for (int i = 360 - 25; i <= 360 + 25; i++) {
                for (int j = 25 - 25; j <= 25 + 25; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            updateGridImage();
            imagePanel.validate();
            imagePanel.repaint();
        }

        if (number == 3) {
            lm1 = new Landmarks(20, 10, 10);
            for (int i = 10 - 10; i <= 10 + 10; i++) {
                for (int j = 10 - 10; j <= 10 + 10; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm2 = new Landmarks(30, 25, 275);
            for (int i = 25 - 15; i <= 25 + 15; i++) {
                for (int j = 275 - 15; j <= 275 + 15; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm3 = new Landmarks(40, 286, 275);
            for (int i = 286 - 20; i <= 286 + 20; i++) {
                for (int j = 275 - 20; j <= 275 + 20; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm4 = new Landmarks(50, 374, 100);
            for (int i = 374 - 25; i <= 374 + 25; i++) {
                for (int j = 100 - 25; j <= 100 + 25; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            updateGridImage();
            imagePanel.validate();
            imagePanel.repaint();
        }
        if (number == 1) {
            lm1 = new Landmarks(20, 100, 25);
            for (int i = 100 - 10; i <= 100 + 10; i++) {
                for (int j = 25 - 10; j <= 25 + 10; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm2 = new Landmarks(30, 25, 200);
            for (int i = 25 - 15; i <= 25 + 15; i++) {
                for (int j = 200 - 15; j <= 200 + 15; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm3 = new Landmarks(40, 120, 374);
            for (int i = 120 - 20; i <= 120 + 20; i++) {
                for (int j = 374 - 20; j <= 374 + 20; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm4 = new Landmarks(50, 374, 200);
            for (int i = 374 - 25; i <= 374 + 25; i++) {
                for (int j = 200 - 25; j <= 200 + 25; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            updateGridImage();
            imagePanel.validate();
            imagePanel.repaint();
            vBotandLandmarks();
        }

    }

    
    public void condition3Landmarks() {

        if (number == 2) {
            lm1 = new Landmarks(20, 190, 35);
            for (int i = 190 - 10; i <= 190 + 10; i++) {
                for (int j = 35 - 10; j <= 35 + 10; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm2 = new Landmarks(30, 100, 340);
            for (int i = 100 - 15; i <= 100 + 15; i++) {
                for (int j = 340 - 15; j <= 340 + 15; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm3 = new Landmarks(40, 340, 280);
            for (int i = 340 - 20; i <= 340 + 20; i++) {
                for (int j = 280 - 20; j <= 280 + 20; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm4 = new Landmarks(50, 350, 35);
            for (int i = 350 - 25; i <= 350 + 25; i++) {
                for (int j = 35 - 25; j <= 35 + 25; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            updateGridImage();
            imagePanel.validate();
            imagePanel.repaint();
        }

        if (number == 3) {
            lm1 = new Landmarks(20, 20, 20);
            for (int i = 20 - 10; i <= 20 + 10; i++) {
                for (int j = 20 - 10; j <= 20 + 10; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm2 = new Landmarks(30, 35, 285);
            for (int i = 35 - 15; i <= 35 + 15; i++) {
                for (int j = 285 - 15; j <= 285 + 15; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm3 = new Landmarks(40, 276, 265);
            for (int i = 276 - 20; i <= 276 + 20; i++) {
                for (int j = 265 - 20; j <= 265 + 20; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm4 = new Landmarks(50, 290, 110);
            for (int i = 290 - 25; i <= 290 + 25; i++) {
                for (int j = 110 - 25; j <= 110 + 25; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            updateGridImage();
            imagePanel.validate();
            imagePanel.repaint();
        }
        if (number == 1) {
            lm1 = new Landmarks(20, 90, 35);
            for (int i = 90 - 10; i <= 90 + 10; i++) {
                for (int j = 35 - 10; j <= 35 + 10; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm2 = new Landmarks(30, 35, 210);
            for (int i = 35 - 15; i <= 35 + 15; i++) {
                for (int j = 210 - 15; j <= 210 + 15; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm3 = new Landmarks(40, 130, 364);
            for (int i = 130 - 20; i <= 130 + 20; i++) {
                for (int j = 364 - 20; j <= 364 + 20; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm4 = new Landmarks(50, 364, 210);
            for (int i = 364 - 25; i <= 364 + 25; i++) {
                for (int j = 210 - 25; j <= 210 + 25; j++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            updateGridImage();
            imagePanel.validate();
            imagePanel.repaint();
            vBotandLandmarks();
        }

    }

    
    public void condition4Landmarks() {
        if (number == 2) {
            lm1 = new Landmarks(20, 365, 190);
            for (int j = 190 - 10; j <= 190 + 10; j++) {
                for (int i = 365 - 10; i <= 365 + 10; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm2 = new Landmarks(30, 60, 100);
            for (int j = 100 - 15; j <= 100 + 15; j++) {
                for (int i = 60 - 15; i <= 60 + 15; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm3 = new Landmarks(40, 120, 340);
            for (int j = 340 - 20; j <= 340 + 20; j++) {
                for (int i = 120 - 20; i <= 120 + 20; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm4 = new Landmarks(50, 365, 350);
            for (int j = 350 - 25; j <= 350 + 25; j++) {
                for (int i = 365 - 25; i <= 365 + 25; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            updateGridImage();
            imagePanel.validate();
            imagePanel.repaint();
        }

            if (number == 3) {
            lm1 = new Landmarks(20, 389, 11);
            for (int j = 11 - 10; j <= 11 + 10; j++) {
                for (int i = 389 - 10; i <= 389 + 10; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm2 = new Landmarks(30, 125, 25);
            for (int j = 25 - 15; j <= 25 + 15; j++) {
                for (int i = 125 - 15; i <= 125 + 15; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm3 = new Landmarks(40, 125, 286);
            for (int j = 286 - 20; j <= 286 + 20; j++) {
                for (int i = 125 - 20; i <= 125 + 20; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm4 = new Landmarks(50, 300, 374);
            for (int j = 374 - 25; j <= 374 + 25; j++) {
                for (int i = 300 - 25; i <= 300 + 25; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            updateGridImage();
            imagePanel.validate();
            imagePanel.repaint();
        }
        if (number == 1) {
            lm1 = new Landmarks(20, 375, 120);
            for (int j = 120 - 10; j <= 120 + 10; j++) {
                for (int i = 375 - 10; i <= 375 + 10; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm2 = new Landmarks(30, 190, 25);
            for (int j = 25 - 15; j <= 25 + 15; j++) {
                for (int i = 190 - 15; i <= 190 + 15; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm3 = new Landmarks(40, 36, 130);
            for (int j = 130 - 20; j <= 130 + 20; j++) {
                for (int i = 36 - 20; i <= 36 + 20; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            lm4 = new Landmarks(50, 190, 364);
            for (int j = 364 - 25; j <= 364 + 25; j++) {
                for (int i = 190 - 25; i <= 190 + 25; i++) {
                    landmarkLocationArray[i][j] = 1;
                }
            }
            updateGridImage();
            imagePanel.validate();
            imagePanel.repaint();
            
        }
        vBotandLandmarks();

    }
    

    
    public void clearLandmarks() {
        for (int i = 0; i < 400; i++) {
            for (int j = 0; j < 400; j++) {
                landmarkLocationArray[i][j] = 0;
            }
        }
    }

    public void vBotandLandmarks() {
        try {
            int vBotx = vbot.getxCoor();
            int vBoty = vbot.getyCoor();
            double lm1dx, lm1dy, lm1dx2, lm1dy2,lm2dx, lm2dy, lm2dx2,lm2dy2;
            double lm3dx, lm3dy, lm3dx2, lm3dy2,lm4dx, lm4dy, lm4dx2, lm4dy2;
            thetalm1dx = 0.0;
            thetalm2dy = 0.0;
            thetalm3dx = 0.0;
            thetalm4dy = 0.0;
            double dx;
            double dy;
            totaltheta = 0.0;
            int lm1x = lm1.getxCoor();
            int lm1y = lm1.getyCoor();
            int lm2x = lm2.getxCoor();
            int lm2y = lm2.getyCoor();
            int lm3x = lm3.getxCoor();
            int lm3y = lm3.getyCoor();
            int lm4x = lm4.getxCoor();
            int lm4y = lm4.getyCoor();
            if (vBotx > lm1x) {
                lm1dx = vBotx - lm1x;
            } else {
                lm1dx = lm1x - vBotx;
            }
            if (vBoty > lm1y) {
                lm1dy = vBoty - lm1y;
            } else {
                lm1dy = lm1y - vBoty;
            }
            if (vBotx > lm2x) {
                lm2dx = vBotx - lm2x;
            } else {
                lm2dx = lm2x - vBotx;
            }
            if (vBoty > lm2y) {
                lm2dy = vBoty - lm2y;
            } else {
                lm2dy = lm2y - vBoty;
            }

            if (vBotx > lm3x) {
                lm3dx = vBotx - lm3x;
            } else {
                lm3dx = lm3x - vBotx;
            }
            if (vBoty > lm3y) {
                lm3dy = vBoty - lm3y;
            } else {
                lm3dy = lm3y - vBoty;
            }

            if (vBotx > lm4x) {
                lm4dx = vBotx - lm4x;
            } else {
                lm4dx = lm4x - vBotx;
            }
            if (vBoty > lm4y) {
                lm4dy = vBoty - lm4y;
            } else {
                lm4dy = lm4y - vBoty;
            }
            thetalm1dx = Math.atan2(lm1dx, lm1dy);
            dy = lm2dy - lm1dy;
            dx = lm2dx - lm1dx;
            thetalm2dy = Math.atan2(dy, dx);
            dy = lm3dy - lm2dy;
            dx = lm3dx - lm2dx;
            thetalm3dx = Math.atan2(dx, dy);
            dy = lm4dy - lm3dy;
            dx = lm4dx - lm3dx;
            thetalm4dy = Math.atan2(dy, dx);
            if (thetalm1dx < 0) {
                thetalm1dx = -thetalm1dx;
            }
            if (thetalm2dy < 0) {
                thetalm2dy = -thetalm2dy;
            }
            if (thetalm3dx < 0) {
                thetalm3dx = -thetalm3dx;
            }
            if (thetalm4dy < 0) {
                thetalm4dy = -thetalm4dy;
            }
            totaltheta = thetalm1dx + thetalm2dy + thetalm3dx + thetalm4dy;

            lm1dx2 = Math.pow(lm1dx, 2);
            lm1dy2 = Math.pow(lm1dy, 2);
            lm1dxy2 = lm1dx2 + lm1dy2;
            lm1dxy2 = Math.pow(lm1dxy2, 0.5);
            lm1dxy2 /= 400;
            lm2dx2 = Math.pow(lm2dx, 2);
            lm2dy2 = Math.pow(lm2dy, 2);
            lm2dxy2 = lm2dx2 + lm2dy2;
            lm2dxy2 = Math.pow(lm2dxy2, 0.5);
            lm2dxy2 /= 400;
            lm3dx2 = Math.pow(lm3dx, 2);
            lm3dy2 = Math.pow(lm3dy, 2);
            lm3dxy2 = lm3dx2 + lm3dy2;
            lm3dxy2 = Math.pow(lm3dxy2, 0.5);
            lm3dxy2 /= 400;
            lm4dx2 = Math.pow(lm4dx, 2);
            lm4dy2 = Math.pow(lm4dy, 2);
            lm4dxy2 = lm4dx2 + lm4dy2;
            lm4dxy2 = Math.pow(lm4dxy2, 0.5);
            lm4dxy2 /= 400;
        } catch (NullPointerException e) {
            System.out.println("Please Choose an Environment");
        }
    }

    public void setPosition(int number) {
        this.position = number;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
