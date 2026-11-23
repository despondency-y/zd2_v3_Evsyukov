package com.bignerdranch.android.zd2_v3_evsyukov.presentation

import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.bignerdranch.android.zd2_v3_evsyukov.R


class MainMenuFragment : Fragment(R.layout.fragment_main_menu) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<LinearLayout>(R.id.btnDiscussions).setOnClickListener {
            (activity as? MainActivity)?.openFragment(ChatListFragment())
        }

        view.findViewById<LinearLayout>(R.id.btnCollections).setOnClickListener {
            (activity as? MainActivity)?.openFragment(MoviesFragment())
        }
    }
}