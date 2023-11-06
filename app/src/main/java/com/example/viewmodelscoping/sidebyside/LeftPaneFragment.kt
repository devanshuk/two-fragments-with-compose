package com.example.viewmodelscoping.sidebyside

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.viewmodelscoping.LeftPaneGraphArgs
import com.example.viewmodelscoping.R
import com.example.viewmodelscoping.ui.theme.ViewModelScopingTheme

class LeftPaneFragment : Fragment() {

    private val args by navArgs<LeftPaneGraphArgs>()

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
                    Surface(color = Color.Yellow) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("Left Pane got a ${args.leftNumber}")
                        }
                    }
                }
            }
        }
    }
}