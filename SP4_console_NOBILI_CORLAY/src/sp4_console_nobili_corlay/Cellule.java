/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sp4_console_nobili_corlay;

/**
 *
 * @author maxim
 */
public class Cellule { 
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
    
    public void Cellule(){
        jetonCourant = null ;
        desintegrateur = false;
        trouNoir = false;
                
    }
    
    public boolean affecterJeton(Jeton JetonJoueur){
        if(jetonCourant == null){
            jetonCourant = JetonJoueur ;
            return true;
        }
        else{
            return false ;
        }
    }
    
    public Jeton recupererJeton(Jeton Jeton){
        return Jeton;
    }
    public boolean supprimerJeton(){
        jetonCourant = null;
        return true;
    }
    
    public boolean placerTrouNoir(){
        if(trouNoir == false){
            trouNoir = true;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean placerDesintegrateur(){
        
    }
    
    public boolean presenceTrouNoir(){
        if (trouNoir == true){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean presenceDesintegrateur(){
        
    }
    
    public String lireCouleurDuJeton(){
        if(jetonCourant!=null){
            jetonCourant.lireCouleur() ;
            return jetonCourant.Couleur ;
        }
        else{
            return "vide" ;
        }
    }
    
    public boolean recupererDesintegrateur(){
        
    }
    
    public boolean activerTrouNoir(){
        if (trouNoir == true& jetonCourant != null){
            jetonCourant = null;
            trouNoir = false;
            return true;
        }
        else{
            return false;
        }
    }
}


