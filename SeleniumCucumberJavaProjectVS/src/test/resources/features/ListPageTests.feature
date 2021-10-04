Feature: I can find a city inside a state.

# los <nombre> son parametros que se pasan a cucumber, a traves de la tabla examples
# osea que va a correr la cantidad de tests por variables que definamos
@List
Scenario Outline: As a Test Enginner, I want to validate that a text is present inside the list.
    Given I navigate to the list page
    When I search <state> in the list
    Then I can find <city> in the list

    Examples:
    |state      |city               |
    |Washington |Seattle, Washington|
    |Chicago    |Chicago, Illinois  |