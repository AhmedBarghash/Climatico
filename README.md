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
