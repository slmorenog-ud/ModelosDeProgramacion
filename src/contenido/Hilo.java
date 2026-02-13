/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import plataforma.Plataforma;

public class Hilo extends Contenido {

    public Hilo(Plataforma plataforma) {
        super(plataforma);
    }

    @Override
    protected String crearMensaje() {
        return "Publicando un Hilo/Thread (serie de publicaciones)";
    }
}
