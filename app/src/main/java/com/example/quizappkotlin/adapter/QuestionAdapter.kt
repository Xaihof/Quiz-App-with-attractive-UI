package com.example.quizappkotlin.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.quizappkotlin.R
import com.example.quizappkotlin.databinding.ViewholderQuestionBinding

class QuestionAdapter(
    val correctAnswer: String,
    val users: MutableList<String> = mutableListOf(),
    val returnScore: score
) : RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {

    interface score {
        fun amount(number: Int, clickedAnswer: String)
    }

    private lateinit var binding: ViewholderQuestionBinding

    inner class ViewHolder : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionAdapter.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        binding = ViewholderQuestionBinding.inflate(inflater, parent, false)
        return ViewHolder()
    }

    override fun onBindViewHolder(holder: QuestionAdapter.ViewHolder, position: Int) {

        val binding = ViewholderQuestionBinding.bind(holder.itemView)
        binding.answerTxt.text = differ.currentList[position]
        var currentPos = 0
        when (correctAnswer) {
            "a" -> {
                currentPos = 0
            }

            "b" -> {
                currentPos = 1
            }

            "c" -> {
                currentPos = 2
            }

            "d" -> {
                currentPos = 3
            }
        }

        if (differ.currentList.size == 5 && currentPos == position) {
            binding.answerTxt.setBackgroundResource(R.drawable.green_bg)
            val drawable = ContextCompat.getDrawable(binding.root.context, R.drawable.tick)
            binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(
                null,
                null,
                drawable,
                null
            )
        }

        if (differ.currentList.size == 5) {
            var clickedPos = 0
            when (differ.currentList[4]) {
                "a" -> {
                    currentPos = 0
                }

                "b" -> {
                    currentPos = 1
                }

                "c" -> {
                    currentPos = 2
                }

                "d" -> {
                    currentPos = 3
                }
            }

          /* if (clickedPos == position && clickedPos != currentPos) {
                 binding.answerTxt.setBackgroundResource(R.drawable.red_bg)

                 val drawable = ContextCompat.getDrawable(binding.root.context, R.drawable.thieves)
                 binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(
                     null,
                     null,
                     drawable,
                     null
                 )
             }*/
        }
        if (position == 4) {
            binding.root.visibility = View.GONE
        }

        holder.itemView.setOnClickListener {
            var str = ""
            when (position) {
                0 -> {
                    str = "a"
                }

                1 -> {
                    str = "b"
                }

                2 -> {
                    str = "c"
                }

                3 -> {
                    str = "d"
                }
            }

            users.add(4, str)
            notifyDataSetChanged()

            if (currentPos == position) {

                binding.answerTxt.setBackgroundResource(R.drawable.green_bg)
                val drawable = ContextCompat.getDrawable(binding.root.context, R.drawable.tick)
                binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null,
                    null,
                    drawable,
                    null
                )
                returnScore.amount(5, str)
            } else {
                binding.answerTxt.setBackgroundResource(R.drawable.red_bg)
                val drawable = ContextCompat.getDrawable(binding.root.context, R.drawable.thieves)
                binding.answerTxt.setCompoundDrawablesRelativeWithIntrinsicBounds(
                    null,
                    null,
                    drawable,
                    null
                )
                returnScore.amount(0, str)
            }
        }
        if (differ.currentList.size == 5) holder.itemView.setOnClickListener(null)
        /*1:53:20*/
    }

    override fun getItemCount() = differ.currentList.size

    private val differCallback = object : DiffUtil.ItemCallback<String>() {
        override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this, differCallback)


}