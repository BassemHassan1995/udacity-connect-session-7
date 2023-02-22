package com.bassem.session7.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bassem.session7.R
import com.bassem.session7.databinding.ActivityMainBinding
import com.bassem.session7.utils.Constants

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.primaryColorsButton.setViewData(
            getString(R.string.primary),
            onShowClick = {
                addColors(Constants.primaryColors)
            },
            onHideClick =
            {
                removeColors(Constants.primaryColors)
            }
        )

        binding.secondaryColorsButton.setViewData(
            getString(R.string.secondary),
            onShowClick = {
                addColors(Constants.secondaryColors)
            },
            onHideClick = {
                removeColors(Constants.secondaryColors)
            }
        )

        binding.tertiaryColorsButton.setViewData(
            getString(R.string.tertiary),
            onShowClick = {
                addColors(Constants.tertiaryColors)
            },
            onHideClick = {
                removeColors(Constants.tertiaryColors)
            }
        )

        setContentView(binding.root)
    }

    private fun removeColors(primaryColors: Map<Int, Int>) {
        binding.colorsWheel.removeColorMap(primaryColors)
    }

    private fun addColors(primaryColors: Map<Int, Int>) {
        binding.colorsWheel.addColorMap(primaryColors)

    }
}