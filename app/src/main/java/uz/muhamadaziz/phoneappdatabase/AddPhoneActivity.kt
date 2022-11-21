package uz.muhamadaziz.phoneappdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import uz.muhamadaziz.phoneappdatabase.databinding.ActivityAddPhoneBinding

class AddPhoneActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPhoneBinding
    private lateinit var phonesList: ArrayList<Phonedata>
    private lateinit var myDataBase: MyDataBase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPhoneBinding.inflate(layoutInflater)
        setContentView(binding.root)

        myDataBase = MyDataBase(this)
        phonesList = myDataBase.getAllPhoneList() as ArrayList<Phonedata>

        title = "Add phone"

        binding.add.setOnClickListener {
            if (binding.phoneName.text.isEmpty() || binding.phoneFeature.text.isEmpty()) {
                Toast.makeText(this, "To'ldiring!!", Toast.LENGTH_SHORT).show()
            } else {
                val position = intent.getIntExtra("id", 0)
                val name = binding.phoneName.text.toString()
                val feature = binding.phoneFeature.text.toString()

                val phone = Phonedata(position, name, feature)
                myDataBase.addPhone(phone)
                phonesList.add(phone)
            }
            finish()


        }
    }
}