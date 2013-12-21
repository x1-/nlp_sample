package com.inkenkun.x1

import breeze.linalg._
import breeze.numerics._

/**
 * ScalaNLPをいじってみるφ(・∇・｀〃 )
 * Created by x1 on 2013/12/21.
 */
object App {
  def main( args: Array[String] )  = {

    // #1. 2 x 3行列を作成
    //      1.0 2.0 3.0
    //      4.0 5.0 6.0
    val m23 = DenseMatrix(
      (1.0d, 2.0d, 3.0d),
      (4.0d, 5.0d, 6.0d))
    println( m23 )

    // #2. 3 x 2のゼロ埋め行列を作成
    //      0 0
    //      0 0
    //      0 0
    val m32z = DenseMatrix.zeros[Double](3, 2)
    println( m32z )

    // #3. 2 x 2の1埋め行列を作成
    //      1 1
    //      1 1
    val m22o = DenseMatrix.zeros[Double](2, 2)
    println( m22o )

    // #4. 2 x 3の乱数行列を作成
    //      0.8765... 0.23909... 0.61324...
    //      0.51976... 0.80524... 0.44318...
    val m23r = DenseMatrix.rand(2, 3)
    println( m23r )

    // #5. 行列の全ての要素に0.1足す
    //    1.1  2.1  3.1
    //    4.1  5.1  6.1
    val plusall = m23 + 0.1d
    println( plusall )

    val m23a = DenseMatrix(
      (2d, 2d, 2d),
      (2d, 2d, 2d))

    val m32 = DenseMatrix(
      (2d, 2d)
      ,(2d, 2d)
      ,(2d, 2d))

    // #6. 行列同士の足し算
    //    3.0  4.0  5.0
    //    6.0  7.0  8.0
    // 要素数が異なるとエラーになります。
    val plus = m23 + m23a
    println( plus )

    // #7. 行列の要素ごとの積
    //    2.0  4.0   6.0
    //    8.0  10.0  12.0
    val eprod = m23 :* m23a
    println( eprod )

    // #8. 行列の積
    //    12.0  12.0
    //    30.0  30.0
    val prod = m23 * m32
    println( prod )

    // #9. 行列の全ての要素に5.0かける
    //    5.0   10.0  15.0
    //    20.0  25.0  30.0
    val prodall = m23 * 0.5d
    println( prodall )

    // #10. 行列の割り算
    //    0.5  1.0  1.5
    //    2.0  2.5  3.0
    val div = m23 / m23a
    println( div )

    // #11. 行列の行同士sumする
    //    5.0  7.0  9.0
    // このメソッドは、Double型の行列でないと失敗しました。
    val sumedr = sum( m23, Axis._0 )
    println( sumedr )

    // #12. 行列の列同士sumする
    //    6.0  15.0
    val sumedc = sum( m23, Axis._1 )
    println( sumedc )

    // #13. 行列のすべての要素をsumする
    //    21.0
    val sumed = sum( m23 )
    println( sumed )

    // #14. 行列のそれぞれの要素の平方根を計算する
    //    1.0  1.4142135623730951  1.7320508075688772
    //    2.0  2.23606797749979    2.449489742783178
    val sqrted = sqrt( m23 )
    println( sqrted )

    // #15. 行列のそれぞれの要素の自然対数を計算する
    //    0.0                 0.6931471805599453  1.0986122886681098
    //    1.3862943611198906  1.6094379124341003  1.791759469228055
    val logged = log( m23 )
    println( logged )

    // #16. 行列の転置を行う（行と列を入れ替える）
    //    1.0 2.0 3.0
    //    4.0 5.0 6.0
    //       ↓
    //    1.0 4.0
    //    2.0 5.0
    //    3.0 6.0
    val t = m23.t
    println( t )

    // #17. 単位行列を作成する
    // 1.0  0.0  0.0
    // 0.0  1.0  0.0
    // 0.0  0.0  1.0
    val dg = diag( DenseVector.ones[Double](3) )
    println( dg )
  }
}
