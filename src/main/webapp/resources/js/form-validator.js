$(document).ready(function() {
        $("#userForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
                firstName: "required",
                lastName: "required",
                password: "required",
            },
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter an valid email address"
                },

                firstName: "Please enter firstName",
                lastName: "Please enter lastName",
                password: "Please enter password"
            }
        });
    });
