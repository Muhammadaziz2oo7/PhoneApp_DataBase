package uz.muhamadaziz.phoneappdatabase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import uz.muhamadaziz.phoneappdatabase.databinding.ActivityPhoneListBinding

class PhoneListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPhoneListBinding
    private lateinit var adapter: RVadapter
    private lateinit var myDataBase: MyDataBase
    private lateinit var phoneList: ArrayList<Phonedata>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhoneListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        myDataBase = MyDataBase(this)
        phoneList = myDataBase.getAllPhoneList() as ArrayList<Phonedata>

        val title = intent.getStringExtra("title")
        val id = intent.getIntExtra("id", 0)

        this.title = title
        val sortList = ArrayList<Phonedata>()

        for (i in phoneList.indices) {
            if (phoneList[i].position == id){
                sortList.add(phoneList[i])
            }
        }

        adapter = RVadapter(sortList, object : RVadapter.OnClickListener {
            override fun onClick(phonedata: Phonedata, position: Int) {

                val intent =Intent(this@PhoneListActivity, InfoActivity::class.java)
                intent.putExtra("phone", sortList[position])
                startActivity(intent)
            }

            override fun onDeleteClick(phonedata: Phonedata, position: Int) {

                val alertDialog = AlertDialog.Builder(this@PhoneListActivity)

                alertDialog.setMessage("O'chirib bo'lmaydi")
                val create = alertDialog.create()
                alertDialog.setPositiveButton("Ha") { _, _ ->
                    myDataBase.deletePhone(phonedata)
                    sortList.remove(phonedata)
                    adapter.notifyItemChanged(sortList.size)
                    adapter.notifyItemRemoved(sortList.size)
                    adapter.notifyItemRangeRemoved(position, sortList.size)
                }
                alertDialog.setNegativeButton("Yo'q") { _, _ ->
                    create.dismiss()
                }
                alertDialog.show()
            }
        })

        binding.recyclerView.adapter = adapter


    }
}