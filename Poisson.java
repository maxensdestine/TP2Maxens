/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1767250
 */
public class Poisson extends Animal {

    private enum Sexe {
        MALE, FEMELE
    };

    private enum Eau {
        SALEE, DOUCE
    };
    private Sexe sexe;
    private Eau eau;
    private String bruitDuCri;

    /**
     *
     * @param nom
     * @param couleur
     * @param taille
     * @param dateObservation
     * @param perso
     * @param sexe
     * @param eau
     * @param bruitDuCri
     */
    public Poisson(String nom, String couleur, double taille, String dateObservation, Personne perso,Sexe sexe, Eau eau, String bruitDuCri) {
       super(nom,couleur,taille,dateObservation,perso);
        this.sexe = sexe;
        this.eau = eau;
        this.bruitDuCri = bruitDuCri;
    }

  

    @Override
    protected void cri() {
        System.out.println(bruitDuCri);
    }
}
