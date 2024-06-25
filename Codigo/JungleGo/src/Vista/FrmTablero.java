/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControlJuego;
import java.awt.MouseInfo;
import java.awt.Point;
import javax.swing.JLabel;

/**
 *
 * @author Jason
 */
public class FrmTablero extends javax.swing.JFrame {

    Point mouse;
    ControlJuego controlador;
    JLabel listaLabels[][] = new JLabel[9][9];

    /**
     * Creates new form FrmTablero
     */
    public FrmTablero() {
        initComponents();
        controlador = new ControlJuego(this);
        this.addMouseListener(controlador);
        asignarLabels();
    }//constructor

    public void asignarLabels() {
        for (int indice = 0; indice < 9; indice++) {
            if (indice == 0) {
                listaLabels[0][0] = this.labelA1;
                listaLabels[0][1] = this.labelA2;
                listaLabels[0][2] = this.labelA3;
                listaLabels[0][3] = this.labelA4;
                listaLabels[0][4] = this.labelA5;
                listaLabels[0][5] = this.labelA6;
                listaLabels[0][6] = this.labelA7;
                listaLabels[0][7] = this.labelA8;
                listaLabels[0][8] = this.labelA9;
            } else if (indice == 1) {
                listaLabels[1][0] = this.labelB1;
                listaLabels[1][1] = this.labelB2;
                listaLabels[1][2] = this.labelB3;
                listaLabels[1][3] = this.labelB4;
                listaLabels[1][4] = this.labelB5;
                listaLabels[1][5] = this.labelB6;
                listaLabels[1][6] = this.labelB7;
                listaLabels[1][7] = this.labelB8;
                listaLabels[1][8] = this.labelB9;
            } else if (indice == 2) {
                listaLabels[2][0] = this.labelC1;
                listaLabels[2][1] = this.labelC2;
                listaLabels[2][2] = this.labelC3;
                listaLabels[2][3] = this.labelC4;
                listaLabels[2][4] = this.labelC5;
                listaLabels[2][5] = this.labelC6;
                listaLabels[2][6] = this.labelC7;
                listaLabels[2][7] = this.labelC8;
                listaLabels[2][8] = this.labelC9;
            } else if (indice == 3) {
                listaLabels[3][0] = this.labelD1;
                listaLabels[3][1] = this.labelD2;
                listaLabels[3][2] = this.labelD3;
                listaLabels[3][3] = this.labelD4;
                listaLabels[3][4] = this.labelD5;
                listaLabels[3][5] = this.labelD6;
                listaLabels[3][6] = this.labelD7;
                listaLabels[3][7] = this.labelD8;
                listaLabels[3][8] = this.labelD9;
            } else if (indice == 4) {
                listaLabels[4][0] = this.labelE1;
                listaLabels[4][1] = this.labelE2;
                listaLabels[4][2] = this.labelE3;
                listaLabels[4][3] = this.labelE4;
                listaLabels[4][4] = this.labelE5;
                listaLabels[4][5] = this.labelE6;
                listaLabels[4][6] = this.labelE7;
                listaLabels[4][7] = this.labelE8;
                listaLabels[4][8] = this.labelE9;
            } else if (indice == 5) {
                listaLabels[5][0] = this.labelF1;
                listaLabels[5][1] = this.labelF2;
                listaLabels[5][2] = this.labelF3;
                listaLabels[5][3] = this.labelF4;
                listaLabels[5][4] = this.labelF5;
                listaLabels[5][5] = this.labelF6;
                listaLabels[5][6] = this.labelF7;
                listaLabels[5][7] = this.labelF8;
                listaLabels[5][8] = this.labelF9;
            } else if (indice == 6) {
                listaLabels[6][0] = this.labelG1;
                listaLabels[6][1] = this.labelG2;
                listaLabels[6][2] = this.labelG3;
                listaLabels[6][3] = this.labelG4;
                listaLabels[6][4] = this.labelG5;
                listaLabels[6][5] = this.labelG6;
                listaLabels[6][6] = this.labelG7;
                listaLabels[6][7] = this.labelG8;
                listaLabels[6][8] = this.labelG9;
            } else if (indice == 7) {
                listaLabels[7][0] = this.labelH1;
                listaLabels[7][1] = this.labelH2;
                listaLabels[7][2] = this.labelH3;
                listaLabels[7][3] = this.labelH4;
                listaLabels[7][4] = this.labelH5;
                listaLabels[7][5] = this.labelH6;
                listaLabels[7][6] = this.labelH7;
                listaLabels[7][7] = this.labelH8;
                listaLabels[7][8] = this.labelH9;
            } else {
                listaLabels[8][0] = this.labeli1;
                listaLabels[8][1] = this.labeli2;
                listaLabels[8][2] = this.labeli3;
                listaLabels[8][3] = this.labeli4;
                listaLabels[8][4] = this.labeli5;
                listaLabels[8][5] = this.labeli6;
                listaLabels[8][6] = this.labeli7;
                listaLabels[8][7] = this.labeli8;
                listaLabels[8][8] = this.labeli9;
            }//else
        }//for
    }//asignarLabels

    public void setImagen(int x, int y, String url) {
        listaLabels[x][y].setIcon(new javax.swing.ImageIcon(getClass().getResource(url)));
    }//setImagen

    public void setPuntaje(int numero, String puntaje) {
        if (numero == 2) {
            this.labelComidaContador2.setText(puntaje);
        } else {
            this.labelComidaContador1.setText(puntaje);
        }//else
    }//setPuntaje

    public int getPuntaje(int numero) {
        if (numero == 1) {
            if (this.labelComidaContador1.getText().toString() == "") {
                return 0;
            } else {
                return Integer.parseInt(this.labelComidaContador1.getText().toString());
            }//else
        } else {
            if (this.labelComidaContador2.getText().toString() == "") {
                return 0;
            } else {
                return Integer.parseInt(this.labelComidaContador2.getText().toString());
            }//else
        }//else
    }//getPuntaje

    public void setMensajeGanador() {
        this.labelGanador.setText(controlador.ganador().toUpperCase());
    }//setMensajeGanador

    public Point getCoordenadas() {
        mouse = MouseInfo.getPointerInfo().getLocation();
        this.labelX.setText("X: " + mouse.getX());
        this.labelY.setText("Y: " + mouse.getY());
        return mouse;
    }//cambiarCoordenadas

    public void detectarAccion(Point mouse) {
        if (mouse.getX() >= 161 && mouse.getX() <= 955) {
            if (mouse.getY() >= 168 && mouse.getY() <= 971) {
                controlador.jugarTurno(controlador.turnoActual(), mouse);
            }//if
        }//if
        else if (mouse.getX() >= 1130 && mouse.getX() <= 1220) {

            if (mouse.getY() >= 430 && mouse.getY() <= 470) {
                System.out.println("Entró 1");
                controlador.cambiarTurno(1);

            }//if
        } else if (mouse.getX() >= 1400 && mouse.getX() <= 1490) {
            System.out.println("Entró 2");
            if (mouse.getY() >= 430 && mouse.getY() <= 470) {
                controlador.cambiarTurno(2);

            }//if
        } else if (mouse.getX() >= 1420 && mouse.getX() <= 1680) {
            if (mouse.getY() >= 850 && mouse.getY() <= 960) {
                //System.exit(0);
                setMensajeGanador();
            }//if
        } else {

        }//else
    }//detectarAccion

    public void cambiarColorSkip(int turno) {
        if (turno == 2) {
            labelSkip1.setForeground(new java.awt.Color(77, 98, 23));
            labelSkip2.setForeground(new java.awt.Color(102, 84, 83));
        } else {
            labelSkip1.setForeground(new java.awt.Color(102, 84, 83));
            labelSkip2.setForeground(new java.awt.Color(77, 98, 23));
        }
    }//cambiarColorSkip

    public int getFila(double y) { // GetFila utilizara Y
        if (y >= 168 && y <= 255) {
            return 0;
        } else if (y >= 261 && y <= 348) {
            return 1;
        } else if (y >= 351 && y <= 438) {
            return 2;
        } else if (y >= 439 && y <= 526) {
            return 3;
        } else if (y >= 531 && y <= 618) {
            return 4;
        } else if (y >= 619 && y <= 705) {
            return 5;
        } else if (y >= 706 && y <= 793) {
            return 6;
        } else if (y >= 796 && y <= 883) {
            return 7;
        } else {
            return 8;
        }//else
    }//getFila 

    public int getColumna(double x) { // GetColumna utilizara x
        if (x >= 161 && x <= 239) {
            return 0;
        } else if (x >= 250 && x <= 328) {
            return 1;
        } else if (x >= 340 && x <= 418) {
            return 2;
        } else if (x >= 429 && x <= 508) {
            return 3;
        } else if (x >= 519 && x <= 597) {
            return 4;
        } else if (x >= 608 && x <= 686) {
            return 5;
        } else if (x >= 698 && x <= 776) {
            return 6;
        } else if (x >= 788 && x <= 866) {
            return 7;
        } else {
            return 8;
        }//else
    }//getColumna

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelA9 = new javax.swing.JLabel();
        labelA8 = new javax.swing.JLabel();
        labelA7 = new javax.swing.JLabel();
        labelA6 = new javax.swing.JLabel();
        labelA5 = new javax.swing.JLabel();
        labelA4 = new javax.swing.JLabel();
        labelA3 = new javax.swing.JLabel();
        labelA2 = new javax.swing.JLabel();
        labelA1 = new javax.swing.JLabel();
        labelB9 = new javax.swing.JLabel();
        labelB8 = new javax.swing.JLabel();
        labelB7 = new javax.swing.JLabel();
        labelB6 = new javax.swing.JLabel();
        labelB5 = new javax.swing.JLabel();
        labelB4 = new javax.swing.JLabel();
        labelB3 = new javax.swing.JLabel();
        labelB2 = new javax.swing.JLabel();
        labelB1 = new javax.swing.JLabel();
        labelC9 = new javax.swing.JLabel();
        labelC8 = new javax.swing.JLabel();
        labelC7 = new javax.swing.JLabel();
        labelC6 = new javax.swing.JLabel();
        labelC5 = new javax.swing.JLabel();
        labelC4 = new javax.swing.JLabel();
        labelC3 = new javax.swing.JLabel();
        labelC2 = new javax.swing.JLabel();
        labelC1 = new javax.swing.JLabel();
        labelD9 = new javax.swing.JLabel();
        labelD8 = new javax.swing.JLabel();
        labelD7 = new javax.swing.JLabel();
        labelD6 = new javax.swing.JLabel();
        labelD5 = new javax.swing.JLabel();
        labelD4 = new javax.swing.JLabel();
        labelD3 = new javax.swing.JLabel();
        labelD2 = new javax.swing.JLabel();
        labelD1 = new javax.swing.JLabel();
        labelE9 = new javax.swing.JLabel();
        labelE8 = new javax.swing.JLabel();
        labelE7 = new javax.swing.JLabel();
        labelE6 = new javax.swing.JLabel();
        labelE5 = new javax.swing.JLabel();
        labelE4 = new javax.swing.JLabel();
        labelE3 = new javax.swing.JLabel();
        labelE2 = new javax.swing.JLabel();
        labelE1 = new javax.swing.JLabel();
        labelF9 = new javax.swing.JLabel();
        labelF8 = new javax.swing.JLabel();
        labelF7 = new javax.swing.JLabel();
        labelF6 = new javax.swing.JLabel();
        labelF5 = new javax.swing.JLabel();
        labelF4 = new javax.swing.JLabel();
        labelF3 = new javax.swing.JLabel();
        labelF2 = new javax.swing.JLabel();
        labelF1 = new javax.swing.JLabel();
        labelG9 = new javax.swing.JLabel();
        labelG8 = new javax.swing.JLabel();
        labelG7 = new javax.swing.JLabel();
        labelG6 = new javax.swing.JLabel();
        labelG5 = new javax.swing.JLabel();
        labelG4 = new javax.swing.JLabel();
        labelG3 = new javax.swing.JLabel();
        labelG2 = new javax.swing.JLabel();
        labelG1 = new javax.swing.JLabel();
        labelH9 = new javax.swing.JLabel();
        labelH8 = new javax.swing.JLabel();
        labelH7 = new javax.swing.JLabel();
        labelH6 = new javax.swing.JLabel();
        labelH5 = new javax.swing.JLabel();
        labelH4 = new javax.swing.JLabel();
        labelH3 = new javax.swing.JLabel();
        labelH2 = new javax.swing.JLabel();
        labelH1 = new javax.swing.JLabel();
        labeli9 = new javax.swing.JLabel();
        labeli8 = new javax.swing.JLabel();
        labeli7 = new javax.swing.JLabel();
        labeli6 = new javax.swing.JLabel();
        labeli5 = new javax.swing.JLabel();
        labeli4 = new javax.swing.JLabel();
        labeli3 = new javax.swing.JLabel();
        labeli2 = new javax.swing.JLabel();
        labeli1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        labelGanador = new javax.swing.JLabel();
        labelComidaContador2 = new javax.swing.JLabel();
        labelComidaContador1 = new javax.swing.JLabel();
        labelFComidaJ2 = new javax.swing.JLabel();
        labelFComidaJ1 = new javax.swing.JLabel();
        labelSkip2 = new javax.swing.JLabel();
        labelSkip1 = new javax.swing.JLabel();
        labelY = new javax.swing.JLabel();
        labelX = new javax.swing.JLabel();
        labelFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(null);
        setSize(new java.awt.Dimension(1920, 1080));

        jPanel1.setMaximumSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setPreferredSize(new java.awt.Dimension(1920, 1080));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(labelA9, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 168, 78, 87));
        jPanel1.add(labelA8, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 168, 78, 87));
        jPanel1.add(labelA7, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 168, 78, 87));
        jPanel1.add(labelA6, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 168, 78, 87));
        jPanel1.add(labelA5, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 168, 78, 87));
        jPanel1.add(labelA4, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 168, 78, 87));
        jPanel1.add(labelA3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 168, 78, 87));
        jPanel1.add(labelA2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 168, 78, 87));
        jPanel1.add(labelA1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 168, 78, 87));
        jPanel1.add(labelB9, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 261, 78, 87));
        jPanel1.add(labelB8, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 261, 78, 87));
        jPanel1.add(labelB7, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 261, 78, 87));
        jPanel1.add(labelB6, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 261, 78, 87));
        jPanel1.add(labelB5, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 261, 78, 87));
        jPanel1.add(labelB4, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 261, 78, 87));
        jPanel1.add(labelB3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 261, 78, 87));
        jPanel1.add(labelB2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 261, 78, 87));
        jPanel1.add(labelB1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 261, 78, 87));
        jPanel1.add(labelC9, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 351, 78, 87));
        jPanel1.add(labelC8, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 351, 78, 87));
        jPanel1.add(labelC7, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 351, 78, 87));
        jPanel1.add(labelC6, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 351, 78, 87));
        jPanel1.add(labelC5, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 351, 78, 87));
        jPanel1.add(labelC4, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 351, 78, 87));
        jPanel1.add(labelC3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 351, 78, 87));
        jPanel1.add(labelC2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 351, 78, 87));
        jPanel1.add(labelC1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 351, 78, 87));
        jPanel1.add(labelD9, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 439, 78, 87));
        jPanel1.add(labelD8, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 439, 78, 87));
        jPanel1.add(labelD7, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 439, 78, 87));
        jPanel1.add(labelD6, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 439, 78, 87));
        jPanel1.add(labelD5, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 439, 78, 87));
        jPanel1.add(labelD4, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 439, 78, 87));
        jPanel1.add(labelD3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 439, 78, 87));
        jPanel1.add(labelD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 439, 78, 87));
        jPanel1.add(labelD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 439, 78, 87));
        jPanel1.add(labelE9, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 531, 78, 87));
        jPanel1.add(labelE8, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 531, 78, 87));
        jPanel1.add(labelE7, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 531, 78, 87));
        jPanel1.add(labelE6, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 531, 78, 87));
        jPanel1.add(labelE5, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 531, 78, 87));
        jPanel1.add(labelE4, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 531, 78, 87));
        jPanel1.add(labelE3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 531, 78, 87));
        jPanel1.add(labelE2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 531, 78, 87));
        jPanel1.add(labelE1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 531, 78, 87));
        jPanel1.add(labelF9, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 618, 78, 87));
        jPanel1.add(labelF8, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 618, 78, 87));
        jPanel1.add(labelF7, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 618, 78, 87));
        jPanel1.add(labelF6, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 618, 78, 87));
        jPanel1.add(labelF5, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 618, 78, 87));
        jPanel1.add(labelF4, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 618, 78, 87));
        jPanel1.add(labelF3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 618, 78, 87));
        jPanel1.add(labelF2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 618, 78, 87));
        jPanel1.add(labelF1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 618, 78, 87));
        jPanel1.add(labelG9, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 706, 78, 87));
        jPanel1.add(labelG8, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 706, 78, 87));
        jPanel1.add(labelG7, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 706, 78, 87));
        jPanel1.add(labelG6, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 706, 78, 87));
        jPanel1.add(labelG5, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 706, 78, 87));
        jPanel1.add(labelG4, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 706, 78, 87));
        jPanel1.add(labelG3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 706, 78, 87));
        jPanel1.add(labelG2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 706, 78, 87));
        jPanel1.add(labelG1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 706, 78, 87));
        jPanel1.add(labelH9, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 796, 78, 87));
        jPanel1.add(labelH8, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 796, 78, 87));
        jPanel1.add(labelH7, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 796, 78, 87));
        jPanel1.add(labelH6, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 796, 78, 87));
        jPanel1.add(labelH5, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 796, 78, 87));
        jPanel1.add(labelH4, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 796, 78, 87));
        jPanel1.add(labelH3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 796, 78, 87));
        jPanel1.add(labelH2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 796, 78, 87));
        jPanel1.add(labelH1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 796, 78, 87));
        jPanel1.add(labeli9, new org.netbeans.lib.awtextra.AbsoluteConstraints(877, 884, 78, 87));
        jPanel1.add(labeli8, new org.netbeans.lib.awtextra.AbsoluteConstraints(788, 884, 78, 87));
        jPanel1.add(labeli7, new org.netbeans.lib.awtextra.AbsoluteConstraints(698, 884, 78, 87));
        jPanel1.add(labeli6, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 884, 78, 87));
        jPanel1.add(labeli5, new org.netbeans.lib.awtextra.AbsoluteConstraints(519, 884, 78, 87));
        jPanel1.add(labeli4, new org.netbeans.lib.awtextra.AbsoluteConstraints(429, 884, 78, 87));
        jPanel1.add(labeli3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 884, 78, 87));
        jPanel1.add(labeli2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 884, 78, 87));
        jPanel1.add(labeli1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 884, 78, 87));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/botones/BotonSalir.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1105, 850, 260, 110));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/botones/BotonTerminar.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1420, 850, 280, 110));

        labelGanador.setBackground(new java.awt.Color(102, 84, 83));
        labelGanador.setFont(new java.awt.Font("Kid Games", 0, 18)); // NOI18N
        labelGanador.setForeground(new java.awt.Color(102, 84, 83));
        labelGanador.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(labelGanador, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 720, 480, 50));

        labelComidaContador2.setBackground(new java.awt.Color(102, 84, 83));
        labelComidaContador2.setFont(new java.awt.Font("Kid Games", 0, 65)); // NOI18N
        labelComidaContador2.setForeground(new java.awt.Color(102, 84, 83));
        labelComidaContador2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(labelComidaContador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1530, 560, 120, 90));

        labelComidaContador1.setBackground(new java.awt.Color(102, 84, 83));
        labelComidaContador1.setFont(new java.awt.Font("Kid Games", 0, 65)); // NOI18N
        labelComidaContador1.setForeground(new java.awt.Color(102, 84, 83));
        labelComidaContador1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(labelComidaContador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1290, 560, 120, 90));

        labelFComidaJ2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/fichas/Ficha1.png"))); // NOI18N
        labelFComidaJ2.setText("jLabel1");
        jPanel1.add(labelFComidaJ2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1430, 550, 78, 87));

        labelFComidaJ1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/fichas/Ficha2.png"))); // NOI18N
        labelFComidaJ1.setText("jLabel1");
        jPanel1.add(labelFComidaJ1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 550, 78, 87));

        labelSkip2.setBackground(new java.awt.Color(102, 84, 83));
        labelSkip2.setFont(new java.awt.Font("Kid Games", 0, 24)); // NOI18N
        labelSkip2.setForeground(new java.awt.Color(102, 84, 83));
        labelSkip2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSkip2.setText("  SKIP");
        labelSkip2.setToolTipText("");
        jPanel1.add(labelSkip2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1400, 430, 90, 40));

        labelSkip1.setBackground(new java.awt.Color(102, 84, 83));
        labelSkip1.setFont(new java.awt.Font("Kid Games", 0, 24)); // NOI18N
        labelSkip1.setForeground(new java.awt.Color(102, 84, 83));
        labelSkip1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSkip1.setText(" SKIP");
        jPanel1.add(labelSkip1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 430, 90, 40));

        labelY.setBackground(new java.awt.Color(102, 84, 83));
        labelY.setFont(new java.awt.Font("Kid Games", 0, 24)); // NOI18N
        labelY.setForeground(new java.awt.Color(102, 84, 83));
        jPanel1.add(labelY, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 220, 150, 30));

        labelX.setFont(new java.awt.Font("Kid Games", 0, 24)); // NOI18N
        labelX.setForeground(new java.awt.Color(102, 84, 83));
        jPanel1.add(labelX, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 220, 150, 30));

        labelFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/img/escenario/FondoJuego.png"))); // NOI18N
        labelFondo.setText("jLabel1");
        jPanel1.add(labelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmTablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmTablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelA1;
    private javax.swing.JLabel labelA2;
    private javax.swing.JLabel labelA3;
    private javax.swing.JLabel labelA4;
    private javax.swing.JLabel labelA5;
    private javax.swing.JLabel labelA6;
    private javax.swing.JLabel labelA7;
    private javax.swing.JLabel labelA8;
    private javax.swing.JLabel labelA9;
    private javax.swing.JLabel labelB1;
    private javax.swing.JLabel labelB2;
    private javax.swing.JLabel labelB3;
    private javax.swing.JLabel labelB4;
    private javax.swing.JLabel labelB5;
    private javax.swing.JLabel labelB6;
    private javax.swing.JLabel labelB7;
    private javax.swing.JLabel labelB8;
    private javax.swing.JLabel labelB9;
    private javax.swing.JLabel labelC1;
    private javax.swing.JLabel labelC2;
    private javax.swing.JLabel labelC3;
    private javax.swing.JLabel labelC4;
    private javax.swing.JLabel labelC5;
    private javax.swing.JLabel labelC6;
    private javax.swing.JLabel labelC7;
    private javax.swing.JLabel labelC8;
    private javax.swing.JLabel labelC9;
    private javax.swing.JLabel labelComidaContador1;
    private javax.swing.JLabel labelComidaContador2;
    private javax.swing.JLabel labelD1;
    private javax.swing.JLabel labelD2;
    private javax.swing.JLabel labelD3;
    private javax.swing.JLabel labelD4;
    private javax.swing.JLabel labelD5;
    private javax.swing.JLabel labelD6;
    private javax.swing.JLabel labelD7;
    private javax.swing.JLabel labelD8;
    private javax.swing.JLabel labelD9;
    private javax.swing.JLabel labelE1;
    private javax.swing.JLabel labelE2;
    private javax.swing.JLabel labelE3;
    private javax.swing.JLabel labelE4;
    private javax.swing.JLabel labelE5;
    private javax.swing.JLabel labelE6;
    private javax.swing.JLabel labelE7;
    private javax.swing.JLabel labelE8;
    private javax.swing.JLabel labelE9;
    private javax.swing.JLabel labelF1;
    private javax.swing.JLabel labelF2;
    private javax.swing.JLabel labelF3;
    private javax.swing.JLabel labelF4;
    private javax.swing.JLabel labelF5;
    private javax.swing.JLabel labelF6;
    private javax.swing.JLabel labelF7;
    private javax.swing.JLabel labelF8;
    private javax.swing.JLabel labelF9;
    private javax.swing.JLabel labelFComidaJ1;
    private javax.swing.JLabel labelFComidaJ2;
    private javax.swing.JLabel labelFondo;
    private javax.swing.JLabel labelG1;
    private javax.swing.JLabel labelG2;
    private javax.swing.JLabel labelG3;
    private javax.swing.JLabel labelG4;
    private javax.swing.JLabel labelG5;
    private javax.swing.JLabel labelG6;
    private javax.swing.JLabel labelG7;
    private javax.swing.JLabel labelG8;
    private javax.swing.JLabel labelG9;
    private javax.swing.JLabel labelGanador;
    private javax.swing.JLabel labelH1;
    private javax.swing.JLabel labelH2;
    private javax.swing.JLabel labelH3;
    private javax.swing.JLabel labelH4;
    private javax.swing.JLabel labelH5;
    private javax.swing.JLabel labelH6;
    private javax.swing.JLabel labelH7;
    private javax.swing.JLabel labelH8;
    private javax.swing.JLabel labelH9;
    private javax.swing.JLabel labelSkip1;
    private javax.swing.JLabel labelSkip2;
    private javax.swing.JLabel labelX;
    private javax.swing.JLabel labelY;
    private javax.swing.JLabel labeli1;
    private javax.swing.JLabel labeli2;
    private javax.swing.JLabel labeli3;
    private javax.swing.JLabel labeli4;
    private javax.swing.JLabel labeli5;
    private javax.swing.JLabel labeli6;
    private javax.swing.JLabel labeli7;
    private javax.swing.JLabel labeli8;
    private javax.swing.JLabel labeli9;
    // End of variables declaration//GEN-END:variables
}
