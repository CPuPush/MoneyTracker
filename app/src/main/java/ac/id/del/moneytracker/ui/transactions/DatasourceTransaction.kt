package ac.id.del.moneytracker.ui.transactions

object DatasourceTransaction {
    fun load(): ArrayList<TransactionItem> {
        var currentData = ArrayList<TransactionItem>()
        currentData.clear()
        currentData.add(TransactionItem("12", "Monday", "April 2022", "Rp 50.000"))
        currentData.add(TransactionItem("13", "Tuesday", "April 2022", "Rp 10.000"))
        currentData.add(TransactionItem("14", "Wednesday", "April 2022", "Rp 30.000"))
        currentData.add(TransactionItem("15", "Thursday", "April 2022", "Rp 110.000"))
        currentData.add(TransactionItem("16", "Friday", "April 2022", "Rp 10.000"))

        return if (!currentData.isNullOrEmpty()) {
            currentData
        }else {
            arrayListOf()
        }
    }
}