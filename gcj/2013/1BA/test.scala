/**
 * Created with IntelliJ IDEA.
 * User: benito
 * Date: 5/4/13
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
object test {

  def calc(inarmin: Long, inmoths: Array[Int]) = {
    val moths = inmoths.sorted;
    var armin = inarmin.toLong;

    var res = 0;
    var i = 0;
    while (i < moths.length && moths(i) < armin) {
      armin += moths(i);
      i+=1;
    }

    if (i < moths.length ) {
      res = moths.length - i;
      for (cutoff <- 0 to moths.length){
        val oldarmin = armin;
        val oldi = i;
        var newres = cutoff;
        while (i < moths.length - cutoff && newres < res) {
          while (moths(i) >= armin && newres < res) {
            armin += armin - 1;
            newres += 1;
          }
          armin += moths(i);
          i+=1;
        }
        if (newres < res) res = newres;
        i = oldi;
        armin = oldarmin;
        println(s"$armin $res $i")
      }
    }
    res
  }
}

var it = io.Source.fromFile("A-large.in").getLines.filter(_ != "")
val T = it.next.toInt;
for (t <- 1 to T) {
  val r = it.next.split(" ");
  val A = (r(0)).toInt; val N = (r(1)).toLong;

  println("Case #"+t+": "+ test.calc(A, it.next.split(" ") map (_.toInt) toArray))
}
