package treasurequest.domains;

import java.util.Collections;
import java.util.List;

public class RandomCoordinate implements IRandomCoordinate{

	@Override
	public void shuffle(List<Coordinate> list) {
		Collections.shuffle(list);
		
	}

	

}
