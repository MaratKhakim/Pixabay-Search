# Pixabay Search Clean Architecture Multi-module Android app

This project is an example of implementing Pixabay API for searching and retrieving free images.
The app contains two screens: search images and image details. A user can search for images by typing on the search input and can see image details by clicking on an image card.
The app can be used without Internet connection, the previous results are cached.

# Getting Started
Download this repository and replace "YOUR_API_KEY" with a Pixabay API key in base-module.gradle

# Architecture
MVVM + Clean Architecture. Each feature has their own layers (if required): domain, data and presentation.

# Modularization
Feature and layer based modules
- app
- core
  - common
  - ui
- search
    - search-data
    - search-domain
    - search-presentation
- details
    - details-presentation

# Tech Stack:
 - Kotlin
 - Coroutines + Flow
 - Jetpack Compose
 - Retrofit
 - Coil
 - Moshi
 - Room
 - Hilt
 - Paging
 - Junit
 - Mockk

# Screenshots
<img src="https://github.com/MaratKhakim/Pixabay-Search/blob/master/screenshots/1.png" width="200"
hspace="10" vspace="10">
<img src="https://github.com/MaratKhakim/Pixabay-Search/blob/master/screenshots/2.png" width="200"
hspace="10" vspace="10">
<img src="https://github.com/MaratKhakim/Pixabay-Search/blob/master/screenshots/4.png" width="200"
hspace="10" vspace="10">
<img src="https://github.com/MaratKhakim/Pixabay-Search/blob/master/screenshots/3.png" width="600"
hspace="10" vspace="10">