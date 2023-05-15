package treasurequest.domains;

/**
 * enum des differents profils de joueur
 * @author virgi
 *
 */
public enum Profil {
	F("LUMBERJACK"), R("MINER"), P("FARMER"),S("TOURIST"),N("NONE");
	
	
	private String title;

	Profil(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}
}
