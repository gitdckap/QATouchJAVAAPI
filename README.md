# QA Touch API

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

## config.php

$domain = '*****';              
		// Your Domain name

$apiToken = 'XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX';   
		// Your API Key Token generated in your domain 
		
		(Go to User->Edit profile Under General settings, Click 'Generate API Key')

$url    = 'https://api.qatouch.com/api/v1/';                // QA Touch API URL



## Pagination

By default, all the endpoints which return more than 50 rows are paginated. You can move to another page by adding parameters to the request.

For example : api.qatouch.com/api/v1/getAllProjects?page=2

The above example will return the data which are available in the second page of the request.


## Projects

Provides the list of projects created for your domain.

GET api.qatouch.com/api/v1/getAllProjects
