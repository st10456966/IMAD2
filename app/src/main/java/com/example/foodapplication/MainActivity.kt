package com.example.foodapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var timeInput: EditText
    private lateinit var suggestButton: Button
    private lateinit var resetButton: Button
    private lateinit var suggestionText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timeInput = findViewById(R.id.timeInput)
        suggestButton = findViewById(R.id.suggestButton)
        resetButton = findViewById(R.id.resetButton)
        suggestionText = findViewById(R.id.suggestionText)

        suggestButton.setOnClickListener { suggestMeal() }
        resetButton.setOnClickListener { resetFields() }
    }

    private fun suggestMeal() {
        val timeOfDay = timeInput.text.toString().trim().toLowerCase()
        var mealSuggestion: String

        if (timeOfDay == "morning") {
            mealSuggestion = "Breakfast: Eggs, Pancakes, or Oatmeal."
        } else if (timeOfDay == "mid-morning") {
            mealSuggestion = "Light Snack: Fruit, Yogurt, or Smoothie."
        } else if (timeOfDay == "afternoon") {
            mealSuggestion = "Lunch: Sandwich, Salad, or Sushi."
        } else if (timeOfDay == "afternoon snack") {
            mealSuggestion = "Quick Bites: Cake, Nuts, or a Granola Bar."
        } else if (timeOfDay == "dinner") {
            mealSuggestion = "Main Course: Pasta, Grilled Chicken, or Stir-fry."
        } else if (timeOfDay == "after dinner snack") {
            mealSuggestion = "Dessert: Ice cream, Chocolate, or Cookies."
        } else {
            mealSuggestion = "Invalid input! Please enter a valid meal time:eg" +
                    "\n" +
                    "- Morning\n" +
                    "- Mid-morning\n" +
                    "- Afternoon\n" +
                    "- Afternoon Snack\n" +
                    "- Dinner\n" +
                    "- After Dinner Snack"
        }

        suggestionText.text = mealSuggestion
    }
    private fun resetFields() {
        timeInput.text.clear()
        suggestionText.text = ""
    }
}
