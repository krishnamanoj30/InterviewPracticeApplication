package com.example.Project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Project.Model.Project;
import com.example.Project.Service.ProjectService;

@RestController
@RequestMapping("/Project")
public class ProjectController {
	
	@Autowired
	private ProjectService service; 
	
	
	@GetMapping("/Projects")
	public ResponseEntity<List<Project>> getProjectsList(){
		
		return ResponseEntity.ok().body(service.getProjectsList());
		
	}
	
	
	@PostMapping("/PostProject")
	public ResponseEntity<Project> addProject(@RequestBody Project project  ){
		return ResponseEntity.ok().body(service.addProject(project));
	}

}
