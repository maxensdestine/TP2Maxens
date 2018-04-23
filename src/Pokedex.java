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

    private ArrayList<Personne> utilisateur = new ArrayList();
    private ArrayList<Specimen> infoPersonne = new ArrayList();
    private ArrayList<Animal> infoAnimal = new ArrayList();
    private ArrayList<Poisson> infoPoisson = new ArrayList();
    private ArrayList<MammifereMarin> infoMammifereMarin = new ArrayList();
    private ArrayList<Autre> infoAutre = new ArrayList();
    private ArrayList<Mineral> infoMineral = new ArrayList();
    private ArrayList<Plante> infoPlante = new ArrayList();
    
    
    public void programme() {

        chargerPersonne();
        test();
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
            System.out.println("Erreur inconnu ligne 38 dans Pokedex");
        } catch (NumberFormatException e) {
            System.out.println("Erreur lors de la conversion de l'age");
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
        Scanner scanner = new Scanner(System.in); //creer scanner
        String username;  //variable string pour que l'utilisateur entre son username
        String password;  //variable string pour que l'utilisateur entre son mot de passe
        int compteur = 0;  //compteur du nombre de tentative par l'utilisateur
        boolean verif = true;  //true or false, le username ou le mot de passe est valide
        int position = 0;  //position de l'utilisateur dans la liste Personne
        boolean loop = true; //loop pour le programme
        boolean continuer = true;  //loop pour demander a l'utilisateur ce qu'il veut faire

        while (loop) {
            try {
                while (compteur < 3 && verif) {
                    System.out.println("Nom d'utilisateur:");
                    username = scanner.nextLine();

                    for (int i = 0; i < (utilisateur.size()); i++) {
                        if (username.equals(utilisateur.get(i).getCodeAcces())) {
                            verif = false;
                            loop = true;
                            position = i;
                            break;
                        } else {
                            loop = false;
                        }
                    }

                    compteur++;
                }

                if (loop == false) {
                    break;
                }

                verif = true;
                compteur = 0;

                while (compteur < 3 && verif) {
                    System.out.println("Mot de passe:");
                    password = scanner.nextLine();

                    if (password.equals(utilisateur.get(position).getMotDePasseEncryp())) {
                        verif = false;
                        loop = true;
                    } else {
                        loop = false;
                    }

                    compteur++;
                }

                if (loop == false) {
                    break;
                }

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Veuillez effectuer des saisis valides!");
            }

            System.out.println("");
            System.out.println("Bonjour! Bienvenu dans le pokedex!");

            while (continuer) {
                continuer = menu_option(utilisateur);
            }
            //////////////////////////////////////////////////////////////////////sauvegarder toute les entrer (SERIALISATION)
            loop = false;
        }
        System.out.println("");
        System.out.println("Merci!");
        System.out.println("Et a la prochaine fois!");
    }

    private boolean menu_option(ArrayList<Personne> utilisateur) {
        boolean erreur = true;
        int choix = 0;
        boolean continuer = true;

        System.out.println("Que voulez-vous faire?");
        System.out.println("1. Consultez des spécimens déjà saisis");
        System.out.println("2. Saisir un nouveau spéciment");
        System.out.println("3. Modifier un spécimen");
        System.out.println("4. Statistique");
        System.out.println("5. Quitter le programme");
        System.out.println("Veuillez entrer votre choix:");

        while (erreur) {
            choix = entrer();

            if (choix > 5 || choix < 1) {
                erreur = true;
            } else {
                erreur = false;
            }
        }

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
        boolean erreur = true;
        int choix = 0;

        System.out.println("");
        System.out.println("Que voulez-vous faire?");
        System.out.println("1. Afficher toutes les entrées?");
        System.out.println("2. Afficher les entrées d'un seul type?");
        System.out.println("3. Afficher les animaux par ordre chronologique d'observation?");
        System.out.println("Veuillez entrer votre choix:");

        while (erreur) {
            choix = entrer();

            if (choix > 3 || choix < 1) {
                erreur = true;
            } else {
                erreur = false;
            }
        }

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
        //////////////////////////////////////////////////////////////////////////creer un numero de transaction unique
        //////////////////////////////////////////////////////////////////////////la date d'observation (sous qu'elle forme? DD/MM/YYYY?)
        //////////////////////////////////////////////////////////////////////////le type d'entrer
        //////////////////////////////////////////////////////////////////////////tout les attributs propres a ce type
        //////////////////////////////////////////////////////////////////////////la quantite observer
        //////////////////////////////////////////////////////////////////////////garder en memoire l'utilisateur qui effectue cette entrer
    }

    //methode pour modifier un specimen du pokedex
    private void modifierSpecimen() {
        boolean erreur = true;
        int choix = 0;

        System.out.println("");
        System.out.println("Que voulez-vous faire?");
        System.out.println("1. Supprimer un specimen");
        System.out.println("2. Modifier la quantite apercu d'un specimen");
        System.out.println("3. Retourner au menu principal");
        System.out.println("Veuillez entrer votre choix:");

        while (erreur) {
            choix = entrer();

            if (choix > 3 || choix < 1) {
                erreur = true;
            } else {
                erreur = false;
            }
        }

        switch (choix) {
            case 1:
                choix = entrerTypeSpecimen();

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
                System.out.println("");
                break;
        }
    }

    //methode pour afficher les statistiques du pokedex
    private void statistique(ArrayList<Personne> utilisateur) {
        boolean erreur = true;
        int choix = 0;

        System.out.println("");
        System.out.println("Que voulez-vous voir?");
        System.out.println("1. Afficher le nombre d'entrees, pour chacun des specimens?");
        System.out.println("2. Afficher le nombre d'entrees, pour chacune des personnes?");
        System.out.println("3. Afficher les informations des personnes du syteme?");
        System.out.println("Veuillez entrer votre choix:");

        while (erreur) {
            choix = entrer();

            if (choix > 3 || choix < 1) {
                erreur = true;
            } else {
                erreur = false;
            }
        }

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
    private int entrer() {
        Scanner scanner = new Scanner(System.in); //creer scanner
        int choix = 0; //variable du choix de l'utilisateur

        try {
            choix = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) { //catch pour erreur de nombre reel
            System.out.println("Veuillez saisir un nombre réel!");
        }
        return choix; // return le choix de l'utilisateur
    }

    //methode pour choisir le type de specimen desirer
    private int entrerTypeSpecimen() {
        boolean erreur = true;
        int choix = 0;

        System.out.println("Quel type desirez-vous observer?");
        System.out.println("1. Poisson");
        System.out.println("2. Mammifere marin");
        System.out.println("3. Plante aquatique");
        System.out.println("4. Mineral");
        System.out.println("Veuillez entrer votre choix:");

        while (erreur) {
            choix = entrer();

            if (choix > 4 || choix < 1) {
                erreur = true;
            } else {
                erreur = false;
            }
        }

        return choix;
    }
}
