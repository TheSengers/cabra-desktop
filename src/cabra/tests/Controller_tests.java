package cabra.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;
import cabra.*;

public class Controller_tests {

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
		clearApplicationData();
		Controller cont = new Controller();
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
		clearApplicationData();
		Controller cont = new Controller();
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
	//creating a project with an empty string for a name.
	public void addProject_withEmptyName_test() {
		clearApplicationData();
		Controller cont = new Controller();
		Project proj = cont.addProject("Project1", false);
		
		ArrayList<Project> Projects = cont.getAllProjects();
		
		int actualSize = Projects.size();
		int expectedSize = 0;
		assertEquals("Number of projects",expectedSize, actualSize);		
	}
	
	@Test
	//creating a project with a null string for a name.
	public void addProject_withNullName_test() {
		clearApplicationData();
		Controller cont = new Controller();
		Project proj = cont.addProject(null, true);
		
		ArrayList<Project> Projects = cont.getAllProjects();
		
		int actualSize = Projects.size();
		int expectedSize = 0;
		assertEquals("Number of projects",expectedSize, actualSize);		
	}

}
