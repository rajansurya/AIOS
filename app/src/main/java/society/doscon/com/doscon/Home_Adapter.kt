package society.doscon.com.doscon


import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.android.volley.Response
import com.android.volley.toolbox.ImageRequest
import com.android.volley.toolbox.Volley


/**
 * Created by stpl on 20-3-2017.
 */
internal class Home_Adapter(var mContext: Context, var service: ArrayList<String>, var width: Int, var height: Int, var whichsec: String) : RecyclerView.Adapter<Home_Adapter.ViewHolder>() {
    //, var adapter: AdapterClick
    init {
        println("service "+service.size)
    }

    override fun getItemCount(): Int {
        print("sinz "+service.size)
        return service.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        val params = LinearLayout.LayoutParams(width / 2 -3, width / 2 + 100)
        holder?.grid_item?.setLayoutParams(params);
        if (whichsec.equals("commity")) {
            holder?.home_txt?.setText(colorlist[position].split("#")[0])
//            holder?.designation?.setText(colorlist[position].split("#")[1])
        }else{
            holder?.home_txt?.setText(colorlist[position])
        }




        val params1 = LinearLayout.LayoutParams(width / 2 - 3, width / 2)
        holder?.home_icon?.setLayoutParams(params1);
        val requestQueue = Volley.newRequestQueue(mContext)
        val request = ImageRequest(service.get(position),
                Response.Listener { bitmap -> holder?.home_icon?.setImageBitmap(bitmap) }, 0, 0, null,
                Response.ErrorListener { holder?.home_icon?.setImageResource(R.mipmap.ic_launcher_foreground) })
        requestQueue.add(request)
        println("POS  "+position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(mContext).inflate(R.layout.home_adapter_view, parent, false)
        return ViewHolder(itemView)
    }

    var colorlist = ArrayList<String>()

    interface AdapterClick {
        fun clickAdapter(positionL: Int)
    }

    init {
        var ta: Array<String>? = null
        if (whichsec.equals("commity")) {
//            ta = mContext.getResources().getStringArray(R.array.nameimg);
        } else if (whichsec.equals("member")) {
//            ta = mContext.getResources().getStringArray(R.array.namemember);
        } else if (whichsec.equals("representative")) {
//            ta = mContext.getResources().getStringArray(R.array.representative);
        } else if (whichsec.equals("exmember")) {
//            ta = mContext.getResources().getStringArray(R.array.exmember);
        }
        colorlist.addAll(ta!!.toCollection(ArrayList()))
    }





    fun updateView(service: ArrayList<String>) {
        this.service.clear()
        this.service.addAll(service)
        notifyDataSetChanged()
    }


    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var grid_item: CardView? = null
        var home_txt: TextView? = null
        var home_icon: ImageView? = null
        var designation: TextView? = null


        init {
            grid_item = view.findViewById(R.id.grid_item)
            home_txt = view.findViewById(R.id.home_txt)
            home_icon = view.findViewById(R.id.home_icon)
            designation = view.findViewById(R.id.designation)
        }
    }
}
