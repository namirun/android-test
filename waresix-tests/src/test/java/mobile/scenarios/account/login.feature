Feature: android test

  Background:
    * call read 'classpath:mobile/pages/login/locator.json'
    * mobileDriver.webDriverSession.desiredCapabilities.avd = 'Pixel_3_API_29'

  Scenario: Login account
    Given driver mobileDriver
    And waitFor(boarding.skip_button)
    And click(boarding.next_button)
    And click(boarding.next_button)
    And click(boarding.start_button)
    And click(login.logo_button)
    And waitFor(debug.select_server)
    And click(debug.select_server)
    And click(debug.select_sit)
    And click(debug.save_button)
    And waitFor(login.phone_input)
    And input(login.phone_input, '81310001197')
    And click(login.login_button)
    And waitFor(login.message_verify)
    And click(login.message_verify)
    And click(login.verify_button)
    And waitFor(otp.otp_input)
    * def args = { dial_code: '+62', phone: '81310001197' }
    * def decryptOTP = call read('classpath:api/api.feature@decrypt_otp') args
    * def otpCode = decryptOTP.response.getOTPByTelp.data
    And input(otp.otp_input, otpCode)
    And click(otp.confirm_button)
    And waitFor(dashboard.profile_tab)
#    And click(dashboard.profile_tab)
#    And waitFor(profile.task_history)
#    And click(profile.task_history)
#    And waitFor(history.do_number)
#    And script("mobile: scroll", { "strategy" : "class name", "selector": "android.widget.TextView"} )
#    And script("mobile: scrollGesture", {"left": 100, "top": 100, "width": 1000, "height": 1000, "direction": "down", "percent": "50.0"} )
#    And scroll(history.do_number)
#    And delay(2000)

#  Scenario: Login account
#    Given driver mobileDriver
#    And waitFor(boarding.skip_button)
#    And click(boarding.next_button)
#    And click(boarding.next_button)
#    And click(boarding.start_button)

