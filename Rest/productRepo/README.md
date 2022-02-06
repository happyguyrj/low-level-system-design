## Product Repo REST API Service

### Usage
#### GET
To get all products
```
http://localhost:8080/products
```

#### POST
To create a product
```
http://localhost:8080/products

payload
{
"id": "1"
"name": "Rahul Jain"
}
```

#### PUT
To update a resource
```
http://localhost:8080/products/3

payload
{
"name": "Rahul Jain"
}
```

#### DELETE
To delete a product
```
http://localhost:8080/products/3
```


