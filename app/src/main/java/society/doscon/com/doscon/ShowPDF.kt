package society.doscon.com.doscon

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.header_other.*
import kotlinx.android.synthetic.main.show_pdf.*

class ShowPDF : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_pdf)
        title_name.text = "SHUTTLE"
        back.setOnClickListener { this@ShowPDF.finish() }
        pdfv.fromAsset("shuttleservice.pdf").load()
    }
}