# CP3405  Assignment 1 and Assignment 2

I use miro board to do and store [scrum artifacts](https://miro.com/app/board/o9J_lA2-Lck=/) such as:

Two Product backlog

Burndown chart

Velocity chart

Daily Stand up

Team retrospective 

Committed hours and focus factor, velocity 

<br />

## Scrum Report And Presenation on Scrum

This is Group B1 [Scrum Report](https://docs.google.com/document/d/1ljeTd45wb6Sv6PPzmzh9rSooItRPeFx67xR4QZ6773U/edit?usp=sharing) and [Presenation](https://docs.google.com/presentation/d/1pk9e4DdihuqVPYs9wDCbNOHoHGVAg1e8/edit?usp=sharing&ouid=106273584563257056793&rtpof=true&sd=true)

<br />

## To run the app

You would first need to download android studio with this link: https://developer.android.com/studio?gclid=CjwKCAjwy7CKBhBMEiwA0Eb7atJ6tre3ZYgZRXF42p2Be1jvKdYEpmaXDTeNtNX57GDOD8oLAwNIsxoCcnwQAvD_BwE&gclsrc=aw.ds

You need to clone or download the source code from the branch named Clement's_branch. After cloning the source code, open it in android studio and click trust the project. You will also have to download a virtual device using the AVD manager in android studio to run the app. I used the pixel 3XL API 30. This branch has all the screens linked together and also the app works.

Igore the other three branches those are separate for transaction and budget screens.

If you face any issues running the project please contact me on Discord @Senko#1882

# Expen$o 📊

A simple Expense Tracker App 📱 built to help users with their financial needs. *Made by [CP3405 Group B1](https://github.com/id8lab/scrum-project-assignment-1-and-assignment-2-group_b1-sp52)*

<br />

# UI Design

***Click to View Expen$o app Design from below 👇***

[![Expen$o](https://img.shields.io/badge/Expen$o-FIGMA-black.svg?style=for-the-badge&logo=figma)](https://www.figma.com/file/luxbpmWrc6qDtRVazLEbpt/CP3405-Group-B1-Assignment-1?node-id=2301%3A1213)

<br />

## All Transaction Screens 
|View Transaction|Add Transation|Transaction Details|Edit Transaction|All Income| All Expense|
|----            |----          |----               |----            |----      |-----       |
|![View Transaction](https://user-images.githubusercontent.com/68360382/134280310-8af52c38-5058-4804-b851-c74dea4c64fd.png)|![Add Budget](https://user-images.githubusercontent.com/68360382/134280415-0db61c8c-0dde-42fe-8c29-cdf846cbadc8.png)|![Details](https://user-images.githubusercontent.com/68360382/134281914-db34f818-dfbb-4fe6-b62a-1eac0cc1d916.png)|![Edit Transaction](https://user-images.githubusercontent.com/68360382/134282922-0756fffc-4c7d-4e27-b557-52b54481a49e.png)|![  View Income](https://user-images.githubusercontent.com/68360382/134282426-c086a13f-d9ae-455c-aed0-23dac9857ca0.png)|![View Expense](https://user-images.githubusercontent.com/68360382/134282679-e2527def-a2b0-4aff-93ad-d8355a40b391.png)|

<br/>

## All Budget Screens

|View Budget Not done|Add Budget|Edit Budget|
|----                |----      |-----      |
|![View Budget](https://user-images.githubusercontent.com/68360382/134468880-7ac71d6d-d83a-45d7-8615-d94322c79d0b.png)|![Add Budget](https://user-images.githubusercontent.com/68360382/134286006-f57d221f-1002-49d7-87af-872135f18c28.png)|![Edit Budget](https://user-images.githubusercontent.com/68360382/134329512-dd691e99-dfd4-4896-a2fe-90b0cc21d28b.png)|

<br />

## About Screen
|About Us|
|----    |
|![About](https://user-images.githubusercontent.com/68360382/134286111-0e906620-8c08-4ad0-858b-96277fb818b0.png)|

<br />

## Demo of Expen$o App

https://user-images.githubusercontent.com/68360382/134453201-d8afe10b-5cff-4d1e-8f46-06eb3cc072e9.mov

<br />

## Built With 🛠
- [Kotlin](https://kotlinlang.org/) - First class and official programming language for Android development.
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - For asynchronous and more..
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [Stateflow](https://developer.android.com/kotlin/flow/stateflow-and-sharedflow) - StateFlow is a state-holder observable flow that emits the current and new state updates to its collectors. 
  - [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html) - A flow is an asynchronous version of a Sequence, a type of collection whose values are lazily produced.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - SQLite object mapping library.
  - [Jetpack Navigation](https://developer.android.com/guide/navigation) - Navigation refers to the interactions that allow users to navigate across, into, and back out from the different pieces of content within your app
  - [DataStore](https://developer.android.com/topic/libraries/architecture/datastore) - Jetpack DataStore is a data storage solution that allows you to store key-value pairs or typed objects with protocol buffers. DataStore uses Kotlin coroutines and Flow to store data asynchronously, consistently, and transactionally.
- [Material Components for Android](https://github.com/material-components/material-components-android) - Modular and customizable Material Design UI components for Android.
- [Figma](https://figma.com/) - Figma is a vector graphics editor and prototyping tool which is primarily web-based.
- [Miro Board](https://miro.com) -  Miro board is an online whiteboard that you can use to visualize your ideas, work on projects either individually or with a team.
<br />

## Package Structure 📦
    
    com.cp3405b1.expensetrackerapp  # Root Package
    ├── di                          # Hilt DI Modules 
    ├── data                        # For data handling.
    │   ├── local                   # Local Persistence Database. Room (SQLite) database
    |   │   ├── dao                 # Data Access Object for Room   
    |   |   |── database            # Database Instance
    |
    ├── model                       # Model classes [Transaction]
    |
    |-- repo                        # Used to handle all data operations
    |
    ├── view                        # Activity/Fragment View layer
    │   ├── main                    # Main root folder
    |   │   ├── main                # Main Activity for RecyclerView
    |   │   └── viewmodel           # Transaction ViewModel
    |   │   ├── adapter             # Adapter for RecyclerView
    │   ├── Dashboard               # Dashboard root folder
    |   |   |__ dashboard           # view Transaction
    │   ├── Add                     # Add Transaction root folder
    |   |   |__ add                 # Add Transaction 
    │   ├── Edit                    # Edit Transaction root folder
    |   |   |__ edit                # Edit Transaction
    │   ├── Details                 # Details root folder
    |   |   |__ details             # Transaction Details
    │   ├── About                   # About root folder
    |   |   |__ about               # About 
    │   ├── Dialog                  # All Dialogs root folder
    |   |   |__ dialog              # Error Dialog 
    |   |__budget                   # Budget root folder
    |   |  |__Addbudget             # Add Budget
    |   |  |__Editbudget            # Edit Budget
    |   |  |__listAdpater           # List of Budgets
    |   |  |__listBudget            # Shows the list adapter 
    ├── utils                       # All extension functions                  
    |__Budget                       # Budget root folder
    |   |  |__budget                # Creates budget table
    |   |  |__budgetdao             # Access to budget data for Room
    |   |  |__budgetdatabase        # Stores data from creatation of budgets
    |   |  |__budgetrepository      # Use to handle all budget data operations
    |   |  |__budgetviewmodel        # BudgetViewModel
    
<br />

## Build-tool 🧰
You need to have [Android Studio Beta 3 or above](https://developer.android.com/studio/preview) to build this project.
![Unknown](https://user-images.githubusercontent.com/68360382/134287561-30eff22f-4507-4d11-ab70-3caaaf54191d.png)

<br>

## Contact Us📩
Have an project? DM us at 👇

Keashyn Naidoo - keashyn.naidoo@my.jcu.edu.au

<br>

## License 🔖
```
    Apache 2.0 License


    Copyright 2021 CP3405  

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
