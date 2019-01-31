
class Wonkifier {


  def wonkify(s: StringBuilder) {

    var index = 0

    while (index < s.length) {
      var char = s(index)
      s.delete(index,index+1)
      if (index % 2 == 0) {
        s.insert(index,char.toUpper)
      } else {
        s.insert(index,char.toLower)
      }
      index = index + 1
    }

  }


}

