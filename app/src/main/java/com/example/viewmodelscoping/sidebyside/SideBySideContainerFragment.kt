package com.example.viewmodelscoping.sidebyside

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.viewmodelscoping.R

class SideBySideContainerFragment: Fragment(R.layout.fragment_side_by_side) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initPanes()
    }

    private fun initPanes() {
        val args = SideBySideContainerFragmentArgs.fromBundle(requireArguments())

        val leftArgs = bundleOf("leftNumber" to args.leftNumber)
        val leftPaneNavHost = childFragmentManager.findFragmentById(R.id.leftPane)
        leftPaneNavHost?.findNavController()?.setGraph(R.navigation.side_by_side_left_graph, leftArgs)

        val rightArgs = bundleOf("rightNumber" to args.rightNumber)
        val rightPaneNavHost = childFragmentManager.findFragmentById(R.id.rightPane)
        rightPaneNavHost?.findNavController()?.setGraph(R.navigation.side_by_side_right_graph, rightArgs)
    }

}