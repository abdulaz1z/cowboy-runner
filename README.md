# Cowboy Runner

### Description
To be added

------------

### Features
- To be added
- To be added

------------

### Development workflow
1. Create an issue on github with the detailed description of what needs to be done. Keep the issue small.
2. Assign it to yourself if you are going to work on this issue.
3. Clone the repo if you have not done so yet.
4. `git checkout master`
5. `git pull`
6. Create a branch with the issue number. `git checkout -b issue_{number}`
7. Make your changes/implementation. Make sure to add Java documentation. Look at the example below.
8. `git add {filename}` for specific files or `git add .` for all.
9. `git commit -m "{title of the issue}, closes {#issue_number}"`
10. `git pull origin master` then `git push origin issue_{number}`. Resolve conflict if there is any.
11. Go to github and create a pull request (PR). Example: `issue_1234 --> master`. Tag someone to review it.
12. Merge it with master if its approved.

------------

##### Resolving merge conflict
1. `git checkout issue_{number}`
2. `git pull origin master`
3. Resolve the conflict.
4. Add the changes, commit, then push again to your branch. You do not need to create another PR.

------------

### Project File Structure
- **cowboy-runner** - name of the project
	- src
		- com
			- cowboy
				- main
					- Game.java
				- state
					- State.java
					- InitState.java
					- MenuState.java
					- PlayState.java
					- GameOverState.java
				- model
					- Player.java
				- resource
					- Resource.java
				- util
					- Animation.java
					- Frame.java
					- InputHandler.java
					- BgImageLayer.java
	- images - folder for all images

------------

### Shared Google Drive
Click [here](https://drive.google.com/open?id=1qbP4K96mR1F2hbrFmLwGcv84BqBUDFFO "here") for shared google drive

------------

##### Java Documentation Comments
Note: do not type it. Use `/**` then press enter. Then edit it.

Example:  for classes
```java
/**
* The HelloWorld program implements an application that
* simply displays "Hello World!" to the standard output.
*
* @author  Your name here
*/
public class HelloWorld {

   public static void main(String[] args) {
      System.out.println("Hello World!");
   }
}
```

for methods:
```java
/**
   * This method is used to add two integers.
   *
   * @param numA This is the first parameter to addNum method
   * @param numB  This is the second parameter to addNum method
   * @return int This returns sum of numA and numB.
   */
   public int addNum(int numA, int numB) {
      return numA + numB;
   }
```

------------

Note: If you work on this file, click [here](https://pandao.github.io/editor.md/en.html "here") to use this editor.