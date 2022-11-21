package uz.muhamadaziz.phoneappdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.muhamadaziz.phoneappdatabase.databinding.ActivityInfoBinding

class InfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val phone = intent.getSerializableExtra("phone") as Phonedata

        title = phone.name

        binding.name.text = phone.name
        binding.feature.text = phone.feature
    }
}