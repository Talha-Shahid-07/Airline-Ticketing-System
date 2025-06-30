# Airline Ticketing System

A desktop application built with Java Swing for managing airline operations, including flight management, user and airline registration, booking, and administrative tasks. This system provides distinct interfaces for users, airline representatives, and administrators, showcasing modular design and database integration.

## 🌟 Features

### User Module
- **User Registration & Login**: Securely register and log in to access services.
- **Search Flights**: Find one-way or round-trip flights by departure and arrival cities.
- **View Available Flights**: Browse all available flights in the system.
- **Book Flights**: Book flights using flight number and username.
- **View Booked Flights**: Display all flights booked by a specific user.

### Airline Module
- **Airline Registration & Login**: Register airline details and log in to manage operations.
- **Add Flights**: Add new flights with details like flight number, type, cities, class, price, dates, and seat capacity.
- **Update Flights**: Modify existing flight details using the flight number.
- **Cancel Flights**: Remove flights from the system.
- **View Available Flights**: List all flights currently available.

### Admin Module
- **Admin Login**: Secure access for system administrators.
- **Remove Airlines**: Delete registered airline accounts from the database.
- **Remove Users**: Delete user accounts from the database.
- **View Available Flights**: Monitor all flights in the system.

## 🛠️ Technologies Used
- **Programming Language**: Java
- **GUI Framework**: Java Swing
- **Database Connectivity**: JDBC (Java Database Connectivity)
- **Database**: Microsoft Access (`.accdb` file)
- **JDBC Driver**: UCanAccess (for connecting Java to Access database)

## 🚀 Setup and Installation

### Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher.
- **UCanAccess JDBC Driver**: Download the latest UCanAccess JAR file and its dependencies (commons-lang, commons-logging, HSQLDB, Jackcess) from [UCanAccess SourceForge](https://sourceforge.net/projects/ucanaccess/files/).
- **Microsoft Access**: Optional, for viewing or modifying the database directly.

### Database Setup
1. **Database File**: The project uses a Microsoft Access database named `Information.accdb`.
2. **Location**: Update the database path in `ConnectionToDB.java`. The default path is:
   ```java
   String url = "path-to-file";
   ```
   - Place `Information.accdb` in the `src/Resources/` folder of your project.
   - Modify the `url` to match the actual file location on your system (e.g., `D:\\MyProjects\\AirlineTicketingSystem\\src\\Resources\\Information.accdb`).

### IDE Setup
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/Talha-Shahid-07/AirlineTicketingSystem.git
   cd AirlineTicketingSystem
   ```
2. **Open Project in IDE**:
   - **NetBeans**: File > Open Project > Select the `AirlineTicketingSystem` folder.
   - **IntelliJ IDEA**: File > Open > Navigate to the `AirlineTicketingSystem` folder.
   - **Eclipse**: File > Import > General > Existing Projects into Workspace > Select the `AirlineTicketingSystem` folder.
3. **Add UCanAccess Libraries**:
   - In your IDE, add the UCanAccess JAR (`ucanaccess-x.x.x.jar`) and its dependencies to the project’s classpath/libraries via project properties or build path settings.

### Running the Application
1. **Verify Database Path**: Ensure the `url` in `ConnectionToDB.java` points to the correct `Information.accdb` location.
2. **Run the Application**: Locate `AirlineTicketingSystem.java` (contains the `main` method) and run it from your IDE to launch the main application window.

## 💡 Usage
- **Start the Application**: Launch `AirlineTicketingSystem.java` to open the `MainForm` for role selection (User, Airline, Admin).
- **User Role**:
  - Register or log in.
  - Search, view, or book flights.
  - View or manage personal bookings.
- **Airline Role**:
  - Register or log in.
  - Add, update, or cancel flights.
  - View all available flights.
- **Admin Role**:
  - Log in to access administrative functions.
  - Remove users or airlines.
  - View all flights.

## 🤝 Contributing
Contributions are welcome! To contribute:
1. Fork the repository.
2. Create a new branch:
   ```bash
   git checkout -b feature/YourFeature
   ```
3. Make and commit your changes:
   ```bash
   git commit -m 'Add new feature'
   ```
4. Push to the branch:
   ```bash
   git push origin feature/YourFeature
   ```
5. Open a Pull Request on GitHub.

## 📄 License
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## 📧 Contact
For questions or support, please open an issue in the GitHub repository.

## Acknowledgments
Developed as part of an academic project at Bahria University Karachi Campus to demonstrate proficiency in Java, GUI development, and database integration.
