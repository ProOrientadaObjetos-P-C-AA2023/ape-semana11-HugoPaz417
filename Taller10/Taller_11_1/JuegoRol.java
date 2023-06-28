package Taller_11_1;

import java.util.Scanner;

public class JuegoRol {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese los nombres para el guerrero, el mago y el arquero");
        String nomGuerrero = sc.nextLine();
        String nomMago = sc.nextLine();
        String nomArquero = sc.nextLine();
        Guerrero guerrero = new Guerrero(nomGuerrero,2000, 1, 4, "ìwí");
        Mago mago = new Mago(nomMago,1000, 1, 20, "Black meteorite");
        Arquero arquero = new Arquero(nomArquero,1500, 1, 4, "Trululu");
        int opcion = 0;
        while (opcion != 4){
            System.out.println("Seleccionar opción");
            System.out.println("1. Combate entre: Guerrero y mago");
            System.out.println("2. Combate entre: Mago y arquero");
            System.out.println("3. Combate entre: Arquero y guerrero");
            System.out.println("4. Salir");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:
                    if (guerrero.nombre==null) {
                        System.out.println("Ingrese el nombre del personaje");
                        System.out.println("Guerrero: " + guerrero.nombre);
                    }
                    if (mago.nombre==null) {
                        System.out.println("Ingrese el nombre del personaje");
                        System.out.println("Mago: " + mago.nombre);
                    }
                    guerrero.atacar(mago);
                    guerrero.defender(guerrero.puntosVida/3);
                    mago.atacar(guerrero);
                    mago.defender(mago.poderMagico/mago.puntosVida);
                    break;
                case 2:
                    if (mago.nombre==null){
                        System.out.println("Ingrese el nombre del personaje");
                        System.out.println("Mago: "+mago.nombre);
                    }
                    if (arquero.nombre==null) {
                        System.out.println("Ingrese el nombre del personaje");
                        System.out.println("Arquero: " + arquero.nombre);
                    }
                    mago.atacar(arquero);
                    mago.defender(mago.poderMagico/mago.puntosVida);
                    arquero.atacar(mago);
                    arquero.defender(arquero.nivelXp* arquero.puntosVida);
                    break;
                case 3:
                    if (arquero.nombre==null) {
                        System.out.println("Ingrese el nombre del personaje");
                        System.out.println("Arquero: " + arquero.nombre);
                    }
                    if (guerrero.nombre==null) {
                        System.out.println("Ingrese el nombre del personaje");
                        System.out.println("Guerrero: "+guerrero.nombre);
                    }
                    arquero.atacar(guerrero);
                    arquero.defender(arquero.nivelXp* arquero.puntosVida);
                    guerrero.atacar(arquero);
                    guerrero.defender(guerrero.puntosVida/3);
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Numeros del 1-4");
            }
        }
    }
}
abstract class Personaje {
    public String nombre;
    public double puntosVida;
    public double nivelXp;
    public double puntosXP;
    public void danioPersonaje(double danioAtaque){
        puntosVida=puntosVida-danioAtaque;
    }
    public Personaje(String nombre, double puntosVida, double nivelXp) {
        this.nombre = nombre;
        this.puntosVida = puntosVida;
        this.nivelXp = nivelXp;
    }
    public abstract void atacar(Personaje enemigo);
    public abstract void defender(double puntosDefensa);
    public abstract void puntosDeVida(double puntosVida);
    public abstract void nivel(double puntosXP);
}
class Guerrero extends Personaje{
    public double fuerza;
    public String ataque;
    public Guerrero(String nombre, double puntosVida, double nivelXp, double fuerza, String ataque) {
        super(nombre, puntosVida, nivelXp);
        this.fuerza = fuerza;
        this.ataque = ataque;
    }

    @Override
    public void atacar(Personaje enemigo) {
        double puntosAtaque = ((puntosVida/fuerza)*nivelXp);
        System.out.println(nombre+" ataca a "+enemigo.nombre+" y le resta -"+puntosAtaque+" a su vida");
    }
    @Override
    public void defender(double puntosDefensa) {
        puntosDefensa = (puntosVida/3);
        danioPersonaje(puntosDefensa);
        System.out.println(nombre+" le resta "+puntosDefensa+" al ataque rival");
    }
    @Override
    public void puntosDeVida(double puntosVida) {
        if (puntosVida<=0){
            System.out.println(nombre+" perdió el combate");
            System.out.println(nombre+" obtiene 50 xp");
            puntosXP+=50;
        }
    }
    @Override
    public void nivel(double puntosXP) {
        if (puntosXP>=50 && puntosXP<=100){
            nivelXp=2;
        } else if (puntosXP>100 && puntosXP<=200) {
            nivelXp=3;
        } else if (puntosXP>200 && puntosXP<=500) {
            nivelXp=4;
        }
    }
}
class Mago extends Personaje{
    public double poderMagico;
    public String hechizo;

    public Mago(String nombre, double puntosVida, double nivelXp, double poderMagico, String hechizo) {
        super(nombre, puntosVida, nivelXp);
        this.poderMagico = poderMagico;
        this.hechizo = hechizo;
    }

    @Override
    public void atacar(Personaje enemigo) {
        double puntosAtaque = (poderMagico*(puntosVida/nivelXp));
        System.out.println(nombre+" ataca a "+enemigo.nombre+" con el hechizo de "+hechizo+" y le resta -"+puntosAtaque+" a su vida");
    }
    @Override
    public void defender(double puntosDefensa) {
        puntosDefensa = (poderMagico/puntosVida);
        danioPersonaje(puntosDefensa);
        System.out.println(nombre+" le resta "+puntosDefensa+" al ataque rival");
    }
    public void puntosDeVida(double puntosVida) {
        if (puntosVida<=0){
            System.out.println(nombre+" perdió el combate");
            System.out.println(nombre+" obtiene 50 xp");
            puntosXP+=50;
        }

    }
    @Override
    public void nivel(double puntosXP) {
        if (puntosXP>=50 && puntosXP<=100){
            nivelXp=2;
        } else if (puntosXP>100 && puntosXP<=200) {
            nivelXp=3;
        } else if (puntosXP>200 && puntosXP<=500) {
            nivelXp=4;
        }
    }
}
class Arquero extends Personaje{
    public double aim;
    public String habilidadDistancia;
    public Arquero(String nombre, double puntosVida, double nivelXp, double presicion, String habilidadDistancia) {
        super(nombre, puntosVida, nivelXp);
        this.aim = presicion;
        this.habilidadDistancia = habilidadDistancia;
    }
    @Override
    public void atacar(Personaje enemigo) {
        double puntosAtaque = (nivelXp*aim);
        System.out.println(nombre+" ataca a "+enemigo.nombre+" y le resta -"+puntosAtaque+" a su vida");
    }
    @Override
    public void defender(double puntosDefensa) {
        puntosDefensa = (nivelXp*puntosVida);
        danioPersonaje(puntosDefensa);
        System.out.println(nombre+" le resta "+puntosDefensa+" al ataque rival");
    }
    public void puntosDeVida(double puntosVida) {
        if (puntosVida<=0){
            System.out.println(nombre+" perdió el combate");
            System.out.println(nombre+" obtiene 50 xp");
            puntosXP+=50;
        }
    }
    @Override
    public void nivel(double puntosXP) {
        if (puntosXP>=50 && puntosXP<=100){
            nivelXp=2;
        } else if (puntosXP>100 && puntosXP<=200) {
            nivelXp=3;
        } else if (puntosXP>200 && puntosXP<=500) {
            nivelXp=4;
        }
    }
}