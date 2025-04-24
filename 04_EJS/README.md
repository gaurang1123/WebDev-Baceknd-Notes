# EJS (EMBEDDED JAVASCRIPT TEMPLATE)

## EJS and Setting ejs as view engine and setting path.
It is a templating engine based on javascript.
To use ejs wee need to first require Ejs ans set express view engine to ejs.
we must set path for views dir using path module.
i.e
```sh
const express = require("express")
const app = express()
const path = require("path")

app.set("view engine", "ejs")
app.set("views" , path.join(__dirname,"/views")) 

app.get("/",(req,res)=>{
    res.render("home.ejs")
})

const port = 3000
app.listen(port)
```

It sets express view engine to ejs.
we are rendering home.ejs file from views directory. (express by default finds ejs files from views directory).
rendering means sending files as output.
Ejs will find views dir from where server is started so we need path module to set views dir path to where index.js is stored.


## EJS INTERPOLATION SYNTAX
Ejs allows use to use it syntax in our views to perform operations directly in our .ejs files.
It is similar to javascript string interpolation.
we have different tags for this. One is 
<%= %> this tag outputs value into .html/.ejs
i.e
```sh
# JS:- 
let name = gaurang;
let srt = "Hello i am ${name}"

# EJS Interpolation
<body>
    <p>This is my about page 1+2</p>
    <h1>Sum is <%= 1+2 %> </h1>
</body>

# output
This is my about page 1+2
Sum is 3
```
## Passing data to EJS
We can also pass data to ejs template. data might be from database or direct.
we can send data as object to our views
i.e
```sh
# index.js
app.get("/",(req,res)=>{
    let randomval = Math.ceil(Math.random()*6)
    res.render("home.ejs",{val:randomval})
})

# home.ejs
    <h1>Num is <%=val %></h1>
```
It will generate random number and send to home.esp

## Using Conditional statements of js in .ejs
We can use javascript in ejs using scriptlet tag (<% %>)
we can only write javascript in scriptlet tags not html.

IF STATEMENTS
i.e
```sh
# index.js
app.get("/",(req,res)=>{
    let randomval = Math.ceil(Math.random()*6)
    res.render("home.ejs",{val:randomval})
    # or
    # res.render("home.ejs",{randomval})  //Access randomval directly

})

# home.ejs
    <h1>Sum is <%= val %></h1>
    <% if(val == 6){ %>
        <h2>Nice you got 6</h2>
    <% } %>
```
this will give us h2 only when val == 6. we need to write "}" inside another scriptlet tag as we cannot write html tag in it.

For Loops
i.e
```sh 
# index.js
app.get("/",(req,res)=>{
    let data = ["apple","grapes","orange"]
    res.render("home.ejs",{data})
})

# home.ejs
   <h1>For loop</h1>
    <ul>
    <% for(name of data){ %> 
        <li><%= name %></li> # Access as variable
    <% } %>
    </ul>
```
Using for loop we can access elements of array and  print each element.

## Accessing large data (.json) file in ejs
we can access data from .json file using require()
i.e
let data = require("./data.json")

variable data will store json as js object which we can access and pass to ejs files.

Then we can send this data to ejs using render
i.e
res.render("home.ejs",{data:data})

to access data for a specific user name we can use parameters and req.params to get specific data and use loop in ejs file
i.e
```sh
# index.js
app.get("/:username",(req,res)=>{
    let {username} = req.params
    let file = require("./data.json") 
    let data = file[username]  
    if(data){               #check if data is there 
        res.render("home.ejs",{data}) # we must use key/value to use value/index with value. i.e data:data[username] 
    } 
    else{
        res.render("nodata.ejs")
    }
}) 

# home.ejs
    <h1>Welcome to instagram </h1>
    <% for(let post of data.posts){ %>
        <img src="<%- post.image %>"%>
        <p><%= post.likes %>
        <%= post.comments %></p>
    <% }%>
```


## Including sub templates to templates
we can use a sub template in our template for repeated code 
i.e headers and footers

we can do that by using include() inside an ejs tag <%- %>
i.e
```sh
<%- include("header.ejs") %>
```

i.e
```sh
#header.ejs
<nav style="background-color: aqua;">
    <div style="display: flex;justify-content: space-between;padding-inline: 10px;;" class="navbar">
        <div class="left">
            <h3>LOGO</h3>
        </div>
        <div style="display: flex;gap: 20px;" class="right">
            <p>Link1</p>
            <p>Link2</p>
            <p>Link3</p>
        </div>
    </div>
</nav>

# index.js
app.get("/",(req,res)=>{  
    res.render("home.ejs")
})

# home.ejs
<%-include("header.ejs") %>
<h1>Welcome to my website!</h1>

```

this will add a nav bar in home.ejs which can be use with other templates too.

we can also add all our sub templates in a folder and keep it inside views folder only.

```sh
<%- include("folder/header.ejs")%>
```

