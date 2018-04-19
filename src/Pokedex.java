
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

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
  public void programme(){
  
  
  
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
        } catch (IOException e) {System.out.println("Erreur inconnu lors de la fermeture de personnes.txt");}

    }
    
    private void test(){
    
    for(Personne temp: utilisateur){
        System.out.println(temp.getNom()+" "+temp.getMotDePasseEncryp()+" ");
    }
    
    }
}
