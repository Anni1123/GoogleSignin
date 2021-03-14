package com.anni.googlesignin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.widget.Button
import android.widget.Toast
import android.text.TextUtils
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.View
import com.google.firebase.database.FirebaseDatabase


class AddData : AppCompatActivity() {

    lateinit var employeeNameEdt: EditText
    lateinit var employeePhoneEdt: EditText
    lateinit var employeeAddressEdt: EditText
    lateinit var sendDatabtn: Button

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_data)
            employeeNameEdt = findViewById(R.id.idEdtEmployeeName)
            employeePhoneEdt = findViewById(R.id.idEdtEmployeePhoneNumber)
            employeeAddressEdt = findViewById(R.id.idEdtEmployeeAddress)

            sendDatabtn = findViewById(R.id.idBtnSendData)
            sendDatabtn.setOnClickListener{
                savedata();
            }
        }

    private fun savedata() {
        var name = employeeNameEdt.getText().toString();
        var phone = employeePhoneEdt.getText().toString();
        var address = employeeAddressEdt.getText().toString();

        var ref=FirebaseDatabase.getInstance().getReference("Data");
        val id=ref.push().key
        var data= Data(id.toString() ,name,address,phone)
        ref.child(id.toString()).setValue(data).addOnCanceledListener {
            Toast.makeText(applicationContext,"Uploaded Successfully",Toast.LENGTH_LONG).show()
            employeeAddressEdt.setText("")
            employeePhoneEdt.setText("")
            employeeAddressEdt.setText("")
        }

    }
}
