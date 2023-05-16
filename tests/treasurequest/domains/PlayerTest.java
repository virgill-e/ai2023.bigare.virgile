package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
	
	@Test
	void getSpend() {
		Player player=new Player(0);
		player.addCoins(20);
		player.substractCoins(10);
		assertEquals(10, player.getSpend());
	}
	
	@Test
	void getGain() {
		Player player=new Player(0);
		player.addCoins(20);
		player.substractCoins(10);
		assertEquals(20, player.getGain());		
	}
	
	@Test
	void getTime() throws InterruptedException {
		Player player=new Player(0);
		TimeUnit.SECONDS.sleep(2);
		assertNotEquals("00:00", player.getMinSeconde());
	}
	
	@Test
	void profil() {
		Player player=new Player(0);
		player.setProfil(Profil.F);
		assertEquals(Profil.F, player.getProfil());
		player.setProfil(null);
		assertEquals(Profil.N, player.getProfil());
	}
	
	@Test
	void zone() {
		Player player=new Player(0);
		Set<Coordinate> zone=new HashSet<Coordinate>();
		player.setZone(zone);
		assertEquals(zone, player.getZone());
	}

}
