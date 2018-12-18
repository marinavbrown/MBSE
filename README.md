# Model-Based Systems Engineering

This repository contains code examples and exercises for a course in Model-Based Systems Engineering (MBSE). Our computing environment in this class will be the Scala programming language inside the Intellij IDEA development editor.

This page has instructions for getting your Scala environment set up and download the files that are in this repository. Once you're done here, you can take a look in the ```src``` folder starting with ```Week4```.


### Installation

1. Download & install Intellij for your operating system from [here](https://www.jetbrains.com/idea/download/).

2. When you run Intellij for the first time, a wizard will set up your installation. For more information on the installation process, you can look [here](https://www.jetbrains.com/help/idea/install-and-set-up-product.html). My recommended option choices are as follows:
    - UI theme - Your choice
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
    
    - Hit the Play button at the top of the worksheet.
    - You should get a split window with a response from the compiler on the left (it might take a minute) saying:
    
        ```res0: String = Hello World!```
    
    - If so, you are good to go and your Scala/Intellij environment is set up correctly!

Now, go take a look at the files in ```Week4``` to get started programming.
