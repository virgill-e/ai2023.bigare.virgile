package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CaseTypeTest {

	@Test
	void constructorInstanceOf() {
		assertTrue(new CaseType('W') instanceof CaseType);
	}
	
	@Test
	void isGoodType() {
		CaseType water=new CaseType('W');
		CaseType forest=new CaseType('F');
		CaseType grassland=new CaseType('P');
		CaseType rock=new CaseType('R');
		CaseType sand=new CaseType('S');
		CaseType unknown=new CaseType('U');
		assertEquals('W', water.getType());
		assertEquals('F', forest.getType());
		assertEquals('P', grassland.getType());
		assertEquals('R', rock.getType());
		assertEquals('S', sand.getType());
		assertEquals('U', unknown.getType());
	}
	
	@Test
	void getCost() {
		CaseType forest=new CaseType('F');
		CaseType grassland=new CaseType('P');
		CaseType rock=new CaseType('R');
		CaseType sand=new CaseType('S');
		
		assertEquals(sand.getCost(), 1);
		assertEquals(grassland.getCost(), 2);
		assertEquals(forest.getCost(), 3);
		assertEquals(rock.getCost(), 5);
	}
	
	@Test
	void canBeDug() {
		CaseType water=new CaseType('X');
		CaseType forest=new CaseType('F');
		CaseType grassland=new CaseType('P');
		CaseType rock=new CaseType('R');
		CaseType sand=new CaseType('S');
		
		assertFalse(water.canBeDug());
		assertTrue(forest.canBeDug());
		assertTrue(grassland.canBeDug());
		assertTrue(rock.canBeDug());
		assertTrue(sand.canBeDug());
		
	}
}
