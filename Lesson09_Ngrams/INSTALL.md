####Installation Instructions for the N-Grams Assignment for Macs

######To install this project's dependencies, we will use the package manager for Mac OS X known as Homebrew
1. Check to see if you have homebrew by running `brew -v`
2. If you do not have homebrew, install it by running `ruby -e "$(curl -fsSL https://raw.github.com/Homebrew/homebrew/go/install)"` in your terminal shell (see [Homebrew site](http://brew.sh/))
3. If you have homebrew, make sure it is up to date by running `brew update`
4. Install [Maven](http://maven.apache.org/) by running `brew install maven`
5. When you go to create the project in IntelliJ, import the project in IntelliJ and then choose `Import project from external model` and choose `Maven`
6. Add a new run configuration of type `Maven`, then add `test` in the `Command Line` field
7. If you're having trouble getting Maven to run, make sure that your `pom.xml` matches the `pom.xml` in this repository.
