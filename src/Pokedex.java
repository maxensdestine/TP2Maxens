
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

    public void programme() {

        chargerPersonne();
        test();
        menuDebut(utilisateur);

    }

    private void chargerPersonne() {
        String Texte;
        int i = 0;
        //On cree un bufferedreader pour pouvoir lire le fichier
        BufferedReader Lire = null;
        try {
            Lire = new BufferedReader(new FileReader("personnes.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Le fichier est introuvable");
        }

        try {
            while ((Texte = Lire.readLine()) != null) {/*programme reste dans la boucle tant qu'il reste une ligne dans le fichier
Ici le programme prend la ligne et la transforme en tableau, en se servant de ; comme separateur*/
                String[] ligne = Texte.split(";");// ; est le separateur pour les informations du fichier
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

    }

    private void menuDebut(ArrayList<Personne> utilisateur) {
        Scanner scanner = new Scanner(System.in); //creer scanner
        String username;
        String password;
        int compteur = 0;
        boolean verif = true;
        int position = 0;
        boolean loop = true;
        boolean continuer = true;

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
                    }

                    compteur++;
                }

            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Veuillez effectuer des saisis valides!");
            }

            if (loop == false) {
                break;
            }

            System.out.println("");
            System.out.println("Bonjour! Bienvenu dans le pokedex!");

            while (continuer) {
                continuer = menu_option();
            }
            loop = false;
        }

        System.out.println("À la prochaine fois!");
    }

    private boolean menu_option() {
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
                statistique();
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
                System.out.println("Hello world!");
                //trier toute les entrees par ordre croissant (tri par insertion) dans une liste (affichage ordre croissant)
                //inverser la pile en file pour ordre decroissant
                break;
            case 2:
                System.out.println("Quel type desirez-vous observer?");
                System.out.println("1. Poisson");
                System.out.println("2. Mammifere marin");
                System.out.println("3. Plante aquatique");
                System.out.println("4. Mineral");
                System.out.println("Veuillez entrer votre choix:");

                erreur = true;
                
                while (erreur) {
                    choix = entrer();

                    if (choix > 4 || choix < 1) {
                        erreur = true;
                    } else {
                        erreur = false;
                    }
                }
                
                // tri a bulle croissant, affichage d'un type
                break;
            case 3:
                //tri au choix, TOUT les ANIMAUX par ordre chronologique d'observation
                break;
        }
    }

    private void nouveauSpecimen() {

    }

    private void modifierSpecimen() {

    }

    private void statistique() {

    }

    private int entrer() {
        Scanner scanner = new Scanner(System.in); //creer scanner
        int choix = 0;

        try {
            choix = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Veuillez saisir un nombre réel!");
        }
        return choix;
    }
}
