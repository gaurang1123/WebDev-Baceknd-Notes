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
"browserslist": [
  ">0.5%",
  "last 2 versions",
  "not dead"
]

## Remove console.log automatically
babel can help you remove log automatically by using it plugin.
1. npm install --save-dev babel-plugin-transform-remove-console
2. Add plugin into package.json
i.e
  "babel": {
    "plugins": ["transform-remove-console"]
  }


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
const heading =  React.createElemnet("h1",{id:"head1"},"content");

and we can create a root element using 
const root = ReactDom.createRoot(document.getElementById("root"));

and then render our elemmnt into the root using
root.render(heading)

we can add multiple child element inside the html element by passing [] (array).
i.e

const heading1 =  React.createElemnet("h1",{id:"head1"},"content");
const heading2 =  React.createElemnet("h1",{id:"head2"},"content");
const container =  React.createElemnet("div",{id:"container"},[heading1,heading2]);
root.render(container);

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
import React from "react"
import ReactDOM from "react-dom/client"


const root = ReactDOM.createRoot(document.getElementById("root"));
const heading = React.createElement("h1",{},"Heading 1");
console.log(heading)
root.render(heading)

inside html add type="module" in script tag as index.js is a module file.
use parcel to deploy server with an entry point (index.html)
i.e --> npx parcel index.html

## conversion of react fiunctional components -> React.createElement -> html(dom) 
using functional component we can return React.createElement type of code (converted by babel before returing) to our root.render().
before returning babel will convert our code into react.createElement type of code and send it further.
inside our component we can also call another component (as a function() call) or load it as component 
i.e
const Title = ()=>(<div><h1>Functionnal head</h1></div>);
const vartitle = (<div><h1>Functional head</h1></div>);
const LoadTitle = ()=>(<div>Here title is loaded like {title} or <Title/></div>);
root.render(LoadTitle);

in above we called Title as a function() call and also as component both return js code (React.createElement) into the LoadTitle component and hence it is not required to convert them again at render as are already converted.
 
## Setting react locally

```sh
npm create vite@latest
```
after running above command select react and javascript.

Then install node_modules from package.json using 
```sh
npm install
```

To run react app 
```sh
npm run dev
```

## Code structure and flow in React app

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
i.e <button> </button>  OR </button>

In return statement we can only return one individual tag or we can return multiple tag as children to a single div
i.e return <div> <h1> hello </h1> <button> click </button> </div>

We can use () with return to write from next line as return statement will not recognize anything written from next line.
i.e return (
    <div> 
    <h1> hello </h1> 
    <button> click </button> 
    </div>
    )

We can create component and use it inside our App.js like
i.e for Title inside App.jsx

```sh
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

### multiple export / named export

In react we can define multiple component in a single jsx file and export each component but then we have to import it using {}.
i.e
```sh
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

### single / default export
for Title component we can export it using 
```sh

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

```sh

# App.jsx

import Title from "./Title"
```

### Exporting both single and default

We can also have both single and default export in same file and can import it in App.
we have to use import for single component like {comp1, comp2} and default using only name.
i.e

```sh
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

## Using javascript {} in jsx

Any code written inside {} in jsx is treated as pure javascript
i.e
```sh
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

## Structuring react components

We must import repeating component into one component and then use that one to render in App.jsx
for a product with description and title we must made it one and then render it in App.jsx 
i.e product * 3 --> product tab --> App.jsx

```sh
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
```sh
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
import "./Product.css"

## Rendering List/Array

To render an array or list in react we mostly use map method to render array as list item
ie
```sh
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
let item = {"id":1,"name":"gaurang"}
<Product key=item.id name=item.name/>

this data will be sent to Product component using prop object.
prop is an default object in which this values are appended 
for console.log(prop)
prop = {"key":1,"name":"gaurang"}

we can just use this prop to access values 
i.e:- prop.key or prop.name

Example of using prop
```sh
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
```sh
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
let obj={name:"gaurang",age:21}
<Restaurant {...obj}>

It will pass prop automatically like 
<Restaurant name="gaurang" age=21>


## Conditional Rendering
1. In react we can do conditional rendering anywhere in {} using && operator or ? : operator

2. In && any condition of left if is true then right side part will be executed/rendered
It returns first falsy value or a component
i.e
const islogged = true
{islogged  && <Logout/>}
if islogged is is true it will return Logout.

const islogged = false
{islogged  && <Logout/>}
if islogged is is true it will return false (value of islogged).

3. using if else
we cannot directly use if else to render component in return statement because of {} (we need to write in it)
but we can use a function to write our condition in and call function in our retuns
i.e 
const isLogged = false;
const renderOne = ()=>{
  if(!isLogged){
    return <Login/>
  }
  else{
    return <Logout/>
  }
}

this shows buttons to either logout or login according to isLogged status.


## One and Two way data binding (Namste react) and event handing and input taking
React only supports one way data binding which means we can only pass data/props from parent to child or (from var to input, and not from input to var). 
i.e
let search = "value"
<input type="text"
    value={search}
    onChange={search=value}/> // this will not works as only search can provide data and onChange cannot change in it because of one way data binding.

const [searchtxt, setSeachTxt] = useState("")

<input type="text"
  value={searchtxt}
  onChange={(e)=>{setSeachTxt(e.target.value)}}/> // Here state variable set method allow us to do two way data binding.
<button>Search - {searchtxt}</button>


## useState()/Hooks in react

Hooks : Special function which allows functional components to use special react features.
i.e useState(), useEffect(), useContext(), useReducer(), useCallback() and more.....

useState() are used to create stateful variable which comes with a setter method.
when we need to change variable value we use set method for particular variable.
It helps to maintain state of variable throughout our file.
So when we change value of variable it will be changed/rendered everywhere.

To create a variable using useState() we create it 
i.e
```sh
let [count,setCount] = useState();
```
useState returns array with a variable and a setter function we need to destructure it to use it.
We can set default value by passing argument to useState().
let [count,setCount] = useState("0");  
Set count to 0 by default.

## Updater Function

It is a function passed as a argument to update state of variable 
When updating a count of variable we might call setCount() one or more time
i.e
value of count = 0

function handler(){
  setCount(count + 1)
  setCount(count + 1)
} 

But it will result to value of count = 1
Because react will batch/combine all setCount method and run it where state of count always stays 0 until updated.
like:

setCount(count + 1)   #setCount(0 + 1)
setCount(count + 1)   #setCount(0 + 1)
setCount(count + 1)   #setCount(0 + 1)

after last call count will be updated to 1

So we can use updater function / pass a function to update count value
i.e

setCount(preValue => preValue + 1)     #setCount(0 => 0 + 1)
setCount(preValue => preValue + 1)     #setCount(1 => 1 + 1)
setCount(preValue => preValue + 1)     #setCount(2 => 2 + 1)

updater function takes pending state to calculate next state.  # current state = 0, pending state = 0, 1 ,2 (each after function call)
react puts updater function into queue and execute all at next render.

It is good practice to use updater function even for single update


## Update object using useState()

we can assign a object to variable
i.e
```sh
let [car,setCar] = useState({year:2024,
                              brand:"Ford",
                              model:"mustang"})
```

how to change using setCar()

```sh
    function change(e){
    setCar(c => ({...car,year : e.target.value}))
  }

    <p>Car is {car.year} {car.brand} {car.model}</p>
    <input type="number" value={car.year} onChange={change} />
```

Because we cannot use car.year directly in {} jsx. we need to use spread car object.


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
useEffect(()=>{
    console.log("executed at every time render")
    },);

2. when we want to execute some code only once when our component render for first time we can pass a callback executor and a empty array (dependency array) to useEffect().

i.e
useEffect(()=>{
    console.log("executed at every time render")
    },[]); // will execute only once after first render
useEffect(()=>{
    console.log("executed at every time render")
    },[]); // will execute only once after first render

3. every time some state variable changes we can pass a array of state variables called dependency array. and callback executor.

i.e
const [status, setStatus] = useStatus("offline");
useEffect(()=>{
    console.log("executed at every time render")
    },[status]); // will execute every time when variable changes. 



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
    onChange={(e)=>{setSeacshTxt(e.target.value)}}/>
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
3. handle state using a function invoked on onChange and use event to get value of element .

IMP --> Dont use single function for onChange as it will manipulate others value to.

i.e
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

<textarea value={textArea} onChange={handleTextChange} rows=3></textarea>
</form>


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

no we can use them in our form
#### register:- 
It is use to register our form elements (input, select...) so that react-hook-form can track changes in it.
in this we pass a name and fields which help us to set constraints on our input.
register(name,fields);
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
errors{
  name:{
    type:minlength,
    message:"not working"
  }
}  

we can access this error.name.message to print error 
AND 
conditonally add or remove classname to our input to style
i.e
```javascript
 <input className={errors.name?.message ? "name-error" : ""} // classname to show error conditionally
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
npm i react-router-dom

### Creating Routes 
we can creates route for application using createBrowserRouter by specifing each route in an array as object like
[{
  path:"",
  element:"",
  children:{}
},]
i.e
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

### Using routes 
To  use our routes we first need to return RouterProvider and pass our router(with routes) inside it, then according to our route component will be loaded into App component.
i.e 
import {createBrowserRouter, RouterProvider} from "react-router-dom

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

Now we can use our routes to  access specific components.

### Using Link and NavLink
we can use Link or NavLink instead of <a></a> tag as it will reload whole page.
we can use Link and NavLink with a prop to="/", which routes to specific route.
i.e
<Link to="/">Home</Link>
<Link to="/about">About</Link>
<Link to="/user">User</Link>

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

so when we will visit path like /user/123 OR /user/gaurang OR /user/gavu1123 it will load UserId component.

#### useParams()
Now we can use the id placeholder from our url to access specific data or something or get the id value.
To get  id value we use useParams.
i.e
const {id} = useParams()

there might be multiple parameters for url/route like /user/:id/:reportno

we can access them like 
const {id,reportno} = useParams()

we can than use the data to show or load specific values.

### Nested Routes and outlet
#### Creating nested routes
when we want to change part or tab of our screen like from option to either see search or product etc  we can use nested route. 

We can create nested routes like 
/dashboard/profile OR /dashboard/report OR /dashboard/income

using i.e

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

#### use nested component using outlet
to use nested component inside out parent/main component we need to use outlet to render our child component 
Like incase of /user/profile we need to render <UserProfile> inside <User>

import {outlet} from "react-router-dom"
const User = ()=>{
  return{
    <>
    It can change 
    <outlet/>
    </>
  }
}

this will render the component inplace out outlet accoring to the route 
like 
for UserProfile will load <UserProfile/> 
for UserReport will load <UserReport/>

### using useNavigate() for navigation through button 
When we want to navigate user from a page to another using a btn click we can do this by using useNavigate().
useNavigate will provide us method which will reroute us according to path given.
i.e
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

this will navigate user to path "/".

### Error Page handling 404
we can create a route to path "*" which will render same component for all not know or illegal path.
i.e

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

### useSearchParams()
It help use to handle the query string parameters like
?q="how to"

this query is written after a path and we can use useSearchParam to get the query in the component
useSearchParam return an array which has a object, which has a get method which is used to get parameter value based on name (when have multiple parameters).
i.e 
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

-----> Search.jsx

for url like localhost:1234/search?q=react&sort=latest

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

export default Search

