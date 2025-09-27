package com.asha.ehr.data

import androidx.compose.runtime.Immutable

@Immutable
data class Patient(
    val id: String,
    val name: String,
    val age: Int,
    val gender: String,
    val phone: String,
    val address: String,
    val village: String,
    val lastVisit: String,
    val nextAppointment: String? = null,
    val healthStatus: String = "Normal",
    val assignedAshaWorker: String = "ASHA Worker 1"
)

@Immutable
data class Visit(
    val id: String,
    val patientId: String,
    val patientName: String,
    val date: String,
    val purpose: String,
    val symptoms: String,
    val diagnosis: String,
    val treatment: String,
    val followUpRequired: Boolean = false,
    val followUpDate: String? = null
)

@Immutable
data class Reminder(
    val id: String,
    val patientId: String,
    val patientName: String,
    val type: String, // Vaccination, ANC Checkup, Follow-up
    val date: String,
    val time: String,
    val status: String = "Pending", // Pending, Completed, Overdue
    val priority: String = "Medium" // High, Medium, Low
)

@Immutable
data class SyncStatus(
    val totalRecords: Int,
    val syncedRecords: Int,
    val pendingRecords: Int,
    val lastSyncTime: String,
    val syncStatus: String // Online, Offline, Partial
)
