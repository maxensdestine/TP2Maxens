
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1767250
 */
public class Pokedex {

    private static Scanner scanner = new Scanner(System.in);

    private ArrayList<Personne> utilisateur = new ArrayList();
    private ArrayList<Specimen> infoSpecimen = new ArrayList();

    private Personne currentPers = null;

    public void programme() {

        chargerPersonne();
        menuDebut(utilisateur);

    }

    private void chargerPersonne() {
        String texte;
        int i = 0;
        //On cree un bufferedreader pour pouvoir lire le fichier
        BufferedReader Lire = null;
        try {
            Lire = new BufferedReader(new FileReader("personnes.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier est introuvable");
        }

        try {
            while ((texte = Lire.readLine()) != null) {/*programme reste dans la boucle tant qu'il reste une ligne dans le fichier
         Ici le programme prend la ligne et la transforme en tableau, en se servant de ; comme separateur*/
                String[] ligne = texte.split(";");// ; est le separateur pour les informations du fichier
                Personne personne = new Personne(ligne[0], ligne[1], ligne[2], Integer.parseInt(ligne[3]));
                utilisateur.add(personne);
            }
        } catch (IOException e) {
            System.out.println("Erreur inconnu ligne 38 dans Pokedex.");
        } catch (NumberFormatException e) {
            System.out.println("Erreur lors de la conversion de l'age.");
        }

        try {
            Lire.close();//fermeture du fichier
        } catch (IOException e) {
            System.out.println("Erreur inconnu lors de la fermeture de personnes.txt");
        }

    }

    private void test() {

        for (Personne temp : utilisateur) {
            System.out.println(temp.getNom() + " " + temp.getMotDePasseEncryp() + " ");
        }
        System.out.println("");

    }

    //methode du menu de debut
    private void menuDebut(ArrayList<Personne> utilisateur) {
        String username, password;  //variable string pour que l'utilisateur entre son username
        //variable string pour que l'utilisateur entre son mot de passe
        int compteur = 0, position = 0;  //compteur du nombre de tentative par l'utilisateur
        //true or false, le username ou le mot de passe est valide
        //position de l'utilisateur dans la liste Personne
        boolean limiteSortie = true, continuer = true, bonneValeur = false; //loop pour le programme
        //loop pour demander a l'utilisateur ce qu'il veut faire

        while (limiteSortie) {
            try {
                while (compteur < 3 && !bonneValeur) {

                    System.out.println("Nom d'utilisateur:");
                    username = scanner.nextLine();

                    for (int i = 0; i < (utilisateur.size()); i++) {
                        if (username.equals(utilisateur.get(i).getCodeAcces())) {
                            bonneValeur = true;
                            limiteSortie = true;
                            position = i;
                            break;
                        } else {
                            limiteSortie = false;
                        }
                    }

                    compteur++;
                }

                if (!limiteSortie) {
                    break;
                }

                bonneValeur = false;
                compteur = 0;

                while (compteur < 3 && !bonneValeur) {
                    System.out.println("Mot de passe:");
                    password = scanner.nextLine();

                    if (password.equals(utilisateur.get(position).getMotDePasseEncryp())) {
                        bonneValeur = true;
                        limiteSortie = true;
                    } else {
                        limiteSortie = false;
                    }

                    compteur++;
                }

                if (!limiteSortie) {
                    break;
                }

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Veuillez effectuer des saisis valides!");
            }
            currentPers = utilisateur.get(position);
            System.out.println("\nBonjour! Bienvenue dans le pokedex!");

            while (continuer) {
                continuer = menu_option(utilisateur);
            }/////////////sauvegarder toute les entrer (SERIALISATION)
            limiteSortie = false;

        }

        System.out.println("\nMerci! \n"
                + "Et a la prochaine fois!\n");
    }

    private boolean menu_option(ArrayList<Personne> utilisateur) {
        boolean erreur = true;
        int choix = 0;
        boolean continuer = true;

        System.out.println("Que voulez-vous faire? \n"
                + "1. Consultez des spécimens déjà saisis \n"
                + "2. Saisir un nouveau spéciment \n"
                + "3. Modifier un spécimen \n"
                + "4. Statistique \n"
                + "5. Quitter le programme \n"
                + "Veuillez appuyer sur le chiffre correspondant a votre choix: \n");

        choix = entrer(1, 5);

        switch (choix) {
            case 1:
                consulterSpecimen();
                break;
            case 2:
                nouveauSpecimen();
                break;
            case 3:
                modifierSpecimen();
                break;
            case 4:
                statistique(utilisateur);
                break;
            case 5:
                continuer = false;
                break;
        }

        return continuer;
    }

    private void consulterSpecimen() {

        int choix = 0;

        System.out.println("Que voulez-vous faire? \n"
                + "1. Afficher toutes les entrées? \n"
                + "2. Afficher les entrées d'un seul type? \n"
                + "3. Afficher les animaux par ordre chronologique d'observation? \n"
                + "Veuillez entrer votre choix: \n");

        choix = entrer(1, 3);

        switch (choix) {
            case 1:
                //////////////////////////////////////////////////////////////////trier toute les entrees par ordre croissant (tri par insertion) dans une liste (affichage ordre croissant)
                //////////////////////////////////////////////////////////////////inverser la pile en file pour ordre decroissant
                break;
            case 2:
                choix = entrerTypeSpecimen();

                ////////////////////////////////////////////////////////////////// tri a bulle croissant, affichage d'un type
                break;
            case 3:
                //////////////////////////////////////////////////////////////////tri au choix, TOUT les ANIMAUX par ordre chronologique d'observation
                break;
        }
    }

    //methode pour ajouter un nouveau specimen au pokedex
    private void nouveauSpecimen() {

        switch (entrerTypeSpecimen()) {
            case 1:
                creationMammifere();
                break;
            case 2:
                creationPoisson();
                break;
            case 3:
                creationAutre();
                break;
            case 4:
                creationPlante();
                break;
            case 5:
                creationMineral();
                break;
        }

    }

    //methode pour modifier un specimen du pokedex
    private void creationMammifere() {
        String nom, couleur, dateObs, bruitDuCri;
        double taille;
        boolean estMale, estEauSalee, estCarnivore;
        nom = prendreNom();
        couleur = prendreCouleur();
        taille = prendreTaille();
        dateObs = prendreDateObserv();
        estMale = estMale();
        estEauSalee = estEauSalee();
        estCarnivore = estCarnivore();
        bruitDuCri = prendreBruitDuCri();
        Specimen specimen = new MammifereMarin(nom, couleur, taille, dateObs, currentPers, estMale, estEauSalee, estCarnivore, bruitDuCri);
        infoSpecimen.add(specimen);

    }

    private void creationPoisson() {
        String nom, couleur, dateObs, bruitDuCri;
        double taille;
        boolean estMale, estEauSalee;

        nom = prendreNom();
        couleur = prendreCouleur();
        taille = prendreTaille();
        dateObs = prendreDateObserv();
        estMale = estMale();
        estEauSalee = estEauSalee();
        bruitDuCri = prendreBruitDuCri();
        Specimen specimen = new Poisson(nom, couleur, taille, dateObs, currentPers, estMale, estEauSalee, bruitDuCri);
        infoSpecimen.add(specimen);

    }

    private void creationAutre() {
        String nom, couleur, dateObs, bruitDuCri;
        double taille;
        boolean estMale;
        nom = prendreNom();
        couleur = prendreCouleur();
        taille = prendreTaille();
        dateObs = prendreDateObserv();
        estMale = estMale();
        bruitDuCri = prendreBruitDuCri();
        Specimen specimen = new Autre(nom, couleur, taille, dateObs, currentPers, estMale, bruitDuCri);
        infoSpecimen.add(specimen);

    }

    private void creationPlante() {
        String nom, couleur, dateObs;
        double taille;
        boolean estEauSalee, estFlottante;
        nom = prendreNom();
        couleur = prendreCouleur();
        taille = prendreTaille();
        dateObs = prendreDateObserv();
        estEauSalee = estEauSalee();
        estFlottante = estFlottante();
        Specimen specimen = new Plante(nom, couleur, taille, dateObs, currentPers, estEauSalee, estFlottante);
        infoSpecimen.add(specimen);

    }

    private void creationMineral() {
        String nom, couleur, dateObs;
        double taille;
        nom = prendreNom();
        couleur = prendreCouleur();
        taille = prendreTaille();
        dateObs = prendreDateObserv();
        Specimen specimen = new Mineral(nom, couleur, taille, dateObs, currentPers);
        infoSpecimen.add(specimen);
    }

    private boolean estFlottante() {
        boolean estFlottante = true;
        System.out.println("Flottante(1) ou immerge(2)?");

        if (entrer(1, 2) == 2) {
            estFlottante = false;
        }

        return estFlottante;

    }

    private boolean estEauSalee() {
        boolean estEauSalee = true;
        System.out.println("Eau salee(1) ou eau douce(2)?");

        if (entrer(1, 2) == 2) {
            estEauSalee = false;
        }

        return estEauSalee;

    }

    private boolean estCarnivore() {
        boolean estCarnivore = true;
        System.out.println("Carnivore(1) ou vegetarien(2)?");

        if (entrer(1, 2) == 2) {
            estCarnivore = false;
        }

        return estCarnivore;

    }

    private boolean estMale() {
        boolean estMale = true;
        System.out.println("Male(1) ou femelle(2)?");

        if (entrer(1, 2) == 2) {
            estMale = false;
        }

        return estMale;
    }

    private String prendreNom() {
        String nom = "";
        System.out.println("Veuillez entrer le nom du specimen:");

        try {
            nom = scanner.nextLine();
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Veuillez saisir un nom plus court!");
        }
        return nom;
    }

    private String prendreCouleur() {
        String couleur = "";
        System.out.println("Veuillez entrer la couleur du specimen:");
        
        try {
            couleur = scanner.nextLine();
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Veuillez saisir un nom plus court!");
        }
        return couleur;

    }

    private String prendreDateObserv() {
        String dateObs = null;
        boolean estValide = false;

        while (!estValide) {
            System.out.println("Veuillez entrer la date d'observation en format AnneeMoisJour:");
            dateObs = scanner.nextLine();

            if (dateObs.contains("[0-9]+") == false) {
                if (dateObs.length() == 8) {
                    estValide = true;
                    break;
                } else {
                    System.out.println("Il faut saisir un nombre de 8 chiffres.");
                }
            }
        }
        return dateObs;
    }

    private double prendreTaille() {
        double taille = 0;
        boolean bonneValeur = false;

        System.out.println("Veuillez entrer la taille:");
        while (!bonneValeur) {
            try {
                taille = Integer.parseInt(scanner.nextLine());
                bonneValeur = true;
            } catch (NumberFormatException e) {
                System.out.println("Assurez-vous d'entrer un nombre.");
            }

        }
        return taille;
    }

    private String prendreBruitDuCri() {
        String bruit = "";
        System.out.println("Veuillez entrer le bruit que fait le specimen:");
        try {
            bruit = scanner.nextLine();
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Veuillez saisir un nom plus court!");
        }
        return bruit;
    }

    private void modifierSpecimen() {
        int choix;

        System.out.println(" \n Que voulez-vous faire? \n"
                + "1. Supprimer un specimen \n"
                + "2. Modifier la quantite apercu d'un specimen \n"
                + "3. Retourner au menu principal \n"
                + "Veuillez entrer votre choix: \n");

        choix = entrer(1, 3);

        switch (choix) {
            case 1:
                choix = entrerTypeSpecimen();
                switch (choix) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;

                }

                //////////////////////////////////////////////////////////////////afficher la liste de tous les elements de ce type (en ordre croissant) 
                //////////////////////////////////////////////////////////////////demander quel element supprimer
                //////////////////////////////////////////////////////////////////supprimer cet element
                break;
            case 2:
                choix = entrerTypeSpecimen();

                //////////////////////////////////////////////////////////////////afficher la liste de tous les elements de ce type (en ordre croissant) 
                //////////////////////////////////////////////////////////////////demander quel element devra etre modifier
                //////////////////////////////////////////////////////////////////demander le nombre a ajouter a la quantite existente
                //////////////////////////////////////////////////////////////////supprimer cet element
                break;
            case 3: //retour au menu principal
                System.out.println();
                break;
            default:
                System.out.println("erreur ligne 454");
        }
    }

    //methode pour afficher les statistiques du pokedex
    private void statistique(ArrayList<Personne> utilisateur) {
        int choix = 0;

        System.out.println("\n Que voulez-vous voir? \n"
                + "1. Afficher le nombre d'entrees, pour chacun des specimens? \n"
                + "2. Afficher le nombre d'entrees, pour chacune des personnes? \n"
                + "3. Afficher les informations des personnes du syteme? \n"
                + "Veuillez entrer votre choix:");

        choix = entrer(1, 3);

        switch (choix) {
            case 1:
                //////////////////////////////////////////////////////////////////afficher le nombre d'entrer pour chacun des types de specimens
                break;
            case 2:
                //////////////////////////////////////////////////////////////////afficher le nombre d'entrer pour chacune des personnes
                break;
            case 3:
                for (int i = 0; i < (utilisateur.size()); i++) {
                    System.out.println("La personne #" + (i + 1) + " est " + utilisateur.get(i).getNom() + " et il/elle a " + utilisateur.get(i).getAge() + " ans.");
                }
                break;
        }
    }

    //methode pour entrer nombre int de l'utilisateur
    private int entrer(int borneBas, int borneHaut) {
        int choix = 0; //variable du choix de l'utilisateur

        boolean erreur = true;

        while (erreur) {
            try {
                choix = Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) { //catch pour erreur de nombre reel
                System.out.println("Veuillez saisir un nombre réel!");
            }

            if (choix < (borneBas - 1) || choix > (borneHaut + 1)) {
                erreur = true;
                System.out.println("Assurez-vous d'entrer une valeur entre " + borneBas + " et " + borneHaut + ".");
            } else {
                erreur = false;
                break;
            }
        }

        return choix; // return le choix de l'utilisateur
    }

    //methode pour choisir le type de specimen desirer
    private int entrerTypeSpecimen() {
        int choix = 0;

        System.out.println("Quel type desirez-vous ? \n"
                + "1. Mammifere marin \n"
                + "2. Poisson \n"
                + "3. Autre type d'animal"
                + "4. Plante aquatique \n"
                + "5. Mineral \n"
                + "Veuillez entrer votre choix: \n");

        choix = entrer(1, 5);

        return choix;
    }
}
