package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class FakeRandomTest {

	@Test
	void FakeShuffle() {
		FakeRandom fr=new FakeRandom();
		List<Coordinate> coords=new ArrayList<Coordinate>();
		List<Coordinate> coordsExpected=new ArrayList<Coordinate>();
		for(int i=10;i>=0;i--) {
			coords.add(new Coordinate(i, 0));
			coordsExpected.add(new Coordinate(10-i, 0));
		}
		fr.shuffle(coords);
		for(int i=0;i<10;i++) {
			assertEquals(coordsExpected.get(i), coords.get(i));
		}
	}
	
	@Test
	void fakeRandom() {
		FakeRandom fr=new FakeRandom();
		assertEquals(fr.nextInt(), 0);
	}

}
