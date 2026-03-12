# -_proyecto_java_funcion_lineal_con_grafica_swing_-_graphics_- :.
programa en Java (IntelliJ + Swing) que incluye:

<img width="1536" height="1024" alt="image" src="https://github.com/user-attachments/assets/0e9c8a5d-ea27-4d7d-9873-db335ca6747d" />  

- ✔ Cálculo de función lineal
- ✔ Interfaz gráfica
- ✔ Gráfica de la función usando Java Graphics (Graphics2D)
- ✔ Visualización del plano cartesiano
- ✔ Dibujo dinámico de la recta 
  f(x)=ax+b

📈 Proyecto Java: Función Lineal con Gráfica (Swing + Graphics):
Ecuación usada:
f(x)=ax+b

Dónde:

a → pendiente

b → intercepto

x → variable independiente
```

📂 Estructura del proyecto:
FuncionLinealGrafica
│
└── src
     │
     └── com.funcionlineal
            │
            ├── FuncionLineal.java
            ├── PanelGrafica.java
            └── InterfazFuncionLineal.java

```

```
1️⃣ Modelo matemático:
📄 FuncionLineal.java

package com.funcionlineal;

public class FuncionLineal {

    private double a;
    private double b;

    public FuncionLineal(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double calcular(double x) {
        return a * x + b;
    }

}

2️⃣ Panel que dibuja la gráfica:
📄 PanelGrafica.java

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
    protected void paintComponent(Graphics g) {

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

3️⃣ Interfaz gráfica:
📄 InterfazFuncionLineal.java

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

▶️ Cómo funciona:
1️⃣ El usuario ingresa valores:

a = 2
b = 1

2️⃣ La aplicación grafica:
  f(x)=2x+1

3️⃣ Se dibuja la recta en el plano cartesiano dentro de la ventana.
📊 Resultado visual esperado

La ventana muestra:

 ------------------------------
 | a: 2  b: 1   [Graficar]    |
 ------------------------------
 |                            |
 |        |                   |
 |        |      /            |
 |--------+-----/-------------|
 |       /                    |
 |      /                     |
 |                            |
 ------------------------------

Con:
- eje X
- eje Y
- recta de la función
```
🚀 Mejoras que lo vuelven un proyecto universitario fuerte

Puedes agregar:

- ✔ Zoom en la gráfica
- ✔ Mostrar coordenadas al pasar el mouse
- ✔ Tabla de valores x / f(x)
- ✔ Exportar gráfica como imagen
- ✔ Múltiples funciones en la misma gráfica / . 
