package treasurequest.domains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

/**
 * CaseMap gere une carte de jeu 2d en liant les coordonnées et les case de jeux
 * 
 * @author virgi
 *
 *         Choix Interface de collection: -Mon interface est une Map car elle
 *         doit me permettre de retrouver rapidement une valeur (Case) sur base
 *         d’une clé (Coordinate), j'utilise les operations get(),put() et
 *         keySet().
 *
 *         Choix implementation de collection: -Mon implementation est une
 *         HashMap car l'odre de mes elements n'a pas d'importance, j'utilise
 *         les operations get() et put(K,V) qui ont toute deux une CTT de O(1)
 *         ainsi que la méthode keySet().
 */
public class CaseMap implements Iterable<Coordinate> {
	private static final double TEN_PERCENT = 0.1;

	private final Map<Coordinate, Case> cases;
	private List<Coordinate> treasores;
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
		Objects.requireNonNull(mapSample);
		cases = new HashMap<Coordinate, Case>();
		addAllCaseToMap(mapSample);
		setAllTreasures();
		setAllClues();
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
		List<Coordinate> coordsCanDig = getAllCasesCanBeDug();
		Random random = new Random();
		int valeur;
		this.nbTreasure = (int) (coordsCanDig.size() * TEN_PERCENT);
		if (coordsCanDig.size() > 0)
			this.nbTreasure = Math.max(1, this.nbTreasure);
		for (int i = 0; i < this.nbTreasure; i++) {
			valeur = random.nextInt(21 - 10) + 10;
			Coordinate CoordWithTreasure = coordsCanDig.get(i);
			cases.get(CoordWithTreasure).setTreasure(valeur);
			treasores.add(CoordWithTreasure);
		}
	}

	private void addAllCaseToMap(char[][] mapSample) {
		int row = mapSample[0].length / 2;
		int col = mapSample.length / 2;
		for (int i = 0; i < mapSample.length; i++) {
			row = Math.min(row, mapSample[i].length / 2);
			for (int j = 0; j < mapSample[i].length; j++) {
				Case actualCase = new Case(mapSample[i][j]);
				Coordinate coord = new Coordinate(j, i);
				cases.put(coord, actualCase);
			}
		}
		center = new Coordinate(row, col);
	}

	private void setAllClues() {
		for (Coordinate coord : treasores) {
			List<Coordinate> neighbors = getNeighbors(coord);
			for (Coordinate neighbor : neighbors) {
				// savoir la position du voisin par rapport à la case
				// si la case a deja un indice mettre la meilleur possibilité (le coffre est
				// stocké dans le clue)
			}
		}
	}

	private CardinalPoints getDirection(Coordinate neighbor, Coordinate origin) {
		// TODO: trouver la direction du voisin vers l'origin et retouner cette
		// direction
		if(neighbor.getCol()<origin.getCol()) {
			//l'indice pointe vers le nord
		}
	}

	private List<Coordinate> getNeighbors(Coordinate central) {
		List<Coordinate> neighbors = new ArrayList<Coordinate>();
		// TODO recuperer les 24 voisins
		return neighbors;
	}

	/**
	 * Verifie si la coordinate envoyé en parametre existe dans le Map de jeu
	 * 
	 * @param coord
	 * @return
	 */
	public boolean caseExist(Coordinate coord) {
		return cases.containsKey(coord);
	}

	/**
	 * Soustrait un trésor au compteur de tresor
	 */
	public void substractTreasure() {
		nbTreasure -= 1;
	}

}
