package ca.tetervak.petdata.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import ca.tetervak.petdata.R
import ca.tetervak.petdata.domain.Gender

@BindingAdapter("gender")
fun bindGender(textView: TextView, gender: Gender?){
    if(gender is Gender){
        val genders = textView.resources.getStringArray(R.array.genders)
        textView.text = genders[gender.ordinal]
    }

}