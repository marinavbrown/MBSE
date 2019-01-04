

def wonky(s : String) : String = {
  val charList : List[Char] = s.toList
  val charIndexList : List[(Char,Int)] = charList.zipWithIndex
  val wonkyList : List[Char] = charIndexList.map({
    case (char,index) =>
      if (index % 2 == 0) char.toUpper
      else char.toLower
  })
  val wonkyString = wonkyList.mkString
  return wonkyString
}


def wonky2(s : String) = s.zipWithIndex.map{
  case (char,index) =>
    if (index % 2 == 0) char.toUpper
    else char.toLower
}.mkString

