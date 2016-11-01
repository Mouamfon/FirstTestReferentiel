/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package activite;

/**
 * Implémentation de l'interface position
 * 
 * @author KAFRA
 *
 */
public class GrilleImpl implements Grille{

	private char[][] position;
	
	/**
	 * definition du constructeur de position
	 * 
	 */
    public GrilleImpl(int dimension) {
        position = new char[dimension][dimension];
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                position[i][j] = Grille.EMPTY;
            }
        }
    }

    	/* (non-Javadoc)
	 * @see position#getDimension()
         * 
         * recuperation de la dimension de la position
	 */
    public int getDimension() {
        return position.length;
    }

              // on verifie si la valeur a inserer est une valeur valide
    public boolean estValide(int value){
        int i = 0;
        boolean valide = false;
        while(i < Grille.possible.length && !valide){
            if(Grille.possible[i] == value){
                valide = true;
            }else{
                i++;
            }
        }
        return valide;
    }
    
	/* (non-Javadoc)
         * inserer une valeur dans la position
         * 
	 * @see position#setValue(int, int, char)
         * 
	 */
    public void setValue(int x, int y, char value) throws IllegalArgumentException {
		// TODO Auto-generated method stub
                // Cas d'une position 9X9
        if(estValide(value)){
            if(getDimension() == 9){
                    // On verifie si la position indiquee est une position de la position
            	if((x < 0 && y < 0) || (x > 8 && y > 8)){
                    throw new IllegalArgumentException("la cellule indique n'est pas une cellule de la position");
                }else{
			position[x][y] = value;
                    }
                // Cas d'une position 16X16
            }else if(getDimension() == 16){
		if((x < 0 && y < 0) || (x > 15 && y > 15)){
                    throw new IllegalArgumentException("la cellule indique n'est pas une cellule de la position");
                }else{
                        position[x][y] = value;
                    }
            }
        }else{
            throw new IllegalArgumentException("la valeur a inserer n'est pas une valeur valide");
        }
    }

	/* (non-Javadoc)
         * on recupere une valeur a une position donnee dans la position
         * 
	 * @see position#getValue(int, int)
         * 
	 */    
    public char getValue(int x, int y) throws IllegalArgumentException {
	char  valeur = ' ';
            	// TODO Auto-generated method stub
                // Cas d'une position 9X9
	if(getDimension() == 9){
                 // On verifie si la position indiquee est une position de la position
            if((x < 0 && x > 8) || (y < 0 && y > 8)){
		throw new IllegalArgumentException("la valeur demande n'est pas une valeur de la grillr");
            }else{
		valeur = position[x][y];
            }
                // Cas d'une position 16X16
	}else if(getDimension() == 16){
                if((x < 0 && x > 15) || (y < 0 && y > 15)){
                    throw new IllegalArgumentException("la valeur demande n'est pas une valeur de la grillr");
                }else{
                    valeur = position[x][y];
                }
            }		
            return valeur;
    }

	/* (non-Javadoc)
         * verifie si la position est complete
         * 
	 * @see position#complete()
	 */
    public boolean complete() {		
        boolean recherche = true;
            // TODO Auto-generated method stub

        int i = 0; 
        while(i < position.length && recherche){
            int j = 0; 
            while(j < position.length && recherche){
                if(position[i][j] == Grille.EMPTY){ 
                    recherche = false;
                }else{i++;}
            }
            i++;
        }
        return recherche;
    }

	/* (non-Javadoc)
         * test si une valeur est possible
	 * @see position#possible(int, int, char)
	 */
    public boolean possible(int x, int y, char value) throws IllegalArgumentException {
        boolean fesable = true;
        if (estValide(value)) {
              //Recherche d'une occurence du caractère dans la ligne
            int c = 0; 
            int l = 0;
            while(c < position.length && fesable) {
                if (position[x][c] == value) {
                    fesable = false;
                }else{c++;}
            }

                //Recherche d'une occurence du caractère dans la colone
            while(l < position.length && fesable){
                if (position[l][y] == value) {
                    fesable = false;
                }else{l++;}
            }

                //Recherche d'une occurence du caractère dans le petit carré local
            int petitCarreDim = (int)Math.sqrt(position.length);
            int interneX = (x / petitCarreDim) * petitCarreDim;
            int interneY = (y / petitCarreDim) * petitCarreDim;
            while(l < petitCarreDim && fesable) {
                while(c < petitCarreDim && fesable){
                    if (position[l + interneX][c + interneY] == value) {
                        fesable = false;
                    }else{c++;}
                }
                l++;
            }
        }else{
            throw new IllegalArgumentException("value n'est pas une valeur d'inscription autorisé");
        }
        return fesable;
    }
}
    
