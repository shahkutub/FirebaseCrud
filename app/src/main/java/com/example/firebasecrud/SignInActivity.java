package com.example.firebasecrud;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SignInActivity extends AppCompatActivity {


    //our database reference object
    DatabaseReference databaseArtists;
    EditText etName;
    EditText etMobile;
    EditText etPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        databaseArtists = FirebaseDatabase.getInstance().getReference("users");

        //getting views
         etName = (EditText) findViewById(R.id.etName);
         etMobile = (EditText) findViewById(R.id.etMobile);
         etPass = (EditText) findViewById(R.id.etPass);

        AppCompatButton buttonAddArtist = (AppCompatButton) findViewById(R.id.btnSignin);



        //adding an onclicklistener to button
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = etMobile.getText().toString().trim();
                //calling the method addArtist()
                //the method is defined below
                //this method is actually performing the write operation
                updateArtist(mobile);
            }
        });

    }

    /*
     * This method is saving a new artist to the
     * Firebase Realtime Database
     * */
    private void addArtist() {
        //getting the values to save
        String name = etName.getText().toString().trim();
        String mobile = etMobile.getText().toString().trim();
        String Pass = etPass.getText().toString().trim();

        //checking if the value is provided
        if (!TextUtils.isEmpty(name)) {

            //getting a unique id using push().getKey() method
            //it will create a unique id and we will use it as the Primary Key for our Artist
            String id = databaseArtists.push().getKey();

            //creating an Artist Object
            User artist = new User(id, name, mobile,Pass);

            //Saving the Artist
            databaseArtists.child(id).setValue(artist);

            //setting edittext to blank again
           // editTextName.setText("");

            //displaying a success toast
            Toast.makeText(this, "Artist added", Toast.LENGTH_LONG).show();
        } else {
            //if the value is not given displaying a toast
            Toast.makeText(this, "Please enter a name", Toast.LENGTH_LONG).show();
        }
    }

    private boolean updateArtist(String mobile) {


        //getting the specified artist reference
        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("users");
        List<User> universityList = new ArrayList<>();
        dR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                universityList.clear();
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    User university = postSnapshot.getValue(User.class);
                    universityList.add(university);
                    for (int i = 0; i <universityList.size() ; i++) {
                        Toast.makeText(SignInActivity.this, ""+universityList.get(i).getUserMobile(), Toast.LENGTH_SHORT).show();
                    }

                    // here you can access to name property like university.name

                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
               // System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
        return true;
    }
}