# Disher

A very simple recipe / dish list app for Android.

## If you are coming here from YouTube

Then you will want to select the `live-stream` branch. That is where all the code that I have done during the live streams lives!

<hr>

## Contributing

This app is currently a work in progress and was started during my YouTube Live Stream (First Video Here: https://www.youtube.com/watch?v=MpYRRB3nLSU)

**HOWEVER** I want to enable others to get involved with this project and contribute to this codebase, maybe as part of Hacktoberfest or simply to get your hands dirty in a MODERN android codebase.

Anyone and everyone is welcome to contribute. If you would like to contribute then please check the `issues` tab above and I will make sure to update a list of potential "Things-to-do" and label them correctly.

**Side Note:** For anyone that is worried that this might affect my future upcoming live streams, where I will continue to work on this repository, then please do NOT fear, I have branched away from the `main` branch and created a branch called `live-stream` that only I will be able to update, however when you contribute you can make your PR and point it directly at `main` and I will simply work happily and separately on my stream on my little isolated branch... *(p.s. thank you for worrying about me)*

## Important things to note

The aim of this app is to be a proper, professional, modern & clean app. That means that my branch `live-stream` will always attempt to keep strictly to the MVVM (clean) architecture pattern however, this does not HAVE TO be the same in the `main` branch.

Feel free to code however you like and if you would like, I will happily give you feedback in order to help you learn if you would like it...

# Progress & API

So the app relies upon the excellent `mealdb` API that provides the caller with different food-based information.

For this project the basic idea is to have 3 screens:
* The List of Food Categories screen (Done in Stream #1) [`CategoryScreen`]
* The List of Dishes in a category screen (Not Started)
* The Individual Dish Detail screen (Not Started)

The idea was for the first screen to be the `CategoryScreen` and there the user will see a list of food categories, then the user can click one of these categories and be taken to the `List of dishes screen` where they will see a different list of all the dishes that exist in that category. Finally, the user can click one of these dishes to bring up the 3rd screen `Dish detail screen` and see information about the specific dish, how to cook it, ingredients, image etc...

For each screen there is a different end point on the mealdb api, these are as follows:
* `CategoryScreen` - www.themealdb.com/api/json/v1/1/categories.php - [DONE]
* `List of dishes screen` - www.themealdb.com/api/json/v1/1/filter.php?c=____ - [TODO]
* `Dish detail screen` - www.themealdb.com/api/json/v1/1/lookup.php?i=_____ - [TODO]

Where you see underscores above (____) this is where missing information needs to go, this information will be decided on what the user clicks as part of their journey.
For the `filter` api there we need the name of a category and for the `lookup` api there we need a unique dish id.

# What next

Well really simple... Go check the `issues` tab if you want to get involved.

In the future, if you want a build of this app then you will have two choices...

1. A community open source version of the app, which will hopefully have been built by many contributors. For that version, you need to use the `main` branch.
2. A version built solely by me, that was built during the YouTube live streams. For that version, you need to use the `live-stream` branch.

Good Luck! You got this, give it a go, literally nothing can go wrong!
BK
