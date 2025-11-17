# Deliverable Set Test Cases

## Overview
This document describes the test cases for the deliverable set feature, which includes the Comments & Activities sidebar and TFL (Table/Figure/Listing) file tab management functionality.

## Test File Locations
- **Feature File**: `src/test/resources/Features/deliverableSet.feature`
- **Page Object**: `src/test/java/pages/DeliverableSetPage.java`
- **Step Definitions**: `src/test/java/StepDefinitions/DeliverableSetSteps.java`

## Running the Tests

### Run all deliverable set tests
```bash
./gradlew cucumber -Dcucumber.filter.tags="@deliverableSet"
```

### Run all tests
```bash
./gradlew test
```

### Run cucumber tests
```bash
./gradlew cucumber
```

## Test Scenarios

### 1. Display Comments and Activities Sidebar
**Purpose**: Verify that the right sidebar displays the "Comments & Activities" area when a deliverable set is opened.

**Steps**:
- User opens a deliverable set
- Right sidebar should display "Comments & Activities" area
- Right sidebar should be visible

**Expected Result**: The Comments & Activities sidebar is displayed and visible.

---

### 2. Collapse the Right Sidebar
**Purpose**: Verify that users can collapse the right sidebar.

**Steps**:
- Given the right sidebar is expanded
- User clicks to collapse the right sidebar
- Right sidebar should be collapsed
- Main view area should expand

**Expected Result**: The right sidebar collapses and the main view area expands to use the available space.

---

### 3. Expand the Right Sidebar
**Purpose**: Verify that users can expand a collapsed right sidebar.

**Steps**:
- Given the right sidebar is collapsed
- User clicks to expand the right sidebar
- Right sidebar should be expanded
- "Comments & Activities" area should be visible

**Expected Result**: The right sidebar expands and the Comments & Activities area becomes visible.

---

### 4. Open a TFL File and Display it in a Tab
**Purpose**: Verify that selecting a TFL file displays it in the main view and creates a new tab.

**Steps**:
- User selects a TFL file "Table 1: Patient Demographics"
- File content should be displayed in the main view area
- A new tab should be created with name "Table 1: Patient Demographics"
- The tab should be active

**Expected Result**: The file content is displayed, a new tab is created with the file name, and the tab is active.

---

### 5. Open Multiple TFL Files
**Purpose**: Verify that multiple TFL files can be opened in separate tabs.

**Steps**:
- Given user has opened a TFL file "Table 1: Patient Demographics"
- User selects another TFL file "Figure 1: Study Flow"
- A new tab should be created with name "Figure 1: Study Flow"
- The new tab should be positioned next to the previous tab
- The new tab should be active

**Expected Result**: A second tab is created next to the first tab, and the new tab becomes active.

---

### 6. Focus on Already Opened Tab
**Purpose**: Verify that selecting an already opened file focuses on the existing tab instead of creating a new one.

**Steps**:
- Given user has opened TFL files "Table 1: Patient Demographics" and "Figure 1: Study Flow"
- User selects the TFL file "Table 1: Patient Demographics" again
- The existing tab "Table 1: Patient Demographics" should be focused
- No new tab should be created

**Expected Result**: The existing tab is focused and no duplicate tab is created.

---

### 7. Close a TFL File Tab
**Purpose**: Verify that users can close TFL file tabs using the close icon.

**Steps**:
- Given user has opened a TFL file "Table 1: Patient Demographics"
- User clicks the close icon on the tab "Table 1: Patient Demographics"
- The tab "Table 1: Patient Demographics" should be closed
- The file should no longer be displayed in the main view

**Expected Result**: The tab is closed and the file is no longer displayed.

---

### 8. Cannot Close Table of Contents Tab
**Purpose**: Verify that the "Table of contents" tab cannot be closed.

**Steps**:
- Given the "Table of contents" tab is displayed
- The "Table of contents" tab should not have a close icon
- The "Table of contents" tab cannot be closed

**Expected Result**: The Table of contents tab does not have a close icon and cannot be closed.

---

### 9. Close One Tab While Others Remain Open
**Purpose**: Verify that closing one tab doesn't affect other open tabs.

**Steps**:
- Given user has opened three TFL files:
  - "Table 1: Patient Demographics"
  - "Figure 1: Study Flow"
  - "Listing 1: Adverse Events"
- User clicks the close icon on the tab "Figure 1: Study Flow"
- The tab "Figure 1: Study Flow" should be closed
- The tabs "Table 1: Patient Demographics" and "Listing 1: Adverse Events" should still be visible

**Expected Result**: Only the selected tab is closed, other tabs remain open and visible.

---

## Test Implementation Details

### Page Object Model
The `DeliverableSetPage` class provides methods to interact with:
- Right sidebar (collapse, expand, verify state)
- TFL file selection
- Tab management (create, focus, close, verify)
- Main view area

### Step Definitions
The `DeliverableSetSteps` class implements:
- WebDriver setup and teardown
- Screenshot capture after each step
- ExtentReports logging integration
- All Given/When/Then step implementations

### Locators Used
The page object uses CSS selectors to locate elements:
- `.right-sidebar` - Right sidebar container
- `.sidebar-collapse-btn` / `.sidebar-expand-btn` - Collapse/expand buttons
- `.tfl-file-list .file-item` - TFL file items
- `.tab` - Tab elements
- `.tab.active` - Active tab
- `.close-icon` - Tab close icon

## Prerequisites
- Java 11 or higher
- Chrome browser installed
- ChromeDriver (automatically managed by WebDriverManager)

## Dependencies
- Selenium WebDriver 3.141.59
- Cucumber 7.4.1
- JUnit 4.13.2
- WebDriverManager 5.3.0
- ExtentReports 5.0.9

## Notes
- Tests use the `@deliverableSet` tag for selective execution
- Screenshots are captured after each step for reporting
- WebDriverManager automatically downloads and manages ChromeDriver
- Tests follow the existing project patterns and conventions
