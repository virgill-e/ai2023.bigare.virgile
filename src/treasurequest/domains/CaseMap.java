package treasurequest.domains;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class CaseMap implements Iterable<Coordinate>{
	private Map<Coordinate,Case > cases;
	
	public CaseMap(char[][] mapSample) {
		cases=new HashMap<Coordinate, Case>();
		addAllToCaseMap(Arrays.copyOf(mapSample, mapSample.length));
	}
	
	private void addAllToCaseMap(char[][] mapSample) {
		for (int i = 0; i < mapSample.length; i++) {
	        for (int j = 0; j < mapSample[i].length; j++) {
	            Case c = new Case(mapSample[i][j]);
	            Coordinate coord = new Coordinate(i, j);
	            cases.put(coord, c);
	        }
	    }
	}
	
	public Case getCaseWithCoord(Coordinate coord) {
		if(coord==null) return null;
		return this.cases.get(coord);
	}

	@Override
	public Iterator<Coordinate> iterator() {
		return this.cases.keySet().iterator();
	}
	
	
	

}
