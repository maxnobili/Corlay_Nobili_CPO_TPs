/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_nobili_corlay;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author maxim
 */
public class Partie { 
    Scanner scanner = new Scanner(System.in);
    Joueur [] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    Grille grilleJeu;
    int jetrest = 0;
   
    public Partie(Joueur joueur1,Joueur joueur2){
       ListeJoueurs[0] = joueur1;
       ListeJoueurs[1] = joueur2;
    }
   
    public void initialiserPartie(){
       grilleJeu = new Grille();
       for (int i = 0 ;i <= 4; i++){
            Random ltn = new Random();
            int lignetn = ltn.nextInt(5) ;
            Random ctn = new Random();
            int colonnetn = ctn.nextInt(6) ;
            grilleJeu.placerTrouNoir(lignetn, colonnetn);
       }     
       for(int i=0; i<21 ; i++){
           ListeJoueurs[0].ListeJetons[i] = new Jeton("rouge");
           ListeJoueurs[1].ListeJetons[i] = new Jeton("jaune");
       }
       grilleJeu.afficherGrilleSurConsole();
       
    }
   
    public void debuterPartie(){
       Random rn = new Random();
       int jdep = rn.nextInt(1) ;
       if (jdep == 0){
           joueurCourant = ListeJoueurs[0];
       }
       if (jdep == 1){
           joueurCourant = ListeJoueurs[1];
       }
       attribuerCouleursAuxJoueurs();
       while (grilleJeu.etreGagnantePourJoueur(joueurCourant) == false && grilleJeu.etreRemplie() == true){
           System.out.println(joueurCourant.nom);
           System.out.println("Donnez la colonne dans laquelle vous souhaitez jouer:");
           int colonne = scanner.nextInt();
           if (colonne != 0 && colonne != 1 && colonne != 2 && colonne != 3 && colonne != 4 && colonne != 5 && colonne != 6 ){
               System.out.println("Vous avez commit l'irréparable...Réessayez");
               continue;
           }
           if (grilleJeu.colonneRemplie(colonne) == true){
               System.out.println("La colonne est remplie");
               continue;
           }
           for (int i = 20 ; i > 0 ; i--){
               if (joueurCourant.ListeJetons[i] != null){
                   jetrest = i;
                   joueurCourant.ListeJetons[jetrest] = null;
                   break;
               }
           }
           Jeton jeton = joueurCourant.ListeJetons[jetrest-1];
           
           grilleJeu.ajouterJetonDansColonne(jeton, colonne);
           for(int i=0; i<6; i++){
               if (grilleJeu.CelluleJeu[i][colonne].lireCouleurDuJeton()== "vide"){
                   if(grilleJeu.CelluleJeu[i][colonne].presenceTrouNoir() == true){
                       grilleJeu.CelluleJeu[i][colonne].activerTrouNoir();
                       grilleJeu.CelluleJeu[i][colonne].supprimerJeton() ;
                       break;
                   }
               }
            }
           grilleJeu.afficherGrilleSurConsole();
           
           if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == true){
               break;
           }
           if (joueurCourant == ListeJoueurs[1]){
               joueurCourant = ListeJoueurs[0];
           }
           else{
               joueurCourant = ListeJoueurs[1];
           }
       }
       if (grilleJeu.etreGagnantePourJoueur(joueurCourant) == true){
           if (joueurCourant == ListeJoueurs[1]){
               System.out.println("Le gagnant est " + ListeJoueurs[0].nom);
           }
           if (joueurCourant == ListeJoueurs[0]){
               System.out.println("Le gagnant est " + ListeJoueurs[1].nom);
           }
       }
    }
   
    public void attribuerCouleursAuxJoueurs(){
       Random rn = new Random();
       int temp = rn.nextInt(1) ;
       if (temp == 1){
           ListeJoueurs[0].couleur = "rouge";
           ListeJoueurs[1].couleur = "jaune";
       }
       else{
           ListeJoueurs[0].couleur = "jaune";
           ListeJoueurs[1].couleur = "rouge";
       }

    }
   
}

