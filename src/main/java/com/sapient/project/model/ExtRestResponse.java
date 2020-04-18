package com.sapient.project.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExtRestResponse {
	
	@JsonProperty("team-1")	
	  private String team1;
	
	@JsonProperty("team-2")
	  private String team2;
	
	@JsonProperty("score")
	  private String scoreDesc;

	  public String getScoreString() {
		return scoreDesc;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public String getScoreDesc() {
		return scoreDesc;
	}

	public void setScoreDesc(String scoreDesc) {
		this.scoreDesc = scoreDesc;
	}




}
