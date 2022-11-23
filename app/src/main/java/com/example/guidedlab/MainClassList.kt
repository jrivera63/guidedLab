package com.example.guidedlab

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainClassList : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_class_list)

        val swDegreeCert = findViewById<Switch>(R.id.idSwitch)
        val spnDegree = findViewById<Spinner>(R.id.spinMajors)
        val btnNext = findViewById<Button>(R.id.idBtnNext)
        val spnCert = findViewById<Spinner>(R.id.spinCerts)
        val txtMajor = findViewById<TextView>(R.id.idLblMajor)
        val txtCert = findViewById<TextView>(R.id.idLblCert)

        val month = findViewById<Spinner>(R.id.idMonths)
        val days = findViewById<EditText>(R.id.idDay)
        val year = findViewById<EditText>(R.id.idYear)

        val firstName = findViewById<EditText>(R.id.idFirst)
        val lastName = findViewById<EditText>(R.id.idLast)
        val phone = findViewById<EditText>(R.id.idPhone)

        firstName.requestFocus()

        swDegreeCert.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                spnDegree.visibility = View.VISIBLE
                txtMajor.visibility = View.VISIBLE
                spnCert.visibility = View.GONE
                txtCert.visibility - View.GONE
            } else {
                spnDegree.visibility = View.GONE
                txtMajor.visibility = View.GONE
                spnCert.visibility = View.VISIBLE
                txtCert.visibility - View.VISIBLE
            }
        }

        btnNext.setOnClickListener {
            if (checkData()) {
                var doBirth = ""
                doBirth =
                    month.selectedItem.toString() + "/" + days.text.toString() + "/" + year.text.toString()

                val nextScreen = Intent(this@MainClassList, ChooseClass::class.java)
                nextScreen.putExtra("FirstName", firstName.text.toString())
                nextScreen.putExtra("LastName", lastName.text.toString())
                nextScreen.putExtra("Phone", phone.text.toString())
                nextScreen.putExtra("Birthday", doBirth)
                nextScreen.putExtra("FirstName", firstName.text.toString())

                if (spnDegree.visibility == View.VISIBLE) {
                    nextScreen.putExtra("isDegreeCert", "Degree")
                    nextScreen.putExtra("Degree", spnDegree.selectedItem.toString())
                } else {
                    nextScreen.putExtra("isDegreeCert", "Certificate")
                    nextScreen.putExtra("Certificate", spnCert.selectedItem.toString())
                }

                startActivity(nextScreen)
            }
        }
    }
    private fun checkData(): Boolean{
                val days = findViewById<EditText>(R.id.idDay)
                val year = findViewById<EditText>(R.id.idYear)

                val firstName = findViewById<EditText>(R.id.idFirst)
                val lastName = findViewById<EditText>(R.id.idLast)
                val phone = findViewById<EditText>(R.id.idPhone)

                if (firstName.text.isEmpty()){
                    firstName.error = "Invalid First Name"
                    firstName.requestFocus()
                    return false
                }

                if (lastName.text.isEmpty()){
                    lastName.error = "Invalid Last Name"
                    lastName.requestFocus()
                    return false
                }

                if (phone.text.isEmpty()){
                    phone.error = "Invalid Phone Number"
                    phone.requestFocus()
                    return false
                }

                if (days.text.isEmpty()){
                    days.error = "Invalid Day of Birth"
                    days.requestFocus()
                    return false
                }

                if (year.text.isEmpty()){
                    year.error = "Invalid Year of Birth"
                    year.requestFocus()
                    return false
                }

                return true
        }
    }
