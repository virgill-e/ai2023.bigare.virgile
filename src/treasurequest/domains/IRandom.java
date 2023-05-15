package treasurequest.domains;

import java.util.List;

/**
 * interface permettant de melanger une list
 * @author virgi
 *
 */
public interface IRandom {

	/**
	 * melange une list
	 * @param list
	 */
	public void shuffle(List<Coordinate> list);
	
	/**
	 * renvoie un entier aleatoire
	 * @return
	 */
	public int nextInt();
}
