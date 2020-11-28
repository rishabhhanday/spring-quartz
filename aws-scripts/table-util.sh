aws dynamodb create-table --table-name Token --attribute-definitions  AttributeName=id,AttributeType=S --key-schema AttributeName=id,KeyType=HASH --provisioned-throughput ReadCapacityUnits=10,WriteCapacityUnits=5 --endpoint-url http://localhost:8000


aws dynamodb put-item --table-name Token --item file://item.json --endpoint-url http://localhost:8000


aws dynamodb list-tables --endpoint-url http://localhost:8000