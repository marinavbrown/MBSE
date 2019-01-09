# -> Model-Based Systems Engineering <-

This repository contains code examples and exercises for a course in Model-Based Systems Engineering (MBSE). Our computing environment in this class will be the Scala programming language inside the Intellij IDEA development editor.

This page has instructions for getting your Scala environment set up and download the files that are in this repository. Once you're done here, you can take a look in the ```src``` folder starting with ```Week1```.


### Scala Installation - Week 1


1. Start by checking Java on your machine and Scala on your machine.
    - Open a terminal window and type
    
        ```java -version```
        
    - If you get a response with a version number, you already have Java and can skip to step 2.
    - If you get a response like "command not recognized" you can download and install Java from either [here](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) (Oracle) or from [here](https://jdk.java.net/11/) (open-source).
    - If you have problems here, try posting a question to the course Slack account here: https://mbse-gw.slack.com

2. Next install Scala. We recommend the following methods
    - Windows: Use the [MSI installer](https://downloads.lightbend.com/scala/2.12.8/scala-2.12.8.msi).
    - Mac: First install [Homebrew](https://brew.sh/). Then run the following commands in a terminal:

        ```brew update```
        
        ``` brew install scala```
    - Linux: Use your distribution's package manager (e.g., apt, yum, etc.).
    
3. Open a terminal window and type ```scala```.
    - You should get a prompt that looks like this:
    
        ```scala>```
    - If you get another error like "command not recognized", try googling "add scala to system path" plus your operating system.
    - Type the following and hit return:
    
        ```"Hello" + " " + "world!"```
    - You should get a response that looks like this:
    
        ```res0: String = Hello world!```
    - If so, your Scala installation is good to go.
    
That's all you need to do the homework for week 1, which you can find in ```Week1``` of the ```src``` folder linked above.
    
### Intellij Installation - Week 2    
    
1. Download & install Intellij for your operating system from [here](https://www.jetbrains.com/idea/download/). Make sure to get the free Community version rather than the Ultimate edition.

2. When you run Intellij for the first time, the program will ask if you want to import settings; choose "Do Not Import Settings". From here, a wizard will set up your installation. For more information on the installation process, you can look [here](https://www.jetbrains.com/help/idea/install-and-set-up-product.html). My recommended option choices are as follows:
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
    
    - If so, you are good to go and your Intellij environment is set up correctly!

Now, go take a look at the files in ```Week2``` to get started programming.
