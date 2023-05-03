package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;


class CaseTest {

	@ParameterizedTest
	@ValueSource(chars = { 'S', 'P','F','R','W' })
	void isInstanceOf(char letter) {
		Case actualCase=new Case(letter);
		assertTrue(actualCase instanceof Case);
	}
	
	@ParameterizedTest
	@CsvSource({
	    "S, S",
	    "P, P",
	    "F, F",
	    "R, R",
	    "X, X"
	})
	void getType(char letter, char type) {
	    Case actualCase = new Case(letter);
	    assertEquals(type, actualCase.getType());
	}
	
	@ParameterizedTest
	@CsvSource({
	    "S, 1",
	    "P, 2",
	    "F, 3",
	    "R, 5",
	})
	void getCost(char letter, int cost) {
	    Case actualCase = new Case(letter);
	    assertEquals(cost, actualCase.getCost());
	}
	
	@Test
	void setTreasureSetOnCase() {
		Case actualCase = new Case('S');
		actualCase.setTreasure(10);
		assertEquals(10, actualCase.getTreasureValue());
		actualCase.setTreasure(20);
		assertEquals(20, actualCase.getTreasureValue());
		actualCase.setTreasure(21);
		assertEquals(20, actualCase.getTreasureValue());
		actualCase.setTreasure(9);
		assertEquals(10, actualCase.getTreasureValue());
	}
	
	@Test
	void checkIfHasTreasure() {
		Case actualCase = new Case('S');
		assertFalse(actualCase.hasTreasure());
		actualCase.setTreasure(10);
		assertTrue(actualCase.hasTreasure());
	}
	
	@Test
	void checkIfIsDug() {
		Case actualCase = new Case('S');
		assertFalse(actualCase.isDug());
		actualCase.setDug();
		assertTrue(actualCase.isDug());
	}
	
	@Test
	void canBeDebug() {
		Case actualCase = new Case('S');
		assertTrue(actualCase.canBeDug());
		actualCase = new Case('R');
		assertTrue(actualCase.canBeDug());
		actualCase = new Case('W');
		assertFalse(actualCase.canBeDug());
	}

}
