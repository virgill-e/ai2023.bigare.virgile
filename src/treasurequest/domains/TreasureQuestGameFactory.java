package treasurequest.domains;

public class TreasureQuestGameFactory {
	
	private TreasureQuestGame game;
	private String sample;
	
	public TreasureQuestGameFactory(String sample) {
		this.sample=sample;
	}
	
	public void createGame() {
		game = new TreasureQuestGame(this.sample);
	}
	
	public TreasureQuestGame getGame() {
		return this.game;
	}
}
