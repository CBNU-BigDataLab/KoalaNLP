package kr.bydelta.koala

/**
  * Created by bydelta on 17. 8. 19.
  */
package object kmr {
  /**
    * 원본품사로 변환.
    *
    * @param tag 원본품사로 변환할 통합표기.
    * @return 변환된 품사.
    */
  def tagToKomoran(tag: _root_.kr.bydelta.koala.POS.Value): String = {
    tag match {
      case POS.NNM => "NNB"
      case POS.XSM | POS.XSO => "XSN"
      case POS.XPV => "XR"
      case POS.SY => "SW"
      case POS.UN | POS.UV | POS.UE => "NA"
      case _ => tag.toString
    }
  }

  /**
    * 통합품사로 변환.
    *
    * @param tag 통합품사로 변환할 원본표기.
    * @return 변환된 통합품사.
    */
  def fromKomoranTag(tag: String): POS.Value = {
    tag.toUpperCase match {
      case "SW" | "SO" => POS.SY
      case "NA" => POS.UE
      case "SL" | "SH" => POS.SL
      case x => POS withName x
    }
  }
}
