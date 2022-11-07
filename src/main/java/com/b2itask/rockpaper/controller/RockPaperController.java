package com.b2itask.rockpaper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
		return new ResponseEntity<Object>(rockPaperService.getGameRules(),HttpStatus.OK);
	}
	
}
