package com.example.myapplication.ui.profile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.widget.addTextChangedListener
import com.example.myapplication.databinding.FragmentProfileBinding
import com.example.myapplication.ui.data.local.Pref
import com.example.myapplication.utils.loadImage

class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    private val pref: Pref by lazy {
        Pref(requireContext())
    }
    private val launcher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK
            && result.data != null
        ) {
            val photoUri: Uri? = result.data?.data
            pref.saveImage(photoUri.toString())
            binding.imgProfile.loadImage(photoUri.toString())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.imgProfile.loadImage(pref.getImage())

        binding.edName.setText(pref.getName())
        binding.edName.addTextChangedListener {
            pref.saveName(binding.edName.text.toString())
        }
        binding.edAge.setText(pref.getAge())
        binding.edAge.addTextChangedListener {
            pref.saveAge(binding.edAge.text.toString())
        }
        binding.edFloor.setText(pref.getFloor())
        binding.edFloor.addTextChangedListener {
            pref.saveFloor(binding.edFloor.text.toString())
        }
        binding.imgProfile.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            launcher.launch(intent)
        }

    }



}