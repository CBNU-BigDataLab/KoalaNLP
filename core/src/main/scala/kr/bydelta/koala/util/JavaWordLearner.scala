package kr.bydelta.koala.util

import kr.bydelta.koala.traits.{CanTag, CanUserDict}

import scala.collection.JavaConverters._

/**
  * 품사분석기가 분석하지 못한 신조어, 전문용어 등을 확인하여 추가하는 작업을 돕는 Class.
  *
  * @param tagger  품사분석의 기준이 되는 Tagger
  * @param targets 신조어 등을 등록할 사용자사전들.
  */
class JavaWordLearner(override protected val tagger: CanTag[_], override protected val targets: CanUserDict*)
  extends BasicWordLearner[java.util.Iterator[String]] {
  override def extractNouns(corpora: java.util.Iterator[String],
                            minOccurrence: Int = 100, minVariations: Int = 3): collection.Set[String] =
    extract(corpora.asScala, minOccurrence, minVariations)
}