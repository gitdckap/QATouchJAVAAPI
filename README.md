## How to Sync Selenium TestNG Test Results with QA Touch API?

You can sync your SeleniumTestNG test automation test result in QA Touch directly with the API endpoints. 


	 git clone git@github.com:gitdckap/QATouchJAVAAPI.git

​​
##	QA Touch API

QA Touch is a Collaborative Test Case Management tool For Modern QA Teams


## Generate API Key

Before you start using our API, your first step is to obtain an api-token from your QA Touch site. Once you obtain the token, then you are ready to go.

To Obtain api-token follow the steps below Go to User->Edit profile Under General settings, Click 'Generate API Key' to generate the API key.

API Key generation is available under Email Notification Settings

(Note: QA Touch API is a Premium feature only for Professional and Enterprise users)

## Information

All the API endpoints require a couple of headers so that we can authenticate you before processing the request.

Required Headers

domain
api-token

## Variables

$domain = '*****';              
		// Your Domain name

$apiToken = 'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX';   
		// Your API Key Token generated in your domain 
		
		(Go to User->Edit profile Under General settings, Click 'Generate API Key')

$url    = 'https://api.qatouch.com/api/v1/';                // QA Touch API URL


## Selenium Test Result Sync:
Setup and configure the values API token, domain, project,test_run, and run_result like the sample files.
There are two files available. They are:
1. AddResultNew.java 
2. GoogleTest.java

File path : (QATouchJAVAAPI/src/main/java/com/qatouch/apitestsync)

In this file, AddResultNew.java, configure the values for API Token, domain. 
This file, GoogleTest.java, is a Selenium TestNG sample test file. Configure and pass the values for project, test_run, and run_result in the function addResultForTestCase.




## Pagination

By default, all the endpoints which return more than 50 rows are paginated. You can move to another page by adding parameters to the request.

For example : api.qatouch.com/api/v1/getAllProjects?page=2

The above example will return the data which are available in the second page of the request.


## Projects

Provides the list of projects created for your domain.

GET api.qatouch.com/api/v1/getAllProjects
