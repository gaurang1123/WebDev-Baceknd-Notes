### this in functions
#### this in normal function 
Normal function has there own but it only refers to this of from where function is being called.
i.e if function is called from another function in global space it will refer to global object(window).
i.e
function outer() {
  function inner() {
    console.log(this); // Different "this" depending on how inner is called
  }
  inner(); // Here, `this` is global/window
}
outer();

In above if inner is called from obj it will  have this of object. like below example in (2)

and
If function is called from object, which always has there own this function will also have this of object.

function inner() {
    console.log(this.name); // Different "this" depending on how inner is called
}
const obj = {
    name:"g",
    fun: inner,
}
obj.fun() // will have this of object 

#### this in arrow function
Arrow functions are different from normal functions.
In arrow function this is inherited from where arrow function is defined (defined not executed).
i.e
const inner=()=> {
    console.log(this); // this will always refer to window as it is defined in global space
}
const obj = {
    name:"g",
    fun: inner,
}
obj.fun() // will have this of global (window) 


### Promises 
#### Promise
A promise is a object made using constructor of Promise class constructor which repesents completion of a asyncronus task as either fullfilled, rejected or pending.
i.e
new Promise(callback)

#### Promise Resovle and Reject
when creating a promise using constructor we pass a callback function called executor function.
i.e
new Promise((res,req)=>{}) // (res,req)=>{} is executor function.

Inside the Executor function we define our task (mostly async) with resolve and reject functions.
We need to check if the data or condition is fullfilef by ASYNC TASK or not and then accordingly set resolve and reject.
i.e
new Promise((res,rej)=>{
    ASYNC TASK
    if(AYSNC_TASK_DATA){
    res();
    }
    else{
    rej();
    }
})

i.e
new Promise((resolve,reject)=>{
    const status = true;
    if(status=="true"){
        resolve("data is true")
    }
    else{
        reject("data is false)
    }
})

#### Handling Resolve and Reject
Once our Async Task is completed it will give some result which we check to decide either to execute resolve or reject.
If we want to do some other task after getting data or after getting error we can use promise chaining.

##### Promise chaining from resolve .then()
After compeleting task and fullfilled promise, if we want resolve to do more operation on data we can use .then() 
It takes a callback which is executed if the promise is resolved.
Argument passed in .resolve is passed/received by  .then and can br used in callback.
i.e
new Promise((resolve,reject)=>{
    const status = true;
    data= "this is imp data";
    if(status=="true"){
        resolve(data)
    }
    else{
        reject("data is false)
    }
})
.then((data)=>{console.log(data.toUpperCase())});

we can add more than one .then, the returned data from old .then can be used by new .then as argument.
i.e

.then((data)=>{ return data.toUpperCase() }) // (argument) Data was passed from resolve.
.then((data)=>{ console.log(data)})  // (argument) Data was passed from above/old .then().

##### Promise chaining from reject .catch()
when the ASYNC_TASK is not able to fullfiil and state becomes rejected we can use .catch() to handle the rejection further.
like we can show user a custom error message. similar to how returned data by resolve is accesible to first .then(), .catch() access data passed by reject.  
i.e
new Promise((resolve,reject)=>{
    const status = true;
    data= "this is imp data";
    if(status=="true"){
        resolve(data)
    }
    else{
        reject("data is false)
    }
})
.then() /// IF ANY
.catch((error)=>{console.log("This is the error you got", error)})

#### Getting Promise data into variable
we cannot retuen our data directly to a variable but it returns a promise so we can use .then() using the variable.
If we want to set data into variable we can create a global variable and set data into it in .then() from promise directly, but it will not be assigned until promise is fullfilled.

### Async and Await

async makes a function return a Promise
await makes a function wait for a Promise



### Fetch  API
Fetch Api is used to fetch url or file.

#### Request with fetch Api
To send a request with fecth api we can do

```javascript
url = "www.google.com"
fetch(url)
```

#### Handling Fetch Api response

We can use .then,.catch and .finally to handle fetch api response.

after making a request using fet
