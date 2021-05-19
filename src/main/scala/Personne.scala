case class Personne(nom : String, prenoms : String, age : Int, nationnalite : String, salaire : Double){
  def affiche(): Unit ={
    println("nom : ", this.nom," prenoms : ",this.prenoms)
  }
  def calculSome(a : Int, b : Int ) : Int = {
    return  a+b
  }
}
