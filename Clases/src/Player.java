import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Player {
	private String name;
	private LocalDate birthDay;
	private String actualTeam;
	private int actualGoals;
	
	public void __constructor(String name, LocalDate birthDay, String actualTeam, int actualGoals) {
		this.name = name;
		this.birthDay = birthDay;
		this.actualTeam = actualTeam;
		this.actualGoals = actualGoals;
	}
	
	public String getPlayerData() {
		return this.name + " " + this.birthDay.format(DateTimeFormatter.ofPattern("d-M-y")) + " " + this.actualTeam + " " + this.actualGoals; 
	}
	
	public String getPlayerName() {
		return this.name;
	}
	
	public String getPlayerBirthDay() {
		return this.birthDay.format(DateTimeFormatter.ofPattern("d-M-y"));
	}
	
	public String getPlayerTeam() {
		return this.actualTeam;
	}
	
	public int getPlayerGoals() {
		return this.actualGoals;
	}
}
