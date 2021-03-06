package by.vfedorenko.letsgetdrunk.entities

import android.support.annotation.IntDef
import by.vfedorenko.letsgetdrunk.presentation.App
import com.google.gson.annotations.Expose

/**
 * @author Vlad Fedorenko <vfedo92@gmail.com> on 02.11.16.
 */
data class User(@Expose(serialize = false)
                var id: Long = App.NO_ID,
                var name: String = App.EMPTY_STRING,
                var image: String = App.EMPTY_STRING,
                @Expose(serialize = false)
                @DeliveryType
                var status: Long = STATUS_UNKNOWN) {

    companion object {
        const val STATUS_UNKNOWN = 0L
        const val STATUS_REQUEST = 1L
        const val STATUS_PENDING = 2L
        const val STATUS_FRIEND = 3L

        @IntDef(STATUS_UNKNOWN, STATUS_REQUEST, STATUS_PENDING, STATUS_FRIEND)
        @Retention(AnnotationRetention.SOURCE)
        annotation class DeliveryType
    }
}
