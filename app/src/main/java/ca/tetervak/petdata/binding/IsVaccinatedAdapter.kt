package ca.tetervak.petdata.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import ca.tetervak.petdata.R

@BindingAdapter("isVaccinated")
fun bindIsVaccinated(textView: TextView, isVaccinated: Boolean?){
    if(isVaccinated is Boolean){
        val resources = textView.resources
        textView.text =
            if(isVaccinated)
                resources.getString(R.string.yes)
            else
                resources.getString(R.string.no)
    }


}