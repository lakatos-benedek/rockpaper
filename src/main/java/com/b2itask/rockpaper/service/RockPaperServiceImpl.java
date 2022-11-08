package com.b2itask.rockpaper.service;

import java.util.HashMap;
import java.util.Optional;

import org.javatuples.Pair;
import org.springframework.stereotype.Service;

import com.b2itask.rockpaper.model.RockPaperResponse;

@Service
public class RockPaperServiceImpl implements RockPaperService {

	@Override
	public HashMap<String, String> getGameRules() {
		HashMap<String, String> rulesMap = new HashMap<>();
		rulesMap.put("Base Rules",
				"The player must select a gesture, send it via the API, then "
				+ "the computer chooses one aswell, and based on their answer "
				+ "the game will end in either side winning or a tie, if they "
				+ "chose the same gesture.");
		rulesMap.put("Rock", "Rock beats Scissors, and gets beaten by Paper.");
		rulesMap.put("Paper", "Paper beats Rock, and gets beaten by Scissors.");
		rulesMap.put("Scissor", "Scissors beats Paper, and gets beaten by Rock");
		rulesMap.put("Tie", "A tie occurs if both sides selected the same gesture.");
		return rulesMap;
	}

	public RockPaperResponse getComputerResponse(String gesture, Optional<Boolean> rules) {
		String lowerGesture = gesture.toLowerCase();
		if (!lowerGesture.equals("scissor") &&
			!lowerGesture.equals("rock") &&
			!lowerGesture.equals("paper")) {
			return null;
		}
		else {
			int computerChoice = (int) ((Math.random() * 3) + 1);
			switch(computerChoice) {
			case 1:
				return createResponse(lowerGesture, "Rock", rules.isPresent() ? rules.get() : false);
			case 2:
				return createResponse(lowerGesture, "Paper", rules.isPresent() ? rules.get() : false);
			case 3:
				return createResponse(lowerGesture, "Scissor", rules.isPresent() ? rules.get() : false);
			default:
				return null;
			}
		}
	}
	
	private RockPaperResponse createResponse(String gesture, String computerGesture, Boolean rules) {
		RockPaperResponse response = new RockPaperResponse();
		response.setComputerGesture(computerGesture);
		response.setGameResult(gameResult(gesture,computerGesture.toLowerCase()).getValue0());
		if (rules) {
			if (gameResult(gesture,computerGesture.toLowerCase()).getValue1()) {
				response.setGameRule(getGameRules().get("Tie"));
			}
			else {
				response.setGameRule(getGameRules().get(computerGesture));
			}
		}
		return response;
	}
	
	private Pair<Boolean,Boolean> gameResult(String gesture, String computerChoice) {
		if (gesture.equals(computerChoice)) {
			return new Pair<Boolean,Boolean>(false, true);
		}
		if (gesture.equals("scissor") && computerChoice.equals("rock")
				|| gesture.equals("rock") && computerChoice.equals("paper")
				|| gesture.equals("paper") && computerChoice.equals("scissor")) {
			return new Pair<Boolean,Boolean>(false, false);
		}
		else {
			return new Pair<Boolean,Boolean>(true, false);
		}
	}
}
