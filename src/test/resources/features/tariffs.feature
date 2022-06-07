#author Chris

  @stories
  Feature: Download tariffs from the banistmo page
    as a user, i want to download tariffs in the banistmo page

    @scenario1
    Scenario: Download the Deposit Account Rates
      Given Chris entered in the banistmo page
      When he download the Deposit Account Rates
      Then he should read the Deposit Account Rates corectly