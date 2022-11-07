package com.b2itask.rockpaper.service;

import java.util.HashMap;

import org.springframework.stereotype.Service;

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
		rulesMap.put("Scissors", "Scissors beats Paper, and gets beaten by Rock");
		return rulesMap;
	}

}
