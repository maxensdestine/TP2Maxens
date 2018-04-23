/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1767250
 */
public class Autre extends Animal {

    private enum Sexe {
        MALE, FEMELE
    };
    private Sexe sexe;
    private String bruitDuCri;

    /**
     *
     * @param nom
     * @param couleur
     * @param taille
     * @param dateObservation
     * @param perso
     * @param sexe
     * @param bruitDuCri
     */
    public Autre(String nom, String couleur, double taille, String dateObservation, Personne perso,Sexe sexe, String bruitDuCri) {
        super(nom,couleur,taille,dateObservation,perso);
        this.sexe = sexe;
        this.bruitDuCri = bruitDuCri;
    }

    @Override
    protected void cri() {
        System.out.println(bruitDuCri);
    }
}
