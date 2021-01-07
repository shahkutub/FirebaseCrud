package com.example.firebasecrud;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SignUpActivity extends AppCompatActivity {


    //our database reference object
    DatabaseReference databaseArtists;
    DatabaseReference databaseBakiList;

    EditText etName;
    EditText etMobile;
    EditText etPass;

    String name;
    String mobile;
    String Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        databaseArtists = FirebaseDatabase.getInstance().getReference("users");
        databaseBakiList = FirebaseDatabase.getInstance().getReference("bakilist");


        //getting views
         etName = (EditText) findViewById(R.id.etName);
         etMobile = (EditText) findViewById(R.id.etMobile);
         etPass = (EditText) findViewById(R.id.etPass);

        AppCompatButton buttonAddArtist = (AppCompatButton) findViewById(R.id.btnSignin);
        AppCompatButton btnBakiLidt = (AppCompatButton) findViewById(R.id.btnBakiLidt);

        btnBakiLidt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //addBaki();
                getBakiuser();
            }
        });


        //adding an onclicklistener to button
        buttonAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //checkUser("");
                name = etName.getText().toString().trim();
                mobile = etMobile.getText().toString().trim();
                Pass = etPass.getText().toString().trim();
                if(TextUtils.isEmpty(name)){

                }else if(TextUtils.isEmpty(mobile)){

                }else if(TextUtils.isEmpty(Pass)){

                }else {
                   checkUser(mobile);

                        //addArtist();

                }


            }
        });

    }

    private void addBaki() {
       // databaseBakiList.push();
        String id = databaseBakiList.push().getKey();
        BakiUser bakiUser = new BakiUser("Ali mia","ajom pur","25300","20300",
                "5000","gazi","01723335972","12-12-2020",
                "21-01-2021");
        databaseBakiList.child("01723335973").setValue(bakiUser);

    }

    /*
     * This method is saving a new artist to the
     * Firebase Realtime Database
     * */
    private void addArtist() {

            String id = databaseArtists.push().getKey();

            //creating an Artist Object
            User artist = new User(id, name, mobile,Pass);

            //Saving the Artist
            databaseArtists.child(mobile).setValue(artist);


            //databaseArtists.setValue(artist);

            Toast.makeText(this, "User Created", Toast.LENGTH_LONG).show();
            startActivity(new Intent(this,SignInActivity.class));

    }

    private void checkUser(String mobile) {

        //getting the specified artist reference

        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("users").child(mobile);
        List<User> universityList = new ArrayList<>();
        dR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                User user = snapshot.getValue(User.class);

                if(user !=null){
                        Toast.makeText(SignUpActivity.this, "User Exist", Toast.LENGTH_SHORT).show();

                }else {
                    addArtist();

                }


                //System.out.println("Author: " + newPost.get("userMobile:"));

//                universityList.clear();
//                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
//                    User university = postSnapshot.getValue(User.class);
//                    universityList.add(university);
//                    for (int i = 0; i <universityList.size() ; i++) {
//                        if(mobile.equalsIgnoreCase(universityList.get(i).getUserMobile())){
//                            Toast.makeText(SignUpActivity.this, "User Exist", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                    }
//                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });


    }

    public void getBaki(View view) {

        //getBakiuser();
    }

    private void getBakiuser() {

        DatabaseReference dR = FirebaseDatabase.getInstance().getReference("bakilist").child("01723335973");
        List<User> universityList = new ArrayList<>();
        dR.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                BakiUser user = snapshot.getValue(BakiUser.class);

                if(user !=null){
                    Toast.makeText(SignUpActivity.this, "User Exist: "+user.getName(), Toast.LENGTH_SHORT).show();

                }else {
                    addBaki();

                }


                //System.out.println("Author: " + newPost.get("userMobile:"));

//                universityList.clear();
//                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
//                    User university = postSnapshot.getValue(User.class);
//                    universityList.add(university);
//                    for (int i = 0; i <universityList.size() ; i++) {
//                        if(mobile.equalsIgnoreCase(universityList.get(i).getUserMobile())){
//                            Toast.makeText(SignUpActivity.this, "User Exist", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                    }
//                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });
    }
}