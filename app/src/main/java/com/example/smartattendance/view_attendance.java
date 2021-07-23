package com.example.smartattendance;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class view_attendance extends AppCompatActivity {

    private Spinner spinner1, spinner2,spinner3,spinner4;
    DatabaseReference ref;
    List<String> year;
    List<String> branch;
    List<String> class1;
    List<String> subject;
    ArrayAdapter<String> arrayAdapter1;
    ArrayAdapter<String> arrayAdapter2;
    ArrayAdapter<String> arrayAdapter3;
    ArrayAdapter<String> arrayAdapter4;
    String yearselected,branchselected,classselected,subjectselected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_attendance);


        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        spinner3 = findViewById(R.id.spinner3);
        spinner4 = findViewById(R.id.spinner4);

        year = new ArrayList<>();
        arrayAdapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, year);
        arrayAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner1.setAdapter(arrayAdapter1);

        subject = new ArrayList<>();
        arrayAdapter4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, subject);
        arrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner4.setAdapter(arrayAdapter4);

        fetchyear();

        branch=new ArrayList<>();
        arrayAdapter2=new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,branch);
        arrayAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner2.setAdapter(arrayAdapter2);
        fetchbranch();


        class1 = new ArrayList<>();
        arrayAdapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, class1);
        arrayAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner3.setAdapter(arrayAdapter3);
        fetchclass();
    }
    private void fetchbranch() {
        ref = FirebaseDatabase.getInstance().getReference().child("branch");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    branch.add(snapshot1.getValue().toString());
                    arrayAdapter2.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
    private void fetchclass() {
        ref = FirebaseDatabase.getInstance().getReference().child("class");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    class1.add(snapshot1.getValue().toString());
                    arrayAdapter3.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                classselected=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
    private void fetchyear() {
        ref = FirebaseDatabase.getInstance().getReference().child("year");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                    year.add(snapshot1.getValue().toString());
                    arrayAdapter1.notifyDataSetChanged();
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Ist")){
                    yearselected= parent.getItemAtPosition(position).toString();
                    first();
                }
                else if(parent.getItemAtPosition(position).equals("2nd")){
                    yearselected= (String) parent.getItemAtPosition(position);
                    second();
                }
                else if(parent.getItemAtPosition(position).equals("3rd")){
                    yearselected= (String) parent.getItemAtPosition(position);
                    third();
                }
                else if(parent.getItemAtPosition(position).equals("4th")){
                    yearselected= (String) parent.getItemAtPosition(position);
                    fourth();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void first(){
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Information Technology")){
                    branchselected=parent.getItemAtPosition(position).toString();
                    subject.clear();
                    ref = FirebaseDatabase.getInstance().getReference().child("IstIT");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Computer Science")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("IstCS");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Electrical")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("IstEC");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Mechanical")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("IstME");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Civil")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("IstCI");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void second(){
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Information Technology")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("2ndIT");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Computer Science")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("2ndCS");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Electrical")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("2ndEC");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Mechanical")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("2ndME");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Civil")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("2ndCI");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void third(){
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Information Technology")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("3rdIT");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Computer Science")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("3rdCS");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Electrical")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("3rdEC");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Mechanical")){
                    subject.clear();
                    ref = FirebaseDatabase.getInstance().getReference().child("3rdME");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Civil")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("3rdCI");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void fourth(){
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(parent.getItemAtPosition(position).equals("Information Technology")){
                    branchselected=parent.getItemAtPosition(position).toString();
                    subject.clear();
                    ref = FirebaseDatabase.getInstance().getReference().child("4thIT");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Computer Science")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("4thCS");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Electrical")){
                    subject.clear();
                    ref = FirebaseDatabase.getInstance().getReference().child("4thEC");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Mechanical")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("4thME");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
                else if(parent.getItemAtPosition(position).equals("Civil")){
                    subject.clear();
                    branchselected=parent.getItemAtPosition(position).toString();
                    ref = FirebaseDatabase.getInstance().getReference().child("4thCI");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {
                            for (DataSnapshot snapshot1 : snapshot.getChildren()) {
                                subject.add(snapshot1.getValue().toString());
                                arrayAdapter4.notifyDataSetChanged();
                            }

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                    spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            subjectselected=parent.getItemAtPosition(position).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    public void viewcard(View view) {

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                branchselected=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                subjectselected=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Intent intent = new Intent(this, view_card.class);
        intent.putExtra("year",yearselected);
        intent.putExtra("branch",branchselected);
        intent.putExtra("class",classselected);
        intent.putExtra("subject",subjectselected);
        startActivity(intent);
    }
}