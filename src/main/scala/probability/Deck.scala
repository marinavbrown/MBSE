package probability

sealed trait Rank extends Ordered[Rank] {

  def compare(that : Rank) : Int = this.value.compare(that.value)

  val value : Int = this match {
    case Ace => 1
    case Two => 2
    case Three => 3
    case Four => 4
    case Five => 5
    case Six => 6
    case Seven => 7
    case Eight => 8
    case Nine => 9
    case Ten => 10
    case Jack => 11
    case Queen => 12
    case King => 13
  }
}
case object Ace extends Rank
case object Two extends Rank
case object Three extends Rank
case object Four extends Rank
case object Five extends Rank
case object Six extends Rank
case object Seven extends Rank
case object Eight extends Rank
case object Nine extends Rank
case object Ten extends Rank
case object Jack extends Rank
case object Queen extends Rank
case object King extends Rank



sealed trait Suit extends Ordered[Suit] {
  val color : SuitColor = this match {
    case Hearts | Diamonds => Red
    case Spades | Clubs => Black
  }

  def compare(that : Suit) : Int = (this,that) match {
    case (x,y) if x == y => 0
    case (Hearts, _) => 1
    case (Spades,_) => 1
    case (Diamonds,_) => 1
//    case _ => 0 // This should never happen
  }
}
case object Hearts extends Suit
case object Spades extends Suit
case object Diamonds extends Suit
case object Clubs extends Suit

sealed case class Card(rank : Rank, suit : Suit) {
  val color : SuitColor = suit.color
  val value : Int = rank.value

  override def toString() : String = s"$rank of $suit"

  def beats(that : Card) : Boolean = {
    require(this != that)

    if (this.rank > that.rank) true
    else if (this.rank == that.rank & this.suit > that.suit) true
    else false
  }
}

object Deck extends Dist(
  (for {
    s <- Set(Hearts, Spades, Diamonds, Clubs)
    r <- Set(Ace, Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King)
  } yield (Card(r,s) -> 1.0/52)).toMap
)

sealed trait SuitColor
case object Red extends SuitColor
case object Black extends SuitColor


