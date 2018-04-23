/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1767250
 */
public class Specimen {

    protected String nom, couleur,dateObservation;
    protected double taille;
    protected Personne perso;

    /**
     *
     * @param nom
     * @param couleur
     * @param taille
     * @param dateObservation
     * @param perso
     */
    public Specimen(String nom, String couleur, double taille,String dateObservation, Personne perso) {
        this.nom = nom;
        this.couleur = couleur;
        this.taille = taille;
        this.dateObservation = dateObservation;
        this.perso = perso;
    }  

}
