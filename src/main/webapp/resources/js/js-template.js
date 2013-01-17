/*! 
 * Simple JavaScript Templating
 * John Resig - http://ejohn.org/ - MIT Licensed
 * 
 * modified by: jaycverg <jaycverg@gmail.com>
 */

(function()
{
    var cache = {};
  
    this.JSTemplate = {
        load: function(target, id, data)
        {
            var html = this.parse(id, data || {});
            var telem = document.getElementById(target);
            if(telem) telem.innerHTML = html || '';
        },
		
        parse: function(id, data) 
        {
            return this.__doParse(document.getElementById(id).innerHTML, data)
        },
		
        __doParse: function(str, data) 
        {
            // Figure out if we're getting a template, or if we need to
            // parse the template - and be sure to cache the result.
            var fn = !/\W/.test(str) ?
            cache[str] = cache[str] ||
            this.__doParse(str, data)(document.getElementById(str).innerHTML) :
      
            // Generate a reusable function that will serve as a template
            // generator (and which will be cached).
            new Function("obj",
                "var p=[],print=function(){p.push.apply(p,arguments);};" +
        
                // Introduce the data as local variables using with(){}
                "with(obj){p.push('" +
        
                // Convert the template into pure JavaScript
                str
                .replace(/[\r\t\n]/g, " ")
                .split("<%").join("\t")
                .replace(/((^|%>)[^\t]*)'/g, "$1\r")
                .replace(/\t=(.*?)%>/g, "',$1,'")
                .split("\t").join("');")
                .split("%>").join("p.push('")
                .split("\r").join("\\'")
                + "');}return p.join('');"
                );
    
            // Provide some basic currying to the user
            return data ? fn( data ) : fn;
        }
    };
})();