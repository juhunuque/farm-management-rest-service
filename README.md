# Farm: Rest Service

## Running the application locally

### Inventory
- Rest api application (Spring Boot)
- Relational database (Mysql)

### Pre-requisites
- Docker
- Docker-compose
- Java 7 >
- Maven 3.5.2 >
- Internet connection for building process of docker.

### Installation

Firstable we need to prepare all binaries needed for the application, go to the app folder in terminal and run:
```sh
mvn clean install
```

Wait until it ends the building stage. Then we can continue by executing the following:

```sh
docker-compose up --force-recreate -d
```

Take into consideration we're running the stack in detach mode, if you want to check the logs you can go and remove the "-d" parameter, or fetch the stack logs.

Wait until docker downloads and builds all the images and, that's it, the application and database should be running now.

### Use

The application is exposed to the port 8080 and the database to the default mysql port 3306, please make sure those are free to be used.
Please refer to the endpoints below to start with the application.

### Stopping

If you want to stop the running stack, go to the folder app in terminal and run:
```sh
docker-compose down
```

Remember. If you want the database destroyed, please remove the volume mounted.
### Running tests
Because I know the tests are really important, included you'll find tests of the most important features. In order to run the tests, go to the folder app in terminal and run:
```sh
mvn test
```


### Troubleshooting

In case you want to execute the spring boot application in standalone mode, you have to change the application.properties file, datasource.url, change it to look up at localhost.

## Endpoints

### /user/v1

* GET /

* GET /{id}

* POST /
```json
{
	"name": "YourName",
	"specialisation": "Specialisation1"
}
```
Note: At this point, Specialisation must match with what is defined within SpecialisationCategory class.

* DELETE /{id}

### /field/v1
* GET /

* GET /{id}

* POST /
```json
{
	"name": "NameHere",
	"cropType": "CropTypeCategory1",
	"latitude": "41.40338",
	"longitude": "2.17403"
}
```
Note: At this point, CropType must match with what is defined within CropTypeCategory class.

* POST /find
```json
{
	"fieldName": "",
	"fieldCropType": "",
	"fieldLatitude": "41.403171",
	"fieldLongitude": "2.173676",
	"userName": "",
	"userSpecialization": "",
	"fcCloudinessInformation": "",
	"fcTemperature": "",
	"fcVegetationInformation": "",
	"fcDateFrom": "2019-05-01",
	"fcDateTo": "2019-05-02"
}
```
Notes: 
- Please use the remaining values as reference. 
-The calculation of the nearest point from the coordinates is not perfect,
uses a technique named Harvesine Formula, and to be near from, should be within a 5 km range.
- If a parameter is not set, not matters, it won't be taken in count.
- Blank value is taken as not present.
- To find by coordinates, you must include both latitude and longitude.
- To find by dates, you must include both dates from and to.

* DELETE /{id}

### /fieldUser/v1

* POST /
```json
{
	"fieldId": 1,
	"userId": 2
}
```
Note: Field and User objects must be existing prior to relation them.

* DELETE /{id}

### /fieldCondition/v1

* GET /

* GET /{id}

* POST /
```json
{
	"temperature": 10,
	"cloudinessInformation": "Dummy",
	"vegetationInformation": 30
}
```
* DELETE /{id}

### /fieldConditionField/v1

* POST /
```json
{
	"fieldId": 1,
	"fieldConditionId": 5
}
```
Note: Field and FieldCondition objects must be existing prior to relation them.

* DELETE /{id}