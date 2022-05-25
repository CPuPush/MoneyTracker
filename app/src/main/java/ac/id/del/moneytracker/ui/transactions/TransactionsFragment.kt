package ac.id.del.moneytracker.ui.transactions

import ac.id.del.moneytracker.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ac.id.del.moneytracker.databinding.FragmentTransactionsBinding
import kotlinx.android.synthetic.main.fragment_transactions.*

class TransactionsFragment : Fragment() {

    private var _binding: FragmentTransactionsBinding? = null

    private var listTransaction = listOf<Any>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_transactions,container, false)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}