package treasurequest.domains;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import treasurequest.supervisors.views.TileType;

public class CaseMap implements Iterable<Coordinate> {
	private Map<Coordinate, Case> cases;
	private Coordinate center;
	private int nbTreasure;

	public CaseMap(char[][] mapSample) {
		cases = new HashMap<Coordinate, Case>();
		addAllCaseToMap(Arrays.copyOf(mapSample, mapSample.length));
		setAllChest();
	}

	private void addAllCaseToMap(char[][] mapSample) {
		for (int i = 0; i < mapSample.length; i++) {
			for (int j = 0; j < mapSample[i].length; j++) {
				Case actualCase = new Case(mapSample[i][j]);
				Coordinate coord = new Coordinate(i, j);
				cases.put(coord, actualCase);
				if(i==mapSample.length/2&&j==mapSample[0].length/2)center=coord;
			}
		}
	}

	public Case getCaseWithCoord(Coordinate coord) {
		if (coord == null)
			return null;
		return this.cases.get(coord);
	}

	/**
	 * Mets les cases creusable dans une liste Shuffle cette liste 
	 * set les 10 * premier % de case de cette liste avec un tresor
	 */
	private void setAllChest() {
		Random random=new Random();
		int valeur;
		List<Coordinate> coordCreusable = new ArrayList<Coordinate>();
		for (Coordinate coord : cases.keySet()) {
			if (cases.get(coord).getType() != TileType.WATER) {
				coordCreusable.add(coord);
			}
		}

		Collections.shuffle(coordCreusable);
		this.nbTreasure=(int) (coordCreusable.size() * 0.1);
		if(coordCreusable.size()>0)this.nbTreasure=Math.max(1, this.nbTreasure);
		for (int i = 0; i < this.nbTreasure ; i++) {
			valeur = random.nextInt(21 - 10) + 10;
			cases.get(coordCreusable.get(i)).setTreasure(valeur);
		}
	}
	
	public int getNbTreasure() {
		return this.nbTreasure;
	}
	
	public Coordinate getCenter() {
		return center;
	}

	@Override
	public Iterator<Coordinate> iterator() {
		return this.cases.keySet().iterator();
	}
	

}
