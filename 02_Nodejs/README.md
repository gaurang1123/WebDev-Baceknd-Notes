## Process Object 

It is an instance of current nodejs runtime. Represents environment in which our code is running and environment variables.

#### process object consists of lot of methods 
i.e :- exit, cwd, argv

argv :- It is an array inside process object which consists of arguments passed into a js file while calling it
i.e :- node script.js arg1 arg2 arg3

argv has two values nodejs location and script file location in which, argv append arguments passed by user. This arguments are accessible by our script file. 

```javascript
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
```javascript
let sum = (a,b)=>{return a+b};
module.exports = sum;
```

File 2
```javascript
let val = require("./File 1")
console.log(val.sum)
```

We can pass an object in module.exports i.e

File1
```javascript
let sum = (a,b)=>{return a+b};
let mul = (a,b)=>{return a*b};

let obj = {
  sum:sum,
  mul:mul,
}
module.exports = obj;
```
File2
```javascript
let val = require("./File1")
val.sum(9,8);
```

We can also directly add our variable into module.exports i.e

File1
```javascript
module.exports.sum = (a,b)=>{return a+b};
```

OR we can directly do exports.var to export 

```javascript
exports.sum = (a,b)=>{return a+b};
exports.mul = (a,b)=>{return a*b};
```
---->>>> we cannot do exports = obj;. because exports will be treated as exports.

## Export Directory

To export multiple/all files in directory. we need to module.exports from all file and require into a single index.js and put them all in array and then do a module.exports for array in index.js file.

i.e
Files in Practice/colors/

File1.js
```javascript
let obj = {
    color:"red"
}
module.exports = obj;
```

File2.js
```javascript
let obj = {
    color:"yellow"
}
module.exports = obj;
```

File3.js
```javascript
let obj = {
    color:"green"
}
module.exports = obj;
```
index.js
```javascript
let red = require("./File1")
let yellow = require("./File2")
let green = require("./File3")

let arr =[red,yellow,green]
module.exports = arr
```

File in Practice/
MainFile.js
```javascript
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
```javascript
npm init
```
And fill the information. It will create a package.json file which will contain mete data about our project and dependencies.


### installing package globally

We must not install package globally.
To install package globally we need to do

Step 1:-
```javascript
npm install -g <package_name> 
```
then we need to link package to local project using
Step 2:-
```javascript
npm link <package_name>
```

## File System
We can use fs module to access file system of Operating System fs module is an api provided by os.

We can do following
Common use for the File System module:

1. Read files
2. Create files
3. Update files
4. Delete files
5. Rename files

### IMP FUNCTIONS
1. fs.readFile():- 	Read file asynchronously
2. fs.readFileSync():- 	Read file synchronously
3. fs.writeFile():- 	Write or overwrite file asynchronously
4. fs.writeFileSync():- 	Write or overwrite file synchronously
5. fs.appendFile():- 	Append to file asynchronously
6. fs.appendFileSync():- 	Append to file synchronously
7. fs.exists() ⚠️:- 	Check if file exists (deprecated)
8. fs.unlink():- 	Delete file asynchronously
9. fs.unlinkSync():- 	Delete file synchronously
10. fs.rename():- 	Rename or move file asynchronously
11. fs.renameSync():- 	Rename or move file synchronously
12. fs.stat()	Get file/directory details (size, type, etc.)
13. fs.mkdir()	Create a directory
14. fs.mkdirSync()	Create a directory synchronously
15. fs.readdir()	Read contents of a directory
16. fs.rm()	Remove file or directory
17. fs.copyFile()	Copy one file to another

### Read Files fs.readFile() or fs.readFileSync()

fs.readFile() is Asynchronous (used for server, apis)
fs.readFileSync() is synchronous (used for startups, init, config)

#### fs.readFile()
using fs.readFile(path,encoding,Callback) 
path:- path of file
encoding:- i.e "utf-8" or "utf-64"
Callback:- handle err and data 
i.e 
```javascript
const fs = require("fs")

fs.readFile("index.html","utf-8",function(err,data){
  if(err){
    console.log("Something went wrong")
  }
  else{
    console.log(data)
  }
})
```

fs.readFile() is asynchronous so it will be executed **after** synchronous code.

#### fs.readFileSync()
path:- path of file
encoding:- i.e "utf-8" or "utf-64" 
i.e 
```javascript
const fs = require("fs")

try{
  const data = fs.readFile("index.html","utf-8")
  console.log(data)
}
catch(err){
  console.log(err)
}
```

fs.readFileSync() is synchronous so it will be executed synchronously.

### Write File & Create File
#### Create and writing in File (overwiting existing file)
We can create file using fs.writeFile()

fs.writeFile(path,data,encoding,Callback)

path:- path of file
data:- data to read
encoding:- i.e "utf-8" or "utf-64"
Callback:- handle err **(data not needed)**

**This code will overwrite if file exist**
i.e 
```javascript
const fs = require("fs")

fs.writeFile("index.html","Data as Text","utf-8",function(err){
  if(err){
    console.log("Something went wrong")
  }
})
```
It is also a asynchronous code.

### Update or writing in File (in existing file)
we can use either 

**fs.appendFile()**
```javascript
const fs = require('fs');

fs.appendFile('file.txt', 'New data added!', 'utf-8', (err) => {
  if (err) throw err;
  console.log('Data appended successfully!');
});
```

OR

**fs.writeFile()**
We can write over a file by passing **flag:'a'** in object like:
**{encoding:"utf-8", flag: 'a'}**

i.e 
```javascript
const fs = require("fs")

fs.writeFile("index.html","Data as Text",{encoding:"utf-8", flag: 'w'},function(err){
  if(err){
    console.log("Something went wrong")
  }
})
```

### Deleting File using fs.unlink() or fs.unlinkSync()
we can delete a file using fs.unlink() or fs.unlinkSync()

fs.unlink(path,Callback());

path:- path of file
Callback:- To handle err

**Asynchronous Deleting**
```javascript
fs.unlink("index.html",(err)=>{
    if(err){
        console.log("err")
    }
    else{
        console.log("done")
    }
})
```

**Synchoronus Deleting**
```javascript
try {
  fs.unlinkSync('file.txt');
  console.log('File deleted successfully!');
} catch (err) {
  console.error('Error deleting file:', err.message);
}
```

### Renaming File fs.rename() & fs.renameSync()

we can rename file using this method 

**Asynchronous**
fs.rename('oldFilePath','NewFilePath',Callback)

oldFilePath:- Old File path with extension
NewFilePath:- New File path with extension
Callback:- Handle Callback

```javascript
fs.rename('oldName.txt', 'newName.txt', (err) => {
  if (err) {
    console.log('Error renaming file:', err.message);
    return;
  }
  console.log('File renamed successfully!');
});
```

**Sycnhronous**
```javascript
try{
    fs.renameSync('index.html', 'newName.txt')
    console.log("scuccess full")
}
catch(err){
    console.log("err")
}
```