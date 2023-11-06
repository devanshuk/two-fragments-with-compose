package com.example.viewmodelscoping

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.example.viewmodelscoping.ui.theme.ViewModelScopingTheme
import com.example.viewmodelscoping.util.isTablet

class FirstFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(
                ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed
            )
            id = R.id.compose_view_first_fragment

            setContent {
                ViewModelScopingTheme {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            verticalArrangement = Arrangement.spacedBy(16.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text("This is the First Fragment !")

                            Button(
                                onClick = {
                                    if(isAdded && isTablet(requireActivity())) {
                                        navigateToSideBySideFragment()
                                    } else {
                                        navigateToSecondFragment()
                                    }
                                }
                            ) {
                                Text("Next")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun navigateToSecondFragment() {
        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment()
        view?.findNavController()?.navigate(action)
    }

    private fun navigateToSideBySideFragment() {
        val action = FirstFragmentDirections.actionFirstFragmentToSideBySideContainerFragment(leftNumber = 3, rightNumber = 4)
        view?.findNavController()?.navigate(action)
    }
}