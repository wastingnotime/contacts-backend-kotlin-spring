# contacts-backend-kotlin-spring

**contacts-backend-kotlin-spring** is part of "contacts" project that is an initiative where we try to explore frontend and backend implementations in order to better understand it cutting-edge features. This repository presents a kotlin rest API sample.

## stack
* openjdk 21
* kotlin
* spring
* sqlite

## features
* migrations


## get started (linux only)

### option 1 - use latest docker image from dockerhub

execute the remote docker image
```
docker run -p 8010:8010 wastingnotime/contacts-backend-kotlin-spring
```

### option 2 - build and run a local docker image
build a local docker image
```
docker build --tag contacts-backend-kotlin-spring .
```

execute the local docker image
```
docker run -p 8010:8010 contacts-backend-kotlin-spring
```
### option 3 - execute from source code 

- first, install openjdk 17 (* instructions - to be defined)
- go to root of solution and execute the commands below

ensure build generated files clean up
```
 mvn clean
```

build and create package
```
 mvn package
```

and then run the application
```
java -jar target/contacts-backend-kotlin-spring-0.0.1-SNAPSHOT.jar
```

## testing
create a new contact
```
curl --request POST \
  --url http://localhost:8010/contacts \
  --header 'Content-Type: application/json' \
  --data '{
	"firstName": "Albert",
	"lastName": "Einstein",
	"phoneNumber": "2222-1111"
  }'
```

retrieve existing contacts
```
curl --request GET \
  --url http://localhost:8010/contacts
```
more examples and details about requests on (link) *to be defined


## knowledge base

### to upgrade maven wrapper
```bash
mvn -N wrapper:wrapper -Dmaven=3.9.11
```
