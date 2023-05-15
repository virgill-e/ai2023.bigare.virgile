package treasurequest.domains;

/**
 * class d'une partie de Treasure Quest
 * 
 * @author virgi
 * 
 *         CTT du calcul d’indices:
 * 
 *         t=nombre de tresor au chargement de la map
 * 
 *         s=(la distane pour être voisin*2)+1, 5 dans notre cas
 * 
 *         v=le nombre de voisin, 24 dans notre cas
 * 
 *         ----------------------------
 * 
 *         - CaseMap.setAllcClues() parcours toute les Coordonne contenant un
 *         tresor
 * 
 *         - La methode appelle ensuite getNeighbors() sur les coordonnees
 *         renvoyant une liste des 24 coordonne voisine en utilisant une boucle
 *         recursive qui parcoure chacune (la distane pour être voisin*2)+1,
 *         dans notre cas 5
 * 
 *         -Pour chaque tresore on parcours ses voisins pour leurs assigne le
 *         meilleur indice possible
 * 
 *         O(t*(s*s+v))
 * 
 *         o(t*(s*s))
 * 
 *         La complexite est donc une complexite cubique
 * 
 * 
 *         ----------------------------------------
 * 
 *         Choix du type et de l’implémentation d’une collection:
 * 
 *         Pour stocker les coordonnees environate (voisine) j'ai utilise une
 *         list car les seul operation que j'effectue son le add et je parcours
 *         ma collection avec une boucle foreach
 * 
 *         mon implementation est une ArrayList car l'ajout est de O(1)
 * 
 * 
 */
public class TreasureQuestGame {
	private final CaseMap caseMap;
	private final Player player;
	private Coordinate activeCoordinate;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * Constructeur d'une partie de Treasure Quest prenant en parametre le path vers
	 * le sample de la map
	 * 
	 * @param sample
	 */
	public TreasureQuestGame(CaseMap map,Player player) {
		this.caseMap = map;
		this.player = player;
		this.player.addCoins(caseMap.getNbTreasure() * 2);
		this.activeCoordinate = caseMap.getCenter();
	}

	/*
	 * PUBLIC METHODS
	 */

	/**
	 * Renvoie la CaseMap de la partie en cours
	 * 
	 * @return
	 */
	public Iterable<Coordinate> getCoords() {
		return this.caseMap;
	}

	/**
	 * renvoie la ligne correspondante a la case active
	 * 
	 * @return
	 */
	public int getActiveRow() {
		return this.activeCoordinate.getRow();
	}

	/**
	 * renvoie la colonne correspondante a la case active
	 * 
	 * @return
	 */
	public int getActiveCol() {
		return this.activeCoordinate.getCol();
	}

	/**
	 * renvoie le nombre de piece que possède le joueur
	 * 
	 * @return
	 */
	public int getPlayerCoins() {
		return this.player.getCoins();
	}
	
	/**
	 * renvoie le total des depenses d'un joueur
	 * @return
	 */
	public int getPlayerSpend() {
		return this.player.getSpend();
	}
	
	/**
	 * renvoie le total des gains d'un joueur
	 * @return
	 */
	public int getPlayerGain() {
		return this.player.getGain();
	}

	/**
	 * renvoie le nombre de trésor restant dans la map
	 * 
	 * @return
	 */
	public int getNbTreasur() {
		return this.caseMap.getNbTreasure();
	}
	
	

	/**
	 * renvoie le type de la case active
	 * 
	 * @return
	 */
	public char getActiveCaseType() {
		return caseMap.getCaseWithCoord(activeCoordinate).getType();
	}

	/**
	 * renvoie le coût pour creuser sur la case active
	 * 
	 * @return
	 */
	public int getActiveCaseCost() {
		Case casee = caseMap.getCaseWithCoord(activeCoordinate);
		return casee.getCost();
	}

	/**
	 * renvoit un char representant la type d'une case En fonction de la coordonnee
	 * recu en parametre
	 * 
	 * @param c
	 * @return
	 */
	public char getCaseTypeWithCoord(Coordinate coord) {
		return this.caseMap.getCaseWithCoord(coord).getType();
	}

	/**
	 * mets a jour la case active
	 */

	public void updateActiveCase(int deltaRow, int deltaCol) {
		int Col = activeCoordinate.getCol();
		int Row = activeCoordinate.getRow();
		Coordinate newActiveCase = new Coordinate(Col + deltaCol, Row + deltaRow);
		if (caseMap.caseExist(newActiveCase)) {
			activeCoordinate = newActiveCase;
		}
	}

	/**
	 * Creuse a l'emplacement de la case active et renvoie true si elle a reussi a
	 * creuser ou false si la case ne peut être creuse
	 * 
	 * @return
	 */
	public boolean dig() {
		Case caseDig = caseMap.getCaseWithCoord(activeCoordinate);
		if (canDig(caseDig)) {
			player.substractCoins(caseDig.getCost());
			if (caseDig.hasTreasure()) {
				player.addCoins(caseDig.getTreasureValue());
				caseMap.removeTreasure(activeCoordinate);
				caseDig.removeTreasure();
			}
			caseDig.setDug();
			caseMap.addDig(activeCoordinate);
			return true;
		}
		return false;
	}

	/**
	 * renvoie le le point cardinal correspondant à l'indice de la case, null si pas
	 * d'indice
	 * 
	 * @return
	 */
	public CardinalPoints getCardinalPoints() {
		return caseMap.getCaseWithCoord(activeCoordinate).getCardinalPoint();
	}

	/**
	 * renvoie si la case active possede un tresor
	 * 
	 * @return
	 */
	public boolean ActiveHasTreasure() {
		return caseMap.getCaseWithCoord(activeCoordinate).hasTreasure();
	}
	
	/**
	 * renvoie un boolean indiquant si le joueur a perdu
	 * @return
	 */
	public boolean isLoose() {
		return getNbTreasur()==0||!hasEnoughCoins();
	}
	
	/**
	 * set le type de profil du joueur
	 */
	public void setProfil() {
		Profil profil=caseMap.findProfil();
		player.setProfil(profil);
	}
	
	/**
	 * renvoie le profil du joueur
	 * @return
	 */
	public Profil getProfil() {
		return player.getProfil();
	}
	
	/**
	 * renvoie le temps du joueur en minute:seconde
	 * @return
	 */
	public String getDuration() {
		return player.getMinSeconde();
	}

	/*
	 * PRIVATE METHODS
	 */
	private boolean canDig(Case caseDig) {

		if (caseDig == null)
			return false;
		if (caseDig.isDug())
			return false;
		if (!caseDig.canBeDug())
			return false;
		return player.getCoins() >= caseDig.getCost();
	}
	
	private boolean hasEnoughCoins() {
		boolean hasEnoughCoins=false;
		for(Coordinate coord:caseMap) {
			Case myCase=caseMap.getCaseWithCoord(coord);
			if(myCase.getCost()<=player.getCoins()&&myCase.getType()!='X') {
				hasEnoughCoins=true;
			}
		}
		return hasEnoughCoins;
	}



	

}
