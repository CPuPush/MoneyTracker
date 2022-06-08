package ac.id.del.moneytracker.ui.add

import ac.id.del.moneytracker.DatePickerFragment
import ac.id.del.moneytracker.Navigation
import ac.id.del.moneytracker.R
import ac.id.del.moneytracker.SignInActivity
import ac.id.del.moneytracker.databinding.ActivityMainBinding
import ac.id.del.moneytracker.databinding.FragmentAddBinding
import android.app.DatePickerDialog
import android.content.Intent
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.os.PersistableBundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.fragment_add.*
import java.util.*

private const val DIALOG_DATE = "DialogDate"

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private lateinit var dateButton: Button
    private lateinit var dateEditText: EditText

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val dashboardViewModel =
//            ViewModelProvider(this).get(DashboardViewModel::class.java)
//
//        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        val textView: TextView = binding.transaction
//        dashboardViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        val view = inflater.inflate(R.layout.fragment_add, container, false)
        dateEditText = view.findViewById(R.id.et_fragment_add_calendar)

        dateEditText.setOnClickListener {
            val cldr: Calendar = Calendar.getInstance()
            val day: Int = cldr.get(Calendar.DAY_OF_MONTH)
            val month: Int = cldr.get(Calendar.MONTH)
            val year: Int = cldr.get(Calendar.YEAR)

            val picker = DatePickerDialog(
                view.context,
                { view, year, monthOfYear, dayOfMonth ->
                    dateEditText.setText(
                        year.toString() + "/" + (monthOfYear + 1) + "/" + dayOfMonth.toString()
                    )
                },
                year,
                month,
                day
            )
            picker.show()
        }

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}