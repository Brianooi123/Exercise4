package com.example.exercise4

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.DatePicker
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var cal = Calendar.getInstance()
        var currentDate = Calendar.getInstance()

        val dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(
                view: DatePicker, year: Int, monthOfYear: Int,
                dayOfMonth: Int
            ) {
                cal.set(year,monthOfYear,dayOfMonth)

                val age =  currentDate.get(Calendar.YEAR) - cal.get(Calendar.YEAR)

                textView1.setText("Age: " + age)

                var minSaving:Int
                if(age in 16..20)
                    minSaving=5000
                else if(age in 21..25)
                    minSaving=14000
                else if(age in 26..30)
                    minSaving=29000
                else if(age in 31..35)
                    minSaving=50000
                else if(age in 36..40)
                    minSaving=78000
                else if(age in 41..45)
                    minSaving=116000
                else if(age in 46..50)
                    minSaving=165000
                else if(age in 51..55)
                    minSaving=228000
                else
                    minSaving=0

                textView2.setText("Min Saving: RM"+minSaving)

            }

        }
        btnDate.setOnClickListener{
            // Creates the date picker dialog when user clicks on the EditText field
            val datePickerDialog = DatePickerDialog(this, dateSetListener, cal.get(Calendar.YEAR), cal.get(
                Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show()


        }
    }
}