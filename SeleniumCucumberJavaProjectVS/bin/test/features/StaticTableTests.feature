@Grid
Feature: Test different actions on the Static Table page.

# La regla es la razon de ser del feature file la cual realmente no hace nada
# solo define el objetivo de esta y por lo cual definira si usar cucumber si vale
# la pena o no
Rule: The user can return values from the table and validate them

# esto se va a ejecutar siempre de primeras en cualquier scenario
Background: Navigate to Table web app.
    Given I navigate to the static table

@Smoke @Regression
Scenario: As a Test Enginner, I want to retrieve  the value of an static table.
    Then I can return the value I wanted

@Regression
Scenario: As a Test Enginner, I want to validate the static table is displayed.
    Then I can validate the table is displayed