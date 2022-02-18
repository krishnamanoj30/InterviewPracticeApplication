package com.example.Project.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Project.Model.Project;
import com.example.Project.Repository.ProjectDao;

@Service
public class ProjectService {

	
	@Autowired
	private ProjectDao dao;
	
	public List<Project> getProjectsList(){
		
		List<Project> list=dao.findAll();
		return list;
	}

	public Project addProject(Project project) {
		// TODO Auto-generated method stub
		return dao.save(project);
	}
	
	
}
