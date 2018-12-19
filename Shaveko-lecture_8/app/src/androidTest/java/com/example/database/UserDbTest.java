package com.example.database;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@RunWith(AndroidJUnit4.class)
public class UserDbTest {
    private UserDao mUserDao;
    private AppDatabase mDb;

    @Before
    public void createDb() {
        Context appContext = InstrumentationRegistry.getTargetContext();
        mDb = Room.inMemoryDatabaseBuilder(appContext, AppDatabase.class).build();
        mUserDao = mDb.userDao();
    }

    @After
    public void closeDb() {
        mDb.close();
    }

    @Test
    public void writeUserAndReadInList() {
        User user = new User();
        user.setName("Ivan");
        user.setSurname("Shaveka");
        mUserDao.insertUsers(user);
        List<User> users = mUserDao.getAll();
        assertThat(users.get(users.size()-1), equalTo(user));
    }
}
