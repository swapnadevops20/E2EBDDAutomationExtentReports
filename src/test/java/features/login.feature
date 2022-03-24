Feature: Login into Application

Scenario Outline: Positive Test validating login
Given Initialize the browser with chrome
And Navigate to "https://www.shopclues.com/" WebSite
And Click on Signin Link in Home Page to land on Secure Signin Page
When User enters <emailId> and <phNo> and logs in
Then Verify that user is successfully logged in
And Close Browsers

Examples: 
      |emailId                   |phNo       |
      |swapnareddi.mca@gmail.com |9704584916 |
      |swapnareddi.mca@gmail.com |9704       |

