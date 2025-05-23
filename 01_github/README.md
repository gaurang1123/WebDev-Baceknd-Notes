# GITHUB

## init (initialize a local folder as git repo)
To make or initalize a local folder into a git repo we can locate to folder using cd command and use git init to initalize it.
i.e
```sh
cd Folder_name
git init
```

## Stages of Files in git and (adding and commiting them)
1. UnTracked
2. UnModified
3. Modified
4. staged


```sh 
git status  #show status of all 4 stages of all files in project
```

1. Untracked :- when a new file is added into git project folder it is untracked. we need to track it first.
this commands are used to track a particular file or all files in folder from project using (git add) to make them tracked.

2. Unmodified :- Files which don't have any change in them.

3. Modified :- Any change done in a file makes it a modified file.

### we need to add all UNTRACKED and MODIFIED Using cmd 

```sh
git add file name
or
git add .
```
4. Staged :- Once you run add cmd it makes file staged which can be now committed into memory.

```sh
git commit -m "Message"
```
Once committed all files are changed finally.

## ADD AND COMMITING LOCAL REPO TO GITHUB
Now we can push this changes to our git repository.
How to add local repo to github

1. we need to create a github repository and copy the repo link
<!-- i.e: github.com/gaurang1123/repo1 -->

2. open terminal in local project add add github remote origin

```sh
git remote add origin <link>
git remote -v #see the remote origin link
```

remote origin is link to our github repo

3. we need to check branch of the repo

```sh
git branch # gives current branch 
git branch -m main # to rename the current brach with specific name --> main 
```

4. now we need to do following steps

```sh 
git status # only to check status
git add .
git commit -m "message"
```

5. Now we can push this code to github using this cmd

```sh
git push origin main # main is name of branch. and origin is remote (link) to repo
```

## GIT REMOTE
Git remote is the used to manage remote repositories (github,bitbucket etc..)
### ADD A REMOTE
```sh
git remote add <name> <url> 
```
In this name is generally origin
### LIST ALL REMOTE
```sh
git remote -v
```
### REMOVE REMOTE
```sh
git remote remove <name>
```
### RENAME REMOTE
```sh
git remote rename <oldname> <newname>
```



## SETTING UPSTREAM and pushing to branch
Shortcut for command
```sh 
git push -u origin main
```
Now we need to only do 
```sh
git push
```
to push into origin main without specifying origin.   


## GITHUB BRANCHES

1. Get branch name 
```sh
git branch # get branch name
```
2. Rename Branch
```sh
git branch -m main # rename branch name to "main"
```
3. Create a new Branch
 ```sh
 git checkout -b features # create a new branch of name --> features
 ```

 4. Navigate or checkout Branch
 ```sh
 git checkout features # to navigate to the branch --> features
 ```

 5. Delete Branch
 ```sh
 git checkout main # to navigate to main branch
 git checkout -d features # Delete features branch. WE NEED TO NAVIGATE TO ANOTHER BRANCH BEFORE DELETE.
 ```

### Pushing Features Branch

First we need to navigate to features branch using
```sh
git checkout features # to navigate to the branch --> features
```
Then make changes like creating file or code. and then ADD ALL Files and make commit.
NOW YOU CAN SET AN UPSTREAM OR DIRECTLY PUSH IT.
```sh
# Using upstream
git push -u origin features  # to set upstream 
git push # now every time we need to just use git push only.
```
```sh
#Using Git origin
git push origin features 
```

### Comparing changes in file (diff)

#### Difference in *(not staged)* file
we can compare of see file changes in **non** tracked/staged files using 
git diff file_path
git diff ".\09Next\Readme"

**any change in file will be shown with deletion and insertion details**

#### Difference in *(staged)* file
we can compare of see file changes in tracked/staged files using 
git diff file_path
git diff ".\09Next\Readme"



### MERGING BRANCHES USING MERGE CMD
To merge using merge cmd 
```sh
git checkout main # navigate to main
git merge features # if we are in main branch
```
IF there are conflicts we need to either keep both or keep any one changes

### MERGING BRANCHES USING PR (PULL REQUEST)
*. Once you push features branch github will have two branches. To merge them we need to create pull request
*. Once code is pushed it will have option to COMPARE AND PULL the branch to main branch.
*. click on it and add message and click CREATE PULL REQUEST
*. If it doesn't have a conflict(when main branch has change in same file ) with another pull request you can MERGE PULL REQUEST.
*. PULL REQUEST IS A COMMIT IN ITSELF so you need to click confirm merge.



## GIT FETCH, GIT MERGE, GIT PULL
### GIT FETCH
We can fetch the changes from origin (github) which will not be applied on local but is used to check or diff. using
i.e
```sh
git fetch origin 
```
This will fetch all branches and store it in origin/main and let use it to diff the current file using
```sh
git diff git diff main origin/main
```
### GIT MERGE SOECIFIC FILE
To merge specifi file we can use 
```sh
git fetch origin
git checkout origin/main -- path/to/file.txt
```
### GIT MERGE (ALL CHANGES)
Using merge we can merge all changes in the origin/main file 
We can merge the changes in origin into our  local using git merge using
```sh
git merge 
``` 
### GIT PULL
using git pull we can fetch and merge the changes at same using single command using
```sh
git pull origin # pull from branch similar to your local
OR
git pull origin main # pull from main branch
OR
git pull origin features # pull from features branch
```
#### GIT PUll --REBASE
It is used to first write changes from origin to local and than write your changes on to it.
any conflict will be shown in Editor to change.
```sh
git pull origin --rebase
OR
git pull --rebase
```
 
## GIT RESET (FIXING MISTAKES)

### Case 1: Staged Changes
```sh
git reset filename  # reset all the staged changes mande using add cmd
    or
git reset
```

### Case 2: Committed Changes **(ONE COMMIT)**
```sh
git reset HEAD~1
```
It will undo the last commit i.e

<!-- 
    COMMIT1  --  COMMIT2  --  COMMIT3  --  COMMIT4
                                 ^           ^
                                 |     <<--  |
                                HEAD        HEAD                         
 -->

HEAD Points to last commit once we run cmd it will undo last commit and point to the second last commit.

### Case 3: Committed Changes **(MANY COMMIT)**

To check position of HEAD and hash of commits 
```sh
git log
```
it gives all the commits done from first to last.
To revert any commit we need to copy the hash code and fo

```sh
git reset hash_code
```
It will reset the commit 

### --hard reset
Hard rest means all the changes made in files will be revert backed.

#### Case 1: hard Reset the stages changes
To revert back changes of all staged file which are not commited 
```sh
git reset --hard
```

#### Case 1: hard Reset the stages changes
TO also delete changes made in commit from code we can do
```sh
git reset --hard hash_code
```

## GIT LOG
### We can see history of changes made using (git log )
i.e 
```sh
git log 
```
### We can see history of changes made in a particular file using (git log file_name) 
i.e 
```sh
git log '.\react\filename.md'
```
### we can also log history with change in file name and location using (git log --follow file_name)
i.e
```sh
git log --follow '.\react\filename.md'
```

## GIT STASH
Git stash is used to temporarily save uncommitted **(tracked or untracked)** changes and reset to last commit
### Create Stash 
we can create a stash using
```sh
git stash
OR
git stash push -m "stash created"
```
**This will revert all your changes which are made after last commit.**

### Get Stash list
```sh
git stash list
```

### Apply changes back (stash changes)
To apply your changes back on to your code we can use
```sh
git stash apply
OR 
# git stash apply STASH_NUMBER
git stash apply 1
```

### Apply changes back and delete stash
To apply your changes back on to your code and delete stash we can use
```sh
git stash pop
```

### Delete stash 
To delete stash we can use  
```sh
# git stash drop STASH_CODE 
git stash drop 1 
OR
git stash clear
```
