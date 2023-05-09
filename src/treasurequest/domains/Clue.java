package treasurequest.domains;

import java.util.Objects;

/**
 * class representant des indice
 * 
 * @author virgi
 *
 */
public class Clue {
	private final CardinalPoints cardinalPoint;
	private final Coordinate originTreasure;

	/**
	 * Constructor d'indice recevant un CardinalPoints et une Coodinate du tresor
	 * vers qui le CardinalPoints pointe
	 * 
	 * @param cardinal
	 * @param treasure
	 */
	public Clue(CardinalPoints cardinal, Coordinate treasure) {
		Objects.requireNonNull(treasure);
		Objects.requireNonNull(cardinal);
		this.cardinalPoint = cardinal;
		this.originTreasure = treasure;
	}

	public Coordinate getOriginTreasure() {
		return this.originTreasure;
	}


	public CardinalPoints getCardinalPoint() {
		return cardinalPoint;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cardinalPoint, originTreasure);
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
		return cardinalPoint == other.cardinalPoint && Objects.equals(originTreasure, other.originTreasure);
	}

}
