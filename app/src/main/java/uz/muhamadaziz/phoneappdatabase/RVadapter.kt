package uz.muhamadaziz.phoneappdatabase

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import uz.muhamadaziz.phoneappdatabase.databinding.PhoneItemBinding

class RVadapter(var phoneList: ArrayList<Phonedata>, var onClickListener: OnClickListener) : RecyclerView.Adapter<RVadapter.VH>() {

    inner class VH(private val binding: PhoneItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun onBind(phonedata: Phonedata, position: Int){
            binding.name.text = phonedata.name

            binding.root.setOnClickListener {
                onClickListener.onClick(phonedata, position)
            }
            binding.root.setOnLongClickListener {
                onClickListener.onDeleteClick(phonedata, position)
                true
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(PhoneItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(phoneList[position], position)
    }

    override fun getItemCount(): Int {
        return phoneList.size

    }
    interface OnClickListener{
        fun onClick(phonedata: Phonedata, position: Int)
        fun onDeleteClick(phonedata: Phonedata, position: Int)
    }
}