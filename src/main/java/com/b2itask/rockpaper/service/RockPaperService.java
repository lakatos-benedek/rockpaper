package com.b2itask.rockpaper.service;

import java.util.HashMap;
import java.util.Optional;

import com.b2itask.rockpaper.model.RockPaperResponse;

public interface RockPaperService {
	public HashMap<String, String> getGameRules();
	public RockPaperResponse getComputerResponse(String gesture, Optional<Boolean> rules);
}
