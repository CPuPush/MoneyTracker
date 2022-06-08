package ac.id.del.moneytracker.ui.report

import ac.id.del.moneytracker.R
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.size
import androidx.fragment.app.Fragment
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter

class ReportFragment : Fragment() {

    private lateinit var pieChart: PieChart

    //private var _binding: FragmentReportBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    //private val binding get() = _binding!!

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

        val view = inflater.inflate(R.layout.fragment_report, container, false)
        pieChart = view.findViewById(R.id.pieChart_fragment_report)
        showPieChart()

        return view
    }

    private fun showPieChart() {
        val pieEntries: ArrayList<PieEntry> = ArrayList()
        val label = "type"

        //initializing data
        val typeAmountMap: MutableMap<String, Int> = HashMap()
        typeAmountMap["Medicine"] = 25
        typeAmountMap["Transportation"] = 16
        typeAmountMap["Food and Beverage"] = 43
        typeAmountMap["Tax"] = 8
        typeAmountMap["Shopping"] = 8

        //initializing colors for the entries
        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#EF5DA8"))
        colors.add(Color.parseColor("#5D5FEF"))
        colors.add(Color.parseColor("#2A9D8F"))
        colors.add(Color.parseColor("#60CEE7"))
        colors.add(Color.parseColor("#EC33CE"))
        colors.add(Color.parseColor("#F46A61"))
        colors.add(Color.parseColor("#F4A261"))
        colors.add(Color.parseColor("#D7C255"))
        colors.add(Color.parseColor("#1C1B1E"))

        //input data and fit data into pie chart entry
        for (type in typeAmountMap.keys) {
            pieEntries.add(PieEntry(typeAmountMap[type]!!.toFloat(), type))
        }

        //collecting the entries with label name
        val pieDataSet = PieDataSet(pieEntries, label)
        //setting text size of the value
        pieDataSet.valueTextSize = 16f
        //providing color list for coloring different entries
        pieDataSet.colors = colors
        //to set text color
        pieDataSet.setValueTextColor(Color.WHITE)
        //to change the value to percentage
        pieDataSet.setValueFormatter(PercentFormatter())
        //grouping the data set from entry to chart
        val pieData = PieData(pieDataSet)
        //showing the value of the entries, default true if not set
        pieData.setDrawValues(true)
        //to remove the "Description Label" in the right-left corner
        pieChart.getDescription().setEnabled(false);
        pieChart.setDrawHoleEnabled(false);

        //pieChart.setHoleRadius(0f);
        //legend attributes
        //legend attributes

        val legend = pieChart.legend
        legend.form = Legend.LegendForm.SQUARE
        legend.textSize = 15f
        legend.formSize = 20f
        legend.formToTextSpace = 10f
        legend.horizontalAlignment = Legend.LegendHorizontalAlignment.LEFT
        legend.verticalAlignment = Legend.LegendVerticalAlignment.BOTTOM
        legend.orientation = Legend.LegendOrientation.VERTICAL

        pieChart.setData(pieData)
        pieChart.invalidate()
    }

//    override fun onDestroyView() {
//        super.onDestroyView()
//        _binding = null
//    }
}