# Microservice


## Structure
1. customer-microservice
2. product-microservice
3. order-microservice

## Flow
- Custumer have records + they will have audit data even the data is deleted
- product have a list of products & their attributes
- A customer can have N orders, so we need to list all their orders

## DB
```
User
id  name    Role    isDeleted   deletedDataTime

Role - WebMaster/OrderProcessor/Customer
A User can have more than 1 role




Product


Order


```









