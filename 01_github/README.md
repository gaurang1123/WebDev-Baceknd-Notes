# GITHUB

#### Stages of Files in git 
1. UnTracked
2. UnModified
3. Modified
4. staged


```sh 
git status  #show status of all 4 stages of all files in project
```

1. Untracked :- when a new file is added into git project folder it is untracked. we need to track it first.
this commands are used to track a particular file or all files in folder from project.

2. Unmodified :- Files which don't have any change in them.

3. Modified :- Any change done in a file makes it a modified file.

###### we need to add all UNTRACKED and MODIFIED Using cmd 

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
-----------------------------------------------------------------------------------------------------------------------------

## ADD LOCAL REPO TO GITHUB
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

## SETTING UPSTREAM 
Shortcut for command
```sh 
git push -u origin main
```
Now we need to only do 
```sh
git push
```
to push into origin main without specifying origin.   
-------------------------------------------------------------------------------------------------------------

## GITHUB BRANCHES

1.
```sh
git branch # get branch name
```
2.
```sh
git branch -m main # rename branch name to "main"
```
3.
 ```sh
 git checkout -b features # create a new branch of name --> features
 ```

 4.
 ```sh
 git checkout features # to navigate to the branch --> features
 ```

 5.
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

### COMPARING & MERGING BRANCHES
```sh
git diff main #if you are in features branch
```

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

## PULLING FROM GITHUB

To update your local repo with changes in github remote repo.
we need to run pull cmd

```sh
git pull origin main
```

 
## FIXING MISTAKES

* Case 1: Staged Changes
```sh
git reset filename  # reset all the staged changes mande using add cmd
    or
git reset
```

* Case 2: Committed Changes (ONE COMMIT)
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

* Case 3: Committed Changes (MANY COMMIT)

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

TO also delete changes made in commit from code we can do
```sh
git reset --hard hash_code
```
