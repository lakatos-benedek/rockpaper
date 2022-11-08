package com.b2itask.rockpaper.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.b2itask.rockpaper.model.Gesture;
import com.b2itask.rockpaper.exceptions.UnknownGestureException;
import com.b2itask.rockpaper.model.RockPaperResponse;
import com.b2itask.rockpaper.service.RockPaperService;

@RestController
@RequestMapping("/")
public class RockPaperController {

	private RockPaperService rockPaperService;

	@Autowired
	public RockPaperController(RockPaperService rockPaperService) {
		this.rockPaperService = rockPaperService;
	}

	@GetMapping("/rules")
	public ResponseEntity<Object> getGameRules() {
		return new ResponseEntity<Object>(rockPaperService.getGameRules(), HttpStatus.OK);
	}

	@PostMapping("/play")
	public ResponseEntity<RockPaperResponse> postPlayerGesture(@RequestBody Gesture gesture,
			@RequestParam("explain") Optional<Boolean> explainRule) {
		RockPaperResponse response = rockPaperService.getComputerResponse(gesture.getGesture(), explainRule);
		if (response == null) {
			throw new UnknownGestureException(gesture.getGesture());
		}
		else {
			return new ResponseEntity<RockPaperResponse>(response, HttpStatus.OK);
		}
	}

}
