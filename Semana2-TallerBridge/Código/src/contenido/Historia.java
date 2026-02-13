/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package contenido;

import plataforma.Plataforma;

public class Historia extends Contenido {

    public Historia(Plataforma plataforma) {
        super(plataforma);
    }

    @Override
    protected String crearMensaje() {
        return "Publicando una Historia ";
    }
}

