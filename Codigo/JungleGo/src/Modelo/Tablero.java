/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Jason
 */
public class Tablero {
    private Ficha tablero[][];

    public Tablero() {
        tablero=new Ficha[9][9];
    }//Tablero

    public Tablero(int fila, int columna) {
        tablero=new Ficha[fila][columna];
    }//Tablero

    public void setFicha(Ficha ficha, int fila, int columna) {
        tablero[fila][columna]=ficha;
    }//setFicha
    
    public void eliminarFicha(int fila, int columna){
        tablero[fila][columna]=null;
    }//eliminarFicha
    
    public Ficha getFicha(int fila, int columna){
        return tablero[fila][columna];
    }//getFicha
    
    public Ficha[][] getArray(){
        return tablero;
    }//getArrat

    @Override
    public String toString() {
        String mostrarTablero="";
        for(int fila=0;fila<tablero.length;fila++){
            for(int columna=0;columna<tablero[fila].length;columna++){
               if(tablero[fila][columna]==null){
		mostrarTablero=mostrarTablero+"[ null ]";
		}else{
                    if(tablero[fila][columna].getnJugador()==1){
                        mostrarTablero=mostrarTablero+"[Blanco]";
			}else{
                            mostrarTablero=mostrarTablero+"[Negro]";
                    }//fin if else
                }//fin if-else 
            }//for
            mostrarTablero=mostrarTablero+"\n";
        }//for
        return mostrarTablero;
    }//toString
    
    
    
}//fin clase
