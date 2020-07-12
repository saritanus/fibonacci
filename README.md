# 1. Fibonacci Service 

A RESTful web service that
* Accepts a numerical value between 1 to 100, and returns the Fibonacci sequence.
```JSON
{“fibonnacci”: [0,1,1,2,3,5,8,13,21,34 ]}
```
* It also returns a sequence that is sorted using the following 
conditions: 
  1. Even numbers first, in descending order
  2. Odd numbers, in descending order 
```json
   {“sorted”: [34,8,2,0, 31,13,5,1,1] } 
```

## Request 
- **URL**: /fibonacci/fibonacci
- **method**: POST
- **consume**: application/json
 
```json
{
    "elements":10
}
```

## Response
- **produces**: application/json
```json
{"fibonacci":[0,1,1,2,3,5,8,13,21,34],
"sorted":[34,8,2,0,21,13,5,3,1,1]}
```

**Note**
* Given Zero or a negative number, it responds with a status code of 400 and an error message
 
    **Number elements are less than minimum value 1. [0]**		
		
* Given a number more than 100, it responds with a status code of 400 and an error message
 
  **Number elements are greater than the maximum value 100. [108]**
  
  ## Installation

* Clone this [Git Repository](https://github.com/saritanus/fibonacci.git)
* Execute the following code to run in an embedded tomcat server

```command
 ./gradle clean bootrun 
```
* Execute the following code to run in an external tomcat server

```command
 ./gradle clean bootwar
```
* Execute the following code to validate if you have done any changes in the code
```command
 ./gradle formatjava validate
```
**NOTE**
JUnit and Mockito has been implemented for unit and REST API testing.
