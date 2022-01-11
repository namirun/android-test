@ignore
Feature: Individual api for user scenario, for granularity

  Background:
    * url baseUrl

  @decrypt_otp
  Scenario: Decrypt OTP
    * def admin_auth = "JWT eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjAwMDksImlhdCI6MTY0MDc0ODgxN30.XXoN_NcUO6KtWC4COIb6BMFdCu0K3QftrMbY5TUE4iM"
    * def basic_auth = "Basic dzY6c3VwZXJoZXJvZXM="
    * def decryptOtpPayload = read('classpath:api/graphql/decrypt_otp.graphql')
    * replace decryptOtpPayload
    | token     | value     |
    | dial_code | dial_code |
    | phone     | phone     |

    Given path 'graphql'
    * headers { x-authorization: '#(admin_auth)', Authorization: '#(basic_auth)' }
    When request { query: '#(decryptOtpPayload)' }
    And method post
    Then status 200