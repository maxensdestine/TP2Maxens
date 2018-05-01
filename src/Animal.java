/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1767250
 */
public abstract class Animal extends Specimen {

      protected String bruitDuCri;
    /**
     *
     * @param nom
     * @param couleur
     * @param taille
     * @param dateObservation
     * @param perso
     */
    public Animal(String nom, String couleur, double taille,String dateObservation, Personne perso,String bruitDuCri) {
        super(nom,couleur,taille,dateObservation,perso);
        this.bruitDuCri=bruitDuCri;
    }

    
  
    
    protected abstract void cri();
}
