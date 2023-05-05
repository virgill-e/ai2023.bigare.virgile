package treasurequest.domains;

import java.util.Objects;

public class Clue {
	private CardinalPoints cardinal;
	private Coordinate originTreasure;
	
	public Clue(CardinalPoints cardinal,Coordinate treasure) {
		Objects.requireNonNull(treasure);
		this.cardinal=cardinal;
		this.originTreasure=treasure;
	}
}
