package ac.id.del.moneytracker.ui.transactions

interface TransactionFragmentContract {
    fun dataCollection()
    fun checkCollection():Int
    fun showCollections():ArrayList<TransactionItem>
    fun setUpConfigRecycleViewTransaction()
}