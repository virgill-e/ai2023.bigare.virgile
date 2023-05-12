package treasurequest.domains;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.StringJoiner;

/**
 * La class player represente un joueur possédant des pieces
 * @author virgi
 *
 */
public class Player {
	private int coins;
	private int spend;
	private int gain;
	private final LocalDateTime time;
	private Profil profil;
	
	/*
	 * CONSTRUCTORS
	 */
	/**
	 * initialise un joueur en recevant son nombre de pieces en parametre
	 * @param coins
	 */
	public Player(int coins) {
		this.coins=coins;
		this.spend=0;
		this.gain=0;
		this.time=LocalDateTime.now();
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
		this.spend+=Math.abs(value);
	}
	
	/**
	 * ajoute des piece au joueur
	 * @param value
	 */
	public void addCoins(int value) {
		this.coins+=Math.abs(value);
		this.gain+=Math.abs(value);
	}
	
	public int getCoins() {
		return this.coins;
	}

	public int getSpend() {
		return this.spend;
	}
	
	public int getGain() {
		return this.gain;
	}

	public void setCoins(int value) {
		this.coins=Math.abs(value);
	}
	
	public String getMinSeconde() {
		StringJoiner stringJoiner=new StringJoiner(":");
		Duration duration=Duration.between(time, LocalDateTime.now());
		stringJoiner.add(String.valueOf(duration.getSeconds()/60));
		stringJoiner.add(String.valueOf(duration.getSeconds()%60));
		return stringJoiner.toString();
	}
	
	public void setProfil(Profil profil) {
		this.profil=profil;
	}
	
	/*
	 * PRIVATE METHODS
	 */
}
