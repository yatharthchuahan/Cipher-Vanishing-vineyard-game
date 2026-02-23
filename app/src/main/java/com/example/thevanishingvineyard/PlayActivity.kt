package com.example.thevanishingvineyard
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isVisible
import com.example.thevanishingvineyard.databinding.ActivityPlayBinding

class PlayActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPlayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        binding = ActivityPlayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.txtGameOver.isVisible = false

        val arrPanel: ArrayList<ArrayList<Button>> = arrayListOf(
            arrayListOf(binding.panel11, binding.panel12, binding.panel13),
            arrayListOf(binding.panel21, binding.panel22, binding.panel23),
            arrayListOf(binding.panel31, binding.panel32, binding.panel33)
        )

        for (i in arrPanel) {
            for (j in i) {
                j.text = ""
                j.setBackgroundColor(resources.getColor(R.color.tile))
            }
        }

        var rndInitX = (0..2).random()
        var rndInitY = (0..2).random()

        val firstBtn = arrPanel[rndInitY][rndInitX]
        firstBtn.text = ("2").toString()
        firstBtn.setBackgroundColor(resources.getColor(R.color.no2))

        var score = 0

        var gameOver = false

        fun checkGameOver(arrPanel: ArrayList<ArrayList<Button>>) {
            if (isGameOver(arrPanel)) {
                true.also { it.also { binding.txtGameOver.isVisible = it } }
                Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show()
                val intent = Intent(this, CalculatorGrapevine::class.java)
                startActivity(intent)
                finish()
            }
        }

        fun checkScore(score: Int) {
            if (score >= 300) {
                val intent = Intent(this, GrapevinePhoneActivity::class.java)
                startActivity(intent)
            }
        }

        binding.btnUp.setOnClickListener {

            var move = true
            var next = false

            // MOVE UP
            while (move) {
                move = false

                for (i in 0..2) {
                    for (j in 0..2) {
                        if (j > 0 && arrPanel[j][i].text != "") {
                            if (arrPanel[j - 1][i].text == "") {
                                arrPanel[j - 1][i].text = arrPanel[j][i].text
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j - 1][i].text) {
                                    "2" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true

                            } else if (arrPanel[j - 1][i].text == arrPanel[j][i].text) {

                                score += arrPanel[j - 1][i].text.toString().toInt()
                                binding.txtScore.text = score.toString()

                                arrPanel[j - 1][i].text = (arrPanel[j - 1][i].text.toString().toInt() * 2).toString()
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j - 1][i].text) {
                                    "2" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j - 1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true
                            }
                        }
                    }
                }
            }

            if (next) {
                var rndX = (0..2).random()
                var rndY = (0..2).random()

                while (arrPanel[rndY][rndX].text != "") {
                    rndX = (0..2).random()
                    rndY = (0..2).random()
                }

                arrPanel[rndY][rndX].text = ("2").toString()
                arrPanel[rndY][rndX].setBackgroundColor(resources.getColor(R.color.no2))
            }

            checkGameOver(arrPanel)
            checkScore(score)
        }

        binding.btnDown.setOnClickListener {

            var move = true
            var next = false

            // MOVE DOWN
            while (move) {
                move = false

                for (i in 0..2) {
                    for (j in 2 downTo 1) {
                        if (j < 2 && arrPanel[j][i].text != "") {
                            if (arrPanel[j + 1][i].text == "") {
                                arrPanel[j + 1][i].text = arrPanel[j][i].text
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j + 1][i].text) {
                                    "2" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true

                            } else if (arrPanel[j + 1][i].text == arrPanel[j][i].text) {

                                score += arrPanel[j + 1][i].text.toString().toInt()
                                score.toString().also { binding.txtScore.text = it }

                                arrPanel[j + 1][i].text = (arrPanel[j + 1][i].text.toString().toInt() * 2).toString()
                                arrPanel[j][i].text = ""

                                //
                                when (arrPanel[j + 1][i].text) {
                                    "2" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[j + 1][i].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[j][i].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true
                            }
                        }
                    }
                }
            }

            if (next) {
                var rndX = (0..2).random()
                var rndY = (0..2).random()

                while (arrPanel[rndY][rndX].text != "") {
                    rndX = (0..2).random()
                    rndY = (0..2).random()
                }

                arrPanel[rndY][rndX].text = ("2").toString()
                arrPanel[rndY][rndX].setBackgroundColor(resources.getColor(R.color.no2))
            }

            checkGameOver(arrPanel)
            checkScore(score)
        }

        binding.btnLeft.setOnClickListener {

            var move = true
            var next = false

            // MOVE LEFT
            while (move) {
                move = false

                for (i in 0..2) {
                    for (j in 0..2) {
                        if (j > 0 && arrPanel[i][j].text != "") {
                            if (arrPanel[i][j - 1].text == "") {
                                arrPanel[i][j - 1].text = arrPanel[i][j].text
                                arrPanel[i][j].text = ""

                                //
                                when (arrPanel[i][j - 1].text) {
                                    "2" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[i][j].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true

                            } else if (arrPanel[i][j - 1].text == arrPanel[i][j].text) {

                                score += arrPanel[i][j - 1].text.toString().toInt()
                                binding.txtScore.text = score.toString()

                                arrPanel[i][j - 1].text = (arrPanel[i][j - 1].text.toString().toInt() * 2).toString()
                                arrPanel[i][j].text = ""

                                //
                                when (arrPanel[i][j - 1].text) {
                                    "2" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color .no4))
                                    }
                                    "8" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[i][j - 1].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[i][j].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true
                            }
                        }
                    }
                }
            }

            if (next) {
                var rndX = (0..2).random()
                var rndY = (0..2).random()

                while (arrPanel[rndY][rndX].text != "") {
                    rndX = (0..2).random()
                    rndY = (0..2).random()
                }

                arrPanel[rndY][rndX].text = ("2").toString()
                arrPanel[rndY][rndX].setBackgroundColor(resources.getColor(R.color.no2))
            }

            checkGameOver(arrPanel)
            checkScore(score)
        }

        binding.btnRight.setOnClickListener {

            var move = true
            var next = false

            // MOVE RIGHT
            while (move) {
                move = false

                for (i in 0..2) {
                    for (j in 2 downTo 1) {
                        if (j < 2 && arrPanel[i][j].text != "") {
                            if (arrPanel[i][j + 1].text == "") {
                                arrPanel[i][j + 1].text = arrPanel[i][j].text
                                arrPanel[i][j].text = ""

                                //
                                when (arrPanel[i][j + 1].text) {
                                    "2" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[i][j].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true

                            } else if (arrPanel[i][j + 1].text == arrPanel[i][j].text) {

                                score += arrPanel[i][j + 1].text.toString().toInt()
                                binding.txtScore.text = score.toString()

                                arrPanel[i][j + 1].text = (arrPanel[i][j + 1].text.toString().toInt() * 2).toString()
                                arrPanel[i][j].text = ""

                                //
                                when (arrPanel[i][j + 1].text) {
                                    "2" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no2))
                                    }
                                    "4" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no4))
                                    }
                                    "8" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no8))
                                    }
                                    "16" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no16))
                                    }
                                    "32" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no32))
                                    }
                                    "64" -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.no64))
                                    }
                                    else -> {
                                        arrPanel[i][j + 1].setBackgroundColor(resources.getColor(R.color.white))
                                    }
                                }
                                arrPanel[i][j].setBackgroundColor(resources.getColor(R.color.tile))

                                move = true
                                next = true
                            }
                        }
                    }
                }
            }

            if (next) {
                var rndX = (0..2).random()
                var rndY = (0..2).random()

                while (arrPanel[rndY][rndX].text != "") {
                    rndX = (0..2).random()
                    rndY = (0..2).random()
                }

                arrPanel[rndY][rndX].text = ("2").toString()
                arrPanel[rndY][rndX].setBackgroundColor(resources.getColor(R.color.no2))
            }

            checkGameOver(arrPanel)
            checkScore(score)
        }
    }

    private fun isGameOver(arrPanel: ArrayList<ArrayList<Button>>): Boolean {
        for (i in arrPanel) {
            for (j in i) {
                if (j.text == "") {
                    return false
                }
            }
        }

        for (i in 0..2) {
            for (j in 0.. 2) {
                if (j > 0 && arrPanel[i][j].text == arrPanel[i][j - 1].text) {
                    return false
                }
                if (j < 2 && arrPanel[i][j].text == arrPanel[i][j + 1].text) {
                    return false
                }
                if (i > 0 && arrPanel[i][j].text == arrPanel[i - 1][j].text) {
                    return false
                }
                if (i < 2 && arrPanel[i][j].text == arrPanel[i + 1][j].text) {
                    return false
                }
            }
        }

        return true
    }

    override fun onBackPressed() {
        super.onBackPressed()
        val intent = Intent(this, CalculatorGrapevine::class.java)
        startActivity(intent)
        finish()
    }
}