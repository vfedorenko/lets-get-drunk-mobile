package by.vfedorenko.letsgetdrunk.entities

import by.vfedorenko.letsgetdrunk.presentation.App
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 08.11.16.
 */
data class Event(@Expose(serialize = false)
                 var id: Long = App.NO_ID,
                 var title: String = App.EMPTY_STRING,
                 var description: String = App.EMPTY_STRING,
                 @SerializedName("image")
                 var imageUrl: String = App.EMPTY_STRING,
                 @Expose(serialize = false)
                 @SerializedName("updated_at")
                 var lastUpdate: String = App.EMPTY_STRING,
                 @Expose(serialize = false)
                 var creator: User = User(),
                 @Expose(serialize = false)
                 var users: List<User> = listOf(),
                 @Expose(deserialize = false)
                 @SerializedName("user_ids")
                 var userIds: List<Long> = listOf(),
                 @Transient var localImage: String = App.EMPTY_STRING)

