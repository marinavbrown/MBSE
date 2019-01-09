package probability

object Dist {

  implicit def dist2Iterable[A](ds: Dist[A]): Iterable[A] = ds.dist.keySet

  def random[A](support : Set[A]) : Dist[A] = this.fromPairs(
    support.map( a => (a,Math.random()) ).toSeq
  )

  def uniform[A](support : Set[A]) : Dist[A] = this.fromPairs(
    support.toSeq.map(a => (a,(1.0/support.size)))
  )

  def fromPairs[A](pairs: Seq[(A,Double)]): Dist[A] = {
    require(pairs.nonEmpty)

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
    require(as.nonEmpty)

    val dist:Map[A,Double] = as.foldLeft(
      // Initial value
      Map.empty[A,Double].withDefaultValue(0.0)
    ){
      (map,a) => map + (a -> (map(a) + (1.0/as.length)))
    }
    new Dist(dist)
  }





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

  require(sum != 0)

  val support : Set[A] = dist.keySet

  override def toString() : String = "Dist(" + dist.map(kv => s"${kv._1}:${(kv._2 * 100).toInt}%").mkString(",") + ")"


  class PartialDistributionException extends Exception
  class EmptyDistributionException extends Exception

  @throws(classOf[Exception])
  def sample() : A = {
    val rand : Double = Math.random()
    dist.foldLeft(0.0){
      case (sum,(a,p)) => if (sum + p > rand) return a else sum + p
    }
    throw new PartialDistributionException

  }

  def sample(n : Int) : Seq[A] = (1 to n).map(i => sample()).toSeq

  def foreach(f : A => Unit) : Unit = f(this.sample())

  def map[B](f : A => B) : Dist[B] = {
    val newPairs : Seq[(B,Double)] = this.dist.toSeq.map{ case (a,p) => (f(a),p) }
    Dist.fromPairs(newPairs)
  }

  def flatMap[B](f : A => Dist[B]) : Dist[B] = {
    val newPairs : Seq[(B,Double)] = for {
      (a,p) <- dist.toSeq
      (b,q) <- f(a).dist.toSeq
    } yield (b,p*q)
    Dist.fromPairs(newPairs)
  }

  def withFilter(test : A => Boolean) : Dist[A] = {
    val newPairs : Seq[(A,Double)] = for {
      (a,p) <- dist.toSeq
      if test(a)
    } yield (a,p)
    if (newPairs.nonEmpty) Dist.fromPairs(newPairs)
    else throw new EmptyDistributionException
  }

  def prod[B](that : Dist[B]) : Dist[(A,B)] = {
    val prodMap:Map[(A,B),Double] = for {
      (a,p) <- this.dist
      (b,q) <- that.dist
    } yield ((a,b), p*q)

    new Dist(prodMap)
  }

}

