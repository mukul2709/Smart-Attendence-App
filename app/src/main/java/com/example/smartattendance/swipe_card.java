package com.example.smartattendance;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class swipe_card extends AppCompatActivity {
    private ArrayAdapter<String> arrayAdapter;
    FirebaseUser user;
    FirebaseAuth auth;

    ArrayList<String> data1;
    SwipeFlingAdapterView flingAdapterView;
    DatabaseReference mRef,ref;
    String yearselected,branchselected,classselected,val,subjectselected;
    @RequiresApi(api=Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_card);

        auth=FirebaseAuth.getInstance();
        user=auth.getCurrentUser();
        ref=FirebaseDatabase.getInstance().getReference();
        Calendar calendar=Calendar.getInstance();
       String current_date= new SimpleDateFormat("d-M-yyyy", Locale.getDefault()).format(new Date());

        yearselected = getIntent().getExtras().getString("year");
        branchselected = getIntent().getExtras().getString("branch");
        classselected = getIntent().getExtras().getString("class");
        subjectselected=getIntent().getExtras().getString("subject");

        flingAdapterView = findViewById(R.id.swipe);
        data1 = new ArrayList<>();

        arrayAdapter = new ArrayAdapter<>(swipe_card.this, R.layout.item, R.id.student_name, data1);

        flingAdapterView.setAdapter(arrayAdapter);


        flingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener() {
            @Override
            public void removeFirstObjectInAdapter() {
                data1.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

            @Override
            public void onLeftCardExit(Object o) {
                val=(String) o;
                if(yearselected.equals("Ist") && branchselected.equals("Information Technology") && classselected.equals("1"))
                {   ref.child("IstITC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");
                }
                if(yearselected.equals("Ist") && branchselected.equals("Information Technology") && classselected.equals("2"))
                {   ref.child("IstITC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");
                }
                if(yearselected.equals("Ist") && branchselected.equals("Computer Science") && classselected.equals("1"))
                {   ref.child("IstCSC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Computer Science") && classselected.equals("2"))
                {   ref.child("IstCSC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Mechanical") && classselected.equals("1"))
                {   ref.child("IstMEC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Mechanical") && classselected.equals("2"))
                {   ref.child("IstMEC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Electrical") && classselected.equals("1"))
                {   ref.child("IstECC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Electrical") && classselected.equals("2"))
                {   ref.child("IstECC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Civil") && classselected.equals("1"))
                {   ref.child("IstCIC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Civil") && classselected.equals("2"))
                {   ref.child("IstCIC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Information Technology") && classselected.equals("1"))
                {   ref.child("2ndITC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");
                }
                if(yearselected.equals("2nd") && branchselected.equals("Information Technology") && classselected.equals("2"))
                {   ref.child("2ndITC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");
                }
                if(yearselected.equals("2nd") && branchselected.equals("Computer Science") && classselected.equals("1"))
                {   ref.child("2ndCSC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Computer Science") && classselected.equals("2"))
                {   ref.child("2ndCSC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Mechanical") && classselected.equals("1"))
                {   ref.child("2ndMEC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Mechanical") && classselected.equals("2"))
                {   ref.child("2ndMEC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Electrical") && classselected.equals("1"))
                {   ref.child("2ndECC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Electrical") && classselected.equals("2"))
                {   ref.child("2ndECC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Civil") && classselected.equals("1"))
                {   ref.child("2ndCIC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Civil") && classselected.equals("2"))
                {   ref.child("2ndCIC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Information Technology") && classselected.equals("1"))
                {   ref.child("3rdITC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");
                }
                if(yearselected.equals("3rd") && branchselected.equals("Information Technology") && classselected.equals("2"))
                {   ref.child("3rdITC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");
                }
                if(yearselected.equals("3rd") && branchselected.equals("Computer Science") && classselected.equals("1"))
                {   ref.child("3rdCSC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Computer Science") && classselected.equals("2"))
                {   ref.child("3rdCSC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Mechanical") && classselected.equals("1"))
                {   ref.child("3rdMEC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Mechanical") && classselected.equals("2"))
                {   ref.child("3rdMEC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Electrical") && classselected.equals("1"))
                {   ref.child("3rdECC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Electrical") && classselected.equals("2"))
                {   ref.child("3rdECC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Civil") && classselected.equals("1"))
                {   ref.child("3rdCIC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Civil") && classselected.equals("2"))
                {   ref.child("3rdCIC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("4th")&& branchselected.equals("Information Technology") && classselected.equals("1"))
                {
                    ref.child("4thITC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");
                }
                if(yearselected.equals("4th") && branchselected.equals("Information Technology") && classselected.equals("2"))
                {   ref.child("4thITC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");
                }
                if(yearselected.equals("4th") && branchselected.equals("Computer Science") && classselected.equals("1"))
                {   ref.child("4thCSC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("4th") && branchselected.equals("Computer Science") && classselected.equals("2"))
                {   ref.child("4thCSC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("4th") && branchselected.equals("Mechanical") && classselected.equals("1"))
                {   ref.child("4thMEC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("4th") && branchselected.equals("Mechanical") && classselected.equals("2"))
                {   ref.child("4thMEC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("4th") && branchselected.equals("Electrical") && classselected.equals("1"))
                {   ref.child("4thECC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("4th") && branchselected.equals("Electrical") && classselected.equals("2"))
                {   ref.child("4thECC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("4th") && branchselected.equals("Civil") && classselected.equals("1"))
                {   ref.child("4thCIC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }
                if(yearselected.equals("4th") && branchselected.equals("Civil") && classselected.equals("2"))
                {   ref.child("4thCIC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Absent");

                }

                Toast.makeText(swipe_card.this, "absent "+val, Toast.LENGTH_SHORT).show();
            }

                    @Override
            public void onRightCardExit(Object o) {
                val=(String) o;
                if(yearselected.equals("Ist") && branchselected.equals("Information Technology") && classselected.equals("1"))
                {   ref.child("IstITC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");
                }
                if(yearselected.equals("Ist") && branchselected.equals("Information Technology") && classselected.equals("2"))
                {   ref.child("IstITC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");
                }
                if(yearselected.equals("Ist") && branchselected.equals("Computer Science") && classselected.equals("1"))
                {   ref.child("IstCSC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Computer Science") && classselected.equals("2"))
                {   ref.child("IstCSC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Mechanical") && classselected.equals("1"))
                {   ref.child("IstMEC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Mechanical") && classselected.equals("2"))
                {   ref.child("IstMEC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Electrical") && classselected.equals("1"))
                {   ref.child("IstECC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Electrical") && classselected.equals("2"))
                {   ref.child("IstECC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Civil") && classselected.equals("1"))
                {   ref.child("IstCIC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("Ist") && branchselected.equals("Civil") && classselected.equals("2"))
                {   ref.child("IstCIC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Information Technology") && classselected.equals("1"))
                {   ref.child("2ndITC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");
                }
                if(yearselected.equals("2nd") && branchselected.equals("Information Technology") && classselected.equals("2"))
                {   ref.child("2ndITC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");
                }
                if(yearselected.equals("2nd") && branchselected.equals("Computer Science") && classselected.equals("1"))
                {   ref.child("2ndCSC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Computer Science") && classselected.equals("2"))
                {   ref.child("2ndCSC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Mechanical") && classselected.equals("1"))
                {   ref.child("2ndMEC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Mechanical") && classselected.equals("2"))
                {   ref.child("2ndMEC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Electrical") && classselected.equals("1"))
                {   ref.child("2ndECC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Electrical") && classselected.equals("2"))
                {   ref.child("2ndECC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Civil") && classselected.equals("1"))
                {   ref.child("2ndCIC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("2nd") && branchselected.equals("Civil") && classselected.equals("2"))
                {   ref.child("2ndCIC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Information Technology") && classselected.equals("1"))
                {   ref.child("3rdITC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");
                }
                if(yearselected.equals("3rd") && branchselected.equals("Information Technology") && classselected.equals("2"))
                {   ref.child("3rdITC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");
                }
                if(yearselected.equals("3rd") && branchselected.equals("Computer Science") && classselected.equals("1"))
                {   ref.child("3rdCSC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Computer Science") && classselected.equals("2"))
                {   ref.child("3rdCSC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Mechanical") && classselected.equals("1"))
                {   ref.child("3rdMEC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Mechanical") && classselected.equals("2"))
                {   ref.child("3rdMEC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Electrical") && classselected.equals("1"))
                {   ref.child("3rdECC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Electrical") && classselected.equals("2"))
                {   ref.child("3rdECC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Civil") && classselected.equals("1"))
                {   ref.child("3rdCIC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("3rd") && branchselected.equals("Civil") && classselected.equals("2"))
                {   ref.child("3rdCIC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("4th")&& branchselected.equals("Information Technology") && classselected.equals("1"))
                {
                    ref.child("4thITC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");
                }
                if(yearselected.equals("4th") && branchselected.equals("Information Technology") && classselected.equals("2"))
                {   ref.child("4thITC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");
                }
                if(yearselected.equals("4th") && branchselected.equals("Computer Science") && classselected.equals("1"))
                {   ref.child("4thCSC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("4th") && branchselected.equals("Computer Science") && classselected.equals("2"))
                {   ref.child("4thCSC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("4th") && branchselected.equals("Mechanical") && classselected.equals("1"))
                {   ref.child("4thMEC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("4th") && branchselected.equals("Mechanical") && classselected.equals("2"))
                {   ref.child("4thMEC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("4th") && branchselected.equals("Electrical") && classselected.equals("1"))
                {   ref.child("4thECC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("4th") && branchselected.equals("Electrical") && classselected.equals("2"))
                {   ref.child("4thECC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("4th") && branchselected.equals("Civil") && classselected.equals("1"))
                {   ref.child("4thCIC1Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }
                if(yearselected.equals("4th") && branchselected.equals("Civil") && classselected.equals("2"))
                {   ref.child("4thCIC2Attendance").child(subjectselected).child(current_date).child(val).setValue("Present");

                }

                        Toast.makeText(swipe_card.this, "present " + val, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int i) {

            }

            @Override
            public void onScroll(float v) {

            }
        });
        flingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener() {
            @Override
            public void onItemClicked(int i, Object o) {
                Toast.makeText(swipe_card.this, "Student is " + data1.get(i), Toast.LENGTH_SHORT).show();
            }
        });

        Button Present, Absent;
        Present = findViewById(R.id.present);
        Absent = findViewById(R.id.absent);

        Present.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingAdapterView.getTopCardListener().selectRight();
            }
        });

        Absent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flingAdapterView.getTopCardListener().selectLeft();
            }
        });
        if(yearselected.equals("Ist") && branchselected.equals("Information Technology") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("IstITC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);

                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }

            });
        }
        if(yearselected.equals("Ist") && branchselected.equals("Information Technology") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("IstITC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);

                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("Ist") && branchselected.equals("Computer Science") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("IstCSC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("Ist") && branchselected.equals("Computer Science") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("IstCSC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("Ist") && branchselected.equals("Mechanical") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("IstMEC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("Ist") && branchselected.equals("Electrical") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("IstECC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("Ist") && branchselected.equals("Electrical") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("IstECC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("Ist") && branchselected.equals("Civil") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("IstCIC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("Ist") && branchselected.equals("Civil") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("IstCIC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("2nd") && branchselected.equals("Information Technology") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("2ndITC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("2nd") && branchselected.equals("Information Technology") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("2ndITC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("2nd") && branchselected.equals("Computer Science") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("2ndCSC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("2nd") && branchselected.equals("Computer Science") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("2ndCSC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("2nd") && branchselected.equals("Mechanical") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("2ndMEC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("2nd") && branchselected.equals("Mechanical") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("2ndMEC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("2nd") && branchselected.equals("Electrical") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("2ndECC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("2nd") && branchselected.equals("Electrical") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("2ndECC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("2nd") && branchselected.equals("Civil") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("2ndCIC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("2nd") && branchselected.equals("Civil") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("2ndCIC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("3rd") && branchselected.equals("Information Technology") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("3rdITC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("3rd") && branchselected.equals("Information Technology") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("3rdITC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("3rd") && branchselected.equals("Computer Science") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("3rdCSC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("3rd") && branchselected.equals("Computer Science") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("3rdCSC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("3rd") && branchselected.equals("Mechanical") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("3rdMEC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("3rd") && branchselected.equals("Mechanical") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("3rdMEC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("3rd") && branchselected.equals("Electrical") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("3rdECC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("3rd") && branchselected.equals("Electrical") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("3rdECC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("3rd") && branchselected.equals("Civil") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("3rdCIC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("3rd") && branchselected.equals("Civil") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("3rdCIC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("4th") && branchselected.equals("Information Technology") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("4thITC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                //    arrayAdapter1.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("4th") && branchselected.equals("Information Technology") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("4thITC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("4th") && branchselected.equals("Computer Science") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("4thCSC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("4th") && branchselected.equals("Computer Science") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("4thCSC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("4th") && branchselected.equals("Mechanical") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("4thMEC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("4th") && branchselected.equals("Mechanical") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("4thMEC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String value = snapshot.getValue(String.class);
                    data1.add(value);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("4th") && branchselected.equals("Electrical") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("4thECC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name + rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("4th") && branchselected.equals("Electrical") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("4thECC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("4th") && branchselected.equals("Civil") && classselected.equals("1"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("4thCIC1Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }
        if(yearselected.equals("4th") && branchselected.equals("Civil") && classselected.equals("2"))
        {
            mRef = FirebaseDatabase.getInstance().getReference().child("4thCIC2Students");
            mRef.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    String name = snapshot.child("name").getValue(String.class);
                    String rollno=snapshot.child("roll").getValue().toString();
                    String show=name +" "+ rollno;
                    data1.add(show);
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                    arrayAdapter.notifyDataSetChanged();
                }
                @Override
                public void onChildRemoved(@NonNull DataSnapshot snapshot) {
                }
                @Override
                public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                }
                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                }
            });
        }


    }
    public void homebutton(View view1)
    {
        Intent intent = new Intent(this, faculty_next.class);
        startActivity(intent);
    }

}

