package com.example.simple_mvvm.views.currentcolor


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.simple_mvvm.databinding.FragmentCurrentColorBinding
import com.example.simple_mvvm.views.base.BaseFragment
import com.example.simple_mvvm.views.base.BaseScreen
import com.example.simple_mvvm.views.base.screenViewModel
import kotlinx.parcelize.Parcelize

class CurrentColorFragment : BaseFragment() {

    //no arguments for this screen
    @Parcelize
    class Screen: BaseScreen

    override val viewModel by screenViewModel<CurrentColorViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentCurrentColorBinding.inflate(inflater, container, false)

        viewModel.currentColor.observe(viewLifecycleOwner){
            binding.colorView.setBackgroundColor(it.value)
        }
        binding.changeColorButton.setOnClickListener {
            viewModel.changeColor()
        }
        return binding.root
    }

}