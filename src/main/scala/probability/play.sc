
import probability.Dist

val m = Map(
  1->("a","b"),
  2->("a","c"),
  3->("b","d"),
  4->("c","d"),
  5->("b","e")
)


m.values.map{
  case (x,y) => Set(x,y)
}

val d = Dist.fromPairs(("a",1),("b",2),("c",3))

val dd = Dist(1,2,2,3,3,3)

Dist.random(Set(1,2,3,4))




