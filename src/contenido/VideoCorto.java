/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import plataforma.Plataforma;

public class VideoCorto extends Contenido {

    public VideoCorto(Plataforma plataforma) {
        super(plataforma);
    }

    @Override
    protected String crearMensaje() {
        return "Publicando un Video Corto (Short/Reel)";
    }
}
