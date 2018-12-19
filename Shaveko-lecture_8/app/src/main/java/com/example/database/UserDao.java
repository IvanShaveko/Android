package com.example.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAll();

    @Query("SELECT * FROM users WHERE uid IN (:userIds)")
    List<User> getUsersByIds(int[] userIds);

    @Query("SELECT COUNT(*) FROM users")
    int countUsers();

    @Insert
    void insertUsers(User... user);

    @Delete
    void deleteUser(User user);
}
