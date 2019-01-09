package probability

sealed trait Face
case object H extends Face
case object T extends Face


object Coin extends Dist(Map(H->.5,T->.5))

