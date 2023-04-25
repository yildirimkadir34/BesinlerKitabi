package com.kadir.besinlerkitabi

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Besin(
     @ColumnInfo("isim")
     @SerializedName("isim")
     val besinisim: String?,
     @ColumnInfo("isim")
     @SerializedName("kalori")
     val besinkalori: String?,
     @ColumnInfo("isim")
     @SerializedName("karbonhidrat")
     val besinkarb: String?,
     @ColumnInfo("isim")
     @SerializedName("protein")
     val besinprotein: String?,
     @ColumnInfo("isim")
     @SerializedName("yag")
     val besinyag : String ?,
     @ColumnInfo("isim")
     @SerializedName("gorsel")
     val besinGorsel: String?,

     ) {
     @PrimaryKey(autoGenerate = true)
     var uuid : Int =0

}