package id.ac.ubaya.informatika.admbweek4.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import id.ac.ubaya.informatika.admbweek4.R
import id.ac.ubaya.informatika.admbweek4.model.Student
import kotlinx.android.synthetic.main.student_list_item.view.*
import java.util.*

class StudentListAdapterr(val studenList:ArrayList<Student>)
    :RecyclerView.Adapter<StudentListAdapterr.StudentViewHolder>() {
    class StudentViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun updateStudentList(newStudentList: List<Student>) {
        studenList.clear()
        studenList.addAll(newStudentList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val v = inflater.inflate(R.layout.student_list_item, parent, false)
        return StudentViewHolder(v)

    }

    override fun getItemCount(holder: StudentViewHolder, position: Int): Int {
        holder.view.txtid.text = studenList[position].id
        holder.view.txtname.text = studenList[position].name

        holder.view.buttondetail.setOnClickListener {
            val action = StudentListFragmentDirections.actionStudentDetail()
            Navigation.findNavController(it).navigate(action)
        }
    }

        override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
            fun getItemCount(): Int {
                return studenList.size
            }
        }
    }