package treasurequest.domains;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

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
	private static final Coordinate TOP_LEFT = new Coordinate(0, 0);

	private final Map<Coordinate, Case> cases;
	private final List<Coordinate> treasures;
	private Coordinate center;
	private final IRandomCoordinate random;
	private final Set<Coordinate> digCoord;

	/*
	 * CONSTRUCTORS
	 */

	/**
	 * constructeur de CaseMap prenant un tableau de char représentant la map en
	 * parametre
	 * 
	 * @param mapSample
	 */
	public CaseMap(char[][] mapSample, IRandomCoordinate random) {
		Objects.requireNonNull(mapSample);
		Objects.requireNonNull(random);
		this.random = random;
		treasures = new ArrayList<Coordinate>();
		cases = new HashMap<Coordinate, Case>();
		digCoord = new LinkedHashSet<Coordinate>();
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

	/**
	 * renvoie le nombre de tresor restant dans le jeu
	 * 
	 * @return
	 */
	public int getNbTreasure() {
		return this.treasures.size();
	}

	public Coordinate getCenter() {
		return center;
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
	 * Supprime le tresor present sur les coordonnee fournie
	 * 
	 * @param activeCoordinate
	 */
	public void removeTreasure(Coordinate activeCoordinate) {
		treasures.remove(activeCoordinate);
	}

	/**
	 * ajoute la coord founie a une collection de case creuse
	 * 
	 * @param coord
	 */
	public void addDig(Coordinate coord) {
		this.digCoord.add(coord);
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
		this.random.shuffle(coordCreusable);
		return coordCreusable;
	}

	/**
	 * ajoute un tresor au 10 premier % des case creusable
	 */
	private void setAllTreasures() {
		List<Coordinate> coordsCanDig = getAllCasesCanBeDug();
		Random random = new Random();
		int valeur;
		int nbTreasure = (int) (coordsCanDig.size() * TEN_PERCENT);
		if (coordsCanDig.size() > 0)
			nbTreasure = Math.max(1, nbTreasure);
		for (int i = 0; i < nbTreasure; i++) {
			valeur = random.nextInt(21 - 10) + 10;
			Coordinate CoordWithTreasure = coordsCanDig.get(i);
			cases.get(CoordWithTreasure).setTreasure(valeur);
			treasures.add(CoordWithTreasure);
		}
	}

	private void addAllCaseToMap(char[][] mapSample) {
		int row = mapSample[0].length / 2;
		int col = mapSample.length / 2;
		for (int i = 0; i < mapSample.length; i++) {
			row = Math.min(row, mapSample[i].length / 2);
			for (int j = 0; j < mapSample[i].length; j++) {
				char type = mapSample[i][j];
				Case actualCase = new Case(type);
				Coordinate coord = new Coordinate(j, i);
				cases.put(coord, actualCase);
			}
		}
		center = new Coordinate(row, col);
	}

	/**
	 * set l'indice a chaque casse qui peut en avoir une
	 */
	private void setAllClues() {
		for (Coordinate coordTreasure : treasures) {
			List<Coordinate> neighbors = coordTreasure.getNeighbors(5);
			for (Coordinate coordNeighbor : neighbors) {
				Case caseNeighbor = cases.get(coordNeighbor);

				if (caseNeighbor == null || caseNeighbor.hasTreasure() || !caseNeighbor.canBeDug()) {
					continue;
				}
				if (caseNeighbor.getClue() == null) {
					caseNeighbor.setClue(ClueGenerator.generateClue(coordNeighbor, coordTreasure));
				} else {
					Coordinate coordOrigin = caseNeighbor.getClue().getOriginTreasure();
					betterClue(coordNeighbor, coordOrigin, coordTreasure);

				}

			}
		}
	}

	/**
	 * attribut l'indice sur la case en fonction de la distance, la valeur, et le
	 * plus proche du coin superieir gauche
	 * 
	 * @param CoordOrigin
	 * @param coordNeighbor
	 * @param objective
	 */
	private void betterClue(Coordinate coordNeighbor, Coordinate coordOrigin, Coordinate coordTrasure) {
		Coordinate betterCoord = betterClueClosest(coordNeighbor, coordOrigin, coordTrasure);
		if (betterCoord != null) {
			setClueOnCase(coordNeighbor, betterCoord);
			return;
		}
		betterCoord = betterClueValue(coordOrigin, coordTrasure);
		if (betterCoord != null) {
			setClueOnCase(coordNeighbor, betterCoord);
			return;
		}
		betterCoord = betterClueClosest(TOP_LEFT, coordOrigin, coordNeighbor);
		if (betterCoord != null) {
			setClueOnCase(coordNeighbor, betterCoord);
			return;
		}
		setClueOnCase(coordNeighbor, coordOrigin);
	}

	private void setClueOnCase(Coordinate myCase, Coordinate objective) {
		if (myCase.equals(objective))
			return;
		cases.get(myCase).setClue(ClueGenerator.generateClue(myCase, objective));
	}

	/**
	 * renvoie la coordonne du tresor ayant la plus groose valeur, null si distance
	 * egal
	 * 
	 * @param coordOrigin
	 * @param coordTrasure
	 * @param coordTrasure
	 * @return
	 */
	private Coordinate betterClueValue(Coordinate coordOrigin, Coordinate coordTrasure) {
		if (cases.get(coordTrasure).getTreasureValue() < cases.get(coordOrigin).getTreasureValue()) {
			return coordOrigin;
		} else if (cases.get(coordTrasure).getTreasureValue() > cases.get(coordOrigin).getTreasureValue()) {
			return coordTrasure;
		}
		return null;
	}

	/**
	 * renvoie la coordonne la plus proche de objective, null si distance egal
	 * 
	 * @param coordOrigin
	 * @param coordNeighbor
	 * @param objective
	 * @return
	 */
	// TODO: supprimer cette methode et garder seulement celle de Coordinate pour
	// eviter class GOD
	private Coordinate betterClueClosest(Coordinate coordNeighbor, Coordinate coordOrigin, Coordinate coordTreasure) {
		return coordNeighbor.getClosest(coordOrigin, coordTreasure);
	}

	public Profil findProfil() {
		Set<Coordinate> visited = new HashSet<Coordinate>();
		Set<Coordinate> zone = new HashSet<Coordinate>();
		Profil profil = Profil.NONE;
		for (Coordinate coord : digCoord) {
			Set<Coordinate> actualZone = new HashSet<Coordinate>();
			addToZone(coord, actualZone, visited);
			if (actualZone.size() > zone.size()) {
				profil = getProfil(coord);
				zone = actualZone;
			}
		}
		return profil;
	}

	private void addToZone(Coordinate coord, Set<Coordinate> zone, Set<Coordinate> visited) {
		char type = getCaseWithCoord(coord).getType();
		zone.add(coord);
		visited.add(coord);
		List<Coordinate> neighbors = coord.getNeighbors(3);
		// pour chaque voisin
		for (Coordinate coordNeigh : neighbors) {
			// si du meme type
			Case caseNeigh = getCaseWithCoord(coordNeigh);
			if(caseNeigh==null)continue;
			if (caseNeigh.getType() == type && !visited.contains(coordNeigh)&&digCoord.contains(coordNeigh)) {
				// on ajoute a visited
				addToZone(coordNeigh, zone, visited);
			}
		}
	}

	private Profil getProfil(Coordinate coord) {
		char type = getCaseWithCoord(coord).getType();
		if (type == 'P')
			return Profil.FARMER;
		else if (type == 'F')
			return Profil.LUMBERJACK;
		else if (type == 'R')
			return Profil.MINER;
		else if (type == 'S')
			return Profil.TOURIST;
		return Profil.NONE;
	}

}
