# Weather Data Analyzer

## Overview
The Weather Data Analyzer is a Java-based application that reads weather data from a CSV file and provides useful insights such as:
- Calculating the average temperature for a specific month.
- Counting the number of hot days (above a given temperature).
- Counting rainy days based on precipitation levels.
- Categorizing weather conditions using Java's enhanced switch statement.

## Features
- Reads weather data from a CSV file
- Uses Java Records for efficient data storage
- Implements Lambdas & Streams for fast processing
- Uses Enhanced Switch Statements for categorization
- Provides an interactive console menu for user interaction

## Setup & Installation

1. Clone the Repository
```sh
git clone <YOUR_GITHUB_REPO_URL>
cd WeatherAnalyzer
Ensure Java 17+ is Installed
sh
Copy
Edit
java -version
If it's not Java 17+, download it from Adoptium.

Open and Run in IntelliJ IDEA
Open the project in IntelliJ IDEA.
Mark src/main/java/ as "Sources Root" if needed.
Click Run → Run 'Main'.
How to Use
Run the program
Select an option from the menu
markdown
Copy
Edit
================================
Weather Data Analyzer
================================
1. Average temperature for a month
2. Days above temperature threshold
3. Count rainy days
4. Exit
================================
Enter your choice: 
Enter the required input (e.g., enter 08 for August).
See the results!
Example Outputs
1. Average Temperature for August
sql
Copy
Edit
Enter month (MM): 08
Average temperature for month 08: 33.75°C (Hot)
2. Count of Hot Days Above 30°C
mathematica
Copy
Edit
Enter temperature threshold: 30
Days above 30.0°C: 2
3. Count of Rainy Days
yaml
Copy
Edit
Rainy days: 3
4. Exit the Program
nginx
Copy
Edit
Exiting program. Goodbye!