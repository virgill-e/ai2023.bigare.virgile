package treasurequest.domains;

public class Player {
	private int coins;
	
	public Player(int coins) {
		this.coins=coins;
	}
	
	public void substractCoins(int value) {
		this.coins-=Math.abs(value);
		Math.max(0, this.coins);
	}
	
	public int getCoins() {
		return this.coins;
	}
}
