package treasurequest.domains;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;

/**
 * La class player represente un joueur possédant des pieces
 * @author virgi
 *
 */
public class Player {
	private int spend;
	private int gain;
	private final LocalDateTime time;
	private Profil profil;
	private Set<Coordinate> zone;
	
	/*
	 * CONSTRUCTORS
	 */
	/**
	 * initialise un joueur en recevant son nombre de pieces en parametre
	 * @param coins
	 */
	public Player(int coins) {
		this.spend=0;
		this.gain=coins;
		this.time=LocalDateTime.now();
		this.profil=Profil.N;
		this.zone=new HashSet<Coordinate>();
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
		this.spend+=Math.min(value, this.gain);
	}
	
	/**
	 * ajoute des piece au joueur
	 * @param value
	 */
	public void addCoins(int value) {
		this.gain+=Math.abs(value);
	}
	
	/**
	 * renvoie le nombre de piece que le joueur possede
	 * @return
	 */
	public int getCoins() {
		return this.gain-this.spend;
	}

	public int getSpend() {
		return this.spend;
	}
	
	public int getGain() {
		return this.gain;
	}

	
	/**
	 * renvoie le temps de jeu depuis la creation du joueur en minute:seconde
	 * @return
	 */
	public String getMinSeconde() {
		StringJoiner stringJoiner=new StringJoiner(":");
		Duration duration=Duration.between(time, LocalDateTime.now());
		stringJoiner.add(String.format("%02d", duration.getSeconds()/60));
		stringJoiner.add(String.format("%02d", duration.getSeconds()%60));
		return stringJoiner.toString();
	}
	
	public void setProfil(Profil profil) {
		if(profil==null) {
			this.profil=Profil.N;
			return;
		}
		this.profil=profil;
	}

	public Profil getProfil() {
		return profil;
		
	}

	public void setZone(Set<Coordinate> zone) {
		this.zone=new HashSet<Coordinate>(zone);
	}
	
	public Set<Coordinate> getZone(){
		return new HashSet<Coordinate>(this.zone);
	}
	
	/*
	 * PRIVATE METHODS
	 */
}
