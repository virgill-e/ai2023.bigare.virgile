package treasurequest.domains;

/**
 * class pemettant de generer une carte
 * @author virgi
 *
 */
public class MapGenerator {
	private static final int SIZE=16;
	
	/**
	 * methode static qui renvoie un tableau de char a 2 dimension 
	 * aleatoire sur la carte donnee
	 * @param map
	 * @param random
	 * @return
	 */
	public static char[][] ramdomMap(char map[][],IRandom random){
		char[][] newMap=new char[SIZE][SIZE];
		int rdmCol=Math.abs(random.nextInt());
		int rdmRow=Math.abs(random.nextInt());
		rdmCol=rdmCol%map.length;
		rdmRow=rdmRow%map[0].length;
		if(rdmCol>map.length-SIZE) {
			rdmCol=rdmCol-SIZE;
		}
		if(rdmRow>map[0].length-SIZE) {
			rdmRow=rdmRow-SIZE;
		}
		
		for(int i=rdmRow;i<rdmRow+16;i++) {
			for(int j=rdmCol;j<rdmCol+16;j++) {
				newMap[i%SIZE][j%SIZE]=map[i][j];
			}
		}
		
		return newMap;
	}
}
