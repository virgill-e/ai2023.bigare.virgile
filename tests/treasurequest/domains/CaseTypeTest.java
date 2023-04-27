package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import treasurequest.supervisors.views.TileType;

class CaseTypeTest {

	@Test
	void constructorInstanceOf() {
		assertTrue(new CaseType(TileType.WATER) instanceof CaseType);
	}
	
	@Test
	void isGoodType() {
		CaseType water=new CaseType(TileType.WATER);
		CaseType forest=new CaseType(TileType.FOREST);
		CaseType grassland=new CaseType(TileType.GRASSLAND);
		CaseType rock=new CaseType(TileType.ROCK);
		CaseType sand=new CaseType(TileType.SAND);
		CaseType unknown=new CaseType(TileType.UNKNOWN);
		assertEquals(TileType.WATER, water.getType());
		assertEquals(TileType.FOREST, forest.getType());
		assertEquals(TileType.GRASSLAND, grassland.getType());
		assertEquals(TileType.ROCK, rock.getType());
		assertEquals(TileType.SAND, sand.getType());
		assertEquals(TileType.UNKNOWN, unknown.getType());
	}
	
	@Test
	void getCost() {
		CaseType forest=new CaseType(TileType.FOREST);
		CaseType grassland=new CaseType(TileType.GRASSLAND);
		CaseType rock=new CaseType(TileType.ROCK);
		CaseType sand=new CaseType(TileType.SAND);
		
		assertEquals(sand.getCost(), 1);
		assertEquals(grassland.getCost(), 2);
		assertEquals(forest.getCost(), 3);
		assertEquals(rock.getCost(), 5);
	}
	
	@Test
	void canBeDug() {
		CaseType water=new CaseType(TileType.WATER);
		CaseType forest=new CaseType(TileType.FOREST);
		CaseType grassland=new CaseType(TileType.GRASSLAND);
		CaseType rock=new CaseType(TileType.ROCK);
		CaseType sand=new CaseType(TileType.SAND);
		
		assertFalse(water.canBeDug());
		assertTrue(forest.canBeDug());
		assertTrue(grassland.canBeDug());
		assertTrue(rock.canBeDug());
		assertTrue(sand.canBeDug());
		
	}
}
