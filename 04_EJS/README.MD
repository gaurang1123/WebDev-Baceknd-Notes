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
    <h1>Sum is <%=1+2 %> </h1>
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

## Using js in .ejs
We can use javascript in ejs using scriptlet tag (<% %>)
we can only write javascript in scriptlet tags not html.
i.e
```sh
    <h1>Sum is <%= val %></h1>
    <% if(val == 6){ %>
        <h2>Nice you got 6</h2>
    <% } %>
```
this will give us h2 only when val == 6. we need to write "}" inside another scriptlet tag as we cannot write html tag in it.