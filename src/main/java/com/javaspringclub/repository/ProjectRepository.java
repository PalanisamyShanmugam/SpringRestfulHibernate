package com.javaspringclub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.javaspringclub.entity.Project;

@Repository("projectRepository")
public interface ProjectRepository extends CrudRepository<Project, Integer>{
	
	static final String GET_SORT_PROJECT_BY_START_DATE = "SELECT * FROM PROJECT ORDER BY START_DATE DESC";
	static final String GET_SORT_PROJECT_BY_END_DATE = "SELECT * FROM PROJECT ORDER BY END_DATE DESC";
	static final String GET_SORT_PROJECT_BY_PRIORITY = "SELECT * FROM PROJECT ORDER BY PRIORITY DESC";
	static final String GET_PROJECT_DETAILS_BY_PROJECT = "SELECT * FROM PROJECT WHERE PROJECT LIKE %:project%";

	@Query(nativeQuery = true, value=GET_SORT_PROJECT_BY_START_DATE)
	List<Project> getSortProjectByStartDate();
	
	@Query(nativeQuery = true, value=GET_SORT_PROJECT_BY_END_DATE)
	List<Project> getSortProjectByEndDate();
	
	@Query(nativeQuery = true, value=GET_SORT_PROJECT_BY_PRIORITY)
	List<Project> getSortProjectByPriority();

	@Query(nativeQuery = true, value=GET_PROJECT_DETAILS_BY_PROJECT)
	List<Project> getProjectDetailsByProject(@Param("project") String project);
	

}
