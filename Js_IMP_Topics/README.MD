### Array Methods
1. Mutate value original array
2. Create/Retuns new array
3. Search & Query methods
4. Combining/Reduction methods
5. Helper methods

**Mutate value original array**
1. push("item):- add item to array's last index.
2. pop():- remove last item and return it.
3. shift("removeFirst"):- remove first item.
4. unshift("addFirst):- add item to first index.
5. splice(startIdx, deleteIdx, ItemtoAdd):- Adds/removes items at an index	
i.e
* *Remove Items*
const fruits = ['🍎', '🍌', '🍊', '🍇'];
fruits.splice(1, 2); // Removes '🍌' and '🍊'

console.log(fruits); // ['🍎', '🍇']

* *Add Item without removing*
const fruits = ['🍎', '🍌', '🍊'];
fruits.splice(2, 0, '🥝'); // Inserts '🥝' at index 2

console.log(fruits); // ['🍎', '🍌', '🥝', '🍊']

* *Add and Remove Item*
const fruits = ['🍎', '🍌', '🍊'];
fruits.splice(1, 1, '🍍', '🍓'); // Removes 1 item at index 1, adds 2 new items

console.log(fruits); // ['🍎', '🍍', '🍓', '🍊']


6. sort():- sort the array
7. reverse():- reverse array

**Create/Retuns new array**
1. map(callback()):- creates an array by doing some operation on each item
2. filter(callback()):- creates array returning item matching a condition
3. slice(startIdx, lastIdx):- return new array by extracts a portion of array 
4. concat([arrayToAdd]):- return merged arrays
5. flat(levelOfDepth):- flatten array 1 level deep by default
i.e
const nested = [1, [2, 3], [4, [5]]];

const flat1 = nested.flat(); // Default depth=1
console.log(flat1); // [1, 2, 3, 4, [5]] (only 1 level flattened)

const flat2 = nested.flat(2); // Depth=2
console.log(flat2); // [1, 2, 3, 4, 5] (fully flattened)

6. flatmap():- map()+flat() only 1 level deep
i.e
const arr2 = ["it's sunny", "it's rainy"]; 
const words = arr2.flatMap(sentence => sentence.split(" "));  //MAP FIRST THAN FLAT
console.log(words); // Output: ["it's", "sunny", "it's", "rainy"] 

**Search & Query methods**
1. find(callback()):- retuns first item matching condition.
2. findIndex(callback()):- retuns index of item which matches condtion
3. includes("item"):- check if item exist
4. indexOf("item"):- returns the first index of item if is present
5. some(callback()):- check if any item passes a condition and return boolean
6. every(callback):- check if every item passes a condition and return boolean

**Combining/Reduction methods**
1. reduce(callback()):- reduce array to single element by performing operation to all
2. reduceRight(callback()):- reduce from right
3. join("Seperator"):- convert whole array into string and add a seperator passed as argument

**Helper methods**
1. forEach(callback()):- loop through each item don't retun
2. Array.isArray(array):- if is array return true/false
3. Array.from(Iterables):- cretas a new array from iterable items. i.e string, array, set, nodelist, {}

### String Methods
1. Extract / slice 
2. search & check
3. transform string
4. convert to array

**Extract / slice**
1. slice(startIdx, endIdx):- Gets substring (end not included).
i.e 
"hello".slice(1,3) → "el"
"hello".slice(-3, -1) → "ll"
"hello".slice(2) → "llo"

2. substring(startIdx, endIdx):- similar to slice don't include negative index.
i.e 
"hello".substring(-3, 4); → "hell" //(treats -3 as 0)

**search & check**
.inlcudes(text):- return true if exist.
i.e "hello".includes("ell") → true

.indexOf(text):- return index of text (first occurance) if exist.
i.e "hello".indexOf("l") → 2

.startsWith(text):- return true if begins with text.
i.e "hello".startsWith("he") → true

.endsWith(text):- return true if ends with text.
i.e "hello".endsWith("lo") → true

**transform**
.toUpperCase():- convert string into upper case.
.toLowerCase():- convert string into lower case.

.trim():- remove spaces from start and end.

.replace(old, new):- replaces the oldWord to newWord in string.
i.e   "hi".replace("i", "ello") → "hello"

.repeate():- repeate a string 
i.e  "ha".repeat(3) → "hahaha"

**convert to array**
.split:- convert string into array.
i.e  "a,b,c".split(",") → ["a","b","c"]

#### IMP STRING TIPS
Need to extract? → .slice()
Searching? → .includes() or .indexOf()
Cleaning text? → .trim() + .toLowerCase()
Breaking data? → .split()

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
