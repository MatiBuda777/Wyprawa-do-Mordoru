package com.example.wyprawadomordoru

import android.icu.util.Calendar
import android.os.Bundle
import android.widget.CheckBox
import android.widget.Chronometer
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Switch
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val characterNameEditText = findViewById<EditText>(R.id.characterName_EditText)
        val characterRaceSpinner = findViewById<Spinner>(R.id.characterRace_Spinner)
        val calendarButton = findViewById<Button>(R.id.calendarOpen_Button)
        val elvesSecretPathSwitch = findViewById<Switch>(R.id.turnOnElvesSecretPaths_Switch)
        val itemElvesCape = findViewById<CheckBox>(R.id.item_elvesCape_CheckBox)
        val itemLembases = findViewById<CheckBox>(R.id.item_lembases_CheckBox)
        val itemTorch = findViewById<CheckBox>(R.id.item_torch_CheckBox)
        val marchRadioGroup = findViewById<RadioGroup>(R.id.march_RadioGroup)
        val marchTimeSeekBar = findViewById<SeekBar>(R.id.march_time_SeekBar)
        val moralesRatingBar = findViewById<RatingBar>(R.id.morales_RatingBar)


        val characterNameTextBox = findViewById<TextView>(R.id.summary_characterName_TextBox)
        val characterRaceTextBox = findViewById<TextView>(R.id.summary_characterRace_TextBox)
        val datetimeTextBox = findViewById<TextView>(R.id.summary_datetime_TextBox)
        val elvesPathsTextBox = findViewById<TextView>(R.id.summary_elvesPaths_TextBox)
        val equipmentTextBox = findViewById<TextView>(R.id.summary_equipment_TextBox)
        val marchPriorityTextBox = findViewById<TextView>(R.id.summary_marchPriority_TextBox)
        val marchTimeTextBox = findViewById<TextView>(R.id.summary_marchTime_TextBox)
        val teamMoralesTextBox = findViewById<TextView>(R.id.summary_teamMorales_TextBox)


        val trainingChronometer = findViewById<Chronometer>(R.id.Training_Chronometer)
        val chronometerStartButton = findViewById<Button>(R.id.Chronometer_Start_Button)
        val chronometerStopButton = findViewById<Button>(R.id.Chronometer_Stop_Button)
        val chronometerResetButton = findViewById<Button>(R.id.Chronometer_Reset_Button)


        val progressBar = findViewById<ProgressBar>(R.id.countdown_ProgressBar)
        val progressBarStartButton = findViewById<Button>(R.id.startCountdown_Button)
    }
}