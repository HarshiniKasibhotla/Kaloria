function getVerifiedContent(){
    $.ajax({
        url: '/verifiedDoc',
        datatype: 'html',
        success: function(data)
        {
            $('#verifiedContent').html(data);
        }
    });
}

function getWaitingContent(){
    $.ajax({
        url: '/waitingDoc',
        datatype: 'html',
        success: function(data)
        {
            $('#waitingContent').html(data);
        }
    });
}


function getDietItems(){
    $.ajax({
        url: '/viewDietItems',
        datatype: 'html',
        success: function(data)
        {
            $('#dietItemsContent').html(data);
        }
    });
}

 $(document).ready(function(){
    getDietItems();
});