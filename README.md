# Quartz with spring application

## How to run the application
1. mvn clean install
2. docker-compose up

This will spin up two containers in same network , on one container dynamodb will be running and application will run on the other one

## POC
This application will create a job which will trigger every 5 secs to check the expiry of token present in database. 

## Notes
https://www.notion.so/Scheduler-a33c6ce0f7504ee789f0d62075da1713
