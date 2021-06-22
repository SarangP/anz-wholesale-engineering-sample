# anz-wholesale-engineering-sample
This REST API returns account and account transactions for a wholesale system. 

Assumptions and Constraints

1. Runs on Java 8 +, make sure to have JDK8 and maven installed on the machine <br>
2. Maven is installed<br>
3. The application uses H2 in-memory database. So, for every server restart, there will be no records in the database <br>
4. Windows/mac version docker must be installed to run the image, if not, the project can be run by traditional build deploy approach<br>

There are currently 3 API's exposed as below.

GET http://localhost:8080/accounts <br>
GET http://localhost:8080/account/{id}} <br>
GET http://localhost:8080/account/{id}}/transactions <br>

Running the Application<br>

1. Docker<br><br>

    A. The docker image for this application is built and shared at https://hub.docker.com/repository/docker/sarangpatrikar/anz-wholesale<br>
    B. Download the image and run  the command<br>
    docker run -p 8080:8080 anz-wholesale or docker run -p 8080:8080 \<image name\> <br>
    <br><br>

2. Build and Run

    To run the app, please follow the steps below.
    
    1. Open the terminal on the folder location you want to run the app <br>
    2. run -> git clone https://github.com/SarangP/anz-wholesale-engineering-sample.git <br>
    3. cd anz-wholesale-engineering-sample <br>
    4. mvn clean install <br>
    5. cd target/ <br>
    6. Run java -jar anz-wholesale-1.0.jar <br>
    

After completing either Docker or "Build and Run" step, spring boot would start up. Make sure the port 8080 is not used while starting up.

To run the project, you can either choose to setup a postman project and have the above api's run in it or use curl command to run the api's

Sample Output for api GET http://localhost:8080/account/1234567890 : <br>


{"accountNumber":1234567890,"accountName":"SGSaving723","accountType":"Savings","currency":"SGD","balanceDate":"2020-03-10","balance":1233.33,"transactions":[{"transactionId":29,"valueDate":"2020-03-10","creditAmount":0.00,"debitAmount":11.10,"debitOrCredit":"Debit","transactionNarrative":"expense"},{"transactionId":30,"valueDate":"2020-03-10","creditAmount":0.00,"debitAmount":81.10,"debitOrCredit":"Debit","transactionNarrative":"expense"},{"transactionId":28,"valueDate":"2020-03-10","creditAmount":0.00,"debitAmount":124.10,"debitOrCredit":"Debit","transactionNarrative":"expense"},{"transactionId":27,"valueDate":"2020-03-10","creditAmount":0.00,"debitAmount":1222.10,"debitOrCredit":"Debit","transactionNarrative":"expense"}]}