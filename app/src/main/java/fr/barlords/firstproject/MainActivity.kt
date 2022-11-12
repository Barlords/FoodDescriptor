package fr.barlords.firstproject

import android.graphics.Typeface
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.StyleSpan
import android.text.style.TypefaceSpan
import android.util.Log
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.product_view)

        supportActionBar?.setBackgroundDrawable(ContextCompat.getDrawable(this, R.drawable.tool_bar))
        Toast.makeText(this, R.string.welcome_message, Toast.LENGTH_LONG).show()
        Log.v("MyActivity", "I'm a log")

        var product: Product = generateFakeProduct()

        var textView = findViewById<TextView>(R.id.product_name)
        var spannable = SpannableString(product.name)
        spannable.setSpan(StyleSpan(Typeface.BOLD), 0, product.name.length, 0)
        textView.text = spannable

        textView = findViewById<TextView>(R.id.product_brand)
        spannable = SpannableString(product.brand)
        spannable.setSpan(StyleSpan(Typeface.ITALIC), 0, product.brand.length, 0)
        textView.text = spannable

        findViewById<TextView>(R.id.product_barcode).applyBoldText(getString(R.string.product_barcode, product.barcode))

        findViewById<TextView>(R.id.product_quantity).applyBoldText(getString(R.string.product_quantity, product.quantity))

        findViewById<TextView>(R.id.product_country).applyBoldText(getString(R.string.product_country, product.countries.toString()))

        findViewById<TextView>(R.id.product_ingredient).applyBoldText(getString(R.string.product_ingredient, product.ingredients.toString()))

        findViewById<TextView>(R.id.product_alergen).applyBoldText(getString(R.string.product_alergen, product.allergens.toString()))

        findViewById<TextView>(R.id.product_additive).applyBoldText(getString(R.string.product_additive, product.additives.toString()))

        var image = findViewById<ImageView>(R.id.product_thumbnail)

        Glide.with(this).load(product.thumbnail).into(image)

        //textView = findViewById<TextView>(R.id.product_country)
        //txt = getString(R.string.product_country, "France, Japon, Suisse")
        //spannable = SpannableString(txt)
        //textView.text = spannable
//
        //textView = findViewById<TextView>(R.id.product_ingredient)
        //txt = getString(R.string.product_ingredient, "Petit pois 66%, eau, garniture 2,8% (salade, oignon grelot), sucre, sel, arôme naturel")
        //spannable = SpannableString(txt)
        //textView.text = spannable
//
        //textView = findViewById<TextView>(R.id.product_alergen)
        //txt = getString(R.string.product_alergen, "Aucune")
        //spannable = SpannableString(txt)
        //textView.text = spannable
//
        //textView = findViewById<TextView>(R.id.product_additive)
        //txt = getString(R.string.product_additive, "Aucun")
        //spannable = SpannableString(txt)
        //textView.text = spannable

    }



}

fun TextView.applyBoldText(text: String) {
    val spannable = SpannableString(text)
    spannable.setSpan(StyleSpan(Typeface.BOLD), 0, text.indexOf(':') + 1, 0)
    this.text = spannable
}

fun TextView.applyText(text: String) {
    val spannable = SpannableString(text)
    this.text = spannable
}