package com.example.smartattendance;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Calendar;


public class view_card extends AppCompatActivity {
    EditText etdate;
    DatePickerDialog.OnDateSetListener setListener;
    String yearselected,branchselected,classselected,subjectselected;
    private ListView mListView;
    ArrayList<String> list;
    ArrayAdapter<String > adapter;
    DatabaseReference reference;
    String date;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_card);
        mListView = (ListView) findViewById(R.id.list_view);
        list = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        mListView.setAdapter(adapter);
        yearselected = getIntent().getExtras().getString("year");
        branchselected = getIntent().getExtras().getString("branch");
        classselected = getIntent().getExtras().getString("class");
        subjectselected = getIntent().getExtras().getString("subject");


        etdate = findViewById(R.id.et_date);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        etdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(view_card.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month + 1;
                        date = day + "-" + month + "-" + year;
                        // String date = new SimpleDateFormat("dd-MM-yyyy").format(calendar.getTime());
                        etdate.setText(date);
                        // etdate.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));


                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        Button button1;
        button1 = findViewById(R.id.next);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.clear();
                if (yearselected.equals("3rd") ) {
                    if (branchselected.equals("Information Technology")) {
                        if (classselected.equals("1")) {
                            reference = FirebaseDatabase.getInstance().getReference().child("3rdITC1Attendance").child(subjectselected).child(date);
                            reference.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                                    String key = snapshot.getKey();
                                    String value = snapshot.getValue(String.class);
                                    String add = key + "  " + value + " " + date;
                                    list.add(add);
                                    adapter.notifyDataSetChanged();
                                }

                                @Override
                                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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
                    else if(branchselected.equals("Electrical"))
                    {
                        if(classselected.equals("1"))
                        {
                            reference = FirebaseDatabase.getInstance().getReference().child("3rdECC1Attendance").child(subjectselected).child(date);
                            reference.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                                    String key = snapshot.getKey();
                                    String value = snapshot.getValue(String.class);
                                    String add = key + "  " + value + " " + date;
                                    list.add(add);
                                    adapter.notifyDataSetChanged();
                                }

                                @Override
                                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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
                }
                else if(yearselected.equals("2nd"))
                {
                    if(branchselected.equals("Information Technology"))
                    {
                        if(classselected.equals("2"))
                        {
                            reference = FirebaseDatabase.getInstance().getReference().child("2ndITC2Attendance").child(subjectselected).child(date);
                            reference.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                                    String key = snapshot.getKey();
                                    String value = snapshot.getValue(String.class);
                                    String add = key + "  " + value + " " + date;
                                    list.add(add);
                                    adapter.notifyDataSetChanged();
                                }

                                @Override
                                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

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
                }
                else if(yearselected.equals("4th"))
                {
                    if(branchselected.equals("Information Technology"))
                    {
                        if(classselected.equals("2"))
                        {
                            reference = FirebaseDatabase.getInstance().getReference().child("4thITC2Attendance").child(subjectselected).child(date);
                            reference.addChildEventListener(new ChildEventListener() {
                                @Override
                                public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                                    String key = snapshot.getKey();
                                    String value = snapshot.getValue(String.class);
                                    String add = key + "  " + value + " " + date;
                                    list.add(add);
                                    adapter.notifyDataSetChanged();
                                }

                                @Override
                                public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
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
                }
            }
        });
    }
}