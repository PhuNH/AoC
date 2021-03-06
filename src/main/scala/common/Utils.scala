package common

import scala.language.reflectiveCalls

object Utils {
  def inputPath(year: Int, day: Int) = s"input/$year/$day"

  def testPath(year: Int, day: Int, number: Int) = s"input/$year/test/$day.$number"

  def using[A <: { def close(): Unit }, B](resource: A)(f: A => B): B =
    try {
      f(resource)
    } finally {
      resource.close()
    }

  @scala.annotation.tailrec
  def gcd(a: Long, b: Long): Long = if (b == 0) a.abs else gcd(b, a%b)

  def lcm(a: Long, b: Long): Long = (a*b).abs / gcd(a,b)

  def lcm(array: Array[Long]): Long = array.reduce(lcm)
}
