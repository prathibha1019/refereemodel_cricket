package controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entity.Referee;
import exception.ResourceNotFoundException;
import repository.RefereeRepository;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RefereeController {
	
@Autowired
RefereeRepository refereeRepository;

//Fetching data from database
@GetMapping("/referee")
public List<Referee> getAllReferee(){
	return refereeRepository.findAll();
}

//Fetching data from database
@GetMapping("/referee/{id}")
public ResponseEntity<Referee>getRefereeById(@PathVariable(value="id") int refefreeId)
throws ResourceNotFoundException{
	Referee referee=refereeRepository.findById(refefreeId).orElseThrow(()->new ResourceNotFoundException("Referee Id not found "+refefreeId));
	return ResponseEntity.ok().body(referee);
}

//saving data to the database
@PostMapping("/referee")
public Referee createReferee(@RequestBody Referee referee) {
	return refereeRepository.save(referee);
}

//Editing the data
@PutMapping("/referee/{id}")
public ResponseEntity<Referee> updateReferee(@PathVariable(value="id") int refefreeId, @RequestBody Referee refreeDetails) 
		throws ResourceNotFoundException{
	Referee referee = refereeRepository.findById(refefreeId).orElseThrow(()->new ResourceNotFoundException("Referee Id not found "+refefreeId));
			
	referee.setRefereeName(refreeDetails.getRefereeName());
	referee.setNoOfMatches(refreeDetails.getNoOfMatches());
	final Referee updatedReferee = refereeRepository.save(referee);
	return ResponseEntity.ok(updatedReferee);
}

//Delete the data
@DeleteMapping("/referee/{id}")
public Map<String, Boolean> deleteReferee(@PathVariable(value="id") int refefreeId)
throws ResourceNotFoundException{
	Referee referee = refereeRepository.findById(refefreeId).orElseThrow(()->new ResourceNotFoundException("Referee Id not found "+refefreeId));
	refereeRepository.delete(referee);
	Map<String,Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return response;
}	

}
