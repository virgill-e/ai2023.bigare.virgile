package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class MyRandomTest {

	@Test
	void test() {
		MyRandom rc=new MyRandom();
		List<Coordinate> coords1=new ArrayList<Coordinate>();
		List<Coordinate> coords2=new ArrayList<Coordinate>();
		boolean isDiff=false;
		
		for(int i=1000;i>=0;i--) {
			coords1.add(new Coordinate(i, 0));
			coords2.add(new Coordinate(i, 0));
		}
		
		rc.shuffle(coords2);
		for(int i=0;i<1000;i++) {
			isDiff=!coords1.get(i).equals(coords2.get(i));
			if(isDiff)break;
		}
		assertTrue(isDiff);
	}

}
