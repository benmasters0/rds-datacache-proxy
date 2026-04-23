/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.rdsdatacacheproxy.gambling

import uk.gov.hmrc.rdsdatacacheproxy.gambling.models.{BusinessDetails, ReturnSummary}

import java.time.LocalDate

object GamblingStubData {
  def getReturnSummary(mgdRegNumber: String): ReturnSummary =
    mgdRegNumber match {
      case "XYZ00000000000" =>
        ReturnSummary(mgdRegNumber, returnsDue = 0, returnsOverdue = 0)
      case "XYZ00000000001" =>
        ReturnSummary(mgdRegNumber, returnsDue = 0, returnsOverdue = 1)
      case "XYZ00000000010" =>
        ReturnSummary(mgdRegNumber, returnsDue = 1, returnsOverdue = 0)
      case "XYZ00000000012" =>
        ReturnSummary(mgdRegNumber, returnsDue = 1, returnsOverdue = 2)
      case "XYZ00000000021" =>
        ReturnSummary(mgdRegNumber, returnsDue = 2, returnsOverdue = 1)
      case "ERR00000000000" =>
        throw new RuntimeException("Simulated downstream failure")
      case _ =>
        ReturnSummary(mgdRegNumber, returnsDue = 3, returnsOverdue = 4)
    }

  def getBusinessDetails(mgdRegNumber: String): BusinessDetails =
      mgdRegNumber match {
        case "XYZ00000000000" =>
          BusinessDetails(
            mgdRegNumber = mgdRegNumber,
            businessType = 6,
            currentlyRegistered = 2,
            groupReg = "foo",
            dateOfRegistration = Some(LocalDate.of(2024, 4, 21)), businessPartnerNumber = "bar", systemDate = Some(LocalDate.of(2024, 4, 21))
          )
        case "XYZ00000000001" =>
          BusinessDetails(
            mgdRegNumber = mgdRegNumber,
            businessType = 1,
            currentlyRegistered = 1,
            groupReg = "foofoo",
            dateOfRegistration = Some(LocalDate.of(2024, 4, 21)), businessPartnerNumber = "bar", systemDate = Some(LocalDate.of(2024, 4, 21))
          )
        case "XYZ00000000010" =>
          BusinessDetails(
            mgdRegNumber = mgdRegNumber,
            businessType = 3,
            currentlyRegistered = 2,
            groupReg = "foo",
            dateOfRegistration = Some(LocalDate.of(2024, 4, 21)), businessPartnerNumber = "bar", systemDate = Some(LocalDate.of(2024, 4, 21))
          )
        case "XYZ00000000012" =>
          BusinessDetails(
            mgdRegNumber = mgdRegNumber,
            businessType = 1,
            currentlyRegistered = 2,
            groupReg = "foobar",
            dateOfRegistration = Some(LocalDate.of(2023, 4, 21)), businessPartnerNumber = "barfoo", systemDate = Some(LocalDate.of(2023, 4, 21))
          )
        case "XYZ00000000021" =>
          BusinessDetails(
            mgdRegNumber = mgdRegNumber,
            businessType = 5,
            currentlyRegistered = 2,
            groupReg = "foofoo",
            dateOfRegistration = Some(LocalDate.of(2024, 1, 21)), businessPartnerNumber = "barbar", systemDate = Some(LocalDate.of(2024, 1, 21))
          )
        case "ERR00000000000" =>
          throw new RuntimeException("Simulated downstream failure")
        case _ =>
          BusinessDetails(
            mgdRegNumber = mgdRegNumber,
            businessType = 0,
            currentlyRegistered = 0,
            groupReg = "unknown",
            dateOfRegistration = Some(LocalDate.of(2026, 4, 22)), businessPartnerNumber = "unknown", systemDate = Some(LocalDate.of(2026, 4, 22))
          )
      }
}
