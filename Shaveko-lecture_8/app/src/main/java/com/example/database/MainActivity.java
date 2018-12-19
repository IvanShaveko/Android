package com.example.database;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends Activity {

    private AppDatabase db;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.context = getApplicationContext();
        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "myDB").build();
    }

    public static Context getAppContext() {
        return MainActivity.context;
    }

    public void performCreation(View view){
        CreateUserTask task = new CreateUserTask(db);
        task.execute();
    }

    private static void addUser(final AppDatabase db, User user){
        List<User> userList = db.userDao().getAll();
        System.out.println("Rows count: " + userList.size());
        db.userDao().insertUsers(user);
    }

    private void createUser(AppDatabase db) {
        User user = new User();
        TextView nameView = findViewById(R.id.name);
        TextView surnameView = findViewById(R.id.surname);
        String name = nameView.getText().toString();
        String surname = surnameView.getText().toString();
        user.setName(name);
        user.setSurname(surname);
        addUser(db, user);
    }

    private class CreateUserTask extends AsyncTask<Void,Void,Void>{
        private final AppDatabase mDb;
        CreateUserTask(AppDatabase db){
            mDb = db;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            createUser(mDb);
            return null;
        }
    }

    public void performCounting(View view){
        CountUsersTask task = new CountUsersTask(db);
        task.execute();
    }

    private void countUsers(AppDatabase db){
        final int amount = db.userDao().countUsers();
        final TextView tv = findViewById(R.id.show);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv.setText(Integer.toString(amount));
            }
        });
    }

    private class CountUsersTask extends AsyncTask<Void,Void,Void>{
        private final AppDatabase mDb;
        CountUsersTask(AppDatabase db){
            mDb = db;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            countUsers(mDb);
            return null;
        }
    }

    public void performShowing(View view){
        ShowUsersTask task = new ShowUsersTask(db);
        task.execute();
    }

    private void showUsers(AppDatabase db){
        User user;
        final StringBuilder result = new StringBuilder();
        List<User> users = db.userDao().getAll();
        final TextView tv = findViewById(R.id.show);
        tv.setText("");
        for (int i = 0; i < users.size(); i++){
            user = users.get(i);
            result.append(tv.getText()).append(user.getName()).append(" ").append(user.getSurname()).append("\n");
        }
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv.setText(result);
            }
        });
    }

    private class ShowUsersTask extends AsyncTask<Void,Void,Void>{
        private final AppDatabase mDb;
        ShowUsersTask(AppDatabase db){
            mDb = db;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            showUsers(mDb);
            return null;
        }
    }
}
