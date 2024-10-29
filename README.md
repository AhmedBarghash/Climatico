# ّThe App: Weather Now & Later
This is  modularized Android application that fetches and displays current weather as well as a  7-day forecast for a given city.
Functional Requirements:
1. Allow users to input a city name.
2. Display the current weather for that city including temperature, condition (e.g.,
   cloudy, sunny, rainy), and an appropriate icon.
3. Display a 7-day forecast in a list with the same details.
4. Store the last searched city name and display its weather data when the app is
   reopened.

## 📄 Project Structure Description

com.developerx.climatico                   # ROOT PACKAGE
│
├── App
├────graph                              # Navigation folder for screens And NavHost.
|   │   ├── AppGraph                    # Composable Function have the Implementation for the NavHost.
|   │   ├── ScreensConstants            # Sealed Class for the Routes in the application.

├────features                           # Screen list
|   │   ├── done                        # Folder for all ui composable components to the success screen.
|   │   ├── orderverification           # Folder for all ui composable components to the order verification ui screen and view model
|   │   ├── otp                         # Folder for all UI composables components to the OTP UI screen and view model
├── ui.
|   │   ├── theme                       # THEME FOLDER
|   │   │   ├── Color                   # Color palette used by the app.
|   │   │   ├── Theme                   # Theme used by the app.
|   │   │   ├── Type                    # Typography styles for the fonts used by the app.
├──── MainActivity                      # The main activity has the entry point for the app and has a function that handles selected images from another app saves the app ID for the application that shares this image and compares it to the authorisedApplicationId in the InstaPlusConstants
├──── InstaPlusApplication              # Application
├── Base-Android                        # Module for base classes MVI design pattern and for creating a singleton data manager object that has one instant from shared preferences and encrypted it.
├── Core                                # Module for network layer that has one instance from retrofit object share among the application and has the extensions
├── features                            # Module to locate the data and domain layer per features
├──── selected-city-weather-broadcast             
|   │   ├── selected-city-weather-broadcast-data           # Folder contains all the API call and data layer for the current selected city Weather broadcast and 7-day forecast either local or remote
|   │   ├── selected-city-weather-broadcast-domain         # Folder contains all the use case for this feature and the repository and Use cases to access the data layer
|   │   ├── selected-city-weather-broadcast-ui             # Folder contains all the compose view and Viewmodel that will communicate with use-case
├──── Search History                     
|   │   ├── otp-domain                 # Folder contains the socket manager for this feature as there is no endpoint.

├── models                              # Module that has all the POJO for the project and the InstaPlusConstants that have all the constants in the project
The project is a multiple Gradle module known as a multi-module project. As you can see we have a future Package that includes a module.

Every module has its own network and data layer **data-module** that has a shared domain among the app like another normal app,
at first and then will change the base URL for the endpoint in run time **domain-module** (for the use case as we use a clean Architecture).

- app
- base-android
- core
- features
- models


## 📚 Package Structure

```
Comming Soon

```

## Installation
- Install **Android Studio Jellyfish | 2023.3.1 Patch 2** or higher
- Run the App with Android version 9 or higher.
- Make sure to install the SDK tool for a Smoother creation.
- Set / change in the **build-gradle(module-app)** the **secretKey**
- The project is using libs.version.toml to save all the lib for Android or third-party library source

##  🛠️ Built with

- Kotlin version "1.9.23"
- Jetpack Compose version "1.6.5" or Higher
- hilt "2.49"

## Support
In case there is help needed for the map Implementation using compose communicate with me through ahmed.osama.barghsh@gmail.com, happy to help anytime.
