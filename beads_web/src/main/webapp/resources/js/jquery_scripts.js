function addToBasket(button) {
    var id = button.attr('id');
    var quantity = $("#quantity").val();
    console.log("send /addItemToOrder with id=" + quantity);

    $.ajax({
        url: "/addItemToOrder",
        type: "PUT",
        contentType: "application/json; charset=utf-8",
        data: '{"productId":' + id + ',"quantity":' + quantity +'}',
        success: function () {
            console.log("Success add to basket");
            button.attr('disabled', 'true');
        },
        error: function () {
            console.log("Error add to basket");
        }
    });
}

function removeEmailError() {
    $("#email_error").hide();
}

function checkEmail() {
    var email = $("#email_field").val();
    var filter = /^[\w\-\.\+]+\@[a-zA-Z0-9\.\-]+\.[a-zA-z0-9]{2,4}$/;

    if (filter.test(email)) {
        removeEmailError();
        $("#Order_button").removeAttr('disabled')
    } else {
        $("#email_error").show();
        $("#Order_button").attr('disabled','disabled')
    }
}

function deleteProduct(button) {
    console.log("Delete productId=" + button.attr('productId'));
    var productId = button.attr('productId');
    $.ajax({
        url: "/deleteItemFromBasket",
        type: "PUT",
        contentType: "application/json; charset=utf-8",
        data: '{"productId":' + productId + '}',
        success: function () {
            console.log("successfully deleted product");
            location.reload(true);
        },
        error: function () {
            console.log("Failed to remove product from basket");
        }
    });
}

function showSubmitOrderForm() {
    $("#submitOrder").show();
    $("#makeOrder").prop("disabled", "true");
}

function makeOrder(button) {
    $.ajax({
        url: "/submitOrder",
        type: "PUT",
        contentType: "application/json; charset=utf-8",
        data: ' ',
        success: function () {
            console.log("successfully created order");
        },
        error: function () {
            console.log("Error add to basket");
        }
    });
}
