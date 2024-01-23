Working with the balance

Author: Kovalev Oleg 

Technologies used: Java, Maven, PostgreSQL, Spring Boot

Api works with the client's balance through controllers.
At this stage, it is possible to: 
1. Add or remove a client 
2. Request a client's balance 
3. TakeMoney or putMoney from the client's balance
4. If the client is not found, the requester receives a message:
   "user with this id was not found"

Additional information:
1. It is based on the condition that the customer uses a credit card 
and may have a negative balance
2. Dump DB located in the folder DB
3. API returns the response in the form of Json
