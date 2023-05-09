package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CardinalPointsTest {

	@Test
	void allCardianlPoints() {
		List<CardinalPoints> cards=Arrays.asList(CardinalPoints.values());
		assertTrue(cards.contains(CardinalPoints.NORTH));
		assertTrue(cards.contains(CardinalPoints.NORTH_EAST));
		assertTrue(cards.contains(CardinalPoints.EAST));
		assertTrue(cards.contains(CardinalPoints.SOUTH_EAST));
		assertTrue(cards.contains(CardinalPoints.SOUTH));
		assertTrue(cards.contains(CardinalPoints.SOUTH_WEST));
		assertTrue(cards.contains(CardinalPoints.WEST));
		assertTrue(cards.contains(CardinalPoints.NORTH_WEST));
	}

}
