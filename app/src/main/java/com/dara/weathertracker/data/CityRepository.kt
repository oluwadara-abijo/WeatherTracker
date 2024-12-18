package com.dara.weathertracker.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject


class CityRepository @Inject constructor(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")
        private val SELECTED_CITY = stringPreferencesKey("selected_city")
    }

    suspend fun saveSelectedCity(value: String) {
        context.dataStore.edit { preferences ->
            preferences[SELECTED_CITY] = value
        }
    }

    val selectedCity: Flow<String?> = context.dataStore.data.map { preferences ->
        preferences[SELECTED_CITY]
    }
}
