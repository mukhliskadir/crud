
function signAlert(msg, myYes) {
			
            var confirmBox = $("#signform");
            confirmBox.find(".mssg").text(msg);
            confirmBox.find(".signIn").unbind().click(function() {
            
               confirmBox.hide();
            });
            confirmBox.find(".cancel").unbind().click(function() {
               confirmBox.hide();
            });
            confirmBox.find(".signIn").click(myYes);
            confirmBox.show();}