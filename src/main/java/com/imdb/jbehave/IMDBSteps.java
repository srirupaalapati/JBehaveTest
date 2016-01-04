package com.imdb.jbehave;


import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.BeforeScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.core.embedder.Embedder;


public class IMDBSteps extends Embedder{

	
		private SystemUnderTestPage system;

		@BeforeScenario
		public void startSystem() {
			
			system = new SystemUnderTestPage();
			try {
				system.start();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		@AfterScenario
		public void stopSystem()  {
			system.stop();

		}

		@Given("I am on imdb.com")
		public void startOnUrl()  {
			
			system.open();
		}
		
		// search string Star Wars: Episode I
		@When("I search for $String")
		public void searchQuery(String param) {
			
			system.search(param);
			
		}
		
		@When("Go to list of cast and crew")
		public void listCrew() {
			system.listCrew();
		}
		//Check if Jim Morris has a special thanks
		
		@Then("Check if $name has a $message")
		public void assertMessage(String name, String message) {
			system.assertFinalMsg(name,message);
		}

	
	}


