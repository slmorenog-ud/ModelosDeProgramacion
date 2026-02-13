/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app;

import plataforma.*;
import contenido.*;

public class Test {
    public static void main(String[] args) {
        System.out.println("=== PATRÓN BRIDGE - SISTEMA DE PUBLICACIÓN MULTI-RED ===\n");
        
        // Crear instancias de todas las plataformas (Implementaciones)
        Plataforma instagram = new Instagram();
        Plataforma tiktok = new TikTok();
        Plataforma x = new X();
        Plataforma youtube = new YouTube();
        
        System.out.println("--- CASO 1: Diferentes contenidos en Instagram ---");
        Contenido foto = new Foto(instagram);
        foto.publicar();
        
        Contenido historia = new Historia(instagram);
        historia.publicar();
        
        Contenido videoCorto = new VideoCorto(instagram);
        videoCorto.publicar();
        
        Contenido hilo = new Hilo(instagram);
        hilo.publicar();
        
        System.out.println("\n--- CASO 2: Mismo contenido (Foto) en diferentes plataformas ---");
        Contenido fotoPara4Redes = new Foto(instagram);
        fotoPara4Redes.publicar();
        
        fotoPara4Redes.setPlataforma(tiktok);
        fotoPara4Redes.publicar();
        
        fotoPara4Redes.setPlataforma(x);
        fotoPara4Redes.publicar();
        
        fotoPara4Redes.setPlataforma(youtube);
        fotoPara4Redes.publicar();
        
        System.out.println("\n--- CASO 3: Video Corto cambiando de plataforma dinámicamente ---");
        Contenido video = new VideoCorto(tiktok);
        System.out.println("Publicando primero en TikTok:");
        video.publicar();
        
        System.out.println("Ahora cambiamos a YouTube:");
        video.setPlataforma(youtube);
        video.publicar();
        
        System.out.println("\n--- CASO 4: Hilo en X (Twitter) y luego en Instagram ---");
        Contenido hiloX = new Hilo(x);
        hiloX.publicar();
        
        hiloX.setPlataforma(instagram);
        hiloX.publicar();
        
        System.out.println("\n--- CASO 5: Combinaciones variadas ---");
        Contenido historiaYT = new Historia(youtube);
        historiaYT.publicar();
        
        Contenido videoTikTok = new VideoCorto(tiktok);
        videoTikTok.publicar();
        
        System.out.println("\n=== VENTAJAS DEL PATRÓN BRIDGE ===");
        System.out.println("✓ Sin condicionales (if/switch) para elegir plataforma");
        System.out.println("✓ Sin explosión de clases (no necesitamos FotoInstagram, FotoTikTok, etc.)");
        System.out.println("✓ Cambio dinámico de plataforma en tiempo de ejecución");
        System.out.println("✓ Fácil agregar nuevas plataformas o tipos de contenido");
        System.out.println("✓ Separación clara: Abstracción (Contenido) vs Implementación (Plataforma)");
    }
}


