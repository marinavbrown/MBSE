## Welcome to Scala

Our computing environment in this course will be the Scala programming language inside the Intellij IDEA development editor.

This page has instructions for getting your Scala environment set up, and for downloading the files that are in this repository. Once you're done here, take a look at Lesson 1 to start getting a feel for the language.

If you have run into problems during the installation (not unlikely!), try posting a question to the course Slack account here: [https://gwu-mbse.slack.com/](https://gwu-mbse.slack.com/).

### Java/Scala Installation



1. We will start by installing Java on your computer, if it isn't there already.

    - Start by checking whether Java is already on your computer by opening a terminal window and typing
    
        ```java -version```
        
    - If you get a response with a version number, you already have Java installed and can skip to step 2.
    - If you get a response like "command not recognized" you can download and install Java from either [here](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (Oracle) or from [here](https://jdk.java.net/11/) (open-source).


2. Next you need to install Scala. We recommend the following methods

    - Windows: Use the [MSI installer](https://downloads.lightbend.com/scala/2.12.8/scala-2.12.8.msi).
    - Mac: First install [Homebrew](https://brew.sh/). Then run the following commands in a terminal:

        ```brew update```
        
        ``` brew install scala```
    - Linux: Use your distribution's package manager (e.g., apt, yum, etc.).
    
3. Open a terminal window and type ```scala```.
    - You should get a prompt that looks like this:
    
        ```scala>```
        
    - At this point you may get an error saying something like "scala is not a recognized command". If so, you need to tell your computer where to find Scala the by adding it to the system's path variable.
        - The instructions are OS-specific, and you might need to reboot.
        - If you need help try googling "add scala to system path" plus your operating system.
    - Once you get a ```scala>``` prompt, type the following and hit return:
    
        ```"Hello" + " " + "world!"```
    - You should get a response that looks like this:
    
        ```res0: String = Hello world!```
    - If so, your Scala installation functioning properly.
    
If you are sick of installation and want to get started programming, this is all you need to complete Lesson 1. Otherwise, the next step is to install the Intellij IDE.
    
    
### Intellij Installation
    
1. Download & install Intellij for your operating system from [here](https://www.jetbrains.com/idea/download/). Make sure to get the free Community version rather than the Ultimate edition.

2. When you run Intellij for the first time, the program will ask if you want to import settings; choose "Do Not Import Settings". From here, a wizard will set up your installation.
  Our recommended option choices are as follows:
  
    - UI theme - Your choice
    - Keymaps (Mac only?) - Your choice
    - Launcher script (Mac only?) - Check yes to create command-line launcher.
    - Default plugins
        - Disable Build Tools, Test Tools, Swing, Android & Plugin Development
        - Customize Version Control - Enable only Git & GitHub
        - Customize Other Tools - Enable only Terminal
    - Download featured plugins - **You must install the Plugin for Scala**.

3. Once the wizard finishes, Intellij will open a prompt with several options. Choose "Check out from Version Control".

    - URL: ```https://github.com/sjbreiner/MBSE```
    - Choose where to install the files. The directory will be created if it doesn't exist already.
     - Click "Clone".
    - Click "Yes". You would like to open the Intellij IDEA project.

4. Now the Intellij editor should open.
    - You may get a pop-up saying that sbt wants to import files. Click "Enable auto-import".
    - Click "1:Project" on the left margin to open up a project view.
    - Open the "MBSE" folder and you should see another folder labeled "src".
    - Right click the "src" folder (Ctrl+Click on some Macs) and select "New > Scala Worksheet"; call the file "HelloWorld"
    - The IDE may ask if you would like to add the new file to your git project. Click "Remember..." and "Add".
    - On the first line of your worksheet type the following:
    
        ```"Hello" + " " + "World!"```
    
    - Hit the Play button at the top of the worksheet (next to the trash can).
    - You should get a split window with a response from the compiler on the left (it might take a minute) saying:
    
        ```res0: String = Hello World!```
    
    - If so, your Intellij environment is set up correctly!
    
Now start working through the rest of the ```WelcomeToScala``` lessons in this folder.

