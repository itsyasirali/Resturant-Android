package com.itsyasirali.restaurant.data

import com.google.firebase.firestore.FirebaseFirestore
import com.itsyasirali.restaurant.model.more.User
import kotlinx.coroutines.tasks.await

class Repo {
    private val firestore = FirebaseFirestore.getInstance()

    suspend fun registerUser(
        name: String,
        email: String,
        phone: String,
        address: String,
        password: String
    ): Result<Unit> {
        return try {
            val user = User(
                name = name,
                email = email,
                phone = phone,
                address = address,
                password = password
            )

            val docRef = firestore.collection("users").add(user).await()

            user.uid = docRef.id
            firestore.collection("users").document(docRef.id).set(user).await()

            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
