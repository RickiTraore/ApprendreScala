import Personne._
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Calendar
import java.text.SimpleDateFormat
import scala.collection.immutable._


object HelloWorld {

  def personne(nom : String, prenoms : String, date2naissance :  String, nationnalite : String, salaire : Double) : Personne = {
    try {
      val naissance = new SimpleDateFormat("dd/MM/yyyy").parse(date2naissance)
      // Calendrier pour la naissance.
      val calendrierNaissance = Calendar.getInstance()
      calendrierNaissance.setTimeInMillis(naissance.getTime)
      // Calendrier pour le jour courant.
      val maintenant = new Date()
      val calendrierMaintenant = Calendar.getInstance()
      calendrierMaintenant.setTimeInMillis(maintenant.getTime)
      // Calcul du nombre d’années.
      val annees = calendrierMaintenant.get(Calendar.YEAR) - calendrierNaissance.get(Calendar.YEAR)
      val p = new  Personne(nom,prenoms, annees, nationnalite , salaire)
      return p
    } catch {
       case e : ParseException => println("entrer la bonne date")
        return Personne("","",0,"",0)
    }
  }


  def main(args: Array[String]): Unit = {

    val maliste = List("COTE D'IVOIRE", "MALI", "CAMEROUN", "NIGERIA")
    maliste.foreach(l => println(l.toLowerCase))
    val prenoms  = Seq("RIKI","CRISTOPHE","SIRIBANA","JEAN","MOHAMED","ASSANE","NAMORY")
    val nombreCaratersPrenoms : Seq[Int]  =  prenoms.map(s => (s.length))
     nombreCaratersPrenoms.foreach(l =>println(l))
    val LongPrenoms = prenoms.filter(l =>(l.length>4)).foreach(l =>println(l))
   val monMap : Map[String,String] = Map(
      "ab" -> "Abobo",
      "cc" -> "Cocody",
      "ad" -> "Adjame"
    )
    val monListeMap = monMap.toList
    monMap.keys.foreach(k => println(k))
    println(monMap("ab"))

    val monTableau : Array[String] = Array("RIKI","CRISTOPHE","SIRIBANA","JEAN","MOHAMED","ASSANE","NAMORY")
    monTableau.foreach(l =>println(l))
  }
}
