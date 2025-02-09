const express = require("express");
const app = express()
let port = 3000;

// app.get('/',(req,res)=>{
//     console.log(req.originalUrl);
//     res.send("<p>HELLO</p>")
// })

app.get('/',(req,res)=>{
    res.send(["helo",23])
})
app.get('/:name',(req,res)=>{
    res.send(`<p>Your name is ${req.params.name}</p>`)
})
app.get('/:name/:id',(req,res)=>{
    res.send(`<p>Your name is ${req.params.name} ${req.params.id} i am next</p>`)
})


app.listen(port,()=>{
    console.log(`listening on port ${port}`);
    
})