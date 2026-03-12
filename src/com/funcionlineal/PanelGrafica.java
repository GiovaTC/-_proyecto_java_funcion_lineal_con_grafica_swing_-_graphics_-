package com.funcionlineal;

import javax.swing.*;
import java.awt.*;

public class PanelGrafica extends JPanel {

    private double a = 1;
    private double b = 0;

    public void actualizarFuncion(double a, double b) {
        this.a = a;
        this.b = b;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        int width = getWidth();
        int height = getHeight();

        int origenX = width / 2;
        int origenY = height / 2;

        // Dibujar ejes
        g2.drawLine(0, origenY, width, origenY);
        g2.drawLine(origenX, 0, origenX, height);

        // Escala
        int escala = 20;

        // Dibujar función
        int prevX = 0;
        int prevY = 0;

        for (int px = -width/2; px < width/2; px++) {

            double x = px / (double) escala;
            double y = a * x + b;

            int py = (int)(-y * escala);

            int screenX = origenX + px;
            int screenY = origenY + py;

            if (px != -width/2) {

                g2.drawLine(prevX, prevY, screenX, screenY);

            }

            prevX = screenX;
            prevY = screenY;
        }
    }
}
