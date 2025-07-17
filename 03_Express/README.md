# EXPRESS JS

It is used to create web server using nodejs.

## Creating an Express app

To create express app we need to first require express and create app using
```sh
const express = require("express");

const app = express();
```

This will create an express app.


## Listening to request

We can listen to all incoming request on specific port using listen method.
i.e
```sh
const port = 3000 <specify port >
app.listen(port)
```
we can also do some task when getting incoming request on specific port like,

i.e
```sh
app.listen(3000,()=>{
    console.log("listening to port 3000") 
})

app.listen(8080,()=>{
    console.log("listening to port 8080") 
})
```

## Sending Response

We can use use() to send response to all routes (use() is middleware but we can also send response using it).
```sh
app.use((req,res)=>{
    res.send("Hello");
})
```
```sh
app.use((req,res)=>{
    res.send(["hello",12]);
})
```

when any other format data is send express will convert it into json and send it.
#### While using use() request sent to any route will give some response even if route don't exist.

## Response Methods
1. res.send() :- Sends a response of various types (string, object, buffer, etc.)
2. res.json() :- Sends a JSON response ({object}) auto convert to application/json
3. res.status() :- Sets the HTTP status code
4. res.sendStatus() :- Sets the status and sends the status code as a response body
5. res.end() :- Ends the response without any data
6. res.redirect() :- Redirects the request to a different URL ("/user"), ("https://google.com")
7. res.download() :- Prompts a file download on the client side
8. res.set() or res.header() :- Sets response headers
9. res.cookie() :- Sets a cookie
10. res.clearCookie() :- Clears a cookie

## Routing request

Using express we can use routing to send specific response to specific request
for this we can use post() or get().
i.e
```sh
app.get('/',(req,res)=>{
    res.send("home");
})
app.get('/about',(req,res)=>{
    res.send("about");
})
app.get('*',(req,res)=>{
    res.send("this page do not exist");
})
```

We can specify on response for one route with same method like get. But we can send different response using post if request is made using post()
ie.
```sh
app.get('/',(req,res)=>{
    res.send('get request: home')
    })

app.post('/',(req,res)=>{
    res.send('post request: home')
})
```    
We can use * to set response for all other route which are not defined.

## Route Parameters
This are dynamic placeholder which are used to pass values directly into url.
In express route parameters are set using (:) sign before parameter name. which are accessible using req object's res.params.placeholder 

### Single route
i.e :- :id
```sh
app.get('/user/:id',(req,res)=>{
    res.send(`id = ${req.params.id}`);
});
```

### Multiple parameter route
```sh
app.get('/:user/:id',(req,res)=>{
    res.send(`user = ${req.params.user}, id = ${req.params.id}`)
});
```

### optional route parameter
this are parameters which are optional
```sh
app.get('/:user/:id/:order?',(req,res)=>{
    if(req.params.order){
    res.send(`user = ${req.params.user}, id = ${req.params.id}, optional = ${req.params.order}`)}
    else{
    res.send(`user = ${req.params.user}, id = ${req.params.id}`)}
    }
);
```

## Query Strings
These are key value pairs send after ? with route.
i.e /search?query=google
route = /search
key/value = query/google

key/value are used after ?

key/value are stored in object req.query so. We can access value using req.query.keyword

```sh
app.get('/search',(req,res)=>{
    let keyword = req.query.keyword;
    res.send(`you searched for ${keyword}`);
})
```
url ex:- localhost:3000/search?q=google


### Multiple Query String
In multiple query we must give same name for key to get value of query.
we can send multiple query string for single route using **(&)** between queries.
```sh
app.get('/search',(req,res)=>{
    let category = req.query.category;
    let price = req.query.price;

    res.send(`you searched for ${category} of this ${price}`);
})
```
