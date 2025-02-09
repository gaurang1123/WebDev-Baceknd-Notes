const express = require("express")
const app = express()

const path = require("path")

const port = 3000

app.set("view engine", "ejs")
app.set("views" , path.join(__dirname,"/views"))

app.get("/",(req,res)=>{
    let randomval = Math.ceil(Math.random()*6)
    res.render("home.ejs",{val:randomval})
})

app.get("/about",(req,res)=>{  
    res.render("about.ejs")
})

app.listen(port,()=>{
    console.log(`listening to port ${port}`);
    
})
