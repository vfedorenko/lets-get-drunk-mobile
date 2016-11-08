package by.vfedorenko.letsgetdrunk.businesslogic.utils

import android.content.SharedPreferences
import by.vfedorenko.letsgetdrunk.presentation.App
import javax.inject.Inject

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 02.11.16.
 */
class AuthorizedUserManager @Inject constructor(private val prefs: SharedPreferences) {
    companion object {
        const val NO_ID: Long = 0

        private const val KEY_MY_ID = "my_id"
        private const val KEY_TOKEN = "token"
        private const val KEY_CLIENT = "client"
        private const val KEY_UID = "uid"
        private const val KEY_IS_DEVICE_ID_SAVED = "device_id_saved"
    }

    fun saveMyId(id: Long) {
        val edit = prefs.edit()
        edit.putLong(KEY_MY_ID, id)
        edit.apply()
    }

    fun getMyId(): Long {
        return prefs.getLong(KEY_MY_ID, NO_ID)
    }

    fun saveToken(token: String) {
        val edit = prefs.edit()
        edit.putString(KEY_TOKEN, token)
        edit.apply()
    }

    fun getToken(): String {
        return prefs.getString(KEY_TOKEN, App.EMPTY_STRING)
    }

    fun saveClient(client: String) {
        val edit = prefs.edit()
        edit.putString(KEY_CLIENT, client)
        edit.apply()
    }

    fun getClient(): String {
        return prefs.getString(KEY_CLIENT, App.EMPTY_STRING)
    }

    fun saveUid(uid: String) {
        val edit = prefs.edit()
        edit.putString(KEY_UID, uid)
        edit.apply()
    }

    fun getUid(): String {
        return prefs.getString(KEY_UID, App.EMPTY_STRING)
    }

    fun isDeviceIdSaved(): Boolean {
        return prefs.getBoolean(KEY_IS_DEVICE_ID_SAVED, false)
    }

    fun setDeviceIdSaved(isSaved: Boolean) {
        val edit = prefs.edit()
        edit.putBoolean(KEY_IS_DEVICE_ID_SAVED, isSaved)
        edit.apply()
    }
}
