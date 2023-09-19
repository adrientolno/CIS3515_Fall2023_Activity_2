package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)




        /* Step 1: Populate this array */
        //val numberArray = Array Of Numbers
        val numberArray = Array(5) {
            10 * (it + 1)
        }

        /* Step 2: Create adapter to display items from array in Spinner */
        //spinner.adapter = ArrayAdapter...

        spinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,
        numberArray);


        // Step 3: Change TextView's text size to the number selected in the Spinner */
        //spinner.onItemSelectedListener = object: ...
        spinner.onItemClickListener = object: AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
               p0?.run {
                   val sizefont = numberArray[p2]?.toFloat()
                   if (sizefont != null)
                       displayTextView.textSize = sizefont

               }

            }

        }

    }
}