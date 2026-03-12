package com.funcionlineal;

import javax.swing.*;
import java.awt.*;

public class InterfazFuncionLineal extends JFrame {

    private JTextField campoA;
    private JTextField campoB;
    private PanelGrafica panelGrafica;

    public InterfazFuncionLineal() {

        setTitle("Gráfica de Función Lineal");
        setSize(700,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelControl = new JPanel();

        panelControl.add(new JLabel("a:"));
        campoA = new JTextField("1",5);
        panelControl.add(campoA);

        panelControl.add(new JLabel("b:"));
        campoB = new JTextField("0",5);
        panelControl.add(campoB);

        JButton botonGraficar = new JButton("Graficar");

        panelControl.add(botonGraficar);

        add(panelControl, BorderLayout.NORTH);

        panelGrafica = new PanelGrafica();
        add(panelGrafica, BorderLayout.CENTER);

        botonGraficar.addActionListener(e -> {

            try {

                double a = Double.parseDouble(campoA.getText());
                double b = Double.parseDouble(campoB.getText());

                panelGrafica.actualizarFuncion(a,b);

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(this,
                        "Ingrese valores numéricos válidos");

            }

        });

    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            new InterfazFuncionLineal().setVisible(true);

        });
    }
}