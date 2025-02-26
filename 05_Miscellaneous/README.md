# Miscellaneous Topics

##  GET & POST Request

we can use different methods to send request (for sending data to server) like GET, POST etc..

When we have to send parameters from input form we can send it using GET or POST request

### GET REQUEST
Get request is used to send data using query strings. But data is visible and limited query strings can be sent (according to browser). We can only send string data using it.

```sh
  <form method="get" action="/register">
        <input type="text" name="user" placeholder="Name">
        <input type="text" name="password" placeholder="Password">
        <button type="submit">Submit</button>
    </form>
```

when we click submit a request will be sent at route register

i.e:-  register?user=admin&password=admin

Now we can access this query strings in our express using 

req.query.user
req.query.password
i.e
```sh
# index.js
app.get("/register",(req,res)=>{
    let {user,password} = req.query
    res.send(`<p>GOT post request @ ${user}</p>`)
})

# form.html
<h2>GET REQUEST FORM</h2>
  <form method="get" action="http://localhost:3000/register/"> # we need to give full path
      <input type="text" name="user" placeholder="Name">
      <input type="text" name="password" placeholder="Password">
      <button type="submit">Submit</button>
  </form> 
```

### Post request
In GET request data is exposed in query string. So we can use POST request.
In POST request we send data using request body. and there is no limit and any kind of data can be sent. 

To access data from request body we need to use middle ware like express.urlencoded and express.json

req.body consist of url encoded payload/data which express cannot read from req.body directly so we need to first use express.urlencoded to parse ot to js object.

```sh
# index.js
app.use(express.urlencoded({extended:true}));

app.post("/register",(req,res)=>{
    let {user,password} = req.body
    res.send(`<p>GOT post request @ ${user}</p>`)
})

#form.html
<h2>POST REQUEST FORM</h2>
  <form method="post" action="http://localhost:3000/register">
      <input type="text" name="user" placeholder="Name">
      <input type="text" name="password" placeholder="Password">
      <button type="submit">Submit</button>
  </form>
```

express.urlencoder converts req.body data into readable format.

when client sends a json payload we can parse it using express.json
i.e
```sh
#index.js
app.use(express.json());

# payload from client to https://localhost:3000
{
  "user":"admin"
  "password":"admin"
}
```