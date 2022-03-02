package models;

public class Player {
	private boolean isDeleted = false; //1
	private String playerName; //22
	private String playerPosition; //10
	private int playerNum; //4
	private String playerTeam; //32
	private int playerScores; //4

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public String getPlayerTeam() {
		return playerTeam;
	}

	public void setPlayerTeam(String playerTeam) {
		this.playerTeam = playerTeam;
	}

	public int getPlayerScores() {
		return playerScores;
	}

	public void setPlayerScores(int playerScores) {
		this.playerScores = playerScores;
	}

}
