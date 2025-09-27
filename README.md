# EHR Companion

A lightweight Android mobile application designed for ASHA workers and PHC staff in rural India, focused on managing electronic health records (EHR) in low or no-internet environments.

## 🏥 App Overview

- **Name**: EHR Companion
- **Platform**: Android (Kotlin + Jetpack Compose)
- **Theme**: Blue and Pink (soothing and healthcare-oriented)
- **Architecture**: Offline-first with automatic synchronization
- **Target Users**: ASHA Workers, PHC Staff, Healthcare Administrators

## ✨ Core Features

### 🔒 **Offline-First Architecture**
- Patient data securely stored locally using SQLite
- Works seamlessly without internet connectivity
- Automatic data synchronization when connection is restored

### 🎤 **Voice Input Support**
- Voice-to-text functionality for data entry
- Supports patient details, symptoms, and notes
- Reduces typing effort for field workers

### 🌐 **Multilingual Support**
- Supports 4 Indian languages: English, Hindi, Tamil, Telugu
- Easy language switching in settings
- Localized UI elements and content

### 🔔 **Smart Reminders**
- Vaccination schedule reminders
- ANC (Antenatal Care) check-up alerts
- Follow-up visit notifications
- Priority-based reminder system

### 👥 **Role-Based Dashboards**
- **ASHA Workers**: View assigned patients, add visit data, manage reminders
- **PHC Staff**: Access complete EHRs, review synced data, analytics dashboard
- **Admin**: System management and user administration

### 🔐 **Data Security**
- End-to-end encryption for sensitive data
- Secure local storage using Android Keystore
- Encrypted shared preferences for app settings

### 🔄 **Auto-Sync Mechanism**
- Background synchronization with remote servers
- Conflict resolution for offline/online data
- Sync status monitoring and error handling

## 🎨 UI/UX Design

### Color Palette
- **Primary Blue**: #1976D2 (Professional, trustworthy)
- **Accent Pink**: #E91E63 (Healthcare, caring)
- **Supporting Colors**: White, Grey for contrast
- **Status Colors**: Green (success), Red (error), Orange (warning)

### Design Principles
- Large buttons and touch targets for easy interaction
- Minimal text with clear icons
- Optimized for low-end Android devices
- Intuitive navigation with role-based access

## 🏗️ Technical Architecture

### **Tech Stack**
- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM with Repository pattern
- **Dependency Injection**: Hilt
- **Database**: Room (SQLite)
- **Networking**: Retrofit + OkHttp
- **Background Tasks**: WorkManager
- **Security**: Android Security Crypto

### **Key Components**

#### Data Layer
- `AshaEhrDatabase`: Room database with entities for Users, Patients, Visits, Reminders
- `Repository`: Centralized data access layer
- `DAO`: Data Access Objects for each entity

#### UI Layer
- `MainActivity`: Entry point with navigation
- `Screens`: Compose-based UI screens for all features
- `Theme`: Custom Material 3 theme with blue/pink colors
- `Navigation`: Type-safe navigation with role-based routing

#### Business Logic
- `VoiceInputManager`: Handles speech recognition
- `EncryptionManager`: Manages data encryption/decryption
- `SyncService`: Background sync operations
- `LocalizationManager`: Multilingual support

## 📱 Screens Overview

### 1. **Login Screen**
- Username/password authentication
- Demo login buttons for ASHA Worker and PHC Staff
- Role-based navigation

### 2. **Dashboard**
- Quick stats cards (Total Patients, Pending Visits, Reminders)
- Quick action buttons for common tasks
- Role-specific content and permissions

### 3. **Patient Management**
- Patient list with search and filtering
- Patient registration form with voice input
- Patient details with visit history
- Contact information and demographics

### 4. **Visit Entry**
- Comprehensive visit recording form
- Voice input for symptoms and notes
- Vital signs capture
- Treatment and medication tracking

### 5. **Reminders**
- Priority-based reminder list
- Filter by type and priority
- Mark as completed functionality
- Due date tracking

### 6. **Sync Status**
- Real-time sync status monitoring
- Connection status indicator
- Sync history and error logs
- Manual sync trigger

### 7. **Settings**
- Language selection
- Notification preferences
- Voice input settings
- Data management options

## 🔧 Setup Instructions

### Prerequisites
- Android Studio Arctic Fox or later
- Android SDK 24+ (Android 7.0)
- Kotlin 1.9.10+
- Gradle 8.1.4+

### Installation
1. Clone the repository
2. Open in Android Studio
3. Sync Gradle files
4. Build and run on device/emulator

### Permissions Required
- `RECORD_AUDIO`: For voice input functionality
- `INTERNET`: For data synchronization
- `ACCESS_NETWORK_STATE`: For connectivity monitoring
- `POST_NOTIFICATIONS`: For reminder notifications

## 🚀 Key Features Implementation

### Offline Storage
```kotlin
// Room database entities
@Entity(tableName = "patients")
data class Patient(
    @PrimaryKey val id: String,
    val name: String,
    val age: Int,
    val gender: Gender,
    // ... other fields
    val isSynced: Boolean = false
)
```

### Voice Input
```kotlin
// Voice input integration
class VoiceInputManager @Inject constructor(
    @ApplicationContext private val context: Context
) {
    fun startListening() {
        // Speech recognition implementation
    }
}
```

### Data Encryption
```kotlin
// Secure data storage
class EncryptionManager @Inject constructor(
    private val context: Context
) {
    fun encryptData(data: String): String {
        // AES encryption implementation
    }
}
```

### Auto-Sync
```kotlin
// Background sync service
@AndroidEntryPoint
class SyncService : Service() {
    private suspend fun performSync() {
        // Sync implementation
    }
}
```

## 🌍 Multilingual Support

The app supports multiple Indian languages:
- **English**: Default language
- **Hindi**: हिंदी
- **Tamil**: தமிழ்  
- **Telugu**: తెలుగు

Language switching is available in Settings with real-time UI updates.

## 🔒 Security Features

- **Data Encryption**: All sensitive data encrypted using Android Keystore
- **Secure Storage**: Encrypted SharedPreferences for app settings
- **Permission Management**: Granular permission handling
- **Data Validation**: Input validation and sanitization

## 📊 Data Models

### Core Entities
- **User**: ASHA workers, PHC staff, administrators
- **Patient**: Demographics, contact info, medical history
- **Visit**: Visit details, symptoms, diagnosis, treatment
- **Reminder**: Vaccination schedules, check-ups, follow-ups
- **SyncLog**: Synchronization history and status

## 🔄 Sync Strategy

1. **Offline First**: All data stored locally
2. **Incremental Sync**: Only changed records synchronized
3. **Conflict Resolution**: Server-side conflict resolution
4. **Retry Logic**: Automatic retry on sync failures
5. **Status Monitoring**: Real-time sync status updates

## 🎯 Target Use Cases

### For ASHA Workers
- Register new patients in the field
- Record home visits and check-ups
- Set vaccination reminders
- Access patient history offline

### For PHC Staff
- Review comprehensive patient records
- Monitor sync status and data quality
- Generate reports and analytics
- Manage user accounts and permissions

## 🚧 Future Enhancements

- Integration with national health programs (Ayushman Bharat, RCH Portal)
- Advanced analytics and reporting
- Telemedicine capabilities
- Offline map integration for field visits
- Barcode/QR code scanning for patient identification
- Photo capture for medical records

## 📄 License

This project is developed for healthcare purposes in rural India. Please ensure compliance with local healthcare data regulations and privacy laws.

## 🤝 Contributing

This is a healthcare application designed for ASHA workers and PHC staff. Contributions should focus on:
- Improving offline functionality
- Enhancing voice input accuracy
- Adding more regional language support
- Optimizing for low-end devices
- Strengthening data security

## 📞 Support

For technical support or feature requests related to this EHR Companion app, please contact the development team.

---

**EHR Companion** - Empowering healthcare workers in rural India with technology that works offline and understands local needs.
