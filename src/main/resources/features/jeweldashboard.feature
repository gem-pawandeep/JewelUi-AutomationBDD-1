Feature: jeweldashboard

  Scenario Outline:Launch login and logout jewel dashboard
    Given user clicks on logIn button
    Then enter <Username> and <Password>
    Then user navigates back after loggin in
    Examples:
      | Username     | Password  |
      | arpit.mishra | arpit1234 |

  Scenario Outline:launch jewel and check url of jewel and pricing
    Given validating url of jewel <expectedUrl>
    Then click on pricing
    Then validate pricing url <expectedPurl>
    Examples:
      | expectedUrl                       | expectedPurl                             |
      | https://jewel.gemecosystem.com/#/ | https://jewel.gemecosystem.com/#/pricing |

  Scenario Outline:launch pricing and validate the texts
    Given clicking on pricing and checking for main heading <pricingHead>
    Then checking for subheading <pricingSubHead>
    Then checking for text <Text>
    Examples:
      | pricingHead | pricingSubHead           | Text                                                       |
      | Hold Tight! | This Page is Coming Soon | Our scouts are currently working hard building this page ! |


  Scenario Outline:launch jewel again and validate texts
    Given clicking on jewel again validating main heading <mainHeading>
    Then validating subheading of jewel <subHeading>
    Examples:
      | mainHeading   | subHeading                                                  |
      | Explore Jewel | Effortless Report analysis and Test monitoring at a glance. |


  Scenario Outline:scroll down the screen
    Given validating whatisjewel <whatisjewel>
    Then validating about us <aboutus>
    Then validating content <content>
    Examples:
      | whatisjewel     | aboutus  | content                                                                                                                                                                                                                                                        |
      | What Is Jewel ? | ABOUT US | Jewel is a test management web solution that offers test suite creation using Gempyp and Gemjar, test execution with maximum parallelisation and load balancing along with live and analytical reporting for any framework that is integrated using Rest APIs. |

  Scenario Outline:validate the text in view report box
    Given validating view report <viewreport>
    Then validating view reportC <viewcontent>
    Examples:
      | viewreport                        | viewcontent                                                                                                                               |
      | JEWEL- End to End Test Management | Quickly Scalable and Easily Maintainable.Form-based codeless approach for API Automation & Data Validation.Testcase-Shareable but secure. |

  Scenario Outline:scroll down again and validate the text in run test suite box
    Given validating run test <runtest>
    Then validating run testC  <runcontent>
    Examples:
      | runtest                  | runcontent                                                                                                                                                               |
      | Create & Run Test Suites | One click runMutliple modes and use-casesCI CD CT ReadyAWS Lambda/Azure Functions- Unlimited Parallel ExecutionOpenness to support plugin with other apps scheduler. |

  Scenario Outline:clicking on facebook logo and validating url
    Given click on facebook logo validate url <facebook>
    Examples:
      | facebook                              |
      | https://www.facebook.com/gemecosystem |

  Scenario Outline:clicking on twitter logo and validating url
    Given click on twitter logo and validate url <twitter>
    Examples:
      | twitter                          |
      | https://twitter.com/gemecosystem |

  Scenario Outline:clicking on instagram logo and validating the url
    Given click on instagram logo and validate url <insta>
    Examples:
      | insta                                   |
      | https://www.instagram.com/gemecosystem/ |
#
#  Scenario Outline:clicking on linkedin logo and validating url
#    Given click on linkedin logo and validate url <linked>
#    Examples:
#      | linked                   |
#      | https://www.linkedin.com |
#
#  Scenario:clicking on jewel dashboard logo
#    Given click on jewel dashboard button
#
#  Scenario Outline:clicking on gemPYP
#    Given click on gemPYP and validate url <pyp>
#    Examples:
#      | pyp                              |
#      | https://gempyp.gemecosystem.com/ |
#
#  Scenario Outline:clicking on gemPRF
#    Given click on gemPRF and validate url <prf>
#    Examples:
#      | prf                              |
#      | https://gemprf.gemecosystem.com/ |
#
#  Scenario Outline:clicking on gemJAR
#    Given click on gemJAR and validate url <jar>
#    Examples:
#      | jar                              |
#      | https://gemjar.gemecosystem.com/ |
#
#  Scenario:click on pricing logo
#    Given click on pricing button
#
#
