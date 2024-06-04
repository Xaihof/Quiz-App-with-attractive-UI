package com.example.quizappkotlin.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.example.quizappkotlin.R
import com.example.quizappkotlin.databinding.ActivityMainBinding
import com.example.quizappkotlin.domain.QuestionModel

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.apply {
            singleBtn.setOnClickListener {

                val intent = Intent(this@MainActivity, QuestionActivity::class.java)
                intent.putParcelableArrayListExtra("list", ArrayList(questionList()))
                startActivity(intent)

            }
            bottomMenu.setItemSelected(R.id.home)
            bottomMenu.setOnItemSelectedListener {
                if (it == R.id.board) {
                    startActivity(Intent(this@MainActivity, LeaderActivity::class.java))
                }
            }
        }
    }

    // This is a function to set the example questions in the game. You can get your questions from the server through api.
    private fun questionList(): MutableList<QuestionModel> {
        val question: MutableList<QuestionModel> = mutableListOf()

        question.add(
            QuestionModel(
                1,
                "What is the capital of France?",
                "London",
                "Berlin",
                "Paris",
                "Madrid",
                "c",
                5,
                "q_1",
                null
            )
        )
        question.add(
            QuestionModel(
                2,
                "What is the largest country in the world by land area?",
                "Canada",
                "Russia",
                "China",
                "United States",
                "b",
                5,
                "q_2",
                null
            )
        )
        question.add(
            QuestionModel(
                3,
                "What is the most populous country in the world?",
                "India",
                "United States",
                "Indonesia",
                "China",
                "d",
                5,
                "q_3",
                null
            )
        )
        question.add(
            QuestionModel(
                4,
                "What is the highest mountain in the world?",
                "K2",
                "Kangchenjunga",
                "Mount Everest",
                "Lhotse",
                "c",
                5,
                "q_4",
                null
            )
        )
        question.add(
            QuestionModel(
                5,
                "What is the deepest ocean in the world?",
                "Atlantic Ocean",
                "Indian Ocean",
                "Arctic Ocean",
                "Pacific Ocean",
                "d",
                5,
                "q_5",
                null
            )
        )
        question.add(
            QuestionModel(
                6,
                "What is the most common element in the universe?",
                "Helium",
                "Hydrogen",
                "Oxygen",
                "Carbon",
                "b",
                5,
                "q_6",
                null
            )
        )
        question.add(
            QuestionModel(
                7,
                "What is the largest organ in the human body?",
                "Skin",
                "Liver",
                "Heart",
                "Brain",
                "a",
                5,
                "q_7",
                null
            )
        )
        question.add(
            QuestionModel(
                8,
                "What is the capital of Australia?",
                "Sydney",
                "Melbourne",
                "Canberra",
                "Perth",
                "c",
                5,
                "q_8",
                null
            )
        )
        question.add(
            QuestionModel(
                9,
                "What is the most popular sport in the world?",
                "Soccer",
                "Cricket",
                "Basketball",
                "Tennis",
                "a",
                5,
                "q_9",
                null
            )
        )
        question.add(
            QuestionModel(
                10,
                "What is the chemical symbol for gold?",

                "Ag",
                "Fe",
                "Cu",
                "Au",
                "d",
                5,
                "q_10",
                null
            )
        )
        return question
    }
}