/*!
 * @author		Jayrome Vergara <jaycverg@gmail.com>
 */

function RemoteService(servicename)
{
    this.post = function(data, handler)
    {
        this.post(null, data, handler);
    };
	
    this.post = function(method, data, handler)
    {
        var url = servicename || '';
        if( method ) url = url + '/' + method;
		
        $.post(url, data, handler, 'json');
    };
	
    this.get = function(data, handler)
    {
        this.get(null, data, handler);
    };
	
    this.get = function(method, data, handler)
    {
        var url = servicename || '';
        if( method ) url = url + '/' + method;
		
        $.get(url, data, handler, 'json');
    };
}