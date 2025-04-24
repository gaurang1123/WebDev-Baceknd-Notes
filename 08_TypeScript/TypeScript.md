## Typescript

Typescript code is compiled into javascript and then a pure javascript file is created which can be executed directly.

### using tsc compiler to execute typerscipt
##### install tsc compiler
npm install -g tsc

##### compile ts code and execute in js
tsc index.ts
node index.js

#### compile and execute at sane time
npm install -g ts-node
ts-node index.ts

### Initalize Project using tsc
we can create a project with tsc to get a tsconfig.json file for our ts project.

#### Including and Excluding 

### Data types in typescript 

1. Primitive
2. Non-Primitive

let fname: string ="gaurang";
let age: number = 21;
let salary: number = 15000.00;
let isLogged: boolean = true;
let tasks: string[] = ["learn ts","variables"];
let id:number | string = 1;
id = 21;
id = "21";
let home_location: any = "gujarat";
let current_location: unknown = "rajkot"
function fun():void {
    console.log("this returns nothing")    
}
function fun2():never{
    throw new Error("This throws error or is infinite loop");
}

// Literal Types 
// set specific value only
let role: "intern" | "tech lead" | 21;
// can only set role to any one from above;
role = "intern"

### Type Annotaions
We can set the type of a variable using type annotaion, once set it will not be changed.
we set type annotaions i.e let a :string = "gaurang"

### Type inference 
when we dont give explicit type using type annotation typescript will automatically set type of variable according to the first value given.

### Arrays in typescript

let task: string[] = ["learn ts","variables","functions","objects"];
let ages: number[] = [21,22,23,24,25];

let task2: Array<string> = ["learn ts","variables","functions","objects"];
let ages2: Array<number> = [21,22,23,24,25];

This are called **generic type** array 
i.e
type Roles = "admin" | "employee" | "manager"
let people: Array<Roles>;
now element in people can only be from type Roles.  


let tasks3: (number | string)[] = ["learn",22,"create"];

task2.push("create website")

task2.forEach(ele => {
    console.log(ele);
}); 

let task4: readonly string[] = ["learn ts", "variables", "functions", "objects"];
// Only useable with (type[]) i.e string[] or generic array
// As readonly string[] is shorthand for ReadonlyArray<string>

### Objects in typescript 
#### Simple js object
const User = {
    fname :"Gaurang",
    age:21
}

#### passing object into function with type specific and optional argument using ?

let obj={
    name:"gaurang",
    age:21
}

function print(obj:{name :string, age? :number}) :void{
    console.log(obj.name);
    if(obj.age){
        console.log(obj.age)
    }
}
 

####  object with specific element type
const User2: {fname: string, age: number}={
    fname:"gaurang",
    age:21
}

#### Type Aliases
#### Reusable Objects using type
type Usert = {
    fname: string;
    age: number;
}

interface Useri {
    fname: string;
    age: number;
}

#### Reusable Objects using interface 
const objI: Useri={
    fname:"Gaurang",
    age:21
}

const objT: Usert={
    fname:"Gaurang",
    age:21
}


#### Reusable Objects using type optional element
interface UserTop{
    fname: string,
    age?: number
}

const objTop: UserTop={
    fname:"gaurang"
}

#### object with readonly member/element
interface UserRead{
    readonly fname: string,
    age: number
}
const objread: UserRead={
    fname:"gaurang",
    age:21
}
#### objread.fname = "hardik"; CANNOT CHANGE ERROR 


#### nested object with in interface object 
interface Company{
    name:string;
    employe:{
        name:string;
        age:number
    }
}

const objcomp: Company = {
    name: "Qrolic",
    employe:{
        name: "gaurang",
        age: 21
    }
}

### Typed Function 
we can specify the type of parameters passed into a funtion,
the return type of function also

We can specify the type of parameters like
function print(num :number, str :string){
    console.log(num);
    console.log(str);
}

if there is not return type explicitly assigned it will infere type from return statement
we can also explicitly define the return type using type annotation
i.e

function print(num :number) :number {
    console.log(num);
    return num;
}

this will only return a number

### passing functions as argument 
we can pass function as argument inside another function, we can also set the type of this argument when passing 
i.e
function passed(a: number,b:  number):void{}

function main(a,b,passed:(a: number, b:number)=>void)

we can also save this function type using a type aliase.
i.e
type callfunc = (a:number,b:number) => void

we can also do it  using interface
interface callfun{ (a:number,b:number ): void}

function add(a: number, b: number){
    console.log(a+b);
}

function math(a:number,b:number,callback: callfun):void{
        callback(a,b)
}

### contextual typing
sometime ts will automatically get the type of the parametes
i.e
let  arr :string[]=["array","array2","array3"]

arr.forEach(function(item){console.log(item)});
arr.forEach((item)=>{console.log(item)});

In this example type for item is assigned by contextual typing, means it get it from the type of foreach and array used.
its is called contextual because the context that function occured will inform the type.

### Union Type
union type is a type made from combing two or more diffrent types we can combine them using union (|) operator. refering type may be any of type. each of this type is called union member.

#### union example
i.e
function print(num :number 
    | string,
    str :string 
    | number,
):number | string{
    console.log(num);
    console.log(str);
    
    return num
}

console.log(print("gaurang","gau"));

#### operation with different union member
While using union operator, typescript will only allow any operation or function when it is supported by both types.
for (str :string | number), we cannot use str.toUpperCase because it is only available with string and not number.

we can fix this by narrowing / by checking type (using typeof in if block).
i.e

function print(str :number | string,){
    // console.log(str.toUpperCase()); ---> ERROR
    if(typeof str === "string"){
        console.log(str.toUpperCase()); 
    }
    else{
        console.log("not working");
    }
    return str
}

print("gaurang");

OR 

in array using Array.isArray(arr)

let arr :number[] | number = [1,2,4,4,2]

function print(arr :number[] | number,){
    if(Array.isArray(arr)){
        arr.forEach((item)=>{console.log(item);}) 
    }
    else{
        console.log("is a number" , arr);
    }
}
arr = 44
print(arr);

#### operation with different union members having same properties
But if the union member have a common property like slice for sting and number[]. we can use it without narrowing.

i.e
let arr :number[] | string = [1,2,4,4,2]

function print(arr :number[] | string,){
    // console.log(num.toUpperCase()); ---> ERROR
    if(Array.isArray(arr)){
        console.log(arr.slice(0,3));
    }
    else{
        console.log(arr.slice(0,3));
    }
}
arr = "gaurang"
print(arr);

#### union with interface
when using union with interfaces/object type we need to use properties of one interface/object type or it will throw an error.
i.e
interface Person{
    name :string;
    age :number
}
interface Employee{
    emp_id :number;
    emp_dept :string
}

interface EmpDetails = Person | Employee

let obj :EmpDetails ={
    name : "gavu",
    age : 21,
    emp_id : 111,   
}
any one set must be used fully i.e (Person) and emp_dept can be optional but any one property i.e(emp_id) must be used 

### Type aliases i.e type and interface

#### type
We can use union operator to declare multiple type every time. but we can also create or set a seperate type to be used every time when we want by declaring a type using type keyword.

type ID = number | string;
let fname :ID = "gaurang"

#### interface
interface is simailar to type but it is used for creating shape for object,
and use it when required.
i.e

interface User {
    x :number;
    y :string;
}

function print(obj :User){
    console.log(obj.x);
    console.log(obj.y);
}

let obj = {x : 21, y : "gaurang"};
print(obj)

#### Using type as interface

we can also use type similar to interface
i.e
type User{
    name:string,
    age: number
}


### Difference between Type and Interface
1. Both are same but there are slight difference like extending interface etc.
2. we can redeclare interface any changes with new declaration will be combined with old interface, so we can use both old and new properties
i.e
interface User{
   name: string,
   age: number 
}
interface User{
    location: string
}
let obj: User ={name : "gavu", age : 21, location : "rajkot"};

#### Extending another interface or type
interface can extend like
interface User {
    x :number;
    y :string;
}

function print(obj :User){
    console.log(obj.x);
    console.log(obj.y);
}

let obj = {x : 21, y : "gaurang"};
// print(obj)

interface UserDetails extends User{
    z:string
}

let obj2 = {x : 21, y : "gaurang", z:"rajkot"};

function detailprint(obj :UserDetails){
    console.log(obj.x);
    console.log(obj.y);
    console.log(obj.z);
}

detailprint(obj2)

Where as for type we need to use intersection for this (&).

#### Adding property to same interface or type

we can add property to same interface,
But not in type

#### Adding property to same interface
interface User {
    x :number;
    y :string;
}

interface User{
    z:number
}

function print(obj :User){
    console.log(obj.x);
    console.log(obj.y);
    console.log(obj.z);
}

let obj = {x : 21, y : "gaurang", z:20};
print(obj)

--------------------
When doing same with type will give error

### Readonly and optional properties

In typescript objects can have properties which are wither optional or readonly.

#### Optional
using it we can set a property to be optional while creating an interface or type for object.
optional properties are not required to be set, but if set type must be 
same except of undefined.

interface User {
    x :number;
    y? :string; // OPTIONAL
}

// let obj :User={x:32,y:null} ---> ERROR
let obj :User={x:32,y:undefined}
console.log(obj["x"]);
console.log(obj["y"]);


#### Readonly 
properties which are readonly cannot br written over again explicitly using any method or directly.

interface User {
    readonly x :number;
    y? :string;
}

// let obj :User={x:32,y:null}
let obj :User={x:32}
obj["x"] = 33; ---> ERROR
console.log(obj["x"]);

### Intersection
It is similar to union but in this all of the properties of object of intersecting members must be used.
i.e
type User = {
    name: string;
    age: number;
}

type Employee = {
    emp_id: number;
    emp_location: string;
}

let emp2 :User & Employee={
    name: "gaurang",
    age: 21,
    location: "rajkot",
    emp_id: 111,
    emp_location: "rajkot"
} 

### Literals
Literals are specific kind of values which can be set as value to variable.
if only one value is set it behaves like a constant 
i.e
let name :"gaurang" = "gaurang"
now we cannot change name again.

we can use union to set multiple literal values to be set.
i.e 
let name :"gaurang" | "hardik";
now any one from the given can be used.

#### combining literals with other types
we can also use literals with other types using union like primitive type or interface etc...
i.e
interface Options {
  width: number;
}
function configure(x: Options | "auto") { .../}
configure({ width: 100 });
configure("auto");
configure("automatic");  //// ERROR 

### Enums 
It is a typescript feature which allow to create a set of named constants.
we can set meaningfull values for the constans in enum.
i.e
enum Direction {
  Up,     
  Down,   
  Left,   
  Right   
}

The final code in js will look like
var Direction={
    0:UP,
    1:Down,
    2:Left,
    3:Right,
    UP:0,
    Down:1,
    Left:2,
    Right:3
}

Each of the properties in enum are readonly and cannot be change once initalized.
Properties in enums by default get value frmo 0 to the next number in ascending order.
If value for a property is set in number the next property will get next value.
i.e in Direction enum values for properties would be
Up = 0  
Down = 1   
Left = 2  
Right = 3

if value for Up would be given 1 rest would be in ascending order 
i.e
Up = 1
Down = 2
Left = 3
Right = 4

we can set string values to properties and use them too.
i.e
enum Role {
  Admin = "ADMIN",
  User = "USER",
  Guest = "GUEST"
}

let userRole: Role = Role.Admin;
console.log(userRole); // "ADMIN"
behind the scence the Role is getting setuped like
type Role = "ADMIN" | "USER" | "GUEST";

#### Reverse Mapping in Enums
We can get key/property name with a specific numerical value from the enum using reverse mapping 
i.e
enum Direction {
  Up = 0,     
  Down = 1,   
  Left,   
  Right   
}

we can get key with value 0 using console.log(Direction[0]) /// IMP


### Generics
We can set the type of the passing value to be set by typescript automatically as per the input to make code reuseable
i.e 
function getFirst<T,S>(array: T[], arr: S[]){
    return array[0];
}
console.log(getFirst([1,2,3,],[1,2,3,]));   //// USAGE
OR
const getFirst = <T,S>(array: T[], arr: S[])=>{ 
    return array[0];
}
console.log(getFirst([1,2,3,],[1,2,3,]));   //// USAGE

this function can get first element from any type of array i.e number[] or string[].

### Type utility
This are usefull to create a new type with specific condition for all properties 
This are mostly used with type aliase or interface which are used with objects.
some are also used for creating union types.

#### Type Utility types

1. Partial: creates a object type with all properties as optional
2. Required: creates a object type with all properties as required
3. Readonly: creates a object type with all properties as readonly

4. Record: it creates a object type from a union type as specific keys and specific type values from a value union type, where all properties are must.
i.e
```javascript
type Roles = "Admin" | "Manager" | "Employee";

let obj :Record<Roles,string> = {
    Admin:"gavu",
    Manager: "hard",
    Employee: "dhamo",
}
```
obj can only have properties which are present in Roles and all properties must be set.

5. Pick: it creates a new type from an existing type where we can select specific properties which we want to include in our new type which will be use as type for object.
i.e 
```javascript
type Roles = {Admin:string,  Manager:string, Employee:string};
type Role = Pick< Roles, "Admin" | "Employee">;
let obj : Role = {
    Admin:"gavu",
    Employee: "dhamo",
}
console.log(obj);

```

6. Omit: it creates a new type by removing specific key/property from existing type.
i.e
```javascript
type Roles = {Admin:string,  Manager:string, Employee:string};
type Role = Omit< Roles, "Admin">;
let obj : Role = {
    Manager: "hard",
    Employee: "dhamo",
}
console.log(obj);
```

7. Exclude: It is used to create a union type from an existing one by exluding given values from already existing union.
i.e
```javascript
type Roles = "Admin" | "Manager" | "Employee"
type othRole = Exclude<Roles, "Admin">;
let myrole: othRole="Manager"; 
```

8. Extract: This is reverse of exclude in this only the given value is set as value.
i.e
```javascript
type Roles = "Admin" | "Manager" | "Employee"
type othRole = Extract<Roles, "Admin">;
let myrole: othRole="Admin"; 
```
### Narrowing and Type guard
#### Narrowing
The process of refining types to a specific type using type guard is called narrowing.
Narrowing is checking type before performing an operation, to ensure that operation is valid for type.
It is used when we use union for setting multiple type.
i.e 
```javascript
function padding(pad: number | string, input: string) :string{
    if(typeof input == "number"){
        return " ".repeat(input);
    }
    else{
        return pad + input
    }
}
```
Above code takes pad and input, which will return input with padding in front.
we can check the type of pad and choose to run specific code, which will not give us error and will be type safe.

##### Type of Narrowing
there are many types of narrowing based on how values are to be narrow down some of them are
1. typeof: narrowing done on primitive types
2. Equility: narrowing using == or === operator on values
3. truthines: using if(val) or !val for narrowing
4. in: used to narrow by checking if property exist in obj.
5. instanceof: checkking if obj is instance of a class.
6. Assignment: by assigning a type to variable i.e let str: string , for str type is now narrowed to string.
7. Discriminated Union: it is used with obj type where each obj will have a same property with different value for all, which will be used for narrowing. 
i.e 
```javascript
type Animal = 
   { type: 'dog'; breed: string; bark: () => void }
  | { type: 'cat'; breed: string; meow: () => void }
  | { type: 'bird'; species: string; fly: () => void };

function handleAnimal(animal: Animal) {
  if (animal.type === 'dog') {
    console.log(animal.breed);
    animal.bark();
  } else if (animal.type === 'cat') {
    console.log(animal.breed);
    animal.meow();
  } else {
    console.log(animal.species);
    animal.fly();
  }
}

const myDog: Animal = { type: 'dog', breed: 'Golden Retriever', bark: () => console.log('Woof!') };
handleAnimal(myDog);
```

const myDog: Animal = { type: 'dog', breed: 'Golden Retriever', bark: () => console.log('Woof!') };
handleAnimal(myDog);



#### Type guard
the part of code (typeof input == "number") used in above is called type gaurd. 
It is a special form of code.
There are different types of type guards which can be used to narrow type for different types.
i.e 
for primitive types we can use typeof, 
for Arrays we can use Array.isArray(T).

there are different types of type guard
1. typeof: used to narrow by checking type
2. instaceof: used to narrow by checking if is a instance of
3. in: used to check if is a property of a object
4. Assignment: using type annotation or = (to set by type inference).
5. Descriminated union:  by checking a property in union of obj which should be present in multiple obj with different values.
6. User-defined type guard:

##### User Defined type guard

###### Type predicste
**is** typeguard
A user defined type guard can be defined like
function isCat(animal :Cat): animal is Cat{ ...////}
**: name is string (this is called type predicate)**
a perdicate should be in form (ArgumentName is Type)

Type predicate is used with a function to determine type of something.
functio than may return true or false.

###### Implementation of user-defined guard
i.e 
```javascript
type Fish = {name: string, swim:()=> void}
type Bird = {name: string, fly:()=> void}

function isFish(pet :Fish | Bird):pet is Fish{
    return (pet as Fish).swim !== undefined;
}

const goldfish :Fish= {name:"goldfish", swim:()=>{console.log("Swim");}}
const sparrow :Bird= {name:"sparrow", fly:()=>{console.log("Fly");}}

function handelPet(pet: Fish | Bird){
    if(isFish(pet)){
        pet.swim();
    }
    else{
        pet.fly()
    }
}

handelPet(sparrow)
```