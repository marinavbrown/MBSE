package probability


case class NodeData(val name : String,val states : Set[Any])

case class EdgeData(val name : String)

class BayesNet[N <: NodeData,E <: EdgeData](val edges : Map[E,(N,N)]) {
  val (sources,targets) : (Set[N],Set[N]) = edges.values.toSet.unzip
  val nodes : Set[N] = sources union targets

  def parents(n : N) : Set[N] = for {
    (e,(src,tgt)) <- edges.toSet
    if (n == tgt)
  } yield src


  class BayesDist


}
