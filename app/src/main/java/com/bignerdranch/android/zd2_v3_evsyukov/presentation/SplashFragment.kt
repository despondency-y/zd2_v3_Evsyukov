package com.bignerdranch.android.zd2_v3_evsyukov.presentation


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.fragment.app.Fragment
import com.bignerdranch.android.zd2_v3_evsyukov.R

class SplashFragment : Fragment(R.layout.fragment_splash) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler(Looper.getMainLooper()).postDelayed({
            if (isAdded) {
                (activity as? MainActivity)?.openFragment(SignInFragment(), addToBackStack = false)
            }
        }, 2000)
    }
}