package org.ssglobal.training.codes;

public class ScoreInfo {
	
	private String firstName;
	private String lastName;
	private int score;
	
	public ScoreInfo(String lName, String fName, int s) {
		firstName = fName;
		lastName = lName;
		score = s;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.join(" ", firstName, lastName, String.valueOf(score));
	}
}
