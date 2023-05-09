package treasurequest.domains;

import java.util.List;

/**
 * interface permettant de melanger une list
 * @author virgi
 *
 */
public interface IRandomCoordinate {

	/**
	 * melange une list
	 * @param list
	 */
	public void shuffle(List<Coordinate> list);
}
