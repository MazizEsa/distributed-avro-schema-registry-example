# Instruction
You need to set up your confluent stack (schema registry, kafka, etc.) and run it before running the following.

1. Compile the producer module
2. Then compile the consumer module
3. Run Producer
4. Run Consumer.

# Trigger the message via REST

To trigger the message you can use the following:

## Trigger Flat Schema Message

```curl --location --request POST 'localhost:8080/trigger-flat'```

## Trigger Split Schema Message

``curl --location --request POST 'localhost:8080/trigger-splitted'``
