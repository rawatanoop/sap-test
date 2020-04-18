package com.sapient.project.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.sapient.project.model.ExtRestResponse;
import com.sapient.project.model.ScoreRequest;

@Service
public class CricketService implements IService {
	@Autowired
	RestTemplate restTemplate;
	
	/***
	 * These properties can be saved in environment specific files.
	 */
	String URL = "http://cricapi.com/api/cricketScore";
	String PARAM_MATCH_ID = "unique_id";
	String PARAM_API_KEY = "apikey" ;
	String RESPONSE_KEY_Team1 = "Team-1" ;
	String RESPONSE_KEY_Team2 = "Team-2" ;
	String RESPONSE_KEY_WinTeamScr = "Winning team’s score" ;
	String RESPONSE_KEY_RoundRotation = "Round rotation" ;

	/***
	 * The key can be saved in environment specific files in encrypted form
	 */
	String key_Value="WmPJrX2s3KMyZVPFwlm1vxXLXKw1";
	
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
	
	public Map<String,String> getScore(ScoreRequest scoreReq) {

		UriComponentsBuilder builder = UriComponentsBuilder
		    .fromUriString(URL)
		    .queryParam(PARAM_MATCH_ID, scoreReq.getMatchID())
		    .queryParam(PARAM_API_KEY, key_Value);

		
		ExtRestResponse result = restTemplate.getForObject(builder.toUriString(), ExtRestResponse.class);
		Map<String,String> res = new HashMap<String,String>();
		
		res.put(RESPONSE_KEY_Team1,result.getTeam1() );
		res.put(RESPONSE_KEY_Team2, result.getTeam2());
		res.put(RESPONSE_KEY_WinTeamScr, result.getTeam1()+"(Winner)");
		res.put(RESPONSE_KEY_RoundRotation, "12345/10");
		
		return res;
		

	}
	

}
