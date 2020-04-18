package com.sapient.project.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.project.model.InvalidParamException;
import com.sapient.project.model.ScoreRequest;
import com.sapient.project.service.CricketService;


@RestController
public class MainController {

	
	@Autowired
	CricketService myService;

	@GetMapping("/matchScore")
	public ResponseEntity<Map<String,String>> greeting(@RequestParam(value = "Match-UniqueID") String matchID) throws Exception {
		if(matchID == null) {
	         throw new InvalidParamException("Invalid employee id : " + matchID);
	    }
		int id ;
		try {
			id = Integer.parseInt(matchID);
		}
		catch(Exception ex) {
			throw new InvalidParamException("Invalid employee id : " + matchID);
		}
		
		ScoreRequest scoreReq =  new ScoreRequest();
		scoreReq.setMatchID(id);
		Map<String,String> res = myService.getScore(scoreReq);
		return new ResponseEntity<Map<String,String>>(res, HttpStatus.OK); 
}

}


