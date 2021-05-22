Feature: Validating Title

Scenario: Validating the title of landing page

Given User lands on the URL "http://www.qaclickacademy.com/"
When Title is checked
Then Title is correct or not