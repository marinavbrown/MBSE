package probability

object Dist {

  implicit def dist2Iterable[A](ds: Dist[A]): Iterable[A] = ds.dist.keySet

  def random[A](support : Set[A]) : Dist[A] = this.fromPairs(
    support.map( a => (a,Math.random()) ).toSeq:_*
  )

  def fromPairs[A](pairs: (A,Double)*): Dist[A] = {

    val total : Double = pairs.map(pair => Math.abs(pair._2)).sum

    // First turn the sequence into a Map, collecting like values
    val dist : Map[A,Double] = pairs.foldLeft (
      // Initial value
      Map.empty[A,Double].withDefaultValue(0.0)
    ) {
      // accumulation function
      case (map,(a,p)) => map + (a -> (p + map(a)))
    }
    new Dist(dist)
  }

  def apply[A](as : A*) : Dist[A] = {
    val dist:Map[A,Double] = as.foldLeft(
      // Initial value
      Map.empty[A,Double].withDefaultValue(0.0)
    ){
      (map,a) => map + (a -> (map(a) + (1.0/as.length)))
    }
    new Dist(dist)
  }

  sealed trait Face
  case object H extends Face
  case object T extends Face

  val coin : Dist[Face] = Dist(H,T)

  sealed trait



}






class Dist[A](private val inputVector : Map[A,Double]) {
  private val sum: Double = {
    inputVector
      .map { case (a, x) => Math.abs(x) }
      .sum
  }

  val dist : Map[A,Double] = {
    inputVector
      .filter { case (a,x) => x != 0 }
      .map{ case (a,x) => (a, Math.abs(x)/sum) }
  }

  val support : Set[A] = dist.keySet

  override def toString() : String = "Dist(" + dist.map(kv => s"${kv._1}:${(kv._2 * 100).toInt}%").mkString(",") + ")"

  def sample() : Option[A] = if (dist.isEmpty) None else {
    val rand : Double = Math.random()

    var sum : Double = 0.0
    for ( kv <- dist ) {
      sum += kv._2
      if (sum >= rand) {
        return Some(kv._1)
      }
    }
    // This should never happen
    return None
  }

  def foreach(f : A => Unit) : Unit = {
    val opt = this.sample
    opt match {
      case Some(a) => f(a)
      case _ =>
    }
  }

  def map[B](f : A => B) : Dist[B] = {
    val newPairs = this.dist.toSeq.map{ case (a,p) => (f(a),p) }
    Dist.fromPairs(newPairs:_*)
  }

  def flatMap[B](f : A => Dist[B]) : Dist[B] = {
    val newPairs:Seq[(B,Double)] = for {
      (a,p) <- dist.toSeq
      (b,q) <- f(a).dist.toSeq
    } yield (b,p*q)
    Dist.fromPairs(newPairs:_*)
  }

  def withFilter(p : A => Boolean) : Dist[A] = {
    val subDist : Map[A,Double] = dist.filterKeys(p)
    new Dist(subDist)
  }

}

