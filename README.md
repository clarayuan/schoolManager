
Main Demo Points
1. spring jpa data auditing

2. spring mvc rest

3. spring boot

4. h2 db

5. camel routing


Admin Instructions
1. Build the project and run using mvn spring-boot:run command. (with mvn clean install -DskipTests)

2. Open a browser and type http://localhost:8080/console to access h2 database.

3. add a student by:
`$ curl -H "Content-Type: application/json" -X POST -d '{"name":"Li Zhao","country":"Japan"}' http://localhost:8080/api/students`

4. get students:
`$ curl http://localhost:8080/api/students`

todos
1. add more robust restful apis:
https://spring.io/guides/tutorials/bookmarks/
