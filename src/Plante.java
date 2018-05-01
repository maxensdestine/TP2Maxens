/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1767250
 */
public class Plante extends Specimen {

    private boolean estFlottante,estEauSalee;
  

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
    public Plante(String nom, String couleur, double taille,String dateObservation, Personne perso,boolean estFlottante, boolean estEauSalee) {
        super(nom,couleur,taille,dateObservation,perso);
        this.estFlottante = estFlottante;
        this.estEauSalee = estEauSalee;
    }

}
