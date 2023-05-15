package treasurequest.domains;

import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * permet de melanger une liste
 * @author virgi
 *
 */
public class MyRandom implements IRandom{

	@Override
	public void shuffle(List<Coordinate> list) {
		Collections.shuffle(list);
		
	}

	@Override
	public int nextInt() {
		Random ran = new Random();
        return ran.nextInt();
	}
	
	

	

}
