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
public class Ficha {
    private String rutaImagen;
    private int nJugador;

    public Ficha(String rutaImagen, int nJugador) {
        this.rutaImagen = rutaImagen;
        this.nJugador = nJugador;
    }//constructor

    public String getRutaImagen() {
        return rutaImagen;
    }//getRutaImagen

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }//setRutaImagen

    public int getnJugador() {
        return nJugador;
    }//getnJugador

    public void setnJugador(int nJugador) {
        this.nJugador = nJugador;
    }//setnJugador

    @Override
    public String toString() {
        return "Ficha{" + "rutaImagen=" + rutaImagen + ", nJugador=" + nJugador + '}';
    }//toString

    
}//Fin clase
