package com.iznan.featuretwo.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.iznan.featuretwo.presentation.viewmodel.PageThreeViewModel
import com.iznan.foundation.theme.foundationComposeView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PageThreeFragment : Fragment() {

    private val viewModel: PageThreeViewModel by viewModels()
//    private val args: PageThreeFragmentArgs by navArgs()

//    override fun initBinding(
//        inflater: LayoutInflater,
//        container: ViewGroup?
//    ): FragmentPageThreeBinding {
//        return FragmentPageThreeBinding.inflate(inflater, container, false)
//    }
//
//    override fun initView(): FragmentPageThreeBinding? = binding?.apply {
//        observeNavigation(viewModel)
//        tvInfo.text = "Hello Page 3 with data: ${args.extraData}"
//    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return foundationComposeView {
            initView()
        }
    }
}

@Composable
fun initView() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val textId = createRef()
        Text(modifier = Modifier
            .constrainAs(textId) {
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            }
            .padding(start = 16.dp, top = 10.dp), text = "page 3")
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowPreview() {
    initView()
}