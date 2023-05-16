package treasurequest.domains;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProfilTest {

	@Test
	void profil() {
		List<Profil> profils=Arrays.asList(Profil.values());
		assertTrue(profils.contains(Profil.F));
		assertTrue(profils.contains(Profil.N));
		assertTrue(profils.contains(Profil.P));
		assertTrue(profils.contains(Profil.R));
		assertTrue(profils.contains(Profil.S));
	}
	
	@Test
	void title() {
		assertEquals(Profil.S.getTitle(), "TOURIST");
	}

}
