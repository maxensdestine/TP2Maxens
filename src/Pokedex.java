
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
        menu(utilisateur);

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

    private void menu(ArrayList<Personne> utilisateur) {
        Scanner scanner = new Scanner(System.in); //creer scanner
        String username;
        String password;
        int compteur = 0;
        boolean verif = true;
        int position = 0;
        boolean loop = true;

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
            menu_option();

            loop = false;
        }

        System.out.println("À la prochaine fois!");
    }

    private int menu_option() {
        Scanner scanner = new Scanner(System.in); //creer scanner
        boolean erreur = true;
        int choix = 0;

        System.out.println("Que voulez-vous faire?");
        System.out.println("1. Consultez des spécimens déjà saisis");
        System.out.println("2. Saisir un nouveau spéciment");
        System.out.println("3. Modifier un spécimen");
        System.out.println("4. Statistique");
        System.out.println("5. Quitter le programme");

        while (erreur) {
            try {
                choix = Integer.parseInt(scanner.nextLine());

                if (choix > 5 || choix < 1) {
                    erreur = false;
                }

            } catch (NumberFormatException e) {
                System.out.println("Veuillez saisir un nombre réel!");
            }
        }

        return choix;
    }
}
