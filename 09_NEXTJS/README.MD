# NEXT JS

## TOPICS
1. - Why Next js
2. - Create a simple Next app
3. - Folder Structure
4. 1. - (APP BASED ROUTING) Understanding routing in Next
  -- File based routing
  -- Ignored Routes i.e components and other extra folders
  -- Merging Routes
  -- usePathname
  -- useSearchParams
  -- useRouter
  -- Redirecting user
  -- param from props of page..tsx
  -- Dynamic Segment [...slug] or [...folderName] / -- Catching all dynamic segment


4. 2. - (PAGE BASED ROUTING) Understanding routing in Next
  -- Folder Structure
  -- Route Folders
  -- useRouter() 
   --- pathname
   --- params
   --- Search params

5. - Adding Head to specific page/route using Head next/head
6. - CSS global.css, .module.css, tailwind
7. - Layouts
  -- Root Layout
  -- Layouts in sub routes (single page)
  -- Layouts in sub routes (Multiple page)
8. - Server side rendering component (PAGE BASED ROUTING ONLY)
  -- getServerSideProp
   --- context in getServerSideProp 
   --- Protecting pages in getServerSideProp 
  -- getStaitcProp & getStaitcPath
   --- getStaitcProp
   --- getStaitcPath
  -- Incremental Static Generation
9. - Client Side Componet ('use client') **(APP BASED)**
  -- Add a button onclick handler
10. - using api from "/pages/api/" **(PAGE BASED ROUTING)**
11. - clsx for conditional classNames
12. - Link component
13. - Image Component
   -- Required prop
   -- Remote Images
    --- configuration of RemotePatters 
   -- Optimize images
14. - middleware
    -- middleware for all urls
    -- middleware for specific paths
    -- middleware for conditional paths
15. - Loading page
16. - Error page
    -- Page Based 
    -- App Based 
17. - Font optimization
18. next-auth
    -- Creating api path [...nextauth] (OAuth)
     --- providers
     --- callbacks
    -- useSession
    -- imp methods for buttons 
    -- Credential based login

## Why Next Js
Server side rendering
Seo Optimisations
Routing
Solve Water Falling Problem
    i.e When request to link
        First send index.html and then request for js
        Get js and execute it and then content/paths are accessed


## Creating a Next js app
we can create a nextjs app using
```javascript
npx create-next-app@latest
```
Select sutaible options


## APP BASED ROUTING
### Folder structure 
1. src/app/
2. next.config.ts (next js configurations)
3. package.json (scripts and dependencies)
4. tailwind.config.ts (tailwind configurations)

src/app/ :- Its folder which is root path and all code is mostly written in this.

### Pages and Routing and Components Folder
Next.js has a file based router This means that the way you create your files, describes what renders on a route.

Inside src/app/ folder we will have page.tsx and a layout.tsx
**Any folder which has a page.tsx is considered as route**

like src/app/page.tsx means app/ folder is a route and it is "/" or home route in next js.

to add another route i.e signin
1. create folder name signin in src/app/ 
2. add a page.tsx inside /app/signin/
3. inside page.tsx write function with any name and return jsx.
i.e
```javascript
interface LabelledInputType {
    label: string;
    placeholder: string;
    type?: string;
}

function LabelledInput({ label, placeholder, type }: LabelledInputType) {
    return <div>
        <label >{label}</label>
        <input placeholder={placeholder} required />
    </div>

export default function Signin() {
    return (
    <div>
        <div >
        <a href="#" >
                <div>
                    <div>
                        <div >
                            Sign in
                        </div>
                    </div>
                    <div >
                        <LabelledInput label="Username" placeholder="harkirat@gmail.com" />
                        <LabelledInput label="Password" type={"password"} placeholder="123456" />
                        <button type="button">Sign in</button>
                    </div>
                </div>
            </a>
        </div>
    </div>
    )
}
} 
```
Now we can visit to https://localhost:1234/signin


#### Merging multiple routes (Used for layout in multiple [pages but not in all])
We can keep multiple routes in a single folder
i.e
app/auth/signin
app/auth/signup

But to access routes we need to use path
https://localhost:1234/auth/signin
https://localhost:1234/auth/signup

What if we donot need to use auth/signup and auth/signin but use /signin and /signup
we can merge routes by writing our folder name in () which nextjs will skip and donot consider ad route.
i.e
app/(auth)/signin 
app/(auth)/signup

so now we can use 

https://localhost:1234/signin 
https://localhost:1234/signup

### Ignnored Routes i.e components folder by using _ or not adding page.tsx
Inside our /src/app we can create folders like ui, components, libs, utils without creating routes for them by
1. creating a folder with (_) in beginning i.e _component  
the _component will not create a route for component.
2. by not adding page.tsx into them We can also create these folders out of app/ like in src/ or root (/) folder.


###  usePathname
Next js provide us usePathname() hook from 'next/navigation'. 
It is similar to react's useParams().
usePathname provide use the current path as string.
i.e
```javascript
import {usePathname} from 'next/navigation'

const path = usePathname();
console.log(path) --->path name i.e "/" , "/about", "/user", "/user/1"
```

we can use path to conditionally style our active links 
i.e
```javascript
import {usePathname} from 'next/navigation'

const path = usePathname();
  <li><Link href="/" className={clsx("hover:underline",{"bg-[#1e2939] p-[5px] rounded":path == "/"})}>Home</Link></li>
  <li><Link href="/about" className={clsx("hover:underline",{"bg-[#1e2939] p-[5px] rounded":path == "/about"})}>About</Link></li>
```

### useSearchParams (get seach parameters)
We can get seach parameter from url using useSearchParams from 'next/navigation'
i.e
for url https://localhost:3000/search?q=cricket

import {useSearchParams} from 'next/navigation'
const searchparam = useSearchParam()
const path = searchparam.get("q") ---> "cricket"


### useRouter():
we can create a object with use navigate
i.e 
```javascript
import {useRoute} from 'next/navigation'
const navigate = useRouter()
```
and than use it's property like 
1. navigate() / navigate.push("/"):- navigate to route adding entry in history.
2. navigate.back():- navigate to one path back according to history.
3. navigate.replace():- replcae current url without adding newentry.
4. navigate.refresh():- reload current page.

### Redirecting user
There are two ways to redirect a user
1. using useRouter():- using push or replace method 
2. using redirect():-
It is provided to use by next/navigation and we can use it similar to push() but no need to cereate a object.


### Dynamic routes and params
#### params from Props in page.tx 
while using dynamic routing we get a prop which we can use in our page.tsx

* path name of dynatmic route  
i.e blogpost/3244 -> 3244

we can get this path using **props.params.DynamicFolderName**
as this will pass a **promise** we need to use **async await** to get the path and a state variable to set path to variable
Next will provide us a prop pramas which will return us [FolderName]:value we can use it like **porp.params.FolderName**
i.e
```javascript
const Component = ({params}:{params:{DynamicFolderName: string}})=> {
  const {blogId, setBlogId} = useState("")

   useEffect(()=>{
    async function getBlogId(){   // async function to get blogId
    const {blog} = await params   //Using key to get value  
    setBlogId(blog)    // set blogId
  }
  getBlogId()},[])
}
```

### Dynamic segment ([...slug] or folder) or Catch-all dynamic segment
we can have a route with multiple paths like /blogpost/blogTag/id
how to get **blogTag and id and more if exist** we can use prop which we get from next while using dynamic routing.
we can get all segments as an array from our prop we get params object which has a slug key with array of our segements.
i.e
prop.params.slug
SLUG IS FOLDER NAME WE USED TO CREATE DYNAMIC ROUTE
i.e /blogTag/[...slug]/page.tsx

we can get all our segment
**IN APP BASED ONLY**
i.e
const Product =async ({params}:{params:{slug:string[]}}) => {
  const {slug} = await params
  return (
    <div>
      {slug.map((item)=> <li>{item}</li>)}
    </div>
  )
}

## Page Based Routing
### Folder structure 
1. src/pages/
2. next.config.ts (next js configurations)**same as app based**
3. package.json (scripts and dependencies)**same as app based**
4. tailwind.config.ts (tailwind configurations)**same as app based**

src/pages/ :- Its folder which is root path and all code is mostly written in this.

### Pages and Routing and Components Folder
Next.js has a **page based router also** This means that the way you create your files, describes what renders on a route.

Inside src/pages/ folder we will have _document.tsx, _app.tsx
and a index.tsx

**Any folder which has a index.tsx is considered as route**

like src/pages/index.tsx means pages/ folder is a route and it is "/" or home route in next js.

to add another route i.e signin
1. create folder name signin in src/pages/ 
2. add a index.tsx inside /pages/signin/
3. inside index.tsx write function with any name and return jsx/tsx.

Now we can visit to https://localhost:1234/signin

#### COMPONENTS FOLDER by not adding index.tsx
Inside our /src/pages we can create folders like ui, components, libs, utils without creating routes for them by not adding index.tsx into them
We can also create these folders out of pages/ like in src/ or root (/) folder.

### useRouter() (pathname, slug param, search param,push, back, replace, reload)
we can create a object with use navigate
i.e 
```javascript
import {useRoute} from 'next/navigation'
const navigate = useRouter()
```
and than use it's property like 
1. navigate.push("/"):- navigate to route adding entry in history.
2. navigate.back():- navigate to one path back according to history.
3. navigate.replace():- replcae current url without adding newentry.
4. navigate.reload():- reload current page.

#### Pathname (dynamic path with same route)
we can get pathname from url 
i.e 
for url http://localhost:3000/blog/221

import {useRouter} from 'next/router'
const router = useRouter()
const path = router.pathname -----> "blog/221"

#### Params (dynamic path with slug)
we can get param or slug using router.query.slug
i.e
for url http://localhost:3000/blog/my-post/postor/postone?page=2

import {useRouter} from 'next/router'
const router = useRouter()
const slug = router.query.slug  => ['my-post', 'postor', 'postone']

#### Search Param
We can get seach parameter from url using useRouter() from 'next/router'
i.e
for url https://localhost:3000/search?q=cricket

import {useRouter} from 'next/router'
const router = useRouter()
const query = router.query.q -----> "cricket"


## Adding Head into custom route/page
### APP BASED / PAGE BASED (SAME)
we can add <head> tag into each page by using Head component
Help us to add <title> <meta> seperate for each page/route
<head> for page will be loadded when page is loaded
i.e

```javascript
import Head from 'next/Head'

const Contact = () => {
  return (
    <>
    <Head>
    <title>Contact Us</title>
    </Head>
    <div className="h-[85vh]">
    <span>Contact</span>
    </div>
    </>
  )
}
export default Contact
```

## CSS global.css, .module.css, tailwind or scss
In next we can style with any of this
### global.css
It is the global css file which is use in (_app.tsx or layout.tsx) accordingly in page and app based routing.

### .module.css
For sepereate component we can use .module.css file to create a seperate css file and use it by importing as styles and using classes as sstyle.class to use module css in our component.
**we cannot directly define a normal css file as it will conflict with gloabl css and nextjs will throw error to us so we need to use .module.css for each component**
**we calso cannot use pure selector like button, div, p directly**
i.e
----> button.module.css

.button{
  background-color:red;
  color:white;
}

----> Button.tsx
```javascript
import styles from "./button.module.css"

function Button(){
  <button className={`${styles.button}`}>Click Me</button>
}

export default Button;
```

### scss
we need to inistall scss package
npm i scss

and add some config 
than use by creating .scss file and it will automatically compiled

## Layout files (APP BASED)
Layout file defines the layout of the route.
Layouts let you wrap all child pages inside some logic.
### Root Layout
We need to define a root layout for our "/" or home path in our app/folder
It returns a html layout of our website using function RootLayout which takes children prop.
All jsx / tsx in our routes will be passed as children and rendered inside our layout.
i.e

 ```javascript
export default function RootLayout({children,}: Readonly<{children: React.ReactNode;}>) {
  return (
    <html lang="en">
      <body className={`${geistSans.variable}  antialiased`}>
        {children}          // Render tsx according to routes
      </body>
    </html> 
  );}
```
### Adding header using layout.tsx 
we can add header by adding html in our layout.tsx
i.e
```javascript
export default function RootLayout({children,}: Readonly<{children: React.ReactNode;}>) {
  return (
    <html lang="en">
      <body className={`${geistSans.variable}  antialiased`}>
        <div className="w-full  bg-red-200 p-4">    // Add a navbar to all routes
          NAVBAR
        </div>
        {children}
      </body>
    </html> 
  )}
```
### Adding layout to (single page)
what if we want to show a banner only in signin route. 
we can achieve this by creating a layout.tsx in app/src/signin folder
But we do not nedd to create a RootLayout function we can just create a normal fubction and pass a children prop
i.e layout.jsx
```javascript
export default function banner({children,}: Readonly<{children: React.ReactNode;}>) {
  return (
         <div className="w-full  bg-red-200 p-4">    // Add a banner to signin route
          Banner
        </div>
        {children}      // render signin component/tsx
  );}
```
### Adding layout to (Multiple pages but not all)
We can show banner to multiple pages like (signin, signup) but not other in 2 ways
1. adding layout files to both signin and signup.
2. adding signin and signup in a single folder and define layout there.
In 2nd problem will occur because we will get path like 
/auth/signin
/auth/signup
**To fix we can use Merging layout as mentioned above**



## *Server Side Rendering* (PAGE BASED ROUTING ONLY)

**WE CAN USE CLIENT SIDE COMPONENT INSIDE A SERVER SIDE**
**BUT NOT A SERVER SIDE INSIDE A CLIENT SIDE**

### Use getServerSideProps(context)
In react we can make a route rendered on the server side called (SSR) **Server Side Rendering**, EVERY TIME A REQUEST IS MADE PAGE IS RENDERED ON SERVER SIDE.
we can export async function getServerSideProps()
when we use this function our route is **pre-rendered in the server side when requested**, we cannot use **getServerSideProps()** in "use client".

To create a route render on server side (SSR)
add getServerSideProps() function in the page route which will provide prop to what ever route it is defined.
we can use getServerSideProps() to do operation in server side like fetching data etc...
Which are thaan returend as **return {props:{posts}}** We can than use those props 
directly in our main/default component .

i.e
-----> **Home.tsx**
```javascript
interface PostType {
  userId: number,
  id: number,
  title: string,
  body: string
}

export default function Home({posts}:{posts: PostType[]}) {
  return (
    <>
    {posts.map((item)=>{return(
      <div key={item.id.toString()}>
      <h1>{item.id.toString()}</h1>
      <h1>{item.title.toString()}</h1>
      <h1>{item.body.toString()}</h1>
      </div>
    )})}
    </>
  );
}

export const getServerSideProps = async() => {
  const res = await fetch('https://jsonplaceholder.typicode.com/posts')
  const posts = await res.json()

  return { props: { posts } }
} 
```
#### context in getServerSideProps
we can get access to req to access
req.body
req.params
using **context** prop which comes in getServerSideProps
i.e
```javascript
export const getServerSideProps = async(context) => {
  const {q} = context.req.query
  const res = await fetch(`https://jsonplaceholder.typicode.com/posts/${q}`)
  const posts = await res.json()

  return { props: { posts } }
} 
```

#### Protecting Pages using getServerSideProp using cookie
```javascript
export async function getServerSideProps(context: {req:{headers:{cookie:string}}}){
  const cookies = parse(context.req.headers.cookie || '');
  const token = cookies.token;
  if (!token) {
    return {
      redirect: {
        destination: '/login',
        permanent: false,
      },
    };
  }
  try {
    jwt.verify(token, SECRET_KEY);
    return { props: {} };
  } catch (err) {
    return { redirect: { destination: '/login', permanent: false } };
  }
}
```

### use getStaticProps & getStaticPath
#### getStaticProps
It is similar to getServerSideProps() but it is not rendered at every request but is rendered when final build is made and stored as HTML for faster access. like About-us page or Blog Posts.

Similar to getServerSideProps() we can export async functoin getStaticProps()
to prerender pages at build time.
i.e
```javascript
export async function getStaticProps({params}:{params:{id:string}}){
  const id = params.id;
        const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${id}`)
        const post = await response.json() 
        return {props:{post}}
    }
```
**WE WILL SEE EXAMPLE WITH getStaticPath() but we can use it without it also.**

#### getStaticPath
when we have 100+ Blog posts in our DB it is not feasible to create static pages and store them all in server. 
So we can define how many pages should be Pre-renderd by 
**export async function getStaticPath()**
which return paths of routes i.e for blog/[id] path=[param_1,param_2,param_3,param_4] as param object from our getStaticPath() return will be 
i.e paths = [
  params:{id:1},
  params:{id:2},
  params:{id:3}
]

i.e
```javascript
export async function getStaticPaths(){
    const response = await fetch('https://jsonplaceholder.typicode.com/posts')
    const posts:PostType[] = await response.json() 
    const paths = posts.slice(0,10).map((item)=>({
      params: {id:item.id.toString()}
      }))
      return {paths,fallback:true}
  }
```
FULL EXAPMLE
```javascript
import { useRouter } from "next/router"

interface PostType {
  userId: number,
    id: number,
    title: string,
    body: string
  }
  export async function getStaticPaths(){
    const response = await fetch('https://jsonplaceholder.typicode.com/posts')
      const posts:PostType[] = await response.json() 
      const paths = posts.slice(0,10).map((item)=>({
        params: {id:item.id.toString()}
        }))
        return {paths,fallback:true}
    }
    
    export async function getStaticProps({params}:{params:{id:string}}){
      const id = params.id;
        const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${id}`)
        const post = await response.json() 
        return {props:{post}}
    }

const PostPage =({post}:{post:PostType})=>{
  const router = useRouter()
    if(router.isFallback){
      return <h1>LOADING...</h1>
    }
    return(
      <>
      <div key={post.id.toString()}>
      <h1>{post.id.toString()}</h1>
      <h1>{post.title.toString()}</h1>
      <h1>{post.body.toString()}</h1>
      </div>
      </>
    )
} 
export default PostPage
```
##### fallback 
Fallback is used to set what happen when page is generating when user is requesting a non static page.
we can check 
if(router.isFallback){return <div>Loading...</div>}

### Incremental Static Generation
When we create a static route it will store static pages in server.
**What if content in DB is Updated**
It will not be updated direclty in static pages we need to add a revalidate key in our getStaticProps()

When a user visit our page old static page will be loaded
1. A timer of seconds from revalidate key will run.
2. After the timer will finish a new page is regenerated with **new/old** data 
3. A new user when request will get new page if data is updated 

**Even if the data is not changed regeneration will still take place.**
**Existing User will not be refreshed but will get new page when new request will be made.**
**It use leaves before revalidation time regeneration will not take place.**

We can define revalidate key in getStaticProps()
i.e
```javascript
export async function getStaticProps({params}:{params:{id:string}}){
    const id = params.id;
    const response = await fetch(`https://jsonplaceholder.typicode.com/posts/${id}`)
    const post = await response.json() 
    return {
    props:{post},
    revalidate:60  // REVALIDATE KEY WITH PROPS
    }
}
```


### Client Component ('use client') (APP BASED ROUTING)
   
**WE CAN USE CLIENT SIDE COMPONENT INSIDE A SERVER SIDE**
**BUT NOT A SERVER SIDE INSIDE A CLIENT SIDE**

**Creating component "use client"**
By default all components are server components means will render on server side and response is sent to user as html.
but when using some thing which only make sense to render on clent side
like a Button with **onClick event handler** which will never work on server.
Nextjs will **throw a error** when we do it. adding a **onClick** event in a button.

So to make our component render only on client side we can add
```javascript
'use client'
```
on top of the file
i.e
```javascript
'use client'

const Button = ({title}:{title:string}) => {
  function handler():void{
    console.log("clicked")
  }
  return (
    <button onClick={handler} type="button" className="mt-8 w-full text-white bg-gray-800 focus:ring-4 focus:ring-gray-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2">{title}</button>
  )
}
export default Button 
```

## Using Api from pages/api/  (PAGE BASED ROUTING)
we can create our local api to fetch data by creating ts file in api/ folder

i.e api/post.ts --> http://localhost:3000/api/post
OR
/api/post/[id].ts --> http://localhost:3000/api/post/2 , http://localhost:3000/api/post/4

we can create multiple ts fille to handle different api route.
we need to export default async handler() which will set a response which will directly send to the calling fetch as a json string.S

i.e /api/post/[id].ts
```javascript
import type { NextApiRequest, NextApiResponse } from 'next';

type Post = {
  userId: number;
  id: number;
  title: string;
  body: string;
};

export default async function handler(req: NextApiRequest,res: NextApiResponse<Post | { error: string }>) 
{
  const { id } = req.query;
  if (typeof id !== 'string') {
    return res.status(400).json({ error: 'Invalid ID' });
  }
  const response = await fetch(`https://jsonplaceholder.typicode.com/post/${id}`);
  if (!response.ok) {
    return res.status(404).json({ error: 'Post not found' });
  }
  const post: Post = await response.json();
  res.status(200).json(post);
}

```
i.e using api ----> blog/[id].tsx
```javascript
import { useRouter } from "next/router"    

export async function getServerSideProps({ params }: { params: { id: string } }) {
  const id = params.id;
  const response = await fetch(`http://localhost:3000/api/posts/${id}`);  // CALLING API

  if (!response.ok) {
      return { notFound: true }; // Return a 404 page if the post is not found
  }
  try {
      const post = await response.json();
      return { props: { post } };
  } catch (error) {
      return { notFound: true };
  }
}

const PostPage =({post}:{post:{userId: number, id: number, title: string, body: string}})=>{
    const router = useRouter()
    if(router.isFallback){
        return <h1>LOADING...</h1>
    }
    return(
        <>
      <div key={post.id.toString()}>
      <h1>{post.id.toString()}</h1>
      <h1>{post.title.toString()}</h1>
      <h1>{post.body.toString()}</h1>
      </div>
      </>
    )
} 
export default PostPage
```

We can also send request of different methods and handle them in api/post/API_NAME.ts using switch case
i.e
 
```javascript
export default async function handler(req: NextApiRequest,res: NextApiResponse<Post | { error: string }>) 
{ 
  switch (req.method){ // METHOD CHECK
   case 'GET':
      // fetch post logic
      break;
    case 'PUT':
      // update post logic
      break;
    case 'DELETE':
      // delete post logic
      break;
    default:
      res.setHeader('Allow', ['GET', 'PUT', 'DELETE']);
      res.status(405).end(`Method ${req.method} Not Allowed`);
    }
}
```

## clsx to add styling conditionally
We can use clsx module to add classes conditionally in our component using clsx.
```javascript
npm i clsx
```
then we use it as function to conditionally add classes with some default class.

i.e
```javascript
import clsx from 'clsx'
function exaample(){
  const state = true;
return(
  <div classNam={clsx("p-2 m-0 bg-red-500 DEFAULTCLASSES", "CONDITIONALCLASSES bg-blur-700" : state == true)}></div>
)
}

```
## Link component ('next/link')
In nextjs we can use Link from 'next/link' to create <a> which do not reload whole page.
i.e
```javascript
import Link from 'next/link'

<Link href="/">MyApp</Link>
```

## Image component 
In nextjs it only serves images and other statiic assests which are only served from /public folder or from internet

### required props
to use Image component to serve image we need to specify some props which are mandatory.
1. src="Relative path to public"
i.e src="/image.jpg"
OR
src="/img.image.jpg"

2. height={100} ---> 100px
3. width={100} ---> 100px
4. alt=""

### Remote Patters 
we can use public/img or any folder inside public/

Next give use better way to add images in our application with optimisations automatically.

---> **home.tsx**
```javascript
import Image from 'next/image' 
<Image src="https://encrypted-tbn0.gstatic.com/images?q=ktzacw&s" alt="" height={500} width={500}>
```
### Configuration of Remote Images (api or website)
when we serve images from remote server we need to define remote pattern in our next config
i.e
---> **next.config.ts**
```javascript
module.exports = {
  images: {
    remotePatterns: [
      {
        protocol: 'https',
        hostname: 'encrypted-tbn0.gstatic.com',
        port: '',
      },
      {
        protocol: 'https',
        hostname: 'localhost:300/api/img',
        port: '',
      }
    ],
  },
}
```

### Local Images in public folder
to use local images we can store them in public/ or public/img
and can use them using directly without import

```javascript
import Image from 'next/image' 
<Image src="/img/image.png" alt="" height={500} width={500}>
```

### Optimization of only specific images in Local Images folder
when we serve images with optimization but we can also set restriction on what images are allowded for optimization by defining localPatterns. path inside local patterns are only allowded for optimization and no other are optimaized.
i.e
**public/assests/images/**
---> **next.config.ts**
```javascript
module.exports = {
  images: {
    localPatterns: [
      {
        pathname: '/assets/images/**',
        search: '',
      },
    ],
  },
}
```
only images in assets/images are optimized


## middleware
when we want to execute some code when user request to specific route.
i.e
check if user is authorized for page or redirect to "/"
Or
redirect user to another page when request to some page like /about to "/"

Middleware can only be defined in root folder or inside src/ (it src/ is there).

### Middleware **for all urls** can be defined like 
should be placed in
**/src/middleware.tsx**

i.e
```javascript
import { NextResponse } from 'next/server'
import type { NextRequest } from 'next/server'

export function middleware(request: NextRequest) {
  return NextResponse.redirect(new URL('/', request.url))
}
```

### Middleware for **specific paths**
we can deifne for which path middleware should execute by exporting a **config** object with **matcher** property
i.e
```javascript
import { NextResponse } from 'next/server'
import type { NextRequest } from 'next/server'

export function middleware(request: NextRequest) {
  return NextResponse.redirect(new URL('/', request.url))
}
export const config = {
  matcher: ['/about','/contact'],
}
```
or
```javascript
export const config = {
  matcher: '/about',
}
```

### Middleware executing conditionally for paths
To conditionally execute code only for specific paths we can use request parameter of middleware(request)
which is a object with lot of information.
we can access **path** from it using **request.nextUrl.pathname** 
and then use if condition  block
i.e
```javascript
import { NextResponse } from 'next/server'
import type { NextRequest } from 'next/server'

export function middleware(request: NextRequest) {
   if(request.nextUrl.pathname == "/about"){
     console.log(request.nextUrl.pathname)
     return NextResponse.redirect(new URL('/', request.url))
   }
   if(request.nextUrl.pathname == "/contact"){
     return NextResponse.redirect(new URL('/about', request.url))
   }
}
export const config = {
  matcher: ['/about','/contact'],
}
```

## Loading page
we might have a route which takes time to load, so we can create our own loading page to show until our route is loaded fully. 
we need to create a **loading.tsx** file our app/route/loading.tsx
it will be rendered until our page is ready.

**---> loading.tsx**
```javascript
const Loading =()=>{
  return(
    <div>Loading...</div>
  )
}
export default Loading
```

**---> page.tsx**
```javascript
const page=()=>{
  setTimeout(()=>{},4000) // 4s loading 
  return(
    <div>Loaded</div>
  )
}
export defalut page
```

## Error Page (App Based and Page Based)
we can show user a custom error page for any error. which is similar to error boundary.

### Page Based Routing
We can create a **_error.tsx** inisde page/_error.tsx
we need to use NextPageContext and ErrorProps within error page
and use Error.getinitialProps() to get statusCode of error

i.e
```javascript
import { NextPageContext } from 'next'
import { ErrorProps } from 'next/error'

const Error = ({ statusCode }: ErrorProps) => {
  return (
    <div style={{ height:"70vh", textAlign: "center", marginTop: "100px" }}>
      <h1>{statusCode ? `Error ${statusCode}` : "An error occurred"}</h1>
    </div>
  )
}

Error.getInitialProps = ({ res, err }: NextPageContext) => {
  const statusCode = res ? res.statusCode : err ? err.statusCode : 404
  return { statusCode }
}

export default Error
```

### App Based Routing
we can create a **error.tsx** inside app/route/error.tsx
Must use **"use client"**

**---> error.tsx**
```javascript
"use client"
const ErrorBoundary = () =>{
  <div>ERROR SOMETHING GONE WRONG</div>
}

export default ErrorBoundary
```

**---> page.tsx**
const About = () => {
  throw new Error("Something went wrong")
  return (
    <div>
    </div>
  )
}

export default About

## Font Optimization
Next js provide us font from it module "next/font/google"
we can import any font method and export the variable with initalization by calling the fontName()
we must pass a object with weight and subset.
to use font we use it in class name and use font.className  in className
1. import font.
2. create object by calling font imported.
3. set className in body to using object.classNamen (will give the font variable automaticcally). 
i.e
```javascript
import type { Metadata } from "next";
import "./globals.css";
import Header from "./ui/Header";
import Footer from "./ui/Footer";
import { Lusitana } from "next/font/google"  // IMPORT FONT

const lusitanaFont:NextFont=Lusitana({
    weight:"400",
    subsets:["latin"]
});

export const metadata: Metadata = {
  title: "PRACTICE NEXTJS",
  description: "Generated by create next app",
};

export default function RootLayout({children,}: Readonly<{children: React.ReactNode;}>) {
  return (
    <html lang="en">
      <body className={`${lusitanaFont.className}  antialiased`}> // USING FONT 
        <Header/>
        {children}
        <Footer />
      </body>
    </html> 
  );
}
```

## next-auth
we can use next auth to implement authentication and authorization.
Types of authentication
1. OAuth
2. Credentials

### Creating [...nextauth].tsx (OAUTH)
we need to create a route which will be used to handle our login inside pages/api/auth/[...nextauth].tsx
inside which we export a default function NextAuth
i.e export default NextAuth({})

inside the function we need to pass a object with two keys
1. providers
2. callbacks

**Providers**:[] is an array which has all our providers as function like GoogleProvider({}), GithubProvider({}), inside which we pass our
1. clientId
2. clientSecret

**callbacks**:{} is used to pass callbacks  like signin, jwt, session.
callbacks are executed at different time during next-auth lifecycle.
i.e 
1. signIn({ user, account, profile, email, credentials }):- when user sign in we can executed some code like writing user data in DB etc.
**In which we can return true to let user sign in or not if false.**
i.e
```javascript
signIn({ user }) {
  console.log("User trying to sign in:", user.email);
  return true; // allow sign in
}
```
2.  jwt({ token, user, account, profile }):- Runs when a JWT token is created or updated. You can attach additional data to the token.
i.e
```javascript
jwt({ token, user }) {
  if (user) {
    token.username = user.name;
    token.picture = user.image;
  }
  return token;
}
```
3. session({ session, token, user }):- Called when the session is checked using useSession() or getSession(). You can customize what data goes into the session. **add data into session**
```javascript
session({ session, token }) {
  session.user.name = token.username;
  session.user.image = token.picture;
  return session;
}
```

### using useSession for authentication
useSession():- You can use useSession() to access the logged-in user's session in any page or component.
i.e
```javascript
const { data: session, status } = useSession();
const username = session?.user?.name;
```
in this data is the accessed like
we can use session data also like
i.e
```javascript
const session = useSession().data;
const username = session?.user?.name;
```
AND 
**status** returns follwing values
status: "loading" | "authenticated" | "unauthenticated"

<!-- DashBoard.tsx -->
```javascript
import { useSession } from "next-auth/react";

export default function Dashboard() {
  const { data: session, status } = useSession();

  if (status === "loading") return <p>Loading...</p>;
  if (!session) return <p>You must be logged in</p>;

  return <p>Welcome {session.user.name}!</p>;
}
```

### IMP Methods used in components for buttons
1. signIn("google):- It is used to let user sign in using specific provider. and also redirect to route.
i.e
```javascript
import {signIn} from next-auth/react
<button onClick={()=>{signIn("google",{callbackurl : "/"})}}>
Sign In
</button>
```

2. signOut():- It is used to  signOut user and also redirect to route.
```javascript
import {signOut} from next-auth/react
<button onClick={()=>{signOut({callbackurl : "/"})}}>
Sign Out
</button>
```

### CREDENTIAL Based Login
when creating a input based login and signup we can use credential providers to manage login jwt, and session for us.

we can call CredentialsProvider({},authorize) in which we pass the credentials to be checked and a authorize function which will check the credential and do the task like checking from DB and returning the data like profilePhoto.

i.e
```javascript
CredentialsProvider({
    name: "Credentials",
    credentials: {
      email: { label: "Email", type: "text" },
      password: { label: "Password", type: "password" },
    },
    async authorize(credentials) {
      if (!credentials?.email || !credentials?.password) {
        return null;
      }
      try {
        const data = await fs.readFile(filePath, "utf-8");
        const users = JSON.parse(data);
        const user = users.find(
          (u: any) =>
            u.email === credentials.email && u.password === credentials.password
        );
        if (user) {
          return {
            id: user.id,
            name: user.username,
            email: user.email,
            image: user.profilePicture,
          };
        }
        return null;
      } catch (err) {
        console.error("Error in authorize:", err);
        return null;
      }
    }
  })
```

In login/index.tsx we can take input and use signIn() to send credentials
i.e
```javascript
import {signIn} from next-auth/react
const [email,setEmail] = useState()
const [password,setPassword] = useState()

const submitLogin = async ()=>{
    const res = await signIn("credentials", {
      redirect: true,
      email,
      password,
      callbackUrl: "/", // redirect after login
    });
} 
return 
(<>
  <form className="login-form" onSubmit={submitLogin}>
  <label className="form-label">Email:</label>
  <input
    className="form-input"
    required
    type="email"
    value={email}
    onChange={(e) => setEmail(e.target.value)}
  />

  <label className="form-label">Password:</label>
  <input
    className="form-input"
    required
    type="password"
    value={password}
    onChange={(e) => setPassword(e.target.value)}
  />

  <button className="primary-btn submit-btn" type="submit">
    {isLoading ? "Logging In..." : "Login"}
  </button>
  </form>
  </>)
```