## Process Object 

It is an instance of current nodejs runtime. Represents environment in which our code is running and environment variables.

#### process object consists of lot of methods 
i.e :- exit, cwd, argv

argv :- It is an array inside process object which consists of arguments passed into a js file while calling it
i.e :- node script.js arg1 arg2 arg3

argv has two values nodejs location and script file location in which, argv append arguments passed by user. This arguments are accessible by our script file. 

```sh
console.log(process.argv);
```
<!-- i.e :- argv=[
  'C:\\Program Files\\nodejs\\node.exe',
  'D:\\PROJECT\\practice\\script.js'
] -->

i.e :- node script.js arg1 arg2 arg3
<!-- argv=[
  'C:\\Program Files\\nodejs\\node.exe',
  'D:\\PROJECT\\practice\\script.js',
  argv1,
  argv2,
  argv3,
] -->

## Export Files  

>>> module.exports =  is a object which exports an object to another file.
>>> require() = is used to get exported object data from file which has module.exports in it. Passing file_name as argument.
i.e require("./file_name")


i.e
File 1
```sh
let sum = (a,b)=>{return a+b};
module.exports = sum;
```

File 2
```sh
let val = require("./File 1")
console.log(val.sum)
```

We can pass an object in module.exports i.e

File1
```sh
let sum = (a,b)=>{return a+b};
let mul = (a,b)=>{return a*b};

let obj = {
  sum:sum,
  mul:mul,
}
module.exports = obj;
```
File2
```sh
let val = require("./File1")
val.sum(9,8);
```

We can also directly add our variable into module.exports i.e

File1
```sh
module.exports.sum = (a,b)=>{return a+b};
```

OR we can directly do exports.var to export 

```sh
exports.sum = (a,b)=>{return a+b};
exports.mul = (a,b)=>{return a*b};
```
---->>>> we cannot do exports = obj;. because exports will be treated as exports.

## Export Directory

To export multiple/all files in directory. we need to module.exports from all file and require into a single index.js and put them all in array and then do a module.exports for array in index.js file.

i.e
Files in Practice/colors/

File1.js
```sh
let obj = {
    color:"red"
}
module.exports = obj;
```

File2.js
```sh
let obj = {
    color:"yellow"
}
module.exports = obj;
```

File3.js
```sh
let obj = {
    color:"green"
}
module.exports = obj;
```
index.js
```sh
let red = require("./File1")
let yellow = require("./File2")
let green = require("./File3")

let arr =[red,yellow,green]
module.exports = arr
```

File in Practice/
MainFile.js
```sh
let val = require("./fruits")
console.log(val[0].color);
```
require("./fruits") will find index.js file in directory and get module.exports from it.

## NPM

Node package manager is used to manage node packages i.e installing package.
It creates library of installed packages.

#### node_module 
In this folder all our packages are installed.

#### package-lock.json
In this file exact version of all dependencies and sub dependencies are stored which are required to run our project.

#### package.json
It stores meta data (i.e project_name, author, license etc..) and name,version of all dependencies used in our project.

### NPM Commands

1:- npm install
It installs all dependencies from package.json file into our project folder.

2:- npm install <package_name>
It install specific package.

3:- npm init
It is used to initialize our project as package.

### Creating our own package

Step 1:- Create project folder. And navigate to it.

step 2:- 
```sh
npm init
```
And fill the information. It will create a package.json file which will contain mete data about our project and dependencies.


### installing package globally

We must not install package globally.
To install package globally we need to do

Step 1:-
```sh
npm install -g <package_name> 
```
then we need to link package to local project using
Step 2:-
```sh
npm link <package_name>
```