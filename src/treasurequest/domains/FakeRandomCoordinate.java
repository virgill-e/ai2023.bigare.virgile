package treasurequest.domains;

import java.util.Collections;
import java.util.List;

/**
 * permet de fausser l'aleatoire en triant la list founie
 * @author virgi
 *
 */
public class FakeRandomCoordinate implements IRandomCoordinate{

	@Override
	public void shuffle(List<Coordinate> list) {
		Collections.sort(list);
	}

}
