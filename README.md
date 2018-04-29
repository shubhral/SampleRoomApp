# SampleRoomApp

My attempt to create a sample app to demonstrate the new persistance library - Room introduced by Google as part of android architecture components. The purpose was just to test out the library, so I'm not using proper package structure (just used 2 packages - model & ui) although it follows MVVM architecture pattern where the view is interacting with the viewModel which in turn is interacting with the repository(single source of truth for data) to interact with the data from the database. 

# Working

The app consists of 2 screens - 
1. Screen which shows list of tasks added
2. Screen to add a new task

# Todo
1. Reorder functionality
2. Edit existing task
3. Delete task
