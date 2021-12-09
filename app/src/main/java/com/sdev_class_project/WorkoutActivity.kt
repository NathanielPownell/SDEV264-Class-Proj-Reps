package com.sdev_class_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_workout.*
import kotlinx.android.synthetic.main.activity_summary.*

var currentday = 1


class WorkoutActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)

        var workouts = Constants.getWorkoutOne()
        val emailId = intent.getStringExtra("email_id")



        if (currentday == 1) {
            workouts = Constants.getWorkoutOne()
            dayHeader.text = "Push Day"
        } else if (currentday == 2){
            workouts = Constants.getWorkoutTwo()
            dayHeader.text = "Pull Day"
        } else {
            workouts = Constants.getWorkoutThree()
            dayHeader.text = "Leg Day"
        }

        var currentPosition = 1
        val currentWorkout: Workout? = workouts[currentPosition-1]

        progressBar.progress = currentPosition
            progressBar.max = workouts.size
            progressText.text = "$currentPosition" + "/" + workouts.size
            workoutLabel.text = currentWorkout!!.name
            setsNumber.text = currentWorkout!!.sets.toString()
            repsNumber.text = currentWorkout!!.reps.toString()


            if (currentPosition == workouts!!.size) {
                buttonWorkoutContinue.text = "FINISH"
            } else {
                buttonWorkoutContinue.text = "Continue"
            }

            var isFinished = false

            fun setQuestion() {

                val currentWorkout = workouts!!.get(currentPosition - 1)


                if (currentPosition == workouts!!.size) {
                    buttonWorkoutContinue.text = "FINISH"
                    isFinished = true
                } else {
                    buttonWorkoutContinue.text = "Continue"
                }

                progressBar.progress = currentPosition

                progressText.text = "$currentPosition" + "/" + workouts.size
                workoutLabel.text = currentWorkout!!.name
                setsNumber.text = currentWorkout!!.sets.toString()
                repsNumber.text = currentWorkout!!.reps.toString()

            }

            buttonWorkoutContinue.setOnClickListener{
                if (isFinished) {
                    val intent = Intent(this@WorkoutActivity, Summary::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    intent.putExtra("email_id", emailId)
    //                intent.putExtra("user_id", firebaseUser.uid)
    //                intent.putExtra("email_id", mEmail)
                    startActivity(intent)
                    if (currentday == 1 || currentday == 2){
                        currentday += 1
                    } else {
                        currentday = 1
                    }
                    finish()
                } else {
                    currentPosition++
                    setQuestion()
                }

            }

            floatingWorkoutBack.setOnClickListener{
                val intent = Intent(this@WorkoutActivity, MainActivity::class.java)
                intent.putExtra("email_id", emailId)

                startActivity(intent)
            }



    }

}
