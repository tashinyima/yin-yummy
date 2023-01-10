package com.example.yinyummy.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
data class RegisteryEntry {
    @PrimaryKey val uID: Int,
    @ColumnInfo(name = "family_name") val familyName: String?,
    @ColumnInfo(name = "given_name") val givenName: String?,
    @ColumnInfo(name = "email") val email: String?,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "password") val password: String?
}
