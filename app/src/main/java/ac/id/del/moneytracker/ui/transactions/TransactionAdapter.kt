package ac.id.del.moneytracker.ui.transactions

import ac.id.del.moneytracker.R
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_transaction.view.*
import kotlinx.android.synthetic.main.item_transaction_title.view.*

class TransactionAdapter(context: Context, datasourceTransaction: ArrayList<TransactionItem>):
    RecyclerView.Adapter<TransactionAdapter.TransactionAdapterViewHolder>(){

    val context = context
    val dataSource = datasourceTransaction

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TransactionAdapter.TransactionAdapterViewHolder {
        val layoutView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        return TransactionAdapterViewHolder(layoutView)
    }

    override fun onBindViewHolder(
        holder: TransactionAdapter.TransactionAdapterViewHolder,
        position: Int
    ) {
        if(holder.tvTitleAmount!=null){
            holder.tvTitleAmount.text = dataSource[position].transactionTotal?:"-"
        }
        if(holder.tvTitleDay!=null){
            holder.tvTitleDay.text = dataSource[position].transactionDay?:"-"
        }
        if(holder.tvTitleDate!=null){
            holder.tvTitleDate.text = dataSource[position].transactionDate?:"-"
        }
        if(holder.tvTitleMonthYear!=null){
            holder.tvTitleMonthYear.text = dataSource[position].transactionYearMonth?:"-"
        }
    }

    override fun getItemCount(): Int {
        return if(dataSource.isNullOrEmpty()) {
            0
        } else {
            dataSource.size
        }
    }

    class TransactionAdapterViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val tvTitleDay = itemView.icl_transaction_title.tv_transaction_title_day
        val tvTitleDate = itemView.icl_transaction_title.tv_transaction_title_date
        val tvTitleMonthYear = itemView.icl_transaction_title.tv_transaction_title_monthyear
        val tvTitleAmount = itemView.icl_transaction_title.tv_transaction_title_amount
    }

}