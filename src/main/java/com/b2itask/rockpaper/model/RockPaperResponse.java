package com.b2itask.rockpaper.model;

import java.util.Optional;

public class RockPaperResponse {

	private String computerGesture;
	private Boolean gameResult;
	private Optional<String> gameRule;
	
	public String getComputerGesture() {
		return computerGesture;
	}
	public void setComputerGesture(String computerGesture) {
		this.computerGesture = computerGesture;
	}
	public Boolean getGameResult() {
		return gameResult;
	}
	public void setGameResult(Boolean gameResult) {
		this.gameResult = gameResult;
	}
	public Optional<String> getGameRule() {
		return gameRule;
	}
	public void setGameRule(String gameRule) {
		this.gameRule = Optional.of(gameRule);
	}
	
}
