package com.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.mealzapp.model.MealResponse
import com.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // val viewModel by viewModels<MealCategoriesViewModel>() // This is old fashioned used before componse
        setContent {
            MealzAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MealCategoriesScreen()
                }
            }
        }
    }
}

@Composable
fun MealCategoriesScreen() {
    val viewModel : MealCategoriesViewModel = viewModel()  // This is compose bind viewmodel, singleton instance
     val rememberMeals : MutableState<List<MealResponse>> = remember { mutableStateOf(emptyList<MealResponse>())}

    val meals = viewModel.meals.collectAsState()
    rememberMeals.value = meals.value.orEmpty()

    LazyColumn {
        items(rememberMeals.value) { meal ->
            Text(text = meal.name)
        }
    }

   // Text(text = rememberMeals.value.toString())
    //meals.value?.size.toString()?.let { Text(text = it) }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealCategoriesScreen()
    }
}