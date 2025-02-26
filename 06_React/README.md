# REACT 
React is a js library used to create component based UI/font-end.

component are reuseable piece of code.. similar to a function.
This form a hierarchy inside which there are multiple components.
i.e Inside a video component we can have like btn, comment btn, thumbnail, description.
where each can be a individual component like like btn ...

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

In return we can only return one individual tag or we can return multiple tag as children to a single div
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

### multiple export

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

## Conditional Rendering
In react we can do conditional rendering anywhere in {} using && operator or ? : operator

in && any condition of left if is true then right side part will be executed/rendered


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
