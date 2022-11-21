package uz.muhamadaziz.phoneappdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import uz.muhamadaziz.phoneappdatabase.databinding.ActivityAddPhonesListBinding

class AddPhonesListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddPhonesListBinding
    private lateinit var phoneList: ArrayList<Phonedata>
    private lateinit var adapter: RVadapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddPhonesListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title ="Phone types"
        phoneList = ArrayList()

        phoneList.add(Phonedata(1, "iPhone", ""))
        phoneList.add(Phonedata(2, "Samsung", ""))
        phoneList.add(Phonedata(3, "Redmi", ""))
        phoneList.add(Phonedata(4, "Sony", ""))

        adapter = RVadapter(phoneList, object : RVadapter.OnClickListener {
            override fun onClick(phonedata: Phonedata, position: Int) {
                val intent = Intent(this@AddPhonesListActivity, AddPhoneActivity::class.java)
                intent.putExtra("id", position + 1)
                startActivity(intent)
            }

            override fun onDeleteClick(phonedata: Phonedata, position: Int) {
                TODO("Not yet implemented")
            }
        })
        binding.recyclerView.adapter = adapter
    }
}