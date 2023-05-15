package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import treasurequest.io.CharArrayFileReader;

class TreasureQuestGameTest {
	private static final String SAMPLE = "resources/maps/map-sample-2.txt";
	private static final char[][] MAP_TAB = CharArrayFileReader.parseFile(SAMPLE);

	@Test
	void constructorInstanceOf() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertTrue(tqg instanceof TreasureQuestGame);
	}

	@Test
	void getMap() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertTrue(tqg.getCoords() != null);
		assertTrue(tqg.getCoords() instanceof CaseMap);
	}

	@Test
	void getActiveRowAndCol() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertEquals(3, tqg.getActiveCol());
		assertEquals(2, tqg.getActiveRow());
	}

	@Test
	void getTypeActive() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertEquals('R', tqg.getActiveCaseType());
	}

	@Test
	void getCostActive() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertEquals(5, tqg.getActiveCaseCost());
	}

	@Test
	void getPlayerCoins() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertEquals(2, tqg.getPlayerCoins());
	}

	@Test
	void getNbTreasure() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertEquals(1, tqg.getNbTreasur());
	}

	@Test
	void getCaseTypeWithCoord() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertEquals(tqg.getCaseTypeWithCoord(new Coordinate(0, 0)), 'X');
		assertEquals(tqg.getCaseTypeWithCoord(new Coordinate(1, 1)), 'S');
	}

	@Test
	void getCoords() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertTrue(tqg.getCoords() instanceof Iterable<?>);
	}

	@Test
	void getActiveRow() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertEquals(2, tqg.getActiveRow());
	}

	@Test
	void getActiveCol() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertEquals(3, tqg.getActiveCol());
	}

	@Test
	void updateActiveCase() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		tqg.updateActiveCase(1, 1);
		assertEquals(3, tqg.getActiveRow());
		assertEquals(4, tqg.getActiveCol());
	}

	@Test
	void dig() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		tqg.updateActiveCase(1, 1);
		assertTrue(tqg.dig());
	}

	@Test
	void digOnTreasure() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		tqg.updateActiveCase(-1, -2);
		assertTrue(tqg.dig());
	}

	@Test
	void digOnWater() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		tqg.updateActiveCase(-2, -3);
		assertFalse(tqg.dig());
	}

	@Test
	void getCardianlPoint() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		tqg.updateActiveCase(-1, -1);
		assertEquals(CardinalPoints.WEST, tqg.getCardinalPoints());
	}

	@Test
	void hasTreasure() {
		Player player = new Player(0);
		TreasureQuestGame tqg = new TreasureQuestGame(new CaseMap(MAP_TAB, new FakeRandom()), player);
		assertFalse(tqg.ActiveHasTreasure());
		tqg.updateActiveCase(-1, -2);
		assertTrue(tqg.ActiveHasTreasure());
	}

}
