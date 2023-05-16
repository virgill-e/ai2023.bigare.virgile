package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


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
		assertEquals('X', water.getType());
		assertEquals('F', forest.getType());
		assertEquals('P', grassland.getType());
		assertEquals('R', rock.getType());
		assertEquals('S', sand.getType());
	}
	
	@Test
	void getCost() {
		CaseType forest=new CaseType('F');
		CaseType grassland=new CaseType('P');
		CaseType rock=new CaseType('R');
		CaseType sand=new CaseType('S');
		CaseType water=new CaseType('X');
		
		assertEquals(sand.getCost(), 1);
		assertEquals(grassland.getCost(), 2);
		assertEquals(forest.getCost(), 3);
		assertEquals(rock.getCost(), 5);
		assertEquals(water.getCost(), 0);
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
	
	@ParameterizedTest
    @CsvSource({ "S,S", "P,P", "F,F", "R,R", "A,X" })
    void testTypeOf(char input, char expectedOutput) {
        CaseType result = CaseType.typeOf(input);
        assertEquals(expectedOutput, result.getType());
    }
	
	@Test
	void hashCodeTest() {
		CaseType sand=new CaseType('S');
		CaseType sand2=new CaseType('S');
		CaseType rock=new CaseType('R');
		assertEquals(sand.hashCode(), sand2.hashCode());
		assertNotEquals(sand.hashCode(), rock.hashCode());
	}
	
	@Test
	void eequalTest() {
		CaseType sand=new CaseType('S');
		CaseType sand2=new CaseType('S');
		CaseType rock=new CaseType('R');
		assertTrue(sand.equals(sand2));
		assertTrue(sand.equals(sand));
		assertFalse(sand.equals(rock));
		assertFalse(sand.equals(null));
		assertFalse(sand.equals(new Player(0)));
	}
}
