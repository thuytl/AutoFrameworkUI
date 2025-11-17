@deliverableSet
Feature: Test deliverable set functionality
  As a user
  I want to view and interact with deliverable sets
  So that I can review TFL files and see comments and activities

  Background: User opens a specific deliverable set
    Given user is on the deliverable set page

  Scenario: Display Comments and Activities sidebar
    Then the right sidebar should display "Comments & Activities" area
    And the right sidebar should be visible

  Scenario: Collapse the right sidebar
    Given the right sidebar is expanded
    When user clicks to collapse the right sidebar
    Then the right sidebar should be collapsed
    And the main view area should expand

  Scenario: Expand the right sidebar
    Given the right sidebar is collapsed
    When user clicks to expand the right sidebar
    Then the right sidebar should be expanded
    And the "Comments & Activities" area should be visible

  Scenario: Open a TFL file and display it in a tab
    When user selects a TFL file "Table 1: Patient Demographics"
    Then the file content should be displayed in the main view area
    And a new tab should be created with name "Table 1: Patient Demographics"
    And the tab should be active

  Scenario: Open multiple TFL files
    Given user has opened a TFL file "Table 1: Patient Demographics"
    When user selects another TFL file "Figure 1: Study Flow"
    Then a new tab should be created with name "Figure 1: Study Flow"
    And the new tab should be positioned next to the previous tab
    And the new tab should be active

  Scenario: Focus on already opened tab when selecting the same file
    Given user has opened a TFL file "Table 1: Patient Demographics"
    And user has opened a TFL file "Figure 1: Study Flow"
    When user selects the TFL file "Table 1: Patient Demographics" again
    Then the existing tab "Table 1: Patient Demographics" should be focused
    And no new tab should be created

  Scenario: Close a TFL file tab
    Given user has opened a TFL file "Table 1: Patient Demographics"
    When user clicks the close icon on the tab "Table 1: Patient Demographics"
    Then the tab "Table 1: Patient Demographics" should be closed
    And the file should no longer be displayed in the main view

  Scenario: Cannot close Table of Contents tab
    Given the "Table of contents" tab is displayed
    Then the "Table of contents" tab should not have a close icon
    And the "Table of contents" tab cannot be closed

  Scenario: Open multiple files and close one
    Given user has opened a TFL file "Table 1: Patient Demographics"
    And user has opened a TFL file "Figure 1: Study Flow"
    And user has opened a TFL file "Listing 1: Adverse Events"
    When user clicks the close icon on the tab "Figure 1: Study Flow"
    Then the tab "Figure 1: Study Flow" should be closed
    And the tab "Table 1: Patient Demographics" should still be visible
    And the tab "Listing 1: Adverse Events" should still be visible
