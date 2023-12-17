package com.example.tutorialapplication.components.bottomnavigationbar

import com.example.tutorialapplication.R


sealed class NavigationItem(var route: String, var icon: Int, var title: String) {
    object Characters : NavigationItem("ListScreen", R.drawable.baseline_person_24, "Characters")
    object Screen2 : NavigationItem("SpellScreen", R.drawable.magic_wand_icon, "Spells")
    object Screen3 : NavigationItem("FavouriteScreen", R.drawable.baseline_favorite_24, "Favourites")
}