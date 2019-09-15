package society.doscon.com.doscon

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Rajan Gupta on 27-08-2018.
 */
class GenerateTicketAdapterHome(var context: Context, retailerList: ArrayList<NotificationData>) : RecyclerView.Adapter<GenerateTicketAdapterHome.MyViewHolder>() {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        var myretailer: NotificationData = retailerList.get(position)
        holder?.notification?.text = myretailer.Notification
        holder?.date?.text = myretailer.Date
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val viewholder = LayoutInflater.from(context).inflate(R.layout.notification_view_home, parent, false)

        return MyViewHolder(viewholder)
    }

    private var retailerList: ArrayList<NotificationData>

    init {
        this.retailerList = ArrayList<NotificationData>()
        this.retailerList.addAll(retailerList)
    }

    internal fun updateView(retailerListupdate: ArrayList<NotificationData>) {
        this.retailerList.clear()
        this.retailerList.addAll(retailerListupdate)
        notifyDataSetChanged()
    }

    /* override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
         val viewholder = LayoutInflater.from(context).inflate(R.layout.notification_view, parent, false)

         return MyViewHolder(viewholder)
     }*/


    /* override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
 //        var myretailer: TicketDetails = retailerList.get(position)
 //        holder?.ticket_code?.text = myretailer.ticketid
 //        holder?.retailer_issue?.text = myretailer.ticketTypeName
 //        holder?.retailer_issue_subtype?.text = myretailer.ticketSubTypeName
 //        holder?.party_name?.text = myretailer.partyCode
 //        holder?.ticket_subtype?.text = myretailer.mobile
 //        holder?.action_priority?.text = myretailer.priority
 //        holder?.ticket_status?.text = myretailer.status
 //        try {
 //            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
 //            val convertedCurrentDate = sdf.parse(myretailer.creationDate)
 //            val dateloc = SimpleDateFormat("HH:mm, dd MMM")
 //            val date = dateloc.format(convertedCurrentDate)
 //            holder?.time_diffr?.setText(date)
 //        } catch (e: Exception) {
 //            e.printStackTrace()
 //        }



     }*/

    override fun getItemCount(): Int {
        return  retailerList.size
    }


    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        //        val ticket_code: TextView
//        //        val retailer_issue: TextView
//        val retailer_issue: TextView
        val date: TextView
        val notification: TextView
//        val action_priority: TextView
//        val retailer_issue_subtype: TextView
//        val ticket_status: TextView
//        val time_diffr: TextView

        init {
            notification = view.findViewById<View>(R.id.notification) as TextView
            date = view.findViewById<View>(R.id.date) as TextView
//            ticket_code = view.findViewById<View>(R.id.ticket_code) as TextView
//            retailer_issue = view.findViewById<View>(R.id.retailer_issue) as TextView
//            retailer_issue_subtype = view.findViewById<View>(R.id.retailer_issue_subtype) as TextView
//            action_priority = view.findViewById<View>(R.id.action_priority) as TextView
//            ticket_status = view.findViewById<View>(R.id.ticket_status) as TextView
//            time_diffr = view.findViewById<View>(R.id.time_diffr) as TextView
        }
    }

}