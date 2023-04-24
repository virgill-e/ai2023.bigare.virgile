package treasurequest.domains;

import treasurequest.io.CharArrayFileReader;

public class TreasureQuestGame {
	private CaseMap caseMap;
	
	public TreasureQuestGame(String sample) {
		this.caseMap=new CaseMap(CharArrayFileReader.parseFile(sample));
	}
	
	public CaseMap getMap() {
		return this.caseMap;
	}
}
