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


# 2. Deploying REST Web Service in a docker container

You must first install Docker on your server (LINUX) before you can install Fibonacci REST API. This section describes how to install Docker with an installation script, and a method to check that the installation is successful. 
1. Log in to your system as a user with sudo privileges. 
2. Update your system by typing the following command. 
```command
sudo yum update -y
```
3. Run the Docker installation script by typing the following command.

```command
 curl -fsSL https://get.docker.com | sh
 sudo yum install docker
```
4. Start Docker by typing the following command.
```command
 sudo service docker start
```
 5. Clone this [Git Repository](https://github.com/saritanus/fibonacci.git)
* Execute the following code to get the artifact fibonacci.war

```command
 ./gradle clean bootwar
```
6. Build the docker image

```command
 docker build --rm -t fibonacci:LATEST -f docker/Dockerfile .

```
7. Execute the following commands to verify and deploy on docker

```command
docker images

docker swarm init --advertise-addr <IP address of the server> 
 
docker stack deploy -c docker/compose/docker-compose.yml fibonacci

docker service ls

```
8. Check that you can access the REST API. The script creates the URL to access  For example: https:// <hostname>:8000/fibonacci/
	
# 3. Accessing REST API on cloud

[FIBONACCI REST API](http://140.238.194.53:8000/fibonacci/fibonacci)


