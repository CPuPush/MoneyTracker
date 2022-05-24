package ac.id.del.moneytracker.ui.profile

import ac.id.del.moneytracker.R
import ac.id.del.moneytracker.databinding.FragmentAddBinding
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*


private const val DIALOG_DATE = "DialogDate"

class ProfileFragment : Fragment() {

    private var _binding: FragmentAddBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}