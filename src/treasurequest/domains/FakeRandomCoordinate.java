package treasurequest.domains;

import java.util.Collections;
import java.util.List;

public class FakeRandomCoordinate implements IRandomCoordinate{

	@Override
	public void shuffle(List<Coordinate> list) {
		Collections.sort(list);
	}

}
