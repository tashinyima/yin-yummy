package com.example.yinyummy.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class User(

    @ColumnInfo(name = "family_name") val familyName: String?,
    @ColumnInfo(name = "given_name") val givenName: String?,
    @ColumnInfo(name = "email") val email: String,
    @ColumnInfo(name = "username") val username: String,
    @ColumnInfo(name = "imageProfilePath") var imageProfilePath: String?,
    @PrimaryKey(autoGenerate = true) val uid: Int = 0

) {
    constructor() : this("", "", "", "", "",0 )

}

