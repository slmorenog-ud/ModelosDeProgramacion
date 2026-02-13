/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package plataforma;

public class TikTok implements Plataforma {

    @Override
    public void publicar(String mensaje) {
        System.out.println("TikTok -> " + mensaje + " 🎵");
    }
}
