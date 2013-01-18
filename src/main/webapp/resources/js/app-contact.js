/*!
 * @author  jvergara <jaycverg@gocatapult.com>
 * @description
 *      depends jquery javascript library
 */

//init script
$(function(){ init(); });

function init()
{
    $('a[data-action]')
    .click(function(){
        eval( $(this).data('action') );
        return false;
    });
}

function showAddContact()
{
    $('#contact-info')
    .find('.alert-error').empty().hide().end()
    .find('form').trigger('reset').end()
    .find('.loading-overlay').hide().end()
    .modal('show');
}

function editContact(id)
{
    showAddContact();
    showInfoOverlay();
    var info = $('#contact-info');
    $.ajax({
        url: getAppURL() + "/" + id,
        type: 'GET',
        dataType: 'json',
        success: function(resp) {
            if (resp.error) {
                alert(resp.message);
                return;
            }
            var form = info.find('form')[0];
            $(form.elements).each(function(idx,elm){
                elm.value = resp.result[elm.name] || '';
            });
            hideInfoOverlay();
        },
        error: function(resp) {
            alert(resp);
        }
    });
}

function submitForm()
{
    showInfoOverlay();
    var form = $('#contact-form');
    $.ajax({
        url: form.attr('action'),
        type: form.attr('method'),
        data: form.serialize(),
        dataType: 'json',
        success: function(resp) {
            if (resp.error) {
                form.find('.alert-error')
                .hide()
                .html(resp.message)
                .fadeIn();
            }
            else {
                form.parents('.modal').modal('hide');
                reloadList();
            }
            hideInfoOverlay();
        },
        error: function(resp) {
            alert(resp);
            hideInfoOverlay();
        }
    });
}

function hideInfoOverlay() {
    $('#contact-info .loading-overlay').fadeOut();
}

function showInfoOverlay() {
    $('#contact-info .loading-overlay').fadeIn(10);
}

function reloadList()
{
    var url = getAppURL() + '/list';
    $.get(url, function(html){
        $('#contact-list').html(html);
        init('#contact-list');
    });
}

function getAppURL()
{
    return location.pathname.replace(/\/?$/, '');
}