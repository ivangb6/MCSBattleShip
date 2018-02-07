package mcs.salazar.jesus.mcsbattleship;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by berekethaile on 2/6/18.
 */

public class MyService extends Service{

    // Write a message to the database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference mDatabaseReference = database.getReference().child("session");

    public MyService() {}

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    Query mQuery = mDatabaseReference;

    @Override
    public void onCreate() {
        super.onCreate();
        mQuery.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot child : dataSnapshot.getChildren()) {
                    Session sesh = child.getValue(Session.class);
                    String email = sesh.getNextTurn().getEmail();
                    Toast.makeText(getApplicationContext(), email, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Toast.makeText(getApplicationContext(), "Service started", Toast.LENGTH_LONG).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
