package com.iznan.remote.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.iznan.domain.irepository.IDataStoreRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class DataStoreRepository @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : IDataStoreRepository {

    private val COIN_NAME = stringPreferencesKey("coin_name")

    override suspend fun saveDataCoin(coinName: String) {
        dataStore.edit {
            it[COIN_NAME] = coinName
        }
    }

    override fun getDataCoin(): Flow<String> = dataStore.data.map {
        it[COIN_NAME] ?: ""
    }
}