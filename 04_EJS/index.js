const express = require("express")
const app = express()

const path = require("path")

const port = 3000

app.set("view engine", "ejs")
app.set("views" , path.join(__dirname,"/views"))

app.get("/ig/:username",(req,res)=>{
    let {username} = req.params
    let file = require("./data.json")
    let data = file[username]
    if(data){
        res.render("home.ejs",{data})
    } 
    else{
        res.render("nodata.ejs")
    }
})

app.get("/head",(req,res)=>{  
    res.render("header.ejs")
})

app.get("/about",(req,res)=>{  
    res.render("about.ejs")
})

app.listen(port,()=>{
    console.log(`listening to port ${port}`);
    
})
