package com.example.wyprawadomordoru

import android.icu.util.Calendar
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.Chronometer
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.RadioGroup
import android.widget.RatingBar
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material3.Button
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private var characterRaces = arrayOf(
        "Człowiek",
        "Elf",
        "Krasnolud",
        "Hobbit",
        "Ork",
        "Goblin",
        "Ent",
        "Troll",
        "Nazgûl",
        "Maiar",
        "Balrog",
        "Uruk-hai",
        "Smok"
    )
    private var ChronometerRunning = false
    private var ChronometerPauseOffset: Long = 0

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
        val characterNameTextBox = findViewById<TextView>(R.id.summary_characterName_TextBox)
        characterNameEditText.setOnClickListener {
            characterNameTextBox.text = "Imię: ${characterNameEditText.text}"
        }


        val characterRaceSpinner = findViewById<Spinner>(R.id.characterRace_Spinner)
        val characterRaceTextBox = findViewById<TextView>(R.id.summary_characterRace_TextBox)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, characterRaces)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        characterRaceSpinner.adapter = adapter
        characterRaceSpinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                characterRaceTextBox.text = "Rasa: ${characterRaces[position]}"
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }


        val calendarButton = findViewById<Button>(R.id.calendarOpen_Button)
        val datetimeTextBox = findViewById<TextView>(R.id.summary_datetime_TextBox)

        val elvesPathsSwitch = findViewById<Switch>(R.id.turnOnElvesSecretPaths_Switch)
        val elvesPathsTextBox = findViewById<TextView>(R.id.summary_elvesPaths_TextBox)
        elvesPathsSwitch.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                elvesPathsSwitch.text = "Tak"
                elvesPathsTextBox.text = "Ścieżki elfów włączone"
            }
            if (!isChecked) {
                elvesPathsSwitch.text = "Nie"
                elvesPathsTextBox.text = "Ścieżki elfów wyłączone"
            }
        }

        val itemElvesCape = findViewById<CheckBox>(R.id.item_elvesCape_CheckBox)
        val itemLembases = findViewById<CheckBox>(R.id.item_lembases_CheckBox)
        val itemTorch = findViewById<CheckBox>(R.id.item_torch_CheckBox)
        val marchRadioGroup = findViewById<RadioGroup>(R.id.march_RadioGroup)
        val marchTimeSeekBar = findViewById<SeekBar>(R.id.march_time_SeekBar)
        val moralesRatingBar = findViewById<RatingBar>(R.id.morales_RatingBar)



        val equipmentTextBox = findViewById<TextView>(R.id.summary_equipment_TextBox)
        val marchPriorityTextBox = findViewById<TextView>(R.id.summary_marchPriority_TextBox)
        val marchTimeTextBox = findViewById<TextView>(R.id.summary_marchTime_TextBox)
        val teamMoralesTextBox = findViewById<TextView>(R.id.summary_teamMorales_TextBox)




        val chronometer = findViewById<Chronometer>(R.id.Training_Chronometer)
        val chronometerStartButton = findViewById<Button>(R.id.Chronometer_Start_Button)
        val chronometerStopButton = findViewById<Button>(R.id.Chronometer_Stop_Button)
        val chronometerResetButton = findViewById<Button>(R.id.Chronometer_Reset_Button)

        chronometerStartButton.setOnClickListener {
            if (!ChronometerRunning) {
                chronometer.base = SystemClock.elapsedRealtime() - ChronometerPauseOffset
                chronometer.start()
                ChronometerRunning = true
            }
        }
        chronometerStopButton.setOnClickListener {
            if (ChronometerRunning) {
                ChronometerPauseOffset = SystemClock.elapsedRealtime() - chronometer.base
                chronometer.stop()
                ChronometerRunning = false
            }
        }
        chronometerResetButton.setOnClickListener {
            chronometer.base = SystemClock.elapsedRealtime()
            chronometer.stop()
            ChronometerPauseOffset = 0
            ChronometerRunning = false
        }


        val progressBar = findViewById<ProgressBar>(R.id.countdown_ProgressBar)
        val progressBarStartButton = findViewById<Button>(R.id.startCountdown_Button)
    }
}