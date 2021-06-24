package app.beer.fifi.models.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.beer.fifi.models.BaseModelResponse

data class UserResponse(
    var name: String
) : BaseModelResponse()

@Entity(tableName = "users")
data class LocalUser(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val name: String = "",
    val nickName: String = "",
    val avatar: String = "",
    val last_name: String = "",
    val email: String = "",
    val birthday: String = "",
    val city: String = "",
    val interests: String = "",
    val biography: String = "",
    val link_to_site: String = "",
    val is_verified: Int = 0,
    val lat: Int = 0,
    val lng: Int = 0
)
