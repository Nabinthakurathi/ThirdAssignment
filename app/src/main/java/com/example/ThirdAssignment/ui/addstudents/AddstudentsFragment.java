package com.example.ThirdAssignment.ui.addstudents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wbv.R;
import com.example.ThirdAssignment.model.Students;

import java.util.ArrayList;
import java.util.List;

public class AddstudentsFragment extends Fragment {

    private RecyclerView recyclerViewhome;
    private EditText etName, etAge, etAddress;
    private RadioGroup rgGender;
    private RadioButton rbMale, rbFemale, rbOthers;
    private Button btnSave;
    private String addStudentName, addStudentAge, addStudentAddress, addStudentGender;
    private int profilePic;
    private static List<Students> studentsList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, final Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_addstudents, container, false);
        etName = root.findViewById(R.id.etName);
        etAge = root.findViewById(R.id.etAge);
        etAddress = root.findViewById(R.id.etAddress);
        rgGender = root.findViewById(R.id.rgGender);
        rbMale = root.findViewById(R.id.rbMale);
        rbFemale = root.findViewById(R.id.rbFemale);
        rbOthers = root.findViewById(R.id.rbOthers);
        btnSave = root.findViewById(R.id.btnSave);
        recyclerViewhome = root.findViewById(R.id.recyclerView);

        final int[] img = {R.drawable.maleimg, R.drawable.femaleimg, R.drawable.noimg};


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!etName.getText().toString().isEmpty()) {
                    addStudentName = etName.getText().toString();
                    if (!etAge.getText().toString().isEmpty()) {
                        addStudentAge = (etAge.getText().toString());
                        if (!etAddress.getText().toString().isEmpty()) {
                            addStudentAddress = (etAddress.getText().toString());
                            try {
                                int selectGender = rgGender.getCheckedRadioButtonId();
                                RadioButton radioButton = root.findViewById(selectGender);
                                addStudentGender = radioButton.getText().toString();
                                if (addStudentGender.equals("Male")) {
                                    profilePic = img[0];
                                } else if (addStudentGender.equals("Female")) {
                                    profilePic = img[1];
                                } else {
                                    profilePic = img[2];
                                }

                                Students students = new Students(addStudentName, addStudentAddress, addStudentGender, addStudentAge, profilePic);
                                studentsList = students.getStudentsList();
                                studentsList.add(students);
                                students.setStudentsList(studentsList);
                                Toast.makeText(getActivity(), "Student added", Toast.LENGTH_LONG).show();
                                etName.getText().clear();
                                etAge.getText().clear();
                                etAddress.getText().clear();
                                rgGender.clearCheck();
//                                for testing
//                                Toast.makeText(getActivity(), " "+addStudentName+" "+ addStudentAge+" "+addStudentGender+" "+addStudentAddress+" "+profilePic, Toast.LENGTH_LONG).show();
                            } catch (Exception e) {
                                Toast.makeText(getActivity(), "Please select gender", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            etAddress.setError("Address required");
                        }
                    } else {
                        etAge.setError("Age required");
                    }
                } else {
                    etName.setError("Name required");
                }
            }
        });
        return root;
    }
}