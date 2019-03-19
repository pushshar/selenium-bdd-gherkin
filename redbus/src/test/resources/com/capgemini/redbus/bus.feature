Feature: Finding buses
    Scenario: Searching bus from source to destination
        Given that the user want to travel "Pune (All Location)" to "Goa (All Location)"
        When it is the day of "28 Apr 2019"
        Then user is given with list of buses available