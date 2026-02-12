/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import plataforma.Plataforma;

public abstract class Contenido {

    protected Plataforma plataforma;

    public Contenido(Plataforma plataforma) {
        this.plataforma = plataforma;
    }

    public void publicar() {
        plataforma.publicar(crearMensaje());
    }

    protected abstract String crearMensaje();
}
