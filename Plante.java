/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1767250
 */
public abstract class Plante extends Specimen {

    private enum Position {
        FLOTTANTE, IMMERGEE
    };

    private enum Eau {
        SALEE, DOUCE
    };
    private Position position;
    private Eau eau;

    /**
     *
     * @param nom
     * @param couleur
     * @param taille
     * @param dateObservation
     * @param perso
     * @param position
     * @param eau
     */
    public Plante(String nom, String couleur, double taille,String dateObservation, Personne perso,Position position, Eau eau) {
        super(nom,couleur,taille,dateObservation,perso);
        this.position = position;
        this.eau = eau;
    }

}
