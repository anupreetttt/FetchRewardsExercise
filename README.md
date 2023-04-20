# Fetch Rewards Coding Exercise - Software Engineering - Mobile

## Task: 

Please write a native Android app in Kotlin or Java that retrieves the data from https://fetch-hiring.s3.amazonaws.com/hiring.json.

Display this list of items to the user based on the following requirements:

Display all the items grouped by "listId"
Sort the results first by "listId" then by "name" when displaying.
Filter out any items where "name" is blank or null.
The final result should be displayed to the user in an easy-to-read list.

Please make the project buildable on the latest (non-pre release) tools and supporting the current release mobile OS.

## Minimum requirements

1. Android Studio installed to latest version
2. AVD emulator
3. Android SDK API version 33
4. Minimum SDK 26
5. Targeted SDK 33

## Installation

1. Download the zip file from github or go to desired location in terminal/command prompt and do "git clone https://github.com/anupreetttt/FetchRewardsExercise.git"
2. Open Android Studio, File -> Open and navigate to your folder location and click open
3. Ones gradle build is finish you should be able to run the application, by clicking on run button.


## Architecture: 

For this assignment, I used MVVM (Model-View-ViewModel) design pattern. By separating the View from the business logic and data source, MVVM makes it easier to maintain and update each component separately. This makes the codebase more modular, easier to read, and reduces the likelihood of introducing errors. MVVM makes it possible to reuse the same ViewModel and Model components in different Views. This can save development time and reduce code duplication.
## Demo: 

https://user-images.githubusercontent.com/55594741/233349274-9fc30370-2c56-4d40-8c8e-f6126c1d30b5.mov
