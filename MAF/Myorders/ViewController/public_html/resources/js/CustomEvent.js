(function () {
setInputText=function (){
       // alert("setting the text");
        var args = arguments;
        var str = ""+ args[0];
       // alert("value of Loc is "+str);
        $('#it1__inputElement').val(str);
};
    showPopup = function () {
               var args = arguments;
        var str = ""+ args[0];
        var element = document.getElementById(str);
        customTriggerEvent(element, "touchstart");
        customTriggerEvent(element, "touchend");
    }

    var customTriggerEvent = function (eventTarget, eventType, triggerExtra) {
        var evt = document.createEvent("HTMLEvents");
        evt.initEvent(eventType, true, true);
        evt.view = window;
        evt.altKey = false;
        evt.ctrlKey = false;
        evt.shiftKey = false;
        evt.metaKey = false;
        evt.keyCode = 0;
        evt.charCode = 'a';
        if (triggerExtra != null)
            evt.triggerExtra = triggerExtra;
        eventTarget.dispatchEvent(evt);
    };

})();