package ac.id.del.moneytracker.ui.report

import ac.id.del.moneytracker.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ac.id.del.moneytracker.databinding.FragmentReportBinding
import android.widget.EditText
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.chart.common.dataentry.ValueDataEntry
import com.anychart.charts.Pie
import java.util.*

class ReportFragment : Fragment() {

    private var chart: AnyChartView? = null

    private val salary = listOf(200,300,400,600)
    private val month = listOf("January","February","March","April")

    private var _binding: FragmentReportBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        val notificationsViewModel =
//            ViewModelProvider(this).get(ReportViewModel::class.java)
//
//        _binding = FragmentNotificationsBinding.inflate(inflater, container, false)
//        val root: View = binding.root
//
//        val textView: TextView = binding.textNotifications
//        notificationsViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return inflater.inflate(R.layout.fragment_report,container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        chart = view?.findViewById(R.id.pieChart)
        configChartView()
    }


    private fun configChartView() {
        val pie : Pie = AnyChart.pie()

        val dataPieChart: MutableList<DataEntry> = mutableListOf()

        for (index in salary.indices){
            dataPieChart.add(ValueDataEntry(month.elementAt(index),salary.elementAt(index)))
        }

        pie.data(dataPieChart)
        pie.title("Salaries Overview")
        chart!!.setChart(pie)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}