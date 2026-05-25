import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;





public class TP1 {

    public static void main(String[] params){
        //L'HEUR DU SYSTEM By WOUAFO TALLA JEAN GAEL
        
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Bienvenue dans le système de facturation de Toiture-Pour-Tous.");
        System.out.println("----------------------------------------------------------------------------------");
        //DECLARATION ET INITIALISATION DES VARIABLE ET DES CONSTANTS
        int CHOIX_OPTION;
        double MONTANT_TOTAL = 0;
        double MONTANT_GLOBAL = 0;
        final double Tps = 0.05;
        final double TVQ = 0.09975;
        
        int TYPE_DE_DECOUVERTURE = 0;
        final String TYPE_DE_COUVERTURE_1 = "La membrane élastomère";
        final String TYPE_DE_COUVERTURE_2 = "La membrane TPO";
        final String TYPE_DE_COUVERTURE_3 = "La membrane EPDM";
        final String TYPE_DE_COUVERTURE_4 = "Le multicouche gravier et bitume";
        final String TYPE_DE_COUVERTURE_5 = "Le bardeau en asphalte";
        final String TYPE_DE_COUVERTURE_6 = "La tôle";
        final String TYPE_DE_COUVERTURE_7 = "L’ardoise";
        
        double PRIX_PAR_PIED = 0.0;
        final double PRIX_PAR_PIED_1 = 21.75;
        final double PRIX_PAR_PIED_2 = 13.25;
        final double PRIX_PAR_PIED_3 = 12.50;
        final double PRIX_PAR_PIED_4 = 12.25;
        final double PRIX_PAR_PIED_5 = 7.50;
        final double PRIX_PAR_PIED_6 = 26.50;
        final double PRIX_PAR_PIED_7 = 36.25;
        
        double DUREE_DE_VIE = 0;
        final double DUREE_DE_VIE_1 = 30;
        final double DUREE_DE_VIE_2 = 28;
        final double DUREE_DE_VIE_3 = 25;
        final double DUREE_DE_VIE_4 = 23;
        final double DUREE_DE_VIE_5 = 20;
        final double DUREE_DE_VIE_6 = 50;
        final double DUREE_DE_VIE_7 = 125;
        
        double tpsAvecMontant;
        double tvqAvecMontant;
        double SOUS_TOTAL;
        
 
        int TOTAL_DE_TOIT = 0;
        int TYPE_DE_TOIT =0;
        
        
        double SURFACE_DE_COUVERTURE = 0;
        int NUMBRE_DE_CHOIX = 0;
        char MODE_DE_PAYEMENT;
        String NOM_DU_CLIENT ;
        String PRENOM_DU_CLIENT;
        String ADDRESS_DU_CLIENT;
        String NUMERO_DU_CLIENT;
        do{
            
        LocalDateTime dateHeureSysteme = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-mm-yy HH:mm:ss");
        
        System.out.println("*** Menu de choix ***");
        System.out.println("1. Facturer le recouvrement d’une toiture");
        System.out.println("2. Afficher le nombre de recouvrements et le montant total de tous les recouvrements");
        System.out.println("3. Quitter le programme ");
        
        System.out.print("Entrez votrez choix:");
        CHOIX_OPTION = Clavier.lireInt();
        
        while(CHOIX_OPTION !=1 && CHOIX_OPTION !=2 && CHOIX_OPTION !=3){  
        System.out.println("Entrée invalide !\n");
        System.out.println("\n*** Menu de choix ***");
        System.out.println("1. Facturer le recouvrement d’une toiture");
        System.out.println("2. Afficher le nombre de recouvrements et le montant total de tous les recouvrements");
        System.out.println("3. Quitter le programme ");
        
        System.out.print("Entrez votrez choix:");
        CHOIX_OPTION = Clavier.lireInt();
        
        
        }
        // OPTION ET VALIDATION DE L'OPTION 1
        if(CHOIX_OPTION==1){
        System.out.print("Entrez le nom du client:");
         NOM_DU_CLIENT = Clavier.lireString();
        
        System.out.print("Entrez le prénom du client:");
        PRENOM_DU_CLIENT = Clavier.lireString();
        
        System.out.print("Entrez le numéro de téléphone du client :");
        NUMERO_DU_CLIENT = Clavier.lireString();
        String tel = NUMERO_DU_CLIENT.replaceFirst("(\\d{3})(\\d{3})(\\d+)","$1 $2 $3");
        
        System.out.print("Entrez l'adresse du client :");
        ADDRESS_DU_CLIENT = Clavier.lireString();   
        
        // TYPE DE TOIT ICI //
        System.out.println("Entrez le type de toit (1 pour le toit plat, ou 2 pour le toit en pente) :");
             TYPE_DE_TOIT = Clavier.lireInt();
        //LA BOQUEL DE VALIDATION 
        while(TYPE_DE_TOIT != 1 && TYPE_DE_TOIT != 2){
            System.out.println("Entree invalide !");
            System.out.println("Entrez le type de toit (1 pour le toit plat, ou 2 pour le toit en pente) :");
                TYPE_DE_TOIT = Clavier.lireInt();
            }
        // TYPE DE COUVERTURE //
              //TYPE 1
            if(TYPE_DE_TOIT == 1){
        System.out.println("Entrez le type de couverture\n1 Pour La membrane élastomère \n2 Pour La membrane TPO\n3 Pour La membrane EPDM\n4 Pour Le multicouche gravier et bitumeour):");
              TYPE_DE_DECOUVERTURE = Clavier.lireInt();
        //LA BOQUEL DE VALIDATION DE LA COUVERTURE
        
        while(TYPE_DE_DECOUVERTURE != 1 && TYPE_DE_DECOUVERTURE != 2 && TYPE_DE_DECOUVERTURE != 3 && TYPE_DE_DECOUVERTURE != 4){
            System.out.println("Entree invalide !");
            System.out.println("Entrez le type de couverture\n1 Pour La membrane élastomère \n2 Pour La membrane TPO\n3 Pour La membrane EPDM\n4 Pour Le multicouche gravier et bitumeour):");
            TYPE_DE_DECOUVERTURE = Clavier.lireInt();
            }
            //PASSAGE DU CHOIX 1
            switch(TYPE_DE_DECOUVERTURE){
                 case 1:
                 PRIX_PAR_PIED = PRIX_PAR_PIED_1;
                 break;
                 
                 case 2:
                 PRIX_PAR_PIED = PRIX_PAR_PIED_2;
                 break;
                 
                 case 3:
                 PRIX_PAR_PIED = PRIX_PAR_PIED_3;
                 break;
                 
                 case 4:
                 PRIX_PAR_PIED = PRIX_PAR_PIED_4;
                 break;   
            }
            
            //PASSAGE DU CHOIX 1
            switch(TYPE_DE_DECOUVERTURE){
                 case 1:
                 DUREE_DE_VIE = DUREE_DE_VIE_1;
                 break;
                 
                 case 2:
                 DUREE_DE_VIE = DUREE_DE_VIE_2;
                 break;
                 
                 case 3:
                 DUREE_DE_VIE = DUREE_DE_VIE_3;
                 break;
                 
                 case 4:
                 DUREE_DE_VIE = DUREE_DE_VIE_4;
                 break;   
            }
          }// fin de choix type1
             //TYPE 2
        else if( TYPE_DE_TOIT == 2){
        System.out.println("Entrez le type de couverture\n5 Pour Le bardeau en asphalte\n6 Pour La tôle \n7 Pour L’ardoise:");
        TYPE_DE_DECOUVERTURE = Clavier.lireInt();
        //LA BOQUEL DE VALIDATION DE LA COUVERTURE
        
        while(TYPE_DE_DECOUVERTURE != 5 && TYPE_DE_DECOUVERTURE != 6 && TYPE_DE_DECOUVERTURE != 7){
            System.out.println("Entree invalide !");
            System.out.println("Entrez le type de couverture\n5 Pour Le bardeau en asphalte\n6 Pour La tôle \n7 Pour L’ardoise:");
            TYPE_DE_DECOUVERTURE = Clavier.lireInt();
            }
             //PASSAGE DU CHOIX 2
            switch(TYPE_DE_DECOUVERTURE){
                 case 5:
                 PRIX_PAR_PIED = PRIX_PAR_PIED_5;
                 break;
                 
                 case 6:
                 PRIX_PAR_PIED = PRIX_PAR_PIED_6;
                 break;
                 
                 case 7:
                 PRIX_PAR_PIED = PRIX_PAR_PIED_7;
                 break;      
            }
          
            switch(TYPE_DE_DECOUVERTURE){
                 case 5:
                 DUREE_DE_VIE = DUREE_DE_VIE_5;
                 break;
                 
                 case 6:
                 DUREE_DE_VIE = DUREE_DE_VIE_6;
                 break;
                 
                 case 7:
                 DUREE_DE_VIE = DUREE_DE_VIE_7;
                 break;      
            }
           }
        System.out.println("Entrez la surface à couvrir en pied carré (supérieure à 0) :");
        SURFACE_DE_COUVERTURE = Clavier.lireDouble();
        
        while(SURFACE_DE_COUVERTURE <= 0){
            System.out.println("Entree invalide !");
            System.out.println("Entrez la surface à couvrir en pied carré (supérieure à 0) :");
            SURFACE_DE_COUVERTURE = Clavier.lireInt();
        }
        //CODITION DE PAYEMENT
        System.out.println("Entrez le mode de paiement (s ou S pour Cash, d ou D pour Débit, et c ou C pour Crédit):");
        char s,S,d,D,c,C;
        
         MODE_DE_PAYEMENT = Clavier.lireChar();
        //CONDITION DE VALIDATION
        while(MODE_DE_PAYEMENT !='s' && MODE_DE_PAYEMENT !='S' && MODE_DE_PAYEMENT !='d' && MODE_DE_PAYEMENT !='D' && MODE_DE_PAYEMENT !='c' && MODE_DE_PAYEMENT !='C'){
        System.out.println("Entree invalide!");
        System.out.println("Entrez le mode de paiement (s ou S pour Cash, d ou D pour Débit, et c ou C pour Crédit):");
             MODE_DE_PAYEMENT = Clavier.lireChar();
        }
        //VALIDATION DU CHOIX DE PAYEMENT
        String paiement;
             switch(MODE_DE_PAYEMENT){
                case 's':
                    paiement ="Cash";
                    break;
                case 'S':
                    paiement ="Cash";
                    break;
                case 'd':
                    paiement ="Débit";
                    break;
                case 'D':
                    paiement ="Débit";
                    break;
                case 'c':
                    paiement ="Crédit";
                    break;
                case 'C':
                    paiement ="Crédit";
                    break;
                }
        //OPERATION    
             //DONC LE RESULTA EST SEULEMENT UTILISER 0.05 ET 0.09975
            NUMBRE_DE_CHOIX ++;
            
            
            SOUS_TOTAL = SURFACE_DE_COUVERTURE * PRIX_PAR_PIED; 
            tpsAvecMontant = Tps * (SOUS_TOTAL);
            tvqAvecMontant = TVQ * (SOUS_TOTAL);
            MONTANT_TOTAL = (SOUS_TOTAL+tpsAvecMontant+tvqAvecMontant);
            
            MONTANT_GLOBAL += MONTANT_TOTAL;
        //AFFICHARGE
        //-------------------------------ENTETE DE FACTURE--------------------------------------------//
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Toiture-Pour-Tous");
        System.out.println("Facture No:\t\t"+NUMBRE_DE_CHOIX+"\tDate et Heure: \t\t"+dateHeureSysteme.format(formatter));
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Nom et prénom :\t\t\t"+ NOM_DU_CLIENT +" "+ PRENOM_DU_CLIENT +"\t\tTéléphone :"+ tel);
        System.out.println("Addresse du client: \t\t "+ADDRESS_DU_CLIENT);
        if(TYPE_DE_TOIT == 1){
        System.out.println("Le type de toit: \t\t\t\t\t Toit plat");
         } else{
             System.out.println("Le type de toit: \t\t\t\t\t Toit en pente");
            }
       if(TYPE_DE_DECOUVERTURE == 1){   
        System.out.println("Le type de couverture: \t\t\t\t\t "+ TYPE_DE_COUVERTURE_1);
           }else if(TYPE_DE_DECOUVERTURE == 2){
        System.out.println("Le type de couverture: \t\t\t\t\t "+ TYPE_DE_COUVERTURE_2);    
            }else if(TYPE_DE_DECOUVERTURE == 3){
        System.out.println("Le type de couverture: \t\t\t\t\t "+ TYPE_DE_COUVERTURE_3);    
            }else if(TYPE_DE_DECOUVERTURE == 4){
        System.out.println("Le type de couverture: \t\t\t\t\t "+ TYPE_DE_COUVERTURE_4);    
            }else if(TYPE_DE_DECOUVERTURE == 5){
        System.out.println("Le type de couverture: \t\t\t\t\t "+ TYPE_DE_COUVERTURE_5);    
            }else if(TYPE_DE_DECOUVERTURE == 6){
        System.out.println("Le type de couverture: \t\t\t\t\t "+ TYPE_DE_COUVERTURE_6);    
            }else if(TYPE_DE_DECOUVERTURE == 7){
        System.out.println("Le type de couverture: \t\t\t\t\t "+ TYPE_DE_COUVERTURE_7);    
            }
        System.out.printf("La durée de vie :\t\t\t\t\t %.0f ans \n",DUREE_DE_VIE);
        System.out.printf("La surface à couvrir:\t\t\t\t\t %.0f pied carré\n",SURFACE_DE_COUVERTURE);
        
        if(MODE_DE_PAYEMENT =='s' && MODE_DE_PAYEMENT =='S'){
         System.out.println("Le mode de paiement: \t\t\t\t\t Cash");
        } else if(MODE_DE_PAYEMENT =='d' && MODE_DE_PAYEMENT =='D'){
         System.out.println("Le mode de paiement: \t\t\t\t\t Débit");
        } else{
         System.out.println("Le mode de paiement: \t\t\t\t\t Crédit");
        }
       
        System.out.println("\nPrix par pied carré \t\t\t\t"+PRIX_PAR_PIED +"$");
        
        System.out.printf("Sous-total\t\t\t\t\t%.2f $\n", SOUS_TOTAL);
        System.out.printf("Montant TPS\t\t\t\t\t%.2f $\n", tpsAvecMontant);
        System.out.printf("Montant TVQ \t\t\t\t\t%.2f $\n", tvqAvecMontant);
        System.out.printf("Montant total \t\t\t\t\t%.2f $\n", MONTANT_TOTAL);
        System.out.println("\t\t---------------------------------------------------------------");
        
        System.out.println("\t\t\t\tMerci pour votre confiance!");
    }
        //
        // SECTION DE LA FACTURATION
        //
        else if(CHOIX_OPTION==2){
        
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Toiture-Pour-Tous");
        System.out.println("Date et Heure: \t\t\t\t\t\t\t"+dateHeureSysteme.format(formatter));
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("\nLe nombre de recouvrements \t\t\t\t\t\t"+NUMBRE_DE_CHOIX);
        System.out.printf("Le montant total de toutes les installations\t\t\t\t %.2f$ \n",MONTANT_GLOBAL);
        System.out.println("----------------------------------------------------------------------------------");
        
        }
        
        else if(CHOIX_OPTION==3){
        System.exit(0);
                     }
                    }
                    while(CHOIX_OPTION !=3);
    }
} // TP1 faire par WOUAFO TALLA JEAN GAEL
