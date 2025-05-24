# TOPICS COVERED

1. [Prerequisite & bundler with some config](#thinks-to-know-before)
2. [How react works behind](#Using-and-understanding-react-cdn-and-how-react-work-bts)
3. [Setting react locally](#setting-react-locally)
4. [Folder structure](#folder-structure)
5. [Basic Syntax](#Basic-syntax-of-jsx-and-App.jsx )
6. [Importing files](#importing-a-file)
   - [Named/Multiple exports](#multiple-export-or-named-export)
   - [Default exports](#single-OR-default-export)
   - [Exporting both single and default and Importing](#Exporting-both-single-and-default-and-Importing)
7. [Using javascript in jsx](#using-javascript-in-jsx)
8. [Structuring and reusing a react components](#structuring-and-reusing-a-react-components)
9. [React Fragment](#react-fragment)
10. [Styling React Components](#styling-react-components)
11. [Rendering listarray](#rendering-listarray)
12. [USING PROPS](#using-props)
13. [Conditional rendering](#conditional-rendering)
14. [One and two way data binding and event handing and input taking](#one-and-two-way-data-binding-namste-react-and-event-handing-and-input-taking)
15. [Usestatehooks in react](#usestatehooks-in-react)
    - [Updater function](#updater-function)
    - [Update object using useState](#update-object-using-usestate)
16. [Useeffect](#useeffect)
    - [Cleanup function of useSEffect](#cleanup-function-of-useeffect)
17. [Config driven ui](#config-driven-ui)
18. [React form handling](#react-form-handling)
    - [Controlled components](#controlled-components)
    - [Handling form in react](#handling-form-in-react)
19. [Handling form using react form hook](#handling-form-using-react-form-hook)
    - [Register](#register)
    - [Handlesubmit](#handlesubmit)
    - [Errors](#errors)
    - [Prevent multiple submission](#prevent-multiple-submission)
20. [React router dom](#react-router-dom)
    - [Creating routes](#creating-routes)
    - [Using routes](#using-routes)
    - [Using link and navlink](#using-link-and-navlink)
    - [Diff btw link vs navlink](#diff-btw-link-vs-navlink)
    - [Parameter routes and useparams](#parameter-routes-and-useparams)
    - [Useparams](#useparams)
    - [Nested routes and outlet](#nested-routes-and-outlet)
    - [Creating nested routes](#creating-nested-routes)
    - [Use nested component using outlet](#use-nested-component-using-outlet)
    - [Using usenavigate for navigation through button](#using-usenavigate-for-navigation-through-button)
    - [Error page handling 404](#error-page-handling-404)
    - [Usesearchparams](#usesearchparams)
    - [Navigate Component](#navigate-component)
21. [Lifting state up in component](#lifting-state-up)
22. [useContext hook api](#usecontext-hook-api)
23. [useRef](#useref)
    - [Refering local variable](#refering-local-variable)
    - [Passing initial value](#passing-initial-value)
    - [Refering dom element](#refering-dom-element)
24. [useMemo](#usememo)
    - [Memo](#memo)
    - [Using memo with usememo](#using-memo-with-usememo)
25. [useCallback](#usecallback)
26. [useReducer](#usereducer)
    - [Reducer](#reducer)
    - [Dispatch](#dispatch)
27. [Custom hook](#custom-hook)
28. [Error boundries](#error-boundries)
    - [Fallback](#fallback)
    - [Show specific error using fallbackrender](#show-specific-error-using-fallbackrender)
    - [Log error and error stack in console using onerror prop not in dispaly but in console](#log-error-and-error-stack-in-console-using-onerror-prop-not-in-dispaly-but-in-console)
    - [Provide reset button to reload page using resetboundary hook](#provide-reset-button-to-reload-page-using-resetboundary-hook)
29. [Portals in react](#portals-in-react)

# Thinks to know before
## Bundeler working
Bundlers like parcel help us to optimise our code and let us use our code in realtime using development server

Bundler converts our code into browser ready code.
Main work of bundler is to minify our code it means --> takes all our code i.e all js files and convert to one js file
i.e
App.js, Header.js, Nav.js, Footer.js ----> index_random.js
App.css, Header.css, Nav.css, Footer.css ----> random_style.css

It can also remove unused code/variables from our web code
Bundles all assets too like images and fonts etc...

## Browserlist
It is written in package.json, it helps dependency and bundlers like parcel, babel or postcss etc to know what browser we want to support.
i.e
```json
"browserslist": [
  ">0.5%",
  "last 2 versions",
  "not dead"
]
```
## Remove console.log automatically
babel can help you remove log automatically by using it plugin.
1. npm install --save-dev babel-plugin-transform-remove-console
2. Add plugin into package.json
i.e
  ```json
  "babel": {
    "plugins": ["transform-remove-console"]
  }
  ```


# REACT 
React is a js library used to create component based UI/font-end.

component are reuseable piece of code.. similar to a function.
This form a hierarchy inside which there are multiple components.
i.e Inside a video component we can have like btn, comment btn, thumbnail, description.
where each can be a individual component like like btn ...

## Using and understanding react cdn and how react work bts.
we can use react cdn links and use it in our index.html
It will give us access to React and ReactDOM object which react use to create and render (add into dom) element.

we can create a react html element using
```javascript
const heading =  React.createElemnet("h1",{id:"head1"},"content");
```
and we can create a root element using 
```javascript
const root = ReactDom.createRoot(document.getElementById("root"));
```
and then render our elemmnt into the root using
root.render(heading)

we can add multiple child element inside the html element by passing [] (array).
i.e

```javascript
const heading1 =  React.createElemnet("h1",{id:"head1"},"content");
const heading2 =  React.createElemnet("h1",{id:"head2"},"content");
const container =  React.createElemnet("div",{id:"container"},[heading1,heading2]);
root.render(container);
```

## Imp
Render will overwrite everything inside root.
React component are just objects.
when creating using createElement() we pass element type, props, children.
props will be any attribute to set.
children will be either a text content or another element.

## Creating own react server using parcel
Parcel is a bundling tools help use to bundel our application i.e 
build our app, create a local server to run, optimise our app using caching and other.  

we can create server in parcel
i.e
initalize using project using --> npm init
install parcel, react, react-dom --> npm i parcel react react-dom

create a index.html and index.js 
inside index.js import react and react-dom/client
create a root and element and render element in root
i.e
```javascript
import React from "react"
import ReactDOM from "react-dom/client"

const root = ReactDOM.createRoot(document.getElementById("root"));
const heading = React.createElement("h1",{},"Heading 1");
console.log(heading)
root.render(heading)
```

inside html add type="module" in script tag as index.js is a module file.
use parcel to deploy server with an entry point (index.html)
i.e --> npx parcel index.html

## conversion of react functional components -> React.createElement -> html(dom) 
using functional component we can return React.createElement type of code (converted by babel before returing) to our root.render().
before returning babel will convert our code into react.createElement type of code and send it further.
inside our component we can also call another component (as a function() call) or load it as component 
i.e
```javascript
const Title = ()=>(<div><h1>Functionnal head</h1></div>);
const vartitle = (<div><h1>Functional head</h1></div>);
const LoadTitle = ()=>(<div>Here title is loaded like {title} or <Title/></div>);
root.render(LoadTitle);
```

in above we called Title as a function() call and also as component both return js code (React.createElement) into the LoadTitle component and hence it is not required to convert them again at render as are already converted.
 
## Setting react locally

```javascript
npm create vite@latest
```
after running above command select react and javascript.

Then install node_modules from package.json using 
```javascript
npm install
```

To run react app 
```javascript
npm run dev
```

## Folder Structure

Important folder is src/ 
In which important files are
App.jsx
App.css
main.jsx
index.css

index.html (inside project folder)

There can be multiple components. But all these components are imported in App component.
from App.js it is imported to main.jsx and from main.jsx it is rendered into index.html

individual_component --> App.jsx --> main.jsx --> index.html

## Basic syntax of jsx and App.jsx 

Rules:
1. Returning a single root element 
2. Closing all Tags
3. Camelcase for most things
4. using className to give class to html tags

In return statement of component we need to have closing tag for an opening tag. we can use different syntax
i.e 
```javascript
<button> </button>  OR </button>
```

In return statement we can only return one individual tag or we can return multiple tag as children to a single div
i.e 
```javascript
return <div> <h1> hello </h1> <button> click </button> </div>
```

We can use () with return to write from next line as return statement will not recognize anything written from next line.
i.e 
```javascript
return (
    <div> 
    <h1> hello </h1> 
    <button> click </button> 
    </div>
    )
```

We can create component and use it inside our App.js like
i.e for Title inside App.jsx

```javascript
function Title(){
  return(
    <div>
      <h1>THIS IS TITLE</h1>
    </div>
  )
}
function Description(){
  return(
    <div>
      <h4>THIS IS Description</h4>
    </div>
  )
}

function App(){
  return(
    <div>
      <Title />
      <Description/>
      <Title />
      <Description/>
    </div>
  )
}
```
this code will render Title and Description in App.

## importing a file
To import a file we need to first export it using export keyword in the file

### multiple export OR named export

In react we can define multiple component in a single jsx file and export each component but then we have to import it using {}.
i.e
```javascript
# Components.jsx

export function Title(){
    return(
      <div>
        <h1>THIS IS TITLE</h1>
      </div>
    )
  }

export function Description(){
  return(
      <div>
        <h1>THIS IS Description</h1>
      </div>
    )
}

# App.jsx

import {Title} from "./Components"
import {Description} from "./Components"

```

### single OR default export
for Title component we can export it using 
```javascript
# Title.jsx

function Title(){
    return(
      <div>
        <h1>THIS IS TITLE</h1>
      </div>
    )
  }
export default Title
```

then we need to import it in App.jsx using

```javascript

# App.jsx

import Title from "./Title"
```

### Exporting both single and default and Importing

We can also have both single and default export in same file and can import it in App.
we have to use import for single component like {comp1, comp2} and default using only name.
i.e

```javascript
# Title
export function Description1(){
  return(
    <div>
      <h1>This is single export</h1>
    </div>
  )
}

export function Description2(){
  return(
    <div>
      <h1>This is single export 2</h1>
    </div>
  )
}


function Title(){
    return(
      <div>
        <h1>This is Default export</h1>
      </div>
    )
  }

export default Title

# App.jsx

import Title,{Description2, Description1} from "./Title"
              OR
import Title from "./Title"
import {Description1} from "./Title"
import {Description2} from "./Title"

```

## Using javascript in jsx

Any code written inside {} in jsx is treated as pure javascript
i.e
```javascript
function Title(){
    let name = "gaurang"
    return(
      <div>
        <p>2*2 = {2*2}</p>
        <h4 >My Name is {name}</h4>
        <h4>My Name is {name.toUpperCase()}</h4>
      </div>
    )
  }
```
this will evaluate 2*2 inside {} to give 4 and give name in uppercase.

## Structuring and reusing a react components

We must import repeating component into one component and then use that one to render in App.jsx
for a product with description and title we must made it one and then render it in App.jsx 
i.e product * 3 --> product tab --> App.jsx

```javascript
# Product.jsx

function Product(){
    return(
        <div>
            <h2>Title</h2>
            <h4>Description</h4>
        </div>
    )
}

export default Product

# ProductTab.jsx

import Product from "./product";

function ProductTab(){
    return(
        <div>
            <Product/>
            <Product/>
            <Product/>
        </div>
    )
}

export default ProductTab

# App.jsx

import "./App.css"
import ProductTab from "./ProductTab"

function App(){
  return(
    <ProductTab/>
  )
}

export default App
```

## React Fragment
In React we can not return multiple tag but we can return a parent tag with all child tag wrapped inside it.
But for this we need to create a extra div block which is not good. So we can use react fragment.
which is part of React module which should be imported first
i.e:-
```javascript
import React from "react";
function Product(props){
    return(
        <React.Fragment>
            <h2>{product_name}</h2>
            <h4>{product_Description}</h4>
        </React.Fragment
        )}
``` 
OR we can just use <> </> empty tags in latest version. 


## Styling React components

To style components we can either use same css file for multiple component. But we should create css file for each component.
i.e
App.jsx  --> App.css
Product.jsx  --> Product.css
ProductTab.js  --> ProductTab.css

we need to import css file 
i.e for Product.jsx
```javascript
import "./Product.css"
```
## Rendering List/Array

To render an array or list in react we mostly use map method to render array as list item
ie
```javascript
function App(){
  let fruits =  ["Apple","grape","banana"]
  return(
    fruits.map(item =>{return(
      <li>{item}</li>
    )})
  )
}
```
this will render all items as list.


## USING PROPS

In react/jsx to data can be sent across component in hierarchy (from parent to child).
we send data using attribute or key/value pair in calling child tag.
i.e To passing data to component product
```javascript
let item = {"id":1,"name":"gaurang"}
<Product key={item.id} name={item.name}/>
```

this data will be sent to Product component using prop object.
prop is an default object in which this values are appended 
for console.log(prop)
prop = {"key":1,"name":"gaurang"}

we can just use this prop to access values 
i.e:- prop.key or prop.name

Example of using prop
```javascript
# App.jsx
import Product  from "./Product.jsx"
function App(){
  let fruits = ["Apple","grape","banana"] 
  return(
    <>
    <ul>
    <Product data=fruits />
    </ul>
    </>
  )
}
export default App

# Product.jsx

function Product(prop){
  let fruits = prop.data #here data is array[] inside prop object.
  return(
    fruits.map(item =>{return(
    <li>{item}</li>
  )})
  )
}

# This code will print all fruits as list items
```

Example with parent child and grand child
```javascript
# App.jsx

import "./App.css"
import ProductTab from "./components/ProductTab"

function App(){
  let product_info = [{
    "id":1,
    "product_name":"Apple",
    "product_description":"Apple is in california",
  },
  { "id":2,
    "product_name":"Samsung",
    "product_description":"Samsung is in Korea",
  },]
  return(
    <ProductTab info={product_info} />
  )
}
export default App

# ProductTab.jsx

import Product from "./Product";
import "./ProductTab.css"
function ProductTab(props){
    let product_info = props.info
    return(
        <div className="product-tab" >
           {product_info.map((item) =>{
            return(
               <Product key={item.id} 
               item_name = {item.product_name} 
               desc={item.product_description} />
            )})}
        </div>
    )
}
export default ProductTab


#Product.jsx
import "./Product.css"
function Product({item_name,desc}){  #Using destructuring
    // let product_name = props.item_name;
    // let product_Description = props.desc;
    return(
        <div className="Product">
            <h2>{item_name}</h2>
            <h4>{desc}</h4>
        </div>
    )
}
export default Product  
```
### Understanding prop in more detail (Namste react)
we can pass prop as a variable like name = "gaurang", 
but if we have an object we can automatically spread it and we can use it directly.
i.e
```javascript
let obj={name:"gaurang",age:21}
<Restaurant {...obj}>
```

It will pass prop automatically like 
```javascript
<Restaurant name="gaurang" age={21}>
```

## Conditional Rendering
1. In react we can do conditional rendering anywhere in {} using && operator or ? : operator

2. In && any condition of left if is true then right side part will be executed/rendered
It returns first falsy value or a component
i.e
```javascript
const islogged = true
{islogged  && <Logout/>}
if islogged is is true it will return Logout.
// OR
const islogged = false
{islogged  && <Logout/>}
if islogged is is true it will return false (value of islogged).
```

3. using if else
we cannot directly use if else to render component in return statement because of {} (we need to write in it)
but we can use a function to write our condition in and call function in our retuns
i.e 
```javascript
const isLogged = false;
const renderOne = ()=>{
  if(!isLogged){
    return <Login/>
  }
  else{
    return <Logout/>
  }
}
```

this shows buttons to either logout or login according to isLogged status.

## One and Two way data binding (Namste react) and event handing and input taking
React only supports one way data binding which means we can only pass data/props from parent to child or (from var to input, and not from input to var). 
i.e
```javascript
let search = "value"
<input type="text"
    value={search}
    onChange={search=value}/> // this will not works as only search can provide data and onChange cannot change in it because of one way data binding.

const [searchtxt, setSeachTxt] = useState("")

<input type="text"
  value={searchtxt}
  onChange={(e)=>{setSeachTxt(e.target.value)}}/> // Here state variable set method allow us to do two way data binding.
<button>Search - {searchtxt}</button>
```


## useState()/Hooks in react

Hooks : Special function which allows functional components to use special react features.
i.e useState(), useEffect(), useContext(), useReducer(), useCallback() and more.....

useState() are used to create stateful variable which comes with a setter method.
when we need to change variable value we use set method for particular variable.
It helps to maintain state of variable throughout our file.
So when we change value of variable it will be changed/rendered everywhere.

To create a variable using useState() we create it 
i.e
```javascript
let [count,setCount] = useState();
```
useState returns array with a variable and a setter function we need to destructure it to use it.
We can set default value by passing argument to useState().
```javascript
let [count,setCount] = useState("0");  
```
Set count to 0 by default.

## Updater Function

It is a function passed as a argument to update state of variable 
When updating a count of variable we might call setCount() one or more time
i.e
```javascript
value of count = 0

function handler(){
  setCount(count + 1)
  setCount(count + 1)
} 
```
But it will result to value of count = 1
Because react will batch/combine all setCount method and run it where state of count always stays 0 until updated.
like:

```javascript
setCount(count + 1)   #setCount(0 + 1)
setCount(count + 1)   #setCount(0 + 1)
setCount(count + 1)   #setCount(0 + 1)
```
after last call count will be updated to 1

So we can use updater function / pass a function to update count value
i.e

```javascript
setCount((preValue) => preValue + 1)     #setCount(0 => 0 + 1)
setCount((preValue) => preValue + 1)     #setCount(1 => 1 + 1)
setCount((preValue) => preValue + 1)     #setCount(2 => 2 + 1)
```

updater function takes pending state to calculate next state.  # current state = 0, pending state = 0, 1 ,2 (each after function call)
react puts updater function into queue and execute all at next render.

It is good practice to use **updater function even for single update** 


## Update object using useState()

we can assign a object to variable
i.e
```javascript
let [car,setCar] = useState({year:2024,
                              brand:"Ford",
                              model:"mustang"})
```

how to change using setCar()

```javascript
    function change(e){
    setCar(prevCar => ({...prevCar,year : e.target.value}))
  }

    <p>Car is {car.year} {car.brand} {car.model}</p>
    <input type="number" value={car.year} onChange={change} />
```

Because we should not change in reference type i.e (array, object, etc..) i.e {...car,year:21} as it will not change the reference of the object hence react will not nbe able to know about change in object and will not reredner it.
so we should pass a new object i.e {...prevCar, year:21} 
or
{brand:"Ford", model:"mustang", year:32} defining all existing and changing year properties


## useEffect
when we want to run some code after a specific render we can use useEffect.
i.e
we can fetch data from api after our website is rendered.

there are different time when useEffect execute code
i.e
1. every time component re-renders
2. once after first render
3. when a specific state variable changes

1. when we want to execute code every time our component render we can create a useEffect with only one callback function to execute

i.e
```javascript
useEffect(()=>{
    console.log("executed at every time render")
    },);
```
2. when we want to execute some code only once when our component render for first time we can pass a callback executor and a empty array (dependency array) to useEffect().

i.e
```javascript
useEffect(()=>{
    console.log("executed at every time render")
    },[]); // will execute only once after first render
useEffect(()=>{
    console.log("executed at every time render")
    },[]); // will execute only once after first render
```

3. every time some state variable changes we can pass a array of state variables called dependency array. and callback executor.

i.e
```javascript
const [status, setStatus] = useStatus("offline");
useEffect(()=>{
    console.log("executed at every time render")
    },[status]); // will execute every time when variable changes.
``` 

### clean up function of useEffect
Clean up funciton of useEffect is used to execute function or code when our component is going to unmount or rerender.
It is used to clean up (subscription, Event Listners or timers)
i.e
```javascript
import React, { useEffect, useState } from "react";

function TimerComponent() {
  const [count, setCount] = useState(0);

  useEffect(() => {
    const timer = setInterval(() => {
      setCount(prev => prev + 1);
    }, 1000);

    // 🔄 Cleanup function
    return () => {
      clearInterval(timer); // Clean up the interval when component unmounts
      console.log("Timer cleared");
    };
  }, []); // Runs only once on mount

  return <h1>Timer: {count}</h1>;
}

export default TimerComponent;
```

This function starts a timer in the begnning and resets when component rerender


## Config driven Ui 
we can create a config driven ui by taing our data from outer source (api, Data base).
we can set our data to be empty format of array or obj ([],{}), and use a shrimmer UI (loading skeleton) until our data is not fetched.
we can fetch data using useEffect setData into state and re-render our component with our actual UI we need to use.
It involves conditonal rendering
i.e
ShrimmerUI.js (component)
```javascript
<>
<div className="res_list">
{array.map((_,index)=>{return(
    <div key={index} style={{  width: "300px",height:"150px", padding: "10px", backgroundColor:"gray" ,border: "2px solid black", display: "flex", flexDirection: "column", alignItems: "center",}} >
    <h2 style={{ backgroundColor:"gray" ,width: "80%"}} ></h2>
    <p style={{ backgroundColor:"gray" ,width: "80%"}}></p>
  </div>
    )
})}
</div>
</>
```

Restaurant.js (component)

```javascript
<>
<div className="item" >
  <img src={CDN_IMG_URL + card.card.info.cloudinaryImageId} alt=""/>
  <h2>{card.card.info.name}</h2>
  {/* <p>{card.card.info.veg.toString()}</p> */}
  <div className="details">
  <h3>Cuisines: {card.card.info.cuisines.join(", ")}</h3>
  <h3>Location: {card.card.info.locality}</h3>
  </div>
</div>
</> 
```

Body.js (component) where different ui is loaded

  ```javascript
  <>
    <div className="search_input">
    <input type="text"
    value={searchtxt}
    onChange={(e)=>{setSearchTxt(e.target.value)}}/>
    <button onClick={()=>{filter(searchtxt)}}>Search</button>
    </div>

    <div className="res_list">
    {filteredData.length === 0 ? <ShrimmerUi/> : filteredData.map((item)=>{
      return item.card.card.info ? <RestaurantCard key={item?.card?.card?.info?.id} {...item} filtertext={searchtxt} /> : null;
    })}
    </div>
  </>
  ```

## React Form Handing
We can create a form and handle the inputs using state and setState functions.

### Controlled components
Any component which is handled by react to set there value at change of input using state change it is called controlled component.
component which uses 
1. state
2. onChange function (Event Handling)
3. setState to change state 

### Handling Form in react
1. write html and add value and onChange.
2. create a state to handle value and set value of html to state.
3. handle state using a function invoked on onChange and use event to get value of element.

IMP --> Dont use single function for different onChange as it will manipulate others value to.

i.e
```javascript
const [name,setName] = useState("");
const [selectValue,setSelectVlaue] = useState("");
const [textArea,setTextValue] = useState("");
const [data,setData] = useState({});

function handleNameChange(e){
  setName(e.target.value);
}
function handleSelectChange(e){
  setSelectVlaue(e.target.value);
}
function handleTextChange(e){
  setTextValue(e.target.value);
}

function onSubmit(){
  const data={
    name,
    selectValue,
    textArea
  }
  setData(data)
}


<form onSubmit={onFormSubmit}>
<input 
type="text"
value={name}
onChange={handleNameChange}/>

<select value={selectValue} onChange={handleSelectChange}>
<option value="react">React</option>
<option value="vue">Vue</option>
</select>

<textarea value={textArea} onChange={handleTextChange} rows="3"></textarea>
</form>
```


### Handling form using react-form-hook
Using react-hook-form we can create form and use functionality like validation, error checks, isSubmitting, print error message.

we need to install react-hook-form
i.e --> npm install react-hook-form

we need to import useFrom from react-hook-form and get important methods from it using destructuring 
i.e
```javascript
import {useForm} from "react-hook-form"

const {register,handleSubmit,formState:{error, isSubmitting}} = useForm();
```

now we can use them in our form.

#### register:- 
It is use to register our form elements (input, select...) so that react-hook-form can track changes in it.
in this we pass a name and fields which help us to set constraints on our input.
i.e register(name,fields);
we need to spread our register() in input.
i.e 
```javascript
<input {...register(
  "firstname",
  {
    required:true,

    minlength:{value:6,
    message:"not working" }, 
    
    pattern:{value:/^[A-Za-z]+$/i, 
    message:"pattern not found"}
    }
    )} />
```
#### handleSubmit:- 
we can handle Submit and data using our handleSubmit(), we can pass our submit function and it gives us our data as object argument.
so we can handle data like.

i.e
```javascript
function submit(data){
  console.log(data);
  console.log("name:", data.name);
}
<form onSubmit={handleSubmit(submit)} >
<input type="submit">
</form>

```
#### errors:- 
we can show  our errors in field using errors object which provided by react-hook-form and provide object and name of input used to registed it which has message and type of error.
i.e 
if our input which is registered as name has minlenght:6 and message:"not working"
```javascript
errors{
  name:{
    type:minlength,
    message:"not working"
  },
  textarea:{
    type:minlength,
    message:"text not working"
  }
}  
```

we can access this error.name.message to print error 
AND 
conditonally add or remove classname to our input to style
i.e
```javascript
 <input className={errors.name ? "name-error" : ""} // classname to show error conditionally
  {...register("name",
    { required:true,   
      minLength:{value:6,message:"Not working"}, 
      pattern:{value:/^[A-Za-z]+$/i, message:"pattern error"}})} />
  
  {errors.name && <p>{errors.name.message}</p>}  // error message showing conditonally
    
```

#### prevent multiple submission
we can use isSubmitting flag of formState to check weather the form is submitted or still submitting to prevent multiptle submit.
we can disable our submit button when isSubmitting is true 

i.e
```javascript
function submit(data){
  console.log(data);
  console.log("name:", data.name);
}
<form onSubmit={handleSubmit(submit)} >
<input type="submit" disabled={isSubmitting}>
</form>
```

## React-router-dom

While using react-router-dom for navigation in our web app we can setup and use it we need to Install it
i.e
```javascript
npm i react-router-dom
```
### Creating Routes 
we can creates route for application using createBrowserRouter by specifing each route in an array as object like
1. create route
2. use ```javascript
<RouterProvider routes={routes} />
[{
  path:"",
  element:"",
  children:{}
},]
```

i.e
```javascript
import {createBrowserRouter} from "react-router-dom

const App = ()=>{
  const routes = createBrowserRouter(
    [
      {
        path:"/",
        element:<Home/>
      },
      {
        path:"/user",
        element:<User/>
      },
      {
        path:"/about",
        element:<About/>
      },
    ]
  )
}
```

### Using routes 
To  use our routes we first need to return RouterProvider and pass our router(with routes) inside it, then according to our route component will be loaded into App component.
i.e 
```javascript
import {createBrowserRouter, RouterProvider} from "react-router-dom";

const App = ()=>{
  const routes = createBrowserRouter(
    [
      {
        path:"/",
        element:<Home/>
      },
      {
        path:"/user",
        element:<User/>
      },
      {
        path:"/about",
        element:<About/>
      },
    ]
  )
  return(
    <RouterProvider router={routes}>
  )
}
```

Now we can use our routes to access specific components.

### Using Link and NavLink
we can use Link or NavLink instead of <a></a> tag as it will reload whole page.
we can use Link and NavLink with a prop to="/", which routes to specific route.
i.e
```javascript
<Link to="/">Home</Link>
<Link to="/about">About</Link>
<Link to="/user">User</Link>
```

#### Diff btw Link vs NavLink
Link and NavLink are both almost similar but NavLink provide different values from props to know state of link and add class accordingly
i.e
```javascript
<NavLink to="/" className={(props)=>{props.isActive ? "active-link" : ""}}>Home</NavLink>
<NavLink to="/about" className={(props)=>{props.isActive ? "active-link" : ""}}>About</NavLink>
<NavLink to="/user" className={(props)=>{props.isActive ? "active-link" : ""}}>User</NavLink>
```

### Parameter routes and useParams()

We can have parameter route which are always dynamic 
i.e 
/user/112 OR /user/gaurang OR /user/gau1123

we can render component based on specific route using placeholder after (:)
Like ---> /user/:id
i.e
```javascript
const App = ()=>{
  const routes = createBrowserRouter(
    [
      {
        path:"/",
        element:<Home/>
      },
      {
        path:"/user",
        element:<User/>
      },
      {
      path:"/user/:id",      // like this (not using children as is seperate component and not inside user )
      element:<UserId/>,
      }]
      )

  return(
    <RouterProvider router={routes}>
  )
}
```

so when we will visit path like /user/123 OR /user/gaurang OR /user/gavu1123 it will load UserId component.

#### useParams()
Now we can use the id placeholder from our url to access specific data or something or get the id value.
To get  id value we use useParams.
i.e
```javascript
const {id} = useParams()
```

there might be multiple parameters for url/route like /user/:id/:reportno

we can access them like 
```javascript
const {id,reportno} = useParams()
```

we can than use the data to show or load specific values.

### Nested Routes and outlet
#### Creating nested routes
when we want to change part or tab of our screen like from option to either see search or product etc  we can use nested route. 

We can create nested routes like 
/dashboard/profile OR /dashboard/report OR /dashboard/income

using i.e

```javascript
const App = ()=>{
  const routes = createBrowserRouter(
    [
      {
        path:"/",
        element:<Home/>
      },
      {
        path:"/user",
        element:<User/>,
        children:[
          {
          path:"profile",      // like this inside children as to render inside User component
          element:<UserProfile/>,
          },
          {
          path:"report",      // like this
          element:<UserReport/>,
          },
        ]
      }
    ]
  )
  return(
    <RouterProvider router={routes}>
  )
}
```

#### use nested component using outlet
to use nested component inside out parent/main component we need to use outlet to render our child component 
Like incase of /user/profile we need to render <UserProfile> inside <User>

```javascript
import {outlet} from "react-router-dom"
const User = ()=>{
  return{
    <>
    It can change 
    <outlet/>
    </>
  }
}
```

this will render the component inplace out outlet accoring to the route 
like 
for UserProfile will load <UserProfile/> 
for UserReport will load <UserReport/>

### using useNavigate() for navigation through button 
When we want to navigate user from a page to another using a btn click we can do this by using useNavigate().
useNavigate will provide us method which will reroute us according to path given.
i.e
```javascript
import {useNavigation} from "react-router-dom"
const App = ()=>{
  const navigate = useNavigate();
  function onClickme(){
      navigate("/");  // path to navigate
  }
  return(
    <button onClick={onClickme}>Click ME</button>
  )
}
```

this will navigate user to path "/".

### Error Page handling 404
we can create a route to path "*" which will render same component for all not know or illegal path.
i.e

```javascript
const App = ()=>{
  const routes = createBrowserRouter(
    [
      {
        path:"/",
        element:<Home/>
      },
      {
        path:"/user",
        element:<User/>,
      },
      {
        path:"*",
        element:<NotFound/>
      }
    ]
  )
  return(
    <RouterProvider router={routes}>
  )
}
```

### useSearchParams()
It help use to handle the query string parameters like
?q="how to"

this query is written after a path and we can use useSearchParam to get the query in the component
useSearchParam return an array which has a object, which has a get method, which is used to get parameter value based on name (when have multiple parameters).
i.e 
```javascript
const App = ()=>{
  const routes = createBrowserRouter(
    [
      {
        path:"/search",
        element:<Search/>
      },
    ]
  )
  return(
    <RouterProvider router={routes}>
  )
}
```

-----> Search.jsx

for url like localhost:1234/search?q=react&sort=latest

```javascript
import {useSearchParams} from "react-router-dom"
const Search=()=>{
  const [seachParam] = useSearchParams();
  const query = searchParams.get("q");
  const sort = searchParams.get("sort");
return (
    <div>
      <h2>Search Query: {query}</h2>
      <p>Sort By: {sort}</p>
    </div>
)
}
```

export default Search

### <Navigate> component
we can use Navigate  component to navigate to the path.
i.e
```javascript
if(!user){
  <Navigate to="/" >
}
```

This will navigate us to "/" path if the user is not set.
we can also set replace prop (without value) to not add the last visited path from where we are navigate into history of browser
i.e after Login and navigate to another path we do not need to navigate back to the login path. so we can use repace.
i.e ---> Login.jsx
```javascript
if(username=="gaurang" && password=="correct"){
  <Navigate to="/home" replace />     // This will not add the login path to history so on clicking back btn user cannot go to login path again.
}
```



## Lifting state up
When we have multiple component with same kind of state variable defined in each. whicch are not in sync to each other.
If we want them to have same state variable, so to show or share same info we can use sate lifting.

State Lifting: It mean lift state up to nearest common parent and pass state and setState() to all child where we want.
then we can use setState() to change value in one child and will reflect change in all others too.

For example to share state between two student report component with parent App
i.e
```javascript
      APP  (will have state and setState())
     /   \
    /     \ 
 report   report
```

1. Lift state to nearest common parent
```javascript
import {useState} from "react"
const App = ()=>{
  const [marks,setMarks] = useState(70)
  return (
    <Report marks={marks} setMarks={setMarks}>
  )
}
const Report =({marks, setMarks})=>{
  return(
    <div>
    <p>show marks: {marks}</p>
    <button onClick={()=>{setMarks(marks+1)}}>ADD +1</button>
    </div>
  )
}
```

## UseContext() hook / Api
To pass information to child and grand child componenet we used props
i.e
```javascript
APP (props)
 |
 |
ChildA (props)
 |
 |
ChildB (props)
```

This is called prop drilling
where we need to pass data to ChildA too even if doesnt want it.
To avoid this and use/pass data more efficiently we can use useContext()

To use useContext we need to follow this steps
1. create context using usecontext()
i.e 
```javascript
const UserContext = useContext()
```

2. create a state or value to pass using useContext().
i.e 
```javascript
const [user,setUser] = useState({name:"gaurang",email:"gau@email.com"});
```

3. wrap app or top most parent component with <context.Provider> and pass **value or multiple value as object**, also export the context.
i.e
```javascript
<UserContext.Provider value={{user,setUser}}> 
<!-- <UserContext.Provider values={user}>  -->
<ChildA>
<UserContext.Provider/>

export UserContext
```
4. in ChildB or where you want to use context,import context and useContext and using useContext(UserContext) we can get value passed from context.
i.e
```javascript
import UserContext from '../../index.js' 
import {useContext} from 'react'

const {user:{name,email}, setUser} = useContext(UserContext); // if sent i.e value={{user,setUser}}
return(
  <>
  <p>{name}</p>
  <p>{email}</p>
  </>
)
```

OR
IF SENT LIKE
```javascript
<UserContext.Provider values={setUser}> 
```
we can direclty get setUser.

```javascript
const setUser = useContext(UserContext)
```

We can use Context Api like this.

## useRef
useRef() allow us to store reference of a dom element or a variable thats not needed for rendering(change). inside a object in key  name current.

### refering local variable
i.e
```javascript
let value = useRef()
```
It will create a object with key current set as undefined.
i.e
```javascript
value = {
  current : undefined;
}
```

we can change value using --> value.current = 10;

### passing initial value
we can also pass initial value to set initial value.
i.e 
```javascript
let value = useRef(10) 
```
will set 
```javascript
value = {
  current:10;
}
```

### refering dom element
we can also refer to a dom element using useRef() and set a attribute ref to our html element and set value to name of ref.
i.e
```javascript
const btn = useRef()
useEffect(()=>{                             
  btn.current.style.backgroundColor = "red"      // Must be used inside useEffect as btn will only assigned after component render
})
<button ref={btn}>Click me</button>
```

now our btn.current will have <button> element
which can be use to style or don anything on it
i.e 
```javascript
btn.current.style.backgroundColor = "red"; 
```

## useMemo() 
useMemo() is used to memoize/cache the output of a expensive calculation or function. 
only when state variable passed as dependency changes new calculation will be done and return value.
If component rerender by any other mean a memoized value is used if value remain same (state variable of parent component).  
It will return last saved value for same input.

we can use useMemo()
i.e

```javascript
let memoizevalue = useMemo(()=>calucativeFunction,[dependency array])
```

calucativeFunction is the expensive function whose result we want to track.
and dependency array is all variable whose value change calls the function.

i.e
```javascript
  const [numA, setNumA] = useState(0);
  const [numB, setNumB] = useState(0);
  const [calAb, setCalAB] = useState({a:0,b:0})
    function calculate(calAb){
        for (let i = 0; i < 1000000000; i++) {}
        console.log(calAb.a);
        
        return Number(calAb.a)+Number(calAb.b);
    }
  const sumChange = useMemo(()=>calculate(calAb), [calAb],[]);
   

  return(
    <div>
    <input type="number" value={numA} onChange={(e)=>{setNumA(Number(e.target.value))}}/>
    <input type="number" value={numB} onChange={(e)=>{setNumB(Number(e.target.value))}}/>
    <button onClick={()=>{(numA != calAb.a || numB != calAb.b) ? setCalAB({a:numA,b:numB}):null }}>Click me</button>  /// must check if object value is changing
    <p>{sumChange}</p>
    </div>
  )
```
While using useMemo we can only set dependency array value to those at whose value change we want to call calculativeFunction.
**If we use object we need to check if value is changed before setting the value otherwise it will always rewrite the value of object changing value and calling calculate().**

## memo()
we can use memo to wrap our child to let it not rerender even if our parent re-render (skipping all jsx conversion/ useeffect calcuations and all...).
But it will only work if we are not passing any prop which is not changing. 
**If we are passing prop it can be a primitive type because memo does shallow comparision (only value check not address).** 
i.e
```javascript
import {memo, useState} from 'react'

const Child = memo(()=>{
    console.log("Child render only once")
    return(
      <div>Will not re-render</div>
    )
})

const Parent = () =>{
    const [num,setNum] = useState(0);
    console.log("Parent render")
    function handleClick(){
        setNum(prev => prev + 1);
    }
  return(
    <div>
    <p> IT will render again </p>
    <button onClick={handleClick}>Click</button>
    <Child/>
    </div>
  )
} 
export default Parent;
```

In this every time we click btn it will render parent but not child.

### using memo with useMemo()
when we are passing any function/object prop whose reference will always be different and will rerender our child component.
But we can use useMemo to prevent this. 
i.e
```javascript
import {memo, useState} from 'react'

const Child = memo(({obj, handleClick})=>{
    console.log("Child render only once")
    return(
      <div>obj: {obj.a}</div>
    )
})

const Parent = () =>{
    const [num,setNum] = useState(0);
    const obj =  useMemo(()=>{a:"gavu",b:1},[]);
    const handleClick=useMemo(()=> setNum(prev => prev + 1),[]);
    console.log("Parent render")
  
  return(
    <div>
    <p> IT will render again </p>
    <button onClick={handleClick}>Click</button>
    <Child obj={obj} handleClick={handleClick}/>
    </div>
  )
} 
export default Parent;
```

In noraml way if we even pass handleClick it would  re-render the child but because it is memoised and child is in memo() it does not rerender child.

## useCallback()
Similar to useMemo with function useCallback is exactly same and is used  for same purpose only  difference between them is useMemo cam momoise different data type but  useCallback is specially for functions.
we can use it just the same way as useMemo for function
i.e
```javascript
import {memo, useState} from 'react'

const Child = memo(({obj, handleClick})=>{
    console.log("Child render only once")
    return(
      <div>obj: {obj.a}</div>
    )
})

const Parent = () =>{
    const [num,setNum] = useState(0);
    const handleClick=useCallback(()=> setNum(prev => prev + 1),[]);
    // OR
    // function handleClick(){
    //   setNum(prev => prev + 1)
    //   }
    // const handleClick=useCallback(handleCallback,[]);
    console.log("Parent render")
  
  return(
    <div>
    <p> IT will render again </p>
    <button onClick={handleClick}>Click</button>
    <Child obj={obj} handleClick={handleClick}/>
    </div>
  )
} 
export default Parent;
```

## useReducer()
It is used to maintain functions which are used to operate on state when functions are complex and big to manage.
We use it when we have complex state to manage 
i.e
```javascript
state={
  something:something,
  something:something,
  something:[something,something,something,],
  }
```
but if we have normal or state which is not complex we can use useState 
i.e state = 20 OR state="hello"

useReducer is similar to useState which returns a state variable and a function.
i.e 
```javascript
const [state, dispatch] = useReducer(reducer,{count:0}) 
```

### reducer
**IMP START**
reducer performs resetting on state (state is immutable) according to the type it has received. and payload of action
i.e 
```javascript
type = increment => return state+1
```    
OR    
```javascript
type = decrement => return state-1
```
or 
IF complex 
```javascript
state={id:1,name:"gaurang",location:"rajkot"},
type = "change location", payload = "veraval" => return {...state,location=action.payload}
```


**IMP END**
It takes a reducer function which has two parameters state and action.
where state would be variable created by a useReducer, and a action which would be a object conataining type key with value of what to do.
The reducer function will get its action from the dispatch function. 
i.e
```javascript
function reducer(state, action){
  return state
}
```

where action would be like {type:"increment"} or {type:"decrement"} which it will receive from dispatch.

### dispatch
dispatch function is called from the handler function and it should pass type and payload as argument i.e {type:"change location",payload:"veraval"}
i.e
```javascript
()=>{
  dispatch({type:"increment"})
}

reducer(state, action)  ==> useReducer(reducer,{count:0}) ==> state & dispatch({type:"increment"})
      ^                                                                  ∨
      |                                                                  |
      --------------------------------------------------------------------
```

i.e
```javascript
import { useReducer } from 'react'

const Reducer = () => {
  function reducer(state,action){
    switch (action.type){
      case "plus":{
        return {count: state.count+1}
      }
      case "minus":{
        return {count: state.count-1}
      }
      default:{
        return state
      }
    }
  }

  const [state,dispatch] = useReducer(reducer,{count:0})
  return (
    <div>
        <button onClick={()=>{dispatch({type:"plus"})}}>+</button>
        <p>{state.count}</p>
        <button onClick={()=>{dispatch({type:"minus"})}}>-</button>
    </div>
  )
}

export default Reducer  
```

**IMP** --> useReducer is superset of useState. 
It also returns a state and a function to manipualte state, and it takes a reducer/handler function ans the inital state.

our reducer / handler function have two argument a state and a action.
A state is what returned by the useReducer and a Action.
Action is used to define type of action to perform by achecking value of type.
and a payload if any to change the value of the state.

i.e Action and PAYLOAD for increment in reducer or handler function
```javascript
action={type:"Increment",payload:"{count:state.count+1}"} //IF const [state, dispatch] = useReducer(reducer,{count:0})
```

i.e Action and PAYLOAD for decrement
```javascript
action={type:"Decrement",payload:"{count:state.count-1}"} //IF const [state, dispatch] = useReducer(reducer,{count:0})
```

Dispatch: It is called with type and payload to invoke reducer function and update state according to type and payload.

## Custom Hook
We can create custom hook by creating a function as HOOK IS A FUNCTION.

1. must start with prefix (use)
2. we can use built in hooks in it
3. should not create side effect (side effect must be managed by useEffect outside hook).
4. create pure function hooks (for same input always generate same output, must not change state variables)

we can create a custom hook to return context value like
If a UserContext retrun values {username,email,location} to use it we need to import useContext, UserContext in aa seperate file.
so we can create a hook to return this value and only need to export this hook.
i.e
```javascript
import {useContext, createContext, useContext} from 'react'

// Assume we already have created context
export const useUserContext = () =>{
    const context = useContext(UserContext)
    return context;
}
```

To use 
```javascript
import {useUserContext} from './App'

const {username,email,location} = useUserContext();

```
**Error handling with custom hook**
We ccan throw custom error while creating custom hook
i.e
import {useContext, createContext, useContext} from 'react'

// Assume we already have created context
```javascript
export const useUserContext = () =>{
    const context = useContext(UserContext);
    if(context === undefined){                //Throwing error if undefined
      throw new Error("Context is Undefined");
    }

    return context;
}
```

## Error Boundries 
It is a way to catch error and either show or log error in file and also can provide reload btn.
We can use error boundry in functional components using react-error-boundary package
using error boundries we can do

1. show error
2. show specific error message (need component rendering)
3. reset button to reload boundary
4. log error and error stack (in console or file).

i.e 
```javascript
npm install react-error-boundary
```

It provides us a component <ErrorBoundary/> which is used to wrap our nearest parent component in which we want to use error boundary (we can wrap particular component too).
i.e
```javascript
import {ErrorBoundary} from "react-error-boundary"
<ErrorBoundary/>    
<Parent/>
<ErrorBoundary/>
```

### fallback
To show error to user we can use fallback prop in <ErrorBoundary/> and pass either a html element or a component to show error
i.e
```javascript
import {ErrorBoundary} from "react-error-boundary"
<ErrorBoundary fallback={<p>"SOMETHING WENT WRONG"</p>} />    
<Parent/>
<ErrorBoundary/>
```
This will show user a <p> element with text "SOMETHING WENT WRONG", and not a blank white screen.

We can also pass a component instead of html
i.e
```javascript
// -----> Render ERROR Component
export defalut const ErrorComponent = ()=>{
  return(
    <div style={{height:"100vh", margin:"auto"}}>
    <p>"SOMETHING WENT WRONG"</p>
    </div>
  )
}
```
```javascript
// ------> App.js
import {ErrorBoundary} from "react-error-boundary"
<ErrorBoundary fallback={<ErrorComponent/>} />    
<Parent/>
<ErrorBoundary/>
```

### Show specific error using fallbackrender={}
We can show specific error using fallbackrender. It will give our component access to the error object which we can print error.message
i.e
```javascript
// -----> CUSTOM ERROR PAGE
export defalut const ErrorComponent = ({error})=>{
  return(
    <div style={{height:"100vh", margin:"auto"}}>
    <p>"SOMETHING WENT WRONG"</p>
    <p>{error.message}</p> // display error message
    </div>
  )
}
```
```javascript
// ------> App.js
import {ErrorBoundary} from "react-error-boundary"
<ErrorBoundary fallbackrender={<ErrorComponent/>} />    // using fallbackrender as it providers error obj.
<Parent/>
<ErrorBoundary/>
```

### Log error and error stack in console using onError={} prop   (NOT IN DISPALY BUT IN CONSOLE)
we can use fallback and then onerror={logError} to call logError function which will have access to error and info(error stack).
onerror={} provide error and a info(call stack) which we can need to convert to json to display.

i.e
```javascript
// -----> Logging Error in console
export defalut const ErrorComponent = ({error})=>{
  return(
    <div style={{height:"100vh", margin:"auto"}}>
    <p>"SOMETHING WENT WRONG"</p>
    <p>{error.message}</p> // display error message
    </div>
  )
}
```
```javascript
// ------> App.js
import {ErrorBoundary} from "react-error-boundary"

const logError = ({error, info})=>{
  console.log("Error is ", error.message)
  console.log("Error stack is ", JSON.stingify(info))     // LOG ERROR STACK
}

<ErrorBoundary fallbackr={<ErrorComponent/>} onError={logError} />    
<Parent/>
<ErrorBoundary/>
```

### Provide reset button to reload page using resetBoundary hook
reat-error-boundary hook provide us hook useErrorBoundary() which provide a function resetBoundary() which reloads the nearest boundary.
We can use this hook inside our error component to have btn click function.

i.e
```javascript
// -----> Logging Error in console
import {useErrorBoundary} from "react-error-boundary" // IMPORT useErrorBoundary

export defalut const ErrorComponent = ({error})=>{
  const {resetBoundary} = useErrorBoundary();       // useErrorBoundary() to get resetBoundary()

  return(
    <div style={{height:"100vh", margin:"auto"}}>
    <p>"SOMETHING WENT WRONG"</p>
    <p>{error.message}</p>
    <button onClick={resetBoundary}>TRY AGAIN</button>    // USE RESET BOUNDARY FUNCTION
    </div>
  )
}
```
```javascript
// ------> App.js
import {ErrorBoundary} from "react-error-boundary"
<ErrorBoundary fallbackr={<ErrorComponent/>} />    
<Parent/>
<ErrorBoundary/>
```

## Portals in react
Portal in react allow us to add code into a specific dom parent
i.e 
Add code inide poratl class

```javascript
<div id="root">NOT RENDERED</div>
<div class="portal"></div>
```

when ever our component will be rendered it will be added to the portal.

It is very usefull in creating popup and modals(similar to popup but dont allow to interacting with restof site in background unti X closed).

we can create a component to render login from on click by setting a state.
whenever state is true show login popup when it is false close popup. we can so this by renturning our component inside a ReactDom.createPortal() and passing jsx and dom element of where to load.
i.e
```javascript
return ReactDom.createPortal(
  <>
    <div>THIS CODE WILL BE SENT TO DOM ELEMENT PORTAL</div>
  </>
  ,document.querySelector(".portal")
) 
```

Now it will be rendered into dom element portal when ever component is called.
**Full working example**
i.e
```javascript
// -----> LoginPopup.jsx
import ReactDOM from 'react-dom'

const Login = ({setModal}) => {
    function handler(){
        setModal(false)
    }
  return ReactDOM.createPortal(       // RETURNING  inside React.DOM  
    <>
    <div className='modal-wrapper'></div>
    <div className='login-popup'>
        <p>
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Earum
          dignissimos molestias delectus, unde porro laboriosam officia tempore
          laborum consectetur ullam incidunt, quia nulla ex assumenda enim.
          Vitae blanditiis esse obcaecati? A cupiditate deserunt dolorem
          accusamus nobis quz
        </p>
        <button onClick={handler}>Close</button>
    </div>
    </>
    ,document.querySelector(".portal")  // DOM ELEMENT WHERE TO RENDER
  )
}
```

```javascript
// -----> Header.jsx
import Login from './Login'
import { useState } from 'react';

const PropHeader = () => {
    const [modal, setModal] = useState(false);
    function openpopup(){
        setModal(true)
    }
  return (
      <>
          <nav>
        <div className="links">
          <ul>
            <li><button className="">Home</button></li>
            <li><button onClick={openpopup}>Login</button></li>
          </ul>
        </div>
      </nav>
      {modal && <Login modal={modal} setModal={setModal} />}
      </>
  )
}
```

will add <Login /> inside portal when state is true. and remove when state is false

## Redux React-Redux
redux and react-redux is a toolkit used for statemanagement in our react application (similar to contextApi).
We can use ContextApi as well as react-redux as per requirement.

to use react redux we need to follow step.

1. Create Slices
  1. useCreate slice and give name, initialState and reducers{methods}
  2. export actions (action.type) and slice.reducer (all methods)

2. Create/Configure Store
  1. import slice.reducer
  2. create store using configureStore({reducer{slice.reducer}})
  3. export store

3. Provide Store
  1. import Provider and store in index.tsx / most parent
  2. wrap main component using <Provider store={store}>

4. Consume slice and dispatch
  1. import actions (action.types) and useDispatch and useSelector
  2. get slice state using useSelector((stare)=>state.slice) // slice will be available automatically from provider
  3. get dispatch using useDispatch()
  4. call dispatch and pass/call the action. dispatch(increment())


i.e 
<!-- CounterSlice.ts -->
```javascript
import { createSlice, PayloadAction } from "@reduxjs/toolkit";
interface initalstate{
    counter:number
}
const initialState:initalstate={
    counter:0
}

const sliceCounter = createSlice({
    name: "counter",
    initialState,
    reducers: {
        increment:(state)=>{
            state.counter++
        },
        decrement:(state)=>{
            state.counter--
        },
        add:(state,action: PayloadAction<number>)=>{
            state.counter = state.counter + action.payload
        },
        minus:(state,action: PayloadAction<number>)=>{
            state.counter = state.counter - action.payload
        },
    },
})

export const {increment,decrement,add,minus} = sliceCounter.actions
export default sliceCounter.reducer;
```
<!-- Store.ts -->
```javascript
import { configureStore } from "@reduxjs/toolkit";
import sliceCounterReducer from "./CounterSlice"
import SliceAuth from "./AuthSlice"

const store = configureStore({
    reducer:{
        sliceCounter: sliceCounterReducer,
        sliceAuth: SliceAuth   
    }
})

export type RootState = ReturnType<typeof store.getState>;
export type AppDispatch = typeof store.dispatch;
export default store;
```
<!-- Component.tsx -->
```javascript
import { useDispatch, useSelector } from "react-redux"
import { RootState,AppDispatch } from "../store/store" 
import { increment,decrement } from "../store/CounterSlice";

const Counter = () => {
    const countSlice = useSelector((state: RootState)=>state.sliceCounter);
    const dispatch = useDispatch<AppDispatch>()  
  return (
    <>
    <div className="counter">
    <p>{countSlice.counter}</p> 
    <button onClick={()=>{dispatch(increment())}}>+</button>
    <button onClick={()=>{dispatch(decrement())}}>-</button>
    </div>
    </>
  )
}

export default Counter
```
