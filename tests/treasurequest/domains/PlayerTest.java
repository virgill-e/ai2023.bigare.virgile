package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {

	@Test
	void constructoInstanceOf() {
		assertTrue(new Player(20) instanceof Player);
	}
	
	@Test
	void substractCoins() {
		Player pl=new Player(20);
		pl.substractCoins(10);
		assertEquals(10, pl.getCoins());
	}
	
	@Test
	void substractTooMuchCoins() {
		Player pl=new Player(20);
		pl.substractCoins(30);
		assertEquals(0, pl.getCoins());
	}
	
	@Test
	void addCoins() {
		Player player=new Player(0);
		player.addCoins(4970);
		assertEquals(4970, player.getCoins());
	}

}
