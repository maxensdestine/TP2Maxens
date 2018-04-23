/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1767250
 */
public class Personne {

    private String codeAcces, nom, motDePasse, motDePasseEncryp;
    private int age;

    protected Personne(String codeAcces, String motDePasseEncryp, String nom, int age) {
        this.codeAcces = codeAcces;
        this.motDePasseEncryp = motDePasseEncryp;
        this.nom = nom;
        this.age = age;

    }

    protected String getMotDePasse() {

        return motDePasse;
    }

    protected String getMotDePasseEncryp() {

        return motDePasseEncryp;
    }

    protected String getCodeAcces() {

        return codeAcces;
    }

    protected String getNom() {

        return nom;
    }

    protected int getAge() {

        return age;
    }
}
