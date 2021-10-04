package com.ezatpanah.alertdialogscomplete

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    private var selectedRadioItem = -1
    private var selectedList = booleanArrayOf(false, false, false, false)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun showCheckmarkList(view: View?) {

        val fruits = arrayOf("Orange", "Banana", "Watermelon", "Grapefruit")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Checkmark List")
        builder.setMultiChoiceItems(fruits, selectedList,
            DialogInterface.OnMultiChoiceClickListener {
                    dialog, which, isChecked ->
                //4
                selectedList.set(which, isChecked)
                Toast.makeText(applicationContext, fruits[which],
                    Toast.LENGTH_SHORT).show()
            })
        builder.setPositiveButton("Ok") {
                dialog, which ->
            dialog.dismiss()
        }
        builder.show()
    }



    fun showTraditionalListDialog(view: View?) {
        val hobbies = arrayOf("VideoGames", "Reading", "Sports", "Movies")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Traditonal List")
        builder.setItems(hobbies, DialogInterface.OnClickListener { dialog, which ->

            Toast.makeText(applicationContext, hobbies[which], Toast.LENGTH_SHORT).show()
        })
        builder.show()


    }

    fun showRadioButtonListDialog(view: View?) {
        val cities = arrayOf("New York", "London", "Hong Kong", "Río")
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Radio Button List")
        builder.setSingleChoiceItems(cities, selectedRadioItem, DialogInterface.OnClickListener {
                dialog, which ->
            selectedRadioItem = which
            Toast.makeText(applicationContext, cities[which], Toast.LENGTH_SHORT).show()
        })
        builder.setPositiveButton("OK") {
                dialog, which ->
            dialog.dismiss()
        }
        builder.show()

    }


    fun showBasicDialog(view: View?) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Alert")
        builder.setMessage("The body of my alert")
        builder.setPositiveButton("Yes") { dialog, which ->
            Toast.makeText(applicationContext, "Yes", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { dialog, which ->
            Toast.makeText(applicationContext, "No", Toast.LENGTH_SHORT).show()
        }
        builder.setNeutralButton("Maybe") { dialog, which ->
            Toast.makeText(applicationContext, "Maybe", Toast.LENGTH_SHORT).show()
        }
        builder.show()
    }

}