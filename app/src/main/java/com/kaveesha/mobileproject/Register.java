package com.kaveesha.mobileproject;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Register extends AppCompatActivity {

    private EditText editTextRegisterFullName,editTextRegisterEmail,editTextRegisterDoB,editTextRegisterMobile,
            editTextRegisterPassword,editTextRegisterConfirmPassword;
    private ProgressBar progressBar;
    private RadioGroup radioGroupRegisterGender;
    private RadioButton radioButtonRegisterGenderSelected;
    private static final String TAG="Register";
    private DatePickerDialog picker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        getSupportActionBar().setTitle("Register");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toast.makeText(Register.this,"You can Register Now",Toast.LENGTH_LONG).show();

        progressBar=findViewById(R.id.progressBar);
        editTextRegisterFullName=findViewById(R.id.editText_register_full_name);
        editTextRegisterEmail=findViewById(R.id.editText_register_email);
        editTextRegisterDoB=findViewById(R.id.editText_register_dob);
        editTextRegisterMobile=findViewById(R.id.editText_register_mobile);
        editTextRegisterPassword=findViewById(R.id.editText_register_password);
        editTextRegisterConfirmPassword=findViewById(R.id.editText_register_confirm_password);


        //Radio button gender
        radioGroupRegisterGender=findViewById(R.id.radio_group_register_gender);
        radioGroupRegisterGender.clearCheck();

        //Setting up DatePicker on edittext
        editTextRegisterDoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month= calendar.get(Calendar.DAY_OF_MONTH);
                int year= calendar.get(Calendar.YEAR);

                //date picker dialog
                picker = new DatePickerDialog(Register.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        editTextRegisterDoB.setText(dayOfMonth+"/"+(month+1)+"/"+year);

                    }
                },year, month, day);
                picker.show();

            }
        });

        Button buttonRegister = findViewById(R.id.button_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selectedGenderId = radioGroupRegisterGender.getCheckedRadioButtonId();
                radioButtonRegisterGenderSelected = findViewById(selectedGenderId);

                //Obtain the entered data
                String textFullName = editTextRegisterFullName.getText().toString();
                String textEmail = editTextRegisterEmail.getText().toString();
                String textDoB = editTextRegisterDoB.getText().toString();
                String textMobile = editTextRegisterMobile.getText().toString();
                String textPwd = editTextRegisterPassword.getText().toString();
                String textConfirmPwd = editTextRegisterConfirmPassword.getText().toString();
                String textGender; // can't obtain the value before verifying if any button was selected or not


                //validate mobile number using Matcher and pattern (Regular Expression)
                String mobileRegex="[0-9]";
                Matcher mobileMatcher;
                Pattern mobilePattern= Pattern.compile(mobileRegex);
                mobileMatcher = mobilePattern.matcher(textMobile);


                if (TextUtils.isEmpty(textFullName)) {
                    Toast.makeText(Register.this, "Please Enter your full name", Toast.LENGTH_LONG).show();
                    editTextRegisterFullName.setError("Full Name is Required");
                    editTextRegisterFullName.requestFocus();

                } else if (TextUtils.isEmpty(textEmail)) {
                    Toast.makeText(Register.this, "Please Enter your Email", Toast.LENGTH_LONG).show();
                    editTextRegisterEmail.setError("Email is Required");
                    editTextRegisterEmail.requestFocus();

                } else if (!Patterns.EMAIL_ADDRESS.matcher(textEmail).matches()) {
                    Toast.makeText(Register.this, "Please re -enter your Email", Toast.LENGTH_LONG).show();
                    editTextRegisterEmail.setError("Valid Email is Required");
                    editTextRegisterEmail.requestFocus();
                } else if (TextUtils.isEmpty(textDoB)) {
                    Toast.makeText(Register.this, "Please Enter Your Date of Birth", Toast.LENGTH_LONG).show();
                    editTextRegisterDoB.setError("Date of Birth is Required");
                    editTextRegisterDoB.requestFocus();

                } else if (radioGroupRegisterGender.getCheckedRadioButtonId() == -1) {
                    Toast.makeText(Register.this, "Please Select Your Gender", Toast.LENGTH_LONG).show();
                    radioButtonRegisterGenderSelected.setError("Gender is Required");
                    radioButtonRegisterGenderSelected.requestFocus();
                } else if (TextUtils.isEmpty(textMobile)) {
                    Toast.makeText(Register.this, "Please Enter Your Mobile", Toast.LENGTH_LONG).show();
                    editTextRegisterMobile.setError("Mobile No is Required");
                    editTextRegisterMobile.requestFocus();
                } else if (textMobile.length() != 10){
                    Toast.makeText(Register.this, "Please re-enter Your Mobile No", Toast.LENGTH_LONG).show();
                    editTextRegisterMobile.setError("Mobile No is should be 10 digits");
                    editTextRegisterMobile.requestFocus();
                }else if(!mobileMatcher.find()) {
                    Toast.makeText(Register.this, "Please re-enter Your Mobile No", Toast.LENGTH_LONG).show();
                    editTextRegisterMobile.setError("Mobile No is not valid");
                    editTextRegisterMobile.requestFocus();


                }else if (TextUtils.isEmpty(textPwd)) {
                    Toast.makeText(Register.this, "Please Enter Your Password", Toast.LENGTH_LONG).show();
                    editTextRegisterPassword.setError("Password is Required");
                    editTextRegisterPassword.requestFocus();
                } else if(textPwd.length()<6){
                    Toast.makeText(Register.this, "Password should be at least 6 digits", Toast.LENGTH_LONG).show();
                    editTextRegisterPassword.setError("Password too weak");
                    editTextRegisterPassword.requestFocus();

                }else if (TextUtils.isEmpty(textConfirmPwd)){
                    Toast.makeText(Register.this, "Please Enter Confirm Your Password", Toast.LENGTH_LONG).show();
                    editTextRegisterConfirmPassword.setError("Password confirmation is required");
                    editTextRegisterConfirmPassword.requestFocus();
                }else if(!textPwd.equals(textConfirmPwd)){
                    Toast.makeText(Register.this, "Please Enter same Password", Toast.LENGTH_LONG).show();
                    editTextRegisterConfirmPassword.setError("Password is Confirmation is Required");
                    editTextRegisterConfirmPassword.requestFocus();

                    //clear the enter passwords
                    editTextRegisterPassword.clearComposingText();
                    editTextRegisterConfirmPassword.clearComposingText();

                }else{
                    textGender=radioButtonRegisterGenderSelected.getText().toString();
                    progressBar.setVisibility(View.VISIBLE);

                    registerUser(textFullName,textEmail,textDoB,textGender,textMobile,textPwd);
                    
                }

            }
        });


    }
    // Register user using the credentials given
    private void registerUser(String textFullName, String textEmail, String textDob, String textGender, String textMobile, String textPwd) {
        FirebaseAuth auth= FirebaseAuth.getInstance();

        //Create user Profile
        auth.createUserWithEmailAndPassword(textEmail,textPwd).addOnCompleteListener(Register.this,
                new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){

                            FirebaseUser firebaseUser=auth.getCurrentUser();

                            //update display name of user
                            UserProfileChangeRequest profileChangeRequest = new UserProfileChangeRequest.Builder().setDisplayName(textFullName).build();
                            firebaseUser.updateProfile(profileChangeRequest);


                            //Enter user data in to the firebase realtime database
                            ReadWriteUserDetails writeUserDetails = new ReadWriteUserDetails(textDob,textGender,textMobile);

                            //Extracting user reference from database for "Register users"
                            DatabaseReference referenceProfile= FirebaseDatabase.getInstance().getReference("Registered Users");

                            referenceProfile.child(firebaseUser.getUid()).setValue(writeUserDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if (task.isSuccessful()){

                                        //send verification Email
                                        firebaseUser.sendEmailVerification();
                                        Toast.makeText(Register.this,"User Registered Successfully,Please verify your email ",Toast.LENGTH_LONG).show();

                                      //open user profile after successful registration

                                        Intent intent= new Intent(Register.this,UserProfileActivity.class);

                                      //To prevent user from returning back to Register Activity on pressing back button after registration
                                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_CLEAR_TASK |Intent.FLAG_ACTIVITY_NEW_TASK);
                                        startActivity(intent);
                                        finish(); // to close register activity

                                    }else{
                                        Toast.makeText(Register.this,"User Registered failed,Please try again",Toast.LENGTH_LONG).show();


                                    }
                                    //hide progressBar whether user creation is successful or failed
                                    progressBar.setVisibility(View.GONE);


                                }
                            });


                        }else {
                            try{
                                throw task.getException();

                            }catch (FirebaseAuthWeakPasswordException e){
                                editTextRegisterPassword.setError("Your password is too week,Kindly use a mix of alphabets,numbers and special characters");
                                editTextRegisterPassword.requestFocus();

                            }catch (FirebaseAuthInvalidUserException e){
                                editTextRegisterPassword.setError("Your email is invalid or already in use, kindly re - enter.");
                                editTextRegisterPassword.requestFocus();
                            }catch (FirebaseAuthUserCollisionException e){
                                editTextRegisterPassword.setError("user is  already registered with this email, use another email");
                                editTextRegisterPassword.requestFocus();
                            }catch (Exception e){
                                Log.e(TAG,e.getMessage());
                                Toast.makeText(Register.this,e.getMessage(),Toast.LENGTH_LONG).show();


                            }
                            //hide progressBar whether user creation is successful or failed
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
    }
}