package com.example.room_theme.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "theme_prefs")

object ThemePreferences {
    private val THEME_KEY = stringPreferencesKey("selected_theme")

    suspend fun saveTheme(context: Context, theme: String) {
        context.dataStore.edit { prefs ->
            prefs[THEME_KEY] = theme
        }
    }

    fun getTheme(context: Context): Flow<String?> {
        return context.dataStore.data.map { prefs ->
            prefs[THEME_KEY]
        }
    }
}