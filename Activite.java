
/**
 *
 * @author KAFRA
 */
public class Activite {

    /**
     * @param args the command line arguments
     */
    
    public static double moyenne(final int[] tableau){
	int taille = tableau.length;
	int somme = 0;
	for(int i = 0; i < taille; i++){
		somme += tableau[i];
	}
	int moyenne = somme/taille;
	return moyenne;
    }

    public static int mediane(final int[] tableau){
	int taille = tableau.length;
	int milieu = taille/2;
	return tableau[milieu];
    }

    public static int plusGrand(final int[] tableau){
	int taille = tableau.length;
	int plusGrand = tableau[0];
	for(int i = 1; i < taille; i++){
            if(tableau[i] > plusGrand){
		plusGrand = tableau[i];
            }
	}
	return plusGrand;
    }

    public static boolean egaux(final int[] tableau1, final int[] tableau2){
	int taille1 = tableau1.length;
	int taille2 = tableau2.length;
	boolean egaux = true;
	if(taille1 == taille2){
		int i = 0;
		while( i < taille1 && tableau1[i] == tableau2[i]){
			i++;
		}
		if(i < taille1){
			egaux = false;
		}			
	}else{
		egaux = false;
	}
	return egaux;
    }

    public static boolean similaire(final int[] tableau1, final int[] tableau2){
	int taille1 = tableau1.length;
	int taille2 = tableau2.length;
	boolean similaire = true;
	int[] tab1 = tableau2;
	if(taille1 == taille2){
		int i = 0;
		while( i < taille1 && similaire){
			int j = 0;
			taille2 = tab1.length;
			int[] tab = new int[taille2-1];
			while( j < taille2 && tab1[j] != tableau1[i]){
				tab[j] = tab1[j];
				j++;
			}
			if(j < taille2){
				for(int k = j+1; k < taille2; k++){
					tab[j] = tab1[k];
					j++;
				}
			}else{
				similaire = false;
			}
			tab1 = tab;
			i++;
		}
	}else{
		similaire = false;
	}
	return similaire;
    }
}