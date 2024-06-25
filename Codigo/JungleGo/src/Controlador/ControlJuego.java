/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Ficha;
import Modelo.Tablero;
import Vista.FrmTablero;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Jason
 */
public class ControlJuego implements MouseListener {

    FrmTablero tableroGo;
    boolean booleanTurno = true;
    Ficha ficha;
    int puntaje1 = 0;
    int puntaje2 = 0;
    Tablero tablero = new Tablero();

    public ControlJuego(FrmTablero tableroGo) {
        this.tableroGo = tableroGo;
    }//constructor

    public int turnoActual() {
        if (booleanTurno == true) {
            return 1;
        } else {
            return 2;
        }//else
    }//turnoActual
    
    public String ganador(){
        int conteo1=0;
        int conteo2=0;
        String mensaje;
        for(int indice=0;indice<9;indice++){
            for(int indice2=0; indice2<9; indice2++){
                if(tablero.getArray()[indice][indice2]!=null){
                    if(tablero.getArray()[indice][indice2].getnJugador()==1){
                        conteo1++;
                    }else{
                        conteo2++;
                    }//else
                }//if
            }//for
        }//for
        
        conteo1+= tableroGo.getPuntaje(1);
        conteo2+= tableroGo.getPuntaje(2);
        
        if(conteo1>conteo2){
            mensaje="El ganador fue el jugador #1";
        }else if(conteo1<conteo2){
            mensaje="El ganador fue el jugador #2";
        }else{
            mensaje="Es un empate";
        }//else
        return mensaje;
    }//ganador

    public void cambiarTurno(int turno) {
        if (turno == 1) {
            booleanTurno = false;
            tableroGo.cambiarColorSkip(turno);
        } else {
            booleanTurno = true;
            tableroGo.cambiarColorSkip(turno);
        }//if
    }//cambiarTurno

    public Ficha getFicha(int turno) {
        if (turno == 1) {
            ficha = new Ficha("/Vista/img/fichas/Ficha1.png", 1);
        } else {
            ficha = new Ficha("/Vista/img/fichas/Ficha2.png", 2);
        }//else
        return ficha;
    }//getFicha

    public void jugarTurno(int turno, Point mouse) {
        if (tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX())) == null) { //Este if funciona para evaluar si el espacio se encuentra vacío, de ser así procede a colocar la ficha y cambiar el turno
            detectarSuicidio(turno, mouse);
        }//if
    }//jugarTurno

    public void colocarFicha(int x, int y, Ficha ficha) {
        tablero.setFicha(ficha, x, y);
        tableroGo.setImagen(x, y, ficha.getRutaImagen());
    }//colocarFicha

    public void eliminarFicha(int x, int y) {
        tablero.eliminarFicha(x, y);
        tableroGo.setImagen(x, y, "");
    }//eliminarFicha

    public void sumarPuntaje(int turno) {
        if (turno == 1) { // Se le suma al jugador 2
            puntaje2++;
            tableroGo.setPuntaje(turno, String.valueOf(puntaje2));
        } else { // Se le suma al jugador 1
            puntaje1++;
            tableroGo.setPuntaje(turno, String.valueOf(puntaje1));
        }
    }//sumarPuntaje

    public void lastStep(int turno, Point mouse) {
        colocarFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()), getFicha(turno));
        cambiarTurno(turno);
    }//lasStep

    public void detectarSuicidio(int turno, Point mouse) {
        if (tableroGo.getFila(mouse.getY()) >= 1) { // Verifica que la fila recibida no este en el borde superior
            if (tableroGo.getFila(mouse.getY()) <= 7) {// Verifica que la fila recibida no este en el borde inferior

                if (tableroGo.getColumna(mouse.getX()) >= 1) { // Verifica que la columna recibida no este en el borde izquierdo
                    if (tableroGo.getColumna(mouse.getX()) <= 7) {// Verifica que la columna recibida no este en el borde derecho

                        //Primera verificacion - Verifica que la casila superior sea null o casilla inferior null o casilla izquierda es null o casilla derecha es null
                        if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())) == null || tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())) == null
                                || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1) == null || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1) == null) {
                            lastStep(turno, mouse);
                            comerFicha(5, turno, mouse);
                        } else {//SI 1 sola no fue null detecta si es suicidio
                            if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno || tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno
                                    || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1).getnJugador() == turno || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1).getnJugador() == turno) {//Verifica si cualquier ficha alrededor es del mismo jugador
                                lastStep(turno, mouse);
                                comerFicha(5, turno, mouse);
                            } else {
                                System.out.println("Todas las fichas alrededor son del jugador contrario");
                            }//else
                        }//else

                    } else {// Se da cuenta que la columna esta en el borde derecho

                        if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())) == null || tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())) == null
                                || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1) == null) { // Verifica si la casilla superior, inferior o izquierda respectivamente sea null
                            lastStep(turno, mouse);
                            comerFicha(6, turno, mouse);
                        } else {//SI 1 sola no fue null detecta si es suicidio
                            if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno || tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno
                                    || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1).getnJugador() == turno) {//Verifica si cualquier ficha alrededor (superior, inferior o izquierda respectivamente) es del mismo jugador
                                lastStep(turno, mouse);
                                comerFicha(6, turno, mouse);
                            } else {
                                System.out.println("Todas las fichas alrededor son del jugador contrario, a la derecha tiene el borde");
                            }//else
                        }//else
                    }//else
                } else {//Se da cuenta que la columna este en el borde izquierdo
                    if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())) == null || tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())) == null
                            || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1) == null) { // Verifica si la casilla superior, inferior o derecha respectivamente sea null
                        lastStep(turno, mouse);
                        comerFicha(4, turno, mouse);
                    } else {//SI 1 sola no fue null detecta si es suicidio
                        if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno || tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno
                                || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1).getnJugador() == turno) {//Verifica si cualquier ficha alrededor (superior, inferior o derecha respectivamente) es del mismo jugador
                            lastStep(turno, mouse);
                            comerFicha(4, turno, mouse);
                        } else {
                            System.out.println("Todas las fichas alrededor, son del jugador contrario, a la izquierda tiene el borde");
                        }//else
                    }//else
                }//else
            } else {// Se da cuenta que la fila esta en el borde inferior

                if (tableroGo.getColumna(mouse.getX()) == 0) { // Verifica si la columna está en el borde izquierdo
                    if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())) == null //Verifica si la casilla superior o derecha respectivamente sea null
                            || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1) == null) {
                        lastStep(turno, mouse);
                        comerFicha(7, turno, mouse);
                    } else {//SI 1 sola no fue null detecta si es suicidio
                        if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno //Verifica si cualquier ficha alrededor (superior o derecha respectivamente) es del mismo jugador
                                || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1).getnJugador() == turno) {
                            lastStep(turno, mouse);
                            comerFicha(7, turno, mouse);
                        } else {
                            System.out.println("Todas las fichas alrededor son del jugador contrario");
                        }//else
                    }//else
                } else if (tableroGo.getColumna(mouse.getX()) == 8) {//Verifica si la columna está en el borde derecho
                    if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())) == null //Verifica si la casilla superior o izquierda respectivamente sea null
                            || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1) == null) {
                        lastStep(turno, mouse);
                        comerFicha(9, turno, mouse);
                    } else {//SI 1 sola no fue null detecta si es suicidio
                        if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno //Verifica si cualquier ficha alrededor (superior o i      zquierda respectivamente) es del mismo jugador
                                || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1).getnJugador() == turno) {
                            lastStep(turno, mouse);
                            comerFicha(9, turno, mouse);
                        } else {
                            System.out.println("Todas las fichas alrededor son del jugador contrario");
                        }//else
                    }//else

                } else {

                    if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())) == null //Verifica si la casilla superior, izquierda o derecha respectivamente sea null
                            || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1) == null || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1) == null) {
                        lastStep(turno, mouse);
                        comerFicha(8, turno, mouse);
                    } else {//SI 1 sola no fue null detecta si es suicidio
                        if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno //Verifica si cualquier ficha alrededor (superior, izquierda o derecha respectivamente) es del mismo jugador
                                || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1).getnJugador() == turno || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1).getnJugador() == turno) {
                            lastStep(turno, mouse);
                            comerFicha(8, turno, mouse);
                        } else {
                            System.out.println("Todas las fichas alrededor son del jugador contrario");
                        }//else
                    }//else
                }//else
            }//else
        } else {// Se da cuenta que la fila esta en el borde superior
            if (tableroGo.getColumna(mouse.getX()) == 0) { // Verifica si la columna está en el borde izquierdo
                if (tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())) == null //Verifica si la casilla inferior o derecha respectivamente sea null
                        || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1) == null) {
                    lastStep(turno, mouse);
                    comerFicha(1, turno, mouse);
                } else {//SI 1 sola no fue null detecta si es suicidio
                    if (tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno //Verifica si cualquier ficha alrededor (inferior o derecha respectivamente) es del mismo jugador
                            || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1).getnJugador() == turno) {
                        lastStep(turno, mouse);
                        comerFicha(1, turno, mouse);
                    } else {
                        System.out.println("Todas las fichas alrededor son del jugador contrario");
                    }//else
                }//else
            } else if (tableroGo.getColumna(mouse.getX()) == 8) {//Verifica si la columna está en el borde derecho
                if (tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())) == null //Verifica si la casilla inferior o izquierda respectivamente sea null
                        || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1) == null) {
                    lastStep(turno, mouse);
                    comerFicha(3, turno, mouse);
                } else {//SI 1 sola no fue null detecta si es suicidio
                    if (tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno //Verifica si cualquier ficha alrededor (inferior o izquierda respectivamente) es del mismo jugador
                            || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1).getnJugador() == turno) {
                        lastStep(turno, mouse);
                        comerFicha(3, turno, mouse);
                    } else {
                        System.out.println("Todas las fichas alrededor son del jugador contrario");
                    }//else
                }//else
            } else {
                if (tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())) == null //Verifica si la casilla inferior, izquierda o derecha respectivamente sea null
                        || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1) == null || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1) == null) {
                    lastStep(turno, mouse);
                    comerFicha(2, turno, mouse);
                } else {//SI 1 sola no fue null detecta si es suicidio
                    if (tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())).getnJugador() == turno //Verifica si cualquier ficha alrededor (inferior, izquierda o derecha respectivamente)  es del mismo jugador
                            || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1).getnJugador() == turno || tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1).getnJugador() == turno) {
                        lastStep(turno, mouse);
                        comerFicha(2, turno, mouse);
                        System.out.println("ntro aqui");
                    } else {
                        System.out.println("Todas las fichas alrededor son del jugador contrario");
                    }//else
                }//else
            }//else
        }//else
    }//detectarSuicidio

    public void detectarFichaComida(int turno, int x, int y) {
        if (x >= 1) { // Verifica que la fila recibida no este en el borde superior
            if (x <= 7) {// Verifica que la fila recibida no este en el borde inferior

                if (y >= 1) { // Verifica que la columna recibida no este en el borde izquierdo
                    if (y <= 7) {// Verifica que la columna recibida no este en el borde derecho

                        //Primera verificacion - Verifica que la casila superior sea null, casilla inferior null,casilla izquierda es null Y casilla derecha es null
                        if (tablero.getFicha(x - 1, y) != null && tablero.getFicha(x + 1, y) != null
                                && tablero.getFicha(x, y - 1) != null && tablero.getFicha(x, y + 1) != null) {
                            System.out.println("elimino la ficha");
                            if (tablero.getFicha(x - 1, y).getnJugador() == turno && tablero.getFicha(x + 1, y).getnJugador() == turno
                                    && tablero.getFicha(x, y - 1).getnJugador() == turno && tablero.getFicha(x, y + 1).getnJugador() == turno) {//Verifica que todas las fichas de alrededor sean del jugador contrario
                                /* Se llama al metodo para borrar la ficha y al metodo para asignar los puntos */
                                eliminarFicha(x, y);
                                sumarPuntaje(turno);
                                System.out.println("elimino la ficha");
                            }//if
                        }//if

                    } else {// Se da cuenta que la columna esta en el borde derecho

                        if (tablero.getFicha(x - 1, y) != null && tablero.getFicha(x + 1, y) != null
                                && tablero.getFicha(x, y - 1) != null) { // Verifica si la casilla superior, inferior o izquierda respectivamente sea null
                            if (tablero.getFicha(x - 1, y).getnJugador() == turno && tablero.getFicha(x + 1, y).getnJugador() == turno
                                    && tablero.getFicha(x, y - 1).getnJugador() == turno) {//Verifica si cualquier ficha alrededor (superior, inferior o izquierda respectivamente) es del mismo jugador
                                /* Se llama al metodo para borrar la ficha y al metodo para asignar los puntos */
                                eliminarFicha(x, y);
                                sumarPuntaje(turno);
                            }//if
                        }//if
                    }//else
                } else {//Se da cuenta que la columna este en el borde izquierdo
                    if (tablero.getFicha(x - 1, y) != null && tablero.getFicha(x + 1, y) != null
                            && tablero.getFicha(x, y + 1) != null) { // Verifica si la casilla superior, inferior o derecha respectivamente sea null
                        if (tablero.getFicha(x - 1, y).getnJugador() == turno && tablero.getFicha(x + 1, y).getnJugador() == turno
                                && tablero.getFicha(x, y + 1).getnJugador() == turno) {//Verifica si cualquier ficha alrededor (superior, inferior o derecha respectivamente) es del mismo jugador
                            /* Se llama al metodo para borrar la ficha y al metodo para asignar los puntos */
                            eliminarFicha(x, y);
                            sumarPuntaje(turno);
                        }//if
                    }//if
                }//else
            } else {// Se da cuenta que la fila esta en el borde inferior

                if (y == 0) { // Verifica si la columna está en el borde izquierdo
                    if (tablero.getFicha(x - 1, y) != null //Verifica si la casilla superior o derecha respectivamente sea null
                            && tablero.getFicha(x, y + 1) != null) {
                        if (tablero.getFicha(x - 1, y).getnJugador() == turno //Verifica si cualquier ficha alrededor (superior o derecha respectivamente) es del mismo jugador
                                && tablero.getFicha(x, y + 1).getnJugador() == turno) {
                            /* Se llama al metodo para borrar la ficha y al metodo para asignar los puntos */
                            eliminarFicha(x, y);
                            sumarPuntaje(turno);
                        }//if
                    }//if
                } else if (y == 8) {//Verifica si la columna está en el borde derecho
                    if (tablero.getFicha(x - 1, y) != null //Verifica si la casilla superior o izquierda respectivamente sea null
                            && tablero.getFicha(x, y - 1) != null) {
                        if (tablero.getFicha(x - 1, y).getnJugador() == turno //Verifica si cualquier ficha alrededor (superior o i      zquierda respectivamente) es del mismo jugador
                                && tablero.getFicha(x, y - 1).getnJugador() == turno) {
                            /* Se llama al metodo para borrar la ficha y al metodo para asignar los puntos */
                            eliminarFicha(x, y);
                            sumarPuntaje(turno);
                        }//if
                    }//if
                } else {
                    if (tablero.getFicha(x - 1, y) != null //Verifica si la casilla superior, izquierda o derecha respectivamente sea null
                            && tablero.getFicha(x, y - 1) != null && tablero.getFicha(x, y + 1) != null) {
                        if (tablero.getFicha(x - 1, y).getnJugador() == turno //Verifica si cualquier ficha alrededor (superior, izquierda o derecha respectivamente) es del mismo jugador
                                && tablero.getFicha(x, y - 1).getnJugador() == turno && tablero.getFicha(x, y + 1).getnJugador() == turno) {
                            /* Se llama al metodo para borrar la ficha y al metodo para asignar los puntos */
                            eliminarFicha(x, y);
                            sumarPuntaje(turno);
                        }//if
                    }//if
                }//else
            }//else
        } else {// Se da cuenta que la fila esta en el borde superior
            System.out.println("Primer print");
            if (y == 0) { // Verifica si la columna está en el borde izquierdo
                System.out.println("Segundo print");
                if (tablero.getFicha(x + 1, y) != null //Verifica si la casilla inferior o derecha respectivamente sea null
                        && tablero.getFicha(x, y + 1) != null) {
                    System.out.println("Tercer  print");
                    if (tablero.getFicha(x + 1, y).getnJugador() == turno //Verifica si cualquier ficha alrededor (inferior o derecha respectivamente) es del mismo jugador
                            && tablero.getFicha(x, y + 1).getnJugador() == turno) {
                        eliminarFicha(x, y);
                        sumarPuntaje(turno);
                        System.out.println("Cuarto print");
                    }//if
                }//if
            } else if (y == 8) {//Verifica si la columna está en el borde derecho
                System.out.println("Primer print");
                if (tablero.getFicha(x + 1, y) != null //Verifica si la casilla inferior o izquierda respectivamente sea null
                        && tablero.getFicha(x, y - 1) != null) {
                    System.out.println("Segundo print");
                    if (tablero.getFicha(x + 1, y).getnJugador() == turno //Verifica si cualquier ficha alrededor (inferior o izquierda respectivamente) es del mismo jugador
                            && tablero.getFicha(x, y - 1).getnJugador() == turno) {
                        System.out.println("Tercer print");
                        eliminarFicha(x, y);
                        sumarPuntaje(turno);
                    }//if
                }//if
            } else {
                if (tablero.getFicha(x + 1, y) != null //Verifica si la casilla inferior, izquierda o derecha respectivamente sea null
                        && tablero.getFicha(x, y - 1) != null && tablero.getFicha(x, y + 1) != null) {

                    if (tablero.getFicha(x + 1, y).getnJugador() == turno //Verifica si cualquier ficha alrededor (inferior, izquierda o derecha respectivamente)  es del mismo jugador
                            && tablero.getFicha(x, y - 1).getnJugador() == turno && tablero.getFicha(x, y + 1).getnJugador() == turno) {

                        eliminarFicha(x, y);
                        sumarPuntaje(turno);
                    }//if
                }//if
            }//else
    }//else
}//detectarFichaComida

public void comerFicha(int numero, int turno, Point mouse) {
        if (numero == 1) {
            detectarFED(turno, mouse);
            detectarFEA(turno, mouse);
        } else if (numero == 2) {
            detectarFEI(turno, mouse);
            detectarFEA(turno, mouse);
            detectarFED(turno, mouse);
        } else if (numero == 3) {
            detectarFEA(turno, mouse);
            detectarFEI(turno, mouse);
        } else if (numero == 4) {
            detectarFEA(turno, mouse);
            detectarFED(turno, mouse);
            detectarFES(turno, mouse);
        } else if (numero == 5) {
            detectarFED(turno, mouse);
            detectarFEI(turno, mouse);
            detectarFES(turno, mouse);
            detectarFEA(turno, mouse);
        } else if (numero == 6) {
            detectarFEI(turno, mouse);
            detectarFES(turno, mouse);
            detectarFEA(turno, mouse);
        } else if (numero == 7) {
            detectarFED(turno, mouse);
            detectarFES(turno, mouse);
        } else if (numero == 8) {
            detectarFED(turno, mouse);
            detectarFEI(turno, mouse);
            detectarFES(turno, mouse);
        } else {
            detectarFEI(turno, mouse);
            detectarFES(turno, mouse);
        }//else
        
    }//comerFicha

    public void detectarFED(int turno, Point mouse) {
        if (tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1) != null) {
            if (tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1).getnJugador() != turno) {
                detectarFichaComida(turno, tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) + 1);
                        System.out.println("entro aqui D");

            }//if
        }//if
    }//detectarFED

    public void detectarFEI(int turno, Point mouse) {
         if (tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1) != null) {
            if (tablero.getFicha(tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1).getnJugador() != turno) {
                detectarFichaComida(turno, tableroGo.getFila(mouse.getY()), tableroGo.getColumna(mouse.getX()) - 1);
                        System.out.println("entro aqui I");

            }//if
        }//if
    }//detectarFEI

    public void detectarFES(int turno, Point mouse) {
         if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())) != null) {
            if (tablero.getFicha(tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX())).getnJugador() != turno) {
                detectarFichaComida(turno, tableroGo.getFila(mouse.getY()) - 1, tableroGo.getColumna(mouse.getX()));
                        System.out.println("entro aqui S");

            }//if
        }//if
    }//detectarFES

    public void detectarFEA(int turno, Point mouse) {
         if (tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())) != null) {
            if (tablero.getFicha(tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX())).getnJugador() != turno) {
                detectarFichaComida(turno, tableroGo.getFila(mouse.getY()) + 1, tableroGo.getColumna(mouse.getX()));
                        System.out.println("entro aqui A");

            }//if
        }//if
    }//detectarFEA

    //Metodos del MouseListener
    @Override
public void mouseClicked(MouseEvent arg0) {
        tableroGo.detectarAccion(tableroGo.getCoordenadas());
    }

    @Override
public void mousePressed(MouseEvent arg0) {

    }

    @Override
public void mouseReleased(MouseEvent arg0) {
    }

    @Override
public void mouseEntered(MouseEvent arg0) {
    }

    @Override
public void mouseExited(MouseEvent arg0) {
    }

}//fin clase
