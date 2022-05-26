package ac.id.del.moneytracker.ui.add

import ac.id.del.moneytracker.DatePickerFragment
import ac.id.del.moneytracker.Navigation
import ac.id.del.moneytracker.R
import ac.id.del.moneytracker.SignInActivity
import ac.id.del.moneytracker.databinding.ActivityMainBinding
import ac.id.del.moneytracker.databinding.FragmentAddBinding
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

private const val DIALOG_DATE = "DialogDate"

class AddFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private lateinit var dateButton: Button

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
//        dateButton = view.findViewById(R.id.btn_add_calendar) as Button

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}