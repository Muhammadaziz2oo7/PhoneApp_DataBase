package uz.muhamadaziz.phoneappdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import uz.muhamadaziz.phoneappdatabase.databinding.ActivityPhonesBinding

class PhonesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhonesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhonesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Phones"

        binding.iPhone.setOnClickListener {
            val intent = Intent(this, PhoneListActivity::class.java)
            intent.putExtra("title", "iPhone")
            intent.putExtra("id", 1)
            startActivity(intent)
        }
        binding.samsung.setOnClickListener {
            val intent = Intent(this, PhoneListActivity::class.java)
            intent.putExtra("title", "Samsung")
            intent.putExtra("id", 2)
            startActivity(intent)
        }
        binding.mi.setOnClickListener {
            val intent = Intent(this, PhoneListActivity::class.java)
            intent.putExtra("title", "Redmi")
            intent.putExtra("id", 3)
            startActivity(intent)
        }
        binding.sony.setOnClickListener {
            val intent = Intent(this, PhoneListActivity::class.java)
            intent.putExtra("title", "Sony")
            intent.putExtra("id", 4)
            startActivity(intent)
        }
    }
}