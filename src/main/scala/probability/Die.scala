package probability


sealed trait DiceSide
case object DiceOne extends DiceSide
case object DiceTwo extends DiceSide
case object DiceThree extends DiceSide
case object DiceFour extends DiceSide
case object DiceFive extends DiceSide
case object DiceSix extends DiceSide

object Die extends Dist(Map(
  DiceOne -> 1.0/6,
  DiceTwo -> 1.0/6,
  DiceThree -> 1.0/6,
  DiceFour -> 1.0/6,
  DiceFive -> 1.0/6,
  DiceSix -> 1.0/6
))
