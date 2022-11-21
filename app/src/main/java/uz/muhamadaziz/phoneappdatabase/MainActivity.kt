package uz.muhamadaziz.phoneappdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.muhamadaziz.phoneappdatabase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.phone.setOnClickListener {
            startActivity(Intent(this, PhonesActivity::class.java))
        }

        binding.addPhone.setOnClickListener {
            startActivity(Intent(this, AddPhonesListActivity::class.java))
        }
    }
}