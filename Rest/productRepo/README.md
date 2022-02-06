## Product Repo REST API Service

### Usage
#### GET
- To get all products
- The default HTTP request method is GET. 
- This method does not require any Request Body. 
- You can send request parameters and path variables to define the custom or dynamic URL.
```
http://localhost:8080/products
http://localhost:8080/products/1
```

#### POST
- To create a product
- The HTTP POST request is used to create a resource. 
- This method contains the Request Body. 
- We can send request parameters and path variables to define the custom or dynamic URL.
```
http://localhost:8080/products

payload
{
"id": "1"
"name": "Rahul Jain"
}
```

#### PUT
- To update a resource
- The HTTP PUT request is used to update the existing resource. 
- This method contains a Request Body. 
- We can send request parameters and path variables to define the custom or dynamic URL.
```
http://localhost:8080/products/3

payload
{
"name": "Rahul Jain"
}
```

#### DELETE
- To delete a product
- The HTTP Delete request is used to delete the existing resource. 
- This method does not contain any Request Body. 
- We can send request parameters and path variables to define the custom or dynamic URL.
```
http://localhost:8080/products/3
```


