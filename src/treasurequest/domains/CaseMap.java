package treasurequest.domains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * CaseMap gere une carte de jeu 2d en liant les coordonnées et les case de jeux
 * 
 * @author virgi
 *
 *         Choix Interface de collection: -Mon interface est une Map car elle
 *         doit me permettre de retrouver rapidement une valeur (Case) sur base
 *         d’une clé (Coordinate), j'utilise les operations get(),put() et keySet().
 *
 *         Choix implementation de collection: -Mon implementation est une
 *         HashMap car l'odre de mes elements n'a pas d'importance, j'utilise
 *         les operations get() et put(K,V) qui ont toute deux une CTT de O(1)
 *         ainsi que la méthode keySet().
 */
public class CaseMap implements Iterable<Coordinate> {
	private static final double TEN_PERCENT=0.1;
	
	
	private final Map<Coordinate, Case> cases;
	private Coordinate center;
	private int nbTreasure;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * constructeur de CaseMap prenant un tableau de char représentant la map en
	 * parametre
	 * 
	 * @param mapSample
	 */
	public CaseMap(char[][] mapSample) {
		cases = new HashMap<Coordinate, Case>();
		addAllCaseToMap(Arrays.copyOf(mapSample, mapSample.length));
		setAllTreasures();
	}

	/*
	 * PUBLIC METHODS
	 */

	/**
	 * renvoie la une case en fonction des coordonnées reçu en parametre
	 * 
	 * @param coord
	 * @return
	 */
	public Case getCaseWithCoord(Coordinate coord) {
		if (coord == null)
			return null;
		return this.cases.get(coord);
	}

	public int getNbTreasure() {
		return this.nbTreasure;
	}

	public Coordinate getCenter() {
		return center;
	}

	@Override
	public Iterator<Coordinate> iterator() {
		return Collections.unmodifiableSet(this.cases.keySet()).iterator();
	}

	/*
	 * PRIVATE METHODS
	 */

	/**
	 * Renvoie une liste melange de toute les cases qui peuvent etre creuse
	 */
	private List<Coordinate> getAllCasesCanBeDug() {
		List<Coordinate> coordCreusable = new ArrayList<Coordinate>();
		for (Coordinate coord : cases.keySet()) {
			if (cases.get(coord).canBeDug()) {
				coordCreusable.add(coord);
			}
		}
		Collections.shuffle(coordCreusable);
		return coordCreusable;
	}
	
	/**
	 * ajoute un tresor au 10 premier % des case creusable
	 */
	private void setAllTreasures() {
		List<Coordinate> coordCreusable=getAllCasesCanBeDug();
		Random random = new Random();
		int valeur;
		this.nbTreasure = (int) (coordCreusable.size() * TEN_PERCENT);
		if (coordCreusable.size() > 0)
			this.nbTreasure = Math.max(1, this.nbTreasure);
		for (int i = 0; i < this.nbTreasure; i++) {
			valeur = random.nextInt(21 - 10) + 10;
			cases.get(coordCreusable.get(i)).setTreasure(valeur);
		}
	}

	private void addAllCaseToMap(char[][] mapSample) {
		int centerX=mapSample[0].length/2;
		int centerY=mapSample.length/2;
		for (int i = 0; i < mapSample.length; i++) {
			centerX=Math.min(centerX, mapSample[i].length/2);
			for (int j = 0; j < mapSample[i].length; j++) {
				Case actualCase = new Case(mapSample[i][j]);
				Coordinate coord = new Coordinate(i, j);
				cases.put(coord, actualCase);
			}
		}
		center=new Coordinate(centerX, centerY);
	}

}
