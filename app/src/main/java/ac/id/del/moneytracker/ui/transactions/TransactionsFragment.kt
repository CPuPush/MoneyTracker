package ac.id.del.moneytracker.ui.transactions

import ac.id.del.moneytracker.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ac.id.del.moneytracker.databinding.FragmentTransactionsBinding
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager

class TransactionsFragment : Fragment(), TransactionFragmentContract {

    private var _binding: FragmentTransactionsBinding? = null

    private var listTransaction = listOf<Any>()
    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

    //List of cluster
    private var _listOfClusterTransaction: ArrayList<TransactionItem> = arrayListOf()

    private var transactionFragmentAdapter: TransactionAdapter? = null

    lateinit var binding: FragmentTransactionsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTransactionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Collection dara from HardCode data source
        dataCollection()

        Log.d("trace-checkcollection", checkCollection().toString())
        showCollections().let {
            if(!it.isNullOrEmpty()){
                Log.d("trace-showcollections", it.toString())
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun dataCollection() {
        DatasourceTransaction.load().let {
            if (_listOfClusterTransaction.isNullOrEmpty()) {
                _listOfClusterTransaction = it
                transactionFragmentAdapter = TransactionAdapter(requireContext(), _listOfClusterTransaction)
                setUpConfigRecycleViewTransaction()
            }
        }
    }

    override fun checkCollection(): Int {
        return _listOfClusterTransaction.size
    }

    override fun showCollections(): ArrayList<TransactionItem> {
        return _listOfClusterTransaction
    }

    override fun setUpConfigRecycleViewTransaction() {
        binding.rvListTransaction.apply {
            layoutManager = LinearLayoutManager(requireContext())
            hasFixedSize()
            adapter = transactionFragmentAdapter
        }
    }
}