package cabra.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*;

public class Controller_tests {

	//this functions clears all application data and returns a new Controller.
	private Controller getNewController()
	{
		clearApplicationData();
		return new Controller();
	}
	
	//this functions clears all projects, cards, notes and user data.
	private void clearApplicationData(){	
		Utils.purgeFolder(SaveLoad.getProjectFolder());
        UserData.makeAllDefault();
	}
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	//simply add one project and see if it was stored in the application properly.
	public void addProject_positiveTest() {
		Controller cont = getNewController();
		Project proj = cont.addProject("Project1", true);
		
		ArrayList<Project> Projects = cont.getAllProjects();
		
		int actualSize = Projects.size();
		int expectedSize = 1;
		assertEquals("Number of projects",expectedSize, actualSize);
		
		String actualName = Projects.get(0).getName();
		String expectedName = "Project1";
		assertEquals("Name of added project", expectedName, actualName);	
	}
	
	@Test
	//simply add one project but with a false "shouldSave" input.
	//"shouldSave" pertains to saving UserData, not projects.
	public void addProject_positiveTest2() {
		Controller cont = getNewController();
		Project proj = cont.addProject("Project1", false);
		
		ArrayList<Project> Projects = cont.getAllProjects();
		
		int actualSize = Projects.size();
		int expectedSize = 1;
		assertEquals("Number of projects",expectedSize, actualSize);
		
		String actualName = Projects.get(0).getName();
		String expectedName = "Project1";
		assertEquals("Name of added project", expectedName, actualName);
	}
	
	@Test
	//adding multiple projects
	public void addProject_multipeProjects_test() {
		Controller cont = getNewController();
		cont.addProject("Project1", true);
		cont.addProject("Project2", true);
		cont.addProject("Project3", true);
		cont.addProject("Project4", true);
		
		ArrayList<Project> Projects = cont.getAllProjects();
		
		int actualSize = Projects.size();
		int expectedSize = 4;
		assertEquals("Number of projects",expectedSize, actualSize);
	}	
	
	@Test
	//creating a project with an empty string for a name.
	public void addProject_withEmptyName_test() {
		Controller cont = getNewController();
		Project proj = cont.addProject("", true);
		
		ArrayList<Project> Projects = cont.getAllProjects();
		
		int actualSize = Projects.size();
		int expectedSize = 0;
		assertEquals("Number of projects",expectedSize, actualSize);		
	}
	
	@Test 
	//creating a project with a null string for a name.
	public void addProject_withNullName_test() {
		Controller cont = getNewController();
		Project proj = cont.addProject(null, true);
		
		ArrayList<Project> Projects = cont.getAllProjects();
		
		int actualSize = Projects.size();
		int expectedSize = 0;
		assertEquals("Number of projects",expectedSize, actualSize);		
	}
	
	@Test
	//testing getNumberOfProjects with 0 projects added.
	public void getNumberofProjects_zeroProjects_test() {
		Controller cont = getNewController();
		
		int actualSize = cont.getNumberOfProjects();
		int expectedSize = 0;
		assertEquals("Number of projects",expectedSize, actualSize);		
	}
	
	@Test
	//testing getNumberOfProjects with 4 projects added.
	public void getNumberofProjects_mutltipleProjects_test() {
		Controller cont = getNewController();
		cont.addProject("p1", true);
		cont.addProject("p2", true);
		cont.addProject("p3", true);
		cont.addProject("p4", true);
			
		int actualSize = cont.getNumberOfProjects();
		int expectedSize = 4;
		assertEquals("Number of projects",expectedSize, actualSize);		
	}
	
	@Test
	//remove an added project.
	public void removeProject_postiveTest() {
		Controller cont = getNewController();
		
		cont.addProject("p1", true);
		cont.addProject("p2", true);
		Project projectToRemove = cont.addProject("p3", true);
		cont.addProject("p4", true);
		
		cont.removeProject(projectToRemove);
		
		ArrayList<Project> allProjects = cont.getAllProjects();
		boolean actualBool = allProjects.contains(projectToRemove);
		boolean expectedBool = false;
		
		assertEquals("Added project is still present",expectedBool, actualBool);		
	}
	
	@Test
	//remove a project that doesn't exist.
	public void removeProject_removeProjectThatDoesntExist() {
		Controller cont = getNewController();
		
		cont.addProject("p1", true);
		cont.addProject("p2", true);
		cont.addProject("p3", true);
		cont.addProject("p4", true);
		
		Project projectToRemove = new Project("p5");
		cont.removeProject(projectToRemove);
		
		int actualSize = cont.getNumberOfProjects();
		int expectedSize = 4;
		assertEquals("Number of projects",expectedSize, actualSize);		
	}
	
	@Test
	//renaming project
	public void renameProject_postiveTest() {
		Controller cont = getNewController();
		
		Project proj = cont.addProject("p1", true);
		
		cont.renameProject(proj, "newProject");
	
		String actualName = cont.getAllProjects().get(0).getName();
		String expectedName = "newProject";
		assertEquals("Name of project",expectedName, actualName);		
	}
	
	@Test
	//renaming project with an empty string.
	public void renameProject_emptyString_test() {
		Controller cont = getNewController();
		
		Project proj = cont.addProject("p1", true);
		
		cont.renameProject(proj, "");
	
		String actualName = cont.getAllProjects().get(0).getName();
		String expectedName = "p1";
		assertEquals("Name of project",expectedName, actualName);		
	}
	
	@Test
	//renaming project with a null string.
	public void renameProject_nullString_test() {
		Controller cont = getNewController();
		
		Project proj = cont.addProject("p1", true);
		
		cont.renameProject(proj, null);
	
		String actualName = cont.getAllProjects().get(0).getName();
		String expectedName = "p1";
		assertEquals("Name of project",expectedName, actualName);		
	}
	
	@Test
	//setting an active project.
	public void setActiveProject_positiveTest() {
		Controller cont = getNewController();
		
		cont.addProject("p1", true);
		Project proj = cont.addProject("p2", true);
		
		cont.setActiveProject(proj, true);	
	
		String actualName = cont.getActiveProject().getName();
		String expectedName = "p2";
		assertEquals("Name of project",expectedName, actualName);		
	}
	
	@Test
	//setting an active project using the project name.
	public void setActiveProject_withProjectName() {
		Controller cont = getNewController();
		
		cont.addProject("p1", true);
		Project proj = cont.addProject("p2", true);
		
		cont.setActiveProject("p2", true);	
	
		String actualName = cont.getActiveProject().getName();
		String expectedName = "p2";
		assertEquals("Name of project",expectedName, actualName);		
	}
	
	@Test
	//setting no active project.
	public void setNoActiveProject_positiveTest() {
		Controller cont = getNewController();
		
		cont.addProject("p1", true);
		Project proj = cont.addProject("p2", true);
		cont.setNoActiveProject();
			
		Project actualProject = cont.getActiveProject();
		Project expectedProject = null;
		assertEquals("Active roject",expectedProject, actualProject);		
	}
	
	@Test
	//setting active project with name that doesn't exist.
	public void setActiveProject_withNonExistantProjectName_test() {
		Controller cont = getNewController();
		
		cont.addProject("p1", true);
		cont.addProject("p2", true);
		cont.setActiveProject("p1", true);
		cont.setActiveProject("p5", true);
			
		String actualName = cont.getActiveProject().getName();
		String expectedName = "p1";
		assertEquals("Name of project",expectedName, actualName);		
	}
	
	@Test
	//setting active project with a null project.
	public void setActiveProject_withNullProject_test() {
		Controller cont = getNewController();
		
		cont.addProject("p1", true);
		cont.addProject("p2", true);
		cont.setActiveProject("p1", true);
		
		Project proj = null;
		cont.setActiveProject(proj, true);
			
		String actualName = cont.getActiveProject().getName();
		String expectedName = "p1";
		assertEquals("Name of project",expectedName, actualName);		
	}


}
