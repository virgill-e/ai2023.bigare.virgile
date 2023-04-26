package treasurequest.domains;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import treasurequest.io.CharArrayFileReader;

class CaseTest {

	@Test
	void isInstanceOf() {
		Case actualCase=new Case('S');
		assertTrue(actualCase instanceof Case);
	}

}
