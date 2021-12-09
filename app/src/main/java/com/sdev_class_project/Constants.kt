package com.sdev_class_project


object Constants {
    // Push day
    fun getWorkoutOne(): ArrayList<Workout>{
        val workoutList = ArrayList<Workout>()

        val pushups = Workout("Push Ups", 3, 12, false)
        val pullups = Workout("Overhead Press", 3, 10, false)
        val lunges = Workout("Lateral Raises", 3, 15, false)
        val squats = Workout("Tricep Dips", 3, 10, false)
        val deadlifts = Workout("Bench Press", 3, 8, false)
        val situps = Workout("Tricep Extensions", 3, 14, false)

        workoutList.add(pushups)
        workoutList.add(pullups)
        workoutList.add(lunges)
        workoutList.add(squats)
        workoutList.add(deadlifts)
        workoutList.add(situps)

        return workoutList
    }
    // Pull day
    fun getWorkoutTwo(): ArrayList<Workout>{
        val workoutList = ArrayList<Workout>()

        val pushups = Workout("Deadlifts", 3, 12, false)
        val pullups = Workout("Pull Ups", 3, 10, false)
        val lunges = Workout("Cable Rows", 3, 15, false)
        val squats = Workout("Curls", 3, 10, false)
        val deadlifts = Workout("Facepulls", 3, 8, false)
        val situps = Workout("Rear Delts", 3, 14, false)

        workoutList.add(pushups)
        workoutList.add(pullups)
        workoutList.add(lunges)
        workoutList.add(squats)
        workoutList.add(deadlifts)
        workoutList.add(situps)

        return workoutList
    }
    // Leg day
    fun getWorkoutThree(): ArrayList<Workout>{
        val workoutList = ArrayList<Workout>()

        val pushups = Workout("Lunges", 3, 12, false)
        val pullups = Workout("Leg Extensions", 3, 10, false)
        val lunges = Workout("Leg Curls", 3, 15, false)
        val squats = Workout("Squats", 3, 10, false)
        val deadlifts = Workout("Hip Thrusts", 3, 8, false)
        val situps = Workout("Leg Press", 3, 14, false)

        workoutList.add(pushups)
        workoutList.add(pullups)
        workoutList.add(lunges)
        workoutList.add(squats)
        workoutList.add(deadlifts)
        workoutList.add(situps)

        return workoutList
    }
}

// Divide workouts into three workouts - 1, 2, 3
// If the user hasn't completed one, they are ineligible to complete the following workout until completing the current one.