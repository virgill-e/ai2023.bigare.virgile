package treasurequest.domains;

/**
 * La classe player represente un joueur possédant des pieces
 * @author virgi
 *
 */
public class Player {
	private int coins;
	
	/*
	 * CONSTRUCTORS
	 */
	/**
	 * initialise un joueur en recevant son nombre de pieces en parametre
	 * @param coins
	 */
	public Player(int coins) {
		this.coins=coins;
	}
	
	/*
	 * PUBLIC METHODS
	 */
	
	/**
	 * - Soustrait un nombre de piece a la bourse du joueur
	 * - La valeur minimum de la bourse est 0
	 * - La valeur donnee en parametre devient une valeur absolue
	 * @param value
	 */
	public void substractCoins(int value) {
		this.coins-=Math.abs(value);
		this.coins=Math.max(0, this.coins);
	}
	
	public int getCoins() {
		return this.coins;
	}
	
	/*
	 * PRIVATE METHODS
	 */
}
