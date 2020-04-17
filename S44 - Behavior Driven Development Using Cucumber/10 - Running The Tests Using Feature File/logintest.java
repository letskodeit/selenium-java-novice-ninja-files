// Save this file with .feature extension and delete this line

Feature: Login
Scenario: Successful Login with Valid Credentials
Given User is on Home Page
When User enters UserName and Password
Then He can visit the practice page

Scenario: Successful LogOut
When User LogOut from the Application
Then he cannot visit practice page