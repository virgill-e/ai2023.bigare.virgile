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
	
	public Coordinate getOriginTreasure() {
		return this.originTreasure;
	}
	
	public CardinalPoints getCardinalPoint() {
		return cardinal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardinal, originTreasure);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clue other = (Clue) obj;
		return cardinal == other.cardinal && Objects.equals(originTreasure, other.originTreasure);
	}
	
	
}
