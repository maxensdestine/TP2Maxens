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

    private boolean estMale,estEauSalee;

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
    public Poisson(String nom, String couleur, double taille, String dateObservation, Personne perso,boolean estMale,boolean estEauSalee, String bruitDuCri) {
       super(nom,couleur,taille,dateObservation,perso,bruitDuCri);
        this.estMale=estMale;
        this.estEauSalee=estEauSalee;
    }

  

    @Override
    protected void cri() {
        System.out.println(bruitDuCri);
    }
}
