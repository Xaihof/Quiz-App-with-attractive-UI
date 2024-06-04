package com.example.quizappkotlin.activity

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.quizappkotlin.R
import com.example.quizappkotlin.adapter.LeaderAdapter
import com.example.quizappkotlin.databinding.ActivityLeaderBinding
import com.example.quizappkotlin.domain.UserModel

class LeaderActivity : AppCompatActivity() {

    lateinit var binding: ActivityLeaderBinding
    private val leaderAdapter by lazy { LeaderAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLeaderBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        binding.apply {

            scoreTxt1.text = loadData().get(0).score.toString()
            scoreTxt2.text = loadData().get(1).score.toString()
            scoreTxt3.text = loadData().get(2).score.toString()
            titleTop1Txt.text = loadData().get(0).name
            titleTop2Txt.text = loadData().get(1).name
            titleTop3Txt.text = loadData().get(2).name

            val drawableResourceId1: Int = binding.root.resources.getIdentifier(
                loadData().get(0).pic, "drawable", binding.root.context.packageName
            )
            val drawableResourceId2: Int = binding.root.resources.getIdentifier(
                loadData().get(1).pic, "drawable", binding.root.context.packageName
            )
            val drawableResourceId3: Int = binding.root.resources.getIdentifier(
                loadData().get(2).pic, "drawable", binding.root.context.packageName
            )

            Glide.with(root.context).load(drawableResourceId1).into(pic1)
            Glide.with(root.context).load(drawableResourceId2).into(pic2)
            Glide.with(root.context).load(drawableResourceId3).into(pic3)

            bottomMenu.setItemSelected(R.id.board)
            bottomMenu.setOnItemSelectedListener {
                if (it == R.id.home) {
                    startActivity(Intent(this@LeaderActivity, MainActivity::class.java))
                }
            }

            var list: MutableList<UserModel> = loadData()
            list.removeAt(0)
            list.removeAt(1)
            list.removeAt(2)
            leaderAdapter.differ.submitList(list)
            leaderView.apply {
                layoutManager = LinearLayoutManager(this@LeaderActivity)
                adapter = leaderAdapter
            }

        }
    }

    private fun loadData(): MutableList<UserModel> {
        val users: MutableList<UserModel> = mutableListOf()
        users.add(UserModel(1, "XAIHOF", "person1", 4850))
        users.add(UserModel(2, "Umer", "person2", 4765))
        users.add(UserModel(3, "Talal", "person3", 4652))
        users.add(UserModel(4, "Abdurahman", "person4", 4532))
        users.add(UserModel(5, "Adeel", "person5", 4456))
        users.add(UserModel(6, "Nabeel", "person6", 3868))
        users.add(UserModel(7, "Minhal", "person7", 3579))
        users.add(UserModel(8, "Faryal", "person8", 3478))
        users.add(UserModel(9, "Minhal", "person9", 3350))
        users.add(UserModel(10, "Minhal", "person9", 3350))
        return users
    }
}