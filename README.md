# Weather Tracker

This project is an Android weather application built using Kotlin, Jetpack Compose, and clean architecture. It allows users to search for a city, display its current weather information, and persist the selected city across app launches.

## Features

* **Home Screen:** Displays weather information for a saved city, including temperature, condition, humidity, UV index, and "feels like" temperature.
* **Search Functionality:** Allows users to search for cities and view their weather details.
* **City Persistence:** Saves the selected city using DataStore for retrieval on app launch.
* **Error Handling:** Gracefully handles API errors and network connectivity issues.
* **Clean Architecture:** Follows MVVM architecture with modular and testable code.
* **Dependency Injection:** Utilizes dependency injection using Hilt for managing dependencies.

## Setup Instructions

1. **Clone the repository:**
[git clone https://github.com/oluwadara-abijo/WeatherTracker.git](https://github.com/oluwadara-abijo/WeatherTracker.git)

2. **Open the project in Android Studio:**
   - Import the project into Android Studio.

3. **Obtain a WeatherAPI.com API Key:**
   - Create a free account on [WeatherAPI.com](https://www.weatherapi.com/) and obtain an API key.

4. **Configure API Key:**
   - Create a file named `local.properties` in the root directory of your project.
   - Add the following line to the file, replacing `YOUR_API_KEY` with your actual API key:

5. **Build the project:**
   - Build the project by clicking "Build" -> "Make Project" or using the keyboard shortcut (usually Ctrl+F9 or Cmd+F9).

6. **Run the app:**
   - Run the app on an emulator or a physical device by clicking "Run" -> "Run 'app'" or using the keyboard shortcut (usually Shift+F10).

## Usage

1. **Search for a city:**
   - Enter the city name in the search bar and tap the search icon.
   - Select a city from the search results.

2. **View weather information:**
   - The home screen will display the current weather information for the selected city.

3. **Persist city selection:**
   - The selected city will be saved and automatically loaded when the app is launched again.

## Dependencies

* Kotlin
* Jetpack Compose
* Hilt/Koin (Dependency Injection)
* Retrofit (Networking)
* DataStore/SharedPreferences (Local Storage)
* WeatherAPI.com API

## Contributing

Contributions are welcome! Please feel free to open issues or pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Disclaimer

This project was created as part of an Android take-home test and may not be fully production-ready. It is intended to demonstrate the developer's skills and understanding of Android development principles.
